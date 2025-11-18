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
package challenge.leetcode.easy.removeElement;

import static challenge.leetcode.easy.removeElement.RemoveElement.removeElement;
import java.util.Arrays;
import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static utils.DataUtils.generateRandomArray;

@DisplayName("27. Remove Element")
class RemoveElementTest
{
	static final int[] ARRAY_0 = new int[]{};
	static final int[] ARRAY_1 = new int[]{3, 2, 2, 3};
	static final int[] ARRAY_2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
	static final int[] ARRAY_3 = new int[]{2};

	@Test
	void testRemoveElement()
	{
/*
		// LeetCode test
		int[] nums = generateRandomSortedArray();    // Input array
		int val = (int) (Math.random() * 101);       // Value to remove
		int[] expectedNums = filterArray(nums, val); // The expected answer with correct length.
                                                     // It is sorted with no values equaling val.
		int k = removeElement(nums, val);            // Calls your implementation
		int actualLength = expectedNums.length;
		assertEquals(k, actualLength);
		sort(nums, 0, k);                            // Sort the first k elements of nums
		for (int i = 0; i < actualLength; i++)
		{
			assertEquals(nums[i], expectedNums[i]);
		}
*/

		testRemoveElementPredefined(ARRAY_0, 0, 0);
		testRemoveElementPredefined(ARRAY_1, 3, 2);
		testRemoveElementPredefined(ARRAY_2, 2, 5);
		testRemoveElementPredefined(ARRAY_3, 3, 1);
		testRemoveElementRandom();
	}

	//	@Test
	void testRemoveElementPredefined(int[] ints, int val, int k)
	{
		int[] expected = filterArray(ints, val);
		int expectedLength = removeElement(ints, val);

		sort(ints, 0, k);
		assertEquals(k, expectedLength);
		for (int i = 0; i < k; i++)
		{
			assertEquals(ints[i], expected[i], "\nMismatch at index=" + i + "\nExpected=\n\t" + Arrays.toString(expected) + "\nActual=\n\t" + Arrays.toString(ints));
		}
	}

	@Test
	void testRemoveElementRandom()
	{
		int[] ints = generateRandomArray(100, 50);
		int val = (int) (Math.random() * 101);
		int[] expected = filterArray(ints, val);
		int k = removeElement(ints, val);

		sort(ints, 0, k);
		assertEquals(k, expected.length);
		for (int i = 0; i < k; i++)
		{
			assertEquals(ints[i], expected[i], "\nMismatch at index=" + i + "\nExpected=\n\t" + Arrays.toString(expected) + "\nActual=\n\t" + Arrays.toString(ints));
		}
	}

	private int[] filterArray(int[] ints, int val)
	{
		return Arrays.stream(ints).filter(i -> i != val).sorted().toArray();
	}
}