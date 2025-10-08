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
 *
 */
package challenge.medium.addTwoNumbers;

import data.ListNode;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static utils.DataUtils.createListNode;

class AddTwoNumbersTest
{
	private static final ListNode LISTNODE_1 = createListNode(new int[]{2, 4, 3});
	private static final ListNode LISTNODE_2 = createListNode(new int[]{5, 6, 4});

	private static final ListNode LISTNODE_3 = createListNode(new int[]{0});
	private static final ListNode LISTNODE_4 = createListNode(new int[]{0});

	private static final ListNode LISTNODE_5 = createListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
	private static final ListNode LISTNODE_6 = createListNode(new int[]{9, 9, 9, 9});

	private static final ListNode LISTNODE_7 = createListNode(new int[]{0, 9, 9, 9});
	private static final ListNode LISTNODE_8 = createListNode(new int[]{0, 0, 0, 2});

	private static final ListNode LISTNODE_9 = createListNode(new int[]{0, 1});
	private static final ListNode LISTNODE_10 = createListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});

	private static final ListNode LISTNODE_11 = createListNode(new int[]{9});
	private static final ListNode LISTNODE_12 = createListNode(new int[]{9, 9, 4, 1, 8, 4, 6, 2, 8, 7, 7, 5, 4, 6, 2});

	private static final ListNode LISTNODE_13 = createListNode(new int[]{0, 9, 3, 5, 3, 8, 9, 0, 7, 2, 7, 0});
	private static final ListNode LISTNODE_14 = createListNode(new int[]{5, 0, 7, 0, 9, 0, 5, 1, 0, 1, 0, 0, 3, 0, 7});

	@Test
	void TestAdd()
	{
		test(AddTwoNumbers.add(LISTNODE_1, LISTNODE_1), AddTwoNumbers.add(LISTNODE_1, LISTNODE_1).toArray()); // 4 8 6
		test(AddTwoNumbers.add(LISTNODE_1, LISTNODE_2), AddTwoNumbers.add(LISTNODE_1, LISTNODE_2).toArray()); // 7 0 8
		test(AddTwoNumbers.add(LISTNODE_1, LISTNODE_3), AddTwoNumbers.add(LISTNODE_1, LISTNODE_3).toArray()); // 2 4 3
		test(AddTwoNumbers.add(LISTNODE_1, LISTNODE_5), AddTwoNumbers.add(LISTNODE_1, LISTNODE_5).toArray()); // 1 4 3 0 0 0 0 1
		test(AddTwoNumbers.add(LISTNODE_1, LISTNODE_6), AddTwoNumbers.add(LISTNODE_1, LISTNODE_6).toArray()); // 1 4 3 0 1
		test(AddTwoNumbers.add(LISTNODE_2, LISTNODE_2), AddTwoNumbers.add(LISTNODE_2, LISTNODE_2).toArray()); // 0 3 9
		test(AddTwoNumbers.add(LISTNODE_2, LISTNODE_5), AddTwoNumbers.add(LISTNODE_2, LISTNODE_5).toArray()); // 4 6 4 0 0 0 0 1
		test(AddTwoNumbers.add(LISTNODE_2, LISTNODE_6), AddTwoNumbers.add(LISTNODE_2, LISTNODE_6).toArray()); // 4 6 4 0 1
		test(AddTwoNumbers.add(LISTNODE_3, LISTNODE_4), AddTwoNumbers.add(LISTNODE_3, LISTNODE_4).toArray()); // 0
		test(AddTwoNumbers.add(LISTNODE_3, LISTNODE_5), AddTwoNumbers.add(LISTNODE_3, LISTNODE_5).toArray()); // 9 9 9 9 9 9 9
		test(AddTwoNumbers.add(LISTNODE_5, LISTNODE_5), AddTwoNumbers.add(LISTNODE_5, LISTNODE_5).toArray()); // 8 9 9 9 9 9 9 1
		test(AddTwoNumbers.add(LISTNODE_6, LISTNODE_6), AddTwoNumbers.add(LISTNODE_6, LISTNODE_6).toArray()); // 8 9 9 9 1
		test(AddTwoNumbers.add(LISTNODE_7, LISTNODE_8), AddTwoNumbers.add(LISTNODE_7, LISTNODE_8).toArray()); // 0 9 9 1 1
		test(AddTwoNumbers.add(LISTNODE_8, LISTNODE_9), AddTwoNumbers.add(LISTNODE_8, LISTNODE_9).toArray()); // 0 1 0 2
		test(AddTwoNumbers.add(LISTNODE_7, LISTNODE_9), AddTwoNumbers.add(LISTNODE_7, LISTNODE_9).toArray()); // 0 0 0 0 1
		test(AddTwoNumbers.add(LISTNODE_9, LISTNODE_10), AddTwoNumbers.add(LISTNODE_9, LISTNODE_10).toArray()); // 1 0 0 0 0 0 0 0 0 0 1
		test(AddTwoNumbers.add(LISTNODE_10, LISTNODE_11), AddTwoNumbers.add(LISTNODE_10, LISTNODE_11).toArray()); // 0 0 0 0 0 0 0 0 0 0 1
		test(AddTwoNumbers.add(LISTNODE_10, LISTNODE_12), AddTwoNumbers.add(LISTNODE_10, LISTNODE_12).toArray()); // 0 9 4 1 8 4 6 2 8 7 8 5 4 6 2
		test(AddTwoNumbers.add(LISTNODE_12, LISTNODE_13), AddTwoNumbers.add(LISTNODE_12, LISTNODE_13).toArray()); // 9 8 8 6 1 3 6 3 5 0 5 6 4 6 2
		test(AddTwoNumbers.add(LISTNODE_12, LISTNODE_14), AddTwoNumbers.add(LISTNODE_12, LISTNODE_14).toArray()); // 4 0 2 2 7 5 1 4 8 8 7 5 7 6 9
		test(AddTwoNumbers.add(LISTNODE_13, LISTNODE_14), AddTwoNumbers.add(LISTNODE_13, LISTNODE_14).toArray()); // 5 9 0 6 2 9 4 2 7 3 7 0 3 0 7
	}

	private void test(ListNode listNode, int[] digits)
	{
		int i = 0;
		while (listNode != null)
		{
			assertEquals(listNode.val, digits[i], "\nTest failed on case:\n" + listNode + "\n" + Arrays.toString(digits) + "\nFailure at index: " + i);
			listNode = listNode.next;
			i++;
		}
	}
}