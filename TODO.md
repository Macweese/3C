# TODO Roadmap
Clear, staged roadmap with concrete deliverables, folder layout, and a few starter code skeletons to get the ball rolling confidently.

<br>

**High-level roadmap**

- ### Phase 0: Quick wins and hygiene
  * [ ]   Make rich a hard dependency in packaging (so pipx installs it).
  * [ ]   Add `--version` and 3c doctor commands.
  * [ ]   Add global `--force-color`/`--no-color` and color diagnostics now standardized across providers.
- ### Phase 1: Project restructuring and core architecture
  * [ ]   Rename `generator/...` to `cli/...`
  * [ ]   Create a provider architecture with a clean Provider base class, registry, and dispatch from a central CLI.
  * [ ]   Break out reusable concerns: logging, progress, filecheck, utils.
- ### Phase 2: UX polish
  * [ ]   Rich-formatted help across CLI (rich-argparse).
  * [ ]   Consistent colorized messages, debug output, and a small theme.
  * [ ]   Progress bars for batch and per-item (Rich Progress).
- ### Phase 3: Filechecker and overwrite policy
  * [ ]   Pre-run compute planned outputs, check for existence, decide skip/overwrite/ask.
  * [ ]   Add flags: `--force`, `--dry-run`, `--no-overwrite`, `--interactive` (optional).
- ### Phase 4: Add providers
  * [ ]   CodeGolf: all, by category, latest, random, fuzzy lookup.
  * [ ]   ProjectEuler: single id, range, recent 10.
  * [ ]   Codeforces: tags, ranges; careful rate limiting and pagination.
  * [ ]   Others later (AtCoder, Kattis, NeetCode, CSES) once the framework is solid.
- ### Phase 5: Performance and robustness
  * [ ]   Threaded batch with concurrency control and request backoff.
  * [ ]   Rotating file logs, error reporting, retries, and cache improvements.
  * [ ]   Cross-platform checks (permissions, locales).
- ### Phase 6: Docs and distribution
  * [ ]   Update 3C CLI README and project README.
  * [ ]   “Doctor” command to validate environment.
  * [ ]   Testing (unit + integration), linting, type checks.
  * [ ]   Packaging polish and future OS package manager targets.

***

**Target directory layout**  
We’ll keep import path as the installed package ccc but reorganize its inner layout.


```text
ccc/                 # the installed package
  __init__.py
  cli/
    app.py           # unified 3c entrypoint
    core/
      provider.py    # Provider base class + registry
      logging.py     # Rich logger + file handler + themes
      progress.py    # Rich Progress wrapper(s)
      filecheck.py   # File existence logic and overwrite policy
      utils.py       # Shared utilities (env, paths, HTTP helpers)
    providers/
      leetcode.py    # current LC ported here
      codegolf.py    # new provider
      projecteuler.py
      codeforces.py
    templates/
      leetcode_readme.md.j2
    config.py        # CACHE_DIR, DEFAULT_OUT_DIR, etc. (moved)
    output_layout.py # unchanged, still used by providers
```

**CLI: central app + Provider interface**

- One entrypoint: 3c  
- Subcommands registered by providers via Provider.register(subparsers, parents=[common])
- Provider.run(args) handles logic
- Core utilities shared across providers

**Example skeletons**  
These are thin scaffolds to implement in Phase 1. They won’t change behavior yet; they make future work faster and cleaner.

<br>

