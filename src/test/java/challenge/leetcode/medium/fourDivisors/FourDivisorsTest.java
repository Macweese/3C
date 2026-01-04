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

package challenge.leetcode.medium.fourDivisors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 09:57 Sun 04 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1390. Four Divisors")
class FourDivisorsTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{21,4,7},32);
		MAP.put(new int[]{21,21},64);
		MAP.put(new int[]{1,2,3,4,5},0);
		MAP.put(new int[]{16,21,4,7},32);
		MAP.put(new int[]{6,8,10,14},69);
		MAP.put(new int[]{15,16,17,18},24);
		MAP.put(new int[]{33,22,26,27,28},166);
		MAP.put(new int[]{6,10,14,15,21,22,26,33,35,38,39,46,51,55,57,58,62,65,69,74},1176);
	}

	@Test
	void sumFourDivisors()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = FourDivisors.sumFourDivisors(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}