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

from __future__ import annotations

import enum
from dataclasses import dataclass
from pathlib import Path


class OverwritePolicy(enum.Enum):
	ASK = "ask"				# (reserved for future interactive use)
	NO_OVERWRITE = "no"		# never overwrite existing
	FORCE = "force"			# always overwrite


@dataclass
class FileDecision:
	path: Path
	should_write: bool
	reason: str
	exists: bool


def decide(path: Path, force: bool = False, no_overwrite: bool = False, dry_run: bool = False) -> FileDecision:
	exists = path.exists()
	if dry_run:
		return FileDecision(path, should_write=False, reason="dry-run", exists=exists)
	if exists:
		if no_overwrite and not force:
			return FileDecision(path, should_write=False, reason="exists-no-overwrite", exists=True)
	return FileDecision(path, should_write=True, reason="ok", exists=exists)


def add_overwrite_arguments(p) -> None:
	p.add_argument(
		"--force",
		action="store_true",
		help="Overwrite existing files without prompting.",
	)
	p.add_argument(
		"--no-overwrite",
		action="store_true",
		help="Never overwrite existing files (skip instead).",
	)
	p.add_argument(
		"--dry-run",
		action="store_true",
		help="Do not write any files, only print what would be done.",
	)
