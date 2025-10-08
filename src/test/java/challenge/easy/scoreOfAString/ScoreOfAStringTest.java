/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
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
package challenge.easy.scoreOfAString;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ScoreOfAStringTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put("hello", 13);
		MAP.put("zaz", 50);
		MAP.put("mynameischetan", 141);
		MAP.put("todaysleetcode", 119);
		MAP.put("questionis", 68);
		MAP.put("supereasy", 72);
		MAP.put("pleasegivedaily", 109);
		MAP.put("thistypeofquestion", 132);
		MAP.put("thankyousomuchleetcode", 171);
	}

	@Test
	void scoreOfString()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String s = entry.getKey();
			final int expected = entry.getValue();
			final int actual = ScoreOfAString.scoreOfString(s);

			String message = "Test failed on case: " + s
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}