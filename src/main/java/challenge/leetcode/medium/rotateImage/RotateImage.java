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

package challenge.leetcode.medium.rotateImage;

/**
 * @author Administrator
 * @Created 07:06 Mon 04 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class RotateImage
{
	public static void rotate(int[][] matrix)
	{
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = temp;
			}
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < i; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
