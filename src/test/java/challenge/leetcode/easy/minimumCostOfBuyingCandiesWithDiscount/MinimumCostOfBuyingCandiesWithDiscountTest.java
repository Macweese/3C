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

package challenge.leetcode.easy.minimumCostOfBuyingCandiesWithDiscount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:50 Mon 01 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2144. Minimum Cost of Buying Candies With Discount")
class MinimumCostOfBuyingCandiesWithDiscountTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{1},1);
		MAP.put(new int[]{9},9);
		MAP.put(new int[]{5,5},10);
		MAP.put(new int[]{1,2,3},5);
		MAP.put(new int[]{6,5,7,9,2,2},23);
		MAP.put(new int[]{3,3,3,3,3,3,3,3},18);
		MAP.put(new int[]{1,2,3,4,6,7,8,9,10,11},44);
		MAP.put(new int[]{7,6,78,85,23,34,78,99,56,33,1},381);
		MAP.put(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100},3400);
	}

	@Test
	void minimumCost()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] ints = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MinimumCostOfBuyingCandiesWithDiscount.minimumCost(ints);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(ints),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}