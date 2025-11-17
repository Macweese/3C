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

package challenge.leetcode.easy.convertIntegerToTheSumOfTwoNonZeroIntegers;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 08/09/2025, 07:16 Mon 08 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1317
 * @Name Convert Integer to the Sum of Two Non-Zero Integers
 * @Difficulty easy
 * @Tags math
 * weekly contest 171
 * @link <a href="https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/">www.leetcode.com/1317</a>
 * @Description <b>No-Zero integer</b> is a positive integer that <b>does not contain any</b> <code>0</code> in its decimal representation.<br>
 * <br>
 * Given an integer <code>n</code>, return <i>a list of two integers</i> <code>[a, b]</code> <i>where</i>:
 * <ul>
 * 		<li><code>a</code> and <b>b</b> are <b>No-Zero integers</b>.</li>
 * 		<li><code>a + b = n</code></li>
 * </ul>
 * <p>
 * The test cases are generated so that there is at least one valid solution.
 * If there are many valid solutions, you can return any of them.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>n = 2</code>
 * 			<br><b>Output:</b> {@code [1,1]}
 * 			<br><b>Explanation:</b> Let a = 1 and b = 1.
 * 				<br>&emsp;Both a and b are no-zero integers, and a + b = 2 = n.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>n = 11</code>
 * 			<br><b>Output:</b> {@code [2,9]}
 * 			<br><b>Explanation:</b> Let a = 2 and b = 9.
 * 				<br>&emsp;Both a and b are no-zero integers, and a + b = 11 = n.
 * 				<br>&emsp;Note that there are other valid answers as [8, 3] that can be accepted.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>2 &le; n &le; 10<sup>4</sup></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class ConvertIntegerToTheSumOfTwoNonZeroIntegers
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString($(200110192)));
	}

	public static int[] getNoZeroIntegers(int n)
	{
		int[] digits = getDigits(n);

		int[] power = new int[digits.length];
		power[0] = 1;
		for (int i = 1; i < power.length; i++)
		{
			power[i] = power[i - 1] * 10;
		}

		int a = digits[0] == 1 ? 2 : 1;

		boolean carry = digits[0] - a < 0;
		digits[0] = carry ? 9 : digits[0] - a;

		for (int i = 1; i < digits.length - 1; i++)
		{
			digits[i] = carry ? digits[i] - 1 : digits[i];
			carry = digits[i] < 0;

			if (digits[i] == 0)
			{
				a += power[i];
				carry = digits[i] - power[i] < 0;
			}
		}

		int[] digitsA = getDigits(a);
		int b = n - a;

		for (int i = 0; i < digitsA.length; i++)
		{
			if (digitsA[i] == 0)
			{
				int[] digitsB = getDigits(b - power[i]);

				a += ((i < digitsB.length && digitsB[i] == 0) ? 2 : 1) * power[i];
				b = n - a;
				digitsA = getDigits(a);
			}
		}

		return new int[]{a, b};
	}

	public static int[] getDigits(int n)
	{
		int[] digits = new int[(int) (Math.log10(n) + 1)];

		for (int i = 0; n > 0; n /= 10, i++)
		{
			digits[i] = n % 10;
		}
		return digits;
	}

	// ----------------------------------------------- //
	//               GOLFED SOLUTIONS

	// SEMI-GOLF
	public static int[] addends(int n)
	{
		int[] d = digits(n), p = new int[d.length];
		p[0] = 1;
		for (int i = 0; i < p.length - 1; p[++i] = p[i - 1] * 10)
		{
		}

		int a = d[0] == 1 ? 2 : 1;
		boolean c = d[0] - a < 0;
		d[0] = c ? 9 : d[0] - a;
		for (int i = 1; i < d.length - 1; i++)
		{
			d[i] = c ? d[i] - 1 : d[i];
			c = d[i] < 0;
			if (d[i] != 0)
			{
				continue;
			}
			a += p[i];
			c = d[i] - p[i] < 0;
		}

		int[] A = digits(a);
		int b = n - a;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != 0)
			{
				continue;
			}
			int[] B = digits(b - p[i]);
			a += ((i < B.length & B[i] == 0) ? 2 : 1) * p[i];
			b = n - a;
			A = digits(a);
		}

		return new int[]{a, b};
	}

	public static int[] digits(int n)
	{
		int[] d = new int[(int) (Math.log10(n) + 1)];
		for (int i = 0; n > 0; d[i++] = n % 10, n /= 10)
		{
		}
		return d;
	}

	// MORE GOLFED
	static long[] $(long n)
	{
		long[] d = D(n), p = new long[d.length];
		p[0] = 1;
		for (int i = 0; i < p.length - 1; p[++i] = p[i - 1] * 10)
		{
		}
		System.out.printf("%24s%20s%20s%n", 0, n, n);
		long a = d[0] == 1 ? 2 : 1, r = 0;
		boolean c = d[0] - a < 0;
		d[0] = c ? 9 : d[0] - a;
		for (int i = 1; i < d.length - 1; i++)
		{
			d[i] = c ? d[i] - 1 : d[i];
			c = d[i] < 0;
			if (d[i] == 0)
			{
				a += p[i];
				c = d[i] - p[i] < 0;
			}
			System.out.printf("%3s:%20s%20s%20s%n", ++r, a, n - a, n);
		}
		long[] A = D(a);
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != 0)
			{
				continue;
			}
			long[] B = D(n - a - p[i]);
			a += ((i < B.length && B[i] == 0) ? 2 : 1) * p[i];
			A = D(a);
			System.out.printf("%3s:%20s%20s%20s%n", ++r, a, n - a, n);
		}
		return new long[]{a, n - a};
	}

	static long[] D(long n)
	{
		long[] d = new long[(int) (Math.log10(n) + 1)];
		for (int i = 0; n > 0; d[i++] = n % 10, n /= 10)
		{
		}
		return d;
	}
}