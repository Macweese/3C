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
package challenge.leetcode.easy.convertDateToBinary;

/**
 * @author Administrator
 * @Created 13/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3280
 * @Name Convert Date To Binary
 * @Difficulty Easy
 * @Tags math
 * string
 * weekly contest 414
 * @link <a href="https://leetcode.com/problems/convert-date-to-binary/">www.leetcode.com/3280</a>
 * @Description You are given a string <code>date</code> representing a Gregorian calendar date in the <code>yyyy-mm-dd</code> format.<br>
 * <br>
 * <code>date</code> can be written in its binary representation obtained by converting year, month, and day
 * to their binary representations without any leading zeroes and writing them down in <code>year-month-day</code> format.<br>
 * <br>
 * Return the <b>binary</b> representation of <code>date</code>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>date = "2080-02-29"</code>
 * 			<br><b>Output:</b> {@code "100000100000-10-11101"}
 * 			<br><b>Explanation:</b> 100000100000, 10, and 11101 are the binary representations of 2080, 02, and 29 respectively.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>date = "1900-01-01"</code>
 * 			<br><b>Output:</b> {@code "11101101100-1-1"}
 * 			<br><b>Explanation:</b> 11101101100, 1, and 1 are the binary representations of 1900, 1, and 1 respectively.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>date.length == 10</code></li>
 * 		<li><code>date[4] == date[7] == '-'</code>, and all other <code>date[i]</code>'s are digits.</li>
 * 		<li>The input is generated such that <code>date</code> represents a valid Gregorian calendar date
 * 			between Jan 1<sup>st</sup>, 1900 and Dec 31<sup>st</sup>, 2100 (both inclusive).</li>
 * </ul>
 * </p>
 * <br>
 * @Similar <a href="https://leetcode.com/problems/number-of-1-bits/"/>191. Number of 1 Bits (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/convert-to-base-2/"/>1017. Convert to Base -2 (Leetcode)</a><br>
 * {@link challenge.easy.numberOf1Bits.NumberOf1Bits 191. Number of 1 Bits (local)}<br>
 * {@link challenge.medium.convertToBase2.ConvertToBase2 1017. Convert to Base -2 (local)}<br>
 **/
public class ConvertDateToBinary
{
	public static String convertDateToBinary(String date)
	{
		final String[] d = date.split("-");

		return Integer.toBinaryString(Integer.parseInt(d[0]))
			+ "-" + Integer.toBinaryString(Integer.parseInt(d[1]))
			+ "-" + Integer.toBinaryString(Integer.parseInt(d[2]));
	}
}
