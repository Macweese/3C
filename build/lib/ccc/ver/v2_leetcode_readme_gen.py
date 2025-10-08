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

#
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
from typing import Dict, Optional, Any, List, Tuple, Set

import requests
from jinja2 import Environment, FileSystemLoader, select_autoescape

LEETCODE_BASE = "https://leetcode.com"
GRAPHQL_URL = f"{LEETCODE_BASE}/graphql"
MAP_ALL_URL = f"{LEETCODE_BASE}/api/problems/all/"

# Difficulty to color mapping
DIFFICULTY_COLOR = {
	"Easy": "#3BE38C",
	"Medium": "#E39A2D",
	"Hard": "#FF4800",
}

def load_env_cookie() -> Dict[str, str]:
	# Supports optional login. Put LEETCODE_SESSION in .env or environment var.
	session_cookie = os.environ.get("LEETCODE_SESSION", "")
	csrftoken = os.environ.get("LEETCODE_CSRF", "")
	cookies = {}
	if session_cookie:
		cookies["LEETCODE_SESSION"] = session_cookie
	if csrftoken:
		cookies["csrftoken"] = csrftoken
	return cookies

def headers_for_graphql(csrftoken: Optional[str]) -> Dict[str, str]:
	# CSRF header is only needed if authenticated
	headers = {
		"Content-Type": "application/json",
		"Referer": LEETCODE_BASE,
		"User-Agent": "leetcode-readme-gen (+https://github.com/Macweese/3C)"
	}
	if csrftoken:
		headers["x-csrftoken"] = csrftoken
	return headers

