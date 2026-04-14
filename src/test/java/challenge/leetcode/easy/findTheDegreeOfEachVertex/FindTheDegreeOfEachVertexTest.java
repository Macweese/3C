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

package challenge.leetcode.easy.findTheDegreeOfEachVertex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 23:12 Tue 14 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3898. Find the Degree of Each Vertex")
class FindTheDegreeOfEachVertexTest
{
	private static final Map<int[][], int[]> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{0,1,1},{1,0,1},{1,1,0}},new int[]{2,2,2});
		MAP.put(new int[][]{{0,1,0},{1,0,0},{0,0,0}},new int[]{1,1,0});
		MAP.put(new int[][]{{0}},new int[]{0});
	}

	@Test
	void findDegrees()
	{
		for (Map.Entry<int[][], int[]> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int[] expected = entry.getValue();
			final int[] actual = FindTheDegreeOfEachVertex.findDegrees(input);

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

			assertArrayEquals(expected, actual, message);
		}
	}
}