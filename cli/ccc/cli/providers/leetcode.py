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

from __future__ import annotations

import argparse
import datetime as dt
import json
import os
import re
import sys
import time
import random
import subprocess
import threading
from pathlib import Path
from typing import Dict, Optional, Any, List, Tuple, Iterable, Set
from concurrent.futures import ThreadPoolExecutor, as_completed

import requests
from jinja2 import Environment, FileSystemLoader, select_autoescape
from bs4 import BeautifulSoup, Tag, NavigableString

from ccc.config import CACHE_DIR, DEFAULT_OUT_DIR
from ccc.output_layout import compute_output_dir, DEFAULT_LAYOUT, DEFAULT_NAMEFMT

from ccc.cli.core.provider import Provider, ProviderContext
from ccc.cli.core.logging import (
	console,
	err_console,
	print_debug,
	print_error,
	print_skip,
	print_success,
)
from ccc.cli.core.utils import get_thread_session, style_path
from ccc.cli.core.filecheck import decide as decide_file, FileDecision, add_overwrite_arguments

# ----------------------------- Rich traceback (optional) ----------------------

try:
	from rich.traceback import install as rich_traceback_install

	rich_traceback_install(show_locals=False, extra_lines=1, width=None)
except Exception:
	pass


# ----------------------------- Styled printing ------------------------------


def _have_console() -> bool:
	return console is not None and err_console is not None


def print_success_wrote(path: Path, problem_id: str, title: str, difficulty: str, out_root: Path) -> None:
	msg = f"Saved {style_path(path, base=out_root)} — {problem_id}. {title} [{difficulty}]"
	print_success(msg)


def print_opened(path: Path, out_root: Path) -> None:
	msg = f"Opened {style_path(path, base=out_root)}"
	print_success(msg)


def print_summary(success: int, skipped: int, failed: int) -> None:
	if not _have_console():
		parts = [f"{success} generated"]
		if skipped:
			parts.append(f"{skipped} skipped")
		if failed:
			parts.append(f"{failed} failed")
		print("Summary: " + ", ".join(parts))
		return
	parts: List[str] = [f"[ok]{success} generated[/ok]"]
	if skipped:
		parts.append(f"[warn]{skipped} skipped[/warn]")
	if failed:
		parts.append(f"[err]{failed} failed[/err]")
	console.print("Summary: " + ", ".join(parts))  # type: ignore[arg-type]


# ----------------------------- LeetCode config ------------------------------

LEETCODE_BASE = "https://leetcode.com"
GRAPHQL_URL = f"{LEETCODE_BASE}/graphql"
MAP_ALL_URL = f"{LEETCODE_BASE}/api/problems/all/"
CONTEST_LIST_URL = f"{LEETCODE_BASE}/contest/api/list/"
CONTEST_INFO_URL = f"{LEETCODE_BASE}/contest/api/info/{{slug}}"
CONTEST_PAGE_URL = f"{LEETCODE_BASE}/contest/{{slug}}/"

DIFFICULTY_COLOR = {
	"Beginner": '#70BAFF',
	"Easy": '#3BE38C',
	"Medium": '#E39A2D',
	"Hard": '#FF4800',
	"Master": '#FF0000',
	"Grandmaster": '#FB00FF',
}

CONTEST_MAP_CACHE = CACHE_DIR / "contest_map.json"
PROBLEM_MAP_CACHE = CACHE_DIR / "problems_all.json"

POTD_QUERY = """
query questionOfToday {
  activeDailyCodingChallengeQuestion {
	date
	link
	question {
	  questionFrontendId
	  titleSlug
	}
  }
}
"""

# ------------------------- Locks for thread safety --------------------------

_CONTEST_CACHE_LOCK = threading.Lock()


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


def headers_for_graphql(csrftoken: Optional[str], referer: Optional[str] = None) -> Dict[str, str]:
	headers = {
		"Content-Type": "application/json",
		"Origin": LEETCODE_BASE,
		"Referer": referer or LEETCODE_BASE,
		"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) 3C/ccc (+https://github.com/Macweese/3C)"
	}
	if csrftoken:
		headers["x-csrftoken"] = csrftoken
	return headers


