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
package challenge.easy.findWordsContainingCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 24/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2942
 * @Name Find Words Containing Character
 * @Difficulty Easy
 * @Tags array
 * string
 * biweekly contest 118
 * @link <a href="https://leetcode.com/problems/find-words-containing-character/">www.leetcode.com/2942</a>
 * @Description You are given a <b>0-indexed</b> array of strings <code>words</code> and a character <code>x</code>.<br>
 *
 * <br>Return <i>an <b>array of indices</b> representing the words that contain the character</i> <code>x</code>.<br>
 *
 * <br><b>Note</b> that the returned array may be in <b>any</b> order.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code words = ["leet","code"], x = "e"}
 * 			<br><b>Output:</b> {@code [0,1]}
 * 			<br><b>Explanation:</b> "e" occurs in both words:
 * 				<br>&emsp;"l<b><u>ee</u></b>t", and "cod<b><u>e</u></b>".
 * 				<br>&emsp;Hence, we return indices 0 and 1.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code words = ["abc","bcd","aaaa","cbc"], x = "a"}
 * 			<br><b>Output:</b> {@code [0,2]}
 * 			<br><b>Explanation:</b> "a" occurs in:
 * 			<br>&emsp;"<b><u>a</u></b>bc", and "<b><u>aaaa</u></b>".
 * 			<br>&emsp;Hence, we return indices 0 and 2.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code words = ["abc","bcd","aaaa","cbc"], x = "z"}
 * 			<br><b>Output:</b> {@code []}
 * 			<br><b>Explanation:</b> "z" does not occur in any of the words.
 * 			<br>&emsp;Hence, we return an empty array.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>1 &le; words.length &le; 50</code></li>
 *     <li><code>1 &le; words[i] &lt; 50</code></li>
 *     <li><code>x</code> is a lowercase English letter.</li>
 *     <li><code>words[i]</code> consists of only lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class FindWordsContainingCharacter
{
	public static void main(String[] args)
	{
		String[] CASE_1 = new String[]{"leet", "code"};
		String[] CASE_2 = new String[]{"abc", "bcd", "aaaa", "cbc"};
		String[] CASE_3 = new String[]{"abc", "bcd", "aaaa", "cbc"};

		char LETTER_1 = 'e';
		char LETTER_2 = 'a';
		char LETTER_3 = 'z';

		System.out.println(findWordsContaining(CASE_1, LETTER_1));
		System.out.println(findWordsContaining(CASE_2, LETTER_2));
		System.out.println(findWordsContaining(CASE_3, LETTER_3));
	}

	public static List<Integer> findWordsContaining(String[] words, char x)
	{
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < words.length; i++)
		{
			if (words[i].contains(String.valueOf(x)))
			{
				list.add(i);
			}
		}

		return list;
	}
}
