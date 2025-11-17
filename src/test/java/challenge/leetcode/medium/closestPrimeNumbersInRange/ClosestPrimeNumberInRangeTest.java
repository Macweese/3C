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
package challenge.leetcode.medium.closestPrimeNumbersInRange;

import challenge.leetcode.medium.closestPrimeNumbersInRange.Solution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("2523. Closest Prime Numbers in Range\n")
class ClosestPrimeNumberInRangeTest
{
	static final Map<Map.Entry<Integer, Integer>, int[]> MAP = new HashMap<>();

	static
	{
		MAP.put(Map.entry(2, 3), new int[]{2, 3});
		MAP.put(Map.entry(4, 6), new int[]{-1, -1});
		MAP.put(Map.entry(10, 19), new int[]{11, 13});
		MAP.put(Map.entry(19, 31), new int[]{29, 31});
		MAP.put(Map.entry(1, 100000), new int[]{2, 3});
		MAP.put(Map.entry(84084, 407043), new int[]{84179, 84181});
//		MAP.put(Map.entry(84084, 407043), new int[]{92789, 92791});
	}

	@Test
	void closestPrimes()
	{
		for (Map.Entry<Map.Entry<Integer, Integer>, int[]> entry : MAP.entrySet())
		{
			int l = entry.getKey().getKey();
			int r = entry.getKey().getValue();
			int[] expected = entry.getValue();
//			int[] actual = ClosestPrimeNumberInRange.closestPrimes(l, r);
			int[] actual = Solution.closestPrimes(l, r);

			String message = "Test case failed for LEFT=" + l + ", RIGHT=" + r
				+ "\nExpected : " + Arrays.toString(expected)
				+ "\nActual   : " + Arrays.toString(actual);

			assertArrayEquals(expected, actual, message);
		}
	}
}