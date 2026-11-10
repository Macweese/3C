from __future__ import annotations

import pytest

from ccc.cli.core import http
from ccc.cli.providers import codeforces as cf
from conftest import FakeResponse

PAGE = (
	'<html><body><div class="problem-statement"><div class="header"><div class="title">A. To My Critics</div>'
	'<div class="time-limit"><div class="property-title">time limit per test</div>1 second</div>'
	'<div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div></div>'
	'<div><p>Digits $$$a$$$ and $$$b$$$. Print "<span class="tex-font-style-tt">YES</span>".</p></div>'
	'<div class="input-specification"><div class="section-title">Input</div><p>One integer $$$t$$$.</p></div>'
	'<div class="sample-tests"><div class="section-title">Example</div><div class="sample-test">'
	'<div class="input"><div class="title">Input</div><pre>\n'
	'<div class="test-example-line test-example-line-even">2</div><div class="test-example-line">8 1 2</div></pre></div>'
	'<div class="output"><div class="title">Output</div><pre>YES<br/>NO</pre></div></div></div></div>'
	'<span class="tag-box" title="x">implementation</span><span class="tag-box" title="Difficulty">*800</span>'
	'</body></html>'
)

CONTEST_PAGE = (
	'<table class="problems"><tr><td class="id"><a href="/contest/1850/problem/A">A</a></td>'
	'<td><a href="/contest/1850/problem/A">To My Critics</a></td></tr>'
	'<tr><td class="id"><a href="/contest/1850/problem/B1">B1</a></td></tr></table>'
	'<a href="/contest/1850/problem/Z">outside the table</a>'
)


class _Resp(FakeResponse):
	def __init__(self, url, **kwargs):
		super().__init__(**kwargs)
		self.url = url


def test_parse_input():
	assert cf.parse_input("1850A") == ("contest", 1850, "A")
	assert cf.parse_input("1234/b1") == ("contest", 1234, "B1")
	assert cf.parse_input("100001A") == ("gym", 100001, "A")
	assert cf.parse_input("1850") == ("contest", 1850, None)
	assert cf.parse_input("https://codeforces.com/problemset/problem/4/A") == ("contest", 4, "A")
	assert cf.parse_input("https://codeforces.com/gym/100001/problem/C") == ("gym", 100001, "C")
	assert cf.parse_input("https://codeforces.com/contest/1850") == ("contest", 1850, None)
	with pytest.raises(ValueError):
		cf.parse_input("watermelon")


def test_parse_problem_page():
	title, body, rating, meta, tags = cf.parse_problem_page(PAGE, "https://codeforces.com/contest/1850/problem/A")
	assert (title, rating, tags) == ("A. To My Critics", "800", ["implementation"])
	assert meta == [("Time limit", "1 second"), ("Memory limit", "256 megabytes")]
	assert "$a$ and $b$" in body and "$$$" not in body
	assert "<code>YES</code>" in body and "<h3>Input</h3>" in body and "<h4>Output</h4>" in body
	assert "<pre>2\n8 1 2\n</pre>" in body and "<pre>YES\nNO\n</pre>" in body
	assert "To My Critics" not in body  # header is metadata, not statement


def test_expand_contest(fake_http, args, ctx):
	fake_http({"/contest/1850": FakeResponse(text=CONTEST_PAGE)})
	assert cf.CodeforcesProvider().expand("1850", args, ctx) == [("contest", 1850, "A"), ("contest", 1850, "B1")]


def test_fetch(fake_http, args, ctx):
	url = "https://codeforces.com/contest/1850/problem/A"
	fake_http({"/contest/1850/problem/A": _Resp(url, text=PAGE)})
	p = cf.CodeforcesProvider().fetch(("contest", 1850, "A"), args, ctx)
	assert (p.id, p.title, p.heading, p.difficulty, p.url) == ("1850A", "To My Critics", "1850A. To My Critics", "800", url)


def test_fetch_redirect_means_not_found(fake_http, args, ctx):
	fake_http({"/contest/1850/problem/Z": _Resp("https://codeforces.com/contest/1850", text="<html></html>")})
	with pytest.raises(http.NotFoundError):
		cf.CodeforcesProvider().fetch(("contest", 1850, "Z"), args, ctx)


def test_fetch_falls_back_to_api_metadata_when_blocked(fake_http, args, ctx):
	api = {"status": "OK", "result": {"problems": [
		{"contestId": 1850, "index": "A", "name": "To My Critics", "rating": 800, "tags": ["implementation"]}]}}
	fake_http({
		"/contest/1850/problem/": http.BlockedError("challenge"),
		"problemset.problems": FakeResponse(json_data=api),
	})
	provider = cf.CodeforcesProvider()
	p = provider.fetch(("contest", 1850, "A"), args, ctx)
	assert (p.title, p.difficulty, p.tags, p.body) == ("To My Critics", "800", ["implementation"], "")
	assert "anti-bot" in p.notice
	with pytest.raises(http.BlockedError):  # nothing known about this one
		provider.fetch(("contest", 1850, "Q"), args, ctx)
