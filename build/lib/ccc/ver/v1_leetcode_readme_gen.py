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
import datetime as dt
import json
import os
import re
import sys
from pathlib import Path
from typing import Dict, Optional, Any, List

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
        companyTagStats
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

def get_slug_from_number(number: str) -> Optional[str]:
	# Map problem number -> slug via the public listing. Works unauthenticated.
	# If this ever changes, require user to pass slug or URL directly.
	try:
		r = requests.get(MAP_ALL_URL, timeout=30)
		r.raise_for_status()
		doc = r.json()
		for pair in doc.get("stat_status_pairs", []):
			stat = pair.get("stat", {}) or {}
			fid = str(stat.get("frontend_question_id"))
			if fid == number:
				return stat.get("question__title_slug")
		return None
	except Exception:
		return None

def extract_slug_from_input(inp: str) -> str:
	# Accepts a slug, a question number, or a full URL.
	inp = inp.strip()
	# URL form
	m = re.match(r"https?://leetcode\.com/problems/([a-z0-9\-]+)/?", inp)
	if m:
		return m.group(1)

	# Pure number?
	if re.fullmatch(r"\d+", inp):
		slug = get_slug_from_number(inp)
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
	now = dt.datetime.utcnow()
	return {
		"iso": now.strftime("%Y-%m-%d"),
		"day": now.strftime("%d"),
		"month": now.strftime("%m"),
		"year": now.strftime("%Y"),
		"weekday_short": now.strftime("%a"),
		"month_full": now.strftime("%B"),
	}

def build_output_dir(base: Path, difficulty: str, mode: str) -> Path:
	# mode can be: flat, by-difficulty, slug, number
	d = base
	diff_dir = difficulty.lower()
	if mode == "by-difficulty":
		d = d / diff_dir
	return d

def ensure_dir(p: Path) -> None:
	p.mkdir(parents=True, exist_ok=True)

def main():
	parser = argparse.ArgumentParser(description="Generate a LeetCode problem README.md from LeetCode GraphQL.")
	parser.add_argument("problem", help="LeetCode problem URL, slug, or number (e.g., 3408 or https://leetcode.com/problems/design-task-manager/)")
	parser.add_argument("--out-dir", default=".", help="Base output directory. Default: current directory")
	parser.add_argument("--mode", choices=["flat", "by-difficulty"], default="by-difficulty",
						help="Where to place generated file. flat: put README.md in out-dir; by-difficulty: in out-dir/<difficulty>/")
	parser.add_argument("--filename", default="README.md", help="Output filename. Default: README.md")
	parser.add_argument("--template", default=str(Path(__file__).parent / "templates" / "leetcode_readme.md.j2"),
						help="Path to Jinja2 template file")
	parser.add_argument("--fail-on-paid", action="store_true", help="Fail if the question is paid-only.")
	parser.add_argument("--open", action="store_true", help="Open the output file after generation (macOS only).")
	args = parser.parse_args()

	try:
		slug = extract_slug_from_input(args.problem)
	except Exception as e:
		print(str(e), file=sys.stderr)
		sys.exit(1)

	cookies = load_env_cookie()
	try:
		q = query_graphql(slug, cookies)
	except Exception as e:
		print(f"Failed to fetch problem data for '{slug}': {e}", file=sys.stderr)
		sys.exit(2)

	if q.get("isPaidOnly") and args.fail_on_paid:
		print("This problem is paid-only. Re-run without --fail-on-paid or provide session cookies.", file=sys.stderr)
		sys.exit(3)

	# Build template context
	today = format_today_utc()
	similar = parse_similar(q.get("similarQuestions"))
	topic_tags = q.get("topicTags") or []
	context = {
		"question_id": q.get("questionFrontendId", ""),
		"question_title": q.get("title", ""),
		"title_slug": q.get("titleSlug", slug),
		"difficulty": q.get("difficulty", "Easy"),
		"difficulty_color": difficulty_color(q.get("difficulty", "Easy")),
		"leetcode_url": f"{LEETCODE_BASE}/problems/{q.get('titleSlug', slug)}/",
		"content_html": q.get("content", "") or "",
		"hints": q.get("hints", []) or [],
		"tags": [t.get("name", "") for t in topic_tags],
		"similar": similar,
		"today": today,
	}

	# Prepare output path
	base = Path(args.out_dir).resolve()
	out_dir = build_output_dir(base, context["difficulty"], args.mode)
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

	if args.open and sys.platform == "darwin":
		os.system(f'open "{out_file}"')

if __name__ == "__main__":
	main()