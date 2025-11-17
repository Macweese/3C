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

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 23/03/2019,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 26
 * @Difficulty Easy
 * @Tags array,
 * two pointers
 * @link <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">www.leetcode.com/26</a>
 * @Description Given an integer array <code>nums</code> sorted in <b>non-decreasing order</b>, remove the duplicates
 * <a href="https://en.wikipedia.org/wiki/In-place_algorithm">in-place</a>
 * such that each unique element appears only <b>once</b>.<br>
 * The <b>relative order</b> of the elements should be kept the <b>same</b>.
 * Then return <i>the number of unique elements in</i> <code>nums</code>.<br>
 * <p>
 * Consider the number of unique elements of <code>nums</code> to be <code>k</code>,
 * to get accepted, you need to do the following things:
 * <ul>
 *     <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code>
 *         contain the unique elements in the order they were present in nums initially.<br>
 *         The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li>
 *     <li>Return <code>k</code>.</li>
 * </ul>
 *
 * <b>Custom Judge:</b><br>
 * The judge will test your solution with the following code:<br>
 * <hr>
 * <code>
 * int[] nums = [...]; // Input array<br>
 * int[] expectedNums = [...]; // The expected answer with correct length<br>
 * <br>
 * int k = removeDuplicates(nums); // Calls your implementation<br>
 * <br>
 * assert k == expectedNums.length;<br>
 * for (int i = 0; i < k; i++)<br>
 * {<br>
 *     assert nums[i] == expectedNums[i];<br>
 * }
 * </code>
 * <hr>
 * If all assertions pass, then your solution will be <b>accepted</b>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [1,1,2]}
 * 			<br><b>Output:</b> {@code 2, nums = [1,2,_]}
 * 			<br><b>Explanation:</b> Your function should return {@code k = 2}, with the first two elements of
 *            {@code nums} being {@code 1} and {@code 2} respectively.<br>
 * 			It does not matter what you leave beyond the returned {@code k} (hence they are underscores).
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [0,0,1,1,1,2,2,3,3,4]}
 * 			<br><b>Output:</b> {@code 5, nums = [0,1,2,3,4,_,_,_,_,_]}
 * 			<br><b>Explanation:</b> Your function should return {@code k = 5}, with the first five elements of
 *            {@code nums} being {@code 0}, {@code 1}, {@code 2}, {@code 3} and {@code 4} respectively.<br>
 * 			It does not matter what you leave beyond the returned {@code k} (hence they are underscores).
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li>{@code 1 <= nums.length <= 3 * 104}</li>
 *     <li>{@code -100 <= nums[i] <= 100}</li>
 *     <li>{@code nums} is sorted in <b>non-decreasing</b> order.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class RemoveDuplicatesFromSortedArray
{
	static final int[] ARRAY_0 = new int[]{7};
	static final int[] ARRAY_1 = new int[]{1, 1, 2};
	static final int[] ARRAY_2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
	static final int[] ARRAY_3 = new int[]{-10, 0, 1, 1, 1, 2, 2, 3, 3, 4, 19};
	static final int[] ARRAY_4 = new int[]{-10, 0, 1, 1, 29};

	public static void main(String[] args)
	{
		BasicConfigurator.configure();

//		log.info("unique elements k={},  expected={}, ARRAY_0={}", removeDuplicates(ARRAY_0), 1, ARRAY_0);
//		log.info("unique elements k={},  expected={}, ARRAY_1={}", removeDuplicates(ARRAY_1), 2, ARRAY_1);
//		log.info("unique elements k={}, expected={}, ARRAY_2={}", removeDuplicates(ARRAY_2), 5, ARRAY_2);
//		log.info("unique elements k={}, expected={}, ARRAY_3={}", removeDuplicates(ARRAY_3), 7, ARRAY_3);
//		log.info("unique elements k={}, expected={}, ARRAY_4={}", removeDuplicates(ARRAY_4), 4, ARRAY_4);
	}

	public static int removeDuplicates(int[] a)
	{
		int k = 1;

		for (int i = 1; i < a.length; i++)
		{
			if (a[i] != a[i - 1])
			{
				a[k] = a[i];
				k++;
			}
		}

		return k;
	}

	private static void swap(int[] a, int i, int j)
	{
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static int sort(int[] a)
	{
		int i = 0;
		while (i < a.length)
		{
			if (a[i] == i + 1 || a[i] <= 0 || a[i] > a.length)
			{
				i++;
			}
			else if (a[a[i] - 1] != a[i])
			{
				swap(a, i, a[i] - 1);
			}
			else
			{
				i++;
			}
		}
		return i;
	}
}
