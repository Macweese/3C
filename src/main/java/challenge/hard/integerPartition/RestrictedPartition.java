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
 *
 */
package challenge.hard.integerPartition;

import utils.arrays.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Read more:
 * <li>Euler product</li>
 * <li>Integer partition</li>
 * <li>Combinatorics</li>
 * <li>Number theory</li>
 * <br>
 * Approx formula
 * <br>
 * p(n) = F(n + 1), 0 &le; n &le; &#8784;&infin; , where F(n) is the n<sup>th</sup> Fibonacci number.
 * <br>
 * The generating function of p(n) is the reciprocal of
 * <a href="https://arachnoid.com/latex/?equ=G_%7B%5C%7Bp(n)%5C%7D%7D(x)%3D%5Csum_%7Bn%3D0%7D%5E%7B%5Cinfty%7Dp%20(n)%20x%5E%7Bn%7D%3D%5Cprod_%7Bk%3D1%7D%5E%7B%5Cinfty%7D(%5Cfrac%7B1%7D%7B1-x%5E%7Bk%7D%7D)%3D%5Cfrac%7B1%7D%7B%5Cprod_%7B%5Cinfty%7D%5E%7Bk%3D1%7D(1-x%5E%7Bk%7D)%7D">Euler&rsquo;s function</a>
 */
public class RestrictedPartition
{
	/**
	 * Gets the least partitions for the sum for the given addends.
	 * <br>
	 * <br>
	 * Solves using dynamic programming for
	 * integer partitioning problem, AKA knapsack problem.
	 * <br>
	 * Solution complexity: O(ns) Pseudo-polynomial.
	 * <br><br>
	 * Example:
	 * <br>
	 * <ol>
	 * 		<li>
	 * 			An array {@code partitions[] = [3, 6, 9]},<br> and the {@code sum = 15}, yields the result {@code 2}.<br>
	 * 			Forming the partitions {@code [6, 9]} to {@code 15}.
	 * 		</li>
	 * 	<p>
	 * 		<li>
	 * 			An array {@code partitions[] = [1, 2, 3, 5, 7, 18, 21, 24, 25, 30]}, and the {@code sum = 28}, yields the result {@code 2}.<br>
	 * 			Forming the partitions {@code [21, 7]} to {@code 28}.
	 * 		</li>
	 * 	<p>
	 * 		<li>
	 * 			An array {@code partitions[] = [2, 10]},<br> and the {@code sum = 11}, yields the result {@code -1}.<br>
	 * 			There are no partitions to {@code 11} from the parts of {@code [2, 10]}.
	 * 		</li>
	 * </ol>
	 *
	 * @param partitions the values for the partitions which are
	 *                   available to make up the sum for.
	 * @param n          the sum for which the partitions need to
	 *                   collate to.
	 * @return the minimum amount of partitions needed.
	 * <br>Returns -1 if no solution exists with the given partitions.
	 */
	public static int findMinNumberOfPartitions(int[] partitions, int n)
	{
		int[] parts = new int[n + 1];
		Arrays.fill(parts, n + 1);
		parts[0] = 0;

		for (int i = 1; i < n + 1; i++)
		{
			for (int c : partitions)
			{
				if (i >= c)
				{
					parts[i] = Math.min(parts[i], parts[i - c] + 1);
				}
			}
			// debug visualized
			//System.out.println(Arrays.toString(parts));
		}

		return parts[n] > n ? -1 : parts[n];
	}

	/**
	 * Finds the integer partitions to {@code n}, restricted to {@code c}
	 * <br>
	 * Read <a href="https://oeis.org/A000009">OEIS A000009</a>
	 *
	 * @param n The number to partition
	 * @param c The number of partitions
	 * @return The partitions, note that these are not compositions
	 */
	public static List<List<Integer>> strictPartition(int n, int c)
	{
		List<List<Integer>> list = new ArrayList<>();
		strictPartition(n, n, c, list, new ArrayList<>());
		return list;
	}

