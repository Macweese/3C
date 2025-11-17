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
package challenge.leetcode.easy.addDigits;

/**
 * @author Administrator
 * @Created 27/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 258
 * @Name Add Digits
 * @Difficulty Easy
 * @Tags math
 * simulation
 * number theory
 * @link <a href="https://leetcode.com/problems/add-digits/">www.leetcode.com/258</a>
 * @Description Given an integer <code>num</code>, repeatedly add all its digits until the result has only one digit, and return it.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code num = 38}
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b> The process is
 * 			<br>&emsp;38 --> 3 + 8 --> 11
 * 			<br>&emsp;11 --> 1 + 1 --> 2
 * 			<br>&emsp;Since 2 has only one digit, return it.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 0}
 * 			<br><b>Output:</b> {@code 0}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 0 &le; n &le; 2<sup>31</sup>-1</code></li>
 * </ul>
 * </p>
 * <h3>Follow up:</h3>
 * Could you do it without any loop/recursion in O(1) runtime?
 **/
public class AddDigits
{
	public static void main(String[] args)
	{

	}

	public static int addDigits(int num)
	{
		return num < 10 ? num : num % 9;
	}
}
