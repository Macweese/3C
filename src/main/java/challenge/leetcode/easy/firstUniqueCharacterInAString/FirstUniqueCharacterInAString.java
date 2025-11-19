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
package challenge.leetcode.easy.firstUniqueCharacterInAString;

import java.util.HashMap;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 387
 * @Name First Unique Character in a String
 * @Difficulty Easy
 * @Tags hash table
 * string
 * queue
 * counting
 * @link <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">www.leetcode.com/387</a>
 * @Description Given a string <code>s</code>,
 * find the <b>first</b> non-repeating character in it and return its index.
 * If it <b>does not</b> exist, return <code>-1</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code s = "leetcode"}
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> The character <code>'l'</code> at index 0 is the first character that does not occur at any other index.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code s = "loveleetcode"}
 * 			<br><b>Output:</b> {@code 2}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code s = "aabb"}
 * 			<br><b>Output:</b> {@code -1}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; n &le; 10<sup>5</sup></code></li>
 * 		<li><code>s</code> consists of only lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class FirstUniqueCharacterInAString
{
	public static int firstUniqChar(String s)
	{
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
		{
			map.computeIfPresent(s.charAt(i), (k, v) -> v = -1);
			map.putIfAbsent(s.charAt(i), i);
		}

		return map.values().stream()
			.filter(i -> i >= 0)
			.min(Integer::compareTo)
			.orElse(-1);
	}
}
