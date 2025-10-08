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
package challenge.easy.palindromeNumber;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 22/03/2019,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 9
 * @Difficulty Easy
 * @Tags math
 * @link <a href="https://leetcode.com/problems/palindrome-number/">www.leetcode.com/9</a>
 * @Description Given an integer {@code x}, return {@code true} <i>if</i> {@code x} <i>is a palindrome</i><sup>1</sup><i>, and</i> {@code false} <i>otherwise</i>.<br>
 *
 * <p>
 * <br>1. Palindrome
 * <br>An integer is a palindrome when it reads the same forward and backward.
 * <br>For example, 121 is a palindrome while 123 is not.
 * </p>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code x = 121}
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> 121 reads as 121 from left to right and from right to left.<br>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code x = -121}
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.<br>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code x = 10}
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> Reads 01 from right to left. Therefore it is not a palindrome.<br>
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li>{@code -231 <= x <= 231 - 1}</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class PalindromeNumber
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

		int a = 121;
		int b = -121;
		int c = 10;
		int d = 1001;
		int e = 1001001;
		int f = 999;
		int g = 123454321;
		int h = 0;

		int[] ints = {a, b, c, d, e, f, g, h};
		for (int i : ints)
		{
//			log.info("Palindrome check: {} \t{}", isPalindrome(i), i);
		}
	}

	@VisibleForTesting
	public static boolean isPalindrome(int x)
	{
		if (Integer.signum(x) == -1)
		{
			return false;
		}
		return x == 0 || x == reverse(x, 0);
	}

	public static int reverse(int n, int reversed)
	{
		if (n > 0)
		{
			int mod = n % 10;
			reversed = reversed * 10 + mod;
			n /= 10;
			return reverse(n, reversed);
		}
		return reversed;
	}
}
