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

from collections import defaultdict
from typing import List


class Solution:
	def distance(self, nums: List[int]) -> List[int]:
		d = defaultdict(list)
		for i, x in enumerate(nums):
			d[x].append(i)
		ans = [0] * len(nums)
		for idx in d.values():
			left, right = 0, sum(idx) - len(idx) * idx[0]
			for i in range(len(idx)):
				ans[idx[i]] = left + right
				if i + 1 < len(idx):
					left += (idx[i + 1] - idx[i]) * (i + 1)
					right -= (idx[i + 1] - idx[i]) * (len(idx) - i - 1)
		return ans
