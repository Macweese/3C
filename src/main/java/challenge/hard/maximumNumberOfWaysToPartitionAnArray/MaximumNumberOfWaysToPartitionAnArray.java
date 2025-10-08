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
package challenge.hard.maximumNumberOfWaysToPartitionAnArray;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:55 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2025
 * @Name Maximum Number of Ways to Partition an Array
 * @Difficulty Hard
 * @Tags array
 * hash table
 * counting
 * enumeration
 * prefix sum
 * biweekly contest 62
 * @link <a href="https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/">www.leetcode.com/2025</a>
 * @Description You are given a <b>0-indexed</b> integer array <code>nums</code> of length <code>n</code>.
 * The number of ways to <b>partition</b> <code>nums</code> is the number of <code>pivot</code> indices that satisfy both conditions:
 * <ol>
 *     <li><code>1 &le; pivot < n</code></li>
 *     <li><code>nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]</code></li>
 * </ol>
 * <br>
 * You are also given an integer <code>k</code>.
 * You can choose to change the value of <b>one</b> element of <code>nums</code> to <code>k</code>,
 * or to leave the array <b>unchanged</b>.<br>
 * <br>
 * Return <i>the <b>maximum</b> possible number of ways to <b>partition</b></i> <code>nums</code>
 * <i>to satisfy both conditions after changing <b>at most</b> one element.</i><br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [2,-1,2], k = 3</code>
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b> One optimal approach is to change <code>nums[0]</code> to <code>k</code>.
 * 				The array becomes <code>[3,-1,2]</code>.
 * 				<br>&emsp; There is one way to partition the array:
 * 				<br>&emsp; • For <code>pivot = 2</code>, we have the partition <code>[3,-1 | 2]: 3 + -1 == 2</code>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [0,0,0], k = 1</code>
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b> The optimal approach is to leave the array unchanged.
 * 				<br>&emsp; There are two ways to partition the array:
 * 				<br>&emsp; • For <code>pivot = 1</code>, we have the partition <code>[0 | 0,0]: 0 == 0 + 0</code>
 * 				<br>&emsp; • For <code>pivot = 2</code>, we have the partition <code>[0,0 | 0]: 0 + 0 == 0</code>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14], k = -33</code>
 * 			<br><b>Output:</b> {@code 4}
 * 			<br><b>Explanation:</b> One optimal approach is to change <code>nums[2]</code> to <code>k</code>.
 * 			The array becomes <code>[22,4,-33,-20,-15,15,-16,7,19,-10,0,-13,-14]</code>.
 * 				<br>&emsp; There are four ways to partition the array.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>n == nums.length</code></li>
 * 		<li><code>2 &le; n &le; 10<sup>5</sup>></code></li>
 * 		<li><code>-10<sup>5</sup>> &le; k, nums[i] &le; 10<sup>5</sup>></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/partition-equal-subset-sum/"/>416. Partition Equal Subset Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets/"/>698. Partition to K Equal Sum Subsets (Leetcode)</a><br>
 * <br>
 * {@link challenge.medium.partitionEqualSubsetSum.PartitionEqualSubsetSum 416. Partition Equal Subset Sum (local)}<br>
 * {@link challenge.medium.partitiontoKEqualSumSubsets.PartitiontoKEqualSumSubsets 698. Partition to K Equal Sum Subsets (local)}<br>
 **/
public class MaximumNumberOfWaysToPartitionAnArray
{
}
