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
package challenge.leetcode.easy.climbingStairs;

import challenge.leetcode.easy.climbingStairs.ClimbingStairs;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
@DisplayName("70. Climbing Stairs")
class ClimbingStairsTest
{
	static final Map<Integer, Integer> MAP = Map.of(
		1, 1,
		2, 2,
		3, 3,
		4, 5,
		5, 8,
		16, 1597,
		21, 17711,
		31, 2178309,
		37, 39088169,
		45, 1836311903
	);

	@Test
	void climbStairs()
	{
		for (Map.Entry<Integer, Integer> entry : MAP.entrySet())
		{
			int expected = entry.getValue();
			int actual = ClimbingStairs.climbStairs(entry.getKey());
			String message = "Test failed on case n = " + entry.getKey() + "\nExpected: " + expected + "\nActual: " + actual;
			assertEquals(expected, actual, message);
		}
	}
}