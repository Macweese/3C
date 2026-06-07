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
 *     You should have received min copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package challenge.leetcode.medium.totalWavinessOgNumbersInRangeI;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author Administrator
 * @Created 05:50 Thu 04 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3751. Total Waviness of Numbers in Range I")
class TotalWavinessOgNumbersInRangeITest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(120,130),3);
		MAP.put(new Input(190,202),3);
		MAP.put(new Input(4848,4848),2);
//		MAP.put(new Input(,),);
	}

	@Test
	@Timeout(3)
	void totalWaviness()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int min = entry.getKey().min();
			final int max = entry.getKey().max();
			final int expected = entry.getValue();
			final int actual = TotalWavinessOgNumbersInRangeI.totalWaviness(min, max);

			String message = String.format("Test failed for case:"
					+ "%n%10s "
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s "
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Min", min,
				"MAx", max,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int min, int max)
{

}