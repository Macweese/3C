#
#      Copyright (C) 2018 Macweese <https://www.github.com/Macweese>
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
from pathlib import Path
from typing import Dict, Optional, Any, List, Tuple, Iterable, Set

import requests
from jinja2 import Environment, FileSystemLoader, select_autoescape
from bs4 import BeautifulSoup, Tag, NavigableString

LEETCODE_BASE = "https://leetcode.com"
GRAPHQL_URL = f"{LEETCODE_BASE}/graphql"
MAP_ALL_URL = f"{LEETCODE_BASE}/api/problems/all/"
CONTEST_LIST_URL = f"{LEETCODE_BASE}/contest/api/list/"
CONTEST_INFO_URL = f"{LEETCODE_BASE}/contest/api/info/{{slug}}"
CONTEST_PAGE_URL = f"{LEETCODE_BASE}/contest/{{slug}}/"

# Difficulty to color mapping (for LeetCode we only use easy, medium, hard)
DIFFICULTY_COLOR = {
	"Beginner": '#70BAFF',
	"Easy": '#3BE38C',
	"Medium": '#E39A2D',
	"Hard": '#FF4800',
	"Master": '#FF0000',
	"Grandmaster": '#FB00FF',
}

CACHE_DIR = Path(__file__).parent / ".cache"
CACHE_DIR.mkdir(parents=True, exist_ok=True)
CONTEST_MAP_CACHE = CACHE_DIR / "contest_map.json"
PROBLEM_MAP_CACHE = CACHE_DIR / "problems_all.json"

# -------------------------------- Utilities --------------------------------

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

# ------------------------------ Problem map ---------------------------------

_PROBLEM_MAP_DOC: Optional[dict] = None
_ID_TO_SLUG: Optional[Dict[str, str]] = None
_SLUG_TO_ID: Optional[Dict[str, str]] = None

def _load_problem_map_doc() -> Optional[dict]:
	if PROBLEM_MAP_CACHE.exists():
		try:
			return json.loads(PROBLEM_MAP_CACHE.read_text(encoding="utf-8"))
		except Exception:
			pass
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

# ------------------------- Output path construction -------------------------

def build_output_dir(base: Path, difficulty: str, mode: str, problem_id: Optional[str], use_id_subdir: bool) -> Path:
	d = base
	if mode == "by-difficulty":
		d = d / difficulty.lower()
	if use_id_subdir and problem_id:
		d = d / str(problem_id)
	return d

def ensure_dir(p: Path) -> None:
	p.mkdir(parents=True, exist_ok=True)

# ---------------------- Contest tag detection (cached) ----------------------

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

# ------------------ Similar enrichment: resolve IDs quickly ------------------

def enrich_similar_with_ids(similar: List[Dict[str, str]], cookies: Dict[str, str]) -> List[Dict[str, str]]:
	out = []
	for s in similar:
		slug = s.get("slug") or ""
		fid = get_id_from_slug(slug)
		if not fid:
			try:
				sq = query_graphql(slug, cookies)
				fid = sq.get("questionFrontendId")
			except Exception:
				fid = None
		out.append({
			"title": s.get("title", ""),
			"slug": slug,
			"id": str(fid) if fid else "",
		})
	return out

# ---------------- Example/Constraints extraction with BeautifulSoup ----------

EX_HEADER_TEXT_RE = re.compile(r"^\s*Example(?:\s*\d+)?\s*:?\s*$", re.IGNORECASE)
LABELS = ["Input", "Output", "Explanation"]

def _tag_text_equals(tag: Tag, pattern: re.Pattern) -> bool:
	txt = tag.get_text(strip=True) if isinstance(tag, Tag) else ""
	return bool(pattern.match(txt))

def _is_constraints_header(tag: Tag) -> bool:
	if not isinstance(tag, Tag):
		return False
	# Look for a tag whose inner strong/b says "Constraints"
	# or the tag text equals "Constraints:"
	if tag.name in ("strong", "b"):
		return tag.get_text(strip=True).lower().startswith("constraints")
	txt = tag.get_text(strip=True).lower()
	if txt.startswith("constraints"):
		return True
	# Specific: <p><strong>Constraints:</strong></p>
	strong = tag.find(["strong", "b"])
	if strong and strong.get_text(strip=True).lower().startswith("constraints"):
		return True
	return False

