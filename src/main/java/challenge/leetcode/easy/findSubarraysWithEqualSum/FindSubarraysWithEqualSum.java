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
package challenge.leetcode.easy.findSubarraysWithEqualSum;

import challenge.leetcode.easy.twoSum.TwoSum;
import challenge.leetcode.medium.findTwoNonOverlappingSubarraysEachWithTargetSum.FindTwoNonOverlappingSubarraysEachWithTargetSum;
import challenge.leetcode.medium.partitionEqualSubsetSum.PartitionEqualSubsetSum;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:01 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2395
 * @Name Find Subarrays With Equal Sum
 * @Difficulty Easy
 * @Tags array
 * hash table
 * biweekly contest 86
 * @link <a href="https://leetcode.com/problems/find-subarrays-with-equal-sum/">www.leetcode.com/2395</a>
 * @Description Given a <b>0-indexed</b> integer array <code>nums</code>,
 * determine whether there exist two subarrays of length <code>2</code> with <b>equal</b> sum.
 * Note that the two subarrays must begin at <b>different</b> indices.<br>
 * <br>
 * Return <code>true</code> <i>if these subarrays exist, and</i> <code>false</code> <i>otherwise</i>.<br>
 * <br>
 * A <b>subarray</b> is a contiguous non-empty sequence of elements within an array.<br>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [4,2,4]</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> The subarrays with elements [4,2] and [2,4] have the same sum of 6.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3,4,5]</code>
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> No two subarrays of size 2 have the same sum.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [0,0,0]</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> The subarrays [nums[0],nums[1]] and [nums[1],nums[2]] have the same sum of 0.
 * 				<br>&emsp; Note that even though the subarrays have the same content,
 * 					the two subarrays are considered different because they are in different positions in the original array.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>2 &le; nums.length &le; 1000</li>
 * 		<li>-10<sup>9</sup> &le; nums[i] &le; 10<sup>9</sup></li>
 * </ul>
 * </p>
 * <br>
 * @Similar <a href="https://leetcode.com/problems/two-sum/"/>1. Two Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/"/>416. Partition Equal Subset Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/"/>1477. Find Two Non-Overlapping Sub-arrays Each With Target Sum (Leetcode)</a><br>
 * {@link TwoSum 1. Two Sum (local)}<br>
 * {@link PartitionEqualSubsetSum 416. Partition Equal Subset Sum (local)}<br>
 * {@link FindTwoNonOverlappingSubarraysEachWithTargetSum 1477. Find Two Non-Overlapping Sub-arrays Each With Target Sum (local)}<br>
 **/
public class FindSubarraysWithEqualSum
{
}
