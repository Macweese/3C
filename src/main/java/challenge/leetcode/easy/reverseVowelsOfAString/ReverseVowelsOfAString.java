/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.easy.reverseVowelsOfAString;

import java.util.Stack;

/**
 * @author Administrator
 * @Created 00:07 Tue 14 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class ReverseVowelsOfAString
{
	public static String reverseVowels(String s)
	{
		Stack<Character> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();

		for (char c : s.toCharArray())
		{
			if (isVowel(c))
			{
				stack.push(c);
			}
		}

		for (int i = 0; i < s.length() || !stack.empty(); i++)
		{
			char c = s.charAt(i);
			if (isVowel(c))
			{
				stringBuilder.append(stack.pop());
				continue;
			}

			stringBuilder.append(c);
		}

		return stringBuilder.toString();
	}

	private static boolean isVowel(char c)
	{
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
