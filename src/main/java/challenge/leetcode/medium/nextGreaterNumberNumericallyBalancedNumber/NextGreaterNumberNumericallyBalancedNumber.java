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

package challenge.leetcode.medium.nextGreaterNumberNumericallyBalancedNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @Created 24/10/2025, 23:53 Fri 24 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class NextGreaterNumberNumericallyBalancedNumber
{
	public static int nextBeautifulNumber(int n)
	{
		int[] digits = getDigits(n);
		int digitCount = digits.length;

		int[] result = new int[digitCount];
		int[] max = new int[digitCount];
		Arrays.fill(max, digitCount);

		int digitsRemaining = digitCount;

		int digit = 1;
		while (digit < digits[0] || digit <= digitsRemaining)
		{
			digit++;
		}
		result[0] = digit;
		digitsRemaining -= digit;

		for (int i = 0; i < digitCount; i++)
		{
			digit = 1;
			while (digit < digits[i] || digit <= digitsRemaining)
			{
				digit++;
			}
			result[i] = digit;
			digitsRemaining -= digit;
			i = i + digit;
		}

		return 0;
	}

	static boolean bal(long n)
	{
		Map<Long, Long> digits = new HashMap<>();
		while (n > 0)
		{
			long digit = n % 10;
			digits.put(digit, digits.getOrDefault(digit, 0L) + 1);
			n /= 10;
		}
		for (Map.Entry<Long, Long> e : digits.entrySet())
		{
			if (!e.getKey().equals(e.getValue()))
			{
				return false;
			}
		}
		return true;
	}

	public static int nbn(int n)
	{
		for (long i = n + 1; i < Long.MAX_VALUE; i++)
		{
			if (bal(i))
			{
				return (int) i;
			}
		}
		return -1;
	}

	private static int[] getDigits(int n)
	{
		int[] digits = new int[(int) (Math.log10(n) + 1)];

		for (int i = 0; n > 0; n /= 10, i++)
		{
			digits[i] = n % 10;
		}
		return digits;
	}

	private static List<HashSet<Integer>> getPartitions(List<HashSet<Integer>> result, int n)
	{
		if (n < 1)
		{
			return result;
		}

		for (int i = 1; i < n; i++)
		{
			HashSet<Integer> set = new HashSet<>();

			set.add(i);
			set.add(n - i);
			if (set.add(i) && set.add(n - i))
			{
				result.add(set);
			}
		}

		return getPartitions(result, n - 1);
	}
}
