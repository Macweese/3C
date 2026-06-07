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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Result container for the optimal index matching.
 *
 * @author Administrator
 * @Created 11:33 Fri 17 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinPairDistance
{
	public static class MatchingResult
	{
		public final long minDistance;
		public final List<int[]> pairs;  // each int[2] = {index_from_setA, index_from_setB}
		public final List<Long> individualDistances; // corresponding absolute distance |indexA - indexB| for each pair

		public MatchingResult(long minDistance, List<int[]> pairs, List<Long> individualDistances)
		{
			this.minDistance = minDistance;
			// Make a defensive copy and sort by the first index (setA side) for nice output
			List<int[]> sorted = new ArrayList<>(pairs);
			sorted.sort(Comparator.comparingInt(p -> p[0]));

			List<Long> sortedDistances = new ArrayList<>();
			for (int[] p : sorted)
			{
				// Find the original distance that belongs to this pair
				for (int i = 0; i < pairs.size(); i++)
				{
					if (Arrays.equals(pairs.get(i), p))
					{
						sortedDistances.add(individualDistances.get(i));
						break;
					}
				}
			}

			this.pairs = Collections.unmodifiableList(sorted);
			this.individualDistances = Collections.unmodifiableList(sortedDistances);
		}
	}

	/**
	 * Computes the minimum total absolute index distance AND returns the actual optimal pairs + distances.
	 * Pairs all indices from the smaller set to distinct indices from the larger set.
	 *
	 * @param setA TreeSet of indices for value k_a (original array positions)
	 * @param setB TreeSet of indices for value k_b
	 * @return MatchingResult containing the min sum and the list of optimal pairs
	 */
	public static MatchingResult minIndexDistance(TreeSet<Integer> setA, TreeSet<Integer> setB)
	{
		// Convert to ArrayLists (already sorted because TreeSet is ordered)
		List<Integer> origA = new ArrayList<>(setA);
		List<Integer> origB = new ArrayList<>(setB);

		List<Integer> listA = new ArrayList<>(origA);
		List<Integer> listB = new ArrayList<>(origB);

		boolean swapped = false;
		if (listA.size() > listB.size())
		{
			// Ensure listA is the smaller (or equal) side
			List<Integer> temp = listA;
			listA = listB;
			listB = temp;
			swapped = true;
		}

		int m = listA.size();
		int n = listB.size();

		if (m == 0)
		{
			return new MatchingResult(0, Collections.emptyList(), Collections.emptyList());
		}

		// dp[i][j] = min cost to match first i elements of listA
		// using exactly i elements from the first j of listB
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
				// Option 1: skip this element of listB
				dp[i][j] = dp[i][j - 1];

				// Option 2: pair listA[i-1] with listB[j-1]
				long cost = dp[i - 1][j - 1] + Math.abs((long) listA.get(i - 1) - listB.get(j - 1));
				if (cost < dp[i][j])
				{
					dp[i][j] = cost;
				}
			}
		}

		long minDist = dp[m][n];

		// Reconstruct pairs and their individual distances
		List<int[]> tempPairs = new ArrayList<>();
		List<Long> tempDistances = new ArrayList<>();

		reconstructPairsAndDistances(listA, listB, dp, m, n, tempPairs, tempDistances);

		// Adjust if swapped
		List<int[]> finalPairs = new ArrayList<>();
		List<Long> finalDistances = new ArrayList<>();

		for (int k = 0; k < tempPairs.size(); k++)
		{
			int[] p = tempPairs.get(k);
			long dist = tempDistances.get(k);
			if (swapped)
			{
				finalPairs.add(new int[]{p[1], p[0]});
			}
			else
			{
				finalPairs.add(new int[]{p[0], p[1]});
			}
			finalDistances.add(dist);
		}

		return new MatchingResult(minDist, finalPairs, finalDistances);
	}

	/**
	 * Backtracks through the DP table to recover one optimal matching.
	 * Prefers the pairing option whenever it achieves the optimal cost (handles ties nicely).
	 */
	private static void reconstructPairsAndDistances(List<Integer> listA, List<Integer> listB, long[][] dp, int m, int n, List<int[]> pairsOut, List<Long> distancesOut)
	{
		int i = m;
		int j = n;

		while (i > 0)
		{
			long pairCost = dp[i - 1][j - 1] + Math.abs((long) listA.get(i - 1) - listB.get(j - 1));

			if (dp[i][j] == pairCost)
			{
				// Take the pair
				int idxA = listA.get(i - 1);
				int idxB = listB.get(j - 1);
				pairsOut.add(new int[]{idxA, idxB});
				distancesOut.add(Math.abs((long) idxA - idxB));

				i--;
			}
			// Skip
			j--;
		}

		// Reverse to get increasing order of listA indices
		Collections.reverse(pairsOut);
		Collections.reverse(distancesOut);
	}

	void main()
	{
		int[] ints = {1, 8, 5, 987, 12, 120, 677, 55, 505, 550, 100, 22, 5, 1, 1};

		solve(ints, 5, 1);
		// Expected output:
		//   [2, 0]
		//   [12, 13]
	}

	private static void solve(int[] ints, int a, int b)
	{
		// Build the map: value → TreeSet of indices
		Map<Integer, TreeSet<Integer>> map = new HashMap<>();
		for (int i = 0; i < ints.length; i++)
		{
			map.computeIfAbsent(ints[i], _ -> new TreeSet<>()).add(i);
		}

		TreeSet<Integer> setA = map.get(a);   // {2, 12}
		TreeSet<Integer> setB = map.get(b);   // {0, 13, 14}

		MatchingResult result = minIndexDistance(setA, setB);
		List<Long> distances = result.individualDistances;

		// Output: 3
		IO.println("Minimum total index distance: " + result.minDistance);
		IO.println("Optimal pairs " + a + " and " + b + " (index A, index B):");
		System.out.printf("%10s  %s%n", "Distance", "Pair");
		for (int i = 0; i < result.pairs.size(); i++)
		{
			System.out.printf("%10s  %s%n", result.individualDistances.get(i), Arrays.toString(result.pairs.get(i)));
		}
	}

}