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
Spinning ASCII donut (easter egg, `3c --donut`).

Classic torus renderer: every frame the surface is sampled, rotated around two
axes, perspective-projected onto a character grid and shaded by the surface
normal's dot product with a fixed light direction.
"""

from __future__ import annotations

import os
import sys
import time
from math import cos, pi, sin
from typing import List, Optional, Tuple

WIDTH = 80
HEIGHT = 24
LUMINANCE = ".,-~:;=!*#$@"
FRAME_INTERVAL = 1 / 30  # seconds; caps the frame rate
EXIT_HINT = "Press ESC, Q or CTRL+C to exit"

_ESC = "\x1b"
_HIDE_CURSOR = "\x1b[?25l"
_SHOW_CURSOR = "\x1b[?25h"
_CLEAR = "\x1b[2J"
_HOME = "\x1b[H"

_QUIT_KEYS = frozenset((_ESC, "q", "Q", "\x03"))


def _trig_table(step: float) -> List[Tuple[float, float]]:
	"""(sin, cos) pairs for one full revolution sampled every `step` radians."""
	return [(sin(i * step), cos(i * step)) for i in range(1, int(2 * pi / step) + 2)]


# The sampling angles never change between frames, so their sines/cosines are
# computed once instead of ~28k times per frame.
_TUBE = _trig_table(0.07)  # angle around the tube cross-section
_RING = _trig_table(0.02)  # angle around the torus' axis of revolution


def render_frame(a: float, b: float) -> str:
	"""Render one frame for rotation angles `a` (x-axis) and `b` (z-axis)."""
	size = WIDTH * HEIGHT
	zbuf = [0.0] * size
	screen = [" "] * size

	sin_a, cos_a = sin(a), cos(a)
	sin_b, cos_b = sin(b), cos(b)

	for sin_j, cos_j in _TUBE:
		h = cos_j + 2  # distance of the tube point from the torus axis
		sj_ca = sin_j * cos_a
		sj_sa = sin_j * sin_a
		for sin_i, cos_i in _RING:
			depth = 1 / (sin_i * h * sin_a + sj_ca + 5)  # 1/z
			t = sin_i * h * cos_a - sj_sa
			x = int(40 + 30 * depth * (cos_i * h * cos_b - t * sin_b))
			y = int(12 + 15 * depth * (cos_i * h * sin_b + t * cos_b))
			if 0 <= y < HEIGHT and 0 <= x < WIDTH:
				p = x + WIDTH * y
				if depth > zbuf[p]:
					zbuf[p] = depth
					n = int(8 * ((sj_sa - sin_i * cos_j * cos_a) * cos_b
								 - sin_i * cos_j * sin_a
								 - sj_ca
								 - cos_i * cos_j * sin_b))
					screen[p] = LUMINANCE[n if n > 0 else 0]

	return "\n".join("".join(screen[r:r + WIDTH]).rstrip() for r in range(0, size, WIDTH))


class _Keyboard:
	"""Non-blocking single-key reader; a no-op when stdin is not a terminal."""

	def __init__(self) -> None:
		self._fd: Optional[int] = None
		self._saved = None
		self._posix = os.name == "posix"

	def __enter__(self) -> "_Keyboard":
		if self._posix:
			try:
				import termios
				import tty

				fd = sys.stdin.fileno()
				self._saved = termios.tcgetattr(fd)
				# cbreak (not raw): keys arrive unbuffered while output
				# post-processing and CTRL+C keep working.
				tty.setcbreak(fd)
				self._fd = fd
			except Exception:
				self._fd = None
		return self

	def __exit__(self, *exc) -> None:
		if self._fd is not None and self._saved is not None:
			try:
				import termios

				termios.tcsetattr(self._fd, termios.TCSADRAIN, self._saved)
			except Exception:
				pass

	def quit_requested(self) -> bool:
		try:
			if self._posix:
				if self._fd is None:
					return False
				import select

				if select.select([self._fd], [], [], 0)[0]:
					return os.read(self._fd, 1).decode("latin-1") in _QUIT_KEYS
				return False
			import msvcrt

			return bool(msvcrt.kbhit()) and msvcrt.getwch() in _QUIT_KEYS
		except Exception:
			return False


def main(frames: Optional[int] = None) -> int:
	"""
	Animate the donut until ESC/Q/CTRL+C is pressed (or for `frames` frames).

	When stdout is not a terminal a single frame is printed instead, so the
	command stays usable in pipes and scripts.
	"""
	out = sys.stdout
	if not out.isatty():
		out.write(render_frame(1.0, 0.5) + "\n")
		return 0

	if os.name == "nt":
		os.system("")  # enables ANSI escape processing on legacy Windows consoles

	a = b = 0.0
	shown = 0
	out.write(_HIDE_CURSOR + _CLEAR)
	try:
		with _Keyboard() as keyboard:
			while frames is None or shown < frames:
				started = time.monotonic()
				# Homing the cursor and overwriting in place avoids the flicker
				# (and process spawn) of clearing the screen every frame.
				out.write(f"{_HOME}{render_frame(a, b)}\n{EXIT_HINT}")
				out.flush()
				shown += 1
				a += 0.04
				b += 0.02
				if keyboard.quit_requested():
					break
				delay = FRAME_INTERVAL - (time.monotonic() - started)
				if delay > 0:
					time.sleep(delay)
	except KeyboardInterrupt:
		pass
	finally:
		out.write(_SHOW_CURSOR + "\n")
		out.flush()
	return 0


if __name__ == "__main__":
	sys.exit(main())
