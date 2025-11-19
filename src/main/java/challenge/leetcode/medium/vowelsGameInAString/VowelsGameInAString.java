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

package challenge.leetcode.medium.vowelsGameInAString;

/**
 * @author Administrator
 * @Created 12/09/2025, 12:39 Fri 12 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3227
 * @Name Vowels Game in a String
 * @Difficulty Medium
 * @Tags math
 * string
 * brainteaser
 * game theory
 * weekly contest 407
 * @link <a href="https://leetcode.com/problems/vowels-game-in-a-string/">www.leetcode.com/3227</a>
 * @Description Alice and Bob are playing a game on a string.<br>
 * <br>
 * You are given a string <code>s</code>,
 * Alice and Bob will take turns playing the following game where Alice starts <b>first</b>:
 * <ul>
 * 		<li>On Alice's turn, she has to remove any <b>non-empty substring</b>
 * 			from <code>s</code> that contains an <b>odd</b> number of vowels.</li>
 * 		<li>On Bob's turn, he has to remove any <b>non-empty substring</b>
 * 			from <code>s</code> that contains an <b>even</b> number of vowels.</li>
 * </ul>
 * The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play <b>optimally</b>.<br>
 * <br>
 * Return <code>true</code> if Alice wins the game, and <code>false</code> otherwise.<br>
 * <br>
 * The English vowels are: <code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, and <code>u</code>.
 *
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>s = "leetcoder"</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> Alice can win the game as follows:
 * 				<br>&emsp; Alice plays first,
 * 					she can delete the underlined substring in <code>s = "<b><u>leetco</u></b>der"</code>
 * 					which contains 3 vowels.
 * 					The resulting string is <code>s = "der"</code>.
 * 				<br>&emsp; Bob plays second,
 * 					he can delete the underlined substring in <code>s = "<u><b>d</b></u>er"</code> or <code>s = "de<u><b>r</b></u>"</code>
 * 					which contains 0 vowels. The resulting string is <code>s = "er"</code> or <code>s = "de"</code>.
 * 				<br>&emsp; Alice plays third,
 * 					she can delete the whole string <code>s = "<u><b>er</b></u>"</code> or <code>s = "<u><b>de</b></u>"</code> which contains 1 vowel.
 * 				<br>&emsp; Bob plays fourth,
 * 					since the string is empty, there is no valid play for Bob.
 * 					So Alice wins the game.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>s = "bbcd"</code>
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> There is no valid play for Alice in her first turn, so Alice loses the game.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>1 &le; s.length &le; 10<sup>5</sup></li>
 * 		<li><code>s</code> consists only of lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class VowelsGameInAString
{
	public static boolean doesAliceWin(String s)
	{
		for (int i = 0; i < s.length(); ++i)
		{
			if (isVowel(s.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean isVowel(char c)
	{
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
