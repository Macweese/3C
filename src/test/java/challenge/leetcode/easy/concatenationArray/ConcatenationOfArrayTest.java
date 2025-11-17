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
package challenge.leetcode.easy.concatenationArray;

import challenge.leetcode.easy.concatenationArray.ConcatenationOfArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("1929. Concatenation of Array")
class ConcatenationOfArrayTest
{
	public final int[] array_1 = {1, 2, 1};
	public final int[] solved_1 = {1, 2, 1, 1, 2, 1};
	public final int[] array_2 = {1, 3, 2, 1,};
	public final int[] solved_2 = {1, 3, 2, 1, 1, 3, 2, 1};
	public final int[] array_3 = generateRandomArray();

	private int[] generateRandomArray()
	{
		int[] ints = new int[(int) (Math.random() * 1000) + 1];
		for (int i = 0; i < ints.length; i++)
		{
			ints[i] = (int) (Math.random() * 101) * ((Math.random() * 2) == 1 ? -1 : 1);
		}
		return ints;
	}

	@Test
	void getConcatenation()
	{
		assertArrayEquals(solved_1, ConcatenationOfArray.getConcatenation(array_1));
		assertArrayEquals(solved_2, ConcatenationOfArray.getConcatenation(array_2));

		for (int i = 0; i < array_3.length; i++)
		{
			assertEquals(
				ConcatenationOfArray.getConcatenation(array_3)[i],
				ConcatenationOfArray.getConcatenation(array_3)[array_3.length + i]);
		}
	}

	@Test
	void getConcatenationSystemArrayCopy()
	{
		assertArrayEquals(solved_1, ConcatenationOfArray.getConcatenationSystemArrayCopy(array_1));
		assertArrayEquals(solved_2, ConcatenationOfArray.getConcatenationSystemArrayCopy(array_2));

		for (int i = 0; i < array_3.length; i++)
		{
			assertEquals(
				ConcatenationOfArray.getConcatenationSystemArrayCopy(array_3)[i],
				ConcatenationOfArray.getConcatenationSystemArrayCopy(array_3)[array_3.length + i]);
		}
	}
}