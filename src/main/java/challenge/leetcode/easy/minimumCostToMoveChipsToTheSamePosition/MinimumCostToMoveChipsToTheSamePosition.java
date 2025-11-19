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
package challenge.leetcode.easy.minimumCostToMoveChipsToTheSamePosition;

import challenge.leetcode.easy.splitWithMinimumSum.SplitWithMinimumSum;
import challenge.leetcode.medium.minimumNumberOfOperationsToMoveAllBallsToEachBox.MinimumNumberOfOperationsToMoveAllBallsToEachBox;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:01 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1217
 * @Name Minimum Cost to Move Chips to The Same Position
 * @Difficulty Easy
 * @Tags array
 * string
 * prefix sum
 * weekly contest 229
 * @link <a href="https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/">www.leetcode.com/1217</a>
 * @Description We have n chips, where the position of the ith chip is position[i].<br>
 * <br>
 * We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:<br>
 * <br>
 * position[i] + 2 or position[i] - 2 with cost = 0.<br>
 * position[i] + 1 or position[i] - 1 with cost = 1.<br>
 * <br>
 * Return the minimum cost needed to move all the chips to the same position.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>position = [1,2,3]</code>
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; First step: Move the chip at position 3 to position 1 with cost = 0.
 * 				<br>&emsp; Second step: Move the chip at position 2 to position 1 with cost = 1.
 * 				<br>&emsp; Total cost is 1.
 *
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>position = [2,2,2,3,3]</code>
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; We can move the two chips at position 3 to position 2.
 * 				<br>&emsp; Each move has cost = 1.
 * 				<br>&emsp; The total cost = 2.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>position = [1,1000000000]</code>
 * 			<br><b>Output:</b> {@code 1}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; position.length &le; 100</code></li>
 * 		<li><code>1 &le; position[i] &le; 10<sup>9</sup></code></li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/split-with-minimum-sum/"/>2578. Split With Minimum Sum (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/"/>1769. Minimum Number of Operations to Move All Balls to Each Box (Leetcode)</a><br>
 * <br>
 * {@link SplitWithMinimumSum 2578. Split With Minimum Sum (local)}<br>
 * {@link MinimumNumberOfOperationsToMoveAllBallsToEachBox 1769. Minimum Number of Operations to Move All Balls to Each Box (local)}<br>
 **/
public class MinimumCostToMoveChipsToTheSamePosition
{
}
