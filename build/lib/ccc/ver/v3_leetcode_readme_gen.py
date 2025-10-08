#
#      Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
#
#      This program is free software: you can redistribute it and/or modify
#      it under the terms of the GNU Affero General Public License as
#      published by the Free Software Foundation, either version 3 of the
#      License, or (at your option) any later version.
#
#      This program is distributed in the hope that it will be useful,
#      but WITHOUT ANY WARRANTY; without even the implied warranty of
#      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#      GNU Affero General Public License for more details.
#
#      You should have received a copy of the GNU Affero General Public License
#      along with this program.  If not, see <http://www.gnu.org/licenses/>.

#!/usr/bin/env python3
import argparse
import datetime
import datetime as dt
import json
import os
import re
import sys
from datetime import timezone
from pathlib import Path
from typing import Dict, Optional, Any, List, Tuple, Iterable, Set

import requests
from jinja2 import Environment, FileSystemLoader, select_autoescape

LEETCODE_BASE = "https://leetcode.com"
GRAPHQL_URL = f"{LEETCODE_BASE}/graphql"
MAP_ALL_URL = f"{LEETCODE_BASE}/api/problems/all/"
CONTEST_LIST_URL = f"{LEETCODE_BASE}/contest/api/list/"
CONTEST_INFO_URL = f"{LEETCODE_BASE}/contest/api/info/{{slug}}"
CONTEST_PAGE_URL = f"{LEETCODE_BASE}/contest/{{slug}}/"

# Difficulty to color mapping based on your formatting
DIFFICULTY_COLOR = {
	"Easy": "#3BE38C",
	"Medium": "#E39A2D",
	"Hard": "#FF4800",
}

CACHE_DIR = Path(__file__).parent / ".cache"
CACHE_DIR.mkdir(parents=True, exist_ok=True)
CONTEST_MAP_CACHE = CACHE_DIR / "contest_map.json"
PROBLEM_MAP_CACHE = CACHE_DIR / "problems_all.json"

# --------------- Utilities ---------------

def load_env_cookie() -> Dict[str, str]:
	session_cookie = os.environ.get("LEETCODE_SESSION", "")
	csrftoken = os.environ.get("LEETCODE_CSRF", "")
	cookies = {}
	if session_cookie:
		cookies["LEETCODE_SESSION"] = session_cookie
	if csrftoken:
		cookies["csrftoken"] = csrftoken
	return cookies

def headers_for_graphql(csrftoken: Optional[str]) -> Dict[str, str]:
	headers = {
		"Content-Type": "application/json",
		"Referer": LEETCODE_BASE,
		"User-Agent": "leetcode-readme-gen (+https://github.com/Macweese/3C)"
	}
	if csrftoken:
		headers["x-csrftoken"] = csrftoken
	return headers

def query_graphql(slug: str, cookies: Dict[str, str]) -> Dict[str, Any]:
	csrftoken = cookies.get("csrftoken", None)
	headers = headers_for_graphql(csrftoken)

	query = """
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionId
        questionFrontendId
        title
        titleSlug
        difficulty
        content
        hints
        topicTags { name slug }
        similarQuestions
        isPaidOnly
      }
    }
    """

	payload = {"operationName": "questionData", "variables": {"titleSlug": slug}, "query": query}
	resp = requests.post(GRAPHQL_URL, headers=headers, cookies=cookies, json=payload, timeout=30)
	resp.raise_for_status()
	data = resp.json()
	if "errors" in data:
		raise RuntimeError(f"LeetCode GraphQL returned errors: {data['errors']}")
	return data["data"]["question"]

# --------------- Problem map (id <-> slug) ---------------

_PROBLEM_MAP_DOC: Optional[dict] = None
_ID_TO_SLUG: Optional[Dict[str, str]] = None
_SLUG_TO_ID: Optional[Dict[str, str]] = None

def _load_problem_map_doc() -> Optional[dict]:
	# Try cache first
	if PROBLEM_MAP_CACHE.exists():
		try:
			return json.loads(PROBLEM_MAP_CACHE.read_text(encoding="utf-8"))
		except Exception:
			pass
	# Fetch and cache
	try:
		r = requests.get(MAP_ALL_URL, timeout=60)
		r.raise_for_status()
		doc = r.json()
		PROBLEM_MAP_CACHE.write_text(json.dumps(doc), encoding="utf-8")
		return doc
	except Exception:
		return None