def _collect_until(tags_iter, stop_predicate) -> List[Tag]:
	collected = []
	for el in tags_iter:
		if isinstance(el, NavigableString):
			# keep strings (whitespace) unless empty
			if str(el).strip() == "":
				collected.append(el)
				continue
		if isinstance(el, Tag) and stop_predicate(el):
			break
		collected.append(el)
	return collected

def _html_of(nodes: List[Any]) -> str:
	return "".join(str(n) for n in nodes).strip()

def _extract_label_content_from_html(html: str, label: str) -> Optional[str]:
	pattern = re.compile(
		r'(?is)(?:<(?:strong|b)[^>]*>)\s*' + re.escape(label) + r'\s*:?\s*</(?:strong|b)>\s*(.*?)(?=(?:<(?:strong|b)[^>]*>)\s*(?:Input|Output|Explanation)\s*:?\s*</(?:strong|b)>|$)'
	)
	m = pattern.search(html)
	if m:
		return m.group(1).strip() or None
	return None

# ---------- New helpers for pattern-based parsing ----------

EXAMPLE_HEADER_STRONG_SELECTOR = lambda tag: (
		isinstance(tag, Tag)
		and tag.name == "strong"
		and ("example" in (tag.get("class") or []))
		and re.match(r"^\s*Example(?:\s*\d+)?\s*:?\s*$", tag.get_text(strip=True), flags=re.IGNORECASE)
)

def _is_nbsp_paragraph(tag: Tag) -> bool:
	if not isinstance(tag, Tag) or tag.name != "p":
		return False
	text = tag.get_text().strip()
	# text may be just &nbsp; or empty due to formatting
	return text == "\xa0" or text == ""

def _is_example_header_p(tag: Tag) -> bool:
	if not isinstance(tag, Tag) or tag.name != "p":
		return False
	strong = tag.find("strong")
	if not strong:
		return False
	# Prefer the site's explicit strong.example marker
	if EXAMPLE_HEADER_STRONG_SELECTOR(strong):
		return True
	# Fallback: recognize "Example n:" even without class="example"
	txt = strong.get_text(strip=True)
	return re.match(r"^\s*Example(?:\s*\d+)?\s*:?\s*$", txt, flags=re.IGNORECASE) is not None

def _extract_example_number_from_header_p(header_p: Tag) -> str:
	strong = header_p.find("strong")
	if not strong:
		return "1"
	m = re.search(r"Example\s*(\d+)", strong.get_text(strip=True), flags=re.IGNORECASE)
	return m.group(1) if m else "1"

def _extract_after_strong_html(p_tag: Tag) -> str:
	# Return inner HTML of <p> excluding the first <strong> label node.
	if not isinstance(p_tag, Tag):
		return ""
	clone = BeautifulSoup(str(p_tag), "html.parser").p
	if not clone:
		return ""
	strong = clone.find("strong")
	if strong:
		strong.decompose()
	return clone.decode_contents().strip()

def _find_constraints_header(container: Tag) -> Optional[Tag]:
	# Typical form: <p><strong>Constraints:</strong></p>
	for p in container.find_all("p"):
		strong = p.find("strong")
		if strong and strong.get_text(strip=True).lower().startswith("constraints"):
			return p
	return None

