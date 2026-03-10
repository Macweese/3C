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

package challenge.leetcode.easy.checkIfBinaryStringHasAtMostOneSegmentOfOnes;

import challenge.leetcode.easy.minimumChangesToMakeAlternatingBinaryString.MinimumChangesToMakeAlternatingBinaryString;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 21:59 Fri 06 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1784. Check if Binary String Has at Most One Segment of Ones")
class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest
{
	private static final Map<String, Boolean> MAP = new HashMap<>();
	static
	{
		MAP.put("1001", false);
		MAP.put("110", true);
		MAP.put("11101", false);
		MAP.put("10", true);
		MAP.put("111", true);
		MAP.put("1011", false);
		MAP.put("100000000000000000000000", true);
		MAP.put("1", true);
	}

	@Test
	void checkOnesSegment()
	{
		for (Map.Entry<String, Boolean> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final boolean expected = entry.getValue();
			final boolean actual = CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", input,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}