def _ensure_problem_maps_ready() -> None:
	global _PROBLEM_MAP_DOC, _ID_TO_SLUG, _SLUG_TO_ID
	if _ID_TO_SLUG is not None and _SLUG_TO_ID is not None:
		return
	_PROBLEM_MAP_DOC = _load_problem_map_doc()
	id_to_slug: Dict[str, str] = {}
	slug_to_id: Dict[str, str] = {}
	if _PROBLEM_MAP_DOC:
		for pair in _PROBLEM_MAP_DOC.get("stat_status_pairs", []):
			stat = pair.get("stat") or {}
			fid = stat.get("frontend_question_id")
			slug = stat.get("question__title_slug")
			if fid and slug:
				fid_s = str(fid)
				id_to_slug[fid_s] = slug
				slug_to_id[slug] = fid_s
	_ID_TO_SLUG = id_to_slug
	_SLUG_TO_ID = slug_to_id

def get_slug_from_number(number: str) -> Optional[str]:
	_ensure_problem_maps_ready()
	return _ID_TO_SLUG.get(str(number)) if _ID_TO_SLUG else None

def get_id_from_slug(slug: str) -> Optional[str]:
	_ensure_problem_maps_ready()
	return _SLUG_TO_ID.get(slug) if _SLUG_TO_ID else None

def extract_slug_from_input(inp: str) -> str:
	inp = inp.strip()
	m = re.match(r"https?://leetcode\.com/problems/([a-z0-9\-]+)/?", inp)
	if m:
		return m.group(1)
	if re.fullmatch(r"\d+", inp):
		slug = get_slug_from_number(inp)
		if not slug:
			raise ValueError(f"Could not resolve slug for problem number {inp}. Try passing the problem URL or slug.")
		return slug
	if re.fullmatch(r"[a-z0-9\-]+", inp):
		return inp
	raise ValueError(f"Unrecognized input: {inp}. Pass a problem URL, slug, or number.")

def difficulty_color(diff: str) -> str:
	return DIFFICULTY_COLOR.get(diff, "#3BE38C")

def parse_similar(similar_json: Optional[str]) -> List[Dict[str, str]]:
	if not similar_json:
		return []
	try:
		arr = json.loads(similar_json)
		out = []
		for item in arr:
			out.append({
				"title": item.get("title", ""),
				"slug": item.get("titleSlug", ""),
				"difficulty": item.get("difficulty", ""),
			})
		return out
	except Exception:
		return []

def sanitize_filename(name: str) -> str:
	return re.sub(r"[^A-Za-z0-9\-_\. ]+", "", name).strip().replace(" ", "-").lower()

def format_today_utc() -> Dict[str, str]:
	now = dt.datetime.now(datetime.UTC)
	return {
		"iso": now.strftime("%Y-%m-%d"),
		"day": now.strftime("%d"),
		"month": now.strftime("%m"),
		"year": now.strftime("%Y"),
		"weekday_short": now.strftime("%a"),
		"month_full": now.strftime("%B"),
	}

# --------------- Output path construction ---------------

def build_output_dir(base: Path, difficulty: str, mode: str, problem_id: Optional[str], use_id_subdir: bool) -> Path:
	d = base
	if mode == "by-difficulty":
		d = d / difficulty.lower()
	if use_id_subdir and problem_id:
		d = d / str(problem_id)
	return d

def ensure_dir(p: Path) -> None:
	p.mkdir(parents=True, exist_ok=True)

# --------------- Contest tag detection (best-effort, cached) ---------------

def _load_contest_map_cache() -> Dict[str, Any]:
	if CONTEST_MAP_CACHE.exists():
		try:
			return json.loads(CONTEST_MAP_CACHE.read_text(encoding="utf-8"))
		except Exception:
			return {}
	return {}

def _save_contest_map_cache(data: Dict[str, Any]) -> None:
	try:
		CONTEST_MAP_CACHE.write_text(json.dumps(data, ensure_ascii=False, indent=2), encoding="utf-8")
	except Exception:
		pass

def _contest_label_from_title(title: str) -> Optional[str]:
	m = re.match(r"\s*(Weekly|Biweekly)\s+Contest\s+(\d+)\s*$", title, re.IGNORECASE)
	if not m:
		return None
	return f"{m.group(1).lower()} contest {m.group(2)}"