`ccc/cli/core/providers.py`  
```python
from __future__ import annotations
import abc
from argparse import _SubParsersAction, ArgumentParser
from typing import Optional, List, Dict, Any, Type

class Provider(abc.ABC):
    """
    Base class for all providers (LeetCode, CodeGolf, etc.).
    Providers must implement register_subparser and run.
    """
    name: str = ""          # short command, e.g. "lc"
    help: str = ""          # one-line help
    description: str = ""   # long help

    @abc.abstractmethod
    def register_subparser(self, subparsers: _SubParsersAction, parents: Optional[List[ArgumentParser]] = None) -> ArgumentParser:
        raise NotImplementedError

    @abc.abstractmethod
    def run(self, args) -> int:
        raise NotImplementedError


class ProviderRegistry:
    _providers: Dict[str, Type[Provider]] = {}

    @classmethod
    def register(cls, provider_cls: Type[Provider]) -> None:
        if not provider_cls.name:
            raise ValueError("Provider must define a non-empty name")
        cls._providers[provider_cls.name] = provider_cls

    @classmethod
    def install_subcommands(cls, subparsers: _SubParsersAction, parents: Optional[List[ArgumentParser]] = None) -> None:
        for prov_name, prov_cls in cls._providers.items():
            prov = prov_cls()
            parser = prov.register_subparser(subparsers, parents=parents)
            parser.set_defaults(_provider_instance=prov)

    @classmethod
    def names(cls) -> List[str]:
        return sorted(cls._providers.keys())
```

<br>

`ccc/cli/app.py`
```python
import argparse
import sys
from .core.provider import ProviderRegistry
from .core import logging as clog

def build_common_parser() -> argparse.ArgumentParser:
    common = argparse.ArgumentParser(add_help=False)
    common.add_argument("--debug", action="store_true", help="Enable debug output.")
    common.add_argument("--no-color", action="store_true", help="Disable colored output (or set NO_COLOR=1).")
    common.add_argument("--force-color", action="store_true", help="Force colored output (or set FORCE_COLOR=1).")
    common.add_argument("--color-diag", action="store_true", help="Print color diagnostics at start.")
    common.add_argument("--version", action="store_true", help="Print version and exit.")
    return common

def main() -> int:
    common = build_common_parser()
    parser = argparse.ArgumentParser(prog="3c", description="3C CLI — Competitive Coding Challenge generators", add_help=True)
    subparsers = parser.add_subparsers(dest="cmd", required=False, metavar="{" + ",".join(ProviderRegistry.names() or ["lc"]) + "}")

    # Install subcommands from registered providers
    ProviderRegistry.install_subcommands(subparsers, parents=[common])

    args = parser.parse_args()

    # Global flags processed here
    clog.init_consoles(no_color=getattr(args, "no_color", False), force_color=getattr(args, "force_color", False))
    if getattr(args, "color_diag", False):
        clog.color_diag()

    if getattr(args, "version", False):
        clog.console_print("3C CLI version: 0.2.0", style="green")
        return 0

    prov = getattr(args, "_provider_instance", None)
    if prov is None:
        parser.print_help()
        return 2

    return prov.run(args)

if __name__ == "__main__":
    sys.exit(main())
```
<br>

`ccc/cli/core/logging.py`
```python
from __future__ import annotations
import os
import sys
from typing import Optional

_RICH_AVAILABLE = True
try:
    from rich.console import Console
    from rich.text import Text
    from rich.traceback import install as rich_traceback_install
except Exception:
    _RICH_AVAILABLE = False
    Console = None  # type: ignore
    Text = None     # type: ignore
    def rich_traceback_install(*args, **kwargs):  # type: ignore
        return None

console: Optional["Console"] = None
err_console: Optional["Console"] = None

def init_consoles(no_color: bool = False, force_color: bool = False) -> None:
    global console, err_console
    if not _RICH_AVAILABLE:
        console = None
        err_console = None
        return
    console = Console(no_color=no_color or bool(os.environ.get("NO_COLOR")), force_terminal=force_color or bool(os.environ.get("FORCE_COLOR")), highlight=False, soft_wrap=False)
    err_console = Console(stderr=True, no_color=no_color or bool(os.environ.get("NO_COLOR")), force_terminal=force_color or bool(os.environ.get("FORCE_COLOR")), highlight=False, soft_wrap=False)
    rich_traceback_install(show_locals=False, extra_lines=1, console=err_console)

def color_diag() -> None:
    if console is None or err_console is None:
        print("[color-diag] rich not available", file=sys.stderr)
        return
    err_console.print(Text("[color-diag] rich available", style="green"))
    err_console.print(Text(f"[color-diag] console.is_terminal={console.is_terminal}", style="yellow"))  # type: ignore
    err_console.print(Text(f"[color-diag] console.color_system={console.color_system}", style="yellow"))  # type: ignore

def console_print(msg: str, style: Optional[str] = None, stderr: bool = False) -> None:
    if console is None or err_console is None:
        stream = sys.stderr if stderr else sys.stdout
        print(msg, file=stream)
        return
    (err_console if stderr else console).print(Text(msg, style=style) if style else msg)

def success_saved(path_text, details_text) -> None:
    if console is None:
        print(f"Saved {path_text}{details_text}")
        return
    from rich.text import Text
    head = Text("Saved", style="green")
    if not isinstance(path_text, Text):
        path_text = Text(str(path_text))
    if not isinstance(details_text, Text):
        details_text = Text(str(details_text), style="deep_sky_blue3")
    console.print(Text.assemble(head, Text(" "), path_text, details_text))
```
<br>

