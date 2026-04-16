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
package challenge.leetcode.hard.rearrangingFruits;

import java.util.Arrays;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("2561. Rearranging Fruits")
class RearrangingFruitsTest
{
	private static final Triple<int[], int[], Integer>[] TRIPLE = new Triple[]
		{
			new ImmutableTriple(new int[]{84, 80, 43, 8, 80, 88, 43, 14, 100, 88}, new int[]{32, 32, 42, 68, 68, 100, 42, 84, 14, 8}, 48),
			new ImmutableTriple(new int[]{2, 3, 4, 1}, new int[]{3, 2, 5, 1}, -1),
			new ImmutableTriple(new int[]{4, 2, 2, 2}, new int[]{1, 4, 1, 2}, 1),
			new ImmutableTriple(new int[]{2, 2, 100, 100}, new int[]{3, 3, 200, 200}, 5),
			new ImmutableTriple(new int[]{1, 100, 100}, new int[]{1, 200, 200}, 2),
			new ImmutableTriple(new int[]{1, 1, 1, 2, 3, 3, 5, 5, 5, 5}, new int[]{1, 2, 2, 2, 4, 4, 5, 5, 5, 5}, 3),
			new ImmutableTriple(new int[]{12, 12, 18, 18, 19, 19}, new int[]{10, 10, 11, 11, 13, 13}, 33),
			new ImmutableTriple(new int[]{95, 95, 93, 93}, new int[]{91, 91, 96, 96}, 33),
			new ImmutableTriple(new int[]{1, 1, 2, 2, 2, 4, 4, 4, 4, 3, 3, 3, 3, 4, 4, 4}, new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7}, -1),
			new ImmutableTriple(new int[]{10, 10, 20, 20, 20, 30, 40, 40, 40, 50, 50, 60, 60, 70}, new int[]{10, 10, 20, 20, 20, 30, 30, 30, 40, 50, 50, 60, 60, 70}, 20),
			new ImmutableTriple(new int[]{1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5}, new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5, 5}, 5),
			new ImmutableTriple(new int[]{7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9}, new int[]{7, 7, 7, 7, 7, 8, 8, 9, 9, 9, 9}, 7),
			new ImmutableTriple(new int[]{100, 100, 200, 200, 200, 200, 300, 400, 400, 400, 400, 400}, new int[]{100, 100, 100, 100, 200, 200, 300, 300, 300, 400, 400, 400}, 300),
			new ImmutableTriple(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5}, new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4}, 5),
			new ImmutableTriple(new int[]{5, 5}, new int[]{5, 5}, 0),
		};

	@Test
	void minCost()
	{
		String message;
		for (Triple<int[], int[], Integer> triple : TRIPLE)
		{
			final int[] a = triple.getLeft();
			final int[] b = triple.getMiddle();
			final long expected = triple.getRight();
			final long actual = RearrangingFruits.minCost(a, b);

			message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s",
				"Input",
				"Basket 1", Arrays.toString(a),
				"Basket 2", Arrays.toString(b),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}