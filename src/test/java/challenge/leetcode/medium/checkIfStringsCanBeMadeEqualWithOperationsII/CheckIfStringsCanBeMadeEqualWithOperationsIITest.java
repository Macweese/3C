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

package challenge.leetcode.medium.checkIfStringsCanBeMadeEqualWithOperationsII;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:06 Mon 30 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2840. Check if Strings Can be Made Equal With Operations II")
class CheckIfStringsCanBeMadeEqualWithOperationsIITest
{
	private static final Map<Input, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("a","a"),true);
		MAP.put(new Input("a","b"),false);
		MAP.put(new Input("ab","ba"),false);
		MAP.put(new Input("abe","bea"),false);
		MAP.put(new Input("abcd","cdab"),true);
		MAP.put(new Input("abcd","dacb"),false);
		MAP.put(new Input("abcdba","cabdab"),true);
		MAP.put(new Input("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz","cbadfegihjklmonprqtsuvwxzyabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"),false);
		MAP.put(new Input("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz","zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzyz"),false);
		MAP.put(new Input("ababababababababababababababababababababababababababababababababababababababababababababababababab","bababababababababababababababababababababababababababababababababababababababababababababababababa"),false);
	}

	@Test
	void checkStrings()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final String a = entry.getKey().a();
			final String b = entry.getKey().b();
			final boolean expected = entry.getValue();
			final boolean actual = CheckIfStringsCanBeMadeEqualWithOperationsII.checkStrings(a, b);

			String message = String.format("Test failed for case:"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"A", a,
				"B", a,
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