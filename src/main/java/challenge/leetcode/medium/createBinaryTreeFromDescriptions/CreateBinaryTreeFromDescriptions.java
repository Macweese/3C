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

package challenge.leetcode.medium.createBinaryTreeFromDescriptions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @Created 07:32 Sun 07 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CreateBinaryTreeFromDescriptions
{
	public static TreeNode createBinaryTree(int[][] descriptions)
	{
		Map<Integer, TreeNode> nodes = new HashMap<>();
		Set<Integer> children = new HashSet<>();

		for (int[] desc : descriptions)
		{
			int parent = desc[0];
			int child = desc[1];
			int isLeft = desc[2];

			nodes.putIfAbsent(parent, new TreeNode(parent));
			nodes.putIfAbsent(child, new TreeNode(child));

			if (isLeft == 1)
			{
				nodes.get(parent).left = nodes.get(child);
			}
			else
			{
				nodes.get(parent).right = nodes.get(child);
			}

			children.add(child);
		}

		for (int val : nodes.keySet())
		{
			if (!children.contains(val))
			{
				return nodes.get(val);
			}
		}

		return null;
	}
}
