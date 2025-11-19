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
package challenge.leetcode.easy.searchInsertPosition;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @Created 04/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 35
 * @Name Search Insert Position
 * @Difficulty Easy
 * @Tags array
 * binary search
 * @link <a href="https://leetcode.com/problems/search-insert-position/">www.leetcode.com/35</a>
 * @Description Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.<br>
 *
 * <br>You must write an algorithm with <code>O(log n)</code> runtime complexity.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [1,3,5,6], target = 5}
 * 			<br><b>Output:</b> {@code 2}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [1,3,5,6], target = 2}
 * 			<br><b>Output:</b> {@code 1}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code nums = [1,3,5,6], target = 7}
 * 			<br><b>Output:</b> {@code 4}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= nums.length <= 10^4}</li>
 *     <li>{@code -10^4 <= nums[i] <= 10^4}</li>
 *     <li>{@code -10^4 <= target <= 10^4}</li>
 *     <li>{@code nums} contains <b>distinct</b> values sorted in <b>ascending</b> order.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class SearchInsertPosition
{
	public static int binarySearch(int[] arr, int value)
	{
		int lower = 0;
		int upper = arr.length - 1;
		int mid = 0;

		if (value <= arr[lower])
		{
			return lower;
		}
		else if (value > arr[upper])
		{
			return upper + 1;
		}

		while (lower != upper)
		{
			mid = lower + (upper - lower) / 2;

			if (arr[mid] == value)
			{
				return mid;
			}

			if (arr[mid] < value)
			{
				lower = mid + 1;
			}
			else
			{
				upper = mid;
			}
		}
		return arr[mid] < value ? mid + 1 : mid;
	}
}
