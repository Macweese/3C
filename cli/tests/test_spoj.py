from __future__ import annotations

import pytest

from ccc.cli.core import http
from ccc.cli.providers import spoj
from conftest import FakeResponse

# Hand-written after SPOJ's page layout; the live site could not be sampled.
PAGE = """
<html><body><div class="prob">
<h2 id="problem-name" class="text-center">TEST - Life, the Universe, and Everything</h2>
<div id="problem-tags"><a href="/problems/tag/basics"><span class="problem-tag">#basics</span></a>
<a href="/problems/tag/tutorial"><span class="problem-tag">#tutorial</span></a></div>
<div id="problem-body"><p>Rewrite small numbers from input to output. <a href="/files/x.txt">file</a></p>
<h3>Example</h3><pre><b>Input:</b>\n1\n42\n\n<b>Output:</b>\n1\n</pre></div>
<table id="problem-meta" class="table"><tbody>
<tr><td>Added by:</td><td><a href="/users/mima">mima</a></td></tr>
<tr><td>Date:</td><td>2004-05-01</td></tr>
<tr><td>Time limit:</td><td>1s</td></tr>
<tr><td>Memory limit:</td><td>1536MB</td></tr>
<tr><td>Languages:</td><td>All</td></tr>
</tbody></table></div></body></html>
"""


def test_parse_input():
	assert spoj.parse_input("test") == "TEST"
	assert spoj.parse_input("https://www.spoj.com/problems/PRIME1/") == "PRIME1"
	assert spoj.parse_input("https://www.spoj.com/PL/problems/abc_1/") == "ABC_1"
	with pytest.raises(ValueError):
		spoj.parse_input("no-dashes")


def test_parse_problem_page():
	title, body, meta, tags = spoj.parse_problem_page(PAGE, "https://www.spoj.com/problems/TEST/", "TEST")
	assert (title, tags) == ("Life, the Universe, and Everything", ["basics", "tutorial"])
	assert meta == [("Time limit", "1s"), ("Memory limit", "1536MB"), ("Added by", "mima"), ("Date", "2004-05-01")]
	assert 'href="https://www.spoj.com/files/x.txt"' in body and "<b>Input:</b>\n1\n42" in body


def test_fetch(fake_http, args, ctx):
	fake_http({"/problems/TEST/": FakeResponse(text=PAGE)})
	p = spoj.SpojProvider().fetch("TEST", args, ctx)
	assert (p.id, p.heading, p.difficulty) == ("TEST", "TEST - Life, the Universe, and Everything", None)


def test_fetch_reports_anti_bot_challenge(fake_http, args, ctx):
	fake_http({"/problems/TEST/": http.BlockedError("challenge")})
	with pytest.raises(http.BlockedError):
		spoj.SpojProvider().fetch("TEST", args, ctx)
