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
Base class for providers that fetch a problem statement and write a README.

A concrete provider only describes its source:

- `expand(token, ...)` turns one CLI input (id, slug, URL, range, contest)
  into the list of problem references it denotes;
- `fetch(ref, ...)` downloads one reference and returns a `Problem`.

Argument parsing, output layout, overwrite policy, parallelism, templating
and reporting are shared here so every source behaves the same way.
"""

from __future__ import annotations

import abc
import argparse
import os
from concurrent.futures import ThreadPoolExecutor, as_completed
from pathlib import Path
from typing import Any, Hashable, List, Optional, Sequence, Tuple

from jinja2 import Environment, FileSystemLoader, Template

from ...config import DEFAULT_OUT_DIR
from ...output_layout import DEFAULT_LAYOUT, DEFAULT_NAMEFMT, compute_output_dir
from .filecheck import add_overwrite_arguments, decide as decide_file
from .http import FetchError
from .logging import print_debug, print_error, print_skip, print_success
from .problem import Problem
from .provider import Provider, ProviderContext

try:
	from rich.markup import escape as _escape
except Exception:  # pragma: no cover - rich is optional at runtime
	def _escape(text: str) -> str:
		return text

TEMPLATE_DIR = Path(__file__).resolve().parents[1] / "templates"
DEFAULT_TEMPLATE = TEMPLATE_DIR / "problem_readme.md.j2"
LAYOUTS = ("source-difficulty-id", "difficulty-source-id", "source-id", "flat")

# Outcome kinds reported by a worker.
_OK, _SKIP, _FAIL = "ok", "skip", "fail"


def _default_jobs() -> int:
	try:
		return max(1, int(os.environ.get("3C_JOBS", "1")))
	except ValueError:
		return 1


class StatementProvider(Provider):
	"""See module docstring. Subclasses set the class attributes below."""

	#: Extra subcommand names (the primary one is `name`).
	aliases: Tuple[str, ...] = ()
	#: Directory segment used in output layouts, e.g. "AtCoder".
	source: str = ""
	#: Human-readable source name for help texts and messages.
	display_name: str = ""
	#: Help text describing accepted inputs.
	input_help: str = "Problem id(s) or URL(s)."
	#: Example invocations shown in `--help`.
	examples: Tuple[str, ...] = ()

	# ------------------------------------------------------------------ CLI

	@classmethod
	def register(cls, subparsers, parents: Optional[List[Any]] = None):
		epilog = None
		if cls.examples:
			epilog = "examples:\n" + "\n".join(f"  {ex}" for ex in cls.examples)
		p = subparsers.add_parser(
			cls.name,
			aliases=list(cls.aliases),
			help=f"Generate {cls.display_name} problem READMEs",
			description=f"Fetch {cls.display_name} problem statements and write them as README.md files.",
			epilog=epilog,
			formatter_class=_HelpFormatter,
			parents=parents or [],
		)
		p.add_argument("inputs", nargs="+", metavar="problem", help=cls.input_help)
		p.add_argument("--out-dir", default=DEFAULT_OUT_DIR,
					   help="Base output directory (default: current directory or $3C_OUT_DIR).")
		p.add_argument("--layout", choices=LAYOUTS, default=DEFAULT_LAYOUT,
					   help="Folder layout (default: source-difficulty-id or $3C_LAYOUT).")
		p.add_argument("--namefmt", default=DEFAULT_NAMEFMT,
					   help="Leaf directory name format (default: {id}; e.g. {id}-{slug}, {source}-{id}).")
		p.add_argument("--no-id-subdir", action="store_true",
					   help="Write directly into the layout directory instead of a per-problem one.")
		p.add_argument("--filename", default="README.md", help="Output filename (default: README.md).")
		p.add_argument("--template", default=str(DEFAULT_TEMPLATE), help="Path to a Jinja2 template file.")
		jobs = _default_jobs()
		p.add_argument("-j", "--jobs", type=int, default=jobs,
					   help=f"Parallel fetches (default: {jobs}; set 3C_JOBS). Keep modest to stay polite.")
		p.add_argument("--refresh", action="store_true", help="Ignore cached source indexes and download them again.")
		add_overwrite_arguments(p)
		cls.add_arguments(p)
		p.set_defaults(provider_name=cls.name, provider_cls=cls)

	@classmethod
	def add_arguments(cls, parser) -> None:
		"""Hook for source-specific options."""

	# --------------------------------------------------------------- Source

	@abc.abstractmethod
	def expand(self, token: str, args, ctx: ProviderContext) -> Sequence[Hashable]:
		"""
		Resolve one CLI input to problem references.

		Raise ValueError for input that cannot be understood.
		"""
		raise NotImplementedError

	@abc.abstractmethod
	def fetch(self, ref: Hashable, args, ctx: ProviderContext) -> Problem:
		"""Download one problem. Raise FetchError (or a subclass) on failure."""
		raise NotImplementedError

	def describe(self, ref: Hashable) -> str:
		"""Short label for a reference in messages."""
		if isinstance(ref, tuple):
			return "/".join(str(part) for part in ref if part)
		return str(ref)

	# ------------------------------------------------------------------ Run

	def run(self, args, ctx: ProviderContext) -> int:
		force = bool(args.force)
		no_overwrite = bool(args.no_overwrite)
		if force and no_overwrite:
			print_error("Cannot use --force and --no-overwrite at the same time.")
			return 2

		template_path = Path(args.template).expanduser().resolve()
		if not template_path.is_file():
			print_error(f"Template not found: {_escape(str(template_path))}")
			return 2
		template = _load_template(template_path)

		try:
			out_root = Path(str(args.out_dir).strip() or DEFAULT_OUT_DIR or ".").expanduser().resolve()
		except Exception:
			out_root = Path.cwd()

		failed = 0
		refs: List[Hashable] = []
		seen = set()
		for token in args.inputs:
			try:
				expanded = self.expand(token.strip(), args, ctx)
			except (ValueError, FetchError) as e:
				print_error(f"{self.display_name}: cannot resolve '{_escape(token)}': {_escape(str(e))}")
				failed += 1
				continue
			for ref in expanded:
				if ref not in seen:
					seen.add(ref)
					refs.append(ref)

		if ctx.debug:
			print_debug(f"{self.display_name}: {len(refs)} problem(s) to process; out_root={out_root}")

		def work(ref: Hashable) -> Tuple[str, str]:
			label = self.describe(ref)
			try:
				problem = self.fetch(ref, args, ctx)
			except FetchError as e:
				return _FAIL, f"{self.display_name} {label}: {e}"
			except Exception as e:  # a parser tripping over unexpected markup
				if ctx.debug:
					raise
				return _FAIL, f"{self.display_name} {label}: unexpected {type(e).__name__}: {e}"
			return self._write(problem, template, out_root, args)

		written = skipped = 0
		jobs = min(max(1, int(args.jobs)), len(refs)) if refs else 1
		if jobs == 1:
			outcomes = map(work, refs)
		else:
			pool = ThreadPoolExecutor(max_workers=jobs, thread_name_prefix=f"3c-{self.name}")
			outcomes = (f.result() for f in as_completed([pool.submit(work, r) for r in refs]))
		try:
			for kind, message in outcomes:
				if kind == _OK:
					written += 1
					print_success(_escape(message))
				elif kind == _SKIP:
					skipped += 1
					print_skip(_escape(message))
				else:
					failed += 1
					print_error(_escape(message))
		finally:
			if jobs > 1:
				pool.shutdown(wait=True, cancel_futures=True)

		parts = [f"{written} {'would be generated' if args.dry_run else 'generated'}"]
		if skipped:
			parts.append(f"{skipped} skipped")
		if failed:
			parts.append(f"{failed} failed")
		print("Summary: " + ", ".join(parts))
		return 1 if failed else 0

	def _write(self, problem: Problem, template: Template, out_root: Path, args) -> Tuple[str, str]:
		out_dir = compute_output_dir(
			out_root=out_root,
			source=problem.source,
			difficulty=(problem.difficulty or "").lower() or None,
			pid=problem.id,
			slug=problem.slug,
			layout=args.layout,
			namefmt=args.namefmt,
			include_id_subdir=not args.no_id_subdir,
		)
		path = out_dir / args.filename
		what = f"{problem.source_name} {problem.id} \"{problem.title}\""

		decision = decide_file(path, force=args.force, no_overwrite=args.no_overwrite, dry_run=args.dry_run)
		if args.dry_run:
			verb = "overwrite" if decision.exists and not args.no_overwrite else "skip existing" if decision.exists else "create"
			return _OK, f"[dry-run] Would {verb}: {path} ({what})"
		if not decision.should_write:
			return _SKIP, f"{what}: {path} exists ({decision.reason})"

		try:
			content = template.render(p=problem, **_template_context(problem))
			out_dir.mkdir(parents=True, exist_ok=True)
			path.write_text(content.rstrip() + "\n", encoding="utf-8")
		except Exception as e:
			return _FAIL, f"{what}: failed to write {path}: {e}"
		return _OK, f"Wrote {what} -> {path}"


class _HelpFormatter(argparse.RawDescriptionHelpFormatter):
	"""Keeps the examples epilog verbatim."""


def _load_template(path: Path) -> Template:
	env = Environment(
		loader=FileSystemLoader(str(path.parent)),
		autoescape=False,  # output is Markdown with intentionally embedded HTML
		trim_blocks=True,
		lstrip_blocks=True,
		keep_trailing_newline=True,
	)
	return env.get_template(path.name)


def _template_context(problem: Problem) -> dict:
	return {
		"source": problem.source,
		"source_name": problem.source_name,
		"id": problem.id,
		"slug": problem.slug,
		"title": problem.title,
		"heading": problem.heading,
		"url": problem.url,
		"difficulty": problem.difficulty,
		"meta": problem.meta,
		"tags": problem.tags,
		"notice": problem.notice,
		"footer": problem.footer,
		"body": problem.body,
	}
