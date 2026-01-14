#
#      Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

class separate_squares_i:
	def separateSquares(self, squares: List[List[int]]) -> float:
		total_area = sum(l * l for x, y, l in squares)
		target_area = total_area / 2

		events = []
		for x, y, l in squares:
			events.append((y, l))
			events.append((y + l, -l))

		events.sort()

		current_area = 0
		current_rate = 0
		prev_y = 0

		for y, delta_rate in events:
			area_gained = current_rate * (y - prev_y)

			if current_area + area_gained >= target_area:
				remaining = target_area - current_area
				if current_rate > 0:
					return prev_y + remaining / current_rate
				else:
					return prev_y

			current_area += area_gained
			current_rate += delta_rate
			prev_y = y

		return prev_y