`ccc/cli/core/progress.py`
```python
from __future__ import annotations
from typing import Iterator, Optional, Iterable
import contextlib

try:
    from rich.progress import Progress, BarColumn, TextColumn, TimeElapsedColumn, TimeRemainingColumn, SpinnerColumn
    _RICH_PROGRESS = True
except Exception:
    _RICH_PROGRESS = False

@contextlib.contextmanager
def progress_context(disable: bool = False):
    if not _RICH_PROGRESS or disable:
        yield None
        return
    with Progress(
        SpinnerColumn(),
        TextColumn("[progress.description]{task.description}"),
        BarColumn(bar_width=None),
        TextColumn("[green]{task.completed}/{task.total}"),
        TimeElapsedColumn(),
        TimeRemainingColumn(),
        transient=False,
    ) as prog:
        yield prog

def track_iter(iterable: Iterable, prog: Optional["Progress"], description: str):
    if prog is None:
        for item in iterable:
            yield item
        return
    task = prog.add_task(description, total=len(iterable) if hasattr(iterable, "__len__") else None)
    for item in iterable:
        yield item
        prog.advance(task)
```
<br>

`ccc/cli/core/filechec.py`
```python
from __future__ import annotations
from dataclasses import dataclass
from pathlib import Path

@dataclass
class FileDecision:
    path: Path
    exists: bool
    action: str  # "skip", "overwrite", "create"
    reason: str

def decide(path: Path, force: bool = False) -> FileDecision:
    if path.exists():
        if force:
            return FileDecision(path, True, "overwrite", "Force enabled")
        return FileDecision(path, True, "skip", "Already exists")
    return FileDecision(path, False, "create", "Not present")
```

**Provider example: LeetCode**  
Refactor existing `leetcode_readme_gen.py` into `ccc/cli/providers/leetcode.py`.   

It will:
- Implement Provider
- Reuse output_layout and config
- Use core.logging (success_saved, console_print)
- Use core.filecheck to decide overwrite/skip
- Use core.progress to report batch progress
- Keep your path coloring helper as-is, but move it into a small path utils module (or into provider if LC-specific)

**Help formatting**

- Use rich-argparse to color and format argparse help. We’ll add it as a dependency, then use RichHelpFormatter:
  - `from rich_argparse import RichHelpFormatter`
  - `parser = argparse.ArgumentParser(..., formatter_class=RichHelpFormatter)`
- We already have SmartFormatter for raw lines; RichHelpFormatter subsumes that with much nicer defaults.

**Filechecker behavior**

- Flags:
  - `--force`: overwrite if file exists
  - `--dry-run`: plan and print what would happen without writing
  - `--no-overwrite` (default behavior): skip file if exists
