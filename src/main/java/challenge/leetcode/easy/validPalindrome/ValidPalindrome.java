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
package challenge.leetcode.easy.validPalindrome;

import challenge.leetcode.easy.findFirstPalindromicStringInArray.FindFirstPalindromicStringInArray;

/**
 * @author Administrator
 * @Created 16/08/2025, 19:01 Sat 16 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 125
 * @Name Valid Palindrome
 * @Difficulty Easy
 * @Tags string
 * two pointers
 * @link <a href="https://leetcode.com/problems/valid-palindrome/">www.leetcode.com/125</a>
 * @Description A phrase is a <b>palindrome</b> if,
 * after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.<br>
 * <br>
 * Given a string <code>s</code>, return <code>true</code> <i>if it is a <b>palindrome</b>, or</i> <code>false</code> <i>otherwise</i>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>s = "A man, a plan, a canal: Panama"</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> "amanaplanacanalpanama" is a palindrome.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>s = "race a car"</code>
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> "raceacar" is not a palindrome.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>s = " "</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> s is an empty string "" after removing non-alphanumeric characters.
 * 			<br>&emsp; Since an empty string reads the same forward and backward, it is a palindrome.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>1 &le; s.length &le; 2 &times; 10<sup>5</sup></li>
 * 		<li><code>s</code> consists only of printable ASCII characters.</li>
 * </ul>
 * </p>
 *
 * <br>
 * @Similar <a href="https://leetcode.com/problems/palindrome-linked-list/"/>234. Palindrome Linked List (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/valid-palindrome-ii/"/>680. Valid Palindrome II (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/find-first-palindromic-string-in-the-array/"/>2108. Find First Palindromic String in the Array (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/"/>2002. Maximum Product of the Length of Two Palindromic Subsequences (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/valid-palindrome-iv/"/>2330. Valid Palindrome IV (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/maximum-palindromes-after-operations/"/>3035. Maximum Palindromes After Operations (Leetcode)</a><br>
 * {@link challenge.easy.palindromeLinkedList.PalindromeLinkedList 234. Palindrome Linked List (local)}<br>
 * {@link challenge.easy.validPalindromeII.ValidPalindromeII 680. Valid Palindrome II (local)}<br>
 * {@link FindFirstPalindromicStringInArray 2108. Find First Palindromic String in the Array (local)}<br>
 * {@link challenge.medium.maximumProductOfTheLengthOfTwoPalindromicSubsequences.MaximumProductOfTheLengthOfTwoPalindromicSubsequences 2002. Maximum Product of the Length of Two Palindromic Subsequences (local)}<br>
 * {@link challenge.medium.validPalindromeIV.ValidPalindromeIV 2330. Valid Palindrome IV (local)}<br>
 * {@link challenge.medium.maximumPalindromesAfterOperations.MaximumPalindromesAfterOperations 3035. Maximum Palindromes After Operations (local)}<br>
 **/
public class ValidPalindrome
{
	public static boolean isPalindrome(String s)
	{
		s = s.toLowerCase().replaceAll("\\P{Alnum}", "");
		char[] chars = s.toLowerCase().replaceAll("\\P{Alnum}", "").toCharArray();

		for (int l = (s.length() / 2) - 1, r = (s.length() + 1) / 2; l >= 0; l--, r++)
		{
			if (chars[l] != chars[r])
			{
				return false;
			}
		}

		return true;
	}

	public static boolean isPalindromeSolution2(String s)
	{
		s = s.toLowerCase().replaceAll("\\P{Alnum}", "");

		int i = 0;
		int j = s.length() - 1;
		while (i < j)
		{
			if (s.charAt(i) != s.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static boolean isPalindromeSolution3(String s)
	{
		int i = 0;
		int j = s.length() - 1;
		while (i <= j)
		{
			if (!Character.isLetterOrDigit(s.charAt(i)))
			{
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j)))
			{
				j--;
				continue;
			}
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
			{
				return false;
			}
			i++;
			j--;
		}

		return true;
	}
}
