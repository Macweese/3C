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

package challenge.leetcode.easy.determineWhetherMatrixCanBeObtainedByRotation;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 06:59 Sun 22 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class DetermineWhetherMatrixCanBeObtainedByRotation
{
	public static boolean findRotation(int[][] matrix, int[][] target)
	{
		for (int r = 0; r < 4; r++)
		{
			if (Arrays.deepEquals(matrix, target))
			{
				return true;
			}
			matrix = rotateMatrix(matrix);
		}

		return false;
	}

	private static int[][] rotateMatrix(int[][] matrix)
	{
		int n = matrix.length;
		int[][] rotated = new int[n][n];

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				rotated[j][n - 1 - i] = matrix[i][j];
			}
		}
		return rotated;
	}

	public static boolean findBranchless(int[][] matrix, int[][] target)
	{
		int n = matrix.length;
		int matches = 0b1111;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int val = matrix[i][j];
				matches &= ~(((val ^ target[i][j]) != 0 ? 1 : 0));
				matches &= ~(((val ^ target[j][n - 1 - i]) != 0 ? 1 : 0) << 1);
				matches &= ~(((val ^ target[n - 1 - i][n - 1 - j]) != 0 ? 1 : 0) << 2);
				matches &= ~(((val ^ target[n - 1 - j][i]) != 0 ? 1 : 0) << 3);
			}
		}

		return matches != 0;
	}

	public static boolean findFast(int[][] matrix, int[][] target)
	{
		int n = matrix.length;

		boolean rotate0 = true;
		boolean rotate90 = true;
		boolean rotate180 = true;
		boolean rotate270 = true;

		for (int i = 0; i < n && (rotate0 || rotate90 || rotate180 || rotate270); i++)
		{
			for (int j = 0; j < n && (rotate0 || rotate90 || rotate180 || rotate270); j++)
			{
				int val = matrix[i][j];
				rotate0 &= val == target[i][j];
				rotate90 &= val == target[j][n - 1 - i];
				rotate180 &= val == target[n - 1 - i][n - 1 - j];
				rotate270 &= val == target[n - 1 - j][i];
			}
		}

		return rotate0 || rotate90 || rotate180 || rotate270;
	}
}
