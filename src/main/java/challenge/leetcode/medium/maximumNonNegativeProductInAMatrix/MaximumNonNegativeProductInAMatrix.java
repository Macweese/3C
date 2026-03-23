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

package challenge.leetcode.medium.maximumNonNegativeProductInAMatrix;

import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * @author Administrator
 * @Created 06:39 Mon 23 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MaximumNonNegativeProductInAMatrix
{
	private static final int MOD = (int) 1e9 + 7;

	public static int maxProductPath(int[][] grid)
	{
		int m = grid.length;
		int n = grid[0].length;

		long[][] dpMin = new long[m][n];
		long[][] dpMax = new long[m][n];

		dpMin[0][0] = dpMax[0][0] = grid[0][0];

		for (int i = 1; i < m; ++i)
		{
			dpMin[i][0] = dpMax[i][0] = dpMin[i - 1][0] * grid[i][0];
		}

		for (int j = 1; j < n; ++j)
		{
			dpMin[0][j] = dpMax[0][j] = dpMin[0][j - 1] * grid[0][j];
		}

		for (int i = 1; i < m; ++i)
		{
			for (int j = 1; j < n; ++j)
			{
				if (grid[i][j] < 0)
				{
					dpMin[i][j] = max(dpMax[i - 1][j], dpMax[i][j - 1]) * grid[i][j];
					dpMax[i][j] = min(dpMin[i - 1][j], dpMin[i][j - 1]) * grid[i][j];
				}
				else
				{
					dpMin[i][j] = min(dpMin[i - 1][j], dpMin[i][j - 1]) * grid[i][j];
					dpMax[i][j] = max(dpMax[i - 1][j], dpMax[i][j - 1]) * grid[i][j];
				}
			}
		}

		long result = dpMax[m - 1][n - 1];

		return result < 0 ? -1 : (int) (result % MOD);
	}
}