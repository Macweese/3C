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

package challenge.hard.trappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * @Created 03/10/2025, 07:16 Fri 03 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 **/
public class TrappingRainWaterII
{
	static void main(String[] args)
	{
		int[][] TEST_1 = new int[][]{
			{1, 4, 3, 1, 3, 2},
			{3, 2, 1, 3, 2, 4},
			{2, 3, 3, 2, 3, 1}
		};
		int[][] TEST_2 = new int[][]{
			{4, 4, 4, 4, 4, 4},
			{4, 3, 3, 3, 3, 4},
			{4, 3, 2, 2, 3, 4},
			{4, 3, 2, 2, 3, 4},
			{4, 3, 3, 3, 3, 4},
			{4, 4, 4, 4, 4, 4},
		};
		int[][] TEST_3 = new int[][]{
			{4, 4, 4, 4, 4, 4},
			{4, 0, 0, 0, 0, 4},
			{4, 0, 0, 0, 0, 4},
			{4, 0, 0, 0, 0, 4},
			{4, 0, 0, 0, 0, 4},
			{4, 4, 4, 4, 4, 4},
		};
		int[][] TEST_4 = new int[][]{
			{1, 1, 1, 1},
			{1, 0, 1, 1},
			{1, 0, 0, 1},
			{1, 1, 1, 1},
		};
		int[][] TEST_5 = new int[][]{
			{9, 9, 9, 9},
			{9, 0, 6, 9},
			{9, 0, 0, 9},
			{9, 9, 9, 9},
		};
		System.out.println(trapRainWater(TEST_1));
		System.out.println(trapRainWater(TEST_2));
		System.out.println(trapRainWater(TEST_3));
		System.out.println(trapRainWater(TEST_4));
		System.out.println(trapRainWater(TEST_5));
	}

	public static int trapRainWater(int[][] elevationMatrix)
	{
		int row = elevationMatrix.length;
		int col = elevationMatrix[0].length;
		if (row <= 2 || col <= 2)
		{
			return 0;
		}

		boolean[][] visited = new boolean[row][col];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

		for (int i = 0; i < row; i++)
		{
			pq.offer(new int[]{elevationMatrix[i][0], i, 0});
			pq.offer(new int[]{elevationMatrix[i][col - 1], i, col - 1});
			visited[i][0] = visited[i][col - 1] = true;
		}
		for (int i = 0; i < col; i++)
		{
			pq.offer(new int[]{elevationMatrix[0][i], 0, i});
			pq.offer(new int[]{elevationMatrix[row - 1][i], row - 1, i});
			visited[0][i] = visited[row - 1][i] = true;
		}

		int res = 0;
		int[] dxdy = {1, 0, -1, 0, 1};

		while (!pq.isEmpty())
		{
			int[] cur = pq.poll();
			int elevation = cur[0];
			int x = cur[1];
			int y = cur[2];

			for (int i = 0; i < 4; i++)
			{
				int dx = x + dxdy[i];
				int dy = y + dxdy[i + 1];
				if (dx < 0 || dx >= row || dy < 0 || dy >= col || visited[dx][dy])
				{
					continue;
				}

				visited[dx][dy] = true;
				if (elevationMatrix[dx][dy] < elevation)
				{
					res += elevation - elevationMatrix[dx][dy];
				}
				pq.offer(new int[]{Math.max(elevationMatrix[dx][dy], elevation), dx, dy});
			}
		}
		return res;
	}
}
