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
import math
import os
import sys
from math import sin, cos

# Platform-specific imports
if os.name == "posix":
	try:
		import select
		import termios
		import tty
	except ImportError:
		print("Warning: Unix terminal modules not available")
else:
	try:
		import msvcrt
	except ImportError:
		print("Warning: Windows console module not available")


def check_for_escape():
	"""Check if ESC key was pressed (non-blocking)"""
	if os.name == "posix":
		# Unix/Linux/macOS
		try:
			if select.select([sys.stdin], [], [], 0) == ([sys.stdin], [], []):
				char = sys.stdin.read(1)
				if ord(char) == 27:  # ESC key
					return True
		except:
			return False
	else:
		# Windows
		try:
			if msvcrt.kbhit():
				char = msvcrt.getch()
				if ord(char) == 27:  # ESC key
					return True
		except:
			return False
	return False


def setup_terminal():
	"""Setup terminal for non-blocking input on Unix systems"""
	if os.name == "posix":
		try:
			# Save original terminal settings
			old_settings = termios.tcgetattr(sys.stdin)
			tty.setraw(sys.stdin.fileno())
			return old_settings
		except:
			return None
	return None


def restore_terminal(old_settings):
	"""Restore original terminal settings on Unix systems"""
	if os.name == "posix" and old_settings:
		try:
			termios.tcsetattr(sys.stdin, termios.TCSADRAIN, old_settings)
		except:
			pass


def main():
	a = 0
	b = 0

	height = 24
	width = 80

	# for clearing console (windows and unix systems)
	clear = "cls"
	if os.name == "posix":
		clear = "clear"

	# Setup terminal for non-blocking input
	old_settings = setup_terminal()

	try:
		os.system(clear)
		while True:
			# Check for escape key
			if check_for_escape():
				break

			z = [0 for _ in range(4 * height * width)]
			screen = [' ' for _ in range(height * width)]

			outer_torus = 0
			while outer_torus < (math.pi * 2):
				outer_torus += 0.07
				inner_torus = 0
				while inner_torus < (math.pi * 2):
					inner_torus += 0.02

					sinA = sin(a)
					cosA = cos(a)
					sinB = sin(b)
					cosB = cos(b)

					sin_inner_torus = sin(inner_torus)
					cos_inner_torus = cos(inner_torus)
					sin_outer_torus = sin(outer_torus)
					cos_outer_torus = cos(outer_torus)

					cosj2 = cos_outer_torus + 2
					mess = 1 / (sin_inner_torus * cosj2 * sinA + sin_outer_torus * cosA + 5)
					t = sin_inner_torus * cosj2 * cosA - sin_outer_torus * sinA

					# 40 is the left screen shift
					x = int(40 + 30 * mess * (cos_inner_torus * cosj2 * cosB - t * sinB))
					# 12 is the down screen shift
					y = int(11 + 15 * mess * (cos_inner_torus * cosj2 * sinB + t * cosB))
					# all values are implicitly floored from int casting
					p = int(x + width * y)
					# multiplying by 8 to bring in range 0-11 as 8 * (sqrt(2)) = 11
					# because we have 11 luminance characters
					n = int(8 * ((sin_outer_torus * sinA - sin_inner_torus * cos_outer_torus * cosA) * cosB
								 - sin_inner_torus * cos_outer_torus * sinA
								 - sin_outer_torus * cosA
								 - cos_inner_torus * cos_outer_torus * sinB))
					# if [x, y] inside screen and previous z-buffer is < mess
					# i.e. when z[p] is 0 or the prev point is behind the new point
					# change it to the point nearer to the eye / above prev point
					if 0 < y < height and 0 < x < width and z[p] < mess:
						z[p] = mess
						screen[p] = ".,-~:;=!*#$@"[n if n > 0 else 0]

			# prints
			os.system(clear)
			for index, char in enumerate(screen):
				if index % width == 0:
					print()
				else:
					print(char, end='')

			# Add "Press ESC to exit" message in the bottom-left corner
			exit_hint = "\nPress ESC or CTRL+C to exit"
			print(exit_hint)

			# increments
			a += 0.04
			b += 0.02

	except KeyboardInterrupt:
		# Handle Ctrl+C gracefully
		pass
	finally:
		# Restore terminal settings
		restore_terminal(old_settings)
		print("\nExiting...")
		exit(1)


if __name__ == "__main__":
	main()
