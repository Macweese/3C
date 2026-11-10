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
Shared HTTP client for providers.

- One `requests.Session` per thread (connection reuse under `-j`).
- A truthful User-Agent identifying the tool.
- Bounded retries with exponential backoff and jitter for transient failures
  (network errors, 429, 5xx), honouring `Retry-After`.
- Typed errors so callers can tell "does not exist" from "site refused us".

Anti-bot challenges (e.g. Cloudflare "Just a moment...") are detected and
reported as `BlockedError`; no attempt is made to get around them.
"""

from __future__ import annotations

import random
import threading
import time
from typing import Any, Optional

import requests

from ... import __version__
from .logging import print_debug

USER_AGENT = f"3c-cli/{__version__} (+https://github.com/Macweese/3C)"
DEFAULT_TIMEOUT = 20  # seconds
MAX_ATTEMPTS = 4
_MAX_BACKOFF = 30.0  # seconds

_THREAD_LOCAL = threading.local()


class FetchError(Exception):
	"""A request failed for good (after retries, or with a permanent status)."""


class NotFoundError(FetchError):
	"""The resource does not exist (HTTP 404 or an equivalent API answer)."""


class BlockedError(FetchError):
	"""The site answered with an anti-bot challenge instead of content."""


def get_session() -> requests.Session:
	"""Return this thread's session, creating it on first use."""
	sess: Optional[requests.Session] = getattr(_THREAD_LOCAL, "session", None)
	if sess is None:
		sess = requests.Session()
		sess.headers.update({
			"User-Agent": USER_AGENT,
			"Accept-Language": "en-US,en;q=0.9",
		})
		_THREAD_LOCAL.session = sess
	return sess


def _is_challenge(resp: requests.Response) -> bool:
	if resp.headers.get("cf-mitigated", "").lower() == "challenge":
		return True
	if resp.status_code in (403, 503) and "text/html" in resp.headers.get("Content-Type", ""):
		head = resp.text[:2048]
		return "Just a moment..." in head or "challenge-platform" in head
	return False


def _retry_delay(resp: Optional[requests.Response], attempt: int) -> float:
	if resp is not None:
		retry_after = resp.headers.get("Retry-After", "")
		if retry_after.isdigit():
			return min(float(retry_after), _MAX_BACKOFF)
	return min(2.0 ** (attempt - 1), _MAX_BACKOFF) + random.uniform(0, 0.5)


def request(
		method: str,
		url: str,
		*,
		debug: bool = False,
		timeout: float = DEFAULT_TIMEOUT,
		max_attempts: int = MAX_ATTEMPTS,
		**kwargs: Any,
) -> requests.Response:
	"""
	Perform a request and return the successful (2xx/3xx) response.

	Raises NotFoundError on 404, BlockedError on an anti-bot challenge and
	FetchError for any other failure once retries are exhausted.
	"""
	sess = get_session()
	failure = "no attempt made"
	for attempt in range(1, max_attempts + 1):
		resp: Optional[requests.Response] = None
		try:
			resp = sess.request(method, url, timeout=timeout, **kwargs)
		except requests.RequestException as e:
			failure = f"{type(e).__name__}: {e}"
		else:
			status = resp.status_code
			if debug:
				print_debug(f"{method} {url} -> {status} ({len(resp.content)} bytes)")
			if status < 400:
				return resp
			if status == 404:
				raise NotFoundError(f"not found: {url}")
			if _is_challenge(resp):
				raise BlockedError(
					f"{url} answered with an anti-bot challenge (HTTP {status}); "
					"the page cannot be fetched from this network right now"
				)
			failure = f"HTTP {status}"
			if status != 429 and status < 500:
				break  # permanent client error; retrying cannot help
		if attempt < max_attempts:
			delay = _retry_delay(resp, attempt)
			if debug:
				print_debug(f"{method} {url} failed ({failure}); retry {attempt}/{max_attempts - 1} in {delay:.1f}s")
			time.sleep(delay)
	raise FetchError(f"{method} {url} failed: {failure}")


def get(url: str, **kwargs: Any) -> requests.Response:
	return request("GET", url, **kwargs)


def post(url: str, **kwargs: Any) -> requests.Response:
	return request("POST", url, **kwargs)
