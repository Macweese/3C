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
package challenge.leetcode.easy.validParentheses;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("20. Valid Parentheses")
class ValidParenthesesTest
{
	private final String string_1 = "([])";
	private final String string_2 = "[";
	private final String string_3 = "((";
	private final String string_4 = "()[]{}";
	private final String string_5 = "(]";

	@Test
	void isValid()
	{
		assertTrue(ValidParentheses.isValid(string_1));
		assertTrue(ValidParentheses.isValid(string_4));

		assertFalse(ValidParentheses.isValid(string_2));
		assertFalse(ValidParentheses.isValid(string_3));
		assertFalse(ValidParentheses.isValid(string_5));
	}
}