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

package challenge.leetcode.hard.maximizeSpanningTreeStabilityWithUpgrades;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 16:50 Thu 12 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3600. Maximize Spanning Tree Stability with Upgrades")
class MaximizeSpanningTreeStabilityWithUpgradesTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(3, new int[][]{{0, 1, 2, 1}, {1, 2, 3, 0}}, 1), 2);
		MAP.put(new Input(3, new int[][]{{0, 1, 4, 0}, {1, 2, 3, 0}, {0, 2, 1, 0}}, 2), 6);
		MAP.put(new Input(3, new int[][]{{0, 1, 1, 1}, {1, 2, 1, 1}, {2, 0, 1, 1}}, 0), -1);
//		MAP.put(new Input(,new int[][]{{},{}},),);
//		MAP.put(new Input(,new int[][]{{},{}},),);
//		MAP.put(new Input(,new int[][]{{},{}},),);
	}

	@Test
	void maxStability()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int n = entry.getKey().n();
			final int[][] edges = entry.getKey().edges();
			final int k = entry.getKey().k();
			final int expected = entry.getValue();
			final int actual = MaximizeSpanningTreeStabilityWithUpgrades.maxStability(n, edges, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"N", n,
				"Edges", Arrays.deepToString(edges),
				"K", k,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}

record Input(int n, int[][] edges, int k)
{

}