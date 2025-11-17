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

import challenge.leetcode.easy.removeDuplicatesFromSortedList.ListNode;
import challenge.leetcode.easy.removeDuplicatesFromSortedList.RemoveDuplicatesFromSortedList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static utils.DataUtils.generateRandomArray;

@DisplayName("83. Remove Duplicates From Sorted List")
class RemoveDuplicatesFromSortedListTest
{
	static final int[] DUPLICATE_VALUES_1 = new int[]{1, 1, 2};
	static final int[] DUPLICATE_VALUES_2 = new int[]{1, 1, 2, 3, 3};
	static final int[] DUPLICATE_VALUES_3 = new int[]{1, 1, 2, 3, 3, 3, 3, 5, 9, 9, 10};
	static final int[] DUPLICATE_VALUES_4 = new int[]{1};
	static final int[] DUPLICATE_VALUES_5 = new int[]{};

	static final int[] ANSWER_VALUES_1 = new int[]{1, 2};
	static final int[] ANSWER_VALUES_2 = new int[]{1, 2, 3};
	static final int[] ANSWER_VALUES_3 = new int[]{1, 2, 3, 5, 9, 10};
	static final int[] ANSWER_VALUES_4 = new int[]{1};
	static final int[] ANSWER_VALUES_5 = new int[]{};

	@Test
	void deleteDuplicatesTest()
	{
		randomTest(100);
	}

	void deleteDuplicatesTest(int[] expected, int[] result)
	{
		String message = "Test failed.\nExpected: " + Arrays.toString(expected) + "\nActual: " + Arrays.toString(result);
		assertArrayEquals(expected, result, message);
	}

	private void randomTest()
	{
		randomTest(1);
	}

	private void randomTest(int testCount)
	{
		for (int i = 0; i < testCount; i++)
		{
			int[] array = Arrays.stream(generateRandomArray(300, 100))
				.sorted()
				.distinct()
				.toArray();
			ListNode listNode = RemoveDuplicatesFromSortedList.deleteDuplicates(RemoveDuplicatesFromSortedList.createListNode(array));
			int[] result = RemoveDuplicatesFromSortedList.listNodeToArray(listNode);

			deleteDuplicatesTest(array, result);
		}
	}
}