def _problem_url(slug: str) -> str:
	return f"{LEETCODE_BASE}/problems/{slug}/"


def _ensure_session(cookies: Dict[str, str]) -> requests.Session:
	s = get_thread_session(cookies)
	s.headers.update({
		"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) 3C/ccc (+https://github.com/Macweese/3C)",
		"Accept": "application/json, text/plain, */*",
		"Accept-Language": "en-US,en;q=0.9",
	})
	return s


def _ensure_csrf(s: requests.Session, slug: Optional[str]) -> Optional[str]:
	cs = s.cookies.get("csrftoken")
	if cs:
		return cs
	try:
		url = _problem_url(slug) if slug else LEETCODE_BASE
		s.get(url, timeout=20)
		return s.cookies.get("csrftoken")
	except Exception:
		return None


def _post_graphql_with_retries(s: requests.Session, slug: str, payload: Dict[str, Any], max_attempts: int = 4,
							   debug: bool = False) -> Dict[str, Any]:
	backoffs = [0.8, 1.6, 3.2]
	last_exc: Optional[Exception] = None
	for attempt in range(1, max_attempts + 1):
		try:
			cs = _ensure_csrf(s, slug)
			headers = headers_for_graphql(cs, referer=_problem_url(slug))
			r = s.post(GRAPHQL_URL, headers=headers, json=payload, timeout=30)
			if debug:
				print_debug(f"GraphQL POST attempt {attempt}: status {r.status_code}")
			if 200 <= r.status_code < 300:
				data = r.json()
				if "errors" in data:
					raise requests.HTTPError(f"GraphQL errors: {data['errors']}", response=r)
				return data
			if r.status_code in (429, 499, 502, 503, 520, 522, 524, 403):
				if r.status_code in (403, 499):
					try:
						s.get(_problem_url(slug), timeout=20)
					except Exception:
						pass
				if attempt < max_attempts:
					sleep_for = backoffs[min(attempt - 1, len(backoffs) - 1)] * (0.7 + random.random() * 0.6)
					if debug:
						print_debug(f"Backing off {sleep_for:.2f}s due to {r.status_code}")
					time.sleep(sleep_for)
					continue
				r.raise_for_status()
			r.raise_for_status()
		except Exception as e:
			last_exc = e
			if debug:
				print_debug(f"Exception on attempt {attempt}: {e}")
			if attempt < max_attempts:
				sleep_for = backoffs[min(attempt - 1, len(backoffs) - 1)] * (0.7 + random.random() * 0.6)
				time.sleep(sleep_for)
				continue
			raise
	if last_exc:
		raise last_exc
	raise RuntimeError("Unknown GraphQL retry failure")


def query_graphql(slug: str, cookies: Dict[str, str], debug: bool = False) -> Dict[str, Any]:
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
	s = _ensure_session(cookies)
	data = _post_graphql_with_retries(s, slug, payload, debug=debug)
	return data["data"]["question"]


def fetch_potd_slug(cookies: Dict[str, str], debug: bool = False) -> Tuple[str, Dict[str, str]]:
	s = _ensure_session(cookies)
	cs = _ensure_csrf(s, slug=None)
	headers = headers_for_graphql(cs, referer=LEETCODE_BASE)
	payload = {
		"operationName": "questionOfToday",
		"variables": {},
		"query": POTD_QUERY,
	}
	r = s.post(GRAPHQL_URL, headers=headers, json=payload, timeout=30)
	if debug:
		print_debug(f"POTD GraphQL status: {r.status_code}")
	r.raise_for_status()
	body = r.json()
	active = (body.get("data") or {}).get("activeDailyCodingChallengeQuestion")
	if not active:
		raise RuntimeError("LeetCode POTD not available (no activeDailyCodingChallengeQuestion).")

	date_str = active.get("date")
	q = active.get("question") or {}
	slug = q.get("titleSlug")
	if not slug:
		raise RuntimeError("LeetCode POTD missing titleSlug in response.")

	try:
		dt_obj = dt.datetime.strptime(date_str, "%Y-%m-%d").replace(tzinfo=dt.timezone.utc)
	except Exception:
		dt_obj = dt.datetime.now(dt.timezone.utc)

	potd_date = {
		"iso": dt_obj.strftime("%Y-%m-%d"),
		"day": dt_obj.strftime("%d"),
		"month": dt_obj.strftime("%m"),
		"year": dt_obj.strftime("%Y"),
		"weekday_short": dt_obj.strftime("%a"),
		"month_full": dt_obj.strftime("%B"),
	}
	return slug, potd_date


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
		return [{
			"title": item.get("title", ""),
			"slug": item.get("titleSlug", ""),
			"difficulty": item.get("difficulty", ""),
		} for item in arr]
	except Exception:
		return []


