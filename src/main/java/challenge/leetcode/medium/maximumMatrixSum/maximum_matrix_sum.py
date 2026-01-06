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

class Solution:
	def maxMatrixSum(self, matrix: list[list[int]]) -> int:

		total_sum = 0
		negative_count = 0
		min_abs_value = float('inf')

		for row in matrix:
			for val in row:
				total_sum += abs(val)

				if val < 0:
					negative_count += 1

				min_abs_value = min(min_abs_value, abs(val))

		if negative_count % 2 == 1:
			total_sum -= 2 * min_abs_value

		return total_sum
