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
package challenge.medium.new21Game;

/**
 * @author Administrator
 * @Created 17/08/2025, 06:36 Sun 17 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 837
 * @Name New 21 Game
 * @Difficulty Medium
 * @Tags math
 * dp
 * dynamic programming
 * sliding window
 * probability and statistics
 * weekly contest 85
 * @link <a href="https://leetcode.com/problems/new-21-game/">www.leetcode.com/837</a>
 * @Description Alice plays the following game, loosely based on the card game <b>"21"</b>.<br>
 * <br>
 * Alice starts with <b>0</b> points and draws numbers while she has less than <b>k</b> points.
 * During each draw, she gains an integer number of points randomly from the range <code>[1, maxPts]</code>,
 * where <code>maxPts</code> is an integer. Each draw is independent and the outcomes have equal probabilities.<br>
 * <br>
 * Alice stops drawing numbers when she gets <code>k</code> <b>or more points</b>.<br>
 * <br>
 * Return the probability that Alice has <code>n</code> or fewer points.<br>
 * <br>
 * Answers within <code>10<sup>-5</sup></code> of the actual answer are considered accepted.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>n = 10, k = 1, maxPts = 10</code>
 * 			<br><b>Output:</b> {@code 1.00000}
 * 			<br><b>Explanation:</b> Alice gets a single card, then stops.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>n = 6, k = 1, maxPts = 10</code>
 * 			<br><b>Output:</b> {@code 0.60000}
 * 			<br><b>Explanation:</b> Alice gets a single card, then stops.
 * 				<br>&emsp; In 6 out of 10 possibilities, she is at or below 6 points.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>n = 21, k = 17, maxPts = 10</code>
 * 			<br><b>Output:</b> {@code 0.73278}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li>0 &le; k &le; n &le; 10<sup>4</sup></li>
 * 		<li>1 &le; maxPts &le; 10<sup>4</sup></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar
 **/
public class New21Game
{
	public static void main(String[] args)
	{

	}

	public static double new21Game(int n, int k, int maxPoints)
	{

		return 0;
	}
}
