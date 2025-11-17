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
package challenge.leetcode.medium.soupServings;

/**
 * @author Administrator
 * @Created 08/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 808
 * @Name Soup Servings
 * @Difficulty Medium
 * @Tags math
 * dp
 * dynamic programming
 * probability
 * statistics
 * probability and statistics
 * weekly contest 78
 * @link <a href="https://leetcode.com/problems/soup-servings/">www.leetcode.com/808</a>
 * @Description <p>You have two soups, <b>A</b> and <b>B</b>, each starting with <code>n</code> mL.
 * On every turn, one of the following four serving operations is chosen <i>at random</i>,
 * each with probability <code>0.25</code> <b>independent</b> of all previous turns:</p>
 *
 * <ul>
 * 		<li>pour 100 mL from types A and 0 mL from types B</li>
 * 		<li>pour 75 mL from types A and 25 mL from types B</li>
 * 		<li>pour 50 mL from types A and 50 mL from types B</li>
 * 		<li>pour 25 mL from types A and 75 mL from types B</li>
 * </ul>
 *
 * <p><b>Note:</b></p>
 * <ul>
 * 		<li>There is no operation that pours 0 mL from A and 100 mL from B.</li>
 * 		<li>The amounts from A and B are poured <i>simultaneously</i> during the turn.</li>
 * 		<li>If an operation asks you to pour <b>more than</b> you have left of a soup, pour all that remains of that soup.</li>
 * </ul>
 *
 * <p>The process stops immediately after any turn in which <i>one of the soups</i> is used up.</p>
 * <p>Return the probability that A is used up <i>before</i> B,
 * plus half the probability that both soups are used up in the<b> same turn</b>.
 * Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code> n = 50</code>
 * 			<br><b>Output:</b> {@code 0.62500}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;If we perform either of the first two serving operations, soup A will become empty first.
 * 				<br>&emsp;If we perform the third operation, A and B will become empty at the same time.
 * 				<br>&emsp;If we perform the fourth operation, B will become empty first.
 * 				<br>&emsp;So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code> n = 100</code>
 * 			<br><b>Output:</b> {@code 0.71875}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;If we perform the first serving operation, soup A will become empty first.
 * 				<br>&emsp;If we perform the second serving operations, A will become empty on performing operation [1, 2, 3], and both A and B become empty on performing operation 4.
 * 				<br>&emsp;If we perform the third operation, A will become empty on performing operation [1, 2], and both A and B become empty on performing operation 3.
 * 				<br>&emsp;If we perform the fourth operation, A will become empty on performing operation 1, and both A and B become empty on performing operation 2.
 * 				<br>&emsp;So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.71875.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>0 &le; n &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * @Similar <a href=""/> (Leetcode)</a><br>
 * {@link (local)}<br>
 **/
public class SoupServings
{
	public static void main(String[] args)
	{

	}

	public double soupServings(int n)
	{
		return 0;
	}
}
