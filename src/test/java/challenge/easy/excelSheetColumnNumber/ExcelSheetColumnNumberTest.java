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
package challenge.easy.excelSheetColumnNumber;

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
class ExcelSheetColumnNumberTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put("A", 1);
		MAP.put("B", 2);
		MAP.put("AA", 27);
		MAP.put("AZ", 52);
		MAP.put("ZY", 701);
		MAP.put("FXSHRXW", 2147483647);
		MAP.put("BAF", 1384);
	}

	@Test
	void titleToNumber()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String value = entry.getKey();
			final int expected = entry.getValue();
			final int actual = ExcelSheetColumnNumber.titleToNumber(value);

			final String message = "Test failed on case: " + value
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}