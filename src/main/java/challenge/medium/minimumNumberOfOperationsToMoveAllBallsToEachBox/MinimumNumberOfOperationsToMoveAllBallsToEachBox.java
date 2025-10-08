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
package challenge.medium.minimumNumberOfOperationsToMoveAllBallsToEachBox;

/**
 * @author Administrator
 * @Created 18/08/2025, 05:01 Mon 18 August 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1769
 * @Name Minimum Number of Operations to Move All Balls to Each Box
 * @Difficulty Medium
 * @Tags array
 * string
 * prefix sum
 * weekly contest 229
 * @link <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/">www.leetcode.com/1769</a>
 * @Description You have <code>n</code> boxes.
 * You are given a binary string <code>boxes</code> of length <code>n</code>,
 * where <code>boxes[i]</code> is <code>'0'</code> if the <code>i<sup>th</sup></code> box is <b>empty</b>,
 * and <code>'1'</code> if it contains <b>one</b> ball.<br>
 * <br>
 * In one operation, you can move <b>one</b> ball from a box to an adjacent box.
 * Box <code>i</code> is adjacent to box <code>j</code> if <code>abs(i - j) == 1</code>.
 * Note that after doing so, there may be more than one ball in some boxes.<br>
 * <br>
 * Return an array <code>answer</code> of size <code>n</code>,
 * where <code>answer[i]</code> is the <b>minimum</b> number of operations needed
 * to move all the balls to the <code>i<sup>th</sup></code> box.<br>
 * <br>
 * Each <code>answer[i]</code> is calculated considering the <b>initial</b> state of the boxes.<br>
 *
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>boxes = "110"</code>
 * 			<br><b>Output:</b> {@code [1,1,3]}
 * 			<br><b>Explanation:</b> The answer for each box is as follows:
 * 				<br>&emsp; 1. First box: you will have to move one ball from the second box to the first box in one operation.
 * 				<br>&emsp; 2. Second box: you will have to move one ball from the first box to the second box in one operation.
 * 				<br>&emsp; 3. Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 *
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>boxes = "001011"</code>
 * 			<br><b>Output:</b> {@code [11,8,5,4,3,4]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>n == boxes.length</code></li>
 * 		<li><code>1 &le; n &le; 2000</code></li>
 * 		<li><code>boxes[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
 * </ul>
 * </p>
 * <br>
 * <hr>
 * @Similar <a href="https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/"/>1217. Minimum Cost to Move Chips to The Same Position (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/"/>2850. Minimum Moves to Spread Stones Over Grid (Leetcode)</a><br>
 * <br>
 * {@link challenge.easy.minimumCostToMoveChipsToTheSamePosition.MinimumCostToMoveChipsToTheSamePosition 1217. Minimum Cost to Move Chips to The Same Position (local)}<br>
 * {@link challenge.medium.minimumMovesToSpreadStonesOverGrid.MinimumMovesToSpreadStonesOverGrid 2850. Minimum Moves to Spread Stones Over Grid (local)}<br>
 **/
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox
{
}