def _fetch_contest_list() -> List[Dict[str, Any]]:
	try:
		r = requests.get(CONTEST_LIST_URL, timeout=30)
		r.raise_for_status()
		data = r.json()
		contests = []
		for k in ("contest", "contests", "previous_contests", "all_contests"):
			v = data.get(k)
			if isinstance(v, list):
				contests.extend(v)
		seen = set()
		uniq = []
		for c in contests:
			slug = c.get("titleSlug") or c.get("title_slug")
			if slug and slug not in seen:
				seen.add(slug)
				uniq.append(c)
		uniq.sort(key=lambda c: c.get("startTime") or c.get("start_time") or 0, reverse=True)
		return uniq
	except Exception:
		return []

def _contest_contains_slug(contest_slug: str, problem_slug: str) -> bool:
	try:
		r = requests.get(CONTEST_INFO_URL.format(slug=contest_slug), timeout=30)
		if r.ok:
			info = r.json()
			qs = info.get("questions") or info.get("problems") or []
			for q in qs:
				ts = q.get("titleSlug") or q.get("title_slug")
				if ts == problem_slug:
					return True
	except Exception:
		pass
	try:
		r = requests.get(CONTEST_PAGE_URL.format(slug=contest_slug), timeout=30)
		if r.ok:
			if re.search(rf'["\']titleSlug["\']\s*:\s*["\']{re.escape(problem_slug)}["\']', r.text):
				return True
	except Exception:
		pass
	return False

def get_contest_tag_for_slug(problem_slug: str) -> Optional[str]:
	cache = _load_contest_map_cache()
	slug_to_contest = cache.get("slug_to_contest", {})
	if problem_slug in slug_to_contest:
		return slug_to_contest[problem_slug]

	contests = _fetch_contest_list()
	for c in contests:
		cslug = c.get("titleSlug") or c.get("title_slug")
		ctitle = c.get("title") or ""
		if not cslug or not ctitle:
			continue
		if not re.search(r"(weekly|biweekly)-contest-\d+", cslug, re.IGNORECASE):
			continue
		try:
			if _contest_contains_slug(cslug, problem_slug):
				label = _contest_label_from_title(ctitle)
				if label:
					slug_to_contest[problem_slug] = label
					cache["slug_to_contest"] = slug_to_contest
					cache["ts"] = int(dt.datetime.utcnow().timestamp())
					_save_contest_map_cache(cache)
					return label
		except Exception:
			continue
	slug_to_contest[problem_slug] = None
	cache["slug_to_contest"] = slug_to_contest
	cache["ts"] = int(dt.datetime.utcnow().timestamp())
	_save_contest_map_cache(cache)
	return None

# --------------- Similar enrichment: resolve IDs ---------------

def enrich_similar_with_ids(similar: List[Dict[str, str]], cookies: Dict[str, str]) -> List[Dict[str, str]]:
	out = []
	for s in similar:
		slug = s.get("slug") or ""
		fid = get_id_from_slug(slug)
		if not fid:
			# fallback: query
			try:
				q = query_graphql(slug, cookies)
				fid = q.get("questionFrontendId")
			except Exception:
				fid = None
		out.append({
			"title": s.get("title", ""),
			"slug": slug,
			"id": str(fid) if fid else "",
		})
	return out

# --------------- Example normalization from HTML (best-effort) ---------------

EX_HEADER_RE = re.compile(
	r'(?is)(?:<p[^>]*>\s*)?(?:<(?:strong|b)[^>]*>)\s*Example\s*(\d+)?\s*:?\s*</(?:strong|b)>\s*(?:</p>)?'
)
LABEL_RE_TMPL = r'(?is)(?:<(?:strong|b)[^>]*>)\s*{label}\s*:?\s*</(?:strong|b)>\s*'
LABELS = ["Input", "Output", "Explanation"]

def _extract_label_content(section_html: str, label: str) -> Optional[str]:
	pattern = re.compile(
		LABEL_RE_TMPL.format(label=re.escape(label)) + r'(.*?)' +
		r'(?=(?:<(?:strong|b)[^>]*>)\s*(?:Input|Output|Explanation)\s*:?\s*</(?:strong|b)>|$)',
		flags=re.IGNORECASE | re.DOTALL
	)
	m = pattern.search(section_html)
	if m:
		content = m.group(1).strip()
		return content if content else None
	return None

