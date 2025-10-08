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

public class RemoveDuplicates
{
	public static int[] removeDuplicatesFromArray(int... ints)
	{
		int[] unique = Arrays.stream(ints).distinct().toArray();

		System.out.println("Duplicates: " + Arrays.toString(ints));
		System.out.println("Unique: " + Arrays.toString(unique));

		return unique;
	}
}
