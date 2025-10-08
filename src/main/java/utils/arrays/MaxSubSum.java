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

/**
 * @author Administrator
 * @Created 19/11/2024
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2461
 * @Difficulty Medium
 * @Tags array
 * hash table
 * sliding window
 * @link <a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/">www.leetcode.com/2461</a>
 * @Description You are given an integer array nums and an integer k.<br>Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * <ul>
 *     <li>The length of the subarray is k</li>
 *     <li>All the elements of the subarray are distinct.</li>
 * </ul>
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * <br>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p><br>
 * <p>
 * <p>
 * Example 1:<br>
 * <p>
 * Input: nums = [1,5,4,2,9,9,9], k = 3<br>
 * Output: 15<br>
 * Explanation: The subarrays of nums with length 3 are:
 * <ul>
 *     <li>[1,5,4] which meets the requirements and has a sum of 10.</li>
 *     <li>[5,4,2] which meets the requirements and has a sum of 11.</li>
 *     <li>[4,2,9] which meets the requirements and has a sum of 15.</li>
 *     <li>[2,9,9] which does not meet the requirements because the element 9 is repeated.</li>
 *     <li>[9,9,9] which does not meet the requirements because the element 9 is repeated.</li>
 * </ul>
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions<br>
 * </p>
 * <p>
 * <br>
 * Example 2:<br>
 * <p>
 * Input: nums = [4,4,4], k = 3<br>
 * Output: 0<br>
 * Explanation: The subarrays of nums with length 3 are:
 * <ul>
 *     <li>[4,4,4] which does not meet the requirements because the element 4 is repeated.</li>
 * </ul>
 * We return 0 because no subarrays meet the conditions.
 * </p><p>
 * <p>
 * <p>
 * Constraints:<br>
 * <p>
 * {@code 1 <= k <= nums.length <= 10^5} <br>
 * {@code 1 <= nums[i] <= 10^5} <br>
 * </p>
 **/
public class MaxSubSum
{
	private static final int[] ARRAY_1 = {1, 5, 4, 2, 9, 9, 9};
	private static final int[] ARRAY_2 = {4, 4, 4};
	private static final int[] ARRAY_3 = {2, 7, 9, 9, 0, 1, 8, 9, 6, 4, 1, 9, 8, 7};
	private static final int[] ARRAY_4 = {8, 8, 8, 1, 1, 8};
	private static final int[] ARRAY_5 = {9};
	private static final int[] ARRAY_6 = {9, 9, 9, 1, 2, 3};


	public static void main(String[] args)
	{
		check();
	}

	public static void check()
	{
		System.out.println("Array 1:  " + Arrays.toString(maximumSubarraySum(ARRAY_1, 3)) + "\nExpected: [4, 2, 9]\nSum:      15\n");
		System.out.println("Array 2:  " + Arrays.toString(maximumSubarraySum(ARRAY_2, 3)) + "\nExpected: [0]\nSum:      0\n");
		System.out.println("Array 3:  " + Arrays.toString(maximumSubarraySum(ARRAY_3, 3)) + "\nExpected: [9, 8, 7]\nSum:      24\n");
		System.out.println("Array 4:  " + Arrays.toString(maximumSubarraySum(ARRAY_4, 2)) + "\nExpected: [8, 1]\nSum:      9\n");
		System.out.println("Array 5:  " + Arrays.toString(maximumSubarraySum(ARRAY_5, 2)) + "\nExpected: [0]\nSum:      0\n");
		System.out.println("Array 6:  " + Arrays.toString(maximumSubarraySum(ARRAY_6, 3)) + "\nExpected: [9, 1, 2]\nSum:      12\n");
	}

	public static int[] maximumSubarraySum(int[] nums, int k)
	{
		if (k < 1 || nums.length < k)
		{
			return new int[]{0};
		}

		int[] sub = new int[k];
		int index = 0;
		try
		{
			System.arraycopy(nums, 0, sub, 0, k);
			if (Arrays.stream(sub).distinct().toArray().length < k)
			{
				Arrays.fill(sub, 0);
			}
		}
		catch (IndexOutOfBoundsException ignored)
		{

		}

		for (int i = 0; i < nums.length; i++)
		{
			int[] temp = Arrays.copyOfRange(nums, i, i + k);

			if (Arrays.stream(temp).distinct().toArray().length < k || i + k > nums.length)
			{
				continue;
			}

			if (Arrays.stream(temp).sum() > Arrays.stream(sub).sum())
			{
				sub = temp;
				index = i;
			}
		}

		sub = Arrays.copyOfRange(nums, index, index + k);
		if (Arrays.stream(sub).distinct().toArray().length < k)
		{
			return new int[]{0};
		}
		return sub;
	}

//	public long maximumSubarraySum2(int[] nums, int k)
//	{
//		if (nums.length < k)
//		{
//			return 0;
//		}
//
//		int start = 0;
//		int sum = 0;
//
//		for (int i = 0; i < nums.length - (k + 1); i++)
//		{
//			int temp = 0;
//			for (int j = i; j < k; j++)
//			{
//				if ()
//				temp =+ nums[j];
//			}
//		}
//
//
//
//
//		return sum;
//	}
}
