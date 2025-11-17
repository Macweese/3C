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
package challenge.leetcode.easy.checkIfTheSentenceIsPangram;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1832
 * @Name Check if the Sentence is Pangram
 * @Difficulty Easy
 * @Tags hash table
 * string
 * weekly contest 237
 * @link <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram/">www.leetcode.com/1832</a>
 * @Description A pangram is a sentence where every letter of the English alphabet appears at least once.<br>
 * <br>
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code sentence = "thequickbrownfoxjumpsoverthelazydog"}
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> sentence contains at least one of every letter of the English alphabet.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code sentence = "leetcode"}
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; sentence.length &le; 1000</code></li>
 * 		<li><code>sentence</code> consists of lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class CheckIfTheSentenceIsPangram
{
	public static void main(String[] args)
	{

		for (int i = 'a'; i < 'z'; i++)
		{
			System.out.println(Character.toString(i) + " : " + Integer.toBinaryString(1 << i - 1));
		}
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydot"));
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazycatinthehandbag"));
//		System.out.println(checkIfPangram("leetcode"));
	}

	public static boolean checkIfPangram(String s)
	{
		if (s.length() < 26)
		{
			return false;
		}

		int mask = 0;
		for (char c : s.toCharArray())
		{
			mask |= (1 << (c - 97));
		}

		return mask == 0x3ffffff;
	}
}
