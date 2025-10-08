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
package challenge.easy.lengthOfLastWord;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 05/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 58
 * @Name Length of Last Word
 * @Difficulty Easy
 * @Tags string
 * @link <a href="https://leetcode.com/problems/length-of-last-word/">www.leetcode.com/58</a>
 * @Description Given a string <code>s</code> consisting of words and spaces,
 * return the <i>length of the <b>last</b> word in the string</i>.<br>
 *
 * <br>A <b>word</b> is a maximal <a href="reference_id">substring<sup>[1]</sup></a>
 * consisting of non-space characters only.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code s = "Hello World"}
 * 			<br><b>Output:</b> {@code 5}
 * 			<br><b>Explanation:</b> The last word is  with length 5.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code s = "   fly me   to   the moon  "}
 * 			<br><b>Output:</b> {@code 4}
 * 			<br><b>Explanation:</b> The last word is {@code "moon"} with length 4.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code s = "luffy is still joyboy"}
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> The last word is {@code "joyboy"} with length 6.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 <= s.length <= 10<sup>4</sup></code></li>
 *     <li><code>s</code> consists of only English letters and spaces (<code>' '</code>).</li>
 *     <li>There will be at least one word in <code>s</code>.</li>
 * </ul>
 * </p>
 *
 * <div id="reference_id"><br><sup>[1]</sup>
 * A <b>substring</b> is a contiguous <b>non-empty sequence</b> of characters within a string.
 * See also: <a href="https://en.wikipedia.org/wiki/Substring">substring (Wikipedia)</a></div>
 **/
@Slf4j
public class LengthOfLastWord
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWordBuiltInFunctions("Hello World"));
	}

	// Option 1
	// The easiest solution to this is using the built-in functions which Java offers
	// For example, string.lastIndexOf(' ') would give where the last space is in the string,
	// and where the last word begins
	// Trim the string and from there count the word length

	// Option 2
	// Loop over all characters in the string, keeping count of non-space characters
	// and resetting the count whenever a space is encountered
	// This needs to consider strings that end with spaces,
	// as the previous word may be the last, so we must keep track of the "previous" word length

	public static int lengthOfLastWord(String s)
	{
		char[] chars = s.toCharArray();
		int len = 0;
		for (int i = chars.length - 1; i >= 0; i--)
		{
			if (len > 0 && chars[i] == ' ')
			{
				break;
			}
			len = chars[i] == ' ' ? len : len + 1;
		}
		return len;
	}

	public static int lengthOfLastWordBuiltInFunctions(String s)
	{
		s = s.trim();
		s = s.substring(s.lastIndexOf(" ") + 1);
		return s.length();
	}
}
