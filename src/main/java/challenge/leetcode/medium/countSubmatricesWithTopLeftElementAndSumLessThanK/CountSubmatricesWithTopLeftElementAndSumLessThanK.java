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

package challenge.leetcode.medium.countSubmatricesWithTopLeftElementAndSumLessThanK;

/**
 * @author Administrator
 * @Created 09:38 Wed 18 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountSubmatricesWithTopLeftElementAndSumLessThanK
{
	public static int countSubmatrices(int[][] grid, int k)
	{
		int m = grid.length;
		int n = grid[0].length;
		int[][] prefixSum = new int[m + 1][n + 1];
		int count = 0;

		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + grid[i - 1][j - 1];

				if (prefixSum[i][j] <= k)
				{
					count++;
				}
			}
		}

		return count;
	}
}
