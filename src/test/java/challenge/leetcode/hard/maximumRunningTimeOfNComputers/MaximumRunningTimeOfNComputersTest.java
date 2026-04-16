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

package challenge.leetcode.hard.maximumRunningTimeOfNComputers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:12 Mon 01 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2141. Maximum Running Time of N Computers")
class MaximumRunningTimeOfNComputersTest
{
	private static final Map<Map.Entry<Integer, int[]>, Long> MAP = new HashMap<>();

	static
	{
		MAP.put(Map.entry(2, new int[]{3,3,3}), 4L);
		MAP.put(Map.entry(2, new int[]{1,1,1,1}), 2L);
		MAP.put(Map.entry(3, new int[]{10,10,5,3}), 8L);
		MAP.put(Map.entry(4, new int[]{8,1,4,8}), 1L);
		MAP.put(Map.entry(2, new int[]{31,87,85,44,47,25}), 159L);
		MAP.put(Map.entry(12, new int[]{11,89,16,32,70,67,35,35,31,24,41,29,6,53,78,83}), 43L);
	}

	@Test
	void maxRunTime()
	{
		for (Map.Entry<Map.Entry<Integer, int[]>, Long> entry : MAP.entrySet())
		{
			int[] ints = entry.getKey().getValue();
			int n = entry.getKey().getKey();
			final long expected = entry.getValue();
			final long actual = MaximumRunningTimeOfNComputers.maxRunTime(n, ints);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s",
				"Input",
				"Batteries", Arrays.toString(ints),
				"n", n,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}