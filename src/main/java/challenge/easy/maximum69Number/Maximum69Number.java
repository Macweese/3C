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
package challenge.easy.maximum69Number;

/**
 * @author Administrator
 * @Created 16/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1323
 * @Name Maximum 69 Number
 * @Difficulty Easy
 * @Tags math
 * greedy
 * weekly contest 172
 * @link <a href="https://leetcode.com/problems/maximum-69-number/">www.leetcode.com/1323</a>
 * @Description You are given a positive integer <code>num</code> consisting only of digits <code>6</code> and <code>9</code>.<br>
 * <br>
 * Return <i>the maximum number you can get by changing <b>at most</b> one digit
 * (<code>6</code> becomes <code>9</code>, and <code>9</code> becomes <code>6</code>)</i>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>num = 9669</code>
 * 			<br><b>Output:</b> {@code 9969}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; Changing the first digit results in 6669.
 * 				<br>&emsp; Changing the second digit results in 9969.
 * 				<br>&emsp; Changing the third digit results in 9699.
 * 				<br>&emsp; Changing the fourth digit results in 9666.
 * 				<br>&emsp; The maximum number is 9969.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>num = 9996</code>
 * 			<br><b>Output:</b> {@code 9999}
 * 			<br><b>Explanation:</b> Changing the last digit 6 to 9 results in the maximum number.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>num = 9999</code>
 * 			<br><b>Output:</b> {@code 9999}
 * 			<br><b>Explanation:</b> It is better not to apply any change.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; num &le; 104</code></li>
 * 		<li><code>num</code> consists of only <code>6</code> and <code>9</code> digits.</li>
 * </ul>
 * </p>
 * <br>
 * @Similar
 **/
public class Maximum69Number
{
	public static void main(String[] args)
	{

	}

	public static int maximum69Number(int n)
	{
		return Integer.parseInt(Integer.toString(n).replaceFirst("6", "9"));
	}
}
