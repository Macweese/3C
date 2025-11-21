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

# !/usr/bin/env python3
#
# 3C CLI — doctor command
# Prints environment diagnostics to help troubleshoot setup, coloring, caches, and basic network checks.

from __future__ import annotations
import argparse
import os
import sys
import platform
import tempfile
from pathlib import Path
from typing import Optional, List

from importlib.metadata import version as _pkg_version, PackageNotFoundError

from .config import CACHE_DIR, DEFAULT_OUT_DIR

# Optional but expected (rich is a hard dependency in packaging)
_RICH_AVAILABLE = True
try:
	from rich.console import Console
	from rich.table import Table
	from rich.text import Text
	from rich.panel import Panel
	from rich.theme import Theme
except Exception:
	_RICH_AVAILABLE = False
	Console = None  # type: ignore
	Table = None    # type: ignore
	Text = None     # type: ignore
	Panel = None    # type: ignore


def _get_pkg_version() -> str:
	try:
		return _pkg_version("ccc")
	except PackageNotFoundError:
		return "unknown"


def _console(no_color: bool, force_color: bool) -> Console | None:
	if not _RICH_AVAILABLE:
		return None
	theme = Theme({
		"ok": "green",
		"warn": "yellow",
		"err": "red",
		"label": "cyan",
		"muted": "grey66",
	})
	return Console(
		no_color=no_color or bool(os.environ.get("NO_COLOR")),
		force_terminal=force_color or bool(os.environ.get("FORCE_COLOR")),
		highlight=False,
		soft_wrap=False,
		theme=theme,
	)


def _print_plain(lines: List[str]) -> None:
	for ln in lines:
		print(ln)


def _writable_dir(p: Path) -> bool:
	try:
		p.mkdir(parents=True, exist_ok=True)
		with tempfile.NamedTemporaryFile(prefix=".probe-", dir=str(p), delete=True) as _:
			pass
		return True
	except Exception:
		return False


def _masked(s: Optional[str], keep_last: int = 4) -> str:
	if not s:
		return ""
	if len(s) <= keep_last:
		return "*" * len(s)
	return "*" * (len(s) - keep_last) + s[-keep_last:]


