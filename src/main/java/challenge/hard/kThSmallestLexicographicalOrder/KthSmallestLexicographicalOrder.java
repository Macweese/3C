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
package challenge.hard.kThSmallestLexicographicalOrder;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 09/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 440
 * @Name K-th Smallest in Lexicographical Order
 * @Difficulty Hard
 * @Tags trie
 * n-ary tree
 * @link <a href="https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/">www.leetcode.com/440</a>
 * @Description Given two integers <code>n</code> and <code>k</code>,
 * return the k<sup>th</sup> lexicographically smallest integer in the range <code>[1, n]</code>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code n = 13, k = 2}
 * 			<br><b>Output:</b> {@code 10}
 * 			<br><b>Explanation:</b> The lexicographical order is
 * 			<br>{@code [1,10,11,12,13,2,3,4,5,6,7,8,9]},
 * 			<br> so the second smallest number is 10.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 1, k = 1}
 * 			<br><b>Output:</b> {@code 1}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; k &le; n &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 **/
@Slf4j
public class KthSmallestLexicographicalOrder
{
	// TODO: create tests
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

//		System.out.println(findKthNumber(13, 2));
//		System.out.println(findKthNumber(2265, 1718));
//		System.out.println(findKthNumber(681_692_778, 351_251_360)); // expected : 416_126_219
//		System.out.println(findKthNumber(1860, 70)); // expected : 161
	}

	public static int findKthNumber(int n, int index)
	{
		int val = 1;
		index--;

		while (index > 0)
		{
			long nodes = skipNodes(val, val + 1, n);
			if (nodes <= index)
			{
				val++;
				index -= nodes;
			}
			else
			{
				val *= 10;
				index--;
			}
		}
		return val;
	}

	private static long skipNodes(long index, long next, int n)
	{
		int steps = 0;
		while (index <= n)
		{
			steps += Math.min(n + 1, next) - index;
			index *= 10;
			next *= 10;
		}
		return steps;
	}
}
