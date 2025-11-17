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
package challenge.leetcode.medium.findTwoNonOverlappingSubarraysEachWithTargetSum;

import challenge.leetcode.easy.findSubarraysWithEqualSum.FindSubarraysWithEqualSum;

/**
 * @author Administrator
 * @Created 18/08/2025, 07:50 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1477
 * @Name Find Two Non-overlapping Sub-arrays Each With Target Sum
 * @Difficulty Medium
 * @Tags array
 * hash table
 * binary search
 * dp
 * dynamic programming
 * sliding window
 * biweekly contest 28
 * @link <a href="https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/">www.leetcode.com/1477</a>
 * @Description You are given an array of integers <code>arr</code> and an integer <code>target</code>.<br>
 * <br>
 * You have to find <b>two non-overlapping sub-arrays</b> of <code>arr</code> each with a sum equal <code>target</code>.
 * There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is <b>minimum</b>.<br>
 * <br>
 * Return <i>the minimum sum of the lengths</i> of the two required sub-arrays,
 * or return <code>-1</code> if you cannot find such two sub-arrays.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>arr = [3,2,2,4,3], target = 3</code>
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b> Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>arr = [7,3,4,7], target = 7</code>
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b> Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]),
 * 				but we will choose the first and third sub-arrays as the sum of their lengths is 2.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>arr = [4,3,2,6,2,3,4], target = 6</code>
 * 			<br><b>Output:</b> {@code -1}
 * 			<br><b>Explanation:</b> We have only one sub-array of sum = 6.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; arr.length &le; 10<sup>5</sup></code></li>
 * 		<li><code>1 &le; arr[i] &le; 1000</code></li>
 * 		<li><code>1 &le; target &le; 10<sup>8</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/find-subarrays-with-equal-sum/"/>2395. Find Subarrays With Equal Sum (Leetcode)</a><br>
 * <br>
 * {@link FindSubarraysWithEqualSum 2395. Find Subarrays With Equal Sum (local)}<br>
 **/
public class FindTwoNonOverlappingSubarraysEachWithTargetSum
{
}
