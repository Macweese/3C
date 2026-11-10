from __future__ import annotations

import pytest

from ccc.cli.core import http
from ccc.cli.providers import codingame as cg
from conftest import FakeResponse

PUZZLE = {
	"id": 5, "level": "easy", "title": "The Descent", "type": "SOLO", "prettyId": "the-descent",
	"detailsPageUrl": "/training/easy/the-descent", "solvedCount": 7, "communityCreation": True,
	"statement": '<div id="statement_back" style="display:none">&nbsp;</div><div class="statement-body">'
				 '<h2><span class="icon icon-goal">&nbsp;</span> <span>The Goal</span></h2>'
				 '<div class="statement-goal-content">Shoot <var>mountainH</var>. <img src="/fileservlet?id=1"/></div></div>',
	"topics": [{"value": "Fundamentals", "children": [{"value": "Loops", "children": []}]}, {"value": "Loops"}],
}


def test_parse_input():
	assert cg.parse_input("The-Descent") == "the-descent"
	assert cg.parse_input("https://www.codingame.com/training/easy/ascii-art") == "ascii-art"
	assert cg.parse_input("https://www.codingame.com/ide/puzzle/onboarding") == "onboarding"
	assert cg.parse_input("https://www.codingame.com/multiplayer/bot-programming/tron-battle") == "tron-battle"
	with pytest.raises(ValueError):
		cg.parse_input("not a puzzle")


def test_flatten_topics():
	assert cg.flatten_topics(PUZZLE["topics"]) == ["Fundamentals", "Loops"]
	assert cg.flatten_topics(None) == []


def test_fetch(fake_http, args, ctx):
	calls = fake_http({"findProgressByPrettyId": FakeResponse(json_data=PUZZLE)})
	p = cg.CodinGameProvider().fetch("the-descent", args, ctx)
	assert calls[0][0] == "POST" and calls[0][2]["json"] == ["the-descent", None]
	assert (p.id, p.title, p.difficulty) == ("the-descent", "The Descent", "Easy")
	assert p.url == "https://www.codingame.com/training/easy/the-descent"
	assert "The Goal" in p.body and "<var>mountainH</var>" in p.body
	assert 'src="https://www.codingame.com/fileservlet?id=1"' in p.body
	assert ("Origin", "Community puzzle") in p.meta and p.tags == ["Fundamentals", "Loops"]


def test_fetch_unknown_puzzle(fake_http, args, ctx):
	class Null(FakeResponse):
		def json(self):
			return None

	fake_http({"findProgressByPrettyId": Null()})
	with pytest.raises(http.NotFoundError):
		cg.CodinGameProvider().fetch("nope", args, ctx)