- LC nuance: we must fetch problem metadata first to compute intended output directory. That’s fine:
  - Fetch minimal info (id, slug, difficulty)
  - Compute `out_dir/README.md`
  - Run `filecheck.decide()`
  - If skip: `print “[SKIP] Duplicate — LeetCode {id}. {title}”` and do not render
  - If overwrite/create: proceed to render

**Progress bars**

- Batch: show total tasks processed
- Per-item: optionally show a small spinner when fetching network content
- Non-TTY: auto-disables

**Concurrency**

- Use ThreadPoolExecutor with a bounded pool (default 4–6).
- Share a small rate limiter for APIs with stricter limits (e.g., LeetCode).
- Respect retries/backoff already implemented.
- Update progress safely (Rich Progress is thread-safe if you call from main thread; otherwise, submit progress updates back to main via queue or use Progress from the main thread only).

**Logging to file**

- Add a rotating file handler (e.g., logs/3c.log under ~/.3c or alongside cache)
- Keep Rich console logs for the terminal and write detailed timestamps to file logs.

**Donut mode**

- `--donut`: spawn a daemon thread that renders the ASCII donut when idle/waiting
- Stop thread cleanly at exit or on SIGINT
- Disable when not a TTY or when progress bars are active, to avoid contention (or place donut animation above progress with live layout).

### Provider plans

- #### CodeGolf
  - Endpoints:
    - `GET /api/holes`
    - `GET /api/holes/{slug}`
  - Commands:
    - `3c golf all`
    - `3c golf latest [--category X]`
    - `3c golf random [--category X] [--exclude-existing]`
    - `3c golf <name or slug>` with fuzzy match (rapidfuzz)
    - `3c golf --category X` (fetch all in category)
  - Logic:  load all holes into cache; compute slug/name maps; check existing files via filechecker before rendering.
- #### ProjectEuler
  - `3c pe 513`
  - `3c pe 23-29`
  - `3c pe --recent` (scrape recent page, present list, optional interactive selection)
- #### Codeforces
  - Start with `3c cf --tags` implementation
  - Provide `3c cf <id>`?  
    (CF ids are tricky: problem = contestId + index; so we’ll support 3c cf <contestId><index> e.g. 1760A)
  - Rate limiting and caching are important.

### Docs updates

- #### 3C CLI README
  - Installation (pipx install ccc), mention rich
  - Usage: `3c lc`, `3c golf`, `3c pe`, etc.
  - Global flags: `--debug`, `--force-color`, `--no-color`, `--color-diag`, `--version`
  - Overwrite policy flags: `--force`, `--dry-run`
  - Output layouts
- #### Project README
  - Vision, providers, architecture, contributing
  - Screenshots/GIFs of progress bars and colored outputs

### Testing and quality

- ruff + mypy/pyright
- Minimal contract tests for:
  - `output_layout.compute_output_dir`
  - `core.filecheck.decide`
  - path anchor renderer
  - LC parser split for examples/constraints (some fixtures)
- Integration: run a couple of LC problems with `--dry-run` in CI.

### Open questions and recommendations

- Concurrency default for LC: start conservative (e.g., 4 workers), allow `--jobs N`
- LC “also similar”: optionally treat similar as a second queue and show progress across both phases
- Rich dependencies:
  - Add `rich` and `rich-argparse` to `install_requires` so `pipx` always has them
- Interactive fuzzy select:
  - `RapidFuzz` for scoring; print top matches if not exact
  - Consider optional interactive select later with “`InquirerPy`” if desired (not required)

### Next steps (actionable)

- #### Phase 1 coding
  1) Create `ccc/cli/core` modules (`provider.py`, `logging.py`, `progress.py`, `filecheck.py`).
  2) Move central CLI to `ccc/cli/app.py`, wire `ProviderRegistry`.
  3) Port current LeetCode code to `ccc/cli/providers/leetcode.py` implementing Provider; keep functionality same.
  4) Keep existing templates and output_layout; adjust imports.
  5) Add packaging dependency on rich and rich-argparse; add entry point in pyproject:
     ```
     [project.scripts] 
         3c = "ccc.cli.app:main"
     ```
