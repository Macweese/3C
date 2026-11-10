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
HTML clean-up for problem statements embedded in generated Markdown.

Statements are kept as HTML (GitHub-flavoured Markdown renders inline HTML),
but scraped markup is normalised first: scripts/styles removed, relative
links made absolute, presentation attributes and wrappers dropped and math
rewritten to the `$...$` notation GitHub renders.
"""

from __future__ import annotations

import re
from typing import Iterable, Optional, Union
from urllib.parse import urljoin

from bs4 import BeautifulSoup, Comment, NavigableString, Tag

# Attributes worth keeping; everything else (class, style, id, data-*, ...) is
# site-specific presentation noise.
_KEEP_ATTRS = frozenset(("href", "src", "alt", "title", "colspan", "rowspan", "width", "height", "align"))
_DROP_TAGS = ("script", "style", "noscript", "iframe", "form", "button", "input", "svg")
# Wrappers that carry no meaning once their attributes are gone.
_UNWRAP_TAGS = ("span", "section", "article", "font")
_URL_ATTRS = (("a", "href"), ("img", "src"))
_BLANK_LINES_RE = re.compile(r"\n[ \t]*\n(?:[ \t]*\n)+")


def parse_html(html: str) -> BeautifulSoup:
	return BeautifulSoup(html, "html.parser")


def text_of(node: Optional[Tag]) -> str:
	"""Whitespace-normalised text content ('' for a missing node)."""
	return " ".join(node.get_text(" ", strip=True).split()) if node is not None else ""


def clean_html(
		fragment: Union[str, Tag],
		base_url: str,
		*,
		var_as_math: bool = False,
		drop_selectors: Iterable[str] = (),
		unwrap_selectors: Iterable[str] = (),
) -> str:
	"""
	Return `fragment` as tidy HTML suitable for embedding in a README.

	- `base_url` resolves relative `href`/`src` values.
	- `var_as_math` turns `<var>x</var>` into `$x$` outside `<pre>` blocks
	  (for sites that typeset LaTeX through `<var>`).
	- `drop_selectors` removes matching elements with their content;
	  `unwrap_selectors` removes only the wrapping element.
	"""
	# Always work on a private tree so the caller's document is left intact.
	root = parse_html(fragment if isinstance(fragment, str) else str(fragment))

	for node in root.find_all(string=lambda s: isinstance(s, Comment)):
		node.extract()
	for tag in root.find_all(_DROP_TAGS):
		tag.decompose()
	for selector in drop_selectors:
		for tag in root.select(selector):
			tag.decompose()
	for selector in unwrap_selectors:
		for tag in root.select(selector):
			tag.unwrap()

	if var_as_math:
		for var in root.find_all("var"):
			if var.find_parent("pre") is None:
				var.replace_with(NavigableString(f"${var.get_text().strip()}$"))

	for name, attr in _URL_ATTRS:
		for tag in root.find_all(name):
			value = tag.get(attr)
			if value and not value.startswith(("#", "data:", "mailto:")):
				tag[attr] = urljoin(base_url, value)

	for tag in root.find_all(True):
		if tag.attrs:
			tag.attrs = {k: v for k, v in tag.attrs.items() if k in _KEEP_ATTRS}
	for tag in root.find_all(_UNWRAP_TAGS):
		tag.unwrap()

	return _BLANK_LINES_RE.sub("\n\n", root.decode(formatter="minimal")).strip()
