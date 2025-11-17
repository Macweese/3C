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
package challenge.leetcode.medium.partitiontoKEqualSumSubsets;

import challenge.leetcode.hard.maximumNumberOfWaysToPartitionAnArray.MaximumNumberOfWaysToPartitionAnArray;
import challenge.leetcode.medium.partitionEqualSubsetSum.PartitionEqualSubsetSum;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:54 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 698
 * @Name Partition to K Equal Sum Subsets
 * @Difficulty Medium
 * @Tags array
 * dp
 * dynamic programming
 * backtracking
 * bit manipulation
 * memoization
 * bitmask
 * @link <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets/">www.leetcode.com/698</a>
 * @Description Given an integer array <code>nums</code> and an integer <code>k</code>,
 * return <code>true</code> if it is possible to divide this array
 * into <code>k</code> non-empty subsets whose sums are all equal.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [4,3,2,3,5,2,1], k = 4</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * 				<br>&emsp;
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3,4], k = 3</code>
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; k &le; nums.length &le; 16</code></li>
 * 		<li><code>1 &le; nums[i] &le; 10<sup>4</sup></code></li>
 * 		<li>The frequency of each element is in the range <code>[1, 4]</code>.</li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/partition-equal-subset-sum/"/>416. Partition Equal Subset Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/fair-distribution-of-cookies/"/>2305. Fair Distribution of Cookies (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/maximum-rows-covered-by-columns/"/>2397. Maximum Rows Covered by Columns (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/"/>2025. Maximum Number of Ways to Partition an Array (Leetcode)</a><br>
 * <br>
 * {@link PartitionEqualSubsetSum 416. Partition Equal Subset Sum (local)}<br>
 * {@link challenge.medium.fairDistributionOfCookies.FairDistributionOfCookies 2305. Fair Distribution of Cookies (local)}<br>
 * {@link challenge.medium.maximumRowsCoveredByColumns.MaximumRowsCoveredByColumns 2397. Maximum Rows Covered by Columns (local)}<br>
 * {@link MaximumNumberOfWaysToPartitionAnArray 2025. Maximum Number of Ways to Partition an Array (local)}<br>
 **/
public class PartitiontoKEqualSumSubsets
{
}
