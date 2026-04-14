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

package challenge.leetcode.hard.minimumTotalDistanceTraveled;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:42 Tue 14 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2463. Minimum Total Distance")
class MinimumTotalDistanceTraveledTest
{
	private static final Map<Input, Long> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(List.of(7),new int[][]{{0,1}}),7L);
		MAP.put(new Input(Arrays.asList(0,4,6),new int[][]{{2,2},{6,2}}),4L);
		MAP.put(new Input(Arrays.asList(1,-1),new int[][]{{-2,1},{2,1}}),2L);
		MAP.put(new Input(Arrays.asList(-40,-14,-8,1,3,5,39),new int[][]{{-34,5},{28,2},{-12,3}}),92L);
		MAP.put(new Input(Arrays.asList(9,11,99,101),new int[][]{{10,1},{7,1},{14,1},{100,1},{96,1},{103,1}}),6L);
		MAP.put(new Input(Arrays.asList(-551,-510,-344,-264,-242,-50,202,185,700,947),new int[][]{{-79,5},{-534,5}}),3172L);
		MAP.put(new Input(Arrays.asList(403625544,670355988,886437985,224430896,126139936,-477101480,-868159607,-293937930),new int[][]{{333473422,7},{912209329,7},{468372740,7},{-765827269,4},{155827122,4},{635462096,2},{-300275936,2},{-115627659,0}}),509199280L);
		MAP.put(new Input(Arrays.asList(9486709,305615257,214323605,282129380,763907021,-662831631,628054452,-132239126,50488558,381544523,-656107497,810414334,421675516,-304916551,571202823,478460906,-972398628,325714139,-86452967,660743346),new int[][]{{-755430217,18},{382914340,2},{977509386,4},{94299927,9},{32194684,16},{-371001457,2},{-426296769,13},{-284404215,8},{-421288725,0},{-893030428,2},{291827872,17},{-766616824,8},{-730172656,17},{-722387876,1},{510570520,20},{756326049,7},{-242350340,14},{6585224,19},{-173457765,15}}),925405949L);
	}

	@Test
	void minimumTotalDistance()
	{
		for (Map.Entry<Input, Long> entry : MAP.entrySet())
		{
			final List<Integer> robot = entry.getKey().robot();
			final int[][] factory = entry.getKey().factory();
			final long expected = entry.getValue();
			final long actual = MinimumTotalDistanceTraveled.minimumTotalDistance(robot, factory);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Robot", robot,
				"Factory", Arrays.deepToString(factory),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(List<Integer> robot, int[][] factory)
{

}