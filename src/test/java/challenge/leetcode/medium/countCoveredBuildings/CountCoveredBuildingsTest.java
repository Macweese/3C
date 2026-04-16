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

package challenge.leetcode.medium.countCoveredBuildings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:05 Thu 11 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3531. Count Covered Buildings")
class CountCoveredBuildingsTest
{
	private static final Map<Map.Entry<Integer, int[][]>, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(Map.entry(3, new int[][]{{1,2},{2,2},{3,2},{2,1},{2,3}}),1);
		MAP.put(Map.entry(3, new int[][]{{1,1},{1,2},{2,1},{2,2}}),0);
		MAP.put(Map.entry(5, new int[][]{{1,3},{3,2},{3,3},{3,5},{5,3}}),1);
	}

	@Test
	void countCoveredBuildings()
	{
		for (Map.Entry<Map.Entry<Integer, int[][]>, Integer> entry : MAP.entrySet())
		{
			final int n = entry.getKey().getKey();
			final int[][] buildings = entry.getKey().getValue();
			final int expected = entry.getValue();
			final int actual = CountCoveredBuildings.countCoveredBuildings(n, buildings);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s",
				"Input",
				"Buildings", Arrays.deepToString(buildings),
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