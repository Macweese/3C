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

package challenge.leetcode.easy.checkIfStringsCanBeMadeEqualWithOperationsI;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:56 Sun 29 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2839. Check if Strings Can be Made Equal With Operations I")
class CheckIfStringsCanBeMadeEqualWithOperationsITest
{
	private static final Map<Input, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("abcd","cdab"),true);
		MAP.put(new Input("abcd","dacb"),false);
		MAP.put(new Input("gckx","ckgx"),false);
		MAP.put(new Input("gpfu","gupf"),false);
		MAP.put(new Input("drih","dhri"),false);
		MAP.put(new Input("rzvo","rvzo"),false);
		MAP.put(new Input("jsvj","ravc"),false);
		MAP.put(new Input("rihr","irrh"),false);
		MAP.put(new Input("hhlz","hzhl"),false);
		MAP.put(new Input("wyjh","wjyh"),false);
		MAP.put(new Input("zzon","zozn"),false);
	}

	@Test
	void canBeEqual()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final String a = entry.getKey().a();
			final String b = entry.getKey().b();
			final boolean expected = entry.getValue();
			final boolean actual = CheckIfStringsCanBeMadeEqualWithOperationsI.canBeEqual(a, b);

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
record Input (String a, String b)
{

}


