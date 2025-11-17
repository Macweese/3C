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

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 22/03/2019,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 14
 * @Difficulty Easy
 * @Tags string,
 * trie
 * @link <a href="https://leetcode.com/problems/longest-common-prefix/">www.leetcode.com/14</a>
 * @Description Write a function to find the longest common prefix string amongst an array of strings.<br>
 * If there is no common prefix, return an empty string {@code ""}.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code strs = ["flower","flow","flight"]}
 * 			<br><b>Output:</b> {@code "fl"}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code strs = ["dog","racecar","car"]}
 * 			<br><b>Output:</b> {@code ""}
 * 			<br><b>Explanation:</b> There is no common prefix among the input strings.<br>
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li>{@code 1 <= strs.length <= 200}</li>
 *     <li>{@code 0 <= strs[i].length <= 200}</li>
 *     <li>{@code strs[i]} consists of only lowercase English letters if it is non-empty.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class LongestCommonPrefix
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

//		log.info("Common prefix: {}", longestCommonPrefix(new String[]{"test dummy", "test", "tester", "test taker"}));
//		log.info("Common prefix: {}", longestCommonPrefix(new String[]{"fan", "fire", "friend"}));
	}

	public static String longestCommonPrefix(String[] strings)
	{
		Arrays.sort(strings);
		int len = Math.min(strings[0].length(), strings[strings.length - 1].length());

		for (int i = 0; i < len; i++)
		{
			if (strings[0].charAt(i) != strings[strings.length - 1].charAt(i))
			{
				return strings[0].substring(0, i);
			}
		}
		return strings[0].substring(0, len);
	}
}
