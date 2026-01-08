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

from collections import deque

class Solution:
	def maxLevelSum(self, root: Optional[TreeNode]) -> int:
		if not root:
			return 0

		queue = deque([root])
		max_sum = float('-inf')
		max_level = 0
		current_level = 0

		while queue:
			level_size = len(queue)
			level_sum = 0
			current_level += 1

			for _ in range(level_size):
				node = queue.popleft()
				level_sum += node.val

				if node.left:
					queue.append(node.left)
				if node.right:
					queue.append(node.right)

			if level_sum > max_sum:
				max_sum = level_sum
				max_level = current_level

		return max_level
