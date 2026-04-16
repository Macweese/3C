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

package challenge.leetcode.medium.countCollisionsOnARoad;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:23 Thu 04 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2211. Count Collisions on a Road")
class CountCollisionsOnARoadTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put("RLRSLL",5);
		MAP.put("LLRR",0);
		MAP.put("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR",20);
		MAP.put("LLRLRLLSLRLLSLSSSS",10);
	}

	@Test
	void countCollisions()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = CountCollisionsOnARoad.countCollisions(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s",
				"Input", input,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}