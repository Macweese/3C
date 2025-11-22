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

from __future__ import annotations

import dataclasses as dc
import json
import random
import re
from datetime import datetime
from pathlib import Path
from typing import Any, Dict, Iterable, List, Optional, Sequence, Tuple

import requests
from jinja2 import Environment, FileSystemLoader, Template

from ccc.cli.core.filecheck import (
	decide as decide_file,
	FileDecision,
	add_overwrite_arguments,
)
from ccc.cli.core.logging import (
	console,
	print_debug,
	print_error,
	print_skip,
	print_success,
)
from ccc.cli.core.provider import Provider, ProviderContext
from ccc.config import CACHE_DIR, DEFAULT_OUT_DIR
from ccc.output_layout import compute_output_dir, DEFAULT_LAYOUT, DEFAULT_NAMEFMT

CODEGOLF_BASE = "https://code.golf"
CODEGOLF_API_BASE = f"{CODEGOLF_BASE}/api"
CODEGOLF_HOLES_URL = f"{CODEGOLF_API_BASE}/holes"

CACHE_FILENAME = "codegolf_holes.json"
CACHE_MAX_AGE_SECONDS = 24 * 60 * 60  # 1 day


# ----------------------------- Data model ------------------------------------


@dc.dataclass
class CodeGolfHole:
	id: str
	name: str
	category: str
	preamble: str
	synopsis: str
	released: str
	links: List[Dict[str, Any]] = dc.field(default_factory=list)
	experiment: Optional[int] = None

	@classmethod
	def from_api(cls, data: Dict[str, Any]) -> "CodeGolfHole":
		return cls(
			id=data["id"],
			name=data["name"],
			category=data.get("category", ""),
			preamble=data.get("preamble", ""),
			synopsis=data.get("synopsis", ""),
			released=data.get("released", "0000-00-00"),
			links=list(data.get("links", [])) if data.get("links") else [],
			experiment=data.get("experiment"),
		)

	@property
	def url(self) -> str:
		return f"{CODEGOLF_BASE}/{self.id}"

	def released_sort_key(self) -> Tuple[int, datetime]:
		if not self.released or self.released == "0000-00-00":
			return (0, datetime.min)
		try:
			dt = datetime.strptime(self.released, "%Y-%m-%d")
		except Exception:
			return (0, datetime.min)
		return (1, dt)


# ----------------------------- Cache helpers ---------------------------------


def _get_cache_file() -> Path:
	# Reuse the same .3c/cache directory style as LeetCode
	return CACHE_DIR / CACHE_FILENAME


def _load_cache() -> Optional[List[CodeGolfHole]]:
	cache_path = _get_cache_file()
	if not cache_path.is_file():
		return None
	try:
		stat = cache_path.stat()
		age = datetime.now().timestamp() - stat.st_mtime
		if age > CACHE_MAX_AGE_SECONDS:
			return None
		raw = json.loads(cache_path.read_text(encoding="utf-8"))
		return [CodeGolfHole.from_api(obj) for obj in raw]
	except Exception:
		return None


def _save_cache(holes: Sequence[CodeGolfHole]) -> None:
	cache_path = _get_cache_file()
	try:
		cache_path.parent.mkdir(parents=True, exist_ok=True)
		raw = [dc.asdict(h) for h in holes]
		cache_path.write_text(json.dumps(raw, ensure_ascii=False, indent=2), encoding="utf-8")
	except Exception:
		print_error("CodeGolf: failed to write cache file")


def _fetch_all_holes(ctx: ProviderContext, refresh: bool = False) -> List[CodeGolfHole]:
	if not refresh:
		cached = _load_cache()
		if cached is not None:
			if ctx.debug:
				print_debug(f"CodeGolf: loaded {len(cached)} holes from cache {_get_cache_file()}")
			return cached

	if ctx.debug:
		print_debug(f"CodeGolf: fetching all holes from {CODEGOLF_HOLES_URL}")

	resp = requests.get(CODEGOLF_HOLES_URL, timeout=15)
	resp.raise_for_status()
	data = resp.json()
	holes = [CodeGolfHole.from_api(obj) for obj in data]
	_save_cache(holes)
	return holes


# ----------------------------- Selection helpers -----------------------------


def _filter_by_category(
		holes: Iterable[CodeGolfHole], category: Optional[str]
) -> List[CodeGolfHole]:
	if not category:
		return list(holes)
	cat_lower = category.lower()
	return [h for h in holes if h.category.lower() == cat_lower]


