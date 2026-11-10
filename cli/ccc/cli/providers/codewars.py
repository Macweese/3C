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
Codewars provider.

Uses the public REST API (https://dev.codewars.com/#get-code-challenge):

    GET https://www.codewars.com/api/v1/code-challenges/<id-or-slug>

Descriptions are Markdown and are embedded unchanged.
"""

from __future__ import annotations

import re
from typing import Hashable, List, Sequence, Tuple
from urllib.parse import quote

from ..core import http
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://www.codewars.com"
API = f"{BASE}/api/v1/code-challenges"
MAX_LANGUAGES = 12  # some kata list 50+ languages; keep the table readable

_URL_RE = re.compile(r"codewars\.com/kata/([^/?#\s]+)", re.IGNORECASE)
_ID_RE = re.compile(r"^[\w.~%-]+$")


def parse_input(token: str) -> str:
	"""Kata URL, id or slug -> the id/slug the API accepts."""
	m = _URL_RE.search(token)
	if m:
		return m.group(1)
	if token and _ID_RE.match(token):
		return token
	raise ValueError("expected a kata id, slug (valid-braces) or codewars.com/kata URL")


class CodewarsProvider(StatementProvider):
	name = "cw"
	aliases = ("codewars",)
	source = "Codewars"
	display_name = "Codewars"
	input_help = "Kata slug(s) (valid-braces), id(s) or codewars.com/kata URL(s)."
	examples = (
		"3c cw valid-braces",
		"3c cw https://www.codewars.com/kata/5277c8a221e209d3f6000b56",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		return [parse_input(token)]

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		try:
			kata = http.get(f"{API}/{quote(str(ref), safe='')}", debug=ctx.debug).json()
		except ValueError:
			raise http.FetchError("Codewars API returned a non-JSON answer")

		rank = (kata.get("rank") or {}).get("name")  # None for beta kata
		meta: List[Tuple[str, str]] = []
		if kata.get("category"):
			meta.append(("Category", str(kata["category"])))
		languages = kata.get("languages") or []
		if languages:
			shown = ", ".join(languages[:MAX_LANGUAGES])
			extra = len(languages) - MAX_LANGUAGES
			meta.append(("Languages", f"{shown} (+{extra} more)" if extra > 0 else shown))
		if kata.get("totalAttempts"):
			meta.append(("Completed / attempts", f"{kata.get('totalCompleted', 0)} / {kata['totalAttempts']}"))
		author = (kata.get("createdBy") or {}).get("username")
		if author:
			meta.append(("Author", author))

		slug = kata.get("slug") or str(ref)
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=slug,
			slug=slug,
			title=kata.get("name") or slug,
			url=kata.get("url") or f"{BASE}/kata/{kata.get('id', ref)}",
			body=(kata.get("description") or "").strip(),
			difficulty=rank,
			meta=meta,
			tags=list(kata.get("tags") or []),
		)
