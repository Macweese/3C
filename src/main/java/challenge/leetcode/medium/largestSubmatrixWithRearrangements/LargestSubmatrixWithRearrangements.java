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

package challenge.leetcode.medium.largestSubmatrixWithRearrangements;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 06:04 Tue 17 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class LargestSubmatrixWithRearrangements
{
	public static int largestSubmatrix(int[][] matrix)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		int maxArea = 0;

		for (int i = 1; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == 1)
				{
					matrix[i][j] += matrix[i - 1][j];
				}
			}
		}

		for (int i = 0; i < m; i++)
		{
			int[] row = matrix[i].clone();
			Arrays.sort(row);

			for (int j = 0; j < n; j++)
			{
				int height = row[j];
				int width = n - j;
				maxArea = Math.max(maxArea, height * width);
			}
		}

		return maxArea;
	}
}
