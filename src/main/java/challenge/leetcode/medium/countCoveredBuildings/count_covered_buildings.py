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


class Solution:
	def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
		if len(buildings) < 5:
			return 0

		axis_x = defaultdict(list)
		axis_y = defaultdict(list)

		for x, y in buildings:
			axis_x[x].append(y)
			axis_y[y].append(x)

		for x in axis_x:
			axis_x[x].sort()

		for y in axis_y:
			axis_y[y].sort()

		res = 0
		for x, y in buildings:
			ox = axis_x[x]
			oy = axis_y[y]
			if oy[0] < x < oy[-1] and ox[0] < y < ox[-1]:
				res += 1

		return res
