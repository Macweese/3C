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

/**
 * @author Administrator
 * @Created 06:49 Mon 01 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumCostOfBuyingCandiesWithDiscount
{
	public static int minimumCost(int[] candyPrices)
	{
		Arrays.sort(candyPrices);
		int cost = 0;
		for (int i = candyPrices.length - 1, j = 0; i >= 0; --i, ++j)
		{
			if (j % 3 != 2)
			{
				cost += candyPrices[i];
			}
		}
		return cost;
	}
}
