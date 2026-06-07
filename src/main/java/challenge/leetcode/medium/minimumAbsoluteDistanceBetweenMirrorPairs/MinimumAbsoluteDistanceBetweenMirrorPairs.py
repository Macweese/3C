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

from typing import List

class Solution:
	def minMirrorPairDistance(self, nums: List[int]) -> int:
		def reverse(x: int) -> int:
			y = 0
			while x:
				y = y * 10 + x % 10
				x //= 10
			return y

		pos = {}
		ans = len(nums) + 1

		for i, x in enumerate(nums):
			if x in pos:
				ans = min(ans, i - pos[x])
			pos[reverse(x)] = i

		return -1 if ans > len(nums) else ans
