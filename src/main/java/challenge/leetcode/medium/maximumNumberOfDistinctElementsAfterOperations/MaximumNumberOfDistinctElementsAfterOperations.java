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

package challenge.leetcode.medium.maximumNumberOfDistinctElementsAfterOperations;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 18/10/2025, 09:00 Sat 18 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 **/
public class MaximumNumberOfDistinctElementsAfterOperations
{
	static void main(String[] args)
	{
		int[] TEST_1 = {1,2,2,3,3,4};
		int[] TEST_2 = {4,4,4,4};
		int[] TEST_3 = {7,7,7,7,9};
		int[] TEST_4 = {1,1,1,1,1,1,1,1,5,5,5};
		int[] TEST_5 = {7,7,7,7,9};
		int[] TEST_6 = {8,8,10,9,9};
		int[] TEST_7 = {10,9,9,8};
		int[] TEST_8 = {898100252, 691476134, 981226697, 233748869, 551821106, 140353241, 87515586};
		int[] TEST_9 = {7,10,10};
		int[] TEST_10 = {1,1,1,2,2,2,4,4,4,4};
		printResult(TEST_1, 2, 6);
		printResult(TEST_2, 1, 3);
		printResult(TEST_3, 1, 4);
		printResult(TEST_4, 3, 10);
		printResult(TEST_5, 1, 4);
		printResult(TEST_6, 1, 5);
		printResult(TEST_7, 0, 3);
		printResult(TEST_8, 47249228, 7);
		printResult(TEST_9, 2, 3);
		printResult(TEST_10, 2, 8);
	}

	public static int maxDistinctElements(int[] ints, int k)
	{
		Arrays.sort(ints);
		int count = 0;
		int previous = Integer.MIN_VALUE;

		for (int i : ints)
		{
			int next = Math.max(i - k, previous + 1);
			if (next <= i + k)
			{
				previous = next;
				count++;
			}
		}

		return count;
	}

	public static void printResult(int[] ints, int k, int expected)
	{
		int result = maxDistinctElements(ints, k);
		System.out.printf("%-4s %-4s %5s%n", result, expected, result == expected ? "" : "FAIL");
	}
}
