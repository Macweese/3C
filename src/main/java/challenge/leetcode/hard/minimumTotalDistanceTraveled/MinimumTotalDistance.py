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
	def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
		robot.sort()
		factory.sort()

		@cache
		def dfs(i, j):
			if i == len(robot):
				return 0
			if j == len(factory):
				return float('inf')

			ans = dfs(i, j + 1)
			cur = 0
			for k in range(factory[j][1]):
				if i + k >= len(robot):
					break
				cur += abs(robot[i + k] - factory[j][0])
				ans = min(ans, cur + dfs(i + k + 1, j + 1))
			return ans

		return dfs(0, 0)
