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
Topcoder provider.

The classic problem archive is published as a static site:

- https://archive.topcoder.com/assets/problems.json                   index
- https://archive.topcoder.com/SRM/ProblemStatement/pm/<id>/index.html  statement

The index (id, name, round, topics) lets problems be addressed by class name.
"""

from __future__ import annotations

import difflib
import re
from typing import Dict, Hashable, List, Optional, Sequence, Tuple

from ..core import cache, http
from ..core.markup import clean_html, parse_html, text_of
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://archive.topcoder.com"
INDEX_URL = f"{BASE}/assets/problems.json"
INDEX_CACHE = "topcoder_problems.json"
WEEK = 7 * cache.DAY

# Archive URLs carry /pm/<id>/; legacy community URLs carry pm=<id>.
_URL_ID_RE = re.compile(r"topcoder\.com/\S*?(?:/pm/|[?&]pm=)(\d+)", re.IGNORECASE)
_NAME_RE = re.compile(r"^\w+$")
_LEVEL_RE = re.compile(r"\s*\(Level \d+\)")


def statement_url(problem_id: str) -> str:
	return f"{BASE}/SRM/ProblemStatement/pm/{problem_id}/index.html"


def _build_index(ctx: ProviderContext) -> Dict[str, str]:
	"""{lower-cased problem name: id}; on duplicate names the newest entry wins."""
	problems = http.get(INDEX_URL, debug=ctx.debug, timeout=60).json()
	index: Dict[str, str] = {}
	for p in problems:  # the index is ordered newest first
		index.setdefault(str(p.get("name", "")).lower(), str(p.get("id", "")))
	index.pop("", None)
	return index


def resolve(token: str, index_loader) -> str:
	"""Problem id, URL or class name -> problem id. `index_loader` is called lazily."""
	m = _URL_ID_RE.search(token)
	if m:
		return m.group(1)
	if token.isdigit():
		return token
	if not _NAME_RE.match(token):
		raise ValueError("expected a problem id (18236), a problem name (MinesweeperStrings) or a topcoder.com URL")
	index = index_loader()
	found = index.get(token.lower())
	if found:
		return found
	close = difflib.get_close_matches(token.lower(), index.keys(), n=3, cutoff=0.75)
	hint = f"; did you mean: {', '.join(close)}?" if close else ""
	raise ValueError(f"no archived problem is named '{token}'{hint}")


def parse_statement_page(html: str, url: str) -> Tuple[str, str, Optional[str], List[Tuple[str, str]], List[str], Optional[str]]:
	"""Return (title, cleaned statement HTML, difficulty, meta, topics, legal notice)."""
	soup = parse_html(html)
	article = soup.select_one("main article")
	if article is None:
		raise http.FetchError("page has no problem statement")
	title = text_of(soup.select_one(".hero h1")) or text_of(soup.title).split("|")[0].strip()

	meta: List[Tuple[str, str]] = []
	dates = [text_of(s) for s in soup.select(".hero-meta span:not(.track)")]
	rounds: List[str] = []
	difficulty = None
	for item in soup.select("aside .panel:not(.toc) > ul > li"):
		badges = [text_of(b) for b in item.select(".badge")]
		name = text_of(item.find("a")) or text_of(soup.select_one(".hero .eyebrow"))
		rounds.append(f"{name}: {', '.join(badges)}" if badges else name)
		if difficulty is None and badges:
			difficulty = _LEVEL_RE.sub("", badges[0]).replace("·", " ")
			difficulty = " ".join(difficulty.split())
	if rounds:
		meta.append(("Round", "; ".join(rounds)))
	if dates and dates[0]:
		meta.append(("Date", dates[0]))

	topics = [text_of(t) for t in soup.select("aside .topic-tags span")]
	legal = text_of(soup.select_one("p.legal")) or None
	return title, clean_html(article, url), difficulty, meta, [t for t in topics if t], legal


class TopcoderProvider(StatementProvider):
	name = "tc"
	aliases = ("topcoder",)
	source = "Topcoder"
	display_name = "Topcoder"
	input_help = "Problem id(s) (18236), problem class name(s) (MinesweeperStrings) or topcoder.com URL(s)."
	examples = (
		"3c tc MinesweeperStrings",
		"3c tc 18236",
		"3c tc https://archive.topcoder.com/SRM/ProblemStatement/pm/18236/index.html",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		loader = lambda: cache.cached(INDEX_CACHE, lambda: _build_index(ctx), max_age=WEEK, refresh=args.refresh)
		return [resolve(token, loader)]

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		pid = str(ref)
		url = statement_url(pid)
		title, body, difficulty, meta, topics, legal = parse_statement_page(http.get(url, debug=ctx.debug).text, url)
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=pid,
			title=title or pid,
			url=url,
			body=body,
			difficulty=difficulty,
			meta=meta,
			tags=topics,
			footer=legal,
		)
