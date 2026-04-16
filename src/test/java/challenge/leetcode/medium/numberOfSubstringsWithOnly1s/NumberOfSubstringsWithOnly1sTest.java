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

package challenge.leetcode.medium.numberOfSubstringsWithOnly1s;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 16/11/2025, 14:16 Sun 16 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1513. Number of Substrings With Only 1s")
class NumberOfSubstringsWithOnly1sTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();
	static
	{
		MAP.put("1", 1);
		MAP.put("101", 2);
		MAP.put("011", 3);
		MAP.put("111", 6);
		MAP.put("1111", 10);
		MAP.put("11110", 10);
		MAP.put("11111", 15);
		MAP.put("011110", 10);
		MAP.put("101111", 11);
		MAP.put("0110111", 9);
		MAP.put("111111", 21);
	}

	@Test
	void testNumSub()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = NumberOfSubstringsWithOnly1s.numSub(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s",
				"Input", input,
				"Expected", expected,
				"Actual", actual
			);
			assertEquals(expected, actual, message);
		}
	}
}