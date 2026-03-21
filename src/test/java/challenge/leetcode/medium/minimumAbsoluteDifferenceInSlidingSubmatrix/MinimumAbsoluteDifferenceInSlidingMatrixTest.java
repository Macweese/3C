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

package challenge.leetcode.medium.minimumAbsoluteDifferenceInSlidingSubmatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:42 Sat 21 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3567. Minimum Absolute Difference in Sliding Submatrix")
class MinimumAbsoluteDifferenceInSlidingMatrixTest
{
	private static final Map<Input, int[][]> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[][]{{3,-1}},1),new int[][]{{0,0}});
		MAP.put(new Input(new int[][]{{1,8},{3,-2}},2),new int[][]{{2}});
		MAP.put(new Input(new int[][]{{1,-2,3},{2,3,5}},2),new int[][]{{1,2}});
		MAP.put(new Input(new int[][]{{81274},{52541}},1),new int[][]{{0},{0}});
		MAP.put(new Input(new int[][]{{99503,-64417},{-48637,-81877},{-6967,44464}},2),new int[][]{{15780},{33240}});
		MAP.put(new Input(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},2),new int[][]{{1,1,1},{1,1,1},{1,1,1}});
		MAP.put(new Input(new int[][]{{0,-1,2,-3},{-4,5,-6,7},{8,-9,10,-11},{-12,13,-14,15}},2),new int[][]{{1,3,3},{3,3,3},{3,3,3}});
		MAP.put(new Input(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}},5),new int[][]{{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}});
	}

	@Test
	void minAbsDiff()
	{
		for (Map.Entry<Input, int[][]> entry : MAP.entrySet())
		{
			final int[][] grid = entry.getKey().grid();
			final int k = entry.getKey().k();
			final int[][] expected = entry.getValue();
			final int[][] actual = MinimumAbsoluteDifferenceInSlidingMatrix.minAbsDiff(grid, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Grid", Arrays.deepToString(grid),
				"K", k,
				"Output",
				"Expected", Arrays.deepToString(expected),
				"Actual", Arrays.deepToString(actual),
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}

record Input(int[][] grid, int k)
{

}