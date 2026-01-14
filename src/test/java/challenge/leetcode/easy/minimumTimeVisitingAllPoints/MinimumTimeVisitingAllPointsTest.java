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

package challenge.leetcode.easy.minimumTimeVisitingAllPoints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 12:59 Tue 13 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("Minimum Time Visiting All Points")
class MinimumTimeVisitingAllPointsTest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{0,0}},0);
		MAP.put(new int[][]{{1,2},{6,2}},5);
		MAP.put(new int[][]{{3,1},{3,6}},5);
		MAP.put(new int[][]{{1,1},{4,4}},3);
		MAP.put(new int[][]{{1,1},{3,2}},2);
		MAP.put(new int[][]{{1,1},{3,4},{-1,0}},7);
		MAP.put(new int[][]{{0,0},{2,2},{0,0}},4);
		MAP.put(new int[][]{{559,511},{932,618},{-623,-443},{431,91},{838,-127},{773,-917},{-500,-910},{830,-417},{-870,73},{-864,-600},{450,535},{-479,-370},{856,573},{-549,369},{529,-462},{-839,-856},{-515,-447},{652,197},{-83,345},{-69,423},{310,-737},{78,-201},{443,958},{-311,988},{-477,30},{-376,-153},{-272,451},{322,-125},{-114,-214},{495,33},{371,-533},{-393,-224},{-405,-633},{-693,297},{504,210},{-427,-231},{315,27},{991,322},{811,-746},{252,373},{-737,-867},{-137,130},{507,380},{100,-638},{-296,700},{341,671},{-944,982},{937,-440},{40,-929},{-334,60},{-722,-92},{-35,-852},{25,-495},{185,671},{149,-452}},0);
	}

	@Test
	void minTimeToVisitAllPoints()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			final int[][] matrix = entry.getKey();
			final Integer expected = entry.getValue();
			final Integer actual = MinimumTimeVisitingAllPoints.minTimeToVisitAllPoints(matrix);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(matrix),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}