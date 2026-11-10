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
SPOJ (Sphere Online Judge) provider.

SPOJ has no API; the problem page is scraped:

    https://www.spoj.com/problems/<CODE>/

The site is fronted by an anti-bot service that frequently answers automated
clients with a challenge. That is reported as an error and never bypassed.
"""

from __future__ import annotations

import re
from typing import Hashable, List, Sequence, Tuple

from ..core import http
from ..core.markup import clean_html, parse_html, text_of
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://www.spoj.com"

_URL_RE = re.compile(r"spoj\.com/(?:[A-Z0-9_]+/)?problems/([A-Za-z0-9_]+)", re.IGNORECASE)
_CODE_RE = re.compile(r"^[A-Za-z0-9_]+$")
_NAME_RE = re.compile(r"^(\S+)\s+-\s+(.+)$")

# Rows of the "problem-meta" table worth showing, in display order.
_META_LABELS = ("Time limit", "Source limit", "Memory limit", "Added by", "Date", "Resource")


def parse_input(token: str) -> str:
	"""Problem code or URL -> upper-case problem code."""
	m = _URL_RE.search(token)
	if m:
		return m.group(1).upper()
	if _CODE_RE.match(token):
		return token.upper()
	raise ValueError("expected a problem code (TEST) or a spoj.com problem URL")


def parse_problem_page(html: str, url: str, code: str) -> Tuple[str, str, List[Tuple[str, str]], List[str]]:
	"""Return (title, cleaned statement HTML, meta, tags)."""
	soup = parse_html(html)
	statement = soup.select_one("#problem-body")
	if statement is None:
		raise http.FetchError("page has no problem statement")

	name = text_of(soup.select_one("#problem-name"))
	m = _NAME_RE.match(name)  # "TEST - Life, the Universe, and Everything"
	title = m.group(2) if m else (name or code)

	rows = {}
	for row in soup.select("#problem-meta tr"):
		cells = row.find_all("td")
		if len(cells) >= 2:
			rows[text_of(cells[0]).rstrip(":")] = text_of(cells[1])
	meta = [(label, rows[label]) for label in _META_LABELS if rows.get(label)]

	tags = [text_of(a).lstrip("#") for a in soup.select("#problem-tags a")]
	return title, clean_html(statement, url), meta, [t for t in tags if t]


class SpojProvider(StatementProvider):
	name = "spoj"
	aliases = ("sp",)
	source = "SPOJ"
	display_name = "SPOJ"
	input_help = "Problem code(s) (TEST) or spoj.com problem URL(s)."
	examples = (
		"3c spoj TEST",
		"3c spoj https://www.spoj.com/problems/PRIME1/",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		return [parse_input(token)]

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		code = str(ref)
		url = f"{BASE}/problems/{code}/"
		title, body, meta, tags = parse_problem_page(http.get(url, debug=ctx.debug).text, url, code)
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=code,
			title=title,
			heading=f"{code} - {title}",
			url=url,
			body=body,
			meta=meta,
			tags=tags,
		)
