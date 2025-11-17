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
package challenge.leetcode.hard.minimumSumOfValuesByDividingArray;

import challenge.leetcode.easy.splitWithMinimumSum.SplitWithMinimumSum;
import challenge.leetcode.hard.findSubarrayWithBitwiseORClosestToK.FindSubarrayWithBitwiseORClosestToK;
import challenge.leetcode.hard.minimumCostToSplitAnArray.MinimumCostToSplitAnArray;

/**
 * @author Administrator
 * @Created 18/08/2025, 06:08 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3117
 * @Name Minimum Sum of Values by Dividing Array
 * @Difficulty Hard
 * @Tags array
 * binary search
 * dp
 * dynamic programming
 * bit manipulation
 * segment tree
 * queue
 * weekly contest 393
 * @link <a href="https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/">www.leetcode.com/3117</a>
 * @Description You are given two arrays <code>nums</code> and <code>andValues</code> of length <code>n</code> and <code>m</code> respectively.<br>
 * <br>
 * The <b>value</b> of an array is equal to the <b>last</b> element of that array.<br>
 * <br>
 * You have to divide <code>nums</code> into <code>m</code> <b>disjoint contiguous</b> subarrays
 * such that for the <code>i<sup>th</sup></code> subarray <code>[l<sub>i</sub>, r<sub>i</sub>]</code>,
 * the bitwise <code>AND</code> of the subarray elements is equal to <code>andValues[i]</code>,
 * in other words,
 * <code>nums[l<sub>i</sub>] & nums[l<sub>i</sub> + 1] & ... & nums[r<sub>i</sub>] == andValues[i]</code>
 * for all <code>1 &le; i &le; m</code>,
 * where <code>&</code> represents the bitwise <code>AND</code> operator.<br>
 * <br>
 * Return the <i><b>minimum</b> possible sum of the values of the</i> <code>m</code> <i>subarrays</i> <code>nums</code> <i>is divided into</i>.
 * <i>If it is not possible to divide</i> <code>nums</code> <i>into</i> <code>m</code> <i>subarrays satisfying these conditions, return</i> <code>-1</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,4,3,3,2], andValues = [0,3,3,2]</code>
 * 			<br><b>Output:</b> {@code 12}
 * 			<br><b>Explanation:</b> The only possible way to divide <code>nums</code> is:
 * 				<br>&emsp; 1. <code>[1,4]</code> as <code>1 & 4 == 0</code>.
 * 				<br>&emsp; 2. <code>[3]</code> as the bitwise <code>AND</code> of a single element subarray is that element itself.
 * 				<br>&emsp; 3. <code>[3]</code> as the bitwise <code>AND</code> of a single element subarray is that element itself.
 * 				<br>&emsp; 4. <code>[2]</code> as the bitwise <code>AND</code> of a single element subarray is that element itself.
 * 				<br>&emsp; The sum of the values for these subarrays is <code>4 + 3 + 3 + 2 = 12</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [2,3,5,7,7,7,5], andValues = [0,7,5]</code>
 * 			<br><b>Output:</b> {@code 17}
 * 			<br><b>Explanation:</b> There are three ways to divide <code>nums</code>:
 * 				<br>&emsp; 1. <code>[[2,3,5],[7,7,7],[5]]</code> with the sum of the values <code>5 + 7 + 5 == 17</code>.
 * 				<br>&emsp; 2. <code>[[2,3,5,7],[7,7],[5]]</code> with the sum of the values <code>7 + 7 + 5 == 19</code>.
 * 				<br>&emsp; 3. <code>[[2,3,5,7,7],[7],[5]]</code> with the sum of the values <code>7 + 7 + 5 == 19</code>.
 * 				<br>&emsp; The minimum possible sum of the values is <code>17</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3,4], andValues = [2]</code>
 * 			<br><b>Output:</b> {@code -1}
 * 			<br><b>Explanation:</b> The bitwise <code>AND</code> of the entire array <code>nums</code> is <code>0</code>.
 * 				As there is no possible way to divide <code>nums</code> into a single subarray
 * 				to have the bitwise <code>AND</code> of elements <code>2</code>, return <code>-1</code>.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; n == nums.length &le; 10<sup>4</sup></code></li>
 * 		<li><code>1 &le; m == andValues.length &le; min(n, 10)</code></li>
 * 		<li><code>1 &le; nums[i] &lt; 10<sup>5</sup></code></li>
 * 		<li><code>0 &le; andValues[j] &lt; 10<sup>5</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/split-with-minimum-sum/"/>2578. Split With Minimum Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimum-cost-to-split-an-array/"/>2547. Minimum Cost to Split an Array (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k/"/>3171. Find Subarray With Bitwise OR Closest to K (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/find-x-value-of-array-ii/"/>3525. Find X Value of Array II (Leetcode)</a><br>
 * <br>
 * {@link SplitWithMinimumSum 2578. Split With Minimum Sum (local)}<br>
 * {@link MinimumCostToSplitAnArray 2547. Minimum Cost to Split an Array (local)}<br>
 * {@link FindSubarrayWithBitwiseORClosestToK 3171. Find Subarray With Bitwise OR Closest to K (local)}<br>
 * {@link challenge.hard.findXValueOfArrayII.FindXValueOfArrayII 3525. Find X Value of Array II (local)}<br>
 **/
public class MinimumSumOfValuesByDividingArray
{
}
