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

package challenge.leetcode.easy.specialPositionsInABinaryMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:44 Thu 05 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
class SpecialPositionsInABinaryMatrixTest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}, 1);
		MAP.put(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3);
	}

	@Test
	void numSpecial()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = SpecialPositionsInABinaryMatrix.numSpecial(input);

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