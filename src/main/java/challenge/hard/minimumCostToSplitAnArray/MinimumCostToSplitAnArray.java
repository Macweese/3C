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
package challenge.hard.minimumCostToSplitAnArray;

/**
 * @author Administrator
 * @Created 18/08/2025, 06:31 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2547
 * @Name Minimum Cost to Split an Array
 * @Difficulty Hard
 * @Tags array
 * hash table
 * dp
 * dynamic programming
 * counting
 * weekly contest 329
 * @link <a href="https://leetcode.com/problems/minimum-cost-to-split-an-array/">www.leetcode.com/2547</a>
 * @Description You are given an integer array <code>nums</code> and an integer <code>k</code>.<br>
 * <br>
 * Split the array into some number of non-empty subarrays.
 * The cost of a split is the sum of the <code>importance value</code> of each subarray in the split.<br>
 * <br>
 * Let <code>trimmed(subarray)</code> be the version of the subarray
 * where all numbers which appear only once are removed.<br>
 * <ol>
 * 		<li>For example, <code>trimmed([3,1,2,4,3,4]) = [3,4,3,4]</code>.</li>
 * </ol>
 * The <b>importance value</b> of a subarray is <code>k + trimmed(subarray).length</code>.<br>
 * <ol>
 * 		<li>For example, if a subarray is <code>[1,2,3,3,3,4,4]</code>,
 * 			then <code>trimmed([1,2,3,3,3,4,4]) = [3,3,3,4,4]</code>.
 * 			The importance value of this subarray will be <code>k + 5</code>.</li>
 * </ol>
 * <p>
 * Return <i>the minimum possible cost of a split of</i> <code>nums</code>.<br>
 * <br>
 * A <b>subarray</b> is a contiguous <b>non-empty</b> sequence of elements within an array.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,1,2,1,3,3], k = 2</code>
 * 			<br><b>Output:</b> {@code 8}
 * 			<br><b>Explanation:</b> We split nums to have two subarrays: [1,2], [1,2,1,3,3].
 * 				<br>&emsp; The importance value of [1,2] is 2 + (0) = 2.
 * 				<br>&emsp; The importance value of [1,2,1,3,3] is 2 + (2 + 2) = 6.
 * 				<br>&emsp; The cost of the split is 2 + 6 = 8. It can be shown that this is the minimum possible cost among all the possible splits.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,1,2,1], k = 2</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> We split nums to have two subarrays: [1,2], [1,2,1].
 * 				<br>&emsp; The importance value of [1,2] is 2 + (0) = 2.
 * 				<br>&emsp; The importance value of [1,2,1] is 2 + (2) = 4.
 * 				<br>&emsp; The cost of the split is 2 + 4 = 6. It can be shown that this is the minimum possible cost among all the possible splits.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,1,2,1], k = 5</code>
 * 			<br><b>Output:</b> {@code 10}
 * 			<br><b>Explanation:</b> We split nums to have one subarray: [1,2,1,2,1].
 * 				<br>&emsp; The importance value of [1,2,1,2,1] is 5 + (3 + 2) = 10.
 * 				<br>&emsp; The cost of the split is 10. It can be shown that this is the minimum possible cost among all the possible splits.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; nums.length &le; 1000</code></li>
 * 		<li><code>0 &le; nums[i] < nums.length</code></li>
 * 		<li><code>1 &le; k &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/coin-change/"/>322. Coin Change (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/split-array-largest-sum/"/>410. Split Array Largest Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/"/>3013. Divide an Array Into Subarrays With Minimum Cost II (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/"/>3117. Minimum Sum of Values by Dividing Array (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/"/>3500. Minimum Cost to Divide Array Into Subarrays (Leetcode)</a><br>
 * <br>
 * {@link challenge.medium.coinChange.CoinChange 322. Coin Change (local)}<br>
 * {@link challenge.hard.splitArrayLargestSum.SplitArrayLargestSum 410. Split Array Largest Sum (local)}<br>
 * {@link challenge.hard.divideAnArrayIntoSubarraysWithMinimumCostII.DivideAnArrayIntoSubarraysWithMinimumCostII 3013. Divide an Array Into Subarrays With Minimum Cost II (local)}<br>
 * {@link challenge.hard.minimumSumOfValuesByDividingArray.MinimumSumOfValuesByDividingArray 3117. Minimum Sum of Values by Dividing Array (local)}<br>
 * {@link challenge.hard.minimumCostToDivideAnArrayIntoSubarrays.MinimumCostToDivideAnArrayIntoSubarrays 3500. Minimum Cost to Divide Array Into Subarrays (local)}<br>
 **/
public class MinimumCostToSplitAnArray
{
}











