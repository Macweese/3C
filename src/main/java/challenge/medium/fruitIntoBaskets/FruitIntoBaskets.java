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
package challenge.medium.fruitIntoBaskets;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Administrator
 * @Created 04/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 904
 * @Name Fruits Into Baskets
 * @Difficulty Medium
 * @Tags array
 * arrays
 * hash table
 * sliding window
 * weekly contest 102
 * @link <a href="https://leetcode.com/problems/fruit-into-baskets/">www.leetcode.com/904</a>
 * @Description You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array <code>fruits</code> where
 * <code>fruits[i]</code> is the <b>types</b> of fruit the <code>i<sup>th</sup></code> tree produces.<br>
 * <br>
 * You want to collect as much fruit as possible.
 * However, the owner has some strict rules that you must follow:<br>
 *
 * <ul>
 * 		<li>You only have <b>two</b> baskets, and each basket can only hold a <b>single types</b> of fruit.
 * 			There is no limit on the amount of fruit each basket can hold.</li>
 * 		<li>Starting from any tree of your choice,
 * 			you must pick <b>exactly one fruit</b> from <b>every</b> tree (including the start tree) while moving to the right.
 * 			The picked fruits must fit in one of your baskets.</li>
 * 		<li>Once you reach a tree with fruit that cannot fit in your baskets, you must stop.</li>
 * </ul>
 * <br>
 * Given the integer array <code>fruits</code>, return <i>the <b>maximum</b> number of fruits you can pick</i>.
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>fruits = [<u>1,2,1</u>]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> We can pick from all 3 trees.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>fruits = [0,<u>1,2,2</u>]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> We can pick from trees [1,2,2].
 * 				<br>&emsp;If we had started at the first tree, we would only pick from trees [0,1].
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>fruits = [1,<u>2,3,2,2</u>]</code>
 * 			<br><b>Output:</b> {@code 4}
 * 			<br><b>Explanation:</b> We can pick from trees [2,3,2,2].
 * 				<br>&emsp;If we had started at the first tree, we would only pick from trees [1,2].
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &lt;= fruits.length &lt;= 10<sup>5</sup></code></li>
 * 		<li><code>0 &lt;= fruits[i] &lt; fruits.length</code></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * <br>
 *
 * <b>Similar problems:</b>
 * <ol>
 * 		<li><a href="https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/">1481. Least Number of Unique Integers After k Removals</a></li>
 * 		<li><a href="https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/">159. Longest Substring with At Most Two Distinct Characters</a></li>
 * </ol>
 *
 * <b>Other Sliding-Window problems:</b>
 * <ul>
 * 		<li><a href=""></a>160. Count Number of Nice Subarrays</li>
 * 		<li><a href=""></a>161. Replace the Substring for Balanced String</li>
 * 		<li><a href=""></a>162. Max Consecutive Ones III</li>
 * 		<li><a href=""></a>163. Binary Subarrays With Sum</li>
 * 		<li><a href=""></a>164. Subarrays with K Different Integers</li>
 * 		<li><a href=""></a>165. Fruit Into Baskets</li>
 * 		<li><a href=""></a>166. Shortest Subarray with Sum at Least K</li>
 * 		<li><a href=""></a>167. Minimum Size Subarray Sum</li>
 *
 * </ul>
 **/
public class FruitIntoBaskets
{
	public static void main(String[] args)
	{

	}

	public static int getLongestSequenceOfTwoValues(int[] fruits)
	{
		int maxLen = 0;
		int i = 0;
		int j = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		while (j < fruits.length)
		{
			map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
			while (map.size() > 2)
			{
				map.put(fruits[i], map.get(fruits[i]) - 1);
				if (map.get(fruits[i]) == 0)
				{
					map.remove(fruits[i]);
				}
				i++;
			}
			maxLen = Math.max(maxLen, j - i + 1);
			j++;
		}
		return maxLen;
	}

	public static int totalFruit(int[] fruits)
	{
		int bestPosition = 0;
		for (int i = 0; i < fruits.length; i++)
		{
			bestPosition = Math.max(bestPosition, takeFruits(fruits, i));
		}

		return bestPosition;
	}

	// Solution works but TLE because its O(n*n)
	public static int takeFruits(int[] fruits, int startPos)
	{
		int best = 0;
		int sum = 0;
		HashSet<Integer> fruitTypes = new HashSet<>(2);
		fruitTypes.add(fruits[startPos]);

		for (int i = startPos; i < fruits.length; i++)
		{
			if (fruitTypes.size() == 2 && !fruitTypes.contains(fruits[i]))
			{
				break;
			}
			fruitTypes.add(fruits[i]);

			sum = Math.max(1, sum + 1);
			best = Math.max(best, sum);
		}
		return best;
	}
}