def _parse_by_nbsp_and_example_blocks(content_html: str) -> Tuple[str, List[Dict[str, Any]], str]:
	"""
	Deterministically parse description, examples, and constraints using the site's structure:
	  Description
	  <p>&nbsp;</p>
	  (Example header p + div.example-block) repeated
	  <p>&nbsp;</p>
	  <p><strong>Constraints:</strong></p>
	  <ul>...</ul>
	Returns: (description_html, examples, constraints_html)
	"""
	soup = BeautifulSoup(content_html, "html.parser")
	# Use the inner description container if present; GraphQL content often already is the inner HTML.
	container = soup.find("div", class_="elfjS") or soup

	# Build a linear list of direct children to respect order
	children: List[Tag] = [c for c in container.children if isinstance(c, Tag)]

	# 1) Split on the first &nbsp; paragraph after the initial description
	first_nbsp_idx = next((i for i, t in enumerate(children) if _is_nbsp_paragraph(t)), None)

	# If no separator, fallback: try to find the first example header and treat everything before as description
	if first_nbsp_idx is None:
		first_example_idx = next((i for i, t in enumerate(children) if _is_example_header_p(t)), None)
		if first_example_idx is None:
			# No clear pattern — return entire content as description.
			return (container.decode_contents().strip(), [], "")
		desc_nodes = children[:first_example_idx]
		rest_nodes = children[first_example_idx:]
	else:
		desc_nodes = children[:first_nbsp_idx]
		rest_nodes = children[first_nbsp_idx + 1 :]  # skip the &nbsp; p

	# 2) From rest_nodes, collect example pairs: (header p) + (following div.example-block)
	examples: List[Dict[str, Any]] = []
	i = 0
	while i < len(rest_nodes):
		node = rest_nodes[i]
		# Stop examples section on a blank paragraph or when constraints header shows up
		if _is_nbsp_paragraph(node):
			i += 1
			break
		if _is_example_header_p(node):
			# Example header found; next relevant sibling should be the example-block div
			ex_header = node
			# Find the next Tag (skip non-Tag or whitespace) that is a div.example-block
			j = i + 1
			ex_block = None
			while j < len(rest_nodes):
				cand = rest_nodes[j]
				if isinstance(cand, Tag):
					if cand.name == "div" and "example-block" in (cand.get("class") or []):
						ex_block = cand
						break
					# If we hit another example header, we consider this example to have no block (unlikely)
					if _is_example_header_p(cand):
						break
				j += 1

			# Extract fields from example-block if present
			number = _extract_example_number_from_header_p(ex_header)
			imgs = []
			in_html = out_html = exp_html = None
			if ex_block:
				imgs = [str(img) for img in ex_block.find_all("img")]

				# Input
				p_input = next((p for p in ex_block.find_all("p") if p.find("strong") and p.find("strong").get_text(strip=True).lower().startswith("input")), None)
				if p_input:
					in_html = _extract_after_strong_html(p_input)

				# Output
				p_output = next((p for p in ex_block.find_all("p") if p.find("strong") and p.find("strong").get_text(strip=True).lower().startswith("output")), None)
				if p_output:
					out_html = _extract_after_strong_html(p_output)

				# Explanation (could be the label p, followed by descriptive p's)
				p_expl_label = next((p for p in ex_block.find_all("p") if p.find("strong") and p.find("strong").get_text(strip=True).lower().startswith("explanation")), None)
				if p_expl_label:
					# Gather the p_expl_label's following siblings within this block that are <p> (until next labeled p)
					exp_parts: List[str] = []
					for sib in p_expl_label.find_next_siblings():
						if not isinstance(sib, Tag) or sib.name != "p":
							continue
						# Stop if it appears to start another label
						sstrong = sib.find("strong")
						if sstrong and re.match(r"^\s*(input|output|explanation)\s*:?\s*$", sstrong.get_text(strip=True), flags=re.IGNORECASE):
							break
						exp_parts.append(str(sib))
					# If no subsequent explanatory <p>, leave None; else join
					if exp_parts:
						exp_html = "\n".join(exp_parts).strip()

			examples.append({
				"number": number,
				"images_html": imgs,
				"input_html": in_html,
				"output_html": out_html,
				"explanation_html": exp_html,
				"raw_html": str(ex_block) if ex_block else str(ex_header),
			})

			# Advance past the header and block if found
			i = j + 1 if ex_block else i + 1
			continue

		# If we encounter the Constraints header, stop collecting examples
		strong = node.find("strong") if isinstance(node, Tag) else None
		if strong and strong.get_text(strip=True).lower().startswith("constraints"):
			break

		i += 1

	# Remaining nodes after examples may include another &nbsp; p then constraints
	rest_after_examples = rest_nodes[i:]

	# 3) Constraints: find header and its next list
	# Prefer to search in the whole container (safer), but do not re-include examples.
	constraints_html = ""
	constraints_p = _find_constraints_header(container)
	if constraints_p:
		list_tag = constraints_p.find_next(lambda t: isinstance(t, Tag) and t.name in ("ul", "ol"))
		parts = [str(constraints_p)]
		if list_tag:
			parts.append(str(list_tag))
		constraints_html = "\n".join(parts).strip()

	description_html = "".join(str(n) for n in desc_nodes).strip()
	return description_html, examples, constraints_html

