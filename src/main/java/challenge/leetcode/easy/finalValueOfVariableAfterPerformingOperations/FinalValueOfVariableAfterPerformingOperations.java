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
package challenge.leetcode.easy.finalValueOfVariableAfterPerformingOperations;

/**
 * @author Administrator
 * @Created 24/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2011
 * @Name Final Value of Variable After Performing Operations
 * @Difficulty Easy
 * @Tags array
 * string
 * simulation
 * weekly contest 259
 * @link <a href="https://leetcode.com/problems/final-value-of-variable-after-performing-operations/">www.leetcode.com/2011</a>
 * @Description There is a programming language with only <b>four</b> operations and one variable <code>X</code>:<br>
 *
 * <ul>
 * 		<li><code>++X</code> and <code>X++</code> increments the value of the variable <code>X</code> by <code>1</code>.</li>
 * 		<li><code>--X</code> and <code>X--</code> decrements the value of the variable <code>X</code> by <code>1</code>.</li>
 * </ul>
 * <p>
 * Initially, the value of <code>X</code> is <code>0</code>.<br>
 *
 * <br>Given an array of strings <code>operations</code> containing a list of operations,
 * return the <i><b>final</b> value of</i> <code>X</code> <i>after performing all the operations</i>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code operations = ["--X","X++","X++"]}
 * 			<br><b>Output:</b> {@code 1}
 * 			<br><b>Explanation:</b> The operations are performed as follows:
 * 			<br>&emsp;Initially, X = 0.
 * 			<br>&emsp;--X: X is decremented by 1, X =  0 - 1 = -1.
 * 			<br>&emsp;X++: X is incremented by 1, X = -1 + 1 =  0.
 * 			<br>&emsp;X++: X is incremented by 1, X =  0 + 1 =  1.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code operations = ["++X","++X","X++"]}
 * 			<br><b>Output:</b> {@code 3}}
 * 			<br><b>Explanation:</b> The operations are performed as follows:
 * 			<br>&emsp;Initially, X = 0.
 * 			<br>&emsp;++X: X is incremented by 1, X = 0 + 1 = 1.
 * 			<br>&emsp;++X: X is incremented by 1, X = 1 + 1 = 2.
 * 			<br>&emsp;X++: X is incremented by 1, X = 2 + 1 = 3.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code operations = ["X++","++X","--X","X--"]}
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> The operations are performed as follows:
 * 			<br>&emsp;Initially, X = 0.
 * 			<br>&emsp;X++: X is incremented by 1, X = 0 + 1 = 1.
 * 			<br>&emsp;++X: X is incremented by 1, X = 1 + 1 = 2.
 * 			<br>&emsp;--X: X is decremented by 1, X = 2 - 1 = 1.
 * 			<br>&emsp;X--: X is decremented by 1, X = 1 - 1 = 0.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; operations.length &le; 100</code></li>
 * 		<li>operations[i] will be either <code>"++X"</code>, <code>"X++"</code>, <code>"--X"</code>, or <code>"X--"</code>.</li>
 * </ul>
 * </p>
 **/
public class FinalValueOfVariableAfterPerformingOperations
{
	public static int finalValueAfterOperations(String[] operations)
	{
		int x = 0;
		for (String op : operations)
		{
			x = op.charAt(1) == '+' ? x + 1 : x - 1;
		}
		return x;
	}
}
