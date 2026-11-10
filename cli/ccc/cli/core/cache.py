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
Small JSON file cache under `CACHE_DIR` with age-based expiry.

Used for per-source problem indexes that are large and change slowly, so a
batch run downloads them at most once per TTL instead of once per problem.
"""

from __future__ import annotations

import json
import os
import tempfile
import threading
import time
from pathlib import Path
from typing import Any, Callable, Dict, Optional

from ...config import CACHE_DIR

DAY = 24 * 60 * 60

# name -> parsed document; avoids re-reading and re-parsing a multi-megabyte
# index for every problem in a batch.
_MEMO: Dict[str, Any] = {}
_LOCK = threading.Lock()


def cache_path(name: str) -> Path:
	return CACHE_DIR / name


def load_json(name: str, max_age: Optional[float] = DAY) -> Optional[Any]:
	"""Return the cached document, or None when missing, stale or unreadable."""
	path = cache_path(name)
	try:
		if max_age is not None and time.time() - path.stat().st_mtime > max_age:
			return None
		with path.open("r", encoding="utf-8") as fh:
			return json.load(fh)
	except (OSError, ValueError):
		return None


def save_json(name: str, data: Any) -> None:
	"""Atomically write the document; failures are non-fatal (cache only)."""
	path = cache_path(name)
	try:
		path.parent.mkdir(parents=True, exist_ok=True)
		fd, tmp = tempfile.mkstemp(prefix=path.name + ".", dir=str(path.parent))
		try:
			with os.fdopen(fd, "w", encoding="utf-8") as fh:
				json.dump(data, fh, ensure_ascii=False, separators=(",", ":"))
			os.replace(tmp, path)
		except BaseException:
			try:
				os.unlink(tmp)
			except OSError:
				pass
			raise
	except OSError:
		pass


def cached(name: str, build: Callable[[], Any], max_age: Optional[float] = DAY, refresh: bool = False) -> Any:
	"""
	Return the document called `name`, building and storing it when absent,
	stale or when `refresh` is set. Thread-safe; `build` runs at most once at
	a time, so concurrent workers never download the same index twice.
	"""
	with _LOCK:
		if not refresh and name in _MEMO:
			return _MEMO[name]
		data = None if refresh else load_json(name, max_age)
		if data is None:
			data = build()
			save_json(name, data)
		_MEMO[name] = data
		return data
