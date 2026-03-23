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

package challenge.leetcode.medium.maximumNonNegativeProductInAMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:40 Mon 23 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1594. Maximum Non Negative Product in a Matrix")
class MaximumNonNegativeProductInAMatrixTest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{1,3},{0,-4}},0);
		MAP.put(new int[][]{{1,-2,1},{1,-2,1},{3,-4,1}},8);
		MAP.put(new int[][]{{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}},-1);
		MAP.put(new int[][]{{2,1,3,0,-3,3,-4,4,0,-4},{-4,-3,2,2,3,-3,1,-1,1,-2},{-2,0,-4,2,4,-3,-4,-1,3,4},{-1,0,1,0,-3,3,-2,-3,1,0},{0,-1,-2,0,-3,-4,0,3,-2,-2},{-4,-2,0,-1,0,-3,0,4,0,-3},{-3,-4,2,1,0,-4,2,-4,-1,-3},{3,-2,0,-4,1,0,1,-3,-1,-1},{3,-4,0,2,0,-2,2,-4,-2,4},{0,4,0,-3,-4,3,3,-1,-2,-2}},19215865);
		MAP.put(new int[][]{{1,-1,2,1,-1,0,0,4,3,2,0,-2,-2},{-2,3,3,-1,-1,0,0,-2,4,-3,3,0,0},{-4,-1,-1,-2,2,-1,-2,-2,0,3,-1,-4,1},{-3,4,-3,0,-3,1,-3,1,4,4,-4,-4,-2},{3,-3,1,0,-1,-4,-4,-4,3,2,2,3,3},{2,-1,-1,-4,-3,-3,4,2,3,4,4,-4,0},{4,-1,2,-3,-1,-1,-3,-4,4,4,4,-3,-1},{-3,-4,4,-2,-1,2,3,-1,2,3,4,4,-4},{-3,-1,-2,1,1,-1,-3,-4,-3,1,-3,3,-4},{2,4,4,4,-3,-3,1,-1,3,4,-1,1,4},{2,-2,0,4,-1,0,-2,4,-4,0,0,2,-3},{1,1,-3,0,-4,-4,-4,-4,0,-1,-4,-1,0},{3,-1,-3,-3,-3,-2,-1,4,-1,-2,4,2,3}},459630706);
		MAP.put(new int[][]{{-3,-3,-2,-2,-1,-3,-4,-4,-4,-2,-2,-2,-3,-1,0},{-3,-2,-1,-2,-3,-1,-1,-1,-2,-2,-1,-1,-2,-4,-3},{-2,-3,-4,-3,-3,-1,-4,-4,-2,-2,-2,-1,-4,-1,-2},{-2,-4,-3,-4,-3,-4,-2,-1,-3,-1,-2,-4,-2,-1,-3},{-1,-1,-2,-1,-3,-1,-4,-3,-3,-4,-3,-1,-4,-2,-1},{-4,-2,-1,-1,-4,-2,-4,-1,-2,-2,-1,-1,-3,-2,-1},{-2,-1,-4,-2,-3,-1,-3,-1,-3,-1,-1,-2,-1,-1,-4},{-4,-4,-2,-3,-1,-2,-2,-1,-3,-1,-2,-3,-3,-2,-1},{-1,-4,-3,-2,-2,-2,-4,-2,-4,-1,-1,-1,-3,-3,-3},{-1,-3,-1,-2,-1,-1,-2,-2,-3,-2,-3,-1,-4,-2,-1},{-1,-4,-1,-1,-2,-3,-1,-3,-3,-2,-1,-3,-3,-1,-1},{-1,-1,-4,-3,-2,-2,-4,-4,-3,-2,-1,-4,-4,-3,-2},{-3,-3,-4,-1,-3,-4,-1,-2,-4,-3,-4,-3,-3,-2,-1},{-3,-1,-1,-3,-2,-4,-2,-2,-4,-2,-3,-1,-2,-3,-3},{-1,-3,-2,-3,-2,-3,-1,-3,-2,-4,-1,-1,-3,-3,-2}},0);
	}

	@Test
	void maxProductPath()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MaximumNonNegativeProductInAMatrix.maxProductPath(input);

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

			assertEquals(actual, expected, message);
		}
	}
}