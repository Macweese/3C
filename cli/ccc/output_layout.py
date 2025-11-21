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

# Flexible output layout helper for 3C/CCC providers
# Supports namespacing by source to avoid collisions across providers.

from __future__ import annotations
from pathlib import Path
import os
import re
from typing import Optional

# Environment-configurable defaults
# Examples:
#   3C_LAYOUT=source-difficulty-id
#   3C_NAMEFMT="{id}-{slug}"
DEFAULT_LAYOUT = (os.environ.get("3C_LAYOUT") or "source-difficulty-id").strip()
DEFAULT_NAMEFMT = (os.environ.get("3C_NAMEFMT") or "{id}").strip()


def safe_segment(s: str) -> str:
	"""
	Sanitize a filesystem segment: keep alnum, dot, underscore, dash; collapse repeats; trim.
	"""
	s = (s or "").strip().replace(" ", "-")
	s = re.sub(r"[^a-zA-Z0-9._\-]+", "-", s)
	s = re.sub(r"-{2,}", "-", s).strip("-")
	return s or "x"


def build_dir_name(namefmt: str, source: str, difficulty: Optional[str], pid: str, slug: Optional[str]) -> str:
	"""
	Build the leaf directory name using a format like:
	  {id}            -> 998
	  {id}-{slug}     -> 998-maximum-binary-tree-ii
	  {source}-{id}   -> leetcode-998
	Unknown keys or formatting errors fall back to {id} or {slug}.
	"""
	vals = {
		"source": safe_segment(source),
		"difficulty": safe_segment(difficulty or ""),
		"id": safe_segment(pid or ""),
		"slug": safe_segment(slug or ""),
	}
	try:
		return safe_segment(namefmt.format(**vals))
	except Exception:
		return safe_segment(pid or slug or "x")


def compute_output_dir(
		out_root: Path,
		source: str,
		difficulty: Optional[str],
		pid: str,
		slug: Optional[str],
		layout: str = DEFAULT_LAYOUT,
		namefmt: str = DEFAULT_NAMEFMT,
		include_id_subdir: bool = True,
) -> Path:
	"""
	Compute the directory for a generated problem.

	Layout options:
	- source-difficulty-id (default): <out>/<source>/<difficulty>/<leaf>
	- difficulty-source-id:          <out>/<difficulty>/<source>/<leaf>
	- source-id:                     <out>/<source>/<leaf>
	- flat:                          <out>/<leaf>

	namefmt controls <leaf> (default: {id})

	Examples:
	- source="leetcode", difficulty="medium", pid="998", slug="maximum-binary-tree-ii"
	  source-difficulty-id + {id}         -> out/leetcode/medium/998
	  source-id + {id}-{slug}             -> out/leetcode/998-maximum-binary-tree-ii
	"""
	output_directory = out_root / "Challenges"
	source_seg = safe_segment(source)
	diff_seg = safe_segment(difficulty or "")
	id_seg = build_dir_name(namefmt, source, difficulty, pid, slug)

	if layout == "source-difficulty-id":
		base = output_directory / source_seg
		if difficulty:
			base = base / diff_seg
		return base / id_seg if include_id_subdir else base

	if layout == "difficulty-source-id":
		base = output_directory
		if difficulty:
			base = base / diff_seg
		base = base / source_seg
		return base / id_seg if include_id_subdir else base

	if layout == "source-id":
		base = output_directory / source_seg
		return base / id_seg if include_id_subdir else base

	if layout == "flat":
		base = output_directory
		return base / id_seg if include_id_subdir else base

	# Unknown -> Fallback to default
	base = output_directory / source_seg
	if difficulty:
		base = base / diff_seg
	return base / id_seg if include_id_subdir else base
