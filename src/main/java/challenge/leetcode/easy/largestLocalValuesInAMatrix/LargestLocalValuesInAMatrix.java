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
 */

package challenge.leetcode.easy.largestLocalValuesInAMatrix;

/**
 * @author Administrator
 * @Created 21:46 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 * Further read: Max-Pooling CNN Pooling layer
 **/
public class LargestLocalValuesInAMatrix
{
	public static int[][] largestLocal(int[][] grid)
	{
		int n = grid.length;
		int[][] matrix = new int[n - 2][n - 2];
		for (int x = 1; x < n - 1; x++)
		{
			for (int y = 1; y < n - 1; y++)
			{
				matrix[x - 1][y - 1] = maxPool(grid, x, y);
			}
		}
		return matrix;
	}

	private static int maxPool(int[][] grid, int x, int y)
	{
		int max = Integer.MIN_VALUE;
		for (int i = x - 1; i <= x + 1; i++)
		{
			for (int j = y - 1; j <= y + 1; j++)
			{
				max = Math.max(max, grid[i][j]);
			}
		}
		return max;
	}
}
