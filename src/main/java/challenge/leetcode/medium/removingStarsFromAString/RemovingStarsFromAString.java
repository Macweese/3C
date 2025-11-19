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
package challenge.leetcode.medium.removingStarsFromAString;

import java.util.Stack;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @Created 26/03/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2390
 * @Difficulty Medium
 * @Tags String,
 * Stack,
 * Simulation
 * @link <a href="https://leetcode.com/problems/removing-stars-from-a-string/">www.leetcode.com/2390</a>
 * @Description You are given a string <code>s</code>, which contains stars <code>*</code>.<br>
 * In one operation, you can:
 * <ul>
 *     <li>Choose a star in <code>s</code>.</li>
 *     <li>Remove the closest <code>non-star</code> character to its <code>left</code>, as well as remove the star itself.</li>
 * </ul>
 * Return <i>the string after <b>all</b> stars have been removed</i>.<br><br>
 * <b>Note:</b><br>
 * <ul>
 * 		<li>The input will be generated such that the operation is always possible.</li>
 * 		<li>It can be shown that the resulting string will always be unique.</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code s = "leet**cod*e"}
 * 			<br><b>Output:</b> {@code "lecoe"}
 * 			<br><b>Explanation:</b> Performing the removals from left to right:
 * 			<ol>
 * 				<li>The closest character to the 1st star is <code>'t'</code> in "lee<b><u>t*</u></b>*cod*e".<br> <code>s</code> becomes "lee*cod*e".</li>
 * 				<li>The closest character to the 2nd star is <code>'e'</code> in "le<b><u>e*</u></b>cod*e".<br> <code>s</code> becomes "lecod*e".</li>
 * 				<li>The closest character to the 3rd star is <code>'d'</code> in "leco<b><u>d*</u></b>e".<br> <code>s</code> becomes "lecoe".</li>
 * 				<li>There are no more stars, so we return <code>"lecoe"</code>.</li>
 * 			</ol>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2</b>:
 * 			<br><b>Input:</b> {@code s = "erase*****"}
 * 			<br><b>Output:</b> {@code ""}
 * 			<br><b>Explanation:</b> The entire string is removed, so we return an empty string.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= s.length <= 105}</li>
 *     <li>{@code s }consists of lowercase English letters and stars {@code *}.</li>
 *     <li>The operation above can be performed on {@code s}.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class RemovingStarsFromAString
{
	public static String remove(String string)
	{
		char[] chars = string.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char c : chars)
		{
			if (c == '*' && !stack.empty())
			{
				stack.pop();
			}
			else
			{
				stack.push(c);
			}
		}

		return stack.stream().map(Object::toString).collect(Collectors.joining(""));
	}

	public static String removeStars(String string)
	{
		char[] chars = removeStar(string.toCharArray());
		return charArrayToString(chars);
	}

	public static char[] removeStar(char[] chars)
	{
		int n = 0;
		for (int i = chars.length - 1; i >= 0; i--)
		{
			if (chars[i] == '*')
			{
				n++;
			}
			else if (chars[i] != '*' && n > 0)
			{
				chars[i] = '*';
				n--;
			}
		}

		return chars;
	}

	public static String charArrayToString(char[] chars)
	{
		StringBuilder sb = new StringBuilder();
		for (char c : chars)
		{
			if (c == '*')
			{
				continue;
			}
			sb.append(c);
		}

		return sb.toString();
	}
}
