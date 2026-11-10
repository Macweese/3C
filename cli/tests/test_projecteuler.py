from __future__ import annotations

import pytest

from ccc.cli.core import http
from ccc.cli.providers import projecteuler as pe
from conftest import FakeResponse

INDEX = "ID##Title##Published##Solved By\n1##Multiples of 3 or 5##2001-10-05 17:00:00##847162\n"


def test_parse_input():
	assert pe.parse_input("12") == [12]
	assert pe.parse_input("3-5") == [3, 4, 5]
	assert pe.parse_input("5..3") == [3, 4, 5]
	assert pe.parse_input("https://projecteuler.net/problem=96") == [96]
	for bad in ("abc", "1-999999", ""):
		with pytest.raises(ValueError):
			pe.parse_input(bad)


def test_fetch(fake_http, args, ctx):
	fake_http({
		"minimal=problems": FakeResponse(text=INDEX),
		"minimal=1": FakeResponse(text='<p>Find $x$ <img src="resources/images/a.png"></p>' + " " * 200),
	})
	p = pe.ProjectEulerProvider().fetch(1, args, ctx)
	assert (p.id, p.title, p.heading) == ("1", "Multiples of 3 or 5", "1. Multiples of 3 or 5")
	assert p.url == "https://projecteuler.net/problem=1"
	assert 'src="https://projecteuler.net/resources/images/a.png"' in p.body
	assert ("Published", "2001-10-05") in p.meta and ("Solved by", "847162") in p.meta


def test_fetch_unknown_problem(fake_http, args, ctx):
	fake_http({"minimal=9999": FakeResponse(text="Data for that problem cannot be found")})
	with pytest.raises(http.NotFoundError):
		pe.ProjectEulerProvider().fetch(9999, args, ctx)
