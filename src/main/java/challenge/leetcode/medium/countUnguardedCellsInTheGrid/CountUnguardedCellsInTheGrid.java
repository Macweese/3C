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

package challenge.leetcode.medium.countUnguardedCellsInTheGrid;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 02/11/2025, 03:58 Sun 02 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountUnguardedCellsInTheGrid
{
	private static final int WALL = -1;
	private static final int GUARD = -2;
	private static final int VISIBLE = 1;
	private static final int INVISIBLE = 0;

	public static int countUnguarded(int m, int n, int[][] guards, int[][] walls)
	{
		int invisibleCells = m * n - guards.length - walls.length;
		int[][] grid = new int[m][n];

		for (int[] coords : walls)
		{
			grid[coords[0]][coords[1]] = WALL;
		}
		for (int[] coords : guards)
		{
			grid[coords[0]][coords[1]] = GUARD;
		}

		for (int x = 0; x < m; x++)
		{
			for (int y = 0; y < n; y++)
			{
				if (grid[x][y] == GUARD)
				{
					invisibleCells -= fillLineOfSight(x, y, grid);
				}
			}
		}

		return invisibleCells;
	}

	private static int fillLineOfSight(int x, int y, int[][] grid)
	{
		int cells = 0;
		// SOUTH
		for (int i = Math.min(x + 1, grid.length - 1); i < grid.length; i++)
		{
			if (grid[i][y] == GUARD || grid[i][y] == WALL)
			{
				break;
			}
			cells += grid[i][y] == INVISIBLE ? 1 : 0;
			grid[i][y] = VISIBLE;
		}
		// NORTH
		for (int i = Math.max(0, x - 1); i >= 0; i--)
		{
			if (grid[i][y] == GUARD || grid[i][y] == WALL)
			{
				break;
			}
			cells += grid[i][y] == INVISIBLE ? 1 : 0;
			grid[i][y] = VISIBLE;
		}
		// WEST
		for (int i = Math.max(0, y - 1); i >= 0; i--)
		{
			if (grid[x][i] == GUARD || grid[x][i] == WALL)
			{
				break;
			}
			cells += grid[x][i] == INVISIBLE ? 1 : 0;
			grid[x][i] = VISIBLE;
		}
		// EAST
		for (int i = Math.min(y + 1, grid[x].length - 1); i < grid[x].length; i++)
		{
			if (grid[x][i] == GUARD || grid[x][i] == WALL)
			{
				break;
			}
			cells += grid[x][i] == INVISIBLE ? 1 : 0;
			grid[x][i] = VISIBLE;
		}
		return cells;
	}
}

class Solution
{
	private static final int MAXS = 100_000;
	private static final int MAXW = (MAXS + 63) >>> 6;

	private static final long[] BLK = new long[MAXW];
	private static final long[] VIS = new long[MAXW];

	private static boolean isSet(final long[] a, final int idx)
	{
		final int w = idx >>> 6;
		final int b = idx & 63;
		return ((a[w] >>> b) & 1L) != 0L;
	}

	private static boolean setIfAbsent(final long[] a, final int idx)
	{
		final int w = idx >>> 6;
		final int b = idx & 63;
		final long mask = 1L << b;
		final long v = a[w];
		if ((v & mask) == 0L)
		{
			a[w] = v | mask;
			return true;
		}
		return false;
	}

	private static void set(final long[] a, final int idx)
	{
		final int w = idx >>> 6;
		final int b = idx & 63;
		a[w] |= 1L << b;
	}

	public int countUnguarded(final int m, final int n, final int[][] guards, final int[][] walls)
	{
		for (final var w : walls)
		{
			set(BLK, w[0] * n + w[1]);
		}
		for (final var g : guards)
		{
			set(BLK, g[0] * n + g[1]);
		}

		int coveredOrBlocked = walls.length + guards.length;

		for (final var g : guards)
		{
			final int x = g[0], y = g[1];

			// up
			for (int i = x - 1, d = i * n + y; i >= 0 && !isSet(BLK, d); --i, d -= n)
			{
				if (setIfAbsent(VIS, d))
				{
					++coveredOrBlocked;
				}
			}
			// down
			for (int i = x + 1, d = i * n + y; i < m && !isSet(BLK, d); ++i, d += n)
			{
				if (setIfAbsent(VIS, d))
				{
					++coveredOrBlocked;
				}
			}
			// left
			for (int j = y - 1, d = x * n + j; j >= 0 && !isSet(BLK, d); --j, --d)
			{
				if (setIfAbsent(VIS, d))
				{
					++coveredOrBlocked;
				}
			}
			// right
			for (int j = y + 1, d = x * n + j; j < n && !isSet(BLK, d); ++j, ++d)
			{
				if (setIfAbsent(VIS, d))
				{
					++coveredOrBlocked;
				}
			}
		}

		final int size = m * n;
		final int q = (size + 63) >>> 6;

		Arrays.fill(BLK, 0, q, 0L);
		Arrays.fill(VIS, 0, q, 0L);

		return size - coveredOrBlocked;
	}
}
