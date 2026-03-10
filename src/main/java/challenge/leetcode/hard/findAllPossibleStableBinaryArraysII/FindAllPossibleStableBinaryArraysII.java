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

package challenge.leetcode.hard.findAllPossibleStableBinaryArraysII;

/**
 * @author Administrator
 * @Created 05:05 Tue 10 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class FindAllPossibleStableBinaryArraysII
{
	private static final int MOD = (int) (1e9 + 7);

	public static int numberOfStableArrays(int zero, int one, int limit)
	{
		long[][][] dp = new long[zero + 1][one + 1][2];

		for (int i = 1; i <= Math.min(zero, limit); i++)
		{
			dp[i][0][0] = 1;
		}

		for (int j = 1; j <= Math.min(one, limit); j++)
		{
			dp[0][j][1] = 1;
		}

		for (int i = 1; i <= zero; i++)
		{
			for (int j = 1; j <= one; j++)
			{
				long sum0 = dp[i - 1][j][1];
				if (i > limit)
				{
					sum0 = (sum0 - dp[i - limit - 1][j][1] + MOD) % MOD;
				}
				dp[i][j][0] = (dp[i - 1][j][0] + sum0) % MOD;

				long sum1 = dp[i][j - 1][0];
				if (j > limit)
				{
					sum1 = (sum1 - dp[i][j - limit - 1][0] + MOD) % MOD;
				}
				dp[i][j][1] = (dp[i][j - 1][1] + sum1) % MOD;
			}
		}

		return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
	}
}
