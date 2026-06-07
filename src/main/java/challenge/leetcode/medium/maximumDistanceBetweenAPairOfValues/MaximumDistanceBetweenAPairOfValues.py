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
	def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
		res = 0
		j = 0
		for i in range(len(nums1)):
			while j < len(nums2) and nums1[i] <= nums2[j]:
				j += 1
			res = max(res, j - i - 1)
		return res