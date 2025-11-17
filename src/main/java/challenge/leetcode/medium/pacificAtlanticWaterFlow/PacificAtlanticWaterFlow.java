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

package challenge.leetcode.medium.pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Created 05/10/2025, 02:16 Sun 05 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 **/
public class PacificAtlanticWaterFlow
{
	static void main(String[] args)
	{
		int[][] TEST_ = {
			{1, 2, 2, 3, 5},        //	1, 2, 2, 3, 5		1, 2, -, 3, 5
			{3, 2, 3, 4, 4},        //	3, 2, 3, 4, 4		-, 2, 3, 4, 4
			{2, 4, 5, 3, 1},        //	2, 4, 5, 3, 1		-, 4, 5, -, 1
			{6, 7, 1, 4, 5},        //	6, 7, 1, 4, 5		-, 7, 1, 4, 5
			{5, 1, 1, 2, 4}            //	5, 1, 1, 2, 4		5, 1, -, 2, 4
		};
		pacificAtlantic(TEST_);
//		System.out.println(djikstra(TEST_));

		List<int[]> path = new ArrayList<>();
//		path.add(new int[]{0,2});
//		path.add(new int[]{2,0});
//		path.add(new int[]{2,2});
		path.add(new int[]{0, 0});
		path.add(new int[]{1, 1});
		path.add(new int[]{0, 1});
		path.add(new int[]{1, 0});
		//	   0  1  2
		//	0  X  X  X
		//	1  X  X
		//	2
		//
		System.out.println(pathReachesEdges(path, 3, 3));
	}

	public static List<List<Integer>> pacificAtlantic(int[][] heights)
	{
		int sizeX = heights.length;
		int sizeY = heights[0].length;
		int[][] visited = new int[sizeX][sizeY];
		List<List<Integer>> result = new ArrayList<>();

		return null;
	}

	public static List<List<Integer>> dfs(int[][] matrix)
	{
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];

		int[] dxdy = {1, 0, -1, 0, 1};

		List<List<Integer>> result = new ArrayList<>();

		for (int x = 0; x < matrix.length; x++)
		{
			for (int y = 0; y < matrix[x].length; y++)
			{
				int elevation = matrix[x][y];

				List<int[]> path = new ArrayList<>();
				for (int k = 0; k < 4; k++)
				{
					int dx = x + dxdy[k];
					int dy = y + dxdy[k + 1];
					if (dx < 0 || dx >= row || dy < 0 || dy >= col || visited[dx][dy])
					{
						continue;
					}
					path.add(new int[]{x, y});

					visited[dx][dy] = true;
					if (matrix[dx][dy] <= elevation && pathReachesEdges(path, row, col))
					{
						result.add(List.of(path.get(0)[0], path.get(0)[1]));
					}
				}
			}
		}
		return result;
	}

	private static boolean pathReachesEdges(List<int[]> coordinatePath, int xMax, int yMax)
	{
		boolean reachesNW = false;
		boolean reachesSE = false;

		System.out.printf("%-10s %-12s %-12s %n", " ", "north-west", "south-east");
		for (int[] coord : coordinatePath)
		{
			reachesNW = (reachesNW | coord[0] == 0 | coord[1] == 0);
			System.out.printf("%-10s %-12s %-12s%n", Arrays.toString(coord), (coord[0] == 0 | coord[1] == 0), (coord[0] == xMax - 1 | coord[1] == yMax - 1));
			reachesSE = (reachesSE | coord[0] == xMax - 1 | coord[1] == yMax - 1);
		}
		return reachesNW && reachesSE;
	}

	private static boolean pathReachesEdges(List<int[]> coordinatePath, int[][] matrix)
	{
		boolean reachesNW = false;
		boolean reachesSE = false;

		for (int[] coord : coordinatePath)
		{
			reachesNW = (reachesNW | coord[0] == 0 | coord[1] == 0);
			reachesSE = (reachesSE | coord[0] == matrix.length - 1 | coord[1] == matrix[0].length - 1);
		}
		return reachesNW && reachesSE;
	}
}





class Solution
{
	private int xSize;
	private int ySize;
	private int[][] matrix;
	private boolean[][] nw;
	private boolean[][] se;
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public List<List<Integer>> pacificAtlantic(int[][] coordinates)
	{
		if (coordinates == null || coordinates.length == 0 || coordinates[0].length == 0)
		{
			return new ArrayList<>();
		}

		this.matrix = coordinates;
		xSize = coordinates.length;
		ySize = coordinates[0].length;
		nw = new boolean[xSize][ySize];
		se = new boolean[xSize][ySize];

		for (int y = 0; y < ySize; y++)
		{
			dfs(0, y, nw);
			dfs(xSize - 1, y, se);
		}

		for (int x = 0; x < xSize; x++)
		{
			dfs(x, 0, nw);
			dfs(x, ySize - 1, se);
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int x = 0; x < xSize; x++)
		{
			for (int y = 0; y < ySize; y++)
			{
				if (nw[x][y] && se[x][y])
				{
					result.add(Arrays.asList(x, y));
				}
			}
		}
		return result;
	}

	private void dfs(int x, int y, boolean[][] coordinates)
	{
		coordinates[x][y] = true;

		for (int[] dir : DIRECTIONS)
		{
			int dx = x + dir[0];
			int dy = y + dir[1];

			if (dx < 0 || dy < 0 || dx >= xSize || dy >= ySize)
			{
				continue;
			}
			if (coordinates[dx][dy])
			{
				continue;
			}
			if (this.matrix[dx][dy] < this.matrix[x][y])
			{
				continue;
			}

			dfs(dx, dy, coordinates);
		}
	}
}