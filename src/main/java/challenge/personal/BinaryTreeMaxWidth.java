/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package challenge.personal;

import javax.swing.tree.TreeNode;

/*
	Given the root of a binary tree, return the maximum width of the given tree.

	The maximum width of a tree is the maximum width among all levels.

	The width of one level is defined as the length between the
	end-nodes (the leftmost and rightmost non-null nodes),
	where the null nodes between the end-nodes that would be present
	in a complete binary tree extending down to that level are
	also counted into the length calculation.

	It is guaranteed that the answer will in the range of a 32-bit signed integer.



	Example 1:
		1				1                 1     	 1
		2		3-------|-------2                  /   \
		3	5---|---3     NULL--|---9     2       3     2
			                                     / \   /  \
		 	                              3     5   3  N   9

	Input: root = [1,3,2,5,3,null,9]
	Output: 4
	Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

	Example 2:
		 1
	   /   \
	  3     2
	 / \   /  \
	5   3  N   9
	Input: root = [1,3,2,5,null,null,9,6,null,7]
	Output: 7
	Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
	Example 3:


	Input: root = [1,3,2,5]
	Output: 2
	Explanation: The maximum width exists in the second level with length 2 (3,2).


	Constraints:

	The number of nodes in the tree is in the range [1, 3000].
	-100 <= Node.val <= 100
 */
public class BinaryTreeMaxWidth implements Runnable
{

	@Override
	public void run()
	{

	}

	/*
		The minimum height of a binary tree can be calculated by
		d = depth
		N = nodes

		h >= ceiling(log2(N+1)) - 1

		Max width at depth d can be calculated by
		2^d

		Max capacity N for the tree structure can be calculated by
		N = 2^0 + 2^1 + .... + 2^d - 1


	 */
	public void maxWidth(int[] array)
	{
		int n = array.length;

		int depth = (int) Math.ceil(Math.log(n + 1) / Math.log(2)) - 1;

		int a = 2 << depth;
		int b = 2 * depth;

		int maxNodes = 0;
		for (int i = 0; i < depth + 2; i++)
		{
			maxNodes += 2 << i;
		}
		maxNodes -= 1;


	}

	public void test(TreeNode root)
	{
		// Stupid question requires traversal to find distance node A node B
	}
}
