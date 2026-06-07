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

package challenge.leetcode.easy.minimumElementAfterReplacementWithDigitSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author Administrator
 * @Created 22:54 Fri 29 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3300. Minimum Element After Replacement With Digit Sum")
class MinimumElementAfterReplacementWithDigitSumTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{10,12,13,14},1);
		MAP.put(new int[]{1,2,3,4},1);
		MAP.put(new int[]{999,19,199},10);
	}

	@Test
	@Timeout(3)
	void minElement()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MinimumElementAfterReplacementWithDigitSum.minElement(input);

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
