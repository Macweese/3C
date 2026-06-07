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

package challenge.leetcode.medium.minimumAbsoluteDistanceBetweenMirrorPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Administrator
 * @Created 06:36 Fri 17 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumAbsoluteDistanceBetweenMirrorPairs
{
	public static int minMirrorPairDistance(int[] ints)
	{
		// 1. if the distance is 1 -> terminate early return 1
		// loop through

		int distance = Integer.MAX_VALUE;
		Map<Integer, Integer> mirrors = new HashMap<>();
		Map<Integer, TreeSet<Integer>> indexMap = new HashMap<>();

		for (int i = 0; i < ints.length; i++)
		{
			mirrors.put(ints[i], reverseDigit(ints[i]));
			indexMap.computeIfAbsent(ints[i], _ -> new TreeSet<>()).add(i);
			IO.println(String.format("%10s : %-10s", ints[i], reverseDigit(ints[i])));
		}

		for (Map.Entry<Integer, Integer> entry : mirrors.entrySet())
		{
			int a = entry.getKey();
			int b = entry.getValue();
			if (mirrors.get(b) == null)
			{
				continue;
			}

			distance = Math.min(distance, ((int) minIndexDistance(indexMap.get(a), indexMap.get(b))));
//			mirrors.remove(entry.getValue());
		}

		return distance == Integer.MAX_VALUE ? -1 : distance;
	}

	private static int reverseDigit(int n)
	{
		int mirror = 0;
		int digit = (int) (Math.log10(n) + 1);
		for (int i = 0; n > 0; n /= 10, i++)
		{
			mirror += ((int) (Math.pow(10, --digit)) * (n % 10));
		}
		return mirror;
	}

	/**
	 * Computes the minimum total absolute distance when pairing
	 * all indices from the smaller TreeSet to distinct indices
	 * from the larger TreeSet.
	 *
	 * @param setA TreeSet of indices for value k_a
	 * @param setB TreeSet of indices for value k_b
	 * @return the minimum sum of |i - j| for the optimal matching
	 */
	public static long minIndexDistance(TreeSet<Integer> setA, TreeSet<Integer> setB)
	{
		// Convert TreeSets to sorted lists (they are already sorted)
		List<Integer> a = new ArrayList<>(setA);
		List<Integer> b = new ArrayList<>(setB);

		int m = a.size();
		int n = b.size();

		if (m > n)
		{
			// Swap to ensure m <= n
			return minIndexDistance(setB, setA);
		}

		// dp[i][j] = min dist to match first i indices from a
		// using exactly i indices from the first j of b
		long[][] dp = new long[m + 1][n + 1];
		for (long[] row : dp)
		{
			Arrays.fill(row, Long.MAX_VALUE / 2);
		}

		// Base case
		for (int j = 0; j <= n; j++)
		{
			dp[0][j] = 0;
		}

		// Fill DP table
		for (int i = 1; i <= m; i++)
		{
			for (int j = i; j <= n; j++)
			{
				// Option 1: skip b[j-1]
				dp[i][j] = dp[i][j - 1];

				// Option 2: pair a[i-1] with b[j-1]
				long dist = dp[i - 1][j - 1] + Math.abs((long) a.get(i - 1) - b.get(j - 1));
				dp[i][j] = Math.min(dp[i][j], dist);
			}
		}

		return dp[m][n];
	}

	public static int solve(int[] ints)
	{
		// 1. if the distance is 1 -> terminate early return 1
		// loop through

		int distance = Integer.MAX_VALUE;
		Map<Integer, Integer> mirrors = new HashMap<>();
		Map<Integer, TreeSet<Integer>> indexMap = new HashMap<>();

		for (int i = 0; i < ints.length; i++)
		{
			mirrors.put(ints[i], reverseDigit(ints[i]));
			indexMap.computeIfAbsent(ints[i], _ -> new TreeSet<>()).add(i);
			IO.println(String.format("%10s : %-10s", ints[i], reverseDigit(ints[i])));
		}

		for (Map.Entry<Integer, Integer> entry : mirrors.entrySet())
		{
			int a = entry.getKey();
			int b = entry.getValue();
			if (mirrors.get(b) == null)
			{
				continue;
			}

			MinPairDistance.MatchingResult result = MinPairDistance.minIndexDistance(indexMap.get(a), indexMap.get(b));
			distance = (int) result.minDistance;
		}

		return distance == Integer.MAX_VALUE ? -1 : distance;
	}

}
