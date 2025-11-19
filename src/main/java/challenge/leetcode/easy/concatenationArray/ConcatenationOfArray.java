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
package challenge.leetcode.easy.concatenationArray;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 21/03/2019,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1929
 * @Difficulty Easy
 * @Tags array
 * simulation
 * @link <a href="https://leetcode.com/problems/concatenation-of-array/">www.leetcode.com/1929</a>
 * @Description Given an integer array {@code nums} of length {@code n},
 * you want to create an array {@code ans} of length {@code 2n} where
 * {@code ans[i] == nums[i]} and {@code ans[i + n] == nums[i]} {@code for 0 <= i < n} <b>(0-indexed)</b>.<br>
 * <p>
 * Specifically, {@code ans} is the <b>concatenation</b> of two {@code nums} arrays.<br>
 * <p>
 * Return <i>the array</i> {@code ans}.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [1,2,1]}
 * 			<br><b>Output:</b> {@code [1,2,1,1,2,1]}
 * 			<br><b>Explanation:</b> The array ans is formed as follows:<br>
 * 			    – ans = {@code [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]}<br>
 * 			    – ans = {@code [1,2,1,1,2,1]}.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [1,3,2,1]}
 * 			<br><b>Output:</b> {@code [1,3,2,1,1,3,2,1]}
 * 			<br><b>Explanation:</b> The array ans is formed as follows:<br>
 * 			    – ans = {@code [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]}<br>
 * 			    – ans = {@code [1,3,2,1,1,3,2,1]}.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li>{@code n == nums.length}</li>
 *     <li>{@code 1 <= n <= 1000}</li>
 *     <li>{@code 1 <= nums[i] <= 1000}</li>
 * </ul>
 * </p>
 **/
public class ConcatenationOfArray
{
	/**
	 * Without use of built-in java features
	 *
	 * @param nums The original array
	 * @return Concatenated array of {@code nums + nums}
	 */
	public static int[] getConcatenation(int[] nums)
	{
		int[] arr = new int[nums.length * 2];
		for (int i = 0; i < nums.length; i++)
		{
			arr[i] = nums[i];
			arr[i + nums.length] = nums[i];
		}
		return arr;
	}

	/**
	 * With use of built-in java features
	 *
	 * @param nums The original array
	 * @return Concatenated array of {@code nums + nums}
	 */
	public static int[] getConcatenationSystemArrayCopy(int[] nums)
	{
		int[] arr = Arrays.copyOf(nums, nums.length * 2);
		System.arraycopy(nums, 0, arr, nums.length, nums.length);
		return arr;
	}
}