def _pick_latest(holes: Sequence[CodeGolfHole]) -> Optional[CodeGolfHole]:
	if not holes:
		return None
	return max(holes, key=lambda h: h.released_sort_key())


def _slugify_for_match(s: str) -> str:
	s = s.lower()
	s = re.sub(r"[^a-z0-9]+", " ", s)
	return s.strip()


def _find_by_id_or_fuzzy(
		holes: Sequence[CodeGolfHole], query: str
) -> Tuple[Optional[CodeGolfHole], List[CodeGolfHole]]:
	"""
	Try exact id match first, then fuzzy match on name and id.

	Returns (best_match, candidates).

	- If exact id match found: (that, [that]).
	- Else if fuzzy finds something: (best, top_candidates).
	- Else: (None, []).
	"""
	q = query.strip()
	# exact id
	for h in holes:
		if h.id == q:
			return h, [h]

	# case-insensitive id
	for h in holes:
		if h.id.lower() == q.lower():
			return h, [h]

	# fuzzy on name + id using simple scoring
	target = _slugify_for_match(q)
	if not target:
		return None, []

	scored: List[Tuple[float, CodeGolfHole]] = []
	for h in holes:
		cand = _slugify_for_match(h.name + " " + h.id)
		if not cand:
			continue
		t_tokens = set(target.split())
		c_tokens = set(cand.split())
		if not t_tokens or not c_tokens:
			continue
		inter = len(t_tokens & c_tokens)
		union = len(t_tokens | c_tokens)
		score = inter / union
		if score > 0:
			scored.append((score, h))

	if not scored:
		return None, []

	scored.sort(key=lambda x: x[0], reverse=True)
	best_score, best = scored[0]
	# keep top few suggestions if they share similar score
	top: List[CodeGolfHole] = []
	for s, h in scored:
		if s < max(0.3, best_score - 0.1):
			break
		top.append(h)
		if len(top) >= 5:
			break
	return best, top


# ----------------------------- Rendering -------------------------------------


def _render_hole_readme(
		hole: CodeGolfHole,
		template_path: Path,
		ctx: ProviderContext,
) -> str:
	"""
	Load the Jinja2 template at template_path and render a README for the hole.
	"""
	env = Environment(
		loader=FileSystemLoader(str(template_path.parent)),
		autoescape=False,
		trim_blocks=True,
		lstrip_blocks=True,
	)
	tmpl: Template = env.get_template(template_path.name)

	context = {
		"id": hole.id,
		"name": hole.name,
		"category": hole.category,
		"preamble_html": hole.preamble,
		"synopsis": hole.synopsis,
		"released": hole.released,
		"url": hole.url,
		"links": hole.links,
	}
	return tmpl.render(**context)


def _compute_output_dir_for_hole(
		out_root: Path,
		layout: str,
		namefmt: str,
		no_id_subdir: bool,
		hole: CodeGolfHole,
) -> Path:
	return compute_output_dir(
		out_root=out_root,
		source="CodeGolf",
		difficulty=None,
		pid=hole.id,
		slug=hole.name,
		layout=layout,
		namefmt=namefmt,
		include_id_subdir=not no_id_subdir,
	)


def _compute_existing_hole_ids(
		holes: Sequence[CodeGolfHole],
		out_root: Path,
		layout: str,
		namefmt: str,
		no_id_subdir: bool,
		filename: str,
) -> set[str]:
	"""
	Compute which hole ids already exist on disk by seeing if the target file exists.
	"""
	existing: set[str] = set()
	for h in holes:
		dir_path = _compute_output_dir_for_hole(
			out_root=out_root,
			layout=layout,
			namefmt=namefmt,
			no_id_subdir=no_id_subdir,
			hole=h,
		)
		full_path = dir_path / filename
		if full_path.is_file():
			existing.add(h.id)
	return existing


# ----------------------------- Provider --------------------------------------


