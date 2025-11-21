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

import threading
from pathlib import Path
from typing import Dict

import requests

from .logging import console

# Thread-local HTTP sessions (reduces TLS handshakes per thread)
_THREAD_LOCAL = threading.local()


def get_thread_session(cookies: Dict[str, str]) -> requests.Session:
	"""
	Return a thread-local `requests.Session` with cookies preloaded.
	"""
	sess: requests.Session | None = getattr(_THREAD_LOCAL, "session", None)
	if sess is None:
		sess = requests.Session()
		_THREAD_LOCAL.session = sess
	for k, v in (cookies or {}).items():
		sess.cookies.set(k, v, domain="leetcode.com")
	return sess


def style_path(path: Path, base: Path | None = None) -> str:
	p = path
	if base is not None:
		try:
			p = path.relative_to(base)
		except Exception:
			p = path
	if console is not None:
		return f"[path]{p}[/path]"
	return str(p)
