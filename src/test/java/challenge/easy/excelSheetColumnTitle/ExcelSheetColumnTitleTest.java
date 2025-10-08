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
 *
 */
package challenge.easy.excelSheetColumnTitle;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 20/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
class ExcelSheetColumnTitleTest
{

	private static final Map<Integer, String> MAP = new HashMap<>();

	static
	{
		MAP.put(1, "A");
		MAP.put(2, "B");
		MAP.put(27, "AA");
		MAP.put(52, "AZ");
		MAP.put(701, "ZY");
		MAP.put(2147483647, "FXSHRXW");
		MAP.put(1384, "BAF");
	}

	@Test
	void convertToTitle()
	{
		for (Map.Entry<Integer, String> entry : MAP.entrySet())
		{
			final int value = entry.getKey();
			final String expected = entry.getValue();
			final String actual = ExcelSheetColumnTitle.convertToTitle(value);

			final String message = "Test failed on case: " + value
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}