#
#      Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
#
#      This program is free software: you can redistribute it and/or modify
#      it under the terms of the GNU Affero General Public License as
#      published by the Free Software Foundation, either version 3 of the
#      License, or (at your option) any later version.
#
#      This program is distributed in the hope that it will be useful,
#      but WITHOUT ANY WARRANTY; without even the implied warranty of
#      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#      GNU Affero General Public License for more details.
#
#      You should have received a copy of the GNU Affero General Public License
#      along with this program.  If not, see <http://www.gnu.org/licenses/>.
"""
AtCoder provider.

AtCoder has no public statement API, so task pages are scraped:

- https://atcoder.jp/contests/<contest>/tasks/<task>   statement, limits
- https://atcoder.jp/contests/<contest>/tasks          task list of a contest

Difficulty is not published by AtCoder; the estimate comes from the
community-run AtCoder Problems dataset (kenkoooo.com), which also maps task
ids to contests for tasks whose id does not start with their contest id.
"""

from __future__ import annotations

import math
import re
from typing import Dict, Hashable, List, Optional, Sequence, Tuple

from ..core import cache, http
from ..core.markup import clean_html, parse_html, text_of
from ..core.problem import Problem
from ..core.provider import ProviderContext
from ..core.statements import StatementProvider

BASE = "https://atcoder.jp"
RESOURCES = "https://kenkoooo.com/atcoder/resources"
MODELS_CACHE = "atcoder_difficulty.json"
CONTESTS_CACHE = "atcoder_task_contests.json"
WEEK = 7 * cache.DAY

_TASK_URL_RE = re.compile(r"atcoder\.jp/contests/([\w-]+)/tasks/(\w+)", re.IGNORECASE)
_CONTEST_URL_RE = re.compile(r"atcoder\.jp/contests/([\w-]+)", re.IGNORECASE)
_TASK_RE = re.compile(r"^[A-Za-z0-9]+(?:_[A-Za-z0-9]+)+$")
_CONTEST_RE = re.compile(r"^[A-Za-z0-9-]+$")
_LIMITS_RE = re.compile(r"Time Limit:\s*(.+?)\s*/\s*Memory Limit:\s*(.+)")
_TITLE_PREFIX_RE = re.compile(r"^\S+\s+-\s+")

# Rating colour bands, 400 points each.
_COLOURS = ("Gray", "Brown", "Green", "Cyan", "Blue", "Yellow", "Orange", "Red")

Ref = Tuple[str, str]  # (contest id, task id)


def parse_input(token: str) -> Tuple[Optional[str], Optional[str]]:
	"""
	Classify an input as (contest, task); either may be None.

	- task URL          -> (contest, task)
	- contest URL / id  -> (contest, None)   meaning "every task"
	- task id           -> (None, task)      contest inferred later
	"""
	m = _TASK_URL_RE.search(token)
	if m:
		return m.group(1).lower(), m.group(2).lower()
	m = _CONTEST_URL_RE.search(token)
	if m:
		return m.group(1).lower(), None
	if _TASK_RE.match(token):
		return None, token.lower()
	if _CONTEST_RE.match(token):
		return token.lower(), None
	raise ValueError("expected a task id (abc300_a), a contest id (abc300) or an atcoder.jp URL")


def guess_contest(task: str) -> str:
	"""abc300_a -> abc300; code_festival_2017_quala_a -> code-festival-2017-quala."""
	return task.rsplit("_", 1)[0].replace("_", "-")


def displayed_rating(raw: float) -> int:
	"""AtCoder Problems clips estimates below 400 so they stay positive."""
	return round(400 / math.exp(1 - raw / 400)) if raw < 400 else round(raw)


