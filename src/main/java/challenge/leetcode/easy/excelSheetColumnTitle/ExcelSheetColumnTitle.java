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
package challenge.leetcode.easy.excelSheetColumnTitle;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 20/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 168
 * @Difficulty Easy
 * @Tags math
 * string
 * @link <a href="https://leetcode.com/problems/excel-sheet-column-title/">www.leetcode.com/168</a>
 * @Description Given an integer <code>columnNumber</code>,
 * return <i>its corresponding column title as it appears in an Excel sheet</i>.<br>
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
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code columnNumber = 1}
 * 			<br><b>Output:</b> {@code A}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code columnNumber = 28}
 * 			<br><b>Output:</b> {@code AB}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code columnNumber = 701}
 * 			<br><b>Output:</b> {@code ZY}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 4:</b>
 * 			<br><b>Input:</b> {@code columnNumber = 2147483647}
 * 			<br><b>Output:</b> {@code FXSHRXW}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; {@code 23 * 26^0 = 23}
 * 				<br>&emsp; {@code 24 * 26^1 = 624}
 * 				<br>&emsp; {@code 18 * 26^2 = 12168}
 * 				<br>&emsp; &ensp;{@code 8 * 26^3 = 140608}
 * 				<br>&emsp; {@code 19 * 26^4 = 8682544}
 * 				<br>&emsp; {@code 24 * 26^5 = 285153024}
 * 				<br>&emsp; &ensp;{@code  6 * 26^6 = 1853494656}
 * 				<br>&emsp; {@code 23 + 624 + 12168 + 140608 + 8682544 + 285153024 + 1853494656 = 2147483647}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 5:</b>
 * 			<br><b>Input:</b> {@code columnNumber = 1384}
 * 			<br><b>Output:</b> {@code BAF}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; {@code 6 * 26^0 = 6}
 * 				<br>&emsp; {@code 1 * 26^1 = 26}
 * 				<br>&emsp; {@code 2 * 26^2 = 1352}
 * 				<br>&emsp; {@code 6 + 26 + 1352 = 1384}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; columnNumber &le; 2<sup>31</sup>-1</code></li>
 * </ul>
 * </p>
 **/
@Slf4j
public class ExcelSheetColumnTitle
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

		// A
		System.out.println(convertToTitle(1));

		// B
		System.out.println(convertToTitle(2));

		// AB
		System.out.println(convertToTitle(27));

		// AZ
		System.out.println(convertToTitle(52));

		// ZY
		System.out.println(convertToTitle(701));

		// FXSHRXW
		System.out.println(convertToTitle(2147483647));

		// BAF
		System.out.println(convertToTitle(1384));
	}


	// For visualizing the values
	private static final Map<Integer, Character> MAP = new HashMap<>();

	static
	{
		MAP.put(1, 'A');
		MAP.put(2, 'B');
		MAP.put(3, 'C');
		MAP.put(4, 'D');
		MAP.put(5, 'E');
		MAP.put(6, 'F');
		MAP.put(7, 'G');
		MAP.put(8, 'H');
		MAP.put(9, 'I');
		MAP.put(10, 'J');
		MAP.put(11, 'K');
		MAP.put(12, 'L');
		MAP.put(13, 'M');
		MAP.put(14, 'N');
		MAP.put(15, 'O');
		MAP.put(16, 'P');
		MAP.put(17, 'Q');
		MAP.put(18, 'R');
		MAP.put(19, 'S');
		MAP.put(20, 'T');
		MAP.put(21, 'U');
		MAP.put(22, 'V');
		MAP.put(23, 'W');
		MAP.put(24, 'X');
		MAP.put(25, 'Y');
		MAP.put(26, 'Z');
	}

	public static String convertToTitle(int columnNumber)
	{
		final int alphabetSize = 26;
		int size = (int) (Math.log10(columnNumber) / Math.log10(alphabetSize)) + 1;
		char[] chars = new char[size];


		final int charOffset = 64;
		int r;
		int pos = size - 1;

		while (columnNumber > 0)
		{
			r = columnNumber % 26;
			if (r == 0)
			{
				r = alphabetSize;
			}
			chars[pos] = (char) (r + charOffset);
			pos--;
			columnNumber = columnNumber - r;
			columnNumber = columnNumber / 26;
		}

		return String.valueOf(chars).trim();
	}
}
