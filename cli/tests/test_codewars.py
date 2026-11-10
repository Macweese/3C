from __future__ import annotations

import pytest

from ccc.cli.providers import codewars as cw
from conftest import FakeResponse

KATA = {
	"id": "5277c8a221e209d3f6000b56", "name": "Valid Braces", "slug": "valid-braces", "category": "algorithms",
	"languages": [f"lang{i}" for i in range(15)], "url": "https://www.codewars.com/kata/5277c8a221e209d3f6000b56",
	"rank": {"id": -6, "name": "6 kyu"}, "createdBy": {"username": "xDranik"},
	"description": "Write a function.\n\n```\n\"(){}[]\" => True\n```\n", "totalAttempts": 10, "totalCompleted": 4,
	"tags": ["Algorithms"],
}


def test_parse_input():
	assert cw.parse_input("valid-braces") == "valid-braces"
	assert cw.parse_input("https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/python") == "5277c8a221e209d3f6000b56"
	with pytest.raises(ValueError):
		cw.parse_input("two words")


def test_fetch(fake_http, args, ctx):
	fake_http({"/code-challenges/valid-braces": FakeResponse(json_data=KATA)})
	p = cw.CodewarsProvider().fetch("valid-braces", args, ctx)
	assert (p.id, p.title, p.difficulty, p.tags) == ("valid-braces", "Valid Braces", "6 kyu", ["Algorithms"])
	assert p.body.startswith("Write a function.") and "```" in p.body  # Markdown kept verbatim
	meta = dict(p.meta)
	assert meta["Completed / attempts"] == "4 / 10" and meta["Languages"].endswith("(+3 more)")


def test_fetch_beta_kata_has_no_rank(fake_http, args, ctx):
	fake_http({"/code-challenges/x": FakeResponse(json_data={**KATA, "rank": {"id": None, "name": None}})})
	assert cw.CodewarsProvider().fetch("x", args, ctx).difficulty is None
