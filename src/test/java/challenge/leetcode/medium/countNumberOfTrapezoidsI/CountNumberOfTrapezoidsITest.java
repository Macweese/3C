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

package challenge.leetcode.medium.countNumberOfTrapezoidsI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:20 Tue 02 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3623. Count Number of Trapezoids I")
class CountNumberOfTrapezoidsITest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{1,0},{2,0},{3,0},{2,2},{3,2}}, 0);
		MAP.put(new int[][]{{0,0},{1,0},{0,1},{2,1}}, 63);
		MAP.put(new int[][]{{43829172,-90177255},{10288344,66721980},{-77412993,1824411},{92811455,54018722},{-11334455,-78001122},{66719831,-2201149},{-55009127,88172210},{9011772,-66100934},{77455221,33019877},{-99881234,44119002},{11822773,-77220019},{66281991,55100933},{-33117881,9901722},{55219902,-44811771},{88117201,77451229},{44118881,-66211772},{-21877119,33001991},{11992281,-55881177},{77118822,11829102},{33211792,88100271}}, 348);
		MAP.put(new int[][]{{1,0},{2,0},{3,0},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{2,2},{3,2}}, 3);
		MAP.put(new int[][]{{1,0},{2,0},{3,0},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{2,2},{3,2},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3}}, 0);
		MAP.put(new int[][]{{-90,-84},{818,-3},{74,-3},{-7,-3},{54,-8},{4,-8}}, 0);
		MAP.put(new int[][]{{1,0},{24,0},{31,0},{2,12},{13,2}}, 0);
		MAP.put(new int[][]{{0,0},{1,0},{0,1},{2,12}}, 0);
		MAP.put(new int[][]{{10,20},{24,-46},{57,64},{72,81}}, 0);
		MAP.put(new int[][]{{-100,100},{50,-50},{25,75},{0,0}}, 0);
	}

	@Test
	void countTrapezoids()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			int[][] points = entry.getKey();
			final int expected = entry.getValue();
			final int actual = CountNumberOfTrapezoidsI.countTrapezoids(points);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"Points", Arrays.toString(points),
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}