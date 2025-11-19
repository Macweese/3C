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
package challenge.leetcode.easy.findFirstPalindromicStringInArray;

import java.util.Stack;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2108
 * @Name Find First Palindromic String in Array
 * @Difficulty Easy
 * @Tags array
 * two pointers
 * string
 * weekly contest 272
 * @link <a href="https://leetcode.com/problems/find-first-palindromic-string-in-the-array/">www.leetcode.com/2108</a>
 * @Description Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 * <br>
 * A string is palindromic if it reads the same forward and backward.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>words = ["abc","car","ada","racecar","cool"]</code>
 * 			<br><b>Output:</b> {@code "ada"}
 * 			<br><b>Explanation:</b> The first string that is palindromic is "ada".
 * 			<br>&emsp; Note that "racecar" is also palindromic, but it is not the first.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>words = ["notapalindrome","racecar"]</code>
 * 			<br><b>Output:</b> {@code "racecar"}
 * 			<br><b>Explanation:</b> The first and only string that is palindromic is "racecar".
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>words = ["def","ghi"]</code>
 * 			<br><b>Output:</b> {@code ""}
 * 			<br><b>Explanation:</b> There are no palindromic strings, so the empty string is returned.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; words.length &le; 100</code></li>
 *     <li><code>1 &le; words[i].length &le; 100</code></li>
 *     <li><code>words[i]</code> consists only of lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class FindFirstPalindromicStringInArray
{
	/**
	 * Uses stack
	 * <br>
	 * <br>Solution complexity:
	 * <br><b>TC:</b> O(nm/2) -> O(nm)
	 * <br><b>SC:</b> O(m/2)   -> O(m)
	 * <br>
	 * <br><b>Performance:</b> suboptimal
	 * <br><b>Use:</b> good for returning the non-palindromic segment
	 *
	 * @param words
	 * @return
	 */
	public static String firstPalindrome(String[] words)
	{
		Stack<Character> stack = new Stack<>();

		outer: for (String word : words)
		{
			stack.clear();
			for (int i = 0; i < (word.length() / 2); i++)
			{
				stack.push(word.charAt(i));
			}
			for (int i = (word.length() + 1) / 2; i < word.length(); i++)
			{
				if (!stack.empty() && stack.peek() == word.charAt(i))
				{
					stack.pop();
				}
				else
				{
					continue outer;
				}
			}
			if (stack.empty())
			{
				return word;
			}
		}
		return "";
	}

	/**
	 * Uses two-pointer
	 * <br>
	 * <br>Solution complexity:
	 * <br><b>TC:</b> O(nm/2) -> O(nm)
	 * <br><b>SC:</b> O(1)
	 *
	 * @param words
	 * @return
	 */
	public static String firstPalindromeOptimal(String[] words)
	{
		outer: for (String word : words)
		{
			int l = 0;
			int r = word.length() - 1;

			while (l < r)
			{
				if (word.charAt(l) != word.charAt(r))
				{
					continue outer;
				}

				l++;
				r--;
			}
			return word;
		}

		return "";
	}
}
