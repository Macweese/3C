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
package challenge.leetcode.medium.bitwiseOROfSubarrays;

import challenge.leetcode.medium.bitwiseOROfSubarrays.BitwiseOROfSubarrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("898. Bitwise OR of Subarrays")
class BitwiseOROfSubarraysTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{1}, 1);
		MAP.put(new int[]{1, 1, 2}, 3);
		MAP.put(new int[]{1, 2, 4}, 6);
		MAP.put(new int[]{1, 10, 15, 30}, 6);
		MAP.put(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 1);
		MAP.put(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1);
		MAP.put(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 22);
		MAP.put(new int[]{8, 4, 2, 1, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384}, 120);
		MAP.put(new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, 1);
		MAP.put(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31}, 16);
		MAP.put(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 2);
		MAP.put(new int[]{536870912, 268435456, 134217728, 67108864, 33554432, 16777216, 8388608, 4194304, 2097152, 1048576}, 55);
	}

	@Test
	void subarrayBitwiseORs()
	{
		String message = "";
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] ints = entry.getKey();
			final int expected = entry.getValue();
			final int actual = BitwiseOROfSubarrays.subarrayBitwiseORs(ints);

			message = "Test failed on case: " + Arrays.toString(ints)
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}