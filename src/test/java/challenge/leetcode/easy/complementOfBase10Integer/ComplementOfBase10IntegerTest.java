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

package challenge.leetcode.easy.complementOfBase10Integer;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:39 Wed 11 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1009. Complement of Base 10 Integer")
class ComplementOfBase10IntegerTest
{
	private static final Map<Integer, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(0, 1);
		MAP.put(1, 0);
		MAP.put(2, 1);
		MAP.put(3, 0);
		MAP.put(4, 3);
		MAP.put(5, 2);
		MAP.put(6, 1);
		MAP.put(7, 0);
		MAP.put(8, 7);
		MAP.put(9, 6);
		MAP.put(10, 5);
		MAP.put(11, 4);
		MAP.put(12, 3);
		MAP.put(13, 2);
		MAP.put(14, 1);
		MAP.put(15, 0);
		MAP.put(16, 15);
		MAP.put(17, 14);
		MAP.put(18, 13);
		MAP.put(19, 12);
		MAP.put(20, 11);
		MAP.put(21, 10);
		MAP.put(22, 9);
		MAP.put(23, 8);
		MAP.put(24, 7);
		MAP.put(25, 6);
		MAP.put(26, 5);
		MAP.put(27, 4);
		MAP.put(28, 3);
		MAP.put(29, 2);
		MAP.put(30, 1);
		MAP.put(31, 0);
		MAP.put(32, 31);
	}

	@Test
	void bitwiseComplement()
	{
		for (Map.Entry<Integer, Integer> entry : MAP.entrySet())
		{
			final int input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = ComplementOfBase10Integer.bitwiseComplement(input);

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

			assertEquals(actual, expected, message);
		}
	}
}