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

package challenge.leetcode.easy.matrixSimilarityAfterCyclicShifts;

/**
 * @author Administrator
 * @Created 06:16 Fri 27 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MatrixSimilarityAfterCyclicShifts
{
	public static boolean areSimilar(int[][] matrix, int k)
	{
		for (int row = 0; row < matrix.length; row++)
		{
			int n = matrix[row].length;
			int shift = k % n;
			int sign = (row & 1) * 2 - 1;

			for (int i = 0; i < matrix[row].length; i++)
			{
				int dest = (i + sign * shift % n + n) % n;

				if (matrix[row][i] != matrix[row][dest])
				{
					return false;
				}
			}
		}

		return true;
	}
}
