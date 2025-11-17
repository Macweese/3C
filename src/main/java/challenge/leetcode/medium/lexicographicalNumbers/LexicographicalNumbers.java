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
package challenge.leetcode.medium.lexicographicalNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 08/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 386
 * @Name Lexicographical Numbers
 * @Difficulty Medium
 * @Tags depth first search,
 * dfs,
 * trie
 * @link <a href="https://leetcode.com/problems/lexicographical-numbers/">www.leetcode.com/386</a>
 * @Description Given an integer <code>n</code>,
 * return all the numbers in the range <code>[1, n]</code> sorted in lexicographical order.<br>
 * <br>You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code n = 13}
 * 			<br><b>Output:</b> {@code [1,10,11,12,13,2,3,4,5,6,7,8,9]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 2}
 * 			<br><b>Output:</b> {@code [1,2]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; n &le; (5 * 10<sup>4</sup>)</code></li>
 * </ul>
 * </p>
 **/
@Slf4j
public class LexicographicalNumbers
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

	}

	public static List<Integer> lexicalOrder(int n)
	{
		List<Integer> list = new ArrayList<>();
		int i = 1;

		while (list.size() < n)
		{
			list.add(i);

			if (i * 10 <= n)
			{
				i = i * 10;
			}
			else
			{
				while (i == n || i % 10 == 9)
				{
					i = i / 10;
				}
				i++;
			}
		}

		return list;
	}

	/* ------------------------------------------------------
	 * --- --- --- CODE BELOW IS ONLY FOR TESTING --- --- ---
	 * ------------------------------------------------------*/

	static int round(int number, int multiple)
	{
		int result = multiple;

		//If not already multiple of given number
		if (number % multiple != 0)
		{
			int division = (number / multiple) + 1;
			result = division * multiple;
		}

		return result;
	}

	static int[] getDigits(int n)
	{
		int d = (int) Math.log10(n) + 1;
		int[] digits = new int[d];
		for (int i = n; i > 0; d--)
		{
			digits[digits.length - d] = n % 10;
			i = n /= 10;
		}
		return digits;
	}

	private static int getDigitCount(int n)
	{
		return (int) Math.log10(n) + 1;
	}

	static int getMax(int n)
	{
		int digits = getDigitCount(n);

		int max = (int) (Math.pow(10, digits + 1) - 1);

		for (int i = 9; i > 0; --i)
		{
			if (n >= max || n > i * Math.pow(10, digits))
			{
				break;
			}

			if (i * Math.pow(10, digits) >= n)
			{
				max = (int) ((i) * Math.pow(10, digits));
			}
		}
		return max - 1;
	}

	private static void find(int[] ints, int numberToFind, int k)
	{
		List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
		System.out.println(numberToFind + " index : " + (list.indexOf(numberToFind)));
		System.out.println(k + " th number : " + list.get((k)));
		System.out.println("max digits : " + getDigitCount(ints.length));
	}

	private static void find(List<Integer> ints, int numberToFind, int k)
	{
		System.out.println(numberToFind + " index : " + (ints.indexOf(numberToFind)));
		System.out.println(k + " th number : " + ints.get((k - 1)));
		System.out.println("max digits : " + getDigitCount(ints.size()));
	}

	private static void printLexicalOrder()
	{
		printLexicalOrder(1, 50_000);
	}

	private static void printLexicalOrder(int maxValue)
	{
		printLexicalOrder(1, maxValue);
	}

	private static void printLexicalOrder(int n, int maxValue)
	{
		for (int i = 0; i < n; i++)
		{
			int random = ThreadLocalRandom.current().nextInt(maxValue + 1);
			System.out.println(random + " : " + lexicalOrder(random));
		}
	}
}
