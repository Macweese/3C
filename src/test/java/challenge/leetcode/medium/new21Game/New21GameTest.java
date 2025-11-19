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
package challenge.leetcode.medium.new21Game;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("837. New 21 Game")
class New21GameTest
{
	private static final Map<Triple<Integer, Integer, Integer>, Double> MAP = new HashMap<>();

	static
	{
		MAP.put(new ImmutableTriple<>(1, 0, 1), 1.0);
		MAP.put(new ImmutableTriple<>(6, 1, 10), 0.6);
		MAP.put(new ImmutableTriple<>(1, 1, 10), 0.1);
		MAP.put(new ImmutableTriple<>(2, 2, 10), 0.11);
		MAP.put(new ImmutableTriple<>(3, 3, 10), 0.121);
		MAP.put(new ImmutableTriple<>(4, 4, 10), 0.1331);
		MAP.put(new ImmutableTriple<>(5, 5, 10), 0.14641);
		MAP.put(new ImmutableTriple<>(10, 1, 10), 1.0);
		MAP.put(new ImmutableTriple<>(10, 7, 5), 0.94047);
		MAP.put(new ImmutableTriple<>(21, 17, 10), 0.73278);
		MAP.put(new ImmutableTriple<>(77, 61, 8746), 0.00196);
		MAP.put(new ImmutableTriple<>(654, 16, 87), 1.00000);
		MAP.put(new ImmutableTriple<>(595, 179, 373), 1.00000);
		MAP.put(new ImmutableTriple<>(108, 94, 33), 0.69446);
		MAP.put(new ImmutableTriple<>(108, 94, 379), 0.05057);
		MAP.put(new ImmutableTriple<>(179, 96, 50), 1.00000);
		MAP.put(new ImmutableTriple<>(179, 96, 879), 0.10646);
		MAP.put(new ImmutableTriple<>(917, 166, 354), 1.00000);
		MAP.put(new ImmutableTriple<>(917, 166, 1058), 0.83067);
		MAP.put(new ImmutableTriple<>(6148, 55, 987), 1.00000);
		MAP.put(new ImmutableTriple<>(5222, 4771, 8583), 0.09180);
		MAP.put(new ImmutableTriple<>(9389, 7085, 6146), 0.59076);
		MAP.put(new ImmutableTriple<>(9367, 7346, 5344), 0.62079);
		MAP.put(new ImmutableTriple<>(5483, 1895, 5252), 0.93510);
		MAP.put(new ImmutableTriple<>(7176, 11, 438), 1.00000);
		MAP.put(new ImmutableTriple<>(8715, 5088, 54), 1.00000);
	}

	@Test
	void new21Game()
	{
		for (Map.Entry<Triple<Integer, Integer, Integer>, Double> entry : MAP.entrySet())
		{
			final int n = entry.getKey().getLeft();
			final int k = entry.getKey().getMiddle();
			final int max = entry.getKey().getRight();
			final double expected = entry.getValue();
			final double actual = New21Game.new21Game(n, k, max);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"n", n,
				"k", k,
				"max", max,
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}