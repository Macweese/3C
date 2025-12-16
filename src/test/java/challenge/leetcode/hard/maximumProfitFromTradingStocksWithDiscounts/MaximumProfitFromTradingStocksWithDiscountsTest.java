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

package challenge.leetcode.hard.maximumProfitFromTradingStocksWithDiscounts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:04 Tue 16 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3562. Maximum Profit from Trading Stocks with Discounts")
class MaximumProfitFromTradingStocksWithDiscountsTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(2,new int[]{1,2},new int[]{3,4},new int[][]{{1,2}},3),5);
		MAP.put(new Input(2,new int[]{3,4},new int[]{5,8},new int[][]{{1,2}},4),4);
		MAP.put(new Input(3,new int[]{4,6,8},new int[]{7,9,11},new int[][]{{1,2},{3,4}},4),10);
		MAP.put(new Input(3,new int[]{5,2,3},new int[]{8,5,6},new int[][]{{1,2},{3,4}},7),12);
//		MAP.put(new Input(3,new int[]{},new int[]{},new int[][]{{}},4),10);
	}

	@Test
	void maxProfit()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int n = entry.getKey().n();
			final int[] present = entry.getKey().present();
			final int[] future = entry.getKey().future();
			final int[][] hierarchy = entry.getKey().hierarchy();
			final int budget = entry.getKey().budget();
			final int expected = entry.getValue();
			final int actual = MaximumProfitFromTradingStocksWithDiscounts.maxProfit(n, present, future, hierarchy, budget);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"n", n,
				"Present", Arrays.toString(present),
				"Future", Arrays.toString(future),
				"Hierarchy", Arrays.deepToString(hierarchy),
				"Budget", budget,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int n, int[] present, int[] future, int[][] hierarchy, int budget)
{
}