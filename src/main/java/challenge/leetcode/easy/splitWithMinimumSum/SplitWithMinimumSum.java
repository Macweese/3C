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
package challenge.leetcode.easy.splitWithMinimumSum;

import challenge.leetcode.easy.minimumCostToMoveChipsToTheSamePosition.MinimumCostToMoveChipsToTheSamePosition;
import challenge.leetcode.hard.minimumSumOfValuesByDividingArray.MinimumSumOfValuesByDividingArray;
import challenge.leetcode.hard.partitionArrayIntoTwoArraystoMinimizeSumDifference.PartitionArrayIntoTwoArraystoMinimizeSumDifference;
import challenge.leetcode.medium.partitionEqualSubsetSum.PartitionEqualSubsetSum;

/**
 * @author Administrator
 * @Created 18/08/2025, 06:52 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2578
 * @Name Split With Minimum Sum
 * @Difficulty Easy
 * @Tags math
 * greedy
 * sorting
 * biweekly contest 99
 * @link <a href="https://leetcode.com/problems/split-with-minimum-sum/">www.leetcode.com/2578</a>
 * @Description Given a positive integer <code>num</code>,
 * split it into two non-negative integers <code>num1</code> and <code>num2</code> such that:
 * <ul>
 * 		<li>The concatenation of <code>num1</code> and <code>num2</code> is a permutation of <code>num</code>.<br>
 * 			&emsp;In other words,
 * 				the sum of the <code>num</code>ber of occurrences of each digit in <code>num1</code> and <code>num2</code>
 * 				is equal to the number of occurrences of that digit in <code>num</code>.
 * 		</li>
 * 		<li><code>num1</code> and <code>num2</code> can contain leading zeros.</li>
 * </ul>
 * <p>
 * Return <i>the <b>minimum</b> possible sum of</i> <code>num1</code> <i>and</i> <code>num2</code>.<br>
 * <br>
 *
 * <b>Notes:</b><br>
 * <ul>
 * 		<li>It is guaranteed that <code>num</code> does not contain any leading zeros.</li>
 * 		<li>The order of occurrence of the digits in <code>num1</code> and <code>num2</code>
 * 			may differ from the order of occurrence of <code>num</code>.</li>
 * </ul>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>num = 4325</code>
 * 			<br><b>Output:</b> {@code 59}
 * 			<br><b>Explanation:</b> We can split 4325 so that <code>num1</code> is 24 and <code>num2</code> is 35,
 * 				giving a sum of 59. We can prove that 59 is indeed the minimal possible sum.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>num = 687</code>
 * 			<br><b>Output:</b> {@code 75}
 * 			<br><b>Explanation:</b> We can split 687 so that <code>num1</code> is 68 and <code>num2</code> is 7,
 * 				which would give an optimal sum of 75.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>10 &le; num &le; 10<sup>9</sup></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/"/>1217. Minimum Cost to Move Chips to The Same Position (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/"/>416. Partition Equal Subset Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/"/>2035. Partition Array Into Two Arrays to Minimize Sum Difference (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/"/>3117. Minimum Sum of Values by Dividing Array (Leetcode)</a><br>
 * <br>
 * {@link MinimumCostToMoveChipsToTheSamePosition 1217. Minimum Cost to Move Chips to The Same Position (local)}<br>
 * {@link PartitionEqualSubsetSum 416. Partition Equal Subset Sum (local)}<br>
 * {@link PartitionArrayIntoTwoArraystoMinimizeSumDifference 2035. Partition Array Into Two Arrays to Minimize Sum Difference (local)}<br>
 * {@link MinimumSumOfValuesByDividingArray 3117. Minimum Sum of Values by Dividing Array (local)}<br>
 **/
public class SplitWithMinimumSum
{
	public static void main(String[] args)
	{

	}

	public static int splitSum(int num)
	{

		return -1;
	}
}
