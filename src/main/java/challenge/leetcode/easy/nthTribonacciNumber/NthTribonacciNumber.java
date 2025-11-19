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
package challenge.leetcode.easy.nthTribonacciNumber;

/**
 * @author Administrator
 * @Created 06/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1137
 * @Name N-th Tribonacci Number
 * @Difficulty Easy
 * @Tags math,
 * dynamic programming,
 * memoization
 * @link <a href="https://leetcode.com/problems/n-th-tribonacci-number/">www.leetcode.com/1137</a>
 * @Description The Tribonacci sequence T<sub>n</sub> is defined as follows:<br>
 * T<sub>0</sub> = 0,
 * T<sub>1</sub> = 1,
 * T<sub>2</sub> = 1,
 * and
 * T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub>
 * for <code>n &ge; 0</code>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code n = 4}
 * 			<br><b>Output:</b> {@code 4}
 * 			<br><b>Explanation:</b>
 * 				<br>&#9;<code>T<sub>3</sub> = 0 + 1 + 1 = 2</code>
 * 				<br>&#9;<code>T<sub>4</sub> = 1 + 1 + 2 = 4</code>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 25}
 * 			<br><b>Output:</b> {@code 1389537}
 * 			<br><b>Explanation:</b>
 * 				<br>&#9;<code>T<sub>25</sub> = 223317 + 410744 + 755476 = 1389537</code>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; n &le; 37</code></li>
 *     <li>The answer is guaranteed to fit within a 32-bit integer, ie. <code>answer &le; 2<sup>31</sup>-1</code></li>
 * </ul>
 * </p>
 * <hr>
 * <br>
 * Alternative problem description:<br>
 * For the "Tribonacci"-sequence <code>T</code>,
 * where the n<sup>th</sup> number in the sequence <code>T<sub>n</sub></code>
 * is the sum of the 3 previous numbers in the sequence,
 * provide the number <code>T<sub>n</sub></code>, given <code>n</code>.<br>
 * <ul>
 * 		<li><b>Example:</b>
 * 			<br><b>Input:</b> {@code n = 9}
 * 			<br><b>Output:</b> {@code 149}
 * 			<br><b>Explanation:</b>
 * 				<br>&#9;<code>T<sub>n</sub> = <code>T<sub>n-3</sub> + <code>T<sub>n-2</sub> + <code>T<sub>n-1</sub></code>
 * 				<br>&#9;<code>T<sub>9</sub> = <code>T<sub>6</sub> + <code>T<sub>7</sub> + <code>T<sub>8</sub> = 149</code>
 * 		</li>
 * </ul>
 **/
public class NthTribonacciNumber
{
	public static int climbStairs(int n)
	{
		if (n < 2)
		{
			return n;
		}

		if (n > 37)
		{
			return -1;
		}

		int[] ints = new int[n + 1];
		ints[0] = 1;
		ints[1] = 1;
		ints[2] = 2;

		for (int i = 3; i < ints.length - 1; i++)
		{
			ints[i] = ints[i - 1] + ints[i - 2] + ints[i - 3];
		}

		return ints[n - 1];
	}
}
