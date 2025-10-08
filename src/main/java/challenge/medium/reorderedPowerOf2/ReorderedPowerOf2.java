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
package challenge.medium.reorderedPowerOf2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Created 10/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 869
 * @Name Reordered Power of 2
 * @Difficulty Medium
 * @Tags hash table
 * math
 * sorting
 * counting
 * enumeration
 * weekly contest 93
 * @link <a href="https://leetcode.com/problems/reordered-power-of-2">www.leetcode.com/869</a>
 * @Description You are given an integer <code>n</code>.
 * We reorder the digits in any order (including the original order) such that the leading digit is not zero..<br>
 * <br>
 * Return <code>true</code> <i>if and only if we can do this so that the resulting number is a power of two</i>.<br>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>1</code>
 * 			<br><b>Output:</b> {@code true}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>10</code>
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; n &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * @Similar <a href="https://leetcode.com/problems/permutations-ii/"/>47. Permutations II (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/power-of-two/description/"/>231. Power of Two (Leetcode)</a><br>
 * {@link challenge.medium.permutationsII.PermutationsII 47. Permutations II (local)}<br>
 * {@link challenge.easy.powerOfTwo.PowerOfTwo 231. Power of Two (local)}<br>
 **/
public class ReorderedPowerOf2
{
	public static void main(String[] args)
	{

	}

	public static boolean reorderedPowerOf2(int n)
	{
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < 31; i++)
		{
			int number = 1 << i;
			char[] chars = String.valueOf(number).toCharArray();
			Map<Integer, Integer> digitMap = new HashMap<>();

			for (char c : chars)
			{
				int digit = c - '0';
				digitMap.put(digit, digitMap.getOrDefault(digit, 0) + 1);
			}

			map.put(i, digitMap);
		}

		HashMap<Integer, Integer> testNumberDigitMap = new HashMap<>();
		char[] nDigits = String.valueOf(n).toCharArray();
		for (char c : nDigits)
		{
			int digit = c - '0';
			testNumberDigitMap.put(digit, testNumberDigitMap.getOrDefault(digit, 0) + 1);
		}

		return map.entrySet().stream().anyMatch(k -> k.getValue().equals(testNumberDigitMap));
	}
}
