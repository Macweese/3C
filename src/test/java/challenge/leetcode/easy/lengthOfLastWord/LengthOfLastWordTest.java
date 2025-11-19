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
package challenge.leetcode.easy.lengthOfLastWord;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("58. Length of Last Word")
class LengthOfLastWordTest
{
	static final Map<String, Integer> MAP = Map.of(
		"Hello World", 5,
		"   fly me   to   the moon  ", 4,
		"luffy is still joyboy", 6,
		"a ", 1,
		" coco ", 4,
		"red red red   re", 2,
		"     ", 0
	);

	@Test
	void lengthOfLastWordTest()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			int expected = entry.getValue();
			int value = LengthOfLastWord.lengthOfLastWord(entry.getKey());
			String message = "Test case failed. Expected = " + expected + ", actual = " + value + "\nString: " + entry.getKey();
			assertEquals(expected, value, message);
		}
	}

	@Test
	void lengthOfLastWordBuiltInFunctionsTest()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			int expected = entry.getValue();
			int value = LengthOfLastWord.lengthOfLastWordBuiltInFunctions(entry.getKey());
			String message = "Test case failed. Expected = " + expected + ", actual = " + value + "\nString: " + entry.getKey();
			assertEquals(expected, value, message);
		}
	}
}