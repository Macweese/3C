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
package challenge.easy.scoreOfAString;

/**
 * @author Administrator
 * @Created 23/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3110
 * @Name Score of a String
 * @Difficulty Easy
 * @Tags string
 * biweekly contest 128
 * @link <a href="https://leetcode.com/problems/score-of-a-string/description/">www.leetcode.com/3110</a>
 * @Description You are given a string <code>s</code>.
 * The <b>score</b> of a string is defined as the sum of the absolute difference between the <b>ASCII</b> values of adjacent characters.<br>
 *
 * <br>Return the <b>score</b> of <code>s</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code s = "hello"}
 * 			<br><b>Output:</b> {@code 13}
 * 			<br><b>Explanation:</b> The ASCII values of the characters in <code>s</code> are:
 * 				<br>&emsp;<code>'h' = 104</code>,
 * 				<br>&emsp;<code>'e' = 101</code>,
 * 				<br>&emsp;<code>'l' = 108</code>,
 * 				<br>&emsp;<code>'o' = 111</code>.
 * 				<br>&emsp;So, the score of <code>s</code> would be <code>|104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code s = "zaz"}
 * 			<br><b>Output:</b> {@code 50}
 * 			<br><b>Explanation:</b> The ASCII values of the characters in <code>s</code> are:
 * 				<br>&emsp;<code>'z' = 122</code>,
 * 				<br>&emsp;<code>'a' = 97</code>.
 * 				<br>&emsp;So, the score of <code>s</code> would be <code>|122 - 97| + |97 - 122| = 25 + 25 = 50</code>.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>2 &le; s.length &le; 100</code></li>
 *     <li><code>s</code> consists of only lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class ScoreOfAString
{
	public static void main(String[] args)
	{

	}

	public static int scoreOfString(String s)
	{
		int sum = 0;

		for (int i = 1; i < s.length(); i++)
		{
			sum += Math.abs(s.codePointAt(i - 1) - s.codePointAt(i));
		}
		return sum;
	}
}
