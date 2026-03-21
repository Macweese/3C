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

package challenge.leetcode.medium.getBiggestThreeRhombusSumInAGrid;

import java.util.TreeSet;

/**
 * @author Administrator
 * @Created 07:06 Mon 16 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class GetBiggestThreeRhombusSumInAGrid
{
	public static int[] getBiggestThree(int[][] grid)
	{
		int m = grid.length;
		int n = grid[0].length;
		TreeSet<Integer> topThree = new TreeSet<>();

		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				topThree.add(grid[i][j]);
				if(topThree.size() > 3)
				{
					topThree.pollFirst();
				}

				int maxLen = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
				for(int len = 1; len <= maxLen; len++)
				{
					int sum = getRhombusSum(grid, i, j, len);
					topThree.add(sum);
					if(topThree.size() > 3)
					{
						topThree.pollFirst();
					}
				}
			}
		}

		int[] result = new int[topThree.size()];
		int idx = topThree.size() - 1;
		for(int val : topThree)
		{
			result[idx--] = val;
		}
		return result;
	}

	private static int getRhombusSum(int[][] grid, int row, int col, int len)
	{
		int sum = 0;

		for(int i = 0; i < len; i++)
		{
			sum += grid[row - len + i][col - i];
		}

		for(int i = 0; i < len; i++)
		{
			sum += grid[row + i][col - len + i];
		}

		for(int i = 0; i < len; i++)
		{
			sum += grid[row + len - i][col + i];
		}

		for(int i = 0; i < len; i++)
		{
			sum += grid[row - i][col + len - i];
		}

		return sum;
	}
}
