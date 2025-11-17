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

package challenge.leetcode.easy.findMostFrequentVowelAndConsonant;

/**
 * @author Administrator
 * @Created 13/09/2025, 05:18 Sat 13 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3541
 * @Name Find Most Frequent Vowel and Consonant
 * @Difficulty Easy
 * @Tags hash table
 * string
 * counting
 * biweekly contest 156
 * @link <a href="https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/">www.leetcode.com/3541</a>
 * @Description You are given a string <code>s</code> consisting of lowercase English letters (<code>'a'</code> to <code>'z'</code>).<br>
 * <br>
 * Your task is to:
 * <ul>
 * 		<li>Find the vowel (one of <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, or <code>'u'</code>)
 * 			with the <b>maximum</b> frequency.</li>
 * 		<li>Find the consonant (all other letters excluding vowels) with the <b>maximum</b> frequency.</li>
 * </ul>
 * <p>
 * Return the sum of the two frequencies.<br>
 * <br>
 * <b>Note</b>: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them.
 * If there are no vowels or no consonants in the string, consider their frequency as 0.<br>
 * <br>
 * The <b>frequency</b> of a letter x is the number of times it occurs in the string.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>s = "successes"</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; The vowels are: <code>'u'</code> (frequency 1), <code>'e'</code> (frequency 2). The maximum frequency is 2.
 * 				<br>&emsp; The consonants are: <code>'s'</code> (frequency 4), <code>'c'</code> (frequency 2). The maximum frequency is 4.
 * 				<br>&emsp; The output is 2 + 4 = 6.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>s = "aeiaeia"</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; The vowels are: <code>'a'</code> (frequency 3), <code>'e'</code> ( frequency 2), <code>'i'</code> (frequency 2). The maximum frequency is 3.
 * 				<br>&emsp; There are no consonants in s. Hence, maximum consonant frequency = 0.
 * 				<br>&emsp; The output is 3 + 0 = 3.
 * 		</li>
 * </ul>x
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; s.length &le; 100</code></li>
 * 		<li><code>s</code> consists of lowercase English letters only.</li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class FindMostFrequentVowelAndConsonant
{
	public static void main(String[] args)
	{
		System.out.println(maxFreqSum("successes"));
		System.out.println(maxFreqSum("aeiaeia"));
	}

	public static int maxFreqSum(String s)
	{
		int con = 0;
		int vow = 0;
		int[] consonants = new int['z' + 1];
		int[] vowels = new int['z' + 1];

		for (int i = 0; i < s.length(); ++i)
		{
			char c = s.charAt(i);
			if (isVowel(c))
			{
				vow = Math.max(vow, ++vowels[c]);
			}
			else if (isConsonant(c))
			{
				con = Math.max(con, ++consonants[c]);
			}
		}

		return con + vow;
	}

	private static boolean isVowel(char c)
	{
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	private static boolean isConsonant(char c)
	{
		return Character.isLetter(c) && !isVowel(c);
	}
}
