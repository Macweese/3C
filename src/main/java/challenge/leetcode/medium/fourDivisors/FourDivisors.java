/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.fourDivisors;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @Created 09:56 Sun 04 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/

// TODO: Very bad brute-force solution whipped together in <2 min
//  Improve this by checking divisors / primes with algorithm
//  e.g. sieve of eratosthenes
public class FourDivisors
{
	public static int sumFourDivisors(int[] ints)
	{
		int sum = 0;
		for (int i : ints)
		{
			Set<Integer> set = getDivisors(i);
			if (set.size() != 4)
			{
				continue;
			}
			for (int divisor : set)
			{
				sum += divisor;
			}
		}
		return sum;
	}

	private static Set<Integer> getDivisors(int n)
	{
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < n + 1; i++)
		{
			if (n % i == 0)
			{
				set.add(i);
			}
		}
		return set;
	}
}
