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
package challenge.hard.numberofGreatPartitions;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:57 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2518
 * @Name Number of Great Partitions
 * @Difficulty Hard
 * @Tags array
 * dp
 * dynamic programming
 * weekly contest 325
 * @link <a href="https://leetcode.com/problems/number-of-great-partitions/">www.leetcode.com/2518</a>
 * @Description You are given an array nums consisting of positive integers and an integer k.<br>
 * <br>
 * Partition the array into two ordered groups such that each element is in exactly one group. A partition is called great if the sum of elements of each group is greater than or equal to k.<br>
 * <br>
 * Return the number of distinct great partitions. Since the answer may be too large, return it modulo 109 + 7.<br>
 * <br>
 * Two partitions are considered distinct if some element nums[i] is in different groups in the two partitions.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3,4], k = 4</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> The great partitions are:
 * 				<br>&emsp; <code>([1,2,3], [4])</code>
 * 				<br>&emsp; <code>([1,3], [2,4])</code>
 * 				<br>&emsp; <code>([1,4], [2,3])</code>
 * 				<br>&emsp; <code>([2,3], [1,4])</code>
 * 				<br>&emsp; <code>([2,4], [1,3])</code>
 * 				<br>&emsp; <code>([4], [1,2,3])</code>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [3,3,3], k = 4</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> There are no great partitions for this array.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [6,6], k = 2</code>
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b> We can either put <code>nums[0]</code> in the first partition or in the second partition.
 * 				<br>&emsp; The great partitions will be:
 * 				<br>&emsp;  <code>([6], [6])</code> and <code>([6], [6])</code>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; nums.length, k &le; 1000</code></li>
 * 		<li><code>1 &le; nums[i] &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/partition-equal-subset-sum/"/>416. Partition Equal Subset Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/find-the-punishment-number-of-an-integer/"/>2698. Find the Punishment Number of an Integer (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/"/>3578. Count Partitions With Max-Min Difference at Most K (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/palindrome-partitioning-ii/"/>132. Palindrome Partitioning II (Leetcode)</a><br>
 * <br>
 * {@link challenge.medium.partitionEqualSubsetSum.PartitionEqualSubsetSum 416. Partition Equal Subset Sum (local)}<br>
 * {@link challenge.medium.findThePunishmentNumberOfAnInteger.FindThePunishmentNumberOfAnInteger 2698. Find the Punishment Number of an Integer (local)}<br>
 * {@link challenge.medium.countPartitionsWithMaxMinDifferenceAtMostK.CountPartitionsWithMaxMinDifferenceAtMostK 3578. Count Partitions With Max-Min Difference at Most K (local)}<br>
 * {@link challenge.hard.palindromePartitioningII.PalindromePartitioningII 132. Palindrome Partitioning II (local)}<br>
 **/
public class NumberofGreatPartitions
{
}
