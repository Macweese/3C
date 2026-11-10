from __future__ import annotations

import pytest

from ccc.cli.providers import topcoder as tc
from conftest import FakeResponse

INDEX = [
	{"id": "18236", "name": "MinesweeperStrings", "type": "srm"},
	{"id": "1259", "name": "ZigZag", "type": "srm"},
	{"id": "7", "name": "ZigZag", "type": "srm"},  # older duplicate name
]

PAGE = (
	'<html><head><title>MinesweeperStrings | Topcoder Archive</title></head><body>'
	'<section class="hero"><div class="hero-meta"><span class="track srm">SRM</span><span>22 May 2024</span></div>'
	'<div class="eyebrow">SRM 855</div><h1>MinesweeperStrings</h1></section>'
	'<main><div class="problem-body"><article><div id="section-0"><h3>Problem Statement</h3><div><p>Strings of length <b>N</b>.</p></div></div>'
	'<div id="section-4"><h3>Examples</h3><ol><li><div><pre>1</pre><pre>Returns: "*"</pre></div></li></ol></div></article>'
	'<p class="legal">Property of Topcoder, Inc. <span class="legal-copyright">(c)2024</span></p></div>'
	'<aside class="sidebar"><section class="panel"><dl><div><dt>Topics</dt><dd><div class="topic-tags"><span>Math</span><span>Sorting</span></div></dd></div></dl>'
	'<ul><li><a href="/SRM/RoundOverview/rd/19800/index.html">SRM 855</a><div class="difficulty-tags">'
	'<span class="badge">Div 1 · Easy (Level 1)</span><span class="badge">Div 2 · Hard (Level 3)</span></div></li></ul></section>'
	'<section class="panel toc"><ul><li><a href="#section-0">Problem Statement</a></li></ul></section></aside></main></body></html>'
)


def _index():
	return {"minesweeperstrings": "18236", "zigzag": "1259"}


def test_resolve():
	never = lambda: pytest.fail("index must not be loaded for ids and URLs")
	assert tc.resolve("18236", never) == "18236"
	assert tc.resolve("https://archive.topcoder.com/SRM/ProblemStatement/pm/18236/index.html", never) == "18236"
	assert tc.resolve("https://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493", never) == "1259"
	assert tc.resolve("zigzag", _index) == "1259"
	with pytest.raises(ValueError, match="did you mean: minesweeperstrings"):
		tc.resolve("MinesweperStrings", _index)
	with pytest.raises(ValueError):
		tc.resolve("not a name!", _index)


def test_index_prefers_newest_duplicate(fake_http, args, ctx):
	fake_http({"problems.json": FakeResponse(json_data=INDEX)})
	assert tc.TopcoderProvider().expand("ZigZag", args, ctx) == ["1259"]


def test_parse_statement_page():
	title, body, difficulty, meta, topics, legal = tc.parse_statement_page(PAGE, tc.statement_url("18236"))
	assert (title, difficulty, topics) == ("MinesweeperStrings", "Div 1 Easy", ["Math", "Sorting"])
	assert meta == [("Round", "SRM 855: Div 1 · Easy (Level 1), Div 2 · Hard (Level 3)"), ("Date", "22 May 2024")]
	assert "<h3>Problem Statement</h3>" in body and "<pre>Returns: \"*\"</pre>" in body and "Property of" not in body
	assert legal == "Property of Topcoder, Inc. (c)2024"


def test_fetch(fake_http, args, ctx):
	fake_http({"/pm/18236/index.html": FakeResponse(text=PAGE)})
	p = tc.TopcoderProvider().fetch("18236", args, ctx)
	assert (p.id, p.title, p.difficulty, p.tags) == ("18236", "MinesweeperStrings", "Div 1 Easy", ["Math", "Sorting"])
	assert p.footer.startswith("Property of Topcoder")
