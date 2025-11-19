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
package challenge.leetcode.easy.powerOfTwo;

import challenge.leetcode.easy.powerOfFour.PowerOfFour;
import challenge.leetcode.easy.powerOfThree.PowerOfThree;

/**
 * @author Administrator
 * @Created 09/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 231
 * @Name Power of Two
 * @Difficulty Easy
 * @Tags math
 * bit manipulation
 * recursion
 * @link <a href="https://leetcode.com/problems/power-of-two/">www.leetcode.com/231</a>
 * @Description Given an integer <code>n</code>, return <i><code>true</code> if it is a power of two. Otherwise, return <code>false</code></i>.<br>
 * <br>
 * An integer <code>n</code> is a power of two, if there exists an integer <code>x</code> such that <code>n == 2<sup>x</sup></code>.
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>1</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> 2<sup>0</sup> = 1
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>16</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> 2<sup>4</sup> = 16
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>3</code>
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>-2<sup>31</sup> &le; n &le; 2<sup>31</sup>-1</code></li>
 * </ul>
 * </p>
 * <br>
 *
 * <b>Follow up:</b><br>
 * Could you solve it without loops/recursion?<br>
 * <br>
 * @Similar <a href="https://leetcode.com/problems/number-of-1-bits/"/>191. Number of 1 bits (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/power-of-three/"/>326. Power of Three (Leetcode)</a><br>
 * <a href="https://leetcode.com/problems/power-of-four/"/>342. Power of Four (Leetcode)</a><br>
 * {@link challenge.easy.numberOf1Bits.NumberOf1Bits 191. Number of 1 Bits (local)}<br>
 * {@link PowerOfThree 326. Power of Three (local)}<br>
 * {@link PowerOfFour 342. Power of Four (local)}<br>
 **/
public class PowerOfTwo
{
	public static boolean isPowerOfTwo(int n)
	{
		return 0 < n && Integer.bitCount(n) == 1;
	}
}
