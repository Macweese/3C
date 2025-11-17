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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @Created 24/10/2025, 23:53 Fri 24 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class NextGreaterNumberNumericallyBalancedNumber
{
	private static final Map<Integer, List<List<Integer>>> MAP = Map.of(
		1, List.of(List.of(1)),
		2, List.of(List.of(2)),
		3, List.of(List.of(1, 2), List.of(3)),
		4, List.of(List.of(1, 3), List.of(4)),
		5, List.of(List.of(1, 4), List.of(2, 3)),
		6, List.of(List.of(1, 5), List.of(2, 4), List.of(1, 2, 3))
	);

	/*

	1 000 000

	1 = 1

	2 = 2

	3 = 1 2
	3 = 2 1
	3 = 3

	4 = 1 3
	4 = 3 1
	4 = 4

	5 = 1 4
	5 = 2 3
	5 = 3 2
	5 = 4 1
	5 = 5

	6 = 1 2 3
	6 = 1 3 2
	6 = 1 5
	6 = 2 1 3
	6 = 2 3 1
	6 = 2 4
	6 = 3 1 2
	6 = 3 2 1
	6 = 4 2
	6 = 5 1
	6 = 6

	7 = 1 2 4
	7 = 1 4 2
	7 = 1 6
	7 = 2 5
	7 = 3 4
	7 = 4 1 2
	7 = 4 2 1
	7 = 4 3
	7 = 5 2
	7 = 6 1

	8 = 1 2 5
	8 = 1 3 4
	8 = 1 4 3
	8 = 1 5 2
	8 = 1 7
	8 = 2 1 5
	8 = 2 5 1
	8 = 2 6
	8 = 3 1 4
	8 = 3 4 1
	8 = 3 5
	8 = 4 1 3
	8 = 4 3 1
	8 = 5 1 2
	8 = 5 2 1
	8 = 5 3
	8 = 6 2
	8 = 6 2
	8 = 7 1
	8 = 9

	9 = 1 8
	9 = 1 2 6
	9 = 1 3 5
	9 = 1 5 3
	9 = 1 6 2
	9 = 2 1 6
	9 = 2 6 1
	9 = 2 7
	9 = 2 3 4
	9 = 2 4 3
	9 = 3 2 4
	9 = 3 1 5
	9 = 3 4 2
	9 = 3 5 1
	9 = 3 6
	9 = 4 5
	9 = 4 2 3
	9 = 4 3 2
	9 = 5 4
	9 = 5 1 3
	9 = 5 3 1
	9 = 6 1 2
	9 = 6 2 1
	9 = 6 3
	9 = 7 2
	9 = 8 1
	9 = 9
	 */

	static void main(String[] args)
	{

//		nextBeautifulNumber(64723);
		System.out.println(nbn(64723));
	}

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

		System.out.println(Arrays.toString(result));

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

		List<HashSet<Integer>> partitions = new ArrayList<>();


		System.out.println(Arrays.toString(digits));
		System.out.println(Arrays.toString(max));
		System.out.println(Arrays.toString(result));

		return 0;
	}

	static boolean bal(long n)
	{
		System.out.println(n);
		Map<Long, Long> digits = new HashMap<>();
		while (n > 0)
		{
			long digit = n % 10;
			digits.put(digit, digits.getOrDefault(digit, 0L) + 1);
			n /= 10;
		}
		System.out.println(digits);
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
