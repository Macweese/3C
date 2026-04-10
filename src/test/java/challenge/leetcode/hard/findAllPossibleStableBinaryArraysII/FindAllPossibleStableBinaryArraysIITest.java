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

package challenge.leetcode.hard.findAllPossibleStableBinaryArraysII;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 05:06 Tue 10 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3130. Find All Possible Stable Binary Arrays II")
class FindAllPossibleStableBinaryArraysIITest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(1, 1, 2), 2);
		MAP.put(new Input(1, 2, 1), 1);
		MAP.put(new Input(3, 3, 2), 14);
		MAP.put(new Input(4, 2, 6), 15);
		MAP.put(new Input(65, 81, 22), 855528744);
		MAP.put(new Input(87, 168, 59), 854085829);
		MAP.put(new Input(677, 163, 319), 261095596);
		MAP.put(new Input(1000, 1000, 1000), 72475738);
	}

	@Test
	void numberOfStableArrays()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int zero = entry.getKey().zero();
			final int one = entry.getKey().one();
			final int limit = entry.getKey().limit();
			final int expected = entry.getValue();
			final int actual = FindAllPossibleStableBinaryArraysII.numberOfStableArrays(zero, one, limit);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Zero", zero,
				"One", one,
				"Limit", limit,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}

record Input(int zero, int one, int limit)
{
}