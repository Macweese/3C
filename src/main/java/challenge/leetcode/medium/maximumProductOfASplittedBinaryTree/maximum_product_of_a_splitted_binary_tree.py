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

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
	def maxProduct(self, root: Optional[TreeNode]) -> int:
		MOD = 10**9 + 7

		def get_total_sum(node):
			if not node:
				return 0
			return node.val + get_total_sum(node.left) + get_total_sum(node.right)

		total = get_total_sum(root)
		self.max_product = 0

		def get_subtree_sum(node):
			if not node:
				return 0

			left_sum = get_subtree_sum(node.left)
			right_sum = get_subtree_sum(node.right)
			subtree_sum = node.val + left_sum + right_sum

			product = subtree_sum * (total - subtree_sum)
			self.max_product = max(self.max_product, product)

			return subtree_sum

		get_subtree_sum(root)
		return self.max_product % MOD
