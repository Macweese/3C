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
package challenge.leetcode.easy.romanToInteger;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000

	For example, 2 is written as II in Roman numeral, just two ones added together.
	12 is written as XII, which is simply X + II.
	The number 27 is written as XXVII, which is XX + V + II.

	Roman numerals are usually written largest to smallest from left to right.
	However, the numeral for four is not IIII. Instead, the number four is written as IV.
	Because the one is before the five we subtract it making four.
	The same principle applies to the number nine, which is written as IX.
	There are six instances where subtraction is used:

	I can be placed before V (5) and X (10) to make 4 and 9.
	X can be placed before L (50) and C (100) to make 40 and 90.
	C can be placed before D (500) and M (1000) to make 400 and 900.
	Given a roman numeral, convert it to an integer.

	Example 1:

	Input: s = "III"
	Output: 3
	Explanation: III = 3.
	Example 2:

	Input: s = "LVIII"
	Output: 58
	Explanation: L = 50, V= 5, III = 3.
	Example 3:

	Input: s = "MCMXCIV"
	Output: 1994
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


	Constraints:

	1 <= s.length <= 15
	s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
	It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger implements Runnable
{
	public static final String ROMAN_2_918_741 = "_M_M_C_M_X_VMMMDCCXLI";
	public static final String ROMAN_999_999 = "_C_M_X_C_I_XCMXCIX";
	public static final String ROMAN_5000 = "_V";
	public static final String ROMAN_1994 = "MCMXCIV";
	public static final String ROMAN_999 = "CMXCIX";
	public static final String ROMAN_58 = "LVIII";
	public static final String ROMAN_49 = "XLIX";
	public static final String ROMAN_3 = "III";
	public static final String ROMAN_INVALID = "IIIDDMIIII";

	static final Map<String, String> valueMap = new LinkedHashMap<>();

	static
	{
		valueMap.put("_C_M", "900000 ");
		valueMap.put("_C_D", "400000 ");
		valueMap.put("_X_C", "90000 ");
		valueMap.put("_X_L", "40000 ");
		valueMap.put("_I_X", "9000 ");
		valueMap.put("_I_V", "4000 ");
		valueMap.put("_M", "1000000 ");
		valueMap.put("_D", "500000 ");
		valueMap.put("_C", "100000 ");
		valueMap.put("_L", "50000 ");
		valueMap.put("_X", "10000 ");
		valueMap.put("_V", "5000 ");
		valueMap.put("CM", "900 ");
		valueMap.put("CD", "400 ");
		valueMap.put("XC", "90 ");
		valueMap.put("XL", "40 ");
		valueMap.put("IX", "9 ");
		valueMap.put("IV", "4 ");
		valueMap.put("M", "1000 ");
		valueMap.put("D", "500 ");
		valueMap.put("C", "100 ");
		valueMap.put("L", "50 ");
		valueMap.put("X", "10 ");
		valueMap.put("V", "5 ");
		valueMap.put("I", "1 ");
	}

	public static boolean invalidNumber(String string)
	{
		return string == null
			|| string.isBlank()
			//|| string.length() > 15
			|| string.matches("^.*((M{4,})|(D{2,})|(C{4,})|(L{2,})|(X{4,})|(V{2,})|(I{4,})).*$")
			|| string.matches("^[IVXLCDM]*[^_IVXLCDM]+.*$");
	}

	public static int convert(String string)
	{
		String original = string;
		string = string.toUpperCase();

		if (invalidNumber(string))
		{
			throw new NumberFormatException("'" + string + "' is not a valid roman numeral.");
		}

		int value = 0;

		for (Map.Entry<String, String> entry : valueMap.entrySet())
		{
			string = string.replaceAll(entry.getKey(), entry.getValue());
		}


		for (String s : string.split(" "))
		{
			value += Integer.parseInt(s);
		}

		System.out.println(value + ", " + original + ", " + Arrays.toString(string.split(" ")));
		return value;
	}

	@Override
	public void run()
	{
		convert(ROMAN_3);
		convert(ROMAN_49);
		convert(ROMAN_58);
		convert(ROMAN_999);
		convert(ROMAN_1994);
		convert(ROMAN_5000);
		convert(ROMAN_999_999);
		convert(ROMAN_2_918_741);
	}

	public static void main(String[] args)
	{
		RomanToInteger r = new RomanToInteger();
		r.run();
	}
}
