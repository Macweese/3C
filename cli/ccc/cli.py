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

# 3C unified CLI entrypoint. Dispatches to source-specific providers.
# Currently available:
# 	lc (LeetCode)
#	doctor (environment diagnostics)
#

from __future__ import annotations

import argparse
import sys
from importlib.metadata import version as _pkg_version, PackageNotFoundError


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


def _get_pkg_version() -> str:
	"""
	Return the installed version of the 'ccc' package, or 'unknown'
	if metadata is not available (e.g. running from source only).
	"""
	try:
		return _pkg_version("ccc")
	except PackageNotFoundError:
		return "unknown"


def main() -> int:
	# Common/global flags shared by all providers
	common = argparse.ArgumentParser(add_help=False)
	common.add_argument("--debug", action="store_true", help="Enable debug output (provider-specific).")
	common.add_argument("--no-color", action="store_true", help="Disable colored output (or set NO_COLOR=1).")
	common.add_argument("--force-color", action="store_true", help="Force colored output even if terminal detection fails (or set FORCE_COLOR=1).")
	common.add_argument("--color-diag", action="store_true", help="Print color diagnostics at start (provider-specific).")

	parser = argparse.ArgumentParser(prog="3c", description="3C — Competitive Coding Challenge CLI")
	parser.add_argument("--version", action="store_true", help="Print version and exit.")

	subparsers = parser.add_subparsers(dest="cmd", required=False, metavar="{lc,doctor}")

	# Register providers
	# LeetCode (lc)
	from . import leetcode_readme_gen as lc_mod
	lc_mod.register_subparser(subparsers, parents=[common])

	# Doctor (doctor)
	from . import doctor as doctor_mod
	doctor_mod.register_subparser(subparsers, parents=[common])

	# Parse and dispatch
	args = parser.parse_args()

	if getattr(args, "version", False):
		print(CLI_ASCII_LOGO)
		print(f"3C CLI version {_get_pkg_version()}")
		return 0

	# Each provider sets a callable at args.func
	if hasattr(args, "func") and callable(args.func):
		rc = args.func(args)
		return int(rc) if rc is not None else 0

	# No subcommand and no --version: show help
	parser.print_help()
	return 2

if __name__ == "__main__":
	sys.exit(main())