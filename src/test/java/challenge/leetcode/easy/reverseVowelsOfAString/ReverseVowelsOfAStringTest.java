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

package challenge.leetcode.easy.reverseVowelsOfAString;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:08 Tue 14 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("345. Reverse Vowels of a String")
class ReverseVowelsOfAStringTest
{
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("ya","ya");
		MAP.put("lol","lol");
		MAP.put("fear","faer");
		MAP.put("rate","reta");
		MAP.put("maise","meisa");
		MAP.put("banjo","bonja");
		MAP.put("abcde","ebcda");
		MAP.put("coconut","cuconot");
		MAP.put("eternal","aternel");
		MAP.put("infamous","unfomais");
		MAP.put("IceCreAm","AceCreIm");
		MAP.put("leetcode","leotcede");
		MAP.put("aaaaaaaaaaaaa","aaaaaaaaaaaaa");
	}

	@Test
	void reverseVowels()
	{
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final String expected = entry.getValue();
			final String actual = ReverseVowelsOfAString.reverseVowels(input);

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