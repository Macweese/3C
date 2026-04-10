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

package challenge.leetcode.medium.getBiggestThreeRhombusSumInAGrid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:06 Mon 16 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1878. Get Biggest Three Rhombus Sums in a Grid")
class GetBiggestThreeRhombusSumInAGridTest
{
	private static final Map<int[][], int[]> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{5}}, new int[]{5});
		MAP.put(new int[][]{{7,7,7}}, new int[]{7});
		MAP.put(new int[][]{{1,1},{1,1}}, new int[]{1});
		MAP.put(new int[][]{{1,2,3,4,5}}, new int[]{5,4,3});
		MAP.put(new int[][]{{1},{2},{3},{4},{5}}, new int[]{5,4,3});
		MAP.put(new int[][]{{9,1,9},{1,9,1},{9,1,9}}, new int[]{9,4,1});
		MAP.put(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[]{20,9,8});
		MAP.put(new int[][]{{1,2,1},{2,100,2},{1,2,1}}, new int[]{100,8,2});
		MAP.put(new int[][]{{10,20,30,40},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, new int[]{55,44,42});
		MAP.put(new int[][]{{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}}, new int[]{228,216,211});
	}

	@Test
	void getBiggestThree()
	{
		for (Map.Entry<int[][], int[]> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int[] expected = entry.getValue();
			final int[] actual = GetBiggestThreeRhombusSumInAGrid.getBiggestThree(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(input),
				"Expected", Arrays.toString(expected),
				"Actual", Arrays.toString(actual),
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}