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

package utils.arrays;

import java.util.Arrays;

public class Flatten2DArray
{
	/**
	 * Flattens a nested 2-dimensional array into a single dimension.
	 * <br>
	 * <br>The nested array:<br>
	 * {@code [1][2][3]}<br>
	 * {@code [4][5][6]}<br>
	 * {@code [7][8][9]}<br>
	 * Becomes:
	 * <br>
	 * {@code [1][2][3][4][5][6][7][8][9]}
	 *
	 * @param nestedArray The nested array to flatten.
	 * @return Single dimension array.
	 */
	public static int[] twoDArrayToOneD(int[][] nestedArray)
	{
		int size = Arrays.stream(nestedArray).mapToInt(sub -> sub.length).sum();
		int[] array = new int[size];

		for (int[] i : nestedArray)
		{
			int index = 0;

			for (int j : i)
			{
				array[index] = j;
				index++;
			}
		}

		System.out.println("Old: " + Arrays.deepToString(nestedArray));
		System.out.println("New: " + Arrays.toString(array));
		return array;
	}
}