def format_today_utc() -> Dict[str, str]:
	now = dt.datetime.now(dt.timezone.utc)
	return {
		"iso": now.strftime("%Y-%m-%d"),
		"day": now.strftime("%d"),
		"month": now.strftime("%m"),
		"year": now.strftime("%Y"),
		"weekday_short": now.strftime("%a"),
		"month_full": now.strftime("%B"),
	}


def ensure_dir(p: Path) -> None:
	p.mkdir(parents=True, exist_ok=True)


# ---------------------- Contest tag detection (cached) ----------------------

def _load_contest_map_cache() -> Dict[str, Any]:
	if CONTEST_MAP_CACHE.exists():
		try:
			with _CONTEST_CACHE_LOCK:
				return json.loads(CONTEST_MAP_CACHE.read_text(encoding="utf-8"))
		except Exception:
			return {}
	return {}


def _save_contest_map_cache(data: Dict[str, Any]) -> None:
	with _CONTEST_CACHE_LOCK:
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
	for c in _fetch_contest_list():
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

def enrich_similar_with_ids(similar: List[Dict[str, str]], cookies: Dict[str, str], debug: bool = False) -> List[
	Dict[str, str]]:
	out = []
	for s in similar:
		slug = s.get("slug") or ""
		fid = get_id_from_slug(slug)
		if not fid:
			try:
				sq = query_graphql(slug, cookies, debug=debug)
				fid = sq.get("questionFrontendId")
			except Exception:
				fid = None
		out.append({"title": s.get("title", ""), "slug": slug, "id": str(fid) if fid else ""})
	return out


# ---------------- Parsing description / examples / constraints ---------------

EX_HEADER_TEXT_RE = re.compile(r"^\s*Example(?:\s*\d+)?\s*:?\s*$", re.IGNORECASE)


def _is_nbsp_paragraph(tag: Tag) -> bool:
	return isinstance(tag, Tag) and tag.name == "p" and (tag.get_text().strip() in {"\xa0", ""})


def _is_example_header_p(tag: Tag) -> bool:
	if not isinstance(tag, Tag) or tag.name != "p":
		return False
	strong = tag.find("strong")
	if not strong:
		return False
	txt = strong.get_text(strip=True)
	return re.match(r"^\s*Example(?:\s*\d+)?\s*:?\s*$", txt, flags=re.IGNORECASE) is not None


def _extract_label_content_from_html(html: str, label: str) -> Optional[str]:
	pattern = re.compile(
		r'(?is)(?:<(?:strong|b)[^>]*>)\s*' + re.escape(
			label) + r'\s*:?\s*</(?:strong|b)>\s*(.*?)(?=(?:<(?:strong|b)[^>]*>)\s*(?:Input|Output|Explanation)\s*:?\s*</(?:strong|b)>|$)'
	)
	m = pattern.search(html)
	return m.group(1).strip() if m and m.group(1).strip() else None


def _find_constraints_header(container: Tag) -> Optional[Tag]:
	for p in container.find_all("p"):
		strong = p.find("strong")
		if strong and strong.get_text(strip=True).lower().startswith("constraints"):
			return p
	return None


