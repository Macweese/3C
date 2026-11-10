"""Shared pytest fixtures. Tests never touch the network or the real cache."""

from __future__ import annotations

import argparse

import pytest

from ccc.cli.core import cache, http
from ccc.cli.core.provider import ProviderContext


class FakeResponse:
	def __init__(self, status=200, text="", json_data=None, headers=None):
		self.status_code = status
		self._json = json_data
		self.text = text
		self.content = text.encode("utf-8")
		self.headers = {"Content-Type": "text/html"} if headers is None else headers

	def json(self):
		if self._json is None:
			raise ValueError("no JSON body")
		return self._json


@pytest.fixture(autouse=True)
def isolated_cache(tmp_path, monkeypatch):
	monkeypatch.setattr(cache, "CACHE_DIR", tmp_path / "cache")
	cache._MEMO.clear()
	yield
	cache._MEMO.clear()


@pytest.fixture(autouse=True)
def no_network(monkeypatch):
	def refuse(method, url, **kwargs):
		raise AssertionError(f"unexpected network access: {method} {url}")

	monkeypatch.setattr(http, "request", refuse)


@pytest.fixture
def fake_http(monkeypatch):
	"""Route http.get/post through a {url-substring: FakeResponse | Exception} table."""

	def install(routes):
		calls = []

		def fake_request(method, url, **kwargs):
			calls.append((method, url, kwargs))
			for needle, answer in routes.items():
				if needle in url:
					if isinstance(answer, Exception):
						raise answer
					return answer
			raise http.NotFoundError(f"not found: {url}")

		monkeypatch.setattr(http, "request", fake_request)
		return calls

	return install


@pytest.fixture
def ctx():
	return ProviderContext()


@pytest.fixture
def args():
	return argparse.Namespace(refresh=False)
