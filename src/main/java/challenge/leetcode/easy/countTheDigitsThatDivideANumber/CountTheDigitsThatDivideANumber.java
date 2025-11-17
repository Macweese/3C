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
package challenge.leetcode.easy.countTheDigitsThatDivideANumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2520
 * @Name Count the Digits That Divide a Number
 * @Difficulty Easy
 * @Tags math
 * weekly contest 326
 * @link <a href="https://leetcode.com/problems/count-the-digits-that-divide-a-number/">www.leetcode.com/2520</a>
 * @Description Given an integer <code>num</code>, return <i>the number of digits in <code>num</code> that divide</i> <code>num</code>.<br>
 * <br>
 * An integer <code>val</code> divides <code>nums</code> if <code>nums % val == 0</code>.<br>
 * <br>
 * Return the maximum number of words that appear in a single sentence.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>sentences = ["alice and bob love leetcode", "i think so too", "<u>this is great thanks very much</u>"]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b>
 * 			<br>&emsp;- The first sentence, "alice and bob love leetcode", has 5 words in total.
 * 			<br>&emsp;- The second sentence, "i think so too", has 4 words in total.
 * 			<br>&emsp;- The third sentence, "this is great thanks very much", has 6 words in total.
 * 			<br>&emsp;Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
 *
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>sentences = ["please wait", "<u>continue to fight</u>", "<u>continue to win</u>"]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> It is possible that multiple sentences contain the same number of words.
 * 			<br>&emsp;In this example, the second and third sentences (underlined) have the same number of words.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; num &le; 10<sup>9</sup></code></li> <!--- NOTE: THIS IS CONTRADICTORY TO THE 2ND CONSTRAINT, AS 10^9 CONTAINS '0', SHOULD BE 1<num<10^9 --->
 *     <li><code>num</code> does not contain <code>0</code> as one of its digits.</li>
 * </ul>
 * </p>
 **/
public class CountTheDigitsThatDivideANumber
{
	public static void main(String[] args)
	{

		System.out.println(countDigits(1));            // Expected: 1
		System.out.println(countDigits(57));            // Expected: 0
		System.out.println(countDigits(575));            // Expected: 2
		System.out.println(countDigits(11111111));        // Expected: 8
	}

	public static int countDigits(int num)
	{
		Map<Integer, Integer> map = getDigits(num);
		System.out.println(map);

		int div = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if (num % entry.getKey() == 0)
			{
				div += entry.getValue();
			}
		}

		return div;
	}

	static Map<Integer, Integer> getDigits(int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = n; i > 0; )
		{
			int j = n % 10;
			map.put(j, map.getOrDefault(j, 0) + 1);
			i = n /= 10;
		}
		return map;
	}
}