def run(args) -> int:
	no_color = bool(getattr(args, "no_color", False) or os.environ.get("NO_COLOR"))
	force_color = bool(getattr(args, "force_color", False) or os.environ.get("FORCE_COLOR"))
	c = _console(no_color, force_color)

	# Gather info
	python_line = sys.version.splitlines()[0]
	plat = platform.platform()
	exe = sys.executable

	# Package versions
	def _ver(modname: str) -> str:
		try:
			return _pkg_version(modname)
		except Exception:
			return "not-installed"

	versions = {
		"ccc": _get_pkg_version(),
		"rich": _ver("rich"),
		"requests": _ver("requests"),
		"jinja2": _ver("jinja2"),
		"beautifulsoup4": _ver("beautifulsoup4"),
	}

	# Env
	env = {
		"3C_OUT_DIR": os.environ.get("3C_OUT_DIR", ""),
		"3C_CACHE_DIR": os.environ.get("3C_CACHE_DIR", ""),
		"3C_LAYOUT": os.environ.get("3C_LAYOUT", ""),
		"3C_NAMEFMT": os.environ.get("3C_NAMEFMT", ""),
		"3C_JOBS": os.environ.get("3C_JOBS", ""),
		"NO_COLOR": os.environ.get("NO_COLOR", ""),
		"FORCE_COLOR": os.environ.get("FORCE_COLOR", ""),
		"LEETCODE_SESSION": _masked(os.environ.get("LEETCODE_SESSION")),
		"LEETCODE_CSRF": _masked(os.environ.get("LEETCODE_CSRF")),
	}

	cache_dir = CACHE_DIR
	out_dir = Path(env["3C_OUT_DIR"] or DEFAULT_OUT_DIR)
	try:
		out_dir = out_dir.expanduser().resolve()
	except Exception:
		out_dir = Path(env["3C_OUT_DIR"] or DEFAULT_OUT_DIR)

	cache_ok = _writable_dir(cache_dir)
	out_ok = _writable_dir(out_dir)

	if c:
		c.print(Panel(Text("3C Doctor", style="bold"), border_style="label"))
		# System table
		sys_tab = Table(title="System", title_justify="left", show_lines=False, box=None)
		sys_tab.add_column("Key", style="label")
		sys_tab.add_column("Value", overflow="fold")
		sys_tab.add_row("Python", python_line)
		sys_tab.add_row("Platform", plat)
		sys_tab.add_row("Executable", exe)
		sys_tab.add_row("3C CLI Version", versions["ccc"])
		c.print(sys_tab)
		c.print()

		# Packages
		pkg_tab = Table(title="Python Packages", show_lines=False, title_justify="left", box=None, highlight=True,
						style="bold")
		pkg_tab.add_column("Package", style="label")
		pkg_tab.add_column("Version", overflow="fold")
		for k in ("rich", "requests", "jinja2", "beautifulsoup4"):
			val = versions[k]
			style = "ok" if val not in ("not-installed", "") else "err"
			pkg_tab.add_row(k, Text(val, style=style))
		c.print(pkg_tab)
		c.print()

		# Env
		if getattr(args, "show_env", False):
			env_tab = Table(title="Environment", title_justify="left", show_lines=False, box=None, highlight=True)
			env_tab.add_column("Variable", style="label")
			env_tab.add_column("Value", overflow="fold", style="muted")
			for k, v in env.items():
				env_tab.add_row(k, v or "-")
			c.print(env_tab)
			c.print()

		# Paths
		path_tab = Table(title="Paths", title_justify="left", show_lines=False, box=None, highlight=True)
		path_tab.add_column("Path", style="label")
		path_tab.add_column("Location", overflow="fold")
		path_tab.add_column("Writable")
		path_tab.add_row("CACHE_DIR", str(cache_dir),
						 Text("yes" if cache_ok else "no", style="ok" if cache_ok else "err"))
		path_tab.add_row("OUT_DIR (base)", str(out_dir),
						 Text("yes" if out_ok else "no", style="ok" if out_ok else "err"))
		c.print(path_tab)
		c.print()

		# Optional network checks
		if getattr(args, "check_network", False):
			try:
				import requests  # local import
				from .cli.providers.leetcode import LEETCODE_BASE, MAP_ALL_URL
				net_tab = Table(title="Network", title_justify="left", show_lines=False, box=None)
				net_tab.add_column("Endpoint", style="label")
				net_tab.add_column("Status")
				ok = True
				try:
					r = requests.get(MAP_ALL_URL, timeout=15)
					net_tab.add_row("LeetCode API", Text(str(r.status_code), style="ok" if r.ok else "warn"))
					ok = ok and (r.status_code < 500)
				except Exception as e:
					net_tab.add_row("LeetCode API", Text(f"Error: {e}", style="err"))
					ok = False
				c.print(net_tab)
				c.print(Text("Network: OK" if ok else "Network: issues detected", style="ok" if ok else "warn"))
			except Exception as e:
				c.print(Text(f"Network check unavailable: {e}", style="warn"))
		return 0

	# Plain output fallback (no rich)
	lines = [
		"3C Doctor",
		f"Python: {python_line}",
		f"Platform: {plat}",
		f"Executable: {exe}",
		f"CLI Version: {versions['ccc']}",
		"",
		"Packages:"
	]
	for k in ("rich", "requests", "jinja2", "beautifulsoup4"):
		lines.append(f"  - {k}: {versions[k]}")
	lines.append("")
	lines.append("Paths:")
	lines.append(f"  - CACHE_DIR: {cache_dir} (writable: {'yes' if cache_ok else 'no'})")
	lines.append(f"  - OUT_DIR:   {out_dir} (writable: {'yes' if out_ok else 'no'})")
	if getattr(args, "show_env", False):
		lines.append("")
		lines.append("Environment:")
		for k, v in env.items():
			lines.append(f"  - {k}={v or ''}")

	# Optional network checks (plain)
	if getattr(args, "check_network", False):
		try:
			import requests
			from .cli.providers.leetcode import LEETCODE_BASE, MAP_ALL_URL
			lines.append("")
			lines.append("Network (LeetCode):")
			try:
				r = requests.get(LEETCODE_BASE, timeout=10)
				lines.append(f"  - Base: {r.status_code}")
			except Exception as e:
				lines.append(f"  - Base: Error: {e}")
			try:
				r = requests.get(MAP_ALL_URL, timeout=15)
				lines.append(f"  - /api/problems/all/: {r.status_code}")
			except Exception as e:
				lines.append(f"  - /api/problems/all/: Error: {e}")
		except Exception as e:
			lines.append(f"Network check unavailable: {e}")

	_print_plain(lines)
	return 0


def register_subparser(subparsers, parents: Optional[List[argparse.ArgumentParser]] = None) -> argparse.ArgumentParser:
	p = subparsers.add_parser(
		"doctor",
		help="Environment diagnostics",
		description="Print diagnostic information about your 3C setup (versions, paths, env, network).",
		parents=parents or [],
	)
	p.add_argument("--show-env", action="store_true", help="Show relevant environment variables.")
	p.add_argument("--check-network", action="store_true", help="Attempt basic network checks (LeetCode endpoints).")
	p.set_defaults(func=run)
	return p
