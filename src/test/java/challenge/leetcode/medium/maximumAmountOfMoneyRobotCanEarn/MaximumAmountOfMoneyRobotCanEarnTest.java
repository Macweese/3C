/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.maximumAmountOfMoneyRobotCanEarn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 05:11 Thu 02 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3418. Maximum Amount of Money Robot Can Earn")
class MaximumAmountOfMoneyRobotCanEarnTest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{-4}},0);
		MAP.put(new int[][]{{10,10,10},{10,10,10}},40);
		MAP.put(new int[][]{{0,1,-1},{1,-2,3},{2,-3,4}},8);
		MAP.put(new int[][]{{-6,-15,-16,-8},{-10,11,6,16},{1,2,18,12},{15,19,4,17}},64);
		MAP.put(new int[][]{{-16,8,-7,-19},{6,3,-10,13},{13,15,4,-3},{-16,4,19,-12}},57);
		MAP.put(new int[][]{{-7,12,12,13},{-6,19,19,-6},{9,-2,-10,16},{-4,14,-10,-9}},60);
	}

	@Test
	void maximumAmount()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MaximumAmountOfMoneyRobotCanEarn.maximumAmount(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}