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
package challenge.leetcode.easy.middleOfTheLinkedList;

import static challenge.leetcode.easy.middleOfTheLinkedList.MiddleOfTheLinkedList.middleNode;
import data.ListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static data.ListNode.createListNode;

@DisplayName("876. Middle of the Linked List")
class MiddleOfTheLinkedListTest
{
	static final ListNode CASE_1 = createListNode(new int[]{1});
	static final ListNode CASE_2 = createListNode(new int[]{1, 2, 3, 4, 5});
	static final ListNode CASE_3 = createListNode(new int[]{1, 2, 3, 4, 5, 6});
	static final ListNode CASE_4 = createListNode(new int[]{100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2});
	static final ListNode CASE_5 = createListNode(new int[]{100, 99, 98});
	static final ListNode CASE_6 = createListNode(new int[]{100, 99});
	static final ListNode CASE_7 = createListNode(new int[]{100});

	@Test
	void middleNodeTest()
	{
		assertEquals(1, middleNode(CASE_1).val);
		assertEquals(3, middleNode(CASE_2).val);
		assertEquals(4, middleNode(CASE_3).val);
		assertEquals(51, middleNode(CASE_4).val);
		assertEquals(99, middleNode(CASE_5).val);
		assertEquals(99, middleNode(CASE_6).val);
		assertEquals(100, middleNode(CASE_7).val);
	}
}