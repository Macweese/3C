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
"""
Codeforces provider.

The official API (https://codeforces.com/apiHelp) exposes problem metadata
but not statements, so:

- statements, limits, rating and tags are scraped from the problem page
  https://codeforces.com/contest/<id>/problem/<index>  (or /gym/...);
- the problems of a contest are read from the contest page's problems table;
- API metadata (problemset.problems, cached for a day) is the fallback below.

Problem pages sit behind an anti-bot service that sometimes answers with a
challenge. That is never bypassed: the README is then generated from API
metadata only, with a note that the statement is missing.
"""

from __future__ import annotations

import re
from typing import Any, Dict, Hashable, List, Optional, Sequence, Tuple

from bs4 import NavigableString, Tag

from ..core import cache, http
from ..core.markup import clean_html, parse_html, text_of
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://codeforces.com"
API = f"{BASE}/api"
GYM_MIN_ID = 100000  # contest ids from here on are gyms
INDEX_CACHE = "codeforces_problems.json"

_PROBLEM_URL_RE = re.compile(
	r"codeforces\.com/(?:(problemset)/problem/(\d+)/(\w+)|(contest|gym)/(\d+)/problem/(\w+))", re.IGNORECASE)
_CONTEST_URL_RE = re.compile(r"codeforces\.com/(contest|gym)/(\d+)", re.IGNORECASE)
_PROBLEM_RE = re.compile(r"^(\d+)[/\-]?([A-Za-z]\d{0,2})$")
_TITLE_INDEX_RE = re.compile(r"^\S+\.\s+")

# Codeforces' own inline styling classes -> semantic tags.
_STYLE_TAGS = {"tex-font-style-tt": "code", "tex-font-style-bf": "b", "tex-font-style-it": "i"}

Ref = Tuple[str, int, str]  # ("contest" | "gym", contest id, problem index)


def _kind(contest_id: int) -> str:
	return "gym" if contest_id >= GYM_MIN_ID else "contest"


def parse_input(token: str) -> Tuple[str, int, Optional[str]]:
	"""Classify an input as (kind, contest id, index); index None means the whole contest."""
	m = _PROBLEM_URL_RE.search(token)
	if m:
		if m.group(1):
			return "contest", int(m.group(2)), m.group(3).upper()
		return m.group(4).lower(), int(m.group(5)), m.group(6).upper()
	m = _CONTEST_URL_RE.search(token)
	if m:
		return m.group(1).lower(), int(m.group(2)), None
	m = _PROBLEM_RE.match(token)
	if m:
		cid = int(m.group(1))
		return _kind(cid), cid, m.group(2).upper()
	if token.isdigit():
		return _kind(int(token)), int(token), None
	raise ValueError("expected a problem (1850A, 1850/A), a contest id (1850) or a codeforces.com URL")


def problem_url(ref: Ref) -> str:
	kind, cid, index = ref
	return f"{BASE}/{kind}/{cid}/problem/{index}"


def contest_problems(kind: str, contest_id: int, ctx: ProviderContext) -> List[str]:
	"""Problem indexes of a contest, in order, from its problems table."""
	resp = http.get(f"{BASE}/{kind}/{contest_id}", debug=ctx.debug)
	link_re = re.compile(rf"/{kind}/{contest_id}/problem/(\w+)$")
	indexes: Dict[str, None] = {}  # ordered set; each problem is linked twice
	for a in parse_html(resp.text).select("table.problems a[href]"):
		m = link_re.search(a["href"])
		if m:
			indexes.setdefault(m.group(1))
	if not indexes:
		raise http.NotFoundError(f"{kind} {contest_id} does not exist or lists no problems")
	return list(indexes)


def _build_index(ctx: ProviderContext) -> Dict[str, List[Any]]:
	"""Compact projection of problemset.problems: {"<id><index>": [name, rating, tags]}."""
	resp = http.get(f"{API}/problemset.problems", debug=ctx.debug, timeout=60)
	try:
		data = resp.json()
	except ValueError:
		raise http.FetchError("Codeforces API returned a non-JSON answer")
	if data.get("status") != "OK":
		raise http.FetchError(f"Codeforces API: {data.get('comment', 'request failed')}")
	return {
		f"{p['contestId']}{p['index']}": [p.get("name", ""), p.get("rating"), p.get("tags", [])]
		for p in data["result"]["problems"]
		if "contestId" in p
	}


