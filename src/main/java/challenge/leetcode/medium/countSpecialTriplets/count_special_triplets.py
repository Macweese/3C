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
	def specialTriplets(self, nums: List[int]) -> int:
		MOD = 10**9 + 7
		left = {}
		right = {}

		for x in nums:
			right[x] = right.get(x, 0) + 1

		ans = 0

		for x in nums:
			right[x] -= 1
			need = x * 2
			ans = (ans + left.get(need, 0) * right.get(need, 0)) % MOD
			left[x] = left.get(x, 0) + 1

		return ans
