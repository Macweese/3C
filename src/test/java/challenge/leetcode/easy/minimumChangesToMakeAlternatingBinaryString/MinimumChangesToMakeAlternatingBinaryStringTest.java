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

package challenge.leetcode.easy.minimumChangesToMakeAlternatingBinaryString;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:37 Thu 05 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
class MinimumChangesToMakeAlternatingBinaryStringTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put("10", 0);
		MAP.put("0100", 1);
		MAP.put("1111", 2);
		MAP.put("10010100", 3);
		MAP.put("101010010", 3);
		MAP.put("10110111100", 5);
		MAP.put("01010101010111100001111000011", 9);
		MAP.put("01010101010111100000000000010", 8);
		MAP.put("01010101010111100000000000000", 9);
		MAP.put("01010101010111100000000000100", 10);
		MAP.put("010101010100101010101010101001010", 16);
		MAP.put("010011110001100110010101000101010100100101001100010010101111000", 23);
	}

	@Test
	void minOperations()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final Integer expected = entry.getValue();
			final Integer actual = MinimumChangesToMakeAlternatingBinaryString.minOperations(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", input,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}