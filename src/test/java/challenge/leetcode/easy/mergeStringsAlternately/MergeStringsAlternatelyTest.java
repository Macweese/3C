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

package challenge.leetcode.easy.mergeStringsAlternately;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 17:06 Mon 13 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1768. Merge Strings Alternately")
class MergeStringsAlternatelyTest
{
	private static final Map<Input, String> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("abc","pqr"),"apbqcr");
		MAP.put(new Input("ab","pqrs"),"apbqrs");
		MAP.put(new Input("abcd","pq"),"apbqcd");
		MAP.put(new Input("fb","ce"),"fcbe");
	}

	@Test
	void mergeAlternately()
	{
		for (Map.Entry<Input, String> entry : MAP.entrySet())
		{
			final String a = entry.getKey().a();
			final String b = entry.getKey().b();
			final String expected = entry.getValue();
			final String actual = MergeStringsAlternately.mergeAlternately(a, b);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"String A", a,
				"String B", b,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(String a, String b)
{

}