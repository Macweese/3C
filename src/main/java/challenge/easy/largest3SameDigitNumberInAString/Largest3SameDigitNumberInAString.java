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
package challenge.easy.largest3SameDigitNumberInAString;

/**
 * @author Administrator
 * @Created 14/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2264
 * @Name Largest 3-Same-Number in String
 * @Difficulty Easy
 * @Tags string
 * weekly contest 292
 * @link <a href="https://leetcode.com/problems/largest-3-same-digit-number-in-string/">www.leetcode.com/2264</a>
 * @Description You are given a string <code>num</code> representing a large integer.
 * An integer is <b>good</b> if it meets the following conditions:
 *
 * <ul>
 *     <li>It is a <b>substring</b> of <code>num</code> with length <code>3</code>.</li>
 *     <li>It consists of only one unique digit.</li>
 * </ul>
 * <p>
 * Return <i>the <b>maximum good</b> integer as a <b>string</b> or an empty string <code>""</code> if no such integer exists</i>.<br>
 * <br>
 * <b>Note</b>
 * <ul>
 *     <li>A <b>substring</b> is a contiguous sequence of characters within a string.</li>
 *     <li>There may be <b>leading zeroes</b> in <code>num</code> or a good integer.</li>
 * </ul>
 *
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>num = "6777133339"</code>
 * 			<br><b>Output:</b> {@code "777"}
 * 			<br><b>Explanation:</b> There are two distinct good integers: "777" and "333".
 * 					"777" is the largest, so we return "777".
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>num = "2300019"</code>
 * 			<br><b>Output:</b> {@code "000"}
 * 			<br><b>Explanation:</b> "000" is the only good integer.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>num = "42352338"</code>
 * 			<br><b>Output:</b> {@code ""}
 * 			<br><b>Explanation:</b> No substring of length 3 consists of only one unique digit.
 * 					Therefore, there are no good integers.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>3 &le; num.length &le; 1000</code></li>
 * 		<li><code>num</code> only consists of digits.</li>
 * </ul>
 * </p>
 * <br>
 * @Similar <a href="https://leetcode.com/problems/largest-odd-number-in-string/"/>1903. Largest Odd Number in String (Leetcode)</a><br>
 * {@link challenge.easy.largestOddNumberInString.LargestOddNumberInString 1903. Largest Odd Number in String (local)}<br>
 **/
public class Largest3SameDigitNumberInAString
{
	public static void main(String[] args)
	{
		System.out.println(largestGoodInteger("6777133339"));
		System.out.println(largestGoodInteger("2300019"));
		System.out.println(largestGoodInteger("42352338"));
	}

	public static String largestGoodInteger(String number)
	{
		int max = -1;
		char[] digits = number.toCharArray();
		for (int i = 2; i < number.length(); i++)
		{
			if (max == 9)
			{
				break;
			}
			if (digits[i] == digits[i - 1] && digits[i] == digits[i - 2])
			{
				max = Math.max(max, Character.getNumericValue(digits[i]));
			}
		}

		return (max == -1) ? "" : Integer.toString(max).repeat(3);
	}
}