def query_graphql(slug: str, cookies: Dict[str, str]) -> Dict[str, Any]:
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
        companyTagStats
      }
    }
    """
	csrftoken = cookies.get("csrftoken", None)
	headers = headers_for_graphql(csrftoken)
	payload = {"operationName": "questionData", "variables": {"titleSlug": slug}, "query": query}
	resp = requests.post(GRAPHQL_URL, headers=headers, cookies=cookies, json=payload, timeout=30)
	resp.raise_for_status()
	data = resp.json()
	if "errors" in data:
		raise RuntimeError(f"LeetCode GraphQL returned errors: {data['errors']}")
	return data["data"]["question"]

def fetch_number_to_slug_map() -> Dict[str, str]:
	"""
	Fetch once and return a mapping of frontend_question_id (as str) -> question__title_slug.
	Works unauthenticated.
	"""
	try:
		r = requests.get(MAP_ALL_URL, timeout=30)
		r.raise_for_status()
		doc = r.json()
		out: Dict[str, str] = {}
		for pair in doc.get("stat_status_pairs", []) or []:
			stat = pair.get("stat", {}) or {}
			fid = stat.get("frontend_question_id")
			slug = stat.get("question__title_slug")
			if fid is not None and slug:
				out[str(fid)] = slug
		return out
	except Exception:
		return {}

def get_slug_from_number(number: str, cache_map: Optional[Dict[str, str]] = None) -> Optional[str]:
	# Map problem number -> slug via the public listing. Works unauthenticated.
	if cache_map is None:
		cache_map = fetch_number_to_slug_map()
	return cache_map.get(str(number))

def extract_slug_from_input(inp: str, cache_map: Optional[Dict[str, str]] = None) -> str:
	# Accepts a slug, a question number, or a full URL.
	inp = inp.strip()
	# URL form
	m = re.match(r"https?://leetcode\.com/problems/([a-z0-9\-]+)/?", inp)
	if m:
		return m.group(1)

	# Pure number?
	if re.fullmatch(r"\d+", inp):
		slug = get_slug_from_number(inp, cache_map=cache_map)
		if not slug:
			raise ValueError(f"Could not resolve slug for problem number {inp}. Try passing the problem URL or slug.")
		return slug

	# Assume already a slug
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
		# expected fields: title, titleSlug, difficulty
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
	now = datetime.datetime.now(datetime.UTC)
	return {
		"iso": now.strftime("%Y-%m-%d"),
		"day": now.strftime("%d"),
		"month": now.strftime("%m"),
		"year": now.strftime("%Y"),
		"weekday_short": now.strftime("%a"),
		"month_full": now.strftime("%B"),
	}

def build_output_dir(base: Path, difficulty: str, mode: str, question_id: Optional[str] = None) -> Path:
	"""
	mode can be:
	- flat: put files directly in base
	- by-difficulty: base/<difficulty>/<question_id> (question_id if available)
	"""
	d = base
	diff_dir = (difficulty or "Easy").lower()
	if mode == "by-difficulty":
		d = d / diff_dir
		if question_id:
			d = d / str(question_id)
	return d

def ensure_dir(p: Path) -> None:
	p.mkdir(parents=True, exist_ok=True)

def expand_inputs_to_slugs(inputs: List[str]) -> List[str]:
	"""
	Expands CLI inputs into a list of distinct slugs. Supports:
	- Single slug/number/url
	- Inclusive numeric range: "40-50"
	- Multiple tokens separated by spaces (via nargs="+")
	"""
	num_map: Optional[Dict[str, str]] = None
	slugs: List[str] = []
	seen: Set[str] = set()

	def add_slug(s: Optional[str]) -> None:
		if s and s not in seen:
			slugs.append(s)
			seen.add(s)

	# Pre-scan to decide if we need the number map
	needs_map = any(re.fullmatch(r"\d+", t.strip()) or re.fullmatch(r"\d+\s*-\s*\d+", t.strip()) for t in inputs)
	if needs_map:
		num_map = fetch_number_to_slug_map()

	for token in inputs:
		t = token.strip()
		# Range?
		m = re.fullmatch(r"(\d+)\s*-\s*(\d+)", t)
		if m:
			start = int(m.group(1))
			end = int(m.group(2))
			if start <= end:
				rng = range(start, end + 1)
			else:
				rng = range(start, end - 1, -1)
			for n in rng:
				slug = get_slug_from_number(str(n), cache_map=num_map)
				if not slug:
					print(f"Warning: could not resolve slug for problem number {n}. Skipping.", file=sys.stderr)
					continue
				add_slug(slug)
			continue

		# Single item (number, slug, or url)
		try:
			slug = extract_slug_from_input(t, cache_map=num_map)
			add_slug(slug)
		except Exception as e:
			print(str(e), file=sys.stderr)

	return slugs

def render_and_write(q: Dict[str, Any], args) -> Path:
	# Build template context
	today = format_today_utc()
	similar = parse_similar(q.get("similarQuestions"))
	topic_tags = q.get("topicTags") or []
	context = {
		"question_id": q.get("questionFrontendId", ""),
		"question_title": q.get("title", ""),
		"title_slug": q.get("titleSlug", ""),
		"difficulty": q.get("difficulty", "../easy"),
		"difficulty_color": difficulty_color(q.get("difficulty", "../easy")),
		"leetcode_url": f"{LEETCODE_BASE}/problems/{q.get('titleSlug', '')}/",
		"content_html": q.get("content", "") or "",
		"hints": q.get("hints", []) or [],
		"tags": [t.get("name", "") for t in topic_tags],
		"similar": similar,
		"today": today,
	}

	# Prepare output path: by-difficulty now also nests by question_id
	base = Path(args.out_dir).resolve()
	out_dir = build_output_dir(base, context["difficulty"], args.mode, question_id=context["question_id"])
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
	print(f"Wrote {out_file}")

	return out_file

def main():
	parser = argparse.ArgumentParser(description="Generate LeetCode problem README.md files from LeetCode GraphQL.")
	parser.add_argument(
		"problems",
		nargs="+",
		help=(
			"One or more LeetCode problem identifiers: URL, slug, number (e.g., 3408), "
			"or an inclusive numeric range like 40-50."
		),
	)
	parser.add_argument("--out-dir", default=".", help="Base output directory. Default: current directory")
	parser.add_argument(
		"--mode",
		choices=["flat", "by-difficulty"],
		default="by-difficulty",
		help="Where to place generated file(s). flat: put README.md in out-dir; by-difficulty: in out-dir/<difficulty>/<id>/"
	)
	parser.add_argument("--filename", default="README.md", help="Output filename. Default: README.md")
	parser.add_argument("--template", default=str(Path(__file__).parent / "templates" / "leetcode_readme.md.j2"),
						help="Path to Jinja2 template file")
	parser.add_argument("--fail-on-paid", action="store_true", help="Fail (skip) paid-only questions unless authenticated.")
	parser.add_argument(
		"--also-similar",
		action="store_true",
		help="Also generate README.md for all 'Similar Questions' of each provided problem."
	)
	parser.add_argument("--open", action="store_true", help="Open the output file(s) after generation (macOS only).")
	args = parser.parse_args()

	# Expand inputs (supports ranges and multiple tokens)
	slug_list = expand_inputs_to_slugs(args.problems)
	if not slug_list:
		print("No valid problems to process.", file=sys.stderr)
		sys.exit(1)

	cookies = load_env_cookie()

	written_files: List[Path] = []
	processed_slugs: Set[str] = set()

	def process_slug(slug: str) -> Tuple[Optional[Path], Optional[List[str]]]:
		try:
			q = query_graphql(slug, cookies)
		except Exception as e:
			print(f"Failed to fetch problem data for '{slug}': {e}", file=sys.stderr)
			return None, None

		if q.get("isPaidOnly") and args.fail_on_paid:
			print(f"Skipping paid-only problem: {q.get('titleSlug', slug)} (use without --fail-on-paid or set cookies)", file=sys.stderr)
			return None, None

		out_file = render_and_write(q, args)
		similar_slugs = [s.get("slug", "") for s in parse_similar(q.get("similarQuestions")) if s.get("slug")]
		return out_file, similar_slugs

	# Process initial list
	for slug in slug_list:
		if slug in processed_slugs:
			continue
		processed_slugs.add(slug)
		out_file, similar_slugs = process_slug(slug)
		if out_file:
			written_files.append(out_file)

		# If requested, also process similar questions
		if args.also_similar and similar_slugs:
			for s in similar_slugs:
				if s in processed_slugs:
					continue
				processed_slugs.add(s)
				sim_out, _ = process_slug(s)
				if sim_out:
					written_files.append(sim_out)

	# Open files on macOS if requested
	if args.open and sys.platform == "darwin":
		for p in written_files:
			try:
				os.system(f'open "{p}"')
			except Exception:
				pass

	# If nothing was written, consider non-zero exit
	if not written_files:
		sys.exit(2)

if __name__ == "__main__":
	main()