def _flatten_sample(pre: Tag) -> None:
	"""Samples are either plain text, <br>-separated, or one <div> per line."""
	lines = pre.find_all("div", recursive=False)
	if lines:
		text = "\n".join(line.get_text() for line in lines)
	else:
		for br in pre.find_all("br"):
			br.replace_with("\n")
		text = pre.get_text()
	pre.clear()
	pre.append(NavigableString(text.strip("\n") + "\n"))


def parse_problem_page(html: str, url: str) -> Tuple[str, str, Optional[str], List[Tuple[str, str]], List[str]]:
	"""Return (title, cleaned statement HTML, rating, meta, tags)."""
	soup = parse_html(html)
	statement = soup.select_one(".problem-statement")
	header = statement.select_one(".header") if statement is not None else None
	if header is None:
		raise http.FetchError("page has no HTML statement (PDF-only or restricted problem)")

	title = text_of(header.select_one(".title"))
	meta: List[Tuple[str, str]] = []
	for css, label in ((".time-limit", "Time limit"), (".memory-limit", "Memory limit"),
					   (".input-file", "Input"), (".output-file", "Output")):
		node = header.select_one(css)
		if node is not None:
			# The value is the node's own text; the nested div is its caption.
			value = " ".join("".join(node.find_all(string=True, recursive=False)).split())
			if value:
				meta.append((label, value))
	header.decompose()

	for node in statement.select(".section-title"):
		node.name = "h3"
	for node in statement.select(".sample-test .title"):
		node.name = "h4"
	for pre in statement.select(".sample-test pre"):
		_flatten_sample(pre)
	for css_class, tag_name in _STYLE_TAGS.items():
		for node in statement.select(f"span.{css_class}"):
			node.name = tag_name

	# Codeforces delimits MathJax with $$$...$$$; GitHub expects $...$.
	body = clean_html(statement, url).replace("$$$", "$")

	rating = None
	tags: List[str] = []
	for box in soup.select(".tag-box"):
		text = text_of(box)
		if text.startswith("*"):
			rating = text.lstrip("*") or None
		elif text:
			tags.append(text)
	return title, body, rating, meta, tags


class CodeforcesProvider(StatementProvider):
	name = "cf"
	aliases = ("codeforces",)
	source = "Codeforces"
	display_name = "Codeforces"
	input_help = "Problem(s) (1850A, 1850/A), contest id(s) for every problem (1850), or codeforces.com URL(s)."
	examples = (
		"3c cf 1850A",
		"3c cf 1850 -j 2",
		"3c cf https://codeforces.com/problemset/problem/4/A",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		kind, cid, index = parse_input(token)
		if index is not None:
			return [(kind, cid, index)]
		return [(kind, cid, i) for i in contest_problems(kind, cid, ctx)]

	def describe(self, ref: Hashable) -> str:
		return f"{ref[1]}{ref[2]}"

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		kind, cid, index = ref
		url = problem_url(ref)
		pid = f"{cid}{index}"
		try:
			resp = http.get(url, debug=ctx.debug)
		except http.BlockedError as blocked:
			return self._from_api(pid, url, blocked, args, ctx)
		if f"/problem/{index}".lower() not in resp.url.lower():
			# Unknown problems redirect to the contest (or elsewhere) instead of 404.
			raise http.NotFoundError(f"problem {pid} does not exist or has no HTML statement")

		title, body, rating, meta, tags = parse_problem_page(resp.text, url)
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=pid,
			title=_TITLE_INDEX_RE.sub("", title) or title,
			heading=f"{cid}{title}" if title.startswith(index + ".") else title,
			url=url,
			body=body,
			difficulty=rating,
			meta=meta,
			tags=tags,
		)

	def _from_api(self, pid: str, url: str, blocked: http.BlockedError, args, ctx: ProviderContext) -> Problem:
		"""Metadata-only fallback for when the problem page is not served."""
		try:
			index = cache.cached(INDEX_CACHE, lambda: _build_index(ctx), refresh=args.refresh)
		except http.FetchError:
			raise blocked
		entry = index.get(pid)
		if entry is None:
			raise blocked  # gym or unlisted problem: nothing to fall back on
		name, rating, tags = entry
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=pid,
			title=name or pid,
			heading=f"{pid}. {name}".rstrip(". "),
			url=url,
			body="",
			difficulty=str(rating) if rating else None,
			tags=list(tags),
			notice=("The statement could not be downloaded because Codeforces answered with an anti-bot "
					"challenge; only API metadata is included. Re-run later with `--force` to complete it."),
		)
