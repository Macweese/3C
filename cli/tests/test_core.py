from __future__ import annotations

import pytest

from ccc.cli import app
from ccc.cli.core import cache, http
from ccc.cli.core.markup import clean_html
from ccc.cli.core.problem import Problem, slugify
from ccc.cli.core.statements import StatementProvider
from conftest import FakeResponse


# ------------------------------------------------------------------ markup

def test_clean_html_strips_noise_and_absolutizes_urls():
	html = (
		'<div class="x" style="color:red"><script>alert(1)</script><!-- c -->'
		'<a href="/a?b=1" onclick="x()"><span class="t">link</span></a><img src="img/p.png" alt="p"></div>'
	)
	out = clean_html(html, "https://example.org/problems/1/")
	assert "<div>" in out and "span" not in out
	assert "script" not in out and "<!--" not in out and "class" not in out and "onclick" not in out
	assert 'href="https://example.org/a?b=1"' in out
	assert 'src="https://example.org/problems/1/img/p.png"' in out


def test_clean_html_var_as_math_skips_pre():
	out = clean_html("<p><var>N \\le 5</var></p><pre><var>N</var></pre>", "https://e.org/", var_as_math=True)
	assert "<p>$N \\le 5$</p>" in out
	assert "<pre><var>N</var></pre>" in out


def test_clean_html_drop_and_unwrap_selectors():
	out = clean_html('<p><span class="m">$x$</span><b class="gone">no</b></p>', "https://e.org/",
					 drop_selectors=[".gone"], unwrap_selectors=["span.m"])
	assert out == "<p>$x$</p>"


def test_slugify_and_problem_defaults():
	assert slugify("  Hello, World! (v2) ") == "hello-world-v2"
	p = Problem(source="S", source_name="S", id="1", title="A - Two Words", url="u", body="b")
	assert p.heading == "A - Two Words" and p.slug == "a-two-words"


# ------------------------------------------------------------------- cache

def test_cached_builds_once_and_honours_refresh():
	calls = []

	def build():
		calls.append(1)
		return {"n": len(calls)}

	assert cache.cached("doc.json", build) == {"n": 1}
	assert cache.cached("doc.json", build) == {"n": 1}
	cache._MEMO.clear()  # a new process still finds it on disk
	assert cache.cached("doc.json", build) == {"n": 1}
	assert cache.cached("doc.json", build, refresh=True) == {"n": 2}
	assert cache.load_json("doc.json", max_age=-1) is None  # stale


# -------------------------------------------------------------------- http

class _Session:
	def __init__(self, answers):
		self.answers = list(answers)
		self.calls = 0

	def request(self, method, url, **kwargs):
		self.calls += 1
		return self.answers.pop(0)


@pytest.fixture
def real_request(monkeypatch):
	"""Undo the no_network guard but replace the session and sleeping."""
	monkeypatch.undo()
	monkeypatch.setattr(http.time, "sleep", lambda s: None)

	def install(answers):
		sess = _Session(answers)
		monkeypatch.setattr(http, "get_session", lambda: sess)
		return sess

	return install


def test_request_retries_transient_then_succeeds(real_request):
	sess = real_request([FakeResponse(503, "busy"), FakeResponse(429, "slow"), FakeResponse(200, "ok")])
	assert http.get("https://e.org/x").text == "ok"
	assert sess.calls == 3


def test_request_does_not_retry_permanent_errors(real_request):
	sess = real_request([FakeResponse(400, "bad")])
	with pytest.raises(http.FetchError):
		http.get("https://e.org/x")
	assert sess.calls == 1


def test_request_maps_404_and_challenge(real_request):
	real_request([FakeResponse(404, "nope")])
	with pytest.raises(http.NotFoundError):
		http.get("https://e.org/x")
	real_request([FakeResponse(403, "<title>Just a moment...</title>")])
	with pytest.raises(http.BlockedError):
		http.get("https://e.org/x")


# -------------------------------------------------------------- statements

class _Toy(StatementProvider):
	name = "toy"
	source = "Toy"
	display_name = "Toy"

	def expand(self, token, args, ctx):
		if token == "bad":
			raise ValueError("nope")
		return [token, token]  # duplicates must collapse

	def fetch(self, ref, args, ctx):
		if ref == "missing":
			raise http.NotFoundError("gone")
		return Problem(source="Toy", source_name="Toy", id=str(ref), title=f"T [{ref}]", url="https://t/" + str(ref),
					   body="<p>body</p>", difficulty="Easy", tags=["Math"], meta=[("Limit", "1 | 2")])


def _run_toy(tmp_path, *argv):
	import argparse

	parser = argparse.ArgumentParser()
	_Toy.register(parser.add_subparsers(dest="cmd"))
	ns = parser.parse_args(["toy", *argv, "--out-dir", str(tmp_path)])
	from ccc.cli.core.provider import ProviderContext

	return _Toy().run(ns, ProviderContext())


def test_statement_provider_writes_layout_and_reports_failures(tmp_path, capsys):
	rc = _run_toy(tmp_path, "a", "b", "missing", "bad", "-j", "3")
	assert rc == 1
	readme = tmp_path / "Challenges" / "Toy" / "easy" / "a" / "README.md"
	text = readme.read_text(encoding="utf-8")
	assert "# T [a]" in text and "[Toy a](https://t/a)" in text and "`math`" in text
	assert "| **Limit** | 1 \\| 2 |" in text
	assert (tmp_path / "Challenges" / "Toy" / "easy" / "b" / "README.md").is_file()
	assert "2 generated, 2 failed" in capsys.readouterr().out


def test_statement_provider_overwrite_policy_and_dry_run(tmp_path, capsys):
	assert _run_toy(tmp_path, "a") == 0
	readme = tmp_path / "Challenges" / "Toy" / "easy" / "a" / "README.md"
	readme.write_text("mine", encoding="utf-8")
	assert _run_toy(tmp_path, "a", "--no-overwrite") == 0
	assert readme.read_text(encoding="utf-8") == "mine"
	assert _run_toy(tmp_path, "c", "--dry-run", "--layout", "flat") == 0
	assert not (tmp_path / "Challenges" / "c").exists()
	assert _run_toy(tmp_path, "a", "--force", "--no-overwrite") == 2
	assert "1 skipped" in capsys.readouterr().out


# --------------------------------------------------------------------- app

def test_donut_flag_prints_a_frame_when_not_a_tty(capsys):
	assert app.main(["--donut"]) == 0
	out = capsys.readouterr().out
	assert len(out.splitlines()) == 24 and "@" in out


def test_all_sources_are_registered(capsys):
	with pytest.raises(SystemExit):
		app.main(["--help"])
	help_text = capsys.readouterr().out
	for cmd in ("lc", "cg", "pe"):
		assert cmd in help_text