class CodeGolfProvider(Provider):
	"""
	Provider for CodeGolf "holes" (challenges).

	CLI entrypoint: `3c golf ...`
	"""

	name = "golf"

	@classmethod
	def register(cls, subparsers, parents: Optional[List[Any]] = None):
		if parents is None:
			parents = []

		p = subparsers.add_parser(
			"golf",
			help="Generate CodeGolf challenge READMEs",
			description="Generate CodeGolf README.md files.",
			parents=parents,
		)

		# Mutually exclusive modes: query OR one of the flags
		mode = p.add_mutually_exclusive_group()
		mode.add_argument(
			"query",
			nargs="?",
			help=(
				"Specific hole id or name to fetch (fuzzy matching supported). "
				"If omitted, one of --all / --latest / --random / --category is required."
			),
		)
		mode.add_argument(
			"--all",
			action="store_true",
			help="Fetch and generate README for all CodeGolf holes.",
		)
		mode.add_argument(
			"--latest",
			action="store_true",
			help="Fetch and generate README for the most recently released hole "
				 "(optionally filtered by --category).",
		)
		mode.add_argument(
			"--random",
			action="store_true",
			help="Fetch and generate README for a random hole (optionally filtered by --category).",
		)

		p.add_argument(
			"--category",
			help="Restrict to holes in this category (e.g., 'Mathematics', 'Sequence', 'Art', ...).",
		)
		p.add_argument(
			"--exclude-existing",
			action="store_true",
			help="When used with --random or --latest or --category, skip holes that already have a README.",
		)

		# output / layout options
		p.add_argument(
			"--out-dir",
			default=DEFAULT_OUT_DIR,
			help="Base output directory (default: current directory or $3C_OUT_DIR if set).",
		)
		p.add_argument(
			"--layout",
			choices=["source-difficulty-id", "difficulty-source-id", "source-id", "flat"],
			default=DEFAULT_LAYOUT,
			help="Folder layout (default: source-difficulty-id or $3C_LAYOUT).",
		)
		p.add_argument(
			"--namefmt",
			default=DEFAULT_NAMEFMT,
			help="Leaf directory name format (default: {id}; examples: {id}-{slug}, {source}-{id}).",
		)
		p.add_argument(
			"--no-id-subdir",
			action="store_true",
			help="Do not create a per-hole-id directory; write directly into the layout directory.",
		)

		# File / template
		p.add_argument(
			"--filename",
			default="README.md",
			help="Output filename (default: README.md).",
		)
		default_template = Path(__file__).resolve().parents[1] / "templates" / "codegolf_readme.md.j2"
		p.add_argument(
			"--template",
			default=str(default_template),
			help="Path to Jinja2 template file for CodeGolf READMEs.",
		)

		# Overwrite / dry-run flags
		add_overwrite_arguments(p)

		p.add_argument(
			"--refresh",
			action="store_true",
			help="Force refresh of the CodeGolf holes cache.",
		)

		p.set_defaults(provider_name=cls.name, provider_cls=cls)

	def run(self, args, ctx: ProviderContext) -> int:
		if not hasattr(args, "debug"):
			setattr(args, "debug", ctx.debug)

		out_root_str = args.out_dir if (args.out_dir is not None and str(args.out_dir).strip() != "") else (
				DEFAULT_OUT_DIR or ".")
		try:
			out_root = Path(out_root_str).expanduser().resolve()
		except Exception:
			out_root = Path.cwd()

		template_path = Path(args.template).expanduser().resolve()
		if not template_path.is_file():
			print_error(f"Template not found: {template_path}")
			return 1

		try:
			holes = _fetch_all_holes(ctx, refresh=args.refresh)
		except Exception as e:
			print_error(f"Failed to fetch CodeGolf holes: {e}")
			return 1

		if not holes:
			print_error("No CodeGolf holes available from API.")
			return 1

		if args.debug:
			print_debug(f"CodeGolf: fetched {len(holes)} holes")

		# Mode resolution
		mode_all = bool(getattr(args, "all", False))
		mode_latest = bool(getattr(args, "latest", False))
		mode_random = bool(getattr(args, "random", False))
		query = getattr(args, "query", None)
		category = getattr(args, "category", None)
		exclude_existing = bool(getattr(args, "exclude_existing", False))

		target_holes: List[CodeGolfHole] = []

		if mode_all:
			target_holes = _filter_by_category(holes, category)
			if not target_holes:
				print_skip("No holes match the requested category.")
				return 0

		elif mode_latest:
			filtered = _filter_by_category(holes, category)
			if exclude_existing:
				existing_ids = _compute_existing_hole_ids(
					filtered,
					out_root=out_root,
					layout=args.layout,
					namefmt=args.namefmt,
					no_id_subdir=args.no_id_subdir,
					filename=args.filename,
				)
				filtered = [h for h in filtered if h.id not in existing_ids]
			latest = _pick_latest(filtered)
			if not latest:
				print_skip("No suitable 'latest' hole found (maybe all are already present?).")
				return 0
			target_holes = [latest]

		elif mode_random:
			filtered = _filter_by_category(holes, category)
			if exclude_existing:
				existing_ids = _compute_existing_hole_ids(
					filtered,
					out_root=out_root,
					layout=args.layout,
					namefmt=args.namefmt,
					no_id_subdir=args.no_id_subdir,
					filename=args.filename,
				)
				filtered = [h for h in filtered if h.id not in existing_ids]
			if not filtered:
				if category:
					print_skip(f"You already have all holes in category '{category}' (nothing to choose from).")
				else:
					print_skip("You already have all CodeGolf holes (nothing to choose from).")
				return 0
			target_holes = [random.choice(filtered)]

		elif category:
			target_holes = _filter_by_category(holes, category)
			if exclude_existing:
				existing_ids = _compute_existing_hole_ids(
					target_holes,
					out_root=out_root,
					layout=args.layout,
					namefmt=args.namefmt,
					no_id_subdir=args.no_id_subdir,
					filename=args.filename,
				)
				target_holes = [h for h in target_holes if h.id not in existing_ids]
			if not target_holes:
				print_skip("No holes match the requested category (or all already exist).")
				return 0

		elif query:
			best, candidates = _find_by_id_or_fuzzy(holes, query)
			if not best:
				print_error(f"No CodeGolf hole found matching '{query}'.")
				return 1
			target_holes = [best]
			# If fuzzy, display hints
			if console and len(candidates) > 1:
				console.print(
					"[warn]Fuzzy match used, closest candidates:[/warn]\n"
					+ "\n".join(
						f"  - {h.name}  (id: {h.id}, category: {h.category})" for h in candidates
					)
					+ f"\n[info]Using: {best.name}  (id: {best.id})[/info]"
				)
		else:
			print_error(
				"No golf mode selected. Specify one of:\n"
				"  3c golf all\n"
				"  3c golf <id-or-name>\n"
				"  3c golf --latest [--category X]\n"
				"  3c golf --random [--category X] [--exclude-existing]\n"
				"  3c golf --category X"
			)
			return 2

		if not target_holes:
			print_skip("Nothing to do.")
			return 0

		force = bool(getattr(args, "force", False))
		no_overwrite = bool(getattr(args, "no_overwrite", False))
		dry_run = bool(getattr(args, "dry_run", False))

		if force and no_overwrite:
			print_error("Cannot use --force and --no-overwrite at the same time.")
			return 2

		written = 0
		skipped = 0
		failed = 0

		for hole in target_holes:
			dir_path = _compute_output_dir_for_hole(
				out_root=out_root,
				layout=args.layout,
				namefmt=args.namefmt,
				no_id_subdir=args.no_id_subdir,
				hole=hole,
			)
			full_dir = dir_path
			full_path = full_dir / args.filename

			decision: FileDecision = decide_file(
				full_path,
				force=force,
				no_overwrite=no_overwrite,
				dry_run=dry_run,
			)

			if dry_run:
				if decision.exists and not decision.should_write:
					print_skip(f"[dry-run] Would skip existing file: {full_path}")
				elif decision.exists and decision.should_write:
					print_skip(f"[dry-run] Would overwrite: {full_path}")
				elif not decision.exists and decision.should_write:
					print_success(f"[dry-run] Would create: {full_path}")
				else:
					print_skip(f"[dry-run] Would do nothing for: {full_path} ({decision.reason})")
				continue

			if not decision.should_write and decision.exists:
				print_skip(f"Skipping existing file: {full_path} ({decision.reason})")
				skipped += 1
				continue

			try:
				full_dir.mkdir(parents=True, exist_ok=True)
			except Exception as e:
				print_error(f"Failed to create directory {full_dir}: {e}")
				failed += 1
				continue

			try:
				content = _render_hole_readme(hole, template_path, ctx)
			except Exception as e:
				print_error(f"Failed to render README for CodeGolf hole '{hole.id}': {e}")
				failed += 1
				continue

			if not decision.should_write:
				print_skip(f"Not writing {full_path} due to decision: {decision.reason}")
				skipped += 1
				continue

			try:
				full_path.write_text(content.rstrip() + "\n", encoding="utf-8")
			except Exception as e:
				print_error(f"Failed to write {full_path}: {e}")
				failed += 1
				continue

			print_success(f"Wrote CodeGolf '{hole.name}' (id: {hole.id}) to {full_path}")
			written += 1

		if console:
			msg = f"[ok]{written} generated[/ok]"
			if skipped:
				msg += f", [warn]{skipped} skipped[/warn]"
			if failed:
				msg += f", [err]{failed} failed[/err]"
			console.print("Summary: " + msg)  # type: ignore[arg-type]
		else:
			parts = [f"{written} generated"]
			if skipped:
				parts.append(f"{skipped} skipped")
			if failed:
				parts.append(f"{failed} failed")
			print("Summary: " + ", ".join(parts))

		return 0
