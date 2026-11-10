from __future__ import annotations

import pytest

from ccc.cli.core import http
from ccc.cli.providers import hackerrank as hr
from conftest import FakeResponse

BODY_HTML = (
	"<div class='challenge_problem_statement'><div class='msB challenge_problem_statement_body'><p>rendered</p></div></div>"
	"<div class='challenge_sample_input'><div class='msB challenge_sample_input_title'><p><strong>Sample Input 0</strong></p></div>"
	"<div class='msB challenge_sample_input_body'><div class='highlight'><pre><span class='err'>2</span>\n<span class='err'>abba</span>\n</pre></div></div></div>"
	"<div class='challenge_explanation'><div class='msB challenge_explanation_title'><p><strong>Explanation 0</strong></p></div>"
	"<div class='msB challenge_explanation_body'><p>Pairs of length <span class='MathJax_SVG'><svg><path d='M1'/></svg></span>.</p></div></div>"
)

MODEL = {
	"slug": "sherlock-and-anagrams", "name": "Sherlock and Anagrams", "difficulty_name": "Medium", "max_score": 50,
	"success_ratio": 0.9, "author_name": "darkshadows", "topics": [{"title": "Anagram", "slug": "anagram"}],
	"track": {"name": "Strings", "track_name": "Algorithms"},
	"problem_statement": "Find pairs in $s$.", "input_format": "An integer $q$.", "constraints": "$1 \\le q \\le 10$",
	"output_format": " ", "body_html": BODY_HTML,
}


def test_parse_input():
	assert hr.parse_input("Solve-Me-First") == ("master", "solve-me-first")
	assert hr.parse_input("https://www.hackerrank.com/challenges/ctci-ransom-note/problem") == ("master", "ctci-ransom-note")
	assert hr.parse_input("https://www.hackerrank.com/contests/w1/challenges/abc") == ("w1", "abc")
	with pytest.raises(ValueError):
		hr.parse_input("two words")


def test_challenge_url():
	assert hr.challenge_url("master", "x") == "https://www.hackerrank.com/challenges/x/problem"
	assert hr.challenge_url("w1", "x") == "https://www.hackerrank.com/contests/w1/challenges/x"


def test_build_body_prefers_markdown_and_takes_samples_from_html():
	body, lost = hr.build_body(MODEL, "https://www.hackerrank.com/challenges/x/problem")
	assert body.startswith("Find pairs in $s$.")
	assert "### Input Format\n\nAn integer $q$." in body and "### Constraints" in body
	assert "Output Format" not in body and "rendered" not in body
	assert "### Sample Input 0\n\n```text\n2\nabba\n```" in body
	assert "### Explanation 0" in body and hr.MATH_PLACEHOLDER in body and "svg" not in body
	assert lost is True


def test_build_body_falls_back_to_rendered_html():
	body, lost = hr.build_body({"body_html": BODY_HTML}, "https://www.hackerrank.com/challenges/x/problem")
	assert "<p>rendered</p>" in body and "<h3>Sample Input 0</h3>" in body and "<pre>2\nabba\n</pre>" in body
	assert lost is True


def test_fetch(fake_http, args, ctx):
	fake_http({"/rest/contests/master/challenges/sherlock-and-anagrams": FakeResponse(json_data={"model": MODEL})})
	p = hr.HackerRankProvider().fetch(("master", "sherlock-and-anagrams"), args, ctx)
	assert (p.id, p.title, p.difficulty, p.tags) == ("sherlock-and-anagrams", "Sherlock and Anagrams", "Medium", ["Anagram"])
	assert dict(p.meta) == {"Track": "Algorithms › Strings", "Max score": "50", "Success rate": "90.0%", "Author": "darkshadows"}
	assert hr.MATH_PLACEHOLDER in p.notice


def test_fetch_without_model(fake_http, args, ctx):
	fake_http({"/rest/contests/": FakeResponse(json_data={"model": None})})
	with pytest.raises(http.NotFoundError):
		hr.HackerRankProvider().fetch(("master", "nope"), args, ctx)
