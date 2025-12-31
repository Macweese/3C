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

package challenge.leetcode.medium.magicSquaresInGrid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:37 Tue 30 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("840. Magic Squares In Grid")
class MagicSquaresInGridTest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{8}},0);
		MAP.put(new int[][]{{1,1,1},{1,1,1},{1,1,1}},0);
		MAP.put(new int[][]{{7,0,5},{2,4,6},{3,8,1}},0);
		MAP.put(new int[][]{{4,7,8},{9,5,1},{2,3,6}},0);
		MAP.put(new int[][]{{5,5,5},{5,5,5},{5,5,5}},0);
		MAP.put(new int[][]{{10,3,5},{1,6,11},{7,9,2}},0);
		MAP.put(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}},1);
		MAP.put(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2},{4,3,8,1},{1,6,7,5}},1);
		MAP.put(new int[][]{{4,3,8,4,3},{9,5,1,9,5},{2,7,6,2,7},{4,3,8,4,3},{9,5,1,9,5},{2,7,6,2,7}},2);
		MAP.put(new int[][]{{4,3,8,4,3,8},{9,5,1,9,5,1},{2,7,6,2,7,6},{4,3,8,4,3,8},{9,5,1,9,5,1},{2,7,6,2,7,6},{4,3,8,4,3,8},{9,5,1,9,5,1},{2,7,6,2,7,6}},6);
		MAP.put(new int[][]{{4,3,8,1,6,7},{9,5,1,7,8,9},{2,7,6,4,9,1},{8,1,6,4,3,8},{3,7,9,2,8,1},{4,3,8,1,6,7},{9,5,1,7,8,9},{2,7,6,4,9,1},{8,1,6,4,3,8},{1,6,7,8,9,2}},2);
		MAP.put(new int[][]{{4,3,8,4,3,8,4,3,8},{9,5,1,9,5,1,9,5,1},{2,7,6,2,7,6,2,7,6},{8,1,6,4,3,8,4,3,8},{3,7,9,2,8,1,9,5,1},{4,3,8,1,6,7,2,7,6},{9,5,1,7,8,9,8,1,6},{2,7,6,4,9,1,3,7,9},{8,1,6,4,3,8,4,3,8},{3,7,9,2,8,1,9,5,1}},5);
		MAP.put(new int[][]{{9,9,5,1,9,5,5,7,2,5},{9,1,8,3,4,6,7,2,8,9},{4,1,1,5,9,1,5,9,6,4},{5,5,6,7,2,8,3,4,0,6},{1,9,1,8,3,1,4,2,9,4},{2,8,6,4,2,7,3,2,7,6},{9,2,5,0,7,8,2,9,5,1},{2,1,4,4,7,6,2,4,3,8},{1,2,5,3,0,5,10,8,5,2},{6,9,6,8,8,4,3,6,0,9}},3);
		MAP.put(new int[][]{{9,9,5,1,9,5,5,7,2,5},{9,1,8,3,4,6,7,2,8,9},{4,1,1,5,9,1,5,9,6,4},{5,5,6,7,2,8,3,4,0,6},{1,9,1,8,3,1,4,2,9,4},{2,8,6,4,2,7,3,2,7,6},{9,2,5,0,7,8,2,9,5,1},{2,1,4,4,7,6,2,4,3,8},{1,2,5,3,0,5,10,8,5,2},{6,9,6,8,8,4,3,6,0,9}},3);
	}

	@Test
	void numMagicSquaresInside()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MagicSquaresInGrid.numMagicSquaresInside(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}