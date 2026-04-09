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

package challenge.leetcode.medium.maximumAmountOfMoneyRobotCanEarn;

/**
 * @author Administrator
 * @Created 05:13 Thu 02 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MaximumAmountOfMoneyRobotCanEarn
{
	private static Integer[][][] memo;
	private static int[][] coins;
	private static int m, n;

	public static int maximumAmount(int[][] coins)
	{
		MaximumAmountOfMoneyRobotCanEarn.coins = coins;
		m = coins.length;
		n = coins[0].length;
		memo = new Integer[m][n][3];

		return dfs(0, 0, 0);
	}

	private static int dfs(int i, int j, int neutralized)
	{
		if (i >= m || j >= n)
		{
			return Integer.MIN_VALUE / 2;
		}

		if (i == m - 1 && j == n - 1)
		{
			if (coins[i][j] < 0 && neutralized < 2)
			{
				return Math.max(coins[i][j], 0);
			}
			return coins[i][j];
		}

		if (memo[i][j][neutralized] != null)
		{
			return memo[i][j][neutralized];
		}

		int maxProfit = Integer.MIN_VALUE / 2;

		int takeCoins = coins[i][j] + Math.max(dfs(i + 1, j, neutralized), dfs(i, j + 1, neutralized));
		maxProfit = Math.max(maxProfit, takeCoins);

		if (coins[i][j] < 0 && neutralized < 2)
		{
			int neutralize = Math.max(dfs(i + 1, j, neutralized + 1), dfs(i, j + 1, neutralized + 1));
			maxProfit = Math.max(maxProfit, neutralize);
		}

		memo[i][j][neutralized] = maxProfit;
		return maxProfit;
	}
}
