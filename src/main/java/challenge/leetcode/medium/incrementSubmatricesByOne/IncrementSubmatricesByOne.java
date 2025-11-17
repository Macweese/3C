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

package challenge.leetcode.medium.incrementSubmatricesByOne;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 14/11/2025, 05:56 Fri 14 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class IncrementSubmatricesByOne
{
	static void main(String[] args)
	{
		rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}});
		solution(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}});
	}

	public static int[][] solution(int n, int[][] queries)
	{
		int[][] diff = new int[n + 1][n + 1];
		int[][] matrix = new int[n][n];

		for (int[] query : queries)
		{
			int x1 = query[0];
			int y1 = query[1];
			int x2 = query[2];
			int y2 = query[3];
			diff[x1][y1]++;
			diff[x2 + 1][y1]--;
			diff[x1][y2 + 1]--;
			diff[x2 + 1][y2 + 1]++;
		}

		matrix[0][0] = diff[0][0];
		for (int y = 1; y < n; ++y)
		{
			matrix[0][y] = diff[0][y] + matrix[0][y - 1];
		}

		for (int x = 1; x < n; ++x)
		{
			matrix[x][0] = diff[x][0] + matrix[x - 1][0];
		}

		for (int x = 1; x < n; ++x)
		{
			for (int y = 1; y < n; ++y)
			{
				int above = matrix[x - 1][y];
				int left = matrix[x][y - 1];
				int diag = matrix[x - 1][y - 1];
				matrix[x][y] = diff[x][y] + above + left - diag;
			}
		}

		return matrix;
	}

	public static int[][] rangeAddQueries(int n, int[][] queries)
	{
		int[][] matrix = new int[n][n];

		for (int query = 0; query < queries.length; ++query)
		{
			int x1 = queries[query][0];
			int y1 = queries[query][1];
			int x2 = queries[query][2];
			int y2 = queries[query][3];
			for (int x = x1; x <= x2; ++x)
			{
				for (int y = y1; y <= y2; ++y)
				{
					matrix[x][y]++;
				}
			}
		}
		for (int[] row : matrix)
		{
			System.out.println(Arrays.toString(row));
		}

		return matrix;
	}
}
