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

package challenge.leetcode.medium.minimumASCIIDeleteSumForTwoStrings;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 21:50 Sat 10 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("712. Minimum ASCII Delete Sum for Two Strings")
class MinimumASCIIDeleteSumForTwoStringsTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("sea", "eat"),231);
		MAP.put(new Input("delete", "leet"),483);
	}

	@Test
	void minimumDeleteSum()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final String s1 = entry.getKey().s1();
			final String s2 = entry.getKey().s2();
			final Integer expected = entry.getValue();
			final Integer actual = MinimumASCIIDeleteSumForTwoStrings.minimumDeleteSum(s1, s2);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s, %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", s1, s2,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(String s1, String s2)
{

}