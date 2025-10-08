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
 *
 */
package challenge.easy.excelSheetColumnNumber;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 20/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 171
 * @Difficulty Easy
 * @Tags math
 * string
 * @link <a href="https://leetcode.com/problems/excel-sheet-column-number/">www.leetcode.com/171</a>
 * @Description Given a string <code>columnTitle</code> that represents the column title as appears in an Excel sheet,
 * return <i>its corresponding column number</i>.<br>
 *
 * <br>For example:
 * <br>&emsp; A -> 1
 * <br>&emsp; B -> 2
 * <br>&emsp; C -> 3
 * <br>&emsp; ...
 * <br>&emsp; Z -> 26
 * <br>&emsp; AA -> 27
 * <br>&emsp; AB -> 28
 * <br>&emsp; ...
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code columnTitle = A}
 * 			<br><b>Output:</b> {@code 1}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code columnTitle = AB}
 * 			<br><b>Output:</b> {@code 28}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code columnTitle = ZY}
 * 			<br><b>Output:</b> {@code 701}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; columnTitle.length &le; 7</code></li>
 * 		<li><code>columnTitle</code> consists of only uppercase English letters.</li>
 * 		<li><code>columnTitle</code> is in the range <code>["A", "FXSHRXW"]</code>.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class ExcelSheetColumnNumber
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();


		System.out.println("A       = " + titleToNumber("A"));
		System.out.println("B       = " + titleToNumber("B"));
		System.out.println("Z       = " + titleToNumber("Z"));
		System.out.println("AA      = " + titleToNumber("AA"));
		System.out.println("AB      = " + titleToNumber("AB"));
		System.out.println("ZY      = " + titleToNumber("ZY"));
		System.out.println("BAF     = " + titleToNumber("BAF"));
		System.out.println("FXSHRXW = " + titleToNumber("FXSHRXW"));

		System.out.println(ALPHABET_SIZE);
		System.out.println(CHAR_VALUE_OFFSET);
	}

	private static final int ALPHABET_SIZE = ('Z' - 'A') + 1;
	private static final int CHAR_VALUE_OFFSET = 'A' - 1;

	public static int titleToNumber(String columnTitle)
	{
		char[] chars = columnTitle.toCharArray();

		int colNumber = 0;
		int n = chars.length - 1;
		for (int i = n; i > -1; i--)
		{
			colNumber = colNumber + (chars[i] - CHAR_VALUE_OFFSET) * (int) Math.pow(ALPHABET_SIZE, n - i);
		}

		return colNumber;
	}
}
