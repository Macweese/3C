/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.smallestSubtreeWithAllTheDeepestNodes;

import challenge.leetcode.medium.maximumMatrixSum.MaximumMatrixSum;
import challenge.leetcode.medium.new21Game.New21Game;
import data.ListNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.TreeNode;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:49 Fri 09 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("865. Smallest Subtree With All The Deepest Nodes")
class SmallestSubtreeWithAllTheDeepestNodesTest
{
	private static final Map<TreeNode, TreeNode> MAP = new HashMap<>();

	static
	{
//		MAP.put()
	}

	@Test
	void subtreeWithAllDeepest()
	{
		for (Map.Entry<TreeNode, TreeNode> entry : MAP.entrySet())
		{
			final TreeNode input = entry.getKey();
			final TreeNode expected = entry.getValue();
			final TreeNode actual = SmallestSubtreeWithAllTheDeepestNodes.subtreeWithAllDeepest(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", input.toString(),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}

	static void main()
	{
		ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3});
	}
}
