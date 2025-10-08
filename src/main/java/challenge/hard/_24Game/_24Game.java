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
package challenge.hard._24Game;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:40 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 679
 * @Name 24 Game
 * @Difficulty Hard
 * @Tags array
 * math
 * backtracking
 * @link <a href="https://leetcode.com/problems/24-game/">www.leetcode.com/679</a>
 * @Description You are given an integer array <code>cards</code> of length <code>4</code>.
 * You have four cards, each containing a number in the range <code>[1, 9]</code>.
 * You should arrange the numbers on these cards in a mathematical expression using the operators <code>['+', '-', '*', '/']</code>
 * and the parentheses <code>'('</code> and <code>')'</code> to get the value 24.<br>
 * <br>
 * You are restricted with the following rules:<br>
 * <br>
 * <ul>
 *     <li>The division operator <code>'/'</code> represents real division, not integer division.<br>
 *     		&emsp; For example, <code>4 / (1 - 2 / 3) = 4 / (1 / 3) = 12</code>.
 *     </li>
 *     <li>Every operation done is between two numbers. In particular, we cannot use <code>'-'</code> as a unary operator.<br>
 *     		&emsp; For example, if <code>cards = [1, 1, 1, 1]</code>, the expression <code>"-1 - 1 - 1 - 1"</code> is <b>not allowed</b>.
 *     </li>
 *     <li>You cannot concatenate numbers together<br>
 *     		&emsp; For example, if <code>cards = [1, 2, 1, 2]</code>, the expression <code>"12 + 12"</code> is not valid.
 *     </li>
 * </ul>
 * <br>
 * Return <code>true</code> if you can get such expression that evaluates to <code>24</code>, and <code>false</code> otherwise.<br>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>cards = [4,1,8,7]</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> (8-4) * (7-1) = 24
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>cards = [1,2,1,2]</code>
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>cards.length == 4</li>
 * 		<li>1 &le; cards[i] &le; 9</li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/find-subarrays-with-equal-sum/"/>2395. Find Subarrays With Equal Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/split-with-minimum-sum/"/>2578. Split With Minimum Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/"/>416. Partition Equal Subset Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets/"/>698. Partition to K Equal Sum Subsets (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/"/>1981. Minimize the Difference Between Target and Chosen Elements (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/"/>2025. Maximum Number of Ways to Partition an Array (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/"/>2035. Partition Array Into Two Arrays to Minimize Sum Difference (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/number-of-great-partitions/"/>2518. Number of Great Partitions (Leetcode)</a><br>
 * <br>
 * {@link challenge.easy.findSubarraysWithEqualSum.FindSubarraysWithEqualSum 2395. Find Subarrays With Equal Sum (local)}<br>
 * {@link challenge.easy.splitWithMinimumSum.SplitWithMinimumSum 2578. Split With Minimum Sum (local)}<br>
 * {@link challenge.medium.partitionEqualSubsetSum.PartitionEqualSubsetSum 416. Partition Equal Subset Sum (local)}<br>
 * {@link challenge.medium.partitiontoKEqualSumSubsets.PartitiontoKEqualSumSubsets 698. Partition to K Equal Sum Subsets (local)}<br>
 * {@link challenge.medium.minimizetheDifferenceBetweenTargetandChosenElements.MinimizetheDifferenceBetweenTargetandChosenElements 1981. Minimize the Difference Between Target and Chosen Elements (local)}<br>
 * {@link challenge.hard.maximumNumberOfWaysToPartitionAnArray.MaximumNumberOfWaysToPartitionAnArray 2025. Maximum Number of Ways to Partition an Array (local)}<br>
 * {@link challenge.hard.partitionArrayIntoTwoArraystoMinimizeSumDifference.PartitionArrayIntoTwoArraystoMinimizeSumDifference 2035. Partition Array Into Two Arrays to Minimize Sum Difference (local)}<br>
 * {@link challenge.hard.numberofGreatPartitions.NumberofGreatPartitions 2518. Number of Great Partitions (local)}<br>
 **/
public class _24Game
{
	public static void main(String[] args)
	{

		int[] ints = new int[]{0, 0, 0, 0};
		judgePoint24(ints);
	}

	public static boolean judgePoint24(int[] ints)
	{
		float[] digits = new float[]{ints[0], ints[1], ints[2], ints[3]};


		return false;
	}

	public static boolean helper(double[] digits)
	{
		if (digits.length == 1 && Math.abs(digits[0] - 24) < 0.001)
		{
			return true;
		}

		double[] clone = digits.clone();
		for (int a = 0; a < clone.length; a++)
		{
			for (int b = 0; b < clone.length; b++)
			{
				if (a == b)
				{
					continue;
				}

				double min = Math.min(clone[a], clone[b]);
				double max = Math.max(clone[a], clone[b]);
				if (min < 1 && max > 24)
				{
					clone[b] = calculate(max, min);
					helper(Arrays.copyOfRange(clone, 1, clone.length - 1));
				}

			}
		}

		return helper(Arrays.copyOfRange(clone, 1, clone.length - 1));
	}

	public static double calculate(double x, double y)
	{
		double result = 0;

		return result;
	}
}

