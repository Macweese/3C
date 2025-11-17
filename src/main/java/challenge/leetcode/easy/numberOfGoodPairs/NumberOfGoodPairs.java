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

package challenge.leetcode.easy.numberOfGoodPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Created 12/09/2025, 17:10 Fri 12 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1512
 * @Name Number of Good Pairs
 * @Difficulty Easy
 * @Tags array
 * hash table
 * math
 * counting
 * weekly contest 197
 * @link <a href="https://leetcode.com/problems/number-of-good-pairs/">www.leetcode.com/1512</a>
 * @Description Given an array of integers <code>nums</code>, return <i>the number of <b>good pairs</b></i>.<br>
 * <br>
 * A pair <code>(i, j)</code> is called <i>good</i> if <code>nums[i] == nums[j]</code> and <code>i < j</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3,1,1,3]</code>
 * 			<br><b>Output:</b> {@code 4}
 * 			<br><b>Explanation:</b> There are 4 good pairs
 * 				<code>(0,3)</code>, <code>(0,4)</code>, <code>(3,4)</code>, <code>(2,5)</code> 0-indexed.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,1,1,1]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> Each pair in the array are good.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3]</code>
 * 			<br><b>Output:</b> {@code 0}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; nums.length &le; 100</code></li>
 * 		<li><code>1 &le; nums[i] &le; 100</code></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/"/>2001. Number of Pairs of Interchangeable Rectangles (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/"/>2083. Substrings That Begin and End With the Same Letter (Leetcode)</a><br>
 * <br>
 * {@link challenge.medium.numberOfPairsOfInterchangeableRectangles.interchangeableRectangles 2001. Number of Pairs of Interchangeable Rectangles (local)}<br>
 * {@link challenge.medium.substringsThatBeginAndEndWithTheSameLetter.numberOfSubstrings 2083. Substrings That Begin and End With the Same Letter (local)}<br>
 **/
public class NumberOfGoodPairs
{
	public static void main(String[] args)
	{
	}

	public static int numIdenticalPairs(int[] ints)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : ints)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int pairs = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			int count = entry.getValue();
			pairs += (count * (count - 1)) / 2;
		}

		return pairs;
	}
}
