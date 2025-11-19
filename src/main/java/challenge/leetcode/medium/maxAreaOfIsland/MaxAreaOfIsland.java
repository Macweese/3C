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

package challenge.leetcode.medium.maxAreaOfIsland;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Created 19/09/2025, 07:57 Fri 19 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class MaxAreaOfIsland
{
	public static void main(String[] args)
	{
		int[][] coords = new int[][]{
			{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},    // 0 0 1 0 0 0 0 1 0 0 0 0 0  ->  0 0 1 0 0 0 0 2 0 0 0 0 0
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},    // 0 0 0 0 0 0 0 1 1 1 0 0 0  ->  0 0 0 0 0 0 0 2 2 2 0 0 0
			{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},    // 0 1 1 0 1 0 0 0 0 0 0 0 0  ->  0 3 3 0 4 0 0 0 0 0 0 0 0
			{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},    // 0 1 0 0 1 1 0 0 1 0 1 0 0  ->  0 3 0 0 4 4 0 0 5 0 5 0 0
			{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},    // 0 1 0 0 1 1 0 0 1 1 1 0 0  ->  0 3 0 0 4 4 0 0 5 5 5 0 0
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},    // 0 0 0 0 0 0 0 0 0 0 1 0 0  ->  0 0 0 0 0 0 0 0 0 0 5 0 0
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},    // 0 0 0 0 0 0 0 1 1 1 0 0 0  ->  0 0 0 0 0 0 0 6 6 6 0 0 0
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}     // 0 0 0 0 0 0 0 1 1 0 0 0 0  ->  0 0 0 0 0 0 0 6 6 0 0 0 0
		};

		maxAreaOfIslandWithMarkingIslands(coords);

		int[][] grid = {
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			{0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
		};
		int ans = maxAreaOfIslandHysteretic(grid);
		System.out.println("Max island size: " + ans);
	}

	private static int rows;
	private static int columns;

	public static int maxAreaOfIsland(int[][] matrix)
	{
		int ans = 0;
		rows = matrix.length;
		columns = matrix[0].length;

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (matrix[i][j] > 0)
				{
					ans = Math.max(ans, dfs(i, j, matrix));
				}
			}
		}
		return ans;
	}

	private static int dfs(int i, int j, int[][] matrix)
	{
		if (i < 0 || j < 0 || i >= rows || j >= columns || matrix[i][j] < 1)
		{
			return 0;
		}
		matrix[i][j] = 0;
		return 1 +
			dfs(i - 1, j, matrix) +
			dfs(i, j - 1, matrix) +
			dfs(i + 1, j, matrix) +
			dfs(i, j + 1, matrix);
	}

	public static int maxAreaOfIslandWithMarkingIslands(int[][] coord)
	{
		if (coord.length == 0 || coord[0].length == 0)
		{
			return 0;
		}

		int xSize = coord.length;
		int ySize = coord[0].length;

		// Reverse signum so that marking island IDs with '1' is possible
		// Otherwise, island with ID '1' would be considered unvisited,
		// and cause infinite recursion
		for (int x = 0; x < xSize; x++)
		{
			for (int y = 0; y < ySize; y++)
			{
				coord[x][y] = coord[x][y] == 1 ? -1 : coord[x][y];
			}
		}

		int max = 0;
		int islandId = 1;
		int[] count = new int[1];
		Map<Integer, Integer> islandIdSizeMap = new HashMap<>();
		for (int x = 0; x < xSize; x++)
		{
			for (int y = 0; y < ySize; y++)
			{
				if (coord[x][y] == -1)
				{
					count[0] = 0;
					dfs(coord, x, y, xSize, ySize, count, islandId);
					islandIdSizeMap.put(islandId, count[0]);
					max = Math.max(count[0], max);
					islandId++;
				}
			}

			System.out.println(Arrays.toString(coord[x]));
		}

		System.out.println("\nID, size");
		islandIdSizeMap.entrySet().forEach(System.out::println);
		System.out.printf("%nLargest island is of size: %s area unit(s)%n", max);
		return max;
	}

	private static void dfs(int[][] coord, int x, int y, int xSize, int ySize, int[] islandSize, int id)
	{
		if (x < 0 || y < 0 || x >= xSize || y >= ySize || coord[x][y] != -1)
		{
			return;
		}

		// Mark visited
		coord[x][y] = id;
		islandSize[0]++;
		dfs(coord, x + 1, y, xSize, ySize, islandSize, id);
		dfs(coord, x - 1, y, xSize, ySize, islandSize, id);
		dfs(coord, x, y + 1, xSize, ySize, islandSize, id);
		dfs(coord, x, y - 1, xSize, ySize, islandSize, id);
	}

	// -----------------------------------------------------------------------------------
	// Testing algorithms
	// -----------------------------------------------------------------------------------

	// Public entry point with suffix-ones enabled by default
	public static int maxAreaOfIslandHysteretic(int[][] grid)
	{
		return maxAreaOfIslandHysteretic(grid, true);
	}

	// Variant that lets you disable the suffix-ones bound (falls back to remaining-cells bound)
	public static int maxAreaOfIslandHysteretic(int[][] grid, boolean useSuffixOnesBound)
	{
		if (grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return 0;
		}

		final int R = grid.length;
		final int C = grid[0].length;
		final int N = R * C;

		// Build a 1D array of original ones in row-major order (BEFORE mutating grid).
		int[] ones = null;
		int[] suffixOnes = null;
		if (useSuffixOnesBound)
		{
			ones = new int[N];
			int k = 0;
			for (int i = 0; i < R; i++)
			{
				for (int j = 0; j < C; j++, k++)
				{
					ones[k] = (grid[i][j] == 1) ? 1 : 0;
				}
			}
			suffixOnes = new int[N + 1]; // suffixOnes[idx] = ones from idx...N-1
			for (int idx = N - 1; idx >= 0; idx--)
			{
				suffixOnes[idx] = suffixOnes[idx + 1] + ones[idx];
			}
		}

		// Flip 1 -> -1 (unvisited land), keep 0 as water. This matches your original scheme.
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
			{
				if (grid[i][j] == 1)
				{
					grid[i][j] = -1;
				}
			}
		}

		int best = 0;
		int islandId = 1;

		// Hysteretic scanning: dynamically widen seed-stride and optionally enable checkerboard seeding.
		final boolean enableCheckerboardOnceBestGe2 = true;
		final int checkerboardColor = 0; // 0 or 1; fixed color when checkerboard is active

		for (int i = 0; i < R; i++)
		{
			// Early termination before processing this row
			final int rowStartIdx = i * C;
			if (useSuffixOnesBound)
			{
				if (suffixOnes[rowStartIdx] <= best)
				{
					return best;
				}
			}
			else
			{
				int remainingCells = N - rowStartIdx;
				if (remainingCells <= best)
				{
					return best;
				}
			}

			// Compute current row seeding stride based on best (m = floor(best/C) + 1)
			int rowStride = (best / C) + 1; // at least 1
			if (rowStride < 1)
			{
				rowStride = 1;
			}
			boolean seedThisRow = (i % rowStride == 0);

			if (!seedThisRow)
			{
				// Skip seeding in this row (but components can still be traversed into from seeded rows)
				continue;
			}

			for (int j = 0; j < C; j++)
			{
				// Mid-row early termination
				if (useSuffixOnesBound)
				{
					int idx = i * C + j;
					if (suffixOnes[idx] <= best)
					{
						return best;
					}
				}

				// Optional checkerboard seeding once best >= 2 (safe to discover any component that could beat best)
				if (enableCheckerboardOnceBestGe2 && best >= 2)
				{
					if (((i + j) & 1) != checkerboardColor)
					{
						continue; // only seed one color; DFS still traverses both
					}
				}

				if (grid[i][j] == -1)
				{
					int size = dfsIterativeMark(grid, i, j, R, C, islandId);
					if (size > best)
					{
						best = size;
					}
					islandId++;

					// Ultra-early-out if our current best already exceeds half the grid: no remaining island can beat it.
					if (best > (N - best))
					{
						return best;
					}
				}
			}
		}

		return best;
	}

	// Iterative DFS that marks an island with id and returns its size.
	private static int dfsIterativeMark(int[][] grid, int sx, int sy, int R, int C, int id)
	{
		int size = 0;
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[]{sx, sy});

		while (!stack.isEmpty())
		{
			int[] cur = stack.pop();
			int x = cur[0], y = cur[1];
			if (x < 0 || y < 0 || x >= R || y >= C)
			{
				continue;
			}
			if (grid[x][y] != -1)
			{
				continue; // not unvisited land
			}

			grid[x][y] = id;
			size++;

			// 4-neighborhood
			// Push neighbors that are likely valid first to improve cache locality a bit
			if (x + 1 < R)
			{
				stack.push(new int[]{x + 1, y});
			}
			if (x - 1 >= 0)
			{
				stack.push(new int[]{x - 1, y});
			}
			if (y + 1 < C)
			{
				stack.push(new int[]{x, y + 1});
			}
			if (y - 1 >= 0)
			{
				stack.push(new int[]{x, y - 1});
			}
		}

		return size;
	}
}
