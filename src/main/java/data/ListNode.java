/*
 *
 *     Copyright (C) 2011 Macweese <https://www.github.com/Macweese>
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
package data;

import java.util.LinkedList;

/**
 * <h3>Singly-linked list</h3>
 *
 * <p>
 * A data structure commonly used in LeetCode questions.
 * </p>
 *
 * <br>
 */
public class ListNode
{
	public int val;
	public ListNode next;

	public ListNode()
	{
	}

	public ListNode(int val)
	{
		this.val = val;
	}

	public ListNode(int val, ListNode next)
	{
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString()
	{
		ListNode me = this;
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		while (me != null)
		{
			sb.append(me.val)
				.append(me.next == null ? "" : ", ");
			me = me.next;
		}
		sb.append("]");

		return sb.toString();
	}

	public int[] toArray()
	{
		ListNode me = this;
		LinkedList<Integer> list = new LinkedList<>();

		while (me != null)
		{
			list.add(me.val);
			me = me.next;
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
