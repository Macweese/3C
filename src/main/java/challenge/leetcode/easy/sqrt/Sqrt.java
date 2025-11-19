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
package challenge.leetcode.easy.sqrt;

/**
 * @author Administrator
 * @Created 21/04/2019,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 69
 * @Difficulty Easy
 * @Tags math
 * binary search
 * @link <a href="https://leetcode.com/problems/sqrtx/">www.leetcode.com/69</a>
 * @Description Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.<br>
 *
 * <br>You must not use any built-in exponent function or operator.<br>
 *
 * <br>For example, do not use {@code pow(x, 0.5)} in c++ or {@code x ** 0.5} in python.
 * <ul>
 * 		<li>Example 1:
 * 			<br>Input: {@code x = 4}
 * 			<br>Output: {@code 2}
 * 			<br>Explanation: The square root of {@code 4} is {@code 2}, so we return {@code 2}.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li>Example 2:
 * 			<br>Input: {@code x = 8}
 * 			<br>Output: {@code 2}
 * 			<br>Explanation: The square root of {@code 8} is {@code 2.82842...}, and since we round it down to the nearest integer, {@code 2} is returned.
 * 		</li>
 * </ul>
 * <p>
 * Constraints:
 * <br>{@code 0 <= x <= 2}<sup>31</sup>{@code - 1}
 * </p>
 **/
public class Sqrt
{
	public static int sqrt(int x)
	{
		if (Integer.signum(x) == -1)
		{
			throw new IllegalArgumentException("Number is negative: cannot square root a negative number.");
		}

		long root = x;

		while (root * root > x)
		{
			root = (root + x / root) / 2;
		}
		return (int) root;
	}

	public static int cheat(int x)
	{
		return (int) Math.pow(Math.E, 0.5 * Math.log(x));
	}

	// testing / trying to find algorithm
	// doesnt really work atm
	public static int test(int x)
	{
		int middle = -1;
		int lower = 1;
		int upper = x;

		while (lower < upper)
		{
			middle = (upper >> 1) + 1;

			int c = middle * middle;
			if (Integer.numberOfLeadingZeros(c) == 0 || c > x)
			{
				upper = middle;
			}
			else if (c == x)
			{
				return c;
			}
			else if (x / middle > middle)
			{
				upper = middle - 1;
			}
			else
			{
				upper = (lower + upper + 1) / 2;
				lower = middle;
			}
		}
		return middle;
	}

	private static String intToBinary(int i)
	{
		String bin = "0".repeat(Integer.numberOfLeadingZeros(i)) + Integer.toBinaryString(i);
		StringBuilder s = new StringBuilder();
		for (int j = 0; j < bin.length(); j++)
		{
			s.append(bin.charAt(j));
			if (j != 0 && (j + 1) % 4 == 0)
			{
				s.append(" ");
			}
		}
		return s.toString();
	}

	public static int findRoot(int i)
	{
		int n = i;
		int c = 0;
		int d = 1 << 30;

		while (d > i)
		{
			d >>= 2;
		}

		while (d != 0)
		{
			if (n >= c + d)
			{
				n -= c + d;
				c = (c >> 1) + d;
			}
			else
			{
				c >>= 1;
			}
			d >>= 2;
		}

		return c;
	}
}
