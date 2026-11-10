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
"""Source-agnostic problem model shared by statement providers."""

from __future__ import annotations

import dataclasses as dc
import re
from typing import List, Optional, Tuple

_SLUG_RE = re.compile(r"[^a-z0-9]+")


def slugify(text: str) -> str:
	"""Lowercase, dash-separated ASCII slug ('' when nothing survives)."""
	return _SLUG_RE.sub("-", (text or "").lower()).strip("-")


@dc.dataclass
class Problem:
	"""
	A fetched problem, ready to be rendered.

	`body` is the statement as Markdown-embeddable text (cleaned HTML or
	Markdown). `difficulty` is the source's own tier/rating label; it is shown
	in the README and used as the difficulty directory in output layouts.
	"""

	source: str  # directory segment, e.g. "AtCoder"
	source_name: str  # display name, e.g. "AtCoder"
	id: str
	title: str
	url: str
	body: str
	slug: Optional[str] = None
	heading: Optional[str] = None  # README H1; defaults to the title
	difficulty: Optional[str] = None
	meta: List[Tuple[str, str]] = dc.field(default_factory=list)  # (label, value) facts
	tags: List[str] = dc.field(default_factory=list)
	notice: Optional[str] = None  # caveat shown above the statement
	footer: Optional[str] = None  # e.g. the source's copyright line

	def __post_init__(self) -> None:
		if not self.heading:
			self.heading = self.title
		if not self.slug:
			self.slug = slugify(self.title) or None
