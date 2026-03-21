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

package challenge.leetcode.easy.flipSquareSubmatrixVertically;

/**
 * @author Administrator
 * @Created 01:07 Sat 21 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class FlipSquareSubmatrixVertically
{
	// LeetCode decided to invert the naming of the x, y variables for some reason,
	// because why follow established mathematical conventions when you can add a trivial gotcha to the problem
	// x = vertical distance (row)
	// y = horizontal distance (column)
	public static int[][] reverseSubmatrix(int[][] matrix, int x, int y, int k)
	{
		for (int r = 0; r < k >> 1; ++r)
		{
			for (int c = 0; c < k; ++c)
			{
				matrix[x + r][y + c] ^= matrix[x + k - 1 - r][y + c];
				matrix[x + k - 1 - r][y + c] ^= matrix[x + r][y + c];
				matrix[x + r][y + c] ^= matrix[x + k - 1 - r][y + c];
			}
		}
		return matrix;
	}
}