	/**
	 * Finds the integer partitions to {@code n}, restricted to {@code c}
	 * <br>
	 * Modified version of {@link RestrictedPartition#strictPartition(int, int)}
	 * for RuneLine Quest Helper.
	 * <br>
	 * Also accepts array of int which are available.
	 */
	public static List<List<Integer>> strictPartition(int n, int c, int... ints)
	{
		List<List<Integer>> partitions = new ArrayList<>();
		strictPartition(n, n, c, partitions, new ArrayList<>(), ints);
		return partitions;
	}

	private static void strictPartition(int n, int max, int c, List<List<Integer>> partitions, List<Integer> partition)
	{
		if (n == 0)
		{
			if (partition.size() == c)
			{
				partitions.add(partition);
			}
		}

		for (int i = Math.min(max, n); i >= 1; i--)
		{
			if (partition.size() > c - 1)
			{
				continue;
			}

			ArrayList<Integer> part = new ArrayList<>(partition);
			part.add(i);
			strictPartition(n - i, i, c, partitions, part);
		}
	}

	/**
	 * Finds the integer partitions to {@code n}, restricted to {@code c}
	 * <br>
	 * Modified version of {@link RestrictedPartition#strictPartition(int, int, int, List, List)}
	 * for RuneLine Quest Helper.
	 * <br>
	 * Also accepts array of int which are available.
	 */
	private static void strictPartition(int n, int max, int c, List<List<Integer>> partitions, List<Integer> partition, int... ints)
	{
		if (n == 0)
		{
			if (partition.size() == c && ArrayUtils.isSubset(ints, partition.stream().mapToInt(Integer::intValue).toArray()))
			{
				partitions.add(partition);
			}
		}

		for (int i = Math.min(max, n); i >= 1; i--)
		{
			if (partition.size() > c - 1)
			{
				continue;
			}

			ArrayList<Integer> part = new ArrayList<>(partition);
			part.add(i);
			strictPartition(n - i, i, c, partitions, part, ints);
		}
	}

	/**
	 * Prints the partitions for the number {@code n}
	 *
	 * @param n The number to calculate partitions up to, from 2.
	 */
	public static void printPartitionCount(int n)
	{
		HashMap<Integer, Integer> partitionMap = new HashMap<>();
		for (int i = 2; i < n; i++)
		{
			partitionMap.put(i, partitions(i));
		}

		for (Map.Entry<Integer, Integer> e : partitionMap.entrySet())
		{
			System.out.println(e);
		}
	}


	public static void partition(int n)
	{
		partition(n, n, "");
	}

	public static void partition(int n, int max, String prefix)
	{
		if (n == 0)
		{
			System.out.println(prefix);
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--)
		{
			partition(n - i, i, prefix + " " + i);
		}
	}

	/**
	 * Gets the partitions of an integer n
	 *
	 * @param n the number to partition
	 * @return the number of compositions
	 */
	public static int partitions(int n)
	{
		int[][] dp = new int[n - 1][n + 1];
		Arrays.fill(dp[0], 1);

		for (int i = 0; i < dp.length; i++)
		{
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++)
		{
			for (int j = 1; j < dp[0].length; j++)
			{
				if (j > i)
				{
					dp[i][j] = dp[i - 1][j] + dp[i][j - (i + 1)];
				}
				else
				{
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1] + 1;
	}

	//--------------------------------------------------------------------------------//

	/**
	 * testing other peoples solution
	 */
	int[] dp;

	public int coinChange(int[] coins, int amount)
	{
		dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		int ans = coinCount(coins, amount);
		return (ans == Integer.MAX_VALUE) ? -1 : ans;
	}

	int coinCount(int[] coins, int amount)
	{
		// Cannot partition into negative range
		// and zero is invalid case for us
		if (amount <= 0)
		{
			return -1;
		}

		if (dp[amount] != -1)
		{
			return dp[amount];
		}

		int minCoins = -1;
		for (int coin : coins)
		{
			int ans = coinCount(coins, amount - coin);

			if (ans != -1)
			{
				//we have returned 0 in ans, so now we are updating the ans count
				//hence 1 + ans
				minCoins = Math.min(minCoins, 1 + ans);
			}
		}
		return dp[amount] = minCoins;
	}

}
