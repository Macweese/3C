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
package challenge.leetcode.medium.sortAnArray;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import utils.DataUtils;
import utils.IntArraySpec;
import utils.SortingMode;

@DisplayName("912. Sort an Array")
class SortAnArrayTest
{

	@Test
	@DisplayName("Test all sorting algorithms")
	void testAllSortingAlgorithms()
	{
		testMergeSorting(10);
		testSelectionSorting(10);
	}

	@DisplayName("Test Merge-sort")
	@RepeatedTest(
		value = 100
	)
	void testMergeSorting()
	{
		final int[] ints = DataUtils.generateArray(IntArraySpec.builder(1000)
			.randomSizeUpTo()
			.bounds(-1000, 1000)
			.sorting(SortingMode.SHUFFLED)
			.build());
		testMergeSort(ints);
	}

	void testMergeSorting(int times)
	{
		for (int i = 0; i < times; i++)
		{
			final int[] ints = DataUtils.generateArray(IntArraySpec.builder(1000)
				.randomSizeUpTo()
				.bounds(-1000, 1000)
				.sorting(SortingMode.SHUFFLED)
				.build());
			testMergeSort(ints);
		}
	}

	void testMergeSort(int[] ints)
	{
		int[] sorted = SortAnArray.mergeSort(ints, 0, ints.length);

		assertEquals(sorted.length, ints.length);
		assertArrayEquals(sorted, ints);
	}

	@DisplayName("Test Selection-sort")
	@RepeatedTest(
		value = 100
	)
	void testSelectionSorting()
	{
		final int[] ints = DataUtils.generateArray(IntArraySpec.builder(1000)
			.randomSizeUpTo()
			.bounds(-1000, 1000)
			.sorting(SortingMode.SHUFFLED)
			.build());
		testSelectionSort(ints);
	}

	void testSelectionSorting(int times)
	{
		for (int i = 0; i < times; i++)
		{
			final int[] ints = DataUtils.generateArray(IntArraySpec.builder(1000)
				.randomSizeUpTo()
				.bounds(-1000, 1000)
				.sorting(SortingMode.SHUFFLED)
				.build());
			testSelectionSort(ints);
		}
	}

	void testSelectionSort(int[] ints)
	{
		int[] sorted = SortAnArray.sort(ints);

		assertEquals(sorted.length, ints.length);
		assertArrayEquals(sorted, ints);
	}
}