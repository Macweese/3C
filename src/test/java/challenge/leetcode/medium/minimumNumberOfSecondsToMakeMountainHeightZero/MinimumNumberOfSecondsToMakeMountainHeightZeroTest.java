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

package challenge.leetcode.medium.minimumNumberOfSecondsToMakeMountainHeightZero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 22:19 Fri 13 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3296. Minimum Number of Seconds to Make Mountain Height Zero")
class MinimumNumberOfSecondsToMakeMountainHeightZeroTest
{
	private static final Map<Input, Long> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(1, new int[]{1}), 1L);
		MAP.put(new Input(5, new int[]{1}), 15L);
		MAP.put(new Input(4, new int[]{3, 10}), 10L);
		MAP.put(new Input(9, new int[]{2, 5}), 42L);
		MAP.put(new Input(4, new int[]{2, 1, 1}), 3L);
		MAP.put(new Input(10, new int[]{3, 2, 2, 4}), 12L);
		MAP.put(new Input(20, new int[]{1, 2, 3, 4, 5}), 30L);
		MAP.put(new Input(1000, new int[]{2, 2, 2, 2, 2}), 40200L);
		MAP.put(new Input(2, new int[]{10, 10, 10, 10, 10, 10, 10, 10}), 10L);
		MAP.put(new Input(10, new int[]{1, 1000000, 1000000, 1000000}), 55L);
		MAP.put(new Input(100000, new int[]{1000000}), 5000050000000000L);
		MAP.put(new Input(100000, new int[]{1000000, 1000000, 1000000, 1000000, 1000000}), 200010000000000L);
	}

	@Test
	void minNumberOfSeconds()
	{
		for (Map.Entry<Input, Long> entry : MAP.entrySet())
		{
			final int mountainHeight = entry.getKey().mountainHeight();
			final int[] workerTimes = entry.getKey().workerTimes();
			final long expected = entry.getValue();
			final long actual = MinimumNumberOfSecondsToMakeMountainHeightZero.minNumberOfSeconds(mountainHeight, workerTimes);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Mountain Height", mountainHeight,
				"Worker Times", Arrays.toString(workerTimes),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}

record Input(int mountainHeight, int[] workerTimes)
{

}