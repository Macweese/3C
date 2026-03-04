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

package challenge.leetcode.easy.specialPositionsInABinaryMatrix;

/**
 * @author Administrator
 * @Created 00:44 Thu 05 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class SpecialPositionsInABinaryMatrix
{
	public static int numSpecial(int[][] mat)
	{
		int m = mat.length;
		int n = mat[0].length;

		int[] rowCount = new int[m];
		int[] colCount = new int[n];

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (mat[i][j] == 1)
				{
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}

		int count = 0;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1)
				{
					count++;
				}
			}
		}

		return count;
	}
}
