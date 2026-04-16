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

package challenge.leetcode.medium.magicSquaresInGrid;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 01:37 Tue 30 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class MagicSquaresInGrid
{
	public static int numMagicSquaresInside(int[][] grid)
	{
		int h = grid.length;
		int w = grid[0].length;
		boolean[][] squares = new boolean[grid.length][grid[0].length];

		for (int y = 0; y < h; y++)
		{
			for (int x = 0; x < w - 2; x++)
			{
				squares[y][x] = (grid[y][x] + grid[y][x + 1] + grid[y][x + 2]) == 15;

			}
		}

		int magicSquares = 0;
		for (int y = 2; y < h; y++)
		{
			for (int x = 0; x < w; x++)
			{
				magicSquares += (squares[y][x] && squares[y - 1][x] && squares[y - 2][x]) ? 1 : 0;
			}
		}

		return magicSquares;
	}
}
