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
package challenge.leetcode.easy.findTheMaximumNumberAchievable;

/**
 * @author Administrator
 * @Created 22/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2769
 * @Name Find the Maximum Achievable Number
 * @Difficulty Easy
 * @Tags math
 * weekly contest 353
 * @link <a href="https://leetcode.com/problems/find-the-maximum-achievable-number/">www.leetcode.com/2769</a>
 * @Description Given two integers, <code>num</code> and <code>t</code>.
 * A <b>number</b> <code>x</code> is <b>achievable</b> if it can become equal to <code>num</code>
 * after applying the following operation <b>at most</b> <code>t</code> times:
 *
 * <ul>
 *     <li> Increase or decrease <code>x</code> by 1, and <i>simultaneously</i> increase or decrease <code>num</code> by 1.</li>
 * </ul>
 * Return the <b>maximum</b> possible value of <code>x</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = num = 4, t = 1}
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> Apply the following operation once to make the maximum achievable number equal to <code>num</code>:
 * 				<br>Decrease the maximum achievable number by 1, and increase <code>num</code> by 1.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code num = 3, t = 2}
 * 			<br><b>Output:</b> {@code 7}
 * 			<br><b>Explanation:</b> Apply the following operation twice to make the maximum achievable number equal to <code>num</code>:
 * 				<br>Decrease the maximum achievable number by 1, and increase <code>num</code> by 1.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>1 &le; num, t &le; 50</code></li>
 * </ul>
 * </p>
 **/
public class FindTheMaximumNumberAchievable
{
	public static int theMaximumAchievableX(int num, int t)
	{
		return num + t * 2;
	}
}