def _parse_by_nbsp_and_example_blocks(content_html: str) -> Tuple[str, List[Dict[str, Any]], str]:
	soup = BeautifulSoup(content_html, "html.parser")
	container = soup.find("div", class_="elfjS") or soup
	children: List[Tag] = [c for c in container.children if isinstance(c, Tag)]

	first_nbsp_idx = next((i for i, t in enumerate(children) if _is_nbsp_paragraph(t)), None)
	if first_nbsp_idx is None:
		first_example_idx = next((i for i, t in enumerate(children) if _is_example_header_p(t)), None)
		if first_example_idx is None:
			return (container.decode_contents().strip(), [], "")
		desc_nodes = children[:first_example_idx]
		rest_nodes = children[first_example_idx:]
	else:
		desc_nodes = children[:first_nbsp_idx]
		rest_nodes = children[first_nbsp_idx + 1:]

	def collect_example_segment(nodes: List[Tag], start_idx: int) -> Tuple[List[Tag], int]:
		seg: List[Tag] = []
		j = start_idx + 1
		while j < len(nodes):
			cand = nodes[j]
			if _is_nbsp_paragraph(cand): break
			if _is_example_header_p(cand): break
			strong = cand.find("strong") if isinstance(cand, Tag) else None
			if strong and strong.get_text(strip=True).lower().startswith("constraints"): break
			seg.append(cand)
			j += 1
		return seg, j

	def extract_from_block_html(block_html: str) -> Tuple[List[str], Optional[str], Optional[str], Optional[str]]:
		bs = BeautifulSoup(block_html, "html.parser")
		imgs = [str(img) for img in bs.find_all("img")]
		in_html = out_html = exp_html = None

		def find_labeled_p(prefix: str) -> Optional[Tag]:
			for p in bs.find_all("p"):
				s = p.find("strong")
				if s and s.get_text(strip=True).lower().startswith(prefix):
					return p
			return None

		p_input = find_labeled_p("input")
		if p_input: in_html = _extract_after_strong_html(p_input)
		p_output = find_labeled_p("output")
		if p_output: out_html = _extract_after_strong_html(p_output)

		p_expl_label = find_labeled_p("explanation")
		if p_expl_label:
			exp_parts: List[str] = []
			for sib in p_expl_label.next_siblings:
				if isinstance(sib, Tag):
					sstrong = sib.find("strong")
					if sstrong and re.match(r"^\s*(input|output|explanation)\s*:?\s*$", sstrong.get_text(strip=True),
											flags=re.IGNORECASE):
						break
					exp_parts.append(str(sib))
				elif isinstance(sib, NavigableString):
					if str(sib).strip():
						exp_parts.append(str(sib))
			if exp_parts:
				exp_html = "".join(exp_parts).strip()

		if in_html is None or out_html is None or exp_html is None:
			pre = bs.find("pre")
			if pre:
				pre_inner = pre.decode_contents()
				in_html = in_html or _extract_label_content_from_html(pre_inner, "Input")
				out_html = out_html or _extract_label_content_from_html(pre_inner, "Output")
				exp_html = exp_html or _extract_label_content_from_html(pre_inner, "Explanation")

		return imgs, in_html, out_html, exp_html

	def _extract_after_strong_html(p_tag: Tag) -> str:
		clone = BeautifulSoup(str(p_tag), "html.parser").p
		if not clone: return ""
		strong = clone.find("strong")
		if strong: strong.decompose()
		return clone.decode_contents().strip()

	examples: List[Dict[str, Any]] = []
	i = 0
	while i < len(rest_nodes):
		node = rest_nodes[i]
		if _is_nbsp_paragraph(node):
			i += 1
			break
		if _is_example_header_p(node):
			ex_header = node
			segment_nodes, j = collect_example_segment(rest_nodes, i)
			ex_block = None
			for sn in segment_nodes:
				if isinstance(sn, Tag) and sn.name == "div" and "example-block" in (sn.get("class") or []):
					ex_block = sn
					break
			number = re.search(r"Example\s*(\d+)", ex_header.get_text(strip=True), flags=re.IGNORECASE)
			number = number.group(1) if number else "1"
			block_html = str(ex_block) if ex_block is not None else "".join(str(n) for n in segment_nodes).strip()
			imgs, in_html, out_html, exp_html = extract_from_block_html(block_html)
			examples.append({
				"number": number,
				"images_html": imgs,
				"input_html": in_html,
				"output_html": out_html,
				"explanation_html": exp_html,
				"raw_html": block_html or str(ex_header),
			})
			i = j
			continue
		strong = node.find("strong") if isinstance(node, Tag) else None
		if strong and strong.get_text(strip=True).lower().startswith("constraints"):
			break
		i += 1

	constraints_html = ""
	constraints_p = _find_constraints_header(container)
	if constraints_p:
		list_tag = constraints_p.find_next(lambda t: isinstance(t, Tag) and t.name in ("ul", "ol"))
		if list_tag:
			constraints_html = str(list_tag).strip()

	description_html = "".join(
		str(n) for n in (children[:first_nbsp_idx] if first_nbsp_idx is not None else children)).strip()
	return description_html, examples, constraints_html


