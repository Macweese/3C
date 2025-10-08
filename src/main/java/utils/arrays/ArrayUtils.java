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

package utils.arrays;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;

public class ArrayUtils
{
	public static boolean isSubset(int[] a, int[] b)
	{
		return IsSubset.subset(a, b);
	}

	/**
	 * Helper method
	 * <br>
	 * Swaps the element in index {@code i} with {@code j} in the array {@code a}.
	 *
	 * @param a The array to operate on
	 * @param i The index of the first element
	 * @param j The index of the second element
	 */
	private static void swap(int[] a, int i, int j)
	{
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * Sorts an array using insert sort algorithm
	 *
	 * @param a The array to sort
	 */
	public static void sort(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length; j++)
			{
				if (a[i] <= a[j])
				{
					swap(a, i, j);
				}
			}
		}
	}

	/**
	 * Removes duplicate elements from an array
	 * and returns the resulting array,
	 * containing only unique elements.
	 *
	 * @param a The array to remove duplicates from
	 * @return Array of {@code int[]} containing
	 * only unique elements
	 */
	public static int[] removeDuplicates(int[] a)
	{
		return Arrays.stream(a).distinct().toArray();
	}

	/**
	 * Finds the smallest missing positive integer within an array
	 * or the next following integer if the sequence of integers
	 * has no discrepancy.<br>
	 * <p>
	 * Examples
	 * <ol types="A">
	 *     <li>
	 *          {@code int[] = [1,2,0]}<br>
	 *          Result: {@code 3}<br>
	 *          Explanation: The numbers in the range {@code [1,2]} are all in the array.
	 *     </li>
	 *     <li>
	 *          {@code int[] = [3,4,-1,1]}<br>
	 *          Result: {@code 2}<br>
	 *          Explanation: {@code 1} is in the array but {@code 2} is missing.
	 *     </li>
	 *     <li>
	 *          {@code int[] = [7,8,9,11,12]}<br>
	 *          Result: {@code 1}<br>
	 *          Explanation: The smallest positive integer {@code 1} is missing.
	 * <br>
	 *     </li>
	 * </ol>
	 *
	 * @param a The array to search
	 * @return The smallest missing positive value
	 * @implNote Does not consider zero to be a positive integer.
	 */
	public static int findFirstMissingPositive(int[] a)
	{
		AtomicInteger ai = new AtomicInteger(1);
		IntPredicate sequential = (i) -> i == ai.get();

		Arrays.stream(a).sorted()
			.distinct()
			.filter(i -> i > 0)
			.takeWhile(sequential)
			.forEach(i -> ai.set(ai.incrementAndGet()));
		return ai.get();
	}

	/**
	 * Flattens a nested 2-dimensional array into a single dimension.
	 * <br>
	 * <br>The nested array:<br>
	 * {@code [1][2][3]}<br>
	 * {@code [4][5][6]}<br>
	 * {@code [7][8][9]}<br>
	 * <br>
	 * Becomes:<br>
	 * {@code [1][2][3][4][5][6][7][8][9]}
	 *
	 * @param nestedArray The nested array to flatten.
	 * @return Single dimension array.
	 */
	public static int[] flatten(int[][] nestedArray)
	{
		int size = Arrays.stream(nestedArray).mapToInt(sub -> sub.length).sum();
		int[] array = new int[size];

		for (int[] i : nestedArray)
		{
			int index = 0;

			for (int j : i)
			{
				array[index] = j;
				index++;
			}
		}
		return array;
	}
}
