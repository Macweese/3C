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
HackerRank provider.

Uses the REST endpoint the site itself calls (no authentication required for
public challenges):

    GET https://www.hackerrank.com/rest/contests/<contest>/challenges/<slug>

The statement, input format, constraints and output format are available as
Markdown with `$...$` math and are embedded as such. Samples and their
explanations only exist in the pre-rendered `body_html`, where formulas are
SVG glyph outlines without any TeX source; those formulas cannot be recovered
and are shown as a placeholder.
"""

from __future__ import annotations

import re
from typing import Any, Dict, Hashable, List, Sequence, Tuple

from ..core import http
from ..core.markup import clean_html, parse_html, text_of
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://www.hackerrank.com"
DEFAULT_CONTEST = "master"  # the practice section
MATH_PLACEHOLDER = "⟨formula⟩"

_CONTEST_URL_RE = re.compile(r"hackerrank\.com/contests/([\w-]+)/challenges/([\w-]+)", re.IGNORECASE)
_URL_RE = re.compile(r"hackerrank\.com/challenges/([\w-]+)", re.IGNORECASE)
_SLUG_RE = re.compile(r"^[\w-]+$")
_MATHJAX = ".MathJax_SVG, .MathJax_SVG_Display, .MathJax, .MathJax_Display"

# (raw Markdown field, heading); the statement itself has no heading.
_MARKDOWN_SECTIONS = (
	("problem_statement", None),
	("input_format", "Input Format"),
	("constraints", "Constraints"),
	("output_format", "Output Format"),
)
_HTML_ONLY_SECTIONS = ".challenge_sample_input, .challenge_sample_output, .challenge_explanation"

Ref = Tuple[str, str]  # (contest slug, challenge slug)


def parse_input(token: str) -> Ref:
	m = _CONTEST_URL_RE.search(token)
	if m:
		return m.group(1).lower(), m.group(2).lower()
	m = _URL_RE.search(token)
	if m:
		return DEFAULT_CONTEST, m.group(1).lower()
	if _SLUG_RE.match(token):
		return DEFAULT_CONTEST, token.lower()
	raise ValueError("expected a challenge slug (solve-me-first) or a hackerrank.com challenge URL")


def challenge_url(contest: str, slug: str) -> str:
	if contest == DEFAULT_CONTEST:
		return f"{BASE}/challenges/{slug}/problem"
	return f"{BASE}/contests/{contest}/challenges/{slug}"


def _html_fragment(node, url: str) -> Tuple[str, bool]:
	"""Clean a body_html fragment; report whether formulas had to be dropped."""
	lost = False
	for math in node.select(_MATHJAX):
		math.replace_with(MATH_PLACEHOLDER)
		lost = True
	return clean_html(node, url), lost


def build_body(model: Dict[str, Any], url: str) -> Tuple[str, bool]:
	"""Assemble the README body. Returns (body, formulas_lost)."""
	soup = parse_html(model.get("body_html") or "")
	parts: List[str] = []
	lost = False

	if (model.get("problem_statement") or "").strip():
		for field, heading in _MARKDOWN_SECTIONS:
			text = (model.get(field) or "").strip()
			if text:
				parts.append(f"### {heading}\n\n{text}" if heading else text)
		for section in soup.select(_HTML_ONLY_SECTIONS):
			title = text_of(section.select_one('[class$="_title"]'))
			content = section.select_one('[class$="_body"]') or section
			pre = content.find("pre")
			if pre is not None and "explanation" not in " ".join(section.get("class", [])):
				block = f"```text\n{pre.get_text().strip(chr(10))}\n```"
			else:
				block, dropped = _html_fragment(content, url)
				lost = lost or dropped
			if block:
				parts.append(f"### {title}\n\n{block}" if title else block)
	else:
		# Challenges without raw Markdown: fall back to the rendered HTML.
		for title in soup.select('[class$="_title"]'):
			title.name = "h3"
			title.string = text_of(title)
		block, lost = _html_fragment(soup, url)
		parts.append(block)

	return "\n\n".join(parts), lost


class HackerRankProvider(StatementProvider):
	name = "hr"
	aliases = ("hackerrank",)
	source = "HackerRank"
	display_name = "HackerRank"
	input_help = "Challenge slug(s) (solve-me-first) or hackerrank.com challenge URL(s), contest URLs included."
	examples = (
		"3c hr solve-me-first",
		"3c hr https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem",
	)

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		return [parse_input(token)]

	def describe(self, ref: Hashable) -> str:
		return ref[1]

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		contest, slug = ref
		try:
			data = http.get(f"{BASE}/rest/contests/{contest}/challenges/{slug}", debug=ctx.debug).json()
		except ValueError:
			raise http.FetchError("HackerRank returned a non-JSON answer")
		model = data.get("model") if isinstance(data, dict) else None
		if not model:
			raise http.NotFoundError(f"challenge '{slug}' does not exist")

		url = challenge_url(contest, slug)
		body, lost = build_body(model, url)
		if not body:
			raise http.FetchError(f"challenge '{slug}' has no public statement")

		meta: List[Tuple[str, str]] = []
		track = model.get("track") or {}
		if track.get("name"):
			meta.append(("Track", " › ".join(x for x in (track.get("track_name"), track["name"]) if x)))
		if model.get("max_score") is not None:
			meta.append(("Max score", str(model["max_score"])))
		if isinstance(model.get("success_ratio"), (int, float)):
			meta.append(("Success rate", f"{model['success_ratio']:.1%}"))
		if model.get("author_name"):
			meta.append(("Author", model["author_name"]))

		tags = [t["title"] if isinstance(t, dict) else str(t) for t in model.get("topics") or []]
		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=slug,
			slug=slug,
			title=model.get("name") or slug,
			url=url,
			body=body,
			difficulty=model.get("difficulty_name") or None,
			meta=meta,
			tags=[t for t in tags if t],
			notice=(f"Formulas in the sample explanations are published as images only and appear as "
					f"{MATH_PLACEHOLDER}; see the original page for them.") if lost else None,
		)