def split_desc_examples_constraints(content_html: str) -> Tuple[str, List[Dict[str, Any]], str]:
	if not content_html:
		return "", [], ""
	try:
		desc_html, examples, constraints_html = _parse_by_nbsp_and_example_blocks(content_html)
		if examples or constraints_html:
			return desc_html, examples, constraints_html
	except Exception:
		pass
	return content_html, [], ""


def expand_problem_inputs(inputs: Iterable[str]) -> List[str]:
	out: List[str] = []
	for token in inputs:
		t = token.strip()
		m = re.fullmatch(r"(\d+)\s*-\s*(\d+)", t)
		if m:
			a, b = int(m.group(1)), int(m.group(2))
			if a > b: a, b = b, a
			if (b - a) > 2000:
				raise ValueError(f"Range too large: {t}")
			out.extend(str(n) for n in range(a, b + 1))
		else:
			out.append(t)
	return out


# ---------------------------- Generation routine ----------------------------

def generate_one(slug: str, args, cookies: Dict[str, str],
				 potd_date: Optional[Dict[str, str]] = None) -> Tuple[
	Optional[str], Optional[str], List[str], Optional[Path]]:
	q = query_graphql(slug, cookies, debug=args.debug)

	if q.get("isPaidOnly") and args.fail_on_paid:
		print_skip(f"Paid-only problem: {slug}")
		return None, None, [], None

	similar = parse_similar(q.get("similarQuestions"))
	similar_slugs = [s.get("slug") for s in similar if s.get("slug")]
	similar_enriched = enrich_similar_with_ids(similar, cookies, debug=args.debug) if similar else []

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
		desc_html, examples, constraints_html = content_html, [], ""
	else:
		try:
			desc_html, examples, constraints_html = split_desc_examples_constraints(content_html)
		except Exception:
			desc_html, examples, constraints_html = content_html, [], ""

	problem_id = q.get("questionFrontendId", "") or get_id_from_slug(slug) or ""
	title = q.get("title", "")
	difficulty = q.get("difficulty", "Easy")
	title_slug = q.get("titleSlug", slug)
	potd_ctx = potd_date if getattr(args, "potd", False) and potd_date else None

	context = {
		"question_id": problem_id,
		"question_title": title,
		"title_slug": title_slug,
		"difficulty": difficulty,
		"difficulty_color": difficulty_color(difficulty),
		"leetcode_url": f"{LEETCODE_BASE}/problems/{title_slug}/",
		"description_html": desc_html,
		"examples": examples,
		"constraints_html": constraints_html,
		"hints": q.get("hints", []) or [],
		"tags": tags,
		"similar": similar_enriched,
		"potd": potd_ctx,
	}

	out_root_str = args.out_dir if (args.out_dir is not None and str(args.out_dir).strip() != "") else (
			DEFAULT_OUT_DIR or ".")
	try:
		out_root = Path(out_root_str).expanduser().resolve()
	except Exception:
		out_root = Path.cwd()

	env_layout = (os.environ.get("3C_LAYOUT") or "").strip()
	layout = args.layout
	if args.mode == "flat" and not env_layout:
		layout = "source-id"

	source_code = "LeetCode"
	out_dir = compute_output_dir(
		out_root=out_root,
		source=source_code,
		difficulty=difficulty,
		pid=str(problem_id),
		slug=title_slug,
		layout=layout,
		namefmt=args.namefmt,
		include_id_subdir=not args.no_id_subdir,
	)
	ensure_dir(out_dir)
	out_file = out_dir / args.filename

	if args.debug:
		print_debug(f"resolved out_root: {out_root}")
		print_debug(f"args.mode: {args.mode}")
		print_debug(f"selected layout: {layout}")
		print_debug(f"namefmt: {args.namefmt}")
		print_debug(f"include_id_subdir: {not args.no_id_subdir}")
		print_debug(f"computed out_dir: {out_dir}")
		print_debug(f"output file: {out_file}")

	# Overwrite / dry-run logic
	decision: FileDecision = decide_file(
		out_file,
		force=getattr(args, "force", False),
		no_overwrite=getattr(args, "no_overwrite", False),
		dry_run=getattr(args, "dry_run", False),
	)
	if not decision.should_write:
		reason = decision.reason
		if reason == "dry-run":
			print_skip(f"[dry-run] Would write {style_path(out_file, base=out_root)} — {problem_id}. {title} [{difficulty}]")
		elif reason == "exists-no-overwrite":
			print_skip(f"Exists, skipping (no-overwrite): {style_path(out_file, base=out_root)}")
		else:
			print_skip(f"Skipped writing {style_path(out_file, base=out_root)} (reason={reason})")
		return str(problem_id) if problem_id else None, title, [s for s in similar_slugs if s], None

	template_path = Path(args.template)
	env = Environment(
		loader=FileSystemLoader(str(template_path.parent)),
		autoescape=select_autoescape(enabled_extensions=("html", "xml", "md", "j2"))
	)
	template = env.get_template(template_path.name)
	rendered = template.render(**context)

	out_file.write_text(rendered, encoding="utf-8")
	print_success_wrote(out_file, str(problem_id), title, difficulty, out_root)

	return str(problem_id) if problem_id else None, title, [s for s in similar_slugs if s], out_file


