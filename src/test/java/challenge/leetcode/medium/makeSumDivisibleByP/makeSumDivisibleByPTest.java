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

package challenge.leetcode.medium.makeSumDivisibleByP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:02 Sun 30 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1590. Make Sum Divisible by P")
class makeSumDivisibleByPTest
{
	private static final Map<Triple<int[], Integer, Integer>, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new ImmutableTriple<>(new int[]{3,1,4,2}, 4, 6), 1);
		MAP.put(new ImmutableTriple<>(new int[]{6,3,5,2}, 4, 9), 2);
		MAP.put(new ImmutableTriple<>(new int[]{1,2,3}, 3, 3), 0);
	}

	@Test
	void minSubArray()
	{
		for (Map.Entry<Triple<int[], Integer, Integer>, Integer> entry : MAP.entrySet())
		{
			final int[] ints = entry.getKey().getLeft();
			final int size = entry.getKey().getMiddle();
			final int p = entry.getKey().getRight();
			final int expected = entry.getValue();
			final int actual = makeSumDivisibleByP.minSubArray(ints, size, p);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"ints", Arrays.toString(ints),
				"size", size,
				"p", p,
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}