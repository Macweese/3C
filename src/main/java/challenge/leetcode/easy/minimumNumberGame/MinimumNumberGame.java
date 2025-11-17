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
package challenge.leetcode.easy.minimumNumberGame;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2974
 * @Name Minimum Number Game
 * @Difficulty Easy
 * @Tags array
 * sorting
 * heap
 * priority queue
 * simulation
 * weekly contest 377
 * @link <a href="https://leetcode.com/problems/minimum-number-game/">www.leetcode.com/2974</a>
 * @Description You are given a <b>0-indexed</b> integer array <code>nums</code> of <b>even</b> length and there is also an empty array <code>arr</code>.
 * Alice and Bob decided to play a game where in every round Alice and Bob will do one move.
 * The rules of the game are as follows:
 *
 * <ul>
 * 		<li>Every round, first Alice will remove the <b>minimum</b> element from <code>nums</code>, and then Bob does the same.</li>
 * 		<li>Now, first Bob will append the removed element in the array <code>arr</code>, and then Alice does the same.</li>
 * 		<li>The game continues until <code>nums</code> becomes empty.</li>
 * </ul>
 * <p>
 * Return <i>the resulting array</i> <code>arr</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [5,4,2,3]}
 * 			<br><b>Output:</b> {@code [3,2,5,4]}
 * 			<br><b>Explanation:</b> In round one, first Alice removes 2 and then Bob removes 3.
 * 			Then in arr firstly Bob appends 3 and then Alice appends 2. So <code>arr = [3,2]</code>.
 * 			<br>&emsp; At the begining of round two, <code>nums = [5,4]</code>.
 * 			Now, first Alice removes 4 and then Bob removes 5.
 * 			Then both append in arr which becomes <code>[3,2,5,4]</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [2,5]}
 * 			<br><b>Output:</b> {@code [5,2]}
 * 			<br><b>Explanation:</b> In round one, first Alice removes 2 and then Bob removes 5.
 * 			Then in arr firstly Bob appends and then Alice appends. So <code>arr = [5,2]</code>.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 2 &le; nums.length &le; 100</code></li>
 * 		<li><code> 1 &le; nums[i] &le; 100</code></li>
 * 		<li><code> nums.length % 2 = 0</code></li>
 * </ul>
 * </p>
 **/
public class MinimumNumberGame
{
	public static void main(String[] args)
	{
		int[] INTS = new int[]{5, 4, 2, 3};
		System.out.println(Arrays.toString(INTS));
		System.out.println(Arrays.toString(numberGame(INTS)));
	}

	public static int[] numberGame(int[] nums)
	{
		System.out.println();
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for (int i = 1; i < nums.length; i = i + 2)
		{
			int t = nums[i - 1];
			nums[i - 1] = nums[i];
			nums[i] = t;
			System.out.println(Arrays.toString(nums));
		}

		return nums;
	}
}
