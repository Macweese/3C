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

import java.util.Map;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @Created 23/03/2019,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 20
 * @Difficulty Easy
 * @Tags string
 * stack
 * @link <a href="https://leetcode.com/problems/valid-parentheses/">www.leetcode.com/20</a>
 * @Description Given a string <code>s</code> containing just the characters <br>
 * <code>'('</code>, <code>')'</code>, <code>'&#123;'</code>, <code>'&#125;'</code>, <code>'['</code> and <code>']'</code>, <br>
 * determine if the input string is valid.<br><br>
 * <p>
 * An input string is valid if:
 * <ol>
 *     <li>Open brackets must be closed by the same types of brackets.</li>
 *     <li>Open brackets must be closed in the correct order.</li>
 *     <li>Every close bracket has a corresponding open bracket of the same types.</li>
 * </ol>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code s = "()"}
 * 			<br><b>Output:</b> {@code true}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code s = "()[]{}"}
 * 			<br><b>Output:</b> {@code true}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code s = "(]"}
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 4:</b>
 * 			<br><b>Input:</b> {@code s = "([])"}
 * 			<br><b>Output:</b> {@code true}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code s} consists of parentheses only {@code '()[]{}'}.</li>
 *     <li>{@code 1 <= s.length <= 104}</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class ValidParentheses
{
	static final Map<Character, Character> CODEPOINT = Map.ofEntries(
		Map.entry(')', '('),
		Map.entry('}', '{'),
		Map.entry(']', '[')
	);

	public static boolean isValid(String s)
	{
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray())
		{
			if (CODEPOINT.containsValue(c))
			{
				stack.push(c);
			}
			else if (CODEPOINT.containsKey(c))
			{
				if (stack.empty() || CODEPOINT.get(c) != stack.pop())
				{
					return false;
				}
			}
		}
		return stack.empty();
	}
}