def split_description_and_examples(content_html: str) -> Tuple[str, List[Dict[str, Any]]]:
	if not content_html:
		return "", []

	desc_parts = []
	examples: List[Dict[str, Any]] = []

	matches = list(EX_HEADER_RE.finditer(content_html))
	if not matches:
		return content_html, []

	first_start = matches[0].start()
	if first_start > 0:
		desc_parts.append(content_html[:first_start])

	for i, m in enumerate(matches):
		start = m.start()
		end = matches[i + 1].start() if i + 1 < len(matches) else len(content_html)
		sect_html = content_html[start:end]
		ex_num = m.group(1)
		in_html = _extract_label_content(sect_html, "Input")
		out_html = _extract_label_content(sect_html, "Output")
		exp_html = _extract_label_content(sect_html, "Explanation")
		imgs = re.findall(r'(<img[^>]*>)', sect_html, flags=re.IGNORECASE)

		examples.append({
			"number": ex_num or str(len(examples) + 1),
			"images_html": imgs,
			"input_html": in_html,
			"output_html": out_html,
			"explanation_html": exp_html,
			"raw_html": sect_html,
		})

	last_end = matches[-1].end()
	if last_end < len(content_html):
		desc_parts.append(content_html[last_end:])

	desc_html = "".join(desc_parts).strip()
	return desc_html, examples

def postprocess_example_subsection_html(html_fragment: Optional[str]) -> Optional[str]:
	if not html_fragment:
		return None
	frag = re.sub(r'(<br\s*/?>\s*){2,}', r'<br>', html_fragment, flags=re.IGNORECASE)
	return frag.strip()

# --------------- Bulk input expansion ---------------

def expand_problem_inputs(inputs: Iterable[str]) -> List[str]:
	# Accepts numbers, slugs, URLs, and numeric ranges like 40-50
	out: List[str] = []
	for token in inputs:
		t = token.strip()
		m = re.fullmatch(r"(\d+)\s*-\s*(\d+)", t)
		if m:
			a, b = int(m.group(1)), int(m.group(2))
			if a > b:
				a, b = b, a
			# modest guard to prevent accidents
			if (b - a) > 2000:
				raise ValueError(f"Range too large: {t}")
			for n in range(a, b + 1):
				out.append(str(n))
		else:
			out.append(t)
	return out

# --------------- Main generation routine ---------------

def generate_one(slug: str, args, cookies: Dict[str, str], id_cache: Dict[str, str]) -> Tuple[Optional[str], Optional[str], List[str], Optional[Path]]:
	"""
	Returns: (problem_id, title, similar_slugs, written_path)
	"""
	# Fetch primary problem
	q = query_graphql(slug, cookies)

	# Early paid-only guard if requested
	if q.get("isPaidOnly") and args.fail_on_paid:
		print(f"Skipping paid-only problem: {slug}", file=sys.stderr)
		return None, None, [], None

	# Build context
	today = format_today_utc()
	similar = parse_similar(q.get("similarQuestions"))
	# Record slugs for bulk if needed
	similar_slugs = [s.get("slug") for s in similar if s.get("slug")]

	# Enrich similar with IDs for rendering
	similar_enriched = []
	if similar:
		similar_enriched = []
		for s in similar:
			s_slug = s.get("slug") or ""
			s_id = get_id_from_slug(s_slug)
			if not s_id:
				try:
					sq = query_graphql(s_slug, cookies)
					s_id = sq.get("questionFrontendId")
				except Exception:
					s_id = None
			similar_enriched.append({
				"title": s.get("title", ""),
				"slug": s_slug,
				"id": str(s_id) if s_id else "",
			})

	topic_tags = q.get("topicTags") or []
	tags = [t.get("name", "") for t in topic_tags if t.get("name")]

	# Contest tag (best-effort)
	if not args.no_contest_tag:
		try:
			contest_tag = get_contest_tag_for_slug(q.get("titleSlug", slug))
		except Exception:
			contest_tag = None
		if contest_tag:
			tags.append(contest_tag)

	# Examples normalization
	content_html = q.get("content", "") or ""
	if not args.no_normalize_examples:
		try:
			desc_html, examples = split_description_and_examples(content_html)
			for ex in examples:
				ex["input_html"] = postprocess_example_subsection_html(ex.get("input_html"))
				ex["output_html"] = postprocess_example_subsection_html(ex.get("output_html"))
				ex["explanation_html"] = postprocess_example_subsection_html(ex.get("explanation_html"))
		except Exception:
			desc_html = content_html
			examples = []
	else:
		desc_html = content_html
		examples = []

	problem_id = q.get("questionFrontendId", "") or get_id_from_slug(slug) or ""
	title = q.get("title", "")
	difficulty = q.get("difficulty", "Easy")
	context = {
		"question_id": problem_id,
		"question_title": title,
		"title_slug": q.get("titleSlug", slug),
		"difficulty": difficulty,
		"difficulty_color": difficulty_color(difficulty),
		"leetcode_url": f"{LEETCODE_BASE}/problems/{q.get('titleSlug', slug)}/",
		"description_html": desc_html,
		"examples": examples,
		"hints": q.get("hints", []) or [],
		"tags": tags,
		"similar": similar_enriched,
		"today": today,
	}

	# Prepare output path
	base = Path(args.out_dir).resolve()
	out_dir = build_output_dir(base, difficulty, args.mode, problem_id if not args.no_id_subdir else None, use_id_subdir=not args.no_id_subdir)
	ensure_dir(out_dir)
	out_file = out_dir / args.filename

	# Render template
	env = Environment(
		loader=FileSystemLoader(Path(args.template).parent),
		autoescape=select_autoescape(enabled_extensions=("html", "xml", "md", "j2"))
	)
	template = env.get_template(Path(args.template).name)
	rendered = template.render(**context)

	out_file.write_text(rendered, encoding="utf-8")
	print(f"Wrote {out_file} — {problem_id}. {title} [{difficulty}]")

	return str(problem_id) if problem_id else None, title, [s for s in similar_slugs if s], out_file

