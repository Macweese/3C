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
package challenge.easy.plusOne;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 05/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 66
 * @Name Plus One
 * @Difficulty Easy
 * @Tags array,
 * math
 * @link <a href="https://leetcode.com/problems/plus-one/">www.leetcode.com/66</a>
 * @Description You are given a <b>large integer</b> represented as an integer array <code>digits</code>,
 * where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading <code>0</code>'s.<br>
 *
 * <br>Increment the large integer by one and return <i>the resulting array of digits</i>.
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code digits = [1,2,3]}
 * 			<br><b>Output:</b> {@code [1,2,4]}
 * 			<br><b>Explanation:</b> The array represents the integer 123.
 * 				<br>Incrementing by one gives 123 + 1 = 124.
 * 				<br>Thus, the result should be {@code [1,2,4]}.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code digits = [4,3,2,1]}
 * 			<br><b>Output:</b> {@code [4,3,2,2]}
 * 			<br><b>Explanation:</b> The array represents the integer 4321.
 * 				<br>Incrementing by one gives 4321 + 1 = 4322.
 * 				<br>Thus, the result should be {@code [4,3,2,2]}.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code digits = [9]}
 * 			<br><b>Output:</b> {@code [1,0]}
 * 			<br><b>Explanation:</b> The array represents the integer 9.
 * 				<br>Incrementing by one gives 9 + 1 = 10.
 * 				<br>Thus, the result should be {@code [1,0]}.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; digits.length &le; 100</code></li>
 *     <li><code>0 &le; digits[i] &le; 9</code></li>
 *     <li>{@code digits} does not contain any leading <code>0</code>'s.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class PlusOne
{
	static final int[] DIGITS = new int[]{9, 0, 9};

	public static void main(String[] args)
	{
		BasicConfigurator.configure();

		System.out.println(Arrays.toString(plusOneCopyArrayStripLeadingZeros(DIGITS)));
	}


	// Solution scratchpad comments

	// Solution option 1
	// Convert all the individuals elements in the array into char/strings
	// Concat them
	// Convert into an integer
	// Add 1 to the integer
	// Convert each digit in the new integer to chars/strings
	// Create an array of integers

	// Solution option 2
	// Work with the number right-to-left
	// 1. Add 1 to the element in the array
	// 2. If the result is 0 (9+1 = 10 -> 0 is the new digit) then repeat step 1
	// Repeat until reaching the start of the number.
	// 	Problem: the array has to expand if the result is n+1 digits
	//			 e.g. [9] -> [1,0]

	// Solution option 3
	// Similar idea as option 2
	// Reverse the array
	// Then add as normal and carry over
	// Then reverse again to "restore" the number
	// Example:
	//			 [3,1,5,5] -> [5,5,1,3]
	//			 [5 + 1,5,1,3] -> [6,5,1,3]
	//			 [6,5,1,3] -> [3,1,5,6]
	//
	//			 [9,9] -> [9,9]
	//			 [9 + 1,9] -> [0,9] carry over
	//			 [0,9 + 1] -> [0,0] carry over
	//			 [0,0] -> [0,0,1]
	//			 [0,0,1] -> [1,0,0]
	// This is easier to understand than option 2

	/**
	 * This creates a new array of size n+1.
	 * <br>Adds +1 to all digits until no carry over.
	 * <br>
	 * <br>A) If the last digit (first non-zero element in the array) has carry over.
	 * <br>&#9;Put 1 as the first element.
	 * <br>&#9;(if the last digit carries over, then that means it was a 9, and the resulting digit can only be 1: 9+1,a,b,c... = 1,0,a,b,c...).
	 * <br>
	 * <br>B) If the last digit (first non-zero element in the array) does not carry over.
	 * <br>&#9;Copy the array from position 1 (exclude the leading zero, result from creating an n+1 array) to an array.
	 * <br>Return the result array.
	 * <br>
	 * <br><b>Note:</b>
	 * <br>Not the most elegant solution (the problem constraints insist that <code>digits</code> does not contain leading zeros).
	 * <br>However, test cases such as <code>[0]</code> and <code>[0,1]</code>
	 * exist for the problem on <a href="https://leetcode.com/problems/plus-one/">LeetCode</a>,
	 * which are arrays containing leading zeros. Therefore, this method does a lot of extra work to remove any potential leading zeros.
	 * <br>Alternatively, use {@link #plusOneCopyArray(int[])} or {@link #plusOne(int[])} if no leading zeros can be guaranteed.
	 *
	 * @param digits
	 * @return
	 */
	public static int[] plusOneCopyArrayStripLeadingZeros(int[] digits)
	{
		boolean carryOver = true;
		int[] temp = new int[digits.length + 1];
		System.arraycopy(digits, 0, temp, 1, digits.length);

		for (int i = temp.length - 1; i > 0; i--)
		{
			if (!carryOver)
			{
				break;
			}
			carryOver = temp[i] > 8;
			temp[i] = carryOver ? 0 : (temp[i] + 1);
		}

		if (carryOver)
		{
			temp[0] = 1;
			temp[1] = 0;
			return temp;
		}

		int leadingZeros = 0;
		for (int i = 0; i < temp.length - 1; i++)
		{
			if (temp[i] == 0)
			{
				leadingZeros++;
			}
			else
			{
				break;
			}
		}

		int[] result = new int[digits.length - (leadingZeros - 1)];
		System.arraycopy(temp, leadingZeros, result, 0, temp.length - leadingZeros);
		return result;
	}

	public static int[] plusOneCopyArray(int[] digits)
	{
		boolean carryOver = true;
		for (int i = digits.length - 1; i >= 0; i--)
		{
			if (!carryOver)
			{
				break;
			}
			carryOver = digits[i] > 8;
			digits[i] = carryOver ? 0 : (digits[i] + 1);
		}

		if (!carryOver)
		{
			return digits;
		}
		else
		{
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			System.arraycopy(digits, 0, res, 1, digits.length);
			return res;
		}
	}

	public static int[] plusOne(int[] digits)
	{
		for (int i = digits.length - 1; i >= 0; i--)
		{
			if (digits[i] < 9)
			{
				digits[i] = digits[i] + 1;
				return digits;
			}

			digits[i] = 0;
		}

		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	public static int[] plusOneReverse(int[] digits)
	{
		boolean carry = true;
		int[] temp = new int[digits.length + 1];

		for (int i = digits.length; i > 0; i--)
		{
			temp[digits.length - i] = digits[i - 1];
		}

		for (int i = 0; i < temp.length; i++)
		{
			if (!carry)
			{
				break;
			}
			carry = temp[i] > 8;
			temp[i] = carry ? 0 : (temp[i] + 1);
		}

		for (int i = 0; i < temp.length / 2; i++)
		{
			int val = temp[i];
			temp[i] = temp[temp.length - 1 - i];
			temp[temp.length - 1 - i] = val;
		}

		return temp;
	}
}
