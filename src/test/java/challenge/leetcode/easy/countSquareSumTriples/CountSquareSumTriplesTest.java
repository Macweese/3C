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

package challenge.leetcode.easy.countSquareSumTriples;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 11:24 Mon 08 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1925. Count Square Sum Triples")
class CountSquareSumTriplesTest
{
	private static final Map<Integer, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(1,0);
		MAP.put(5,2);
		MAP.put(10,4);
		MAP.put(19,10);
		MAP.put(148,172);
		MAP.put(150,178);
		MAP.put(193,238);
		MAP.put(239,312);
		MAP.put(249,324);
		MAP.put(250,330);
	}

	@Test
	void countTriples()
	{
		for (Map.Entry<Integer, Integer> entry : MAP.entrySet())
		{
			final int input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = CountSquareSumTriples.countTriples(input);

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