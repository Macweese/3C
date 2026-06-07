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

package challenge.leetcode.easy.twoFurthestHousesWithDifferentColors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:02 Mon 20 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2078. Two Furthest Houses With Different Colors")
class TwoFurthestHousesWithDifferentColorsTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{1,1,1,6,1,1,1},3);
		MAP.put(new int[]{1,8,3,8,3},4);
		MAP.put(new int[]{0,1},1);
	}

	@Test
	void maxDistance()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = TwoFurthestHousesWithDifferentColors.maxDistance(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"ints", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}