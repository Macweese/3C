from __future__ import annotations

import pytest

from ccc.cli.providers import kattis as kt
from conftest import FakeResponse

PAGE = """
<html><head><title>Different - Kattis</title></head><body><h1 class="book-page-heading">A Different Problem</h1>
<div class="problembody"><p>Between <span class="tex2jax_process">$0$</span> and <span class="tex2jax_process">$10^{15}$</span>.</p>
<img class="illustration" src="/problems/different/file/statement/en/img-0001.png" alt="x">
<table class="sample" summary="sample data"><tr><th>Sample Input 1</th><th>Sample Output 1</th></tr>
<tr><td><pre>10 12\n</pre></td><td><pre>2\n</pre></td></tr></table></div>
<div class="metadata-grid">
<div class="card metadata-cpu-card"><i></i><div><span class="info_label">CPU Time limit</span><span>1 second</span></div></div>
<div class="card metadata-memory-card"><div><span class="info_label">Memory limit</span><span>1024 MB</span></div></div>
<div class="card metadata-difficulty-card"><span class="difficulty_number difficulty_easy">
    2.0 </span><div><span class="info_label">Difficulty</span><span class="text-lg">Easy</span></div></div>
<div class="card metadata-links-card"><span class="info_label">Links</span><a href="/x">Statistics</a></div>
<div class="card metadata-license-card"><span class="info_label">Source &amp; License</span><span>Kattis</span></div>
</div></body></html>
"""


def test_parse_input():
	assert kt.parse_input("Hello") == ("open.kattis.com", "hello")
	assert kt.parse_input("https://open.kattis.com/problems/10kindsofpeople?tab=x") == ("open.kattis.com", "10kindsofpeople")
	assert kt.parse_input("https://ncpc.kattis.com/contests/abc123/problems/a.b") == ("ncpc.kattis.com", "a.b")
	with pytest.raises(ValueError):
		kt.parse_input("hello world")


def test_parse_problem_page():
	title, body, tier, meta = kt.parse_problem_page(PAGE, "https://open.kattis.com/problems/different")
	assert (title, tier) == ("A Different Problem", "Easy")
	assert "Between $0$ and $10^{15}$." in body
	assert 'src="https://open.kattis.com/problems/different/file/statement/en/img-0001.png"' in body
	assert "<th>Sample Input 1</th>" in body and "<pre>10 12\n</pre>" in body
	assert meta == [("CPU time limit", "1 second"), ("Memory limit", "1024 MB"), ("Source & license", "Kattis"),
					("Difficulty", "2.0 (Easy)")]


def test_fetch(fake_http, args, ctx):
	fake_http({"open.kattis.com/problems/different": FakeResponse(text=PAGE)})
	p = kt.KattisProvider().fetch(("open.kattis.com", "different"), args, ctx)
	assert (p.id, p.title, p.difficulty, p.url) == ("different", "A Different Problem", "Easy",
													"https://open.kattis.com/problems/different")
