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

package challenge.leetcode.medium.countSpecialTriplets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:34 Wed 10 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3583. Count Special Triplets")
class CountSpecialTripletsTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{6,3,6},1);
		MAP.put(new int[]{0,1,0,0},1);
		MAP.put(new int[]{8,4,2,8,4},2);
		MAP.put(new int[]{0,0,0,0,0},10);
		MAP.put(new int[]{1,1,2,2},0);
		MAP.put(new int[]{2,0,1,2},1);
		MAP.put(new int[]{84,2,93,1,2,2,26},2);
		MAP.put(new int[]{10,8,3,2,0,1,8,10,2,0,3,10,6,7,0,1,6,9,5,10,5,3,6,3,3,10,2,7,6,6,0,6,4,0,8,3,7,1,0,10,3,8,6,1,4,1,6,7,0,9,0,4,8,10,10,3,8,0,4,5,5,3,10,6,3,6,9,2,0,4,1,9,0,3,3,4,10,8,6,3,5,7,10,2,6,6,1,9,3,4,8,0,2,1,5,9,7,7,8,10},931);
		MAP.put(new int[]{2,1,1,2,2,1,0,2,0,1,0,2,1,0,0,0,1,0,2,2,1,0,1,1,1,2,1,2,0,0,2,2,2,2,2,0,2,2,0,0,1,0,1,0,0,1,1,2,1,2,1,0,2,1,0,1,1,0,2,0,1,0,1,1,0,1,2,0,0,0,1,1,2,1,0,2,2,0,1,0,0,1,0,0,2,0,2,2,1,0,2,2,0,2,0,1,1,0,0,1},12766);
		MAP.put(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},331333993);
	}

	@Test
	void specialTriplets()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = CountSpecialTriplets.specialTriplets(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n10%s",
				"Input", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}