# ---------- Extract elements: pattern-first + fallback ----------

def split_desc_examples_constraints(content_html: str) -> Tuple[str, List[Dict[str, Any]], str]:
	"""
	Returns (description_html, examples, constraints_html)
	Priority 1: Parse via known site structure (nbsp separators, Example headers, example-blocks, Constraints).
	Fallback: previous heuristic-based splitter (if pattern not detected).
	"""
	if not content_html:
		return "", [], ""

	try:
		desc_html, examples, constraints_html = _parse_by_nbsp_and_example_blocks(content_html)
		# If we got a meaningful split (either examples or constraints present), use it
		if examples or constraints_html:
			return desc_html, examples, constraints_html
		# Else fall through to heuristic
	except Exception:
		pass

	# Fallback to the heuristic approach you previously had
	# (You can keep your earlier BeautifulSoup/regex-based splitter here as a backup.)
	# Minimal fallback: put everything in description to avoid duplication.
	return content_html, [], ""

# ------------------------- Bulk input expansion -----------------------------

def expand_problem_inputs(inputs: Iterable[str]) -> List[str]:
	out: List[str] = []
	for token in inputs:
		t = token.strip()
		m = re.fullmatch(r"(\d+)\s*-\s*(\d+)", t)
		if m:
			a, b = int(m.group(1)), int(m.group(2))
			if a > b:
				a, b = b, a
			if (b - a) > 2000:
				raise ValueError(f"Range too large: {t}")
			for n in range(a, b + 1):
				out.append(str(n))
		else:
			out.append(t)
	return out

# ---------------------------- Generation routine ----------------------------

def generate_one(slug: str, args, cookies: Dict[str, str]) -> Tuple[Optional[str], Optional[str], List[str], Optional[Path]]:
	"""
	Returns: (problem_id, title, similar_slugs, written_path)
	"""
	q = query_graphql(slug, cookies)

	if q.get("isPaidOnly") and args.fail_on_paid:
		print(f"Skipping paid-only problem: {slug}", file=sys.stderr)
		return None, None, [], None

	today = format_today_utc()
	similar = parse_similar(q.get("similarQuestions"))
	similar_slugs = [s.get("slug") for s in similar if s.get("slug")]

	similar_enriched = enrich_similar_with_ids(similar, cookies) if similar else []

	topic_tags = q.get("topicTags") or []
	tags = [t.get("name", "") for t in topic_tags if t.get("name")]

	if not args.no_contest_tag:
		try:
			contest_tag = get_contest_tag_for_slug(q.get("titleSlug", slug))
		except Exception:
			contest_tag = None
		if contest_tag:
			tags.append(contest_tag)

	content_html = q.get("content", "") or ""
	if args.no_normalize_examples:
		desc_html = content_html
		examples = []
		constraints_html = ""
	else:
		try:
			desc_html, examples, constraints_html = split_desc_examples_constraints(content_html)
		except Exception:
			desc_html = content_html
			examples = []
			constraints_html = ""

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
		"constraints_html": constraints_html,
		"hints": q.get("hints", []) or [],
		"tags": tags,
		"similar": similar_enriched,
		"today": today,
	}

	base = Path(args.out_dir).resolve()
	out_dir = build_output_dir(base, difficulty, args.mode, problem_id if not args.no_id_subdir else None, use_id_subdir=not args.no_id_subdir)
	ensure_dir(out_dir)
	out_file = out_dir / args.filename

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

	try:
		items = expand_problem_inputs(args.problems)
	except Exception as e:
		print(str(e), file=sys.stderr)
		sys.exit(1)

	cookies = load_env_cookie()

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
	to_add_similar: List[str] = []

	while queue:
		slug = queue.pop(0)
		try:
			pid, title, similar_slugs, written = generate_one(slug, args, cookies)
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
		for s in to_add_similar:
			try:
				pid, title, similar_slugs, written = generate_one(s, args, cookies)
				if written:
					last_written = written
			except Exception as e:
				print(f"Failed to generate for similar '{s}': {e}", file=sys.stderr)

	if args.open and last_written and sys.platform == "darwin":
		os.system(f'open "{last_written}"')

if __name__ == "__main__":
	main()