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

package challenge.leetcode.medium.constructProductMatrix;

/**
 * @author Administrator
 * @Created 06:30 Tue 24 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class ConstructProductMatrix
{
	public static int[][] constructProductMatrix(int[][] grid)
	{
		int MOD = 12345;
		int n = grid.length;
		int m = grid[0].length;
		int[][] productMatrix = new int[n][m];

		long suf = 1;
		for (int i = n - 1; i >= 0; --i)
		{
			for (int j = m - 1; j >= 0; --j)
			{
				productMatrix[i][j] = (int) suf;
				suf = suf * grid[i][j] % MOD;
			}
		}

		long pre = 1;
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < m; ++j)
			{
				productMatrix[i][j] = (int) (productMatrix[i][j] * pre % MOD);
				pre = pre * grid[i][j] % MOD;
			}
		}

		return productMatrix;
	}
}