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
package challenge.easy.palindromeNumber;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class PalindromeNumberTest
{
	static final Map<Integer, Boolean> PALINDROME_MAP = Map.ofEntries(
		Map.entry(121, Boolean.TRUE),
		Map.entry(-121, Boolean.FALSE),
		Map.entry(10, Boolean.FALSE),
		Map.entry(1001, Boolean.TRUE),
		Map.entry(999, Boolean.TRUE),
		Map.entry(123454321, Boolean.TRUE),
		Map.entry(0, Boolean.TRUE),
		Map.entry(9, Boolean.TRUE),
		Map.entry(-1111, Boolean.FALSE),
		Map.entry(16841968, Boolean.FALSE),
		Map.entry(Integer.MIN_VALUE, Boolean.FALSE),
		Map.entry(Integer.MAX_VALUE, Boolean.FALSE),
		Map.entry(59844895, Boolean.TRUE)
	);

	@Test
	void isPalindrome()
	{
		for (Map.Entry<Integer, Boolean> keyset : PALINDROME_MAP.entrySet())
		{
			assertSame(keyset.getValue(), PalindromeNumber.isPalindrome(keyset.getKey()));
		}
	}
}