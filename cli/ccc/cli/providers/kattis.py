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
Kattis provider.

Kattis has no statement API; the problem page is scraped:

    https://open.kattis.com/problems/<id>

Other Kattis instances (https://<name>.kattis.com) work through their URL.
"""

from __future__ import annotations

import re
from typing import Hashable, List, Optional, Sequence, Tuple

from ..core import http
from ..core.markup import clean_html, parse_html, text_of
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

DEFAULT_HOST = "open.kattis.com"

_URL_RE = re.compile(r"(?:https?://)?([\w-]+\.kattis\.com)/(?:contests/[\w-]+/)?problems/([\w.-]+)", re.IGNORECASE)
_ID_RE = re.compile(r"^[a-z0-9][a-z0-9.]*$")

# Metadata cards worth showing: CSS class -> label.
_CARDS = (
	("metadata-cpu-card", "CPU time limit"),
	("metadata-memory-card", "Memory limit"),
	("metadata-license-card", "Source & license"),
)

Ref = Tuple[str, str]  # (host, problem id)


def parse_input(token: str) -> Ref:
	m = _URL_RE.search(token)
	if m:
		return m.group(1).lower(), m.group(2).lower()
	if _ID_RE.match(token.lower()):
		return DEFAULT_HOST, token.lower()
	raise ValueError("expected a problem id (hello) or a kattis.com problem URL")


def parse_problem_page(html: str, url: str) -> Tuple[str, str, Optional[str], List[Tuple[str, str]]]:
	"""Return (title, cleaned statement HTML, difficulty tier, meta)."""
	soup = parse_html(html)
	statement = soup.select_one(".problembody")
	if statement is None:
		raise http.FetchError("page has no problem statement")
	title = text_of(soup.select_one("h1")) or text_of(soup.title)

	meta: List[Tuple[str, str]] = []
	for css, label in _CARDS:
		card = soup.select_one(f".{css}")
		if card is None:
			continue
		caption = card.select_one(".info_label")
		if caption is not None:
			caption.extract()
		value = text_of(card)
		if value:
			meta.append((label, value))

	tier = None
	card = soup.select_one(".metadata-difficulty-card")
	if card is not None:
		score = text_of(card.select_one(".difficulty_number"))
		caption = card.select_one(".info_label")
		tier = text_of(caption.find_next_sibling()) if caption is not None else ""
		tier = tier or None
		if score:
			meta.append(("Difficulty", f"{score} ({tier})" if tier else score))

	# Math is plain $...$ wrapped in a marker span; keep the TeX, drop the span.
	body = clean_html(statement, url, unwrap_selectors=("span.tex2jax_process",))
	return title, body, tier, meta


class KattisProvider(StatementProvider):
	name = "kt"
	aliases = ("kattis",)
	source = "Kattis"
	display_name = "Kattis"
	input_help = "Problem id(s) on open.kattis.com (hello) or kattis.com problem URL(s)."
	examples = (
		"3c kt hello",
		"3c kt https://open.kattis.com/problems/10kindsofpeople",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		return [parse_input(token)]

	def describe(self, ref: Hashable) -> str:
		return ref[1]

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		host, pid = ref
		url = f"https://{host}/problems/{pid}"
		title, body, tier, meta = parse_problem_page(http.get(url, debug=ctx.debug).text, url)
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=pid,
			slug=pid,
			title=title or pid,
			url=url,
			body=body,
			difficulty=tier,
			meta=meta,
		)
