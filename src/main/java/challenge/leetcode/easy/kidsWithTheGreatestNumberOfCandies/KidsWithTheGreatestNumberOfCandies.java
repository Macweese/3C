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
package challenge.leetcode.easy.kidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @Created 13/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1431
 * @Difficulty Easy
 * @Tags array
 * arrays
 * @link <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">www.leetcode.com/1431</a>
 * @Description There are <code>n</code> kids with candies. You are given an integer array <code>candies</code>,
 * where each <code>candies[i]</code> represents the number of candies the <code>i<sup>th</sup></code> kid has,
 * and an integer <code>extraCandies</code>, denoting the number of extra candies that you have.<br>
 *
 * <br>Return <i>a boolean array</i> <code>result</code> <i>of length</i> <code>n</code>
 * <i>, where</i> <code>result[i]</code> <i>is</i> <code>true</code> <i>if, after giving the</i> <code>i<sup>th</sup></code> <i>kid all the</i> <code>extraCandies</code>
 * <i>, they will have the <b>greatest</b> number of candies among all the kids, or</i> <code>false</code> <i>otherwise.</i><br>
 *
 * <br>Note that <b>multiple</b> kids can have the <b>greatest</b> number of candies.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code candies = [2,3,5,1,3], extraCandies = 3}
 * 			<br><b>Output:</b> {@code [true,true,true,false,true]}
 * 			<br><b>Explanation:</b> If you give all <code>extraCandies</code> to:
 * 			<ul>
 * 				<li>Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.</li>
 * 				<li>Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.</li>
 * 				<li>Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.</li>
 * 				<li>Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.</li>
 * 				<li>Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.</li>
 * 			</ul>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code candies = [4,2,1,1,2], extraCandies = 1}
 * 			<br><b>Output:</b> {@code [true,false,false,false,false]}
 * 			<br><b>Explanation:</b> There is only 1 extra candy.
 * 				Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code candies = [12,1,12], extraCandies = 10}
 * 			<br><b>Output:</b> {@code [true,false,true]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>n == candies.length</code></li>
 *     <li><code>2 &le; n &le; 100</code></li>
 *     <li><code>1 &le; candies[i] &le; 100</code></li>
 *     <li><code>1 &le; extraCandies &le; 50</code></li>
 * </ul>
 * </p>
 **/
@Slf4j
public class KidsWithTheGreatestNumberOfCandies
{
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies)
	{
		int max = 0;
		for (int i : candies)
		{
			max = Math.max(max, i);
		}

		List<Boolean> result = new ArrayList<>(candies.length);
		for (int i : candies)
		{
			result.add(i + extraCandies >= max);
		}

		return result;
	}
}
