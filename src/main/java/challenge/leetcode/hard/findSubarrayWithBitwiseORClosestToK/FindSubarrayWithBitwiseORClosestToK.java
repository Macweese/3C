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
package challenge.leetcode.hard.findSubarrayWithBitwiseORClosestToK;

import challenge.leetcode.hard.minimumSumOfValuesByDividingArray.MinimumSumOfValuesByDividingArray;

/**
 * @author Administrator
 * @Created 18/08/2025, 06:30 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3171
 * @Name Find Subarray With Bitwise OR Closest to K
 * @Difficulty Hard
 * @Tags array
 * binary search
 * bit manipulation
 * segment tree
 * weekly contest 400
 * @link <a href="https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k/">www.leetcode.com/3171</a>
 * @Description You are given an array <code>nums</code> and an integer <code>k</code>.
 * You need to find a subarray<sup>1</sup> of <code>nums</code> such that
 * the <b>absolute difference</b> between <code>k</code> and the bitwise <code>OR</code> of the subarray elements
 * is as <b>small</b> as possible.
 * In other words, select a subarray <code>nums[l..r]</code> such that
 * <code>|k - (nums[l] OR nums[l + 1] ... OR nums[r])|</code>
 * is minimum.<br>
 * <br>
 * Return the <b>minimum</b> possible value of the absolute difference.<br>
 * <br>
 * [1]. A <b>subarray</b> is a contiguous <b>non-empty</b> sequence of elements within an array.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,4,5], k = 3</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> The subarray nums[0..1] has OR value 3, which gives the minimum absolute difference |3 - 3| = 0.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,3,1,3], k = 2</code>
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b> The subarray nums[1..1] has OR value 3, which gives the minimum absolute difference |3 - 2| = 1.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [1], k = 10</code>
 * 			<br><b>Output:</b> {@code 9}
 * 			<br><b>Explanation:</b> There is a single subarray with OR value 1, which gives the minimum absolute difference |10 - 1| = 9.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; nums.length &le; 10<sup>5</sup></code></li>
 * 		<li><code>1 &le; nums[i] &le; 10<sup>9</sup></code></li>
 * 		<li><code>1 &le; k &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/"/>3117. Minimum Sum of Values by Dividing Array (Leetcode)</a><br>
 * <br>
 * {@link MinimumSumOfValuesByDividingArray 3117. Minimum Sum of Values by Dividing Array (local)}<br>
 **/
public class FindSubarrayWithBitwiseORClosestToK
{
}
