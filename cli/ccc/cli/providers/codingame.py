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
CodinGame provider.

CodinGame has no documented public API; the site's own JSON service is used,
the same call the puzzle page makes anonymously:

    POST https://www.codingame.com/services/Puzzle/findProgressByPrettyId
    body: ["<pretty-id>", null]

It answers `null` for unknown puzzles.
"""

from __future__ import annotations

import re
from typing import Any, Dict, Hashable, Iterable, List, Sequence, Tuple

from ..core import http
from ..core.markup import clean_html
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://www.codingame.com"
SERVICE = f"{BASE}/services/Puzzle/findProgressByPrettyId"

_URL_RE = re.compile(
	r"codingame\.com/(?:training/[\w-]+|ide/puzzle|multiplayer/[\w-]+|contests)/([\w-]+)", re.IGNORECASE)
_ID_RE = re.compile(r"^[\w-]+$")


def parse_input(token: str) -> str:
	"""Puzzle URL or pretty id -> pretty id."""
	m = _URL_RE.search(token)
	if m:
		return m.group(1).lower()
	if _ID_RE.match(token):
		return token.lower()
	raise ValueError("expected a puzzle id (the-descent) or a codingame.com puzzle URL")


def flatten_topics(topics: Iterable[Dict[str, Any]]) -> List[str]:
	"""Depth-first list of topic names (parents before children), de-duplicated."""
	out: Dict[str, None] = {}
	stack = list(reversed(list(topics or [])))
	while stack:
		topic = stack.pop()
		if topic.get("value"):
			out.setdefault(topic["value"])
		stack.extend(reversed(topic.get("children") or []))
	return list(out)


class CodinGameProvider(StatementProvider):
	name = "codingame"
	aliases = ("cgame",)
	source = "CodinGame"
	display_name = "CodinGame"
	input_help = "Puzzle id(s) as in the puzzle URL (the-descent) or codingame.com puzzle URL(s)."
	examples = (
		"3c codingame the-descent",
		"3c cgame https://www.codingame.com/training/easy/ascii-art",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		return [parse_input(token)]

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		try:
			puzzle = http.post(SERVICE, json=[ref, None], debug=ctx.debug).json()
		except ValueError:
			raise http.FetchError("CodinGame service returned a non-JSON answer")
		if not isinstance(puzzle, dict):
			raise http.NotFoundError(f"puzzle '{ref}' does not exist")

		pretty_id = puzzle.get("prettyId") or str(ref)
		url = BASE + (puzzle.get("detailsPageUrl") or f"/training/{puzzle.get('level', 'easy')}/{pretty_id}")
		# Some puzzle kinds (e.g. bot programming) only carry a short description.
		statement = puzzle.get("statement") or puzzle.get("description") or ""
		body = clean_html(statement, url, drop_selectors=("#statement_back", ".icon"))

		meta: List[Tuple[str, str]] = []
		if puzzle.get("type"):
			meta.append(("Type", str(puzzle["type"]).replace("_", " ").title()))
		if puzzle.get("solvedCount") is not None:
			meta.append(("Solved by", str(puzzle["solvedCount"])))
		if puzzle.get("communityCreation"):
			meta.append(("Origin", "Community puzzle"))

		level = puzzle.get("level")
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=pretty_id,
			slug=pretty_id,
			title=puzzle.get("title") or pretty_id,
			url=url,
			body=body,
			difficulty=str(level).replace("-", " ").title() if level else None,
			meta=meta,
			tags=flatten_topics(puzzle.get("topics")),
		)
