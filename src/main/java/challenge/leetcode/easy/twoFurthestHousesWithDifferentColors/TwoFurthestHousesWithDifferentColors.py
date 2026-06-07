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
	def maxDistance(self, colors: List[int]) -> int:
		n = len(colors)
		left = 0
		right = n - 1

		while colors[left] == colors[right]:
			left += 1

		max_dist = right - left

		left = 0
		right = n - 1

		while colors[left] == colors[right]:
			right -= 1

		max_dist = max(max_dist, right - left)

		return max_dist