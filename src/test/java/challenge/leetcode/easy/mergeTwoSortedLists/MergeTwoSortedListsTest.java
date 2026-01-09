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
package challenge.leetcode.easy.mergeTwoSortedLists;

import static challenge.leetcode.easy.mergeTwoSortedLists.MergeTwoSortedLists.merge;
import data.ListNode;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static data.ListNode.createListNode;

@DisplayName("21. Merge Two Sorted Lists")
class MergeTwoSortedListsTest
{
	private static final int[] INTS_EMPTY = new int[]{};
	private static final int[] INTS_0 = new int[]{0};
	private static final int[] INTS_1 = new int[]{1, 2, 4};
	private static final int[] INTS_2 = new int[]{1, 3, 4};
	private static final int[] INTS_3 = new int[]{1, 2, 3, 4, 5, 6};
	private static final int[] INTS_4 = new int[]{1, 2, 3, 4, 5, 6, 7};
	private static final int[] INTS_5 = new int[]{-47, -5, 1, 5, 99, 100, 100};
	private static final int[] INTS_6 = new int[]{-47, -5, 1, 3, 3, 7, 99, 100, 100};

	private static final ListNode LISTNODE_A_EMPTY = createListNode(INTS_EMPTY);
	private static final ListNode LISTNODE_A_0 = createListNode(INTS_0);

	private static final ListNode LISTNODE_B_1 = createListNode(INTS_1);
	private static final ListNode LISTNODE_B_2 = createListNode(INTS_2);

	private static final ListNode LISTNODE_C_1 = createListNode(INTS_1);
	private static final ListNode LISTNODE_C_3 = createListNode(INTS_3);

	private static final ListNode LISTNODE_D_3 = createListNode(INTS_3);
	private static final ListNode LISTNODE_D_4 = createListNode(INTS_4);

	private static final ListNode LISTNODE_E_5 = createListNode(INTS_5);
	private static final ListNode LISTNODE_E_6 = createListNode(INTS_6);

	private static final ListNode LISTNODE_F_0 = createListNode(INTS_0);
	private static final ListNode LISTNODE_F_6 = createListNode(INTS_6);

	@Test
	void mergeTwoLists()
	{
		assertArrayEquals(
			concat(INTS_EMPTY, INTS_0),
			merge(LISTNODE_A_EMPTY, LISTNODE_A_0).toArray());

		assertArrayEquals(
			concat(INTS_1, INTS_2),
			merge(LISTNODE_B_1, LISTNODE_B_2).toArray());

		assertArrayEquals(
			concat(INTS_1, INTS_3),
			merge(LISTNODE_C_1, LISTNODE_C_3).toArray());

		assertArrayEquals(
			concat(INTS_3, INTS_4),
			merge(LISTNODE_D_3, LISTNODE_D_4).toArray());

		assertArrayEquals(
			concat(INTS_5, INTS_6),
			merge(LISTNODE_E_5, LISTNODE_E_6).toArray());

		assertArrayEquals(
			concat(INTS_0, INTS_6),
			merge(LISTNODE_F_0, LISTNODE_F_6).toArray());
	}

	int[] concat(int[] a, int[] b)
	{
		int[] c = ArrayUtils.addAll(a, b);
		Arrays.sort(c);
		return c;
	}
}