/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.findUniqueBinaryStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:05 Sun 08 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
class FindUniqueBinaryStringsTest
{
	private static final Set<String[]> SET = new HashSet<>();

	static
	{
		SET.add(new String[]{"0"});
		SET.add(new String[]{"1"});
		SET.add(new String[]{"00", "10"});
		SET.add(new String[]{"00", "01"});
		SET.add(new String[]{"01", "10"});
		SET.add(new String[]{"111", "011", "001"});
		SET.add(new String[]{"10101", "01011", "00001", "00111", "00100"});
		SET.add(new String[]{"0101010", "1001111", "1101010", "1100001", "1011111", "1110110", "0001001"});
		SET.add(new String[]{"00101100", "10110101", "00010001", "11110110", "01110011", "11000011", "01111111", "11111001"});
		SET.add(new String[]{"110101000", "010010001", "100111011", "011001101", "110001101", "000011110", "101110110", "001010111", "110101001"});
		SET.add(new String[]{"100101011", "000110011", "100011100", "000001001", "111111101", "100111110", "111001111", "000111011", "001100101"});
		SET.add(new String[]{"01111011010", "10110011111", "10001100011", "01011000001", "01011011100", "01101100010", "01110011111", "10001110011", "00111001111", "11011101111", "00101110100"});
		SET.add(new String[]{"11001001011", "11000001101", "11110010110", "11110101100", "11101110001", "11111100101", "00010101101", "00110110011", "10001010011", "10000100111", "11110011011"});
		SET.add(new String[]{"10000111101", "00101101111", "10110010101", "00000110010", "01010110101", "01100010111", "00010011000", "00111110011", "11110000111", "01110011000", "10011001111"});
		SET.add(new String[]{"1000111100101", "0101000000110", "0011010101111", "0100110100101", "0110111101101", "1110000000100", "0101110100111", "0010010001010", "0110100000101", "0100010010101", "0001110000101", "1001010111011", "0010101100101"});
		SET.add(new String[]{"0101000010111010", "1101101100010010", "0100011011011111", "1111001111111001", "1010110100010101", "0010110101100010", "1101100001110000", "0001010010010000", "0110010010001110", "0101011011001101", "0010100010001110", "0100011010101001", "1000110010000000", "1011110010101011", "0011101110000000", "1010001110011000"});
		SET.add(new String[]{"1010101011011", "0011001101001", "0101101101000", "1001000000000", "0000011111101", "0110011111110", "0011101111110", "1001100100001", "1000101100001", "0000011011110", "1010010000111", "1111010010100", "0011101110000"});
	}

	@Test
	void findDifferentBinaryString()
	{
		for (String[] input : SET)
		{
			final String actual = FindUniqueBinaryStrings.findDifferentBinaryString(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : Any of %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(input),
				"Expected", findComplement(input),
				"Actual", actual,
				""
			);

			assertTrue(actual.length() == input[0].length() && Arrays.stream(input).noneMatch(s -> s.equals(actual)), message);
		}
	}

	private static List<String> findComplement(String[] input)
	{
		if (input == null || input.length == 0)
		{
			return new ArrayList<>();
		}

		int length = input[0].length();
		Set<String> inputSet = new HashSet<>(Arrays.asList(input));
		List<String> complement = new ArrayList<>();

		int totalCombinations = (1 << length) - 1;

		for (int i = 0; i < totalCombinations; i++)
		{
			String binary = String.format("%" + length + "s", Integer.toBinaryString(i))
				.replace(' ', '0');

			if (!inputSet.contains(binary))
			{
				complement.add(binary);
			}
		}

		return complement;
	}
}