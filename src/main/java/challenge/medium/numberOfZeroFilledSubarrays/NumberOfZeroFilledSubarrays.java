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
package challenge.medium.numberOfZeroFilledSubarrays;

/**
 * @author Administrator
 * @Created 19/08/2025, 05:54 Tue 19 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2348
 * @Name Number of Zero-Filled Subarrays
 * @Difficulty Medium
 * @Tags array
 * math
 * biweekly contest 83
 * @link <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">www.leetcode.com/2348</a>
 * @Description Given an integer array nums, return the number of subarrays filled with 0.<br>
 * <br>
 * A subarray is a contiguous non-empty sequence of elements within an array.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,3,0,0,2,0,0,4]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; There are 4 occurrences of [0] as a subarray.
 * 				<br>&emsp; There are 2 occurrences of [0,0] as a subarray.
 * 				<br>&emsp; There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [0,0,0,2,0,0]</code>
 * 			<br><b>Output:</b> {@code 9}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; There are 5 occurrences of [0] as a subarray.
 * 				<br>&emsp; There are 3 occurrences of [0,0] as a subarray.
 * 				<br>&emsp; There is 1 occurrence of [0,0,0] as a subarray.
 * 				<br>&emsp; There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [2,10,2019]</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; There is no subarray filled with 0. Therefore, we return 0.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; nums.length &le; 10<sup>5</sup></code></li>
 * 		<li><code>-10<sup>9</sup> &le; nums[i] &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/arithmetic-slices/"/>413. Arithmetic Slices (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/"/>2110. Number of Smooth Descent Periods of a Stock (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/"/>2414. Length of the Longest Alphabetical Continuous Substring (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/"/>2526. Find Consecutive Integers from a Data Stream (Leetcode)</a><br>
 * <br>
 * {@link challenge.medium.arithmeticSlices.ArithmeticSlices 413. Arithmetic Slices (local)}<br>
 * {@link challenge.medium.numberOfSmoothDescentPeriodsOfAStock.NumberOfSmoothDescentPeriodsOfAStock 2110. Number of Smooth Descent Periods of a Stock (local)}<br>
 * {@link challenge.medium.lengthOfTheLongestAlphabeticalContinuousSubstring.LengthOfTheLongestAlphabeticalContinuousSubstring 2414. Length of the Longest Alphabetical Continuous Substring (local)}<br>
 * {@link challenge.medium.findConsecutiveIntegersFromADataStream.FindConsecutiveIntegersFromADataStream 2526. Find Consecutive Integers from a Data Stream (local)}<br>
 **/
public class NumberOfZeroFilledSubarrays
{
	public static void main(String[] args)
	{
		int[] INTS_1 = new int[]{1, 3, 0, 0, 2, 0, 0, 4};
		int[] INTS_2 = new int[]{0, 0, 0, 2, 0, 0};
		int[] INTS_3 = new int[]{2, 10, 2019};


		int[] INTS_4 = new int[]{0, 0, 1, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 4};
		int[] INTS_5 = new int[]{5, 0, 0, 0, 0, 0, 6, 7, 0, 0, 0, 8, 0, 0};
		int[] INTS_6 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] INTS_7 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] INTS_8 = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
		int[] INTS_9 = new int[]{1, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 4, 0, 0, 5, 0};
		int[] INTS_10 = new int[]{9, 8, 0, 0, 7, 0, 0, 0, 6, 0, 5, 0, 0, 4, 0, 0, 3, 2, 1, 0};
		int[] INTS_11 = new int[]{0, 0, 1, 0, 0, 2, 0, 0, 0, 3, 0, 4, 0, 0, 5, 0, 0, 0, 0, 6};

		System.out.printf("%-14s %-10s %s %n", "ARRAY", "EXPECTED", "ACTUAL");
		System.out.printf("%-14s %-10s %-2s%n", "INTS_1", 6, zeroFilledSubarray(INTS_1));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_2", 9, zeroFilledSubarray(INTS_2));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_3", 0, zeroFilledSubarray(INTS_3));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_4", 22, zeroFilledSubarray(INTS_4));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_5", 24, zeroFilledSubarray(INTS_5));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_6", 55, zeroFilledSubarray(INTS_6));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_7", 0, zeroFilledSubarray(INTS_7));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_8", 7, zeroFilledSubarray(INTS_8));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_9", 23, zeroFilledSubarray(INTS_9));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_10", 17, zeroFilledSubarray(INTS_10));
		System.out.printf("%-14s %-10s %-2s%n", "INTS_11", 26, zeroFilledSubarray(INTS_11));
	}

	public static long zeroFilledSubarray(int[] ints)
	{
		int n = 0;
		int c = 0;
		for (int i = 0; i < ints.length; i++)
		{
			n = ints[i] == 0 ? n + 1 : n;
			if (i == ints.length - 1 || ints[i] != 0 && n > 0)
			{
				c += (n * (n + 1)) / 2;
				n = 0;
			}
		}

		return c;
	}
}
