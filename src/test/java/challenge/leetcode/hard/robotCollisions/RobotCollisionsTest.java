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

package challenge.leetcode.hard.robotCollisions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:35 Wed 01 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2751. Robot Collisions")
class RobotCollisionsTest
{
	private static final Map<Input, List<Integer>> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{5,4,3,2,1},new int[]{2,17,9,15,10},"RRRRR"),List.of(2,17,9,15,10));
		MAP.put(new Input(new int[]{3,5,2,6},new int[]{10,10,15,12},"RLRL"),List.of(14));
		MAP.put(new Input(new int[]{1,2,5,6},new int[]{10,10,11,11},"RLRL"),List.of());
	}

	@Test
	void survivedRobotsHealth()
	{
		for (Map.Entry<Input, List<Integer>> entry : MAP.entrySet())
		{
			final int[] positions = entry.getKey().positions();
			final int[] healths = entry.getKey().healths();
			final String directions = entry.getKey().directions();
			final List<Integer> expected = entry.getValue();
			final List<Integer> actual = RobotCollisions.survivedRobotsHealths(positions, healths, directions);

			String message = String.format("Test failed for case:"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Positions", Arrays.toString(positions),
				"Healths", Arrays.toString(healths),
				"Directions", directions,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}
record Input(int[] positions, int[] healths, String directions)
{

}




