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
Project Euler provider.

Data comes from the site's documented "minimal" endpoints:

- https://projecteuler.net/minimal=<n>        statement of problem n (HTML)
- https://projecteuler.net/minimal=problems   index: id, title, published, solved-by
"""

from __future__ import annotations

import re
from typing import Dict, Hashable, List, Sequence

from ..core import cache, http
from ..core.markup import clean_html
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://projecteuler.net"
INDEX_URL = f"{BASE}/minimal=problems"
INDEX_CACHE = "projecteuler_problems.json"
MAX_RANGE = 1000  # guards against typos such as 1-100000

_URL_RE = re.compile(r"projecteuler\.net/(?:problem=|minimal=)(\d+)", re.IGNORECASE)
_RANGE_RE = re.compile(r"^(\d+)\s*(?:-|\.\.)\s*(\d+)$")
_NOT_FOUND_MARKER = "cannot be found"


def parse_input(token: str) -> List[int]:
	"""'12', '10-20' or a problem URL -> problem numbers."""
	m = _URL_RE.search(token)
	if m:
		return [int(m.group(1))]
	if token.isdigit():
		return [int(token)]
	m = _RANGE_RE.match(token)
	if m:
		lo, hi = sorted((int(m.group(1)), int(m.group(2))))
		if hi - lo >= MAX_RANGE:
			raise ValueError(f"range spans more than {MAX_RANGE} problems")
		return list(range(lo, hi + 1))
	raise ValueError("expected a problem number, a range (e.g. 1-10) or a projecteuler.net URL")


def parse_index(text: str) -> Dict[str, List[str]]:
	"""Parse the '##'-separated index into {id: [title, published, solved_by]}."""
	index: Dict[str, List[str]] = {}
	for line in text.splitlines()[1:]:
		parts = line.split("##")
		if len(parts) >= 4 and parts[0].isdigit():
			index[parts[0]] = [parts[1], parts[2], parts[3]]
	return index


def load_index(ctx: ProviderContext, refresh: bool = False) -> Dict[str, List[str]]:
	return cache.cached(INDEX_CACHE, lambda: parse_index(http.get(INDEX_URL, debug=ctx.debug).text), refresh=refresh)


class ProjectEulerProvider(StatementProvider):
	name = "pe"
	aliases = ("euler", "projecteuler")
	source = "ProjectEuler"
	display_name = "Project Euler"
	input_help = "Problem number(s), inclusive range(s) such as 1-10, or problem URL(s)."
	examples = (
		"3c pe 1",
		"3c pe 1-25 -j 4",
		"3c pe https://projecteuler.net/problem=96",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		return parse_input(token)

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		number = str(ref)
		html = http.get(f"{BASE}/minimal={number}", debug=ctx.debug).text
		if len(html) < 200 and _NOT_FOUND_MARKER in html:
			raise http.NotFoundError(f"problem {number} does not exist (or is not published yet)")

		index = load_index(ctx, refresh=args.refresh)
		if number not in index and not args.refresh:
			index = load_index(ctx, refresh=True)  # published after the index was cached
		title, published, solved_by = index.get(number, [f"Problem {number}", "", ""])

		meta = []
		if published:
			meta.append(("Published", published.split(" ")[0]))
		if solved_by:
			meta.append(("Solved by", solved_by))
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=number,
			title=title,
			heading=f"{number}. {title}",
			url=f"{BASE}/problem={number}",
			body=clean_html(html, f"{BASE}/"),
			meta=meta,
		)
