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

package challenge.leetcode.medium.stringCompression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 09:30 Tue 14 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("443. String Compression")
class StringCompressionTest
{
	private static final Map<char[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new char[]{'a'},1);
		MAP.put(new char[]{'#', '#', '#'},2);
		MAP.put(new char[]{'a','a','b','b','c','c','c'},6);
		MAP.put(new char[]{'$','$','$','#','#','#','#','#','$','$'},6);
		MAP.put(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'},4);
		MAP.put(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','a','a'},6);
		MAP.put(new char[]{'b','l','l','l','l','l','l','4','4','W','W','&','d','d','d','@','D','D','.','.','.','8','8','8','U','V','>','J','J','k','H','H','=','l','[','[','[','[','[','[','[','a','a','\'','<','[','[','y','V','l','l','\'','$','E','`','v','k','E','E','t','t','t','t','t','=','=','0','C','a','l','l','l','r','R','M','M','c','c','c','A','A','S','9','9','9','9',')',')','\\','s','\\','\\','y','W','W','W','J','J','J','J','6','6','<','<','E','u','e','e','e','e','e','e','e','e','e','9','9','9','9','R','8','?','F','3','&','&','&','&','f','%','%','2','2','2',')',')',')','J','p','|','D','D','D','s','t','V','V','?','^','^','S','3','3','3','3','h','*','|','|','b','b','a','a','a','r','r','r','r','J','.','^','^','~','g',':',':',':','(','4','4','4','4','w','w','w','w','w','w','w','C','?','=','d','L',':','0','0','c','w','w','w','w','w','w','{','{','t','k','k','k','&','&','&','h','j','j','j','0','3','l',';',';',';',';',';','.','.','.','%','1','1','1','l','9','?','?','?','t','>','E','N','N','@','>','.','.','I','a','a','a','a','B','7','7','{','o','o','-','+','+','+','+','o','o','}','B','B','r','r','r','q','4','4','4','9','W','W','W','W','W','\'','\'','\'','g','J','(','(','(','(','t','t','?',';','g','g','g','0',']',']',']'},224);
	}

	@Test
	void compress()
	{
		for (Map.Entry<char[], Integer> entry : MAP.entrySet())
		{
			final char[] input = entry.getKey();
			final long expected = entry.getValue();
			final long actual = StringCompression.compress(input);

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