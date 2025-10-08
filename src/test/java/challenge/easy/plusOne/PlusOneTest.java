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
 *
 */
package challenge.easy.plusOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 05/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
class PlusOneTest
{
	static final Map<int[], int[]> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{9}, new int[]{1, 0});
		MAP.put(new int[]{1, 2, 3}, new int[]{1, 2, 4});
		MAP.put(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2});
		MAP.put(new int[]{9, 9}, new int[]{1, 0, 0});
		MAP.put(new int[]{9, 0, 9}, new int[]{9, 1, 0});
		MAP.put(new int[]{0}, new int[]{1});
		MAP.put(new int[]{0, 0}, new int[]{1});
		MAP.put(new int[]{5, 5, 9}, new int[]{5, 6, 0});
		MAP.put(new int[]{1, 0, 1, 0, 1, 0, 0}, new int[]{1, 0, 1, 0, 1, 0, 1});
		MAP.put(new int[]{1, 0, 1, 0, 1, 0, 9}, new int[]{1, 0, 1, 0, 1, 1, 0});
		MAP.put(new int[]{0, 0, 0, 0, 0, 5, 5, 5, 5, 4, 9, 9, 9, 9, 9}, new int[]{5, 5, 5, 5, 5, 0, 0, 0, 0, 0});
		MAP.put(new int[]{0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0}, new int[]{5, 5, 5, 5, 5, 0, 0, 0, 0, 1});
		MAP.put(new int[]{0, 0, 0, 0, 0, 9, 9, 9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0, 0, 0});
		MAP.put(new int[]{0, 0, 9, 9, 9, 9, 8, 9}, new int[]{9, 9, 9, 9, 9, 0});
	}

	@Test
	void plusOne()
	{
		for (Map.Entry<int[], int[]> e : MAP.entrySet())
		{
			int[] expected = e.getValue();
			int[] actual = PlusOne.plusOneCopyArrayStripLeadingZeros(e.getKey());

			assertTrue((actual[0] != 0), "Test failed: array contains leading zero(s)."
				+ "\nExpected : " + Arrays.toString(expected)
				+ "\nActual   : " + Arrays.toString(actual)
				+ "\nElement at index 0 must not be zero.");

			String message = "Test failed on case: " + Arrays.toString(e.getKey())
				+ ".\nExpected : " + Arrays.toString(expected)
				+ "\nActual   : " + Arrays.toString(actual);

			assertArrayEquals(expected, actual, message);

		}
	}
}