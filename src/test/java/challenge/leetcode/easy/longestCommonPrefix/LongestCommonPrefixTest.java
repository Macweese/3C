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

import static challenge.leetcode.easy.longestCommonPrefix.LongestCommonPrefix.longestCommonPrefix;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("14. Longest Common Prefix")
class LongestCommonPrefixTest
{
	static final String[] TEST_CASE_1 = {"flower", "flow", "flight"};                          // Should return "fl"
	static final String[] TEST_CASE_2 = {"dog", "racecar", "car"};                             // Should return ""
	static final String[] TEST_CASE_3 = {"daycare", "daydream", "day"};                        // Should return "day"
	static final String[] TEST_CASE_4 = {"firefight", "fire", "fires"};                        // Should return "fire"
	static final String[] TEST_CASE_5 = {"firefight", "fire", "friend", "fires"};              // Should return "f"
	static final String[] TEST_CASE_6 = {"firefight", "fire", "friend", "fires", "table"};     // Should return ""
	static final String[] TEST_CASE_7 = {"automatic", "autozone", "automobile", "autonomous"}; // Should return "auto"

	@Test
	void longestCommonPrefixTest()
	{
		assertEquals("fl", longestCommonPrefix(TEST_CASE_1));
		assertEquals("", longestCommonPrefix(TEST_CASE_2));
		assertEquals("day", longestCommonPrefix(TEST_CASE_3));
		assertEquals("fire", longestCommonPrefix(TEST_CASE_4));
		assertEquals("f", longestCommonPrefix(TEST_CASE_5));
		assertEquals("", longestCommonPrefix(TEST_CASE_6));
		assertEquals("auto", longestCommonPrefix(TEST_CASE_7));
	}
}