def run_with_args(args) -> int:
	success_count = skip_count = fail_count = 0
	cookies = load_env_cookie()

	potd_date: Optional[Dict[str, str]] = None
	if getattr(args, "potd", False):
		try:
			slug, potd_date = fetch_potd_slug(cookies, debug=args.debug)
			items = [slug]
		except Exception as e:
			print_error(f"Failed to fetch LeetCode POTD: {e}")
			return 1
	else:
		try:
			items = expand_problem_inputs(args.problems)
		except Exception as e:
			print_error(str(e))
			return 1

	queue: List[str] = []
	seen: Set[str] = set()
	for it in items:
		try:
			slug = extract_slug_from_input(it)
			if slug not in seen:
				seen.add(slug)
				queue.append(slug)
		except Exception as e:
			skip_count += 1
			print_skip(f"Input '{it}' ignored: {e}")

	last_written: Optional[Path] = None
	to_add_similar: Set[str] = set()

	def _process_slug(slug: str, potd_ctx: Optional[Dict[str, str]]):
		try:
			pid, title, similar_slugs, written = generate_one(slug, args, cookies, potd_date=potd_ctx)
			return (slug, pid, title, similar_slugs, written, None)
		except Exception as ex:
			return (slug, None, None, [], None, ex)

	jobs = getattr(args, "jobs", 1)
	if jobs > 1 and len(queue) > 1:
		with ThreadPoolExecutor(max_workers=jobs) as pool:
			futures = [pool.submit(_process_slug, slug, potd_date) for slug in queue]
			for fut in as_completed(futures):
				slug, pid, title, similar_slugs, written, exc = fut.result()
				if exc:
					fail_count += 1
					print_error(f"Failed to generate for '{slug}': {exc}")
					continue
				if written:
					last_written = written
					success_count += 1
				else:
					skip_count += 1
				if getattr(args, "also_similar", False):
					for s in similar_slugs:
						if s and s not in seen:
							seen.add(s)
							to_add_similar.add(s)
	else:
		while queue:
			slug = queue.pop(0)
			slug_result = _process_slug(slug, potd_date)
			_, pid, title, similar_slugs, written, exc = slug_result
			if exc:
				fail_count += 1
				print_error(f"Failed to generate for '{slug}': {exc}")
				continue
			if written:
				last_written = written
				success_count += 1
			else:
				skip_count += 1
			if getattr(args, "also_similar", False):
				for s in similar_slugs:
					if s and s not in seen:
						seen.add(s)
						to_add_similar.add(s)

	if getattr(args, "also_similar", False) and to_add_similar:
		sims = list(to_add_similar)
		if jobs > 1 and len(sims) > 1:
			with ThreadPoolExecutor(max_workers=jobs) as pool:
				futures = [pool.submit(_process_slug, slug, None) for slug in sims]
				for fut in as_completed(futures):
					slug, pid, title, similar_slugs, written, exc = fut.result()
					if exc:
						fail_count += 1
						print_error(f"Failed to generate for similar '{slug}': {exc}")
						continue
					if written:
						last_written = written
						success_count += 1
					else:
						skip_count += 1
		else:
			for s in sims:
				slug, pid, title, similar_slugs, written, exc = _process_slug(s, None)
				if exc:
					fail_count += 1
					print_error(f"Failed to generate for similar '{s}': {exc}")
					continue
				if written:
					last_written = written
					success_count += 1
				else:
					skip_count += 1

	if getattr(args, "open", False) and last_written and sys.platform == "darwin":
		os.system(f'open "{last_written}"')
		print_opened(last_written, Path(args.out_dir or DEFAULT_OUT_DIR).expanduser().resolve())

	print_summary(success_count, skip_count, fail_count)
	return 0


