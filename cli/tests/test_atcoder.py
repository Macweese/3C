from __future__ import annotations

import argparse

import pytest

from ccc.cli.core import http
from ccc.cli.providers import atcoder as ac
from conftest import FakeResponse

TASK_PAGE = """
<html><head><title>A - Sum</title></head><body>
<a class="contest-title" href="/contests/abc300">AtCoder Beginner Contest 300</a>
<span class="h2">A - Sum <a class="btn" href="/contests/abc300/tasks/abc300_a/editorial">Editorial</a></span>
<p>Time Limit: 2 sec / Memory Limit: 1024 MiB</p>
<div id="task-statement"><span class="lang">
<span class="lang-ja"><p>和を求めよ</p></span>
<span class="lang-en"><p>Score : <var>100</var> points</p>
<div class="part"><section><h3>Problem Statement</h3><p>Find <var>A+B</var>. <img src="/img/x.png"></p></section></div>
<div class="part"><section><h3>Sample Input 1</h3><pre><var>A</var> <var>B</var></pre></section></div>
</span></span></div></body></html>
"""

TASK_LIST = """
<table><tr><td><a href="/contests/abc300/tasks/abc300_a">A</a></td><td><a href="/contests/abc300/tasks/abc300_a">Sum</a></td></tr>
<tr><td><a href="/contests/abc300/tasks/abc300_b">B</a></td><td><a href="/contests/abc300/tasks/abc300_b">Diff</a></td></tr></table>
"""


@pytest.fixture
def ac_args():
	return argparse.Namespace(refresh=False, no_difficulty=False)


def test_parse_input():
	assert ac.parse_input("abc300_a") == (None, "abc300_a")
	assert ac.parse_input("ABC300") == ("abc300", None)
	assert ac.parse_input("https://atcoder.jp/contests/dp/tasks/dp_a?lang=en") == ("dp", "dp_a")
	assert ac.parse_input("https://atcoder.jp/contests/abc300/") == ("abc300", None)
	with pytest.raises(ValueError):
		ac.parse_input("not a task!")


def test_helpers():
	assert ac.guess_contest("code_festival_2017_quala_a") == "code-festival-2017-quala"
	assert ac.displayed_rating(1234.4) == 1234
	assert 0 < ac.displayed_rating(-1147) < 400
	assert [ac.colour_of(r) for r in (0, 399, 400, 2800, 9999)] == ["Gray", "Gray", "Brown", "Red", "Red"]


def test_parse_task_page_prefers_english():
	title, body, meta = ac.parse_task_page(TASK_PAGE, "https://atcoder.jp/contests/abc300/tasks/abc300_a")
	assert title == "A - Sum"
	assert "和" not in body and "Find $A+B$." in body
	assert "<pre><var>A</var> <var>B</var></pre>" in body
	assert 'src="https://atcoder.jp/img/x.png"' in body
	assert meta == [("Contest", "AtCoder Beginner Contest 300"), ("Time limit", "2 sec"), ("Memory limit", "1024 MiB")]


def test_expand_contest_lists_each_task_once(fake_http, ac_args, ctx):
	fake_http({"/contests/abc300/tasks": FakeResponse(text=TASK_LIST)})
	assert ac.AtCoderProvider().expand("abc300", ac_args, ctx) == [("abc300", "abc300_a"), ("abc300", "abc300_b")]


def test_fetch_resolves_contest_and_difficulty(fake_http, ac_args, ctx):
	calls = fake_http({
		"/contests/arc058/tasks/arc058_a": http.NotFoundError("404"),
		"problems.json": FakeResponse(json_data=[{"id": "arc058_a", "contest_id": "abc042"}]),
		"/contests/abc042/tasks/arc058_a": FakeResponse(text=TASK_PAGE),
		"problem-models.json": FakeResponse(json_data={"arc058_a": {"difficulty": 1000}, "x": {}}),
	})
	p = ac.AtCoderProvider().fetch(("", "arc058_a"), ac_args, ctx)
	assert p.url == "https://atcoder.jp/contests/abc042/tasks/arc058_a"
	assert (p.id, p.title, p.heading, p.difficulty) == ("arc058_a", "Sum", "A - Sum", "Green")
	assert ("Difficulty", "1000 (AtCoder Problems estimate)") in p.meta
	assert len(calls) == 4


def test_fetch_without_difficulty_makes_no_extra_request(fake_http, ctx):
	calls = fake_http({"/contests/abc300/tasks/abc300_a": FakeResponse(text=TASK_PAGE)})
	p = ac.AtCoderProvider().fetch(("abc300", "abc300_a"), argparse.Namespace(refresh=False, no_difficulty=True), ctx)
	assert p.difficulty is None and len(calls) == 1
