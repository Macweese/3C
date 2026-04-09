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

package challenge.leetcode.hard.maximumWallsDestroyedByRobots;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 08:26 Fri 03 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3661. Maximum Walls Destroyed by Robots")
class MaximumWallsDestroyedByRobotsTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{4},new int[]{3},new int[]{1,10}),1);
		MAP.put(new Input(new int[]{1,2},new int[]{100,1},new int[]{10}),0);
		MAP.put(new Input(new int[]{10,2},new int[]{5,1},new int[]{5,2,7}),3);
		MAP.put(new Input(new int[]{1,12,13,18,23,48,70,80},new int[]{5,1,9,3,4,12,3,9},new int[]{1,2,3,6,7,8,10,11,17,19,20,23,25,26,28,30,31,34,38,39}),13);
		MAP.put(new Input(new int[]{1,3,6,7,8,17,19,20,21,22,23,25,27,31,32,34,36,37,38,39,40,42,43,44,45},new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},new int[]{3,6,7,8,9,10,11,18,20,21,22,24,25,27}),12);
		MAP.put(new Input(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},new int[]{6,18,7,10,26,6,26,13,9,6,16,7,6,24,12,26,30,7,17,29},new int[]{8592,12919,13694,20263,20735,28686,43135,49903,51343,56808,59799,60439,76226,82625,84866}),0);
		MAP.put(new Input(new int[]{3,10,13,15,16,17,18,20,25,27,29,30,36,42,44,48,50,51,58,59,60,64,65,67,68,69,71,75,78,83,86,89,92},new int[]{2,1,1,2,2,1,2,1,2,2,2,2,1,2,2,2,2,2,1,2,1,1,1,2,2,1,1,2,2,1,2,2,1},new int[]{4,18,34,40,43,44,49,50,51,53,70}),10);
		MAP.put(new Input(new int[]{2,5,6,9,10,11,15,17,18,22,23,24,25,26,27,28,31,32,34,35,38,41,43,45,46,49,51,53,55,57,59,61,63},new int[]{4,3,1,8,4,3,9,3,2,5,9,2,5,6,9,3,8,6,4,7,8,8,4,4,3,6,6,2,9,3,2,4,8},new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}),16);
		MAP.put(new Input(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33},new int[]{1,2,1,3,6,5,2,3,5,5,5,3,5,3,2,1,1,1,3,4,4,1,4,1,1,3,2,2,5,3,2,3,6},new int[]{1,2,8,9,10,11,12,14,18,19,24,25,27,30,31,32,33,34,35,36,38,40,42,43}),21);
		MAP.put(new Input(new int[]{3,4,8,9,10,11,12,13,14,15,17,23,26,30,32,34,36,37,39,40,42,43,44,45,53,55,56,57,58,60,61,63,66,69,70,72,73,74},new int[]{8,7,4,8,9,5,2,4,5,2,6,9,5,9,5,3,7,6,9,2,8,7,4,3,5,1,7,5,1,3,5,3,5,4,8,7,6,4},new int[]{6,9,20,21,22,23,26,28,30,41,50,52,58,60,75}),15);
		MAP.put(new Input(new int[]{63,56,40,45,4,9,44,69,55,26,73,15,12,60,43,39,37,74,36,34,13,23,66,14,11,42,72,3,57,10,53,8,70,17,58,61,30,32},new int[]{8,7,4,8,9,5,2,4,5,2,6,9,5,9,5,3,7,6,9,2,8,7,4,3,5,1,7,5,1,3,5,3,5,4,8,7,6,4},new int[]{6,22,50,52,20,9,23,75,26,21,60,58,41,28,30}),15);
		MAP.put(new Input(new int[]{2,4,7,8,9,10,15,17,20,22,23,24,25,26,32,33,34,37,38,39,43,45,46,49,50,52,60,68,69},new int[]{3,1,1,1,3,2,3,3,2,3,3,3,3,3,1,1,2,2,3,1,1,2,1,2,1,1,2,1,3},new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38}),36);
	}

	@Test
	void maxWalls()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[] robots = entry.getKey().robots();
			final int[] distance = entry.getKey().distance();
			final int[] walls = entry.getKey().walls();
			final int expected = entry.getValue();
			final int actual = MaximumWallsDestroyedByRobots.maxWalls(robots, distance, walls);

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
				"Robots", Arrays.toString(robots),
				"Distance", Arrays.toString(distance),
				"Walls", Arrays.toString(walls),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}
record Input(int[] robots, int[] distance, int[] walls)
{

}