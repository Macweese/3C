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
package challenge.leetcode.easy.divisibleAndNonDivisibleSumsDifference;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Created 22/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2894
 * @Name Divisible And Non-divisible Sums Difference
 * @Difficulty Easy
 * @Tags math
 * @link <a href="https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/">www.leetcode.com/2894</a>
 * @Description You are given positive integers <code>n</code> and <code>m</code>.<br>
 * Define two integers as follows:
 *
 * <ul>
 *     <li><code>num1</code>: The sum of all integers in the range <code>[1, n]</code> (both <b>inclusive</b>) that are <b>not divisible</b> by <code>m</code>.</li>
 *     <li><code>num2</code>: The sum of all integers in the range <code>[1, n]</code> (both <b>inclusive</b>) that <b>are divisible</b> by <code>m</code>..</li>
 * </ul>
 * <p>
 * Return <i>the integer</i> <code>num1 - num2</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code n = 10, m = 3}
 * 			<br><b>Output:</b> {@code 19}
 * 			<br><b>Explanation:</b> In the given example:
 * 				<br>&emsp; - Integers in the range <code>[1, 10]</code> that are not divisible by <code>3</code> are <code>[1,2,4,5,7,8,10]</code>,
 * 					<br><code>num1</code> is the sum of those integers = <code>37</code>.
 * 				<br>&emsp; - Integers in the range <code>[1, 10]</code> that are divisible by <code>3</code> are <code>[3,6,9]</code>,
 * 					<br><code>num2</code> is the sum of those integers = <code>18</code>.
 * 				<br>&emsp; We return <code>37 - 18 = 19</code> as the answer.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 5, m = 6}
 * 			<br><b>Output:</b> {@code 15}
 * 			<br><b>Explanation:</b> In the given example:
 * 				<br>&emsp; - Integers in the range <code>[1, 5]</code> that are not divisible by <code>6</code> are <code>[1,2,3,4,5]</code>,
 * 					<br><code>num1</code> is the sum of those integers = <code>15</code>.
 * 				<br>&emsp; - Integers in the range <code>[1, 5]</code><br> that are divisible by <code>6</code> are <code>[]</code>,
 * 					<br><code>num2</code> is the sum of those integers = <code>0</code>.
 * 				<br>&emsp; We return <code>15 - 0 = 15</code> as the answer.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code n = 5, m = 1}
 * 			<br><b>Output:</b> {@code -15}
 * 			<br><b>Explanation:</b> In the given example:
 * 				<br>&emsp; - Integers in the range <code>[1, 5]</code> that are not divisible by <code>1</code> are <code>[]</code>,
 * 					<br><code>num1</code> is the sum of those integers = <code>0</code>.
 * 				<br>&emsp; - Integers in the range <code>[1, 5]</code> that are divisible by <code>1</code> are <code>[1,2,3,4,5]</code>,
 * 					<br><code>num2</code> is the sum of those integers = <code>15</code>.
 * 				<br>&emsp; We return <code>0 - 15 = -15</code> as the answer.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>1 &le; m, n &le; 1000</code></li>
 * </ul>
 * </p>
 **/
public class DivisibleAndNonDivisibleSumsDifference
{
	private static final Logger log = LoggerFactory.getLogger(DivisibleAndNonDivisibleSumsDifference.class);

	static
	{
		BasicConfigurator.configure();
	}

	public static void main(String[] args)
	{

	}

	public static int differenceOfSums(int n, int m)
	{
		int a = 0;
		int b = 0;

		for (int i = 1; i <= n; i++)
		{
			if (i % m == 0)
			{
				a += i;
			}
			else
			{
				b += i;
			}
		}

		return b - a;
	}
}
