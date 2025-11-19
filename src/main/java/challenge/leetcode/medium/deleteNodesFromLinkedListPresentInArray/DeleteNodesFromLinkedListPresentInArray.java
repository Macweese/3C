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

package challenge.leetcode.medium.deleteNodesFromLinkedListPresentInArray;

import data.ListNode;
import java.util.HashSet;

/**
 * @author Administrator
 * @Created 01/11/2025, 08:11 Sat 01 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class DeleteNodesFromLinkedListPresentInArray
{
	public static ListNode modifiedList(int[] ints, ListNode head)
	{
		HashSet<Integer> forbidden = new HashSet<>();
		for (int i : ints)
		{
			forbidden.add(i);
		}

		ListNode root = new ListNode();
		ListNode node = new ListNode();
		ListNode prev = new ListNode();
		root.next = node;

		while (head != null)
		{
			if (!forbidden.contains(head.val))
			{
				prev = node;
				node.val = head.val;
				node.next = new ListNode();
				node = node.next;
			}

			head = head.next;
		}

		prev.next = null;
		return root.next;
	}
}
