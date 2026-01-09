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

import data.Tree;
import data.Tree.Node;
import data.Tree.PostOrder;
import java.util.ArrayList;
import javax.swing.tree.TreeNode;

/**
 * @author Administrator
 * @Created 06:47 Fri 09 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class SmallestSubtreeWithAllTheDeepestNodes
{
	public static TreeNode subtreeWithAllDeepest(TreeNode root)
	{
		return null;
	}

	static void main()
	{
		Tree<Integer> tree = new Tree<>(new Integer[]{0, 1, 2, 3});
		ArrayList<Node> list = new ArrayList<>();
		tree.traverse(list::add);
		IO.println("PostOrder:" );
		tree.traverse(new PostOrder(IO::print));
		IO.println("InOrder:" );
		tree.traverse(new Tree.InOrder(IO::print));
		IO.println("PreOrder:" );
		tree.traverse(new Tree.PreOrder(IO::print));
		IO.println("LevelOrder:" );
		tree.traverse(new Tree.LevelOrder(IO::print));
	}
}