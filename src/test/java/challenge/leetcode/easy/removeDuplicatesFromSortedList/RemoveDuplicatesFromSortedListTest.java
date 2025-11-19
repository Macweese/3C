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
package challenge.leetcode.easy.removeDuplicatesFromSortedList;

import static challenge.leetcode.easy.removeDuplicatesFromSortedList.RemoveDuplicatesFromSortedList.createListNode;
import static challenge.leetcode.easy.removeDuplicatesFromSortedList.RemoveDuplicatesFromSortedList.deleteDuplicates;
import static challenge.leetcode.easy.removeDuplicatesFromSortedList.RemoveDuplicatesFromSortedList.listNodeToArray;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static utils.DataUtils.generateRandomArray;

@DisplayName("83. Remove Duplicates From Sorted List")
class RemoveDuplicatesFromSortedListTest
{
	static final int[] CASE_1 = new int[]{1, 1, 2};
	static final int[] CASE_2 = new int[]{1, 1, 2, 3, 3};
	static final int[] CASE_3 = new int[]{1, 1, 2, 3, 3, 3, 3, 5, 9, 9, 10};
	static final int[] CASE_4 = new int[]{1};
	static final int[] CASE_5 = new int[]{};

	static final int[] EXPECTED_1 = new int[]{1, 2};
	static final int[] EXPECTED_2 = new int[]{1, 2, 3};
	static final int[] EXPECTED_3 = new int[]{1, 2, 3, 5, 9, 10};
	static final int[] EXPECTED_4 = new int[]{1};
	static final int[] EXPECTED_5 = new int[]{};

	@Test
	@DisplayName("Test: Delete Duplicates (Predetermined values)")
	void deleteDuplicatesTest()
	{
		validate(EXPECTED_1, listNodeToArray(deleteDuplicates(createListNode(CASE_1))));
		validate(EXPECTED_2, listNodeToArray(deleteDuplicates(createListNode(CASE_2))));
		validate(EXPECTED_3, listNodeToArray(deleteDuplicates(createListNode(CASE_3))));
		validate(EXPECTED_4, listNodeToArray(deleteDuplicates(createListNode(CASE_4))));
		validate(EXPECTED_5, listNodeToArray(deleteDuplicates(createListNode(CASE_5))));
	}

	void validate(int[] expected, int[] actual)
	{
		String message = "Test failed.\nExpected: " + Arrays.toString(expected) + "\nActual: " + Arrays.toString(actual);
		assertArrayEquals(expected, actual, message);
	}

	@RepeatedTest(value = 100)
	@DisplayName("Test: Delete Duplicates (Random-generated values)")
	public void deleteDuplicatesRandomTest()
	{
		int[] array = Arrays.stream(generateRandomArray(300, 100))
			.sorted()
			.distinct()
			.toArray();
		ListNode listNode = deleteDuplicates(createListNode(array));
		int[] result = listNodeToArray(listNode);

		validate(array, result);
	}
}