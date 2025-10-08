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

package challenge.easy.findNUniqueIntegersSumUpToZero;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 19/11/2017
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1304
 * @Difficulty easy
 * @Tags array
 * hash table
 * weekly contest 169
 * @link <a href="https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/">www.leetcode.com/1304</a>
 * @Description Given an integer <code>n</code>, return <b>any</b> array containing <code>n</code> <b>unique</b> integers such that they add up to <code>0</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>n = 5</code>
 * 			<br><b>Output:</b> {@code [-7,-1,1,3,4]}
 * 			<br><b>Explanation:</b> These arrays also are accepted <code>[-5,-1,1,2,3]</code> , <code>[-3,-1,2,-2,4]</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>n = 3</code>
 * 			<br><b>Output:</b> {@code [-1,0,1]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>n = 1</code>
 * 			<br><b>Output:</b> {@code [0]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; n &le; 1000</code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class FindNUniqueIntegersSumUpToZero
{
	public static void main(String[] args)
	{

		sumZero(7);
		sumZero(5);
		sumZero(4);
		sumZero(3);
		sumZero(2);
		sumZero(1);
//		System.out.println(Arrays.toString(sumZero(4)));
	}

	public static int[] sumZero(int n)
	{
		int[] ints = new int[n];

		int val = n / 2;
		for (int i = 0; i < (n / 2); i++)
		{
			ints[i] = -val;
			ints[(n - 1) - i] = val;
			val--;
		}
		System.out.println(Arrays.toString(ints));

		return ints;
	}
}
