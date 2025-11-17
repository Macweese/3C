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
package challenge.leetcode.easy.longestCommonPrefix;

import challenge.leetcode.easy.longestCommonPrefix.LongestCommonPrefix;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("14. Longest Common Prefix")
class LongestCommonPrefixTest
{
	static final String[] STRINGS_1 = {"flower", "flow", "flight"};                         // Should return "fl"
	static final String[] STRINGS_2 = {"dog", "racecar", "car"};                            // Should return "" empty string
	static final String[] STRINGS_3 = {"daycare", "daydream", "day"};                       // Should return "day"
	static final String[] STRINGS_4 = {"firefight", "fire", "fires"};                       // Should return "fire"
	static final String[] STRINGS_5 = {"firefight", "fire", "friend", "fires"};              // Should return "f"
	static final String[] STRINGS_6 = {"firefight", "fire", "friend", "fires", "table"};      // Should return "" empty string
	static final String[] STRINGS_7 = {"automatic", "autozone", "automobile", "autonomous"}; // Should return "auto"

	@Test
	void longestCommonPrefix()
	{
		assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(STRINGS_1));
		assertEquals("", LongestCommonPrefix.longestCommonPrefix(STRINGS_2));
		assertEquals("day", LongestCommonPrefix.longestCommonPrefix(STRINGS_3));
		assertEquals("fire", LongestCommonPrefix.longestCommonPrefix(STRINGS_4));
		assertEquals("f", LongestCommonPrefix.longestCommonPrefix(STRINGS_5));
		assertEquals("", LongestCommonPrefix.longestCommonPrefix(STRINGS_6));
		assertEquals("auto", LongestCommonPrefix.longestCommonPrefix(STRINGS_7));
	}
}