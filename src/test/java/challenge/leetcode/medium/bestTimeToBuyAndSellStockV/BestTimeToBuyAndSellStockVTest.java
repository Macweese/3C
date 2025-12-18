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

package challenge.leetcode.medium.bestTimeToBuyAndSellStockV;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:27 Wed 17 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3573. Best Time to Buy and Sell Stock V")
class BestTimeToBuyAndSellStockVTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{1,7,9,8,2},2),14);
		MAP.put(new Input(new int[]{12,16,19,19,8,1,19,13,9},3),36);
//		MAP.put(new Input(new int[]{},),);
	}

	@Test
	void maxProfit()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[] prices = entry.getKey().prices();
			final int k = entry.getKey().k();
			final int expected = entry.getValue();
			final int actual = BestTimeToBuyAndSellStockV.maxProfit(prices, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Prices", Arrays.toString(prices),
				"k", k,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}

record Input(int[] prices, int k)
{
}