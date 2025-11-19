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
package challenge.leetcode.medium.closestPrimeNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 08/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2523
 * @Name Closest Prime Number in Range
 * @Difficulty Medium
 * @Tags math,
 * number theory
 * @link <a href="https://leetcode.com/problems/closest-prime-numbers-in-range/">www.leetcode.com/2523</a>
 * @Description Given two positive integers left and right, find the two integers num1 and num2 such that:
 * <ul>
 *     <li><code>left &le; num1 < num2 &le; right</code>.</li>
 *     <li>Both <code>num1</code> and <code>num2</code> are <a href="">prime numbers</a>.</li>
 *     <li><code>num2 - num1</code> is the <b>minimum</b> amongst all other pairs satisfying the above conditions.</li>
 * </ul>
 *
 * <br>Return the positive integer array <code>ans = [num1, num2]</code>.
 * If there are multiple pairs satisfying these conditions, return the <b>smallest</b> <code>num1</code> value.
 * If no such numbers exist, return <code>[-1, -1]</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code left = 10, right = 19}
 * 			<br><b>Output:</b> {@code [11,13]}
 * 			<br><b>Explanation:</b> The prime numbers between <code>10</code> and <code>19</code>
 * 					are <code>11</code>, <code>13</code>, <code>17</code>, and <code>19</code>.
 * 				<br>The smallest difference between any pair is <b>2</b>, which can be achieved by <code>[11,13]</code> or <code>[17,19]</code>.
 * 				<br>Since <code>11</code> is smaller than <code>17</code>, we return the first pair.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code left = 4, right = 6}
 * 			<br><b>Output:</b> {@code [-1,-1]}
 * 			<br><b>Explanation:</b> There exists only one prime number in the given range, so the conditions cannot be satisfied.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; left &le; right &le; 10<sup>6</sup></code></li>
 * </ul>
 * </p>
 **/
@Slf4j
public class ClosestPrimeNumberInRange
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();
	}

	// Solution works but TLE
	// TODO: function for checking if a number is a prime number is faulty
	public static int[] closestPrimes(int left, int right)
	{
		int n = 0;
		int[] primes = new int[right - left + 1];

		for (int i = left; i <= right; i++)
		{
			if (!isPrime(i))
			{
				continue;
			}
			primes[n] = i;
			n++;
		}

		left = 0;
		right = 1;

		for (int i = 1; i < primes.length; i++)
		{
			if (primes[i] < 2)
			{
				continue;
			}

			if (primes[i] - primes[i - 1] < (primes[right] - primes[left]))
			{
				left = i - 1;
				right = i;
			}
		}

		return (primes[left] == 0 || primes[right] == 0)
			? new int[]{-1, -1}
			: new int[]{primes[left], primes[right]};
	}

	private static int sqrt(int x)
	{
		int root = x;

		while (root * root > x)
		{
			root = (root + x / root) / 2;
		}
		return root;
	}

	// TODO: function for checking if a number is a prime number is faulty
	private static boolean isPrime(int x)
	{
		if (x == 1)
		{
			return false;
		}

		for (int i = sqrt(x); i > 1; i--)
		{
			if (x % i == 0)
			{
				return false;
			}
		}

		return true;
	}
}

class Solution
{
	public static int[] closestPrimes(int left, int right)
	{
		List<Integer> primes = new ArrayList<>();

		for (int i = Math.max(2, left); i <= right; i++)
		{
			if (isPrime(i))
			{
				primes.add(i);
			}
		}

		if (primes.size() < 2)
		{
			return new int[]{-1, -1};
		}

		int diff = Integer.MAX_VALUE;
		int[] result = new int[]{-1, -1};

		for (int i = 1; i < primes.size(); i++)
		{
			int d = primes.get(i) - primes.get(i - 1);
			if (d < diff)
			{
				diff = d;
				result[0] = primes.get(i - 1);
				result[1] = primes.get(i);
			}
		}

		return result;
	}

	private static boolean isPrime(int n)
	{
		if (n <= 1)
		{
			return false;
		}
		if (n <= 3)
		{
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0)
		{
			return false;
		}
		for (int i = 5; i * i <= n; i += 6)
		{
			if (n % i == 0 || n % (i + 2) == 0)
			{
				return false;
			}
		}
		return true;
	}
}
