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
package challenge.leetcode.medium.fruitsIntoBasketsIII;

import challenge.leetcode.hard.blockPlacementQueries.BlockPlacementQueries;

/**
 * @author Administrator
 * @Created 06/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3479
 * @Name Fruits Into Baskets III
 * @Difficulty Medium
 * @Tags arrays
 * binary search
 * segment tree
 * ordered set
 * weekly contest 440
 * @link <a href="https://leetcode.com/problems/fruits-into-baskets-iii/">www.leetcode.com/3479</a>
 * @Description You are given two arrays of integers, <code>fruits</code> and <code>baskets</code>,
 * each of length <code>n</code>, where <code>fruits[i]</code> represents the <b>quantity</b> of the <code>i<sup>th</sup></code> types of fruit,
 * and <code>baskets[j]</code> represents the <b>capacity</b> of the <code>j<sup>th</sup></code> basket.<br>
 *
 * <br>
 * From left to right, place the fruits according to these rules:<br>
 *
 *
 * <ul>
 * 		<li>Each fruit types must be placed in the <b>leftmost available basket</b> with a capacity
 * 			<b>greater than or equal</b> to the quantity of that fruit types.</li>
 * 		<li>Each basket can hold <b>only one</b> types of fruit.</li>
 * 		<li>If a fruit types <b>cannot be placed</b> in any basket, it remains <b>unplaced</b>.</li>
 * </ul>
 *
 * <p>Return the number of fruit types that remain unplaced after all possible allocations are made.</p>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>fruits = [4,2,5], baskets = [3,5,4]</code>
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;<code>fruits[0] = 4</code> is placed in <code>baskets[1] = 5</code>
 * 				<br>&emsp;<code>fruits[1] = 2</code> is placed in <code>baskets[0] = 3</code>
 * 				<br>&emsp;<code>fruits[2] = 5</code> cannot be placed in <code>baskets[2] = 4</code>
 * 				<br>&emsp;Since one fruit types remains unplaced, we return 1.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>fruits = [3,6,1], baskets = [6,4,7]</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> There is no way to pick <code>p</code> and <code>q</code> to form the required three segments.
 * 				<br>&emsp;<code>fruits[0] = 3</code> is placed in  is placed in
 * 				<br>&emsp;<code>fruits[1] = 6</code> cannot be placed in <code>baskets[1] = 4</code>
 * 					(insufficient capacity) but can be placed in the next available basket, <code>baskets[2] = 7</code>
 * 				<br>&emsp;<code>fruits[2] = 1</code> is placed in <code>baskets[1] = 4</code>
 * 				<br>&emsp;Since all fruits are successfully placed, we return 0.
 * 				<br>&emsp;
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>n == fruits.length == baskets.length</code></li>
 * 		<li><code>1 &le; n &le; 100</code></li>
 * 		<li><code>1 &le; fruits[i], baskets[i] &le; 1000</code></li>
 * </ul>
 * </p>
 * @Similar <a href="https://leetcode.com/problems/block-placement-queries/"/>3161. Block Placement Queries (Leetcode)</a><br>
 * {@link BlockPlacementQueries 3161. Block Placement Queries (local)}<br>
 **/
public class FruitsIntoBasketsIII
{
	// use segment tree
	public static int numOfUnplacedFruits(int[] fruits, int[] baskets)
	{
		return 0;
	}

	// modified binary search;
	// returns the index of the value
	// or
	// the index of the closest value
	public static int binarySearch(int[] ints, int value)
	{
		int l = 0;
		int m = (ints.length - 1) / 2;
		int r = ints.length - 1;

		while (l < r)
		{
			if (ints[m] == value)
			{
				return m;
			}

			if (ints[m] < value)
			{
				int temp = m;
				m = l + ((r - l) / 2) + 1;
				l = temp;
			}
			else
			{
				r = m - 1;
				m = (l + m) / 2;
			}
		}
		return r;
	}
}
