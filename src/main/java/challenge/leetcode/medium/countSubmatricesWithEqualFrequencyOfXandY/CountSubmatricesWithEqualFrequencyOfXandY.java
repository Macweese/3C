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

package challenge.leetcode.medium.countSubmatricesWithEqualFrequencyOfXandY;

/**
 * @author Administrator
 * @Created 07:04 Thu 19 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountSubmatricesWithEqualFrequencyOfXandY
{
	public static int numberOfSubmatrices(char[][] grid)
	{
		int m = grid.length;
		int n = grid[0].length;
		int[][][] prefixSum = new int[m + 1][n + 1][2];
		int count = 0;

		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				prefixSum[i][j][0] = prefixSum[i - 1][j][0] + prefixSum[i][j - 1][0] - prefixSum[i - 1][j - 1][0];
				prefixSum[i][j][1] = prefixSum[i - 1][j][1] + prefixSum[i][j - 1][1] - prefixSum[i - 1][j - 1][1];

				if (grid[i - 1][j - 1] == 'X')
				{
					prefixSum[i][j][0]++;
				}
				else if (grid[i - 1][j - 1] == 'Y')
				{
					prefixSum[i][j][1]++;
				}

				if (prefixSum[i][j][0] > 0 && prefixSum[i][j][0] == prefixSum[i][j][1])
				{
					count++;
				}
			}
		}

		return count;
	}
}
