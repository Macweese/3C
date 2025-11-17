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
package challenge.leetcode.easy.transformArrayByParity;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Administrator
 * @Created 24/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3467
 * @Name Transform Array by Parity
 * @Difficulty Easy
 * @Tags array
 * sort
 * sorting
 * count
 * counting
 * biweekly contest 151
 * @link <a href="https://leetcode.com/problems/transform-array-by-parity/">www.leetcode.com/3467</a>
 * @Description You are given an integer array <code>nums</code>.
 * Transform <code>nums</code> by performing the following operations in the <b>exact</b> order specified:<br>
 *
 * <ol>
 * 		<li>Replace each even number with 0.</li>
 * 		<li>Replace each odd numbers with 1.</li>
 * 		<li>Sort the modified array in <b>non-decreasing</b> order.</li>
 * </ol>
 *
 * <br>Return the resulting array after performing these operations.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [4,3,2,1]}
 * 			<br><b>Output:</b> {@code [0,0,1,1]}
 * 			<br><b>Explanation:</b>
 * 			<br>&emsp;Replace the even numbers (4 and 2) with 0 and the odd numbers (3 and 1) with 1. Now, <code>nums = [0, 1, 0, 1]</code>.
 * 			<br>&emsp;After sorting <code>nums</code> in non-descending order, <code>nums = [0, 0, 1, 1]</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [1,5,1,4,2]}
 * 			<br><b>Output:</b> {@code [0,0,1,1,1]}
 * 			<br><b>Explanation:</b>
 * 			<br>&emsp;Replace the even numbers (4 and 2) with 0 and the odd numbers (1, 5 and 1) with 1. Now, <code>nums = [1, 1, 1, 0, 0]</code>.
 * 			<br>&emsp;After sorting <code>nums</code> in non-descending order, <code>nums = [0, 0, 1, 1, 1]</code>.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; nums.length &le; 100</code></li>
 * 		<li><code> 1 &le; nums[i] &le; 1000</code></li>
 * </ul>
 * </p>
 **/
public class TransformArrayByParity
{
	public static void main(String[] args)
	{

//		System.out.println(Arrays.toString(transformArray(new int[]{4, 3, 2, 1})));
//		System.out.println(Arrays.toString(transformArray(new int[]{1, 5, 1, 4, 2})));
		int[] ints = generateRandomArray();
		transformArray(ints);
	}

	/**
	 * Transforms an array and sorts in-place.
	 * <table>
	 *     <thead>
	 *         <tr>
	 *             <th>Time Complexity</th>
	 *         </tr>
	 *     </thead>
	 *     <tr></tr>
	 *         <th>Worst case</th>
	 *         <td>O(n)</td>
	 *     <tr></tr>
	 *         <th>Best case</th>
	 *         <td>O(<sup>n</sup>&frasl;<sub>2</sub>) → O(n)</td>
	 *     <tr></tr>
	 *         <th>Average case</th>
	 *         <td>O(<sup>2n</sup>&frasl;<sub>3</sub>) → O(n)</td>
	 * </table>
	 *
	 * @param nums
	 * @return
	 */
	public static int[] transformArray(int[] nums)
	{
		int j = nums.length - 1;
		for (int i = 0; i < nums.length && i < j + 1; i++)
		{
			int t = nums[i] & 1;
			int k = nums[j] & 1;

			if (t == 1)
			{
				nums[i] = k;
				i = k == 0 ? i : i - 1;
				nums[j] = t;
				j--;
				continue;
			}

			nums[i] = t;
			nums[j] = k;
			j = k == 1 ? j - 1 : j;
		}

		return nums;
	}

	private static int[] generateRandomArray()
	{
		int[] ints = new int[ThreadLocalRandom.current().nextInt(100) + 1];

		for (int i = 0; i < ints.length; i++)
		{
			ints[i] = ThreadLocalRandom.current().nextInt(1000) + 1;
		}
		return ints;
	}
}