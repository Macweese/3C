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
package challenge.leetcode.easy.addBinary;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
@DisplayName("67. Add Binary")
class AddBinaryTest
{
	static final Map<Map.Entry<String, String>, String> MAP = Map.of(
		Map.entry("1", "11"), "100",
		Map.entry("1010", "1011"), "10101",
		Map.entry("101101", "111101"), "1101010"
	);

	@Test
	void addBinary()
	{
		for (Map.Entry<Map.Entry<String, String>, String> entry : MAP.entrySet())
		{
			String expected = entry.getValue();
			String actual = AddBinary.addBinary(entry.getKey().getKey(), entry.getKey().getValue());
			String message = "Failed test for " + entry.getKey() + "\nExpected = " + expected + "\nActual = " + actual;

			assertEquals(expected, actual, message);
		}
	}
}