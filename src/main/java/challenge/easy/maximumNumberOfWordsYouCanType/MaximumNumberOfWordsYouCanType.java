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

package challenge.easy.maximumNumberOfWordsYouCanType;

/**
 * @author Administrator
 * @Created 15/09/2025, 03:04 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1935
 * @Name Maximum Number of Words You Can Type
 * @Difficulty Easy
 * @Tags hash table
 * string
 * weekly contest 250
 * @link <a href="https://leetcode.com/problems/maximum-number-of-words-you-can-type/">www.leetcode.com/1935</a>
 * @Description
 * There is a malfunctioning keyboard where some letter keys do not work.
 * All other keys on the keyboard work properly.<br>
 * <br>
 * Given a string <code>text</code> of words separated by a single space (no leading or trailing spaces)
 * and a string <code>brokenLetters</code> of all <b>distinct</b> letter keys that are broken,
 * return <i>the <b>number of words</b> in</i> <code>text</code> <i>you can fully type using this keyboard</i>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>text = "hello world", brokenLetters = "ad"</code>
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b> We cannot type "world" because the 'd' key is broken.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>text = "leet code", brokenLetters = "lt"</code>
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b> We cannot type "leet" because the 'l' and 't' keys are broken.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>text = "leet code", brokenLetters = "e"</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> text = "leet code", brokenLetters = "e"
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; text.length &le; 10<sup>4</sup></code></li>
 * 		<li><code>0 &le; brokenLetters.length &le; 26</code></li>
 * 		<li><code>text</code> consists of words separated by a single space without any leading or trailing spaces.</li>
 * 		<li>Each word only consists of lowercase English letters.</li>
 * 		<li><code>brokenLetters</code> consists of <b>distinct</b> lowercase English letters.</li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class MaximumNumberOfWordsYouCanType
{

	public static void main(String[] args)
	{
		String TEXT_1 = "hello world";
		String BR_L_1 = "ad";

		String TEXT_2 = "leet code";
		String BR_L_2 = "lt";

		String TEXT_3 = "leet code";
		String BR_L_3 = "e";

		System.out.println(canBeTypedWords(TEXT_1, BR_L_1));
		System.out.println(canBeTypedWords(TEXT_2, BR_L_2));
		System.out.println(canBeTypedWords(TEXT_3, BR_L_3));
	}

	public static int canBeTypedWords(String text, String brokenLetters)
	{
		int completeWords = 0;
		int brokenLettersMask = getMask(brokenLetters);
//		System.out.printf("%45s %-30s %,13d%n", toBinary(brokenLettersMask), "wordMask", brokenLettersMask);
//		System.out.printf("%45s %-11s %-24s %,13d%n", toBinary(brokenLettersMask), "lettersMask", brokenLetters, brokenLettersMask);
//		System.out.printf("%45s %-11s %-26s %,13d%n", toBinary((1 << 31) - 1), "lettersMask", "abcdefghijklmnopqrstuvwxyz", ((1 << 31) - 1));

		for (String word : text.split(" "))
		{
			int wordMask = getMask(word);
//			System.out.printf("%45s %-11s %-24s %,13d%n", toBinary(wordMask), "wordMask", word, wordMask);
//			System.out.printf("%45s %-32s %,13d%n", toBinary((wordMask & brokenLettersMask)), "Bitwise-AND (wordMask & lettersMask)", (wordMask & brokenLettersMask));
			completeWords = (getMask(word) & brokenLettersMask) == 0 ? completeWords + 1 : completeWords;
//			System.out.printf("Complete words: %s%n", completeWords);
		}

		return completeWords;
	}

	public static int getMask(String word)
	{

		int mask = 0;
		for (int i = 0; i < word.length(); ++i)
		{
			mask |= 1 << (word.charAt(i) - ('a'));
		}
		return mask;
	}

	// For debugging/visualization purposes
	public static String toBinary(int val)
	{
		String s = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');

		int group = 0;
		StringBuilder sb = new StringBuilder(s);
		while (group < 9)
		{
			sb.insert(group * 4 + ++group - 1, " ");
		}

		return sb.toString();
	}
}