def colour_of(rating: int) -> str:
	return _COLOURS[min(max(rating, 0) // 400, len(_COLOURS) - 1)]


def _build_models(ctx: ProviderContext) -> Dict[str, int]:
	models = http.get(f"{RESOURCES}/problem-models.json", debug=ctx.debug, timeout=60).json()
	return {
		task: displayed_rating(model["difficulty"])
		for task, model in models.items()
		if isinstance(model.get("difficulty"), (int, float))
	}


def _build_task_contests(ctx: ProviderContext) -> Dict[str, str]:
	problems = http.get(f"{RESOURCES}/problems.json", debug=ctx.debug, timeout=60).json()
	return {p["id"]: p["contest_id"] for p in problems}


def list_contest_tasks(contest: str, ctx: ProviderContext) -> List[Ref]:
	soup = parse_html(http.get(f"{BASE}/contests/{contest}/tasks", debug=ctx.debug).text)
	prefix = f"/contests/{contest}/tasks/"
	tasks: Dict[str, None] = {}  # ordered set; every task is linked twice
	for a in soup.select(f'a[href^="{prefix}"]'):
		tasks.setdefault(a["href"][len(prefix):].split("?")[0].strip("/"))
	if not tasks:
		raise http.FetchError(f"no tasks listed for contest '{contest}' (not public yet?)")
	return [(contest, task) for task in tasks]


def parse_task_page(html: str, url: str) -> Tuple[str, str, List[Tuple[str, str]]]:
	"""Return (title, cleaned statement HTML, meta) for a task page."""
	soup = parse_html(html)
	statement = soup.select_one("#task-statement")
	if statement is None:
		raise http.FetchError("task page has no statement (login required or contest not public)")

	heading = soup.select_one("span.h2")
	# The heading also holds an "Editorial" link; only its own text is the title.
	title = " ".join(heading.find(string=True, recursive=False).split()) if heading else ""
	title = title or text_of(soup.title)

	meta: List[Tuple[str, str]] = []
	contest = soup.select_one("a.contest-title")
	if contest is not None:
		meta.append(("Contest", text_of(contest)))
	limits = _LIMITS_RE.search(soup.get_text(" "))
	if limits:
		meta += [("Time limit", limits.group(1).strip()), ("Memory limit", limits.group(2).strip())]

	# Recent tasks carry both languages; old ones are a single untagged block.
	body = statement.select_one("span.lang-en") or statement.select_one("span.lang-ja") or statement
	return title, clean_html(body, url, var_as_math=True), meta


class AtCoderProvider(StatementProvider):
	name = "ac"
	aliases = ("atcoder",)
	source = "AtCoder"
	display_name = "AtCoder"
	input_help = "Task id(s) (abc300_a), contest id(s) for every task (abc300), or atcoder.jp URL(s)."
	examples = (
		"3c ac abc300_a",
		"3c ac abc300 -j 4",
		"3c ac https://atcoder.jp/contests/dp/tasks/dp_a",
	)

	@classmethod
	def add_arguments(cls, parser) -> None:
		parser.add_argument("--no-difficulty", action="store_true",
							help="Skip the AtCoder Problems difficulty estimate (no kenkoooo.com request).")

	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		contest, task = parse_input(token)
		if task is None:
			return list_contest_tasks(contest, ctx)
		return [(contest or "", task)]

	def describe(self, ref: Hashable) -> str:
		return ref[1]

	def _get_page(self, contest: str, task: str, args, ctx: ProviderContext) -> Tuple[str, str]:
		"""Fetch the task page, resolving the contest when it was not given."""
		candidates = [contest] if contest else [guess_contest(task)]
		try:
			url = f"{BASE}/contests/{candidates[0]}/tasks/{task}"
			return http.get(url, params={"lang": "en"}, debug=ctx.debug).text, url
		except http.NotFoundError:
			if contest:
				raise
		# The id does not embed its contest (e.g. arc058_a is listed under abc042).
		mapping = cache.cached(CONTESTS_CACHE, lambda: _build_task_contests(ctx), max_age=WEEK, refresh=args.refresh)
		resolved = mapping.get(task)
		if not resolved or resolved in candidates:
			raise http.NotFoundError(f"task '{task}' does not exist")
		url = f"{BASE}/contests/{resolved}/tasks/{task}"
		return http.get(url, params={"lang": "en"}, debug=ctx.debug).text, url

	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		contest, task = ref
		html, url = self._get_page(contest, task, args, ctx)
		title, body, meta = parse_task_page(html, url)

		difficulty = None
		if not args.no_difficulty:
			try:
				ratings = cache.cached(MODELS_CACHE, lambda: _build_models(ctx), max_age=WEEK, refresh=args.refresh)
			except http.FetchError as e:
				ratings = {}  # the estimate is optional; the statement is not
				meta.append(("Difficulty", f"unavailable ({e})"))
			rating = ratings.get(task)
			if rating is not None:
				difficulty = colour_of(rating)
				meta.append(("Difficulty", f"{rating} (AtCoder Problems estimate)"))

		return Problem(
			source=self.source,
			source_name=self.display_name,
			id=task,
			title=_TITLE_PREFIX_RE.sub("", title) or title,
			heading=title,
			url=url,
			body=body,
			difficulty=difficulty,
			meta=meta,
		)
