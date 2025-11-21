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

import abc
import importlib
import pkgutil
from dataclasses import dataclass
from typing import Optional, Type, Dict, Any, List


@dataclass
class ProviderContext:
	debug: bool = False
	no_color: bool = False
	force_color: bool = False
	color_diag: bool = False


class Provider(abc.ABC):
	"""
	Abstract base class for all 3C CLI providers.

	Each provider implements:
	- name: short CLI name, e.g. "lc"
	- register(subparsers, parents): attach argparse subparser(s)
	- run(args, ctx): perform its work and return exit code (int)
	"""

	#: Short provider name (used in CLI and registry keys)
	name: str

	@classmethod
	@abc.abstractmethod
	def register(cls, subparsers, parents: Optional[List[Any]] = None):
		"""
		Register this provider with the argparse subparsers.

		Implementations must:
		- Create a subparser, usually named by `cls.name`
		- Attach arguments and set `set_defaults(provider_name=cls.name, provider_cls=cls)`
		"""
		raise NotImplementedError

	@abc.abstractmethod
	def run(self, args, ctx: ProviderContext) -> int:
		raise NotImplementedError


class ProviderRegistry:
	def __init__(self) -> None:
		self._providers: Dict[str, Type[Provider]] = {}

	def add(self, provider_cls: Type[Provider]) -> None:
		name = getattr(provider_cls, "name", None)
		if not name:
			raise ValueError(f"Provider {provider_cls!r} has no 'name' attribute")
		self._providers[name] = provider_cls

	def get(self, name: str) -> Optional[Type[Provider]]:
		return self._providers.get(name)

	def run(self, name: str, args, ctx: ProviderContext) -> int:
		provider_cls = self.get(name)
		if provider_cls is None:
			raise SystemExit(f"Unknown provider: {name!r}")
		provider = provider_cls()
		return int(provider.run(args, ctx))

	def register_all(self, subparsers, parents: Optional[List[Any]] = None) -> None:
		for provider_cls in self._providers.values():
			provider_cls.register(subparsers, parents=parents)

	def autodiscover(self, package: str) -> None:
		"""
		Import all modules in the given package and look for Provider subclasses
		with a non-empty `name` attribute. They are automatically registered.
		"""
		pkg = importlib.import_module(package)
		for modinfo in pkgutil.iter_modules(pkg.__path__, prefix=package + "."):
			mod = importlib.import_module(modinfo.name)
			for attr_name in dir(mod):
				obj = getattr(mod, attr_name)
				if isinstance(obj, type) and issubclass(obj, Provider) and obj is not Provider:
					name = getattr(obj, "name", None)
					if name:
						self.add(obj)