class LeetCodeProvider(Provider):
	name = "lc"

	@classmethod
	def register(cls, subparsers, parents=None):
		if parents is None:
			parents = []

		p = subparsers.add_parser(
			"lc",
			aliases=["leetcode"],
			help="LeetCode README generator",
			description="Generate LeetCode README.md files.",
			parents=parents,
		)

		p.add_argument(
			"problems",
			nargs="*",
			help="One or more problems (URL, slug, number, or numeric range like 40-50)",
		)
		p.add_argument(
			"--potd",
			action="store_true",
			help="Generate README for today's LeetCode Problem of the Day",
		)
		p.add_argument("--out-dir", default=DEFAULT_OUT_DIR,
					   help="Base output directory (default: current directory or $3C_OUT_DIR if set)")
		p.add_argument("--mode", choices=["flat", "by-difficulty"], default="by-difficulty",
					   help="Legacy layout: flat (by source) or by-difficulty (tiered).")
		p.add_argument("--layout",
					   choices=["source-difficulty-id", "difficulty-source-id", "source-id", "flat"],
					   default=DEFAULT_LAYOUT,
					   help="Folder layout (default: source-difficulty-id or $3C_LAYOUT)")
		p.add_argument("--namefmt",
					   default=DEFAULT_NAMEFMT,
					   help="Leaf directory name format (default: {id}; examples: {id}-{slug}, {source}-{id})")

		p.add_argument("--filename", default="README.md", help="Output filename (default: README.md)")

		default_template = Path(__file__).resolve().parents[1] / "templates" / "leetcode_readme.md.j2"
		p.add_argument("--template", default=str(default_template),
					   help="Path to Jinja2 template file")

		p.add_argument("--fail-on-paid", action="store_true", help="Fail/skip if the question is paid-only")
		p.add_argument("--no-normalize-examples", action="store_true",
					   help="Do not reformat examples; embed raw content")
		p.add_argument("--no-contest-tag", action="store_true", help="Disable contest tag lookup")
		p.add_argument("--no-id-subdir", action="store_true",
					   help="Do not create a per-problem-id directory; write directly into the difficulty or base directory")
		p.add_argument("--also-similar", action="store_true",
					   help="Also generate READMEs for all 'Similar' problems of each specified problem (one level)")
		p.add_argument("--open", action="store_true", help="Open the last output file after generation (macOS only)")

		default_jobs = int(os.environ.get("3C_JOBS", "1"))
		p.add_argument("-j", "--jobs", type=int, default=default_jobs,
					   help=f"Parallel jobs (threads) for fetching/rendering (default: {default_jobs}; set 3C_JOBS). "
							f"Use 1 for sequential. Keep modest (e.g. 4-8) to avoid rate limits.")

		# Overwrite / dry-run flags
		add_overwrite_arguments(p)

		p.set_defaults(provider_name=cls.name, provider_cls=cls)

	def run(self, args, ctx: ProviderContext) -> int:
		# args.debug comes from global flags; ensure it's set
		if not hasattr(args, "debug"):
			setattr(args, "debug", ctx.debug)
		return run_with_args(args)
