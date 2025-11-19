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
package challenge.leetcode.easy.addBinary;

/**
 * @author Administrator
 * @Created 06/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 67
 * @Difficulty Easy
 * @Tags math,
 * string,
 * bit manipulation,
 * simulation
 * @link <a href="https://leetcode.com/problems/add-binary/">www.leetcode.com/67</a>
 * @Description Given two binary strings <code>a</code> and <code>b</code>, return <i>their sum as a binary string</i>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code a = "11", b = "1"}
 * 			<br><b>Output:</b> {@code "100"}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code a = "1010", b = "1011"}
 * 			<br><b>Output:</b> {@code "10101"}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; a.length, b.length &le; 10<sup>4</sup></code></li>
 *     <li>{@code a} and {@code b} only consists of <code>'0'</code> or <code>'1'</code> characters.</li>
 *     <li>Each string does not contain leading zeros except for the zero itself.</li>
 * </ul>
 * </p>
 **/
public class AddBinary
{
	public static String addBinary(String a, String b)
	{
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder result = new StringBuilder();

		while (i >= 0 || j >= 0)
		{
			int sum = carry;
			if (i >= 0)
			{
				sum = sum + a.charAt(i--) - '0';
			}
			if (j >= 0)
			{
				sum = sum + b.charAt(j--) - '0';
			}
			result.append(sum % 2);
			carry = sum / 2;
		}

		result.append(carry != 0 ? carry : "")
			.reverse();

		return result.toString();
	}
}

