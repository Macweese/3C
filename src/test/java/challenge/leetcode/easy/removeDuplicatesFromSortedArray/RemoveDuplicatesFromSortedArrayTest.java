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
package challenge.leetcode.easy.removeDuplicatesFromSortedArray;

import static challenge.leetcode.easy.removeDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArray.removeDuplicates;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static utils.DataUtils.generateRandomArray;

@DisplayName("26. Remove Duplicates from Sorted Array")
class RemoveDuplicatesFromSortedArrayTest
{
	@Test
	void testRemoveDuplicates()
	{
		final int[] nums = generateRandomSortedArray();
		final int[] expectedNums = Arrays.stream(nums).distinct().toArray();

		final int k = removeDuplicates(nums);

		assertEquals(k, expectedNums.length);
		for (int i = 0; i < k; i++)
		{
			assertEquals(nums[i], expectedNums[i], "\nnums=\n\t" + Arrays.toString(nums) + "\nexpectedNums=\n\t" + Arrays.toString(expectedNums));
		}
	}

	/**
	 * Generates an array of integers according to the following:<br>
	 * <code>size</code> = size of the array<br>
	 * <code>int[i]</code> = element at any given index<br>
	 * <ul>
	 *     <li><code>1 &le; size &le; 3 * 10<sup>4</sup></code></li>
	 *     <li><code>-100 &le; int[i] &le; 100</code></li>
	 *     <li>sorted ascending</li>
	 * </ul>
	 *
	 * @return
	 */
	private int[] generateRandomSortedArray()
	{
		// Problem statement constraint
		int maxSize = (int) (Math.random() * 3 * Math.pow(10, 4)) + 1;
		int[] ints = generateRandomArray(maxSize);

		Arrays.sort(generateRandomArray(maxSize));
		return ints;
	}
}