- #### Phase 2
  6) Add RichHelpFormatter to CLI parsers for colored help.
  7) Introduce `--force`, `--dry-run` and filecheck usage in LC provider.
  8) Add batch progress bar using core.progress.
- #### Phase 3
  9) Implement CodeGolf provider (read-only first: fetch by slug or list; generate README).
  10) ProjectEuler provider (single id + range + recent scrape).
- #### Phase 4
  11) Logging to file (rotating logs).
  12) Concurrency (`--jobs`) with cautious defaults and shared limiter.
- #### Phase 5
  13) Update READMEs (3C CLI + root project).
  14) Add 3c doctor and richer `--version` output (versions of libs, platform info).
  15) Basic CI (lint + tests).

**Delegate work to team member:**

- Generate the initial skeleton files (Phase 1) as PR-ready code so you can start moving LC into providers/leetcode.py?
- Or start with CodeGolf provider scaffolding too?

Either way, produce the refactor patches in file blocks next.

---

I think we should draw up a plan for what to do next.The other things I want to accomplish (in no particular order):

- Rename the cli project structure from `./generator/...` to `./cli/...`
- restructure the 3C CLI so that it is organized and ready to expand with more providers, e.g. breaking out things into their own classes.
- Update 3C CLI README + project README
- Format / colorize the `--help` commands / options etc
- Add progressbar in the CLI for displaying README generation progress (both for indivdual and bulk)
- Filechecker
  A pre-running task that is started before beginning generating a README run by a provider.
  This is to check if the intended file already exists, so that we don't do work that is unneccessary.
  NOTE:
  I simultaneously, with this feature addition, want to add a command arg to allow forcing/overwriting, if the file does exists
  So for example, `3c lc 4` would fetch the info needed for the problem, (because if the user is using a specific folder structure like {difficulty}/{id} we need to know the difficulty, in order to check for an existing file) and then if the file already exists, abstain from generating a README.md, and print a useful message to the console, like "[SKIP] Duplicate - LeetCode ${id}. ${title}". Or if the force/overwrite option is enabled, then overwrite the file.
