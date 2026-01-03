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

package challenge.leetcode.hard.numberOfWaysToPaintNx3Grid;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:21 Sat 03 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1411. Number of Ways to Paint N x 3 Grid")
class NumberOfWaysToPaintNx3GridTest
{
	private static final Map<Integer, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(1,12);
		MAP.put(2,54);
		MAP.put(3,246);
		MAP.put(4,1122);
		MAP.put(5,5118);
		MAP.put(6,23346);
		MAP.put(7,106494);
		MAP.put(8,485778);
		MAP.put(9,2215902);
		MAP.put(15,963045241);
		MAP.put(19,260858985);
		MAP.put(71,223019372);
		MAP.put(97,840530269);
		MAP.put(103,325849760);
		MAP.put(129,919795328);
		MAP.put(146,386671380);
		MAP.put(177,988337140);
		MAP.put(225,186658736);
		MAP.put(398,933036796);
		MAP.put(651,429779405);
		MAP.put(709,428335304);
		MAP.put(911,54332613);
		MAP.put(1000,650420578);
		MAP.put(1689,686335836);
		MAP.put(1111,236111302);
		MAP.put(2002,7298639);
		MAP.put(2654,269472684);
		MAP.put(3333,913865260);
		MAP.put(3961,104675913);
		MAP.put(4871,770234383);
		MAP.put(5000,30228214);
	}

	@Test
	void numOfWays()
	{
		for (Map.Entry<Integer, Integer> entry : MAP.entrySet())
		{
			final int input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = NumberOfWaysToPaintNx3Grid.numOfWays(input);

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