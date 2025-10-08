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
package challenge.medium.sortAnArray;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 25/03/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 912
 * @Difficulty Medium
 * @Tags Array,
 * Divide and Conquer,
 * dc,
 * dnc,
 * d&c,
 * d&q,
 * d n c,
 * d n q,
 * d & c,
 * d & q,
 * Sorting,
 * Heap (Priority Queue),
 * priority queue,
 * Merge Sort,
 * Bucket Sort,
 * Radix Sort,
 * Counting Sort
 * @link <a href="https://leetcode.com/problems/sort-an-array/">www.leetcode.com/912</a>
 * @Description Given an array of integers <code>nums</code>, sort the array in ascending order and return it.<br>
 * You must solve the problem <b>without using any built-in functions</b>
 * in <code>O(nlog(n))</code> time complexity and with the smallest space complexity possible.<br>
 * <br>
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [5,2,3,1]}
 * 			<br><b>Output:</b> {@code [1,2,3,5]}
 * 			<br><b>Explanation:</b> After sorting the array, the positions of some numbers are not changed
 * 			(for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [5,1,1,2,0,0]}
 * 			<br><b>Output:</b> {@code [0,0,1,1,2,5]}
 * 			<br><b>Explanation:</b> Note that the values of nums are not necessairly unique.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li>{@code 1 <= nums.length <= 5 * 10^4}</li>
 *     <li>{@code -5 * 10^4 <= nums[i] <= 5 * 10^4}</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class SortAnArray
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

		int[] ints = new int[]{5, 1, 1, 2, 0, 0, -1, 7, 3};

//		log.info("{}", mergeSort(ints, 0, ints.length));
	}

	// Selection sort
	// Time limit exceeded
	public static int[] sort(int[] ints)
	{
		if (ints.length < 2)
		{
			return ints;
		}

		for (int i = 1; i < ints.length; i++)
		{
			for (int j = i; j >= 1; j--)
			{
				if (ints[j] >= ints[j - 1])
				{
					break;
				}

				ints[j - 1] = ints[j - 1] ^ ints[j];
				ints[j] = ints[j - 1] ^ ints[j];
				ints[j - 1] = ints[j - 1] ^ ints[j];
			}
		}
		return ints;
	}

	public static int[] mergeSort(int[] ints, int a, int b)
	{
		if (a == b)
		{
			return ints;
		}

		int mid = (a + b) / 2;

		mergeSort(ints, a, mid);
		mergeSort(ints, mid + 1, b);

		return merge(ints, mid);
	}

	public static int[] merge(int[] ints, int n)
	{
		int[] a = Arrays.copyOfRange(ints, 0, n);
		int[] b = Arrays.copyOfRange(ints, n, ints.length);

		int i = 0;
		int j = 0;
		int k = 0;

		while (j < a.length && k < b.length)
		{
			if (a[j] < b[k])
			{
				ints[i] = a[j];
				j++;
			}
			else
			{
				ints[i] = b[k];
				k++;
			}
			i++;
		}

		while (j < a.length)
		{
			ints[i] = a[j];
			j++;
			i++;
		}
		while (k < b.length)
		{
			ints[i] = b[k];
			k++;
			i++;
		}

		return ints;
	}

	static int[] generateRandomArray()
	{
		return generateRandomArray(50_000, -50_000, 50_000);
	}

	static int[] generateRandomArray(int size, int min, int max)
	{
		int[] ints = new int[ThreadLocalRandom.current().nextInt(1, size + 1)];

		for (int i = 0; i < ints.length; i++)
		{
			ints[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		return ints;
	}
}
