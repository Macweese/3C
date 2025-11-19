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

package challenge.leetcode.medium.sortVowelsInAString;

import java.util.PriorityQueue;

/**
 * @author Administrator
 * @Created 11/09/2025, 10:29 Thu 11 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2785
 * @Name Sort Vowels in a String
 * @Difficulty Medium
 * @Tags string
 * sorting
 * biweekly contest 109
 * @link <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">www.leetcode.com/2785</a>
 * @Description Given a <b>0-indexed</b> string <code>s</code>,
 * <b>permute</b> <b>s</b> to get a new string <code>t</code> such that:
 * <ul>
 * 		<li>All consonants remain in their original places.
 * 			More formally, if there is an index <code>i</code> with <code>0 <= i < s.length</code> such that
 * 			<code>s[i]</code> is a consonant, then <code>t[i] = s[i]</code>.</li>
 * 		<li>The vowels must be sorted in the <b>non-decreasing</b> order of their <b>ASCII</b> values.
 * 			More formally, for pairs of indices <code>i</code>, <code>j</code> with <code>0 <= i < j < s.length</code> such that
 * 			<code>s[i]</code> and <code>s[j]</code> are vowels,
 * 			then <code>t[i]</code> must not have a higher ASCII value than <code>t[j]</code>.</li>
 * </ul>
 * <p>
 * Return <i>the resulting string</i>.<br>
 * <br>
 * The vowels are <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, and <code>'u'</code>
 * and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>s = "lEetcOde"</code>
 * 			<br><b>Output:</b> {@code "lEOtcede"}
 * 			<br><b>Explanation:</b> 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants.
 * 			The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>s = "lYmpH"</code>
 * 			<br><b>Output:</b> {@code "lYmpH"}
 * 			<br><b>Explanation:</b> There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; s.length &le; 10<sup>5</sup></code></li>
 * 		<li><code>s</code> consists only of letters of the English alphabet in <b>uppercase and lowercase</b>.</li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/"/>345. Reverse Vowels in a String (Leetcode)</a><br>
 * <br>
 * {@link challenge.easy.reverseVowelsInAString.reverseVowels 345. Reverse Vowels in a String (local)}<br>
 **/
public class SortVowelsInAString
{
	public static String sortVowels(String s)
	{
		final char[] vowels = new char[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};

		PriorityQueue<Character> charQueue = new PriorityQueue<>();
		PriorityQueue<Integer> charPositions = new PriorityQueue<>();

		for (int i = 0; i < s.length(); ++i)
		{
			for (char vowel : vowels)
			{
				if (vowel == s.charAt(i))
				{
					charQueue.add(vowel);
					charPositions.add(i);
				}
			}
		}

		StringBuilder sb = new StringBuilder(s);
		for (int i : charPositions)
		{
			if (charQueue.isEmpty())
			{
				continue;
			}

			sb.setCharAt(i, charQueue.poll());
		}

		return sb.toString();
	}

	public static String sortVowelsAlternativeSolution(String s)
	{
		int[] vowels = new int[128];

		for (int i = 0; i < s.length(); ++i)
		{
			char c = s.charAt(i);
			if (isVowel(c))
			{
				vowels[c] = vowels[c] + 1;
			}
		}

		StringBuilder result = new StringBuilder(s);
		for (int i = 0; i < result.length(); ++i)
		{
			if (isVowel(result.charAt(i)))
			{
				result.setCharAt(i, getSmallestVowel(vowels));
			}
		}

		return result.toString();
	}

	private static char getSmallestVowel(int[] vowels)
	{
		int[] indices = new int[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

		for (int i : indices)
		{
			if (vowels[i] > 0)
			{
				vowels[i]--;
				return (char) i;
			}
		}

		return '_';
	}

	private static boolean isVowel(char c)
	{
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	private String test(String s)
	{
		PriorityQueue<Character> charQueue = new PriorityQueue<>();
		PriorityQueue<Integer> indexQueue = new PriorityQueue<>();

		for (int i = 0; i < s.length(); ++i)
		{
			char c = s.charAt(i);
			if (isVowel(c))
			{
				charQueue.add(c);
				indexQueue.add(i);
			}
		}

		StringBuilder result = new StringBuilder(s);
		for (int i : indexQueue)
		{
			result.setCharAt(i, charQueue.poll());
		}

		return result.toString();
	}
}
