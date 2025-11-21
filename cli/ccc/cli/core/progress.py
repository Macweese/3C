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

from contextlib import contextmanager
from typing import Iterator, Optional, Tuple, Any

_RICH_AVAILABLE = True
try:
	from rich.progress import Progress, SpinnerColumn, TextColumn, BarColumn, TimeElapsedColumn
except Exception:	# pragma: no cover
	_RICH_AVAILABLE = False
	Progress = None	# type: ignore


@contextmanager
def batch_progress(description: str = "Processing...", total: Optional[int] = None) -> Iterator[Optional[Tuple[Any, int]]]:
	"""
	Context manager for batch progress.

	Yields (progress, task_id) if rich is available, else None.
	"""
	if not _RICH_AVAILABLE or Progress is None:
		yield None
		return

	with Progress(
			SpinnerColumn(),
			TextColumn("[progress.description]{task.description}"),
			BarColumn(),
			TimeElapsedColumn(),
	) as progress:
		task_id = progress.add_task(description, total=total)
		yield (progress, task_id)


@contextmanager
def spinner(label: str = "Working...") -> Iterator[None]:
	"""
	Simple spinner context; if rich is unavailable, does nothing.
	"""
	if not _RICH_AVAILABLE or Progress is None:
		yield
		return

	with Progress(SpinnerColumn(), TextColumn(label)) as _:
		yield
