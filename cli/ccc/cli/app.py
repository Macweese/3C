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

import argparse
import sys
from importlib.metadata import version as _pkg_version, PackageNotFoundError

from .core.provider import ProviderRegistry, ProviderContext
from .core.logging import init_consoles, CLI_ASCII_LOGO, color_diag
from .. import doctor as doctor_mod


def _get_pkg_version() -> str:
	try:
		return _pkg_version("ccc")
	except PackageNotFoundError:
		return "unknown"


def _build_common_parser() -> argparse.ArgumentParser:
	common = argparse.ArgumentParser(add_help=False)
	common.add_argument(
		"-d", "--debug",
		action="store_true",
		help="Enable debug output (provider-specific).",
	)
	common.add_argument(
		"-nc", "--no-color",
		action="store_true",
		help="Disable colored output (or set NO_COLOR=1).",
	)
	common.add_argument(
		"-fc", "--force-color",
		action="store_true",
		help="Force colored output even if terminal detection fails (or set FORCE_COLOR=1).",
	)
	common.add_argument(
		"-cd", "--color-diag",
		action="store_true",
		help="Print color diagnostics at start (provider-specific).",
	)
	return common


def main(argv: list[str] | None = None) -> int:
	if argv is None:
		argv = sys.argv[1:]

	common = _build_common_parser()
	parser = argparse.ArgumentParser(
		prog="3c",
		description="3C — Competitive Coding Challenge CLI",
		add_help=True,
		parents=[common],
	)
	parser.add_argument(
		"-v", "--version",
		action="store_true",
		help="Print version and exit.",
	)

	subparsers = parser.add_subparsers(dest="cmd", required=False, metavar="{lc,doctor,...}")

	doctor_mod.register_subparser(subparsers, parents=[common])

	registry = ProviderRegistry()
	registry.autodiscover("ccc.cli.providers")
	registry.register_all(subparsers, parents=[common])

	args = parser.parse_args(argv)

	if getattr(args, "version", False):
		print(CLI_ASCII_LOGO)
		print(f"3C CLI version {_get_pkg_version()}")
		return 0

	no_color = bool(getattr(args, "no_color", False))
	force_color = bool(getattr(args, "force_color", False))
	init_consoles(no_color=no_color, force_color=force_color)

	ctx = ProviderContext(
		debug=bool(getattr(args, "debug", False)),
		no_color=no_color,
		force_color=force_color,
		color_diag=bool(getattr(args, "color_diag", False)),
	)

	if ctx.color_diag:
		color_diag()
		return 0

	if getattr(args, "cmd", None) == "doctor":
		return int(doctor_mod.run(args))

	if hasattr(args, "provider_name"):
		provider_name = getattr(args, "provider_name")
		return registry.run(provider_name, args, ctx)

	parser.print_help()
	return 2


if __name__ == "__main__":
	sys.exit(main())
