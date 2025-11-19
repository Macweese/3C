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
package challenge.leetcode.medium.bitwiseOROfSubarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @Created 31/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 898
 * @Name Bitwise OR of Subarrays
 * @Difficulty Medium
 * @Tags array
 * dp
 * dynamic programming
 * bit manipulation
 * weekly contest 100
 * @link <a href="https://leetcode.com/problems/bitwise-ors-of-subarrays/">www.leetcode.com/898</a>
 * @Description Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.<br>
 * <br>
 * The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.<br>
 * <br>
 * A subarray is a contiguous non-empty sequence of elements within an array.<br>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [0]</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> There is only one possible result: 0.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,1,2]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
 * 			<br>&emsp;These yield the results 1, 1, 2, 1, 3, 3.
 * 			<br>&emsp;There are 3 unique values, so the answer is 3.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,4]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> The possible results are 1, 2, 3, 4, 6, and 7.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; arr.length &le; 5 * 10<sup>4</sup></code></li>
 *     <li><code>0 &le; arr[i] &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 **/
public class BitwiseOROfSubarrays
{
	// dynamic programming?
	// ints = [1,4,6]   0001 0100 0110
	// []               0 0000
	// [1]              1 0001
	// [4]              4 0100
	// [6]              6 0110
	// [1,4]            5 0101
	// [1,6]            7 0111
	// [4,6]            6 0100 0110
	// [1,4,6]          7 0001 0100 0110
	// possible combinations: 0, 1, 4, 5, 6, 7
	//
	// if we know the max value in the array,
	// and we know the max bit-count of the array,
	// could we calculate the number of possible combinations?
	// e.g.
	// [1,10,15,30]     0001 1010 1111 00011110
	// wrong
	// what if we instead | all the elements
	// that would give us the max possible value
	// and the integer with the most amount of bits set
	// [1,10,15,30] ->  00011111 : does this tell us anything?
	// [1,10,15,30]     0001 1010 1111 00011110
	//
	// []               0000 0000 = 0
	// [1]              0000 0001 = 1
	// [10]             0000 1010 = 10
	// [15]             0000 1111 = 15
	// [30]             0001 1110 = 30
	// [1,10]           0000 1011 = 11
	// [1,15]           0000 1111 = 15
	// [1,30]           0001 1111 = 31
	// [10,15]          0000 1111 = 15
	// [10,30]          0001 1110 = 30
	// [15,30]          0001 1111 = 31
	// [1,10,15]        0000 1111 = 15
	// [1,10,30]        0001 1111 = 31
	// [1,15,30]        0001 1111 = 31
	// [10,15,30]       0001 1111 = 31
	// [1,10,15,30]     0001 1111 = 31
	//
	// 2^n combinations
	// result = [0,1,10,11,15,30,31] = 7 different bitwise-OR
	//
	//
	// [1]              1  00000001
	// [10]             10 00001010
	// [15]             15 00001111
	// [30]             30 00011110
	//
	// frequency of bit position being set (max is (2^n) - 1)
	// 2^4 - 1 = 16 - 1 = 15
	//     [0001 0000] [0000 1000] [0000 0100] [0000 0010] [0000 0001]
	//  [1]    0             0            0            0            8
	// [10]    0             8            0            8            0
	// [15]    0             4            8            4            4
	// [30]    8             2            4            2            0
	//
	//  ALL    8             14           12           14           12
	//
	// cant do it reliably / cant think of a mathematical solution
	// just calculate the different subsets and bitwise-OR the elements
	//
	// ints[] = [1,2,4,5,7,9]
	// Possible contiguous sub-arrays
	// |    [1]                                                           |
	// |    [1,2]          [2]                                            |
	// |    [1,2,4]        [2,4]        [4]                               |
	// |    [1,2,4,5]      [2,4,5]      [4,5]      [5]                    |
	// |    [1,2,4,5,7]    [2,4,5,7]    [4,5,7]    [5,7]    [7]           |
	// |    [1,2,4,5,7,9]  [2,4,5,7,9]  [4,5,7,9]  [5,7,9]  [7,9]  [9]    |
	//
	//
	public static int subarrayBitwiseORs(int[] ints)
	{
		Set<Integer> result = new HashSet<>();
		Set<Integer> currentResult = new HashSet<>();

		for (int i : ints)
		{
			Set<Integer> indexOR = new HashSet<>();
			indexOR.add(i);
			for (int j : currentResult)
			{
				indexOR.add(i | j);
			}
			currentResult = indexOR;
			result.addAll(currentResult);
		}

		return result.size();
	}
}