- Add README providers / generators for (command short ver | long ver):
  - CodeGolf (command: golf | codegolf) (they dont have any robots.txt or robots constraints)https://petstore.swagger.io/?url=https://code.golf/api#/ -> https://code.golf/apie.g.https://code.golf/api/holes/ returns all  questions aka "holes"https://code.golf/api/holes/24-game returns specific question ("hole") "24 Game"Things to implement:

    - Fetch & generate README for ALL holes (through something like a commmand `3c golf all`)
    - Fetch & generate README for specific hole, this is a little trickier, because the user needs to know the actual name and accurately type it out.Ideas on how to solve this:
      - Implement something like a fuzzy-finder.
      - Provide a list of already existing / generated holes in the repo
        This is also tricky to solve, because the user could have saved the challenges in their own schema, e.g. flat or some other way. So unless they use the default folder structure which the 3C CLI generator uses, we would have to first fetch all questions from the api, create a kind of map in memory, then search every folder in `./challenges/` or wherever the user saves questions, and determine which questions exist on the users machine out of the full question map.
        Then present the result as a list in the CLI?
        e.g.
        24 Game	(pad with something like 100 spaces)	:checkmark:
        Arithmetic Numbers 	(padding)				:checkmark:
        Fizz Buzz 	(padding)						:x:
        Tutorial 	(padding)						:x:
        Ascending Primes 	(padding)				:checkmark:
    - Fetch & generate README for specific category
      e.g. all holes in the category "mathematics"
      This would need to be solved in the same way as the above, we would need to check what the user already has, out of the existing holes from api/holes (all holes), then filter the map based on the category.
    - Fetch & generate README for most recently added hole
      e.g. `3c golf latest` or `3c golf --mathematics --latest` or something like that (we'll figure out the naming later)
      This would get the most recently added hole in that category, again, same as other features, we need to get all holes, then filter on the properties.
    - Fetch & generate README for random hole
      e.g. `3c golf --random` or `3c golf cat --mathematics random` or something...
      This would get a random hole, either out of all holes or for the category, if a category is passed as an arg/option. Again, check what the user has so the randomly picked hole isn't something the user already has.
      If the user already has all the holes, e.g. for the category they wanted or already has all the holes available then I guess we print something to the console like "You already have all the holes available [for this category if the user specified a category filter]"
    - Maybe some auxilary commands (can't think of any right now though)
  - ProjectEuler (command: pe | projecteuler) (they dont have any robots.txt or robots constraints)I couldn't find if they had a public api, but the url format is very simple:For a specific problem -> https://projecteuler.net/problem={id}A page for 10 most recent problems exists at -> https://www.projecteuler.net/recent , and the results are presented in a table on the page, we can just use beautifulsoup to grab those, and print to the console for the user to choose from.So the commands for this source could be something like

    - `3c pe 513` get problem id 513
    - `3c pe 23-29` get problems with id between 23-29 (inclusive)
    - `3c pe --recent` get list of 10 most recently published problems
      Essentially, this works nearly identical to the leetcode provider, just uses a different source.
  - Codeforces (command: cf | codeforces)  (they dont have any robots.txt, but they specify disallowing robots for AI, specifically imageAI, so we are in the clear)
    They have a public API which we can use:
    https://codeforces.com/apiHelp
    https://codeforces.com/apiHelp/methods
    https://codeforces.com/apiHelp/methods#problemset.problems
    https://codeforces.com/api/problemset.problems?tags=implementation
    Very well documented and open, perfect! The only thing about this is, they have such a massive repository of problems that I think generating large amounts of READMEs could be difficult, since there exists some ~20,000 problems.
  - AtCoder (command: ac | atcoder)
    This one is a little tricky to do, since they don't explicitly have an open API, have individual problems nor follow an easy schema e.g. REST that can be used to fetch problems.
    Instead, they have contests, which contain a number of problems. These contests are named by their abbreviation, e.g. 2014 Annual Beginner Contest 23 becomes abc23. And there's no easy way to know which contests exist, so building a request for an endpoint requires one to know beforehand what the name is, unlike e.g. leetcode where we are able to simply pass in a problem id, instead of the problem title.
    It can still be done, but is a little odd and might not be user friendly. I don't know. I mean I suppose (I'm just guessing though, that users who intend on using this will be familiar with atCoder, so maybe it will work anyway, as they'd be familiar with the naming convention) it might be alright anyway.
  - Kattis (command: ka | kattis) (no robots.txt exist, nor do they specify anything about scraping/use of automation to visit/fetch data)
    They have a problems page, but a bit like atCoder, they don't provide a public API or have a naming schema that facilitates fetching a specific problem. Instead all the problems are by name, or contest which they belong to.
  - TopCoder (command: tc | topcoder) *** WE SKIP THIS SOURCE FOR NOW ***
  - CodeWars (command: cw | codewars) (no robots.txt or any advisory prohibiting automation/scraping)
    They offer a public API to facilitate fetching data
    https://dev.codewars.com/#introduction
    https://dev.codewars.com/#code-challenges-api
    https://dev.codewars.com/#get-code-challenge
  - HackerRank (command: hr | harckerrank) (no robots.txt or any advisory prohibiting automation/scraping) *** WE SKIP THIS SOURCE FOR NOW ***
  - CodinGame (command: cg | codingame) *** WE SKIP THIS SOURCE FOR NOW ***
  - getCracked.io (command: gc | cracked | getcracked) *** WE SKIP THIS SOURCE FOR NOW ~~~ REQUIRES LOGIN / ACCOUNT REGISTRATION ***
  - NeetCode (command: nc | neetcode) <<< REALLY GOOD RESOURCE (Very similar to leetcode, but doesn't have a similarly easy way to fetch problems)
    Definitely want to implement problem fetching from this source
  - CSES.fi (command: cses) (No robots.txt or any kind of advisory prohibiting automation/scraping)
    This is an gem of a resource, worth absolute gold. Contains many problems, problem sets, categories, themes and contest problem sets.
    Unfortunately there doesn't seem to be any public API (at least no links to an API or any documentation for an API). The content is somewhat structured, which is good, but there seems to be gaps in the contents.
    E.g.
    problem urls are formed as https://cses.fi/problemset/task/{id}
    But the {id} is not guaranteed to exist
    Even though the page does, i.e. visiting a problem that does not exist, let's say https://cses.fi/problemset/task/9999999999999999999999999999999 would serve a skeleton page.
    Courses live on their own page, and the tasks for a contest are named numerically, i.e. 1-99999999... (varies in size, though I only saw courses id in the range 1000-10000)
    Cources lists:
    https://cses.fi/alon/list/
    https://cses.fi/boi/list/
    https://cses.fi/ceoi/list/
    https://cses.fi/problemset/list/
    https://cses.fi/dt/list/
    https://cses.fi/pfp25/list/
    https://cses.fi/tira25s/list/
    Contests live on their own page, and the tasks for a contest are named alphabetically, i.e. A-Z (varies in size)
    So for the contest id=5
    https://cses.fi/5/list/
    The problems would be
    https://cses.fi/5/task/A
    https://cses.fi/5/list/B
    ...
    https://cses.fi/5/list/{UNKNOWN_WHAT_THE_LAST_PROBLEM_LETTER_IS_BECAUSE_THE_PROBLEM_QUANTITY_FOR_CONTESTS_VARY}
    And for contest id=544
    https://cses.fi/544/list/
    The problems would be found at
    https://cses.fi/544/task/A
    https://cses.fi/544/task/...

    Contests lists:
    https://cses.fi/544/list/
    https://cses.fi/524/list/
    https://cses.fi/510/list/
    https://cses.fi/490/list/
    https://cses.fi/484/list/
    https://cses.fi/438/list/
    https://cses.fi/430/list/
    https://cses.fi/389/list/
    https://cses.fi/367/list/
    https://cses.fi/359/list/
    https://cses.fi/358/list/
    https://cses.fi/337/list/
    https://cses.fi/325/list/
    https://cses.fi/314/list/
    https://cses.fi/251/list/
    https://cses.fi/241/list/
    https://cses.fi/231/list/
    https://cses.fi/228/list/
    https://cses.fi/214/list/
    https://cses.fi/177/list/
    https://cses.fi/159/list/
    https://cses.fi/128/list/
    https://cses.fi/102/list/
    https://cses.fi/95/list/
    https://cses.fi/93/list/
    https://cses.fi/80/list/
    https://cses.fi/59/list/
    https://cses.fi/57/list/
    https://cses.fi/56/list/
    https://cses.fi/42/list/
    https://cses.fi/5/list/
  - IOI (command: ioi)
- Add logging
  Output to .log file
- Add multi-threading for batch generating (? ~)
- Add a fun little novelty/trivia feature `--donut` option, to render a spinning ASCII donut in the console using the attached code.
- chore stuff, like documentation, semver, checkstyle, tests, linting
- Robustness, I'm sure there are things I may have overlooked with the current implementation of things, e.g. if someone else wants to fork and use this tool. I need to ensure it's stable on e.g. MacOS, Linux, other Windows versions, checking file permissions before attempting to access/read/write, locale support (incase someone has foreign characters in their file system, make sure I can still save to path)
- Maybe package and ship as an installer for the CLI tool?
  I think, far in the future, I'd want to have this available on package managers like winget, homebrew, apt, pacman and aur. That would be amazing, but is probably the very very last item on the list, only to be done when everything is fleshed out, tested and working; ready to go-gold.

That's all I can think of right now off the top of my head. I'm sure there are more things which'll come to me later on, and other more things that we will have to do as we implement more features.


cli ascii art  
print logo?  
`--ver`  
or  
`--about`