def main():
	parser = argparse.ArgumentParser(description="Generate LeetCode README.md files.")
	parser.add_argument(
		"problems",
		nargs="+",
		help="One or more problems (URL, slug, number, or numeric range like 40-50)."
	)
	parser.add_argument("--out-dir", default=".", help="Base output directory. Default: current directory")
	parser.add_argument("--mode", choices=["flat", "by-difficulty"], default="by-difficulty",
						help="Where to place generated file. flat: out-dir[/<id>]/README.md; by-difficulty: out-dir/<difficulty>[/<id>]/README.md")
	parser.add_argument("--filename", default="README.md", help="Output filename. Default: README.md")
	parser.add_argument("--template", default=str(Path(__file__).parent / "templates" / "leetcode_readme.md.j2"),
						help="Path to Jinja2 template file")
	parser.add_argument("--fail-on-paid", action="store_true", help="Fail/skip if the question is paid-only.")
	parser.add_argument("--no-normalize-examples", action="store_true", help="Do not reformat examples; embed raw content.")
	parser.add_argument("--no-contest-tag", action="store_true", help="Disable contest tag lookup.")
	parser.add_argument("--no-id-subdir", action="store_true", help="Do not create a per-problem-id directory; write directly into the difficulty or base directory.")
	parser.add_argument("--also-similar", action="store_true", help="Also generate READMEs for all 'Similar' problems of each specified problem (one level).")
	parser.add_argument("--open", action="store_true", help="Open the last output file after generation (macOS only).")
	args = parser.parse_args()

	# Expand inputs (ranges etc.)
	try:
		items = expand_problem_inputs(args.problems)
	except Exception as e:
		print(str(e), file=sys.stderr)
		sys.exit(1)

	cookies = load_env_cookie()

	# Resolve each item to a slug
	queue: List[str] = []
	seen: Set[str] = set()
	for it in items:
		try:
			slug = extract_slug_from_input(it)
			if slug not in seen:
				seen.add(slug)
				queue.append(slug)
		except Exception as e:
			print(f"Skipping '{it}': {e}", file=sys.stderr)

	last_written: Optional[Path] = None
	# For similar expansion, collect slugs to add once
	to_add_similar: List[str] = []

	while queue:
		slug = queue.pop(0)
		try:
			pid, title, similar_slugs, written = generate_one(slug, args, cookies, {})
			if written:
				last_written = written
			if getattr(args, "also_similar", False):
				for s in similar_slugs:
					if s and s not in seen:
						seen.add(s)
						to_add_similar.append(s)
		except Exception as e:
			print(f"Failed to generate for '{slug}': {e}", file=sys.stderr)

	if getattr(args, "also_similar", False) and to_add_similar:
		# Process similar problems (one level)
		for s in to_add_similar:
			try:
				pid, title, similar_slugs, written = generate_one(s, args, cookies, {})
				if written:
					last_written = written
			except Exception as e:
				print(f"Failed to generate for similar '{s}': {e}", file=sys.stderr)

	if args.open and last_written and sys.platform == "darwin":
		os.system(f'open "{last_written}"')

if __name__ == "__main__":
	main()