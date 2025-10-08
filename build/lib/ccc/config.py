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

from pathlib import Path
import os

# Where to store caches (JSON maps, contest cache, etc.)
# Env override: 3C_CACHE_DIR
CACHE_DIR = Path(os.environ.get("3C_CACHE_DIR", str(Path.home() / ".3c" / "cache")))
CACHE_DIR.mkdir(parents=True, exist_ok=True)

# Default base out dir for generated READMEs
# Env override: 3C_OUT_DIR
# If unset/empty, default to the current working directory.
DEFAULT_OUT_DIR = os.environ.get("3C_OUT_DIR") or "."