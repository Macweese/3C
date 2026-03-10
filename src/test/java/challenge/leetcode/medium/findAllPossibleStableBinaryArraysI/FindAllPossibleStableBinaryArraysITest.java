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

package challenge.leetcode.medium.findAllPossibleStableBinaryArraysI;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 21:40 Mon 09 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3129. Find All Possible Stable Binary Arrays I")
class FindAllPossibleStableBinaryArraysITest
{
	private static final Map<Input, Integer> MAP = new HashMap();

	static
	{
		MAP.put(new Input(1, 1, 2), 2);
		MAP.put(new Input(1, 2, 1), 1);
		MAP.put(new Input(3, 3, 2), 14);
		MAP.put(new Input(59, 80, 92), 234333249);
		MAP.put(new Input(73, 71, 90), 32906800);
		MAP.put(new Input(72, 74, 53), 396816249);
		MAP.put(new Input(71, 80, 23), 647682807);
		MAP.put(new Input(74, 79, 4), 248636042);
		MAP.put(new Input(80, 75, 76), 28046756);
		MAP.put(new Input(77, 80, 94), 694148718);
		MAP.put(new Input(79, 80, 24), 729658037);
		MAP.put(new Input(200, 200, 25), 292126791);
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
			final int actual = FindAllPossibleStableBinaryArraysI.numberOfStableArrays(zero, one, limit);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Zero", zero,
				"One", one,
				"Limit", limit,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}

record Input(int zero, int one, int limit)
{
}