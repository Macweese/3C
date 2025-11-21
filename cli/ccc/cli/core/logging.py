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

import os
import sys
from typing import Optional

_RICH_AVAILABLE = True
try:
	from rich.console import Console
	from rich.theme import Theme
	from rich.text import Text
	from rich.panel import Panel
	from rich.traceback import install as rich_traceback_install
except Exception:	# pragma: no cover - optional dependency path
	_RICH_AVAILABLE = False
	Console = None	# type: ignore
	Theme = None	# type: ignore
	Text = None		# type: ignore
	Panel = None	# type: ignore

console: Optional["Console"] = None
err_console: Optional["Console"] = None

CLI_ASCII_LOGO = r"""
	                      -=               --,
	                       --=-=            --:.
	                          :-===-=-      ----:.
	                            ::-======--  ---=-:.
	                   ==-        .:-=========----=-.-=
	                     :-========-=::===========-==-:==
	                          .:--==========================
	                              .::--======----==============
	                       :-=+-:   .:-========:-~-.~-===========
	                :::.  :=***-:  -==============-~^=:-~-=======.
	           ::==***+.  :=***-: -========---=-===-~-%@*;-~-===-:
	       .:=+*******+.  :-==: -======-=-=---=---=--~'"^=+-~-===:.
	    :=***********=:        -====-=-=---/-----------=-=-===========-
	.=***********+.           -======-=--//--::-------------=-==========-
	.*******+=-.             =====-=---/ /__::. :-------------=-=======-:.
	.*****=:                -=-===-=--/__  /:.            ...:--=-====-:    _
	.********+:.           -===-=-=-----/ /:                   --===-:   .:===:.
	.=***********+--.     -====::=-----//.                   -----:.   .:======;
	   .-=+**********+=.  =-===-.:-=--/---:                 --          .:=====;
	        --=********.  -=-===-. --------:.                         .:-======;
	            .:+****.   -=-=-=-. ---------:                    .:===========:
	                :-=;    -=-=-=-: --------=-:               -===========:'
	                        ---------.  ------==--             =======-:'
              ________    __    `':::--- ::------::..          ====:'
   ____      / ____/ /   / /          `" ''::-------::::.      ^'
  |_  /_____/ /   / /   / /                    `'"'`
 _/_ </ ___/ /___/ /___/ /
/____/ /__ \____/_____/_/
     \___/
"""


def init_consoles(no_color: bool = False, force_color: bool = False) -> None:
	"""
	Initialize global rich consoles for stdout/stderr.

	Respects NO_COLOR and FORCE_COLOR env vars, unless overridden by arguments.
	"""
	global console, err_console

	if not _RICH_AVAILABLE:
		console = None
		err_console = None
		return

	no_color_flag = no_color or bool(os.environ.get("NO_COLOR"))
	force_flag = force_color or bool(os.environ.get("FORCE_COLOR"))

	theme = Theme(
		{
			"ok": "green",
			"warn": "yellow",
			"err": "red",
			"label": "cyan",
			"muted": "#808080",
			"path": "deep_sky_blue3",
		}
	)

	console = Console(
		no_color=no_color_flag,
		force_terminal=force_flag,
		highlight=False,
		soft_wrap=False,
		theme=theme,
	)
	err_console = Console(
		stderr=True,
		no_color=no_color_flag,
		force_terminal=force_flag,
		highlight=False,
		theme=theme,
	)

	# Install rich tracebacks once
	if _RICH_AVAILABLE:
		rich_traceback_install(show_locals=False, extra_lines=1, console=err_console)


def color_diag() -> None:
	"""
	Print a brief diagnostic about color configuration.
	"""
	no_color_env = os.environ.get("NO_COLOR")
	force_color_env = os.environ.get("FORCE_COLOR")
	term = os.environ.get("TERM")
	stdout_tty = getattr(sys.stdout, "isatty", lambda: False)()
	stderr_tty = getattr(sys.stderr, "isatty", lambda: False)()

	if console is None or err_console is None:
		print("[color-diag] rich: not available; using plain output", file=sys.stderr)
		print(f"[color-diag] NO_COLOR={no_color_env or '<unset>'} FORCE_COLOR={force_color_env or '<unset>'}",
			  file=sys.stderr)
		print(f"[color-diag] TERM={term or '<unset>'} stdout.isatty={stdout_tty} stderr.isatty={stderr_tty}",
			  file=sys.stderr)
		return

	err_console.print(Panel(Text("Color diagnostics", style="bold"), border_style="label"))
	err_console.print(f"[label]NO_COLOR[/label]={no_color_env or '<unset>'}")
	err_console.print(f"[label]FORCE_COLOR[/label]={force_color_env or '<unset>'}")
	err_console.print(f"[label]TERM[/label]={term or '<unset>'}")
	err_console.print(f"[label]stdout.isatty[/label]={stdout_tty}")
	err_console.print(f"[label]stderr.isatty[/label]={stderr_tty}")


def print_debug(msg: str) -> None:
	if err_console is not None:
		err_console.print(f"[muted][DEBUG][/muted] {msg}")
	else:
		print(f"[DEBUG] {msg}", file=sys.stderr)


def print_error(msg: str) -> None:
	if err_console is not None:
		err_console.print(f"[err]{msg}[/err]")
	else:
		print(msg, file=sys.stderr)


def print_skip(msg: str) -> None:
	if err_console is not None:
		err_console.print(f"[warn][SKIP][/warn] {msg}")
	else:
		print(f"[SKIP] {msg}", file=sys.stderr)


def print_success(msg: str) -> None:
	if console is not None:
		console.print(f"[ok]{msg}[/ok]")
	else:
		print(msg)
