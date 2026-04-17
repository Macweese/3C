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

package challenge.leetcode.medium.productOfArrayExceptSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Created 11:25 Wed 15 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class ProductOfArrayExceptSelf
{
	public static int[] productExceptSelf(int[] ints)
	{
		List<Integer> zeros = new ArrayList<>();

		int n = ints.length;
		int product = 1;

		for (int i = 0; i < n; i++)
		{
			if (zeros.size() > 1)
			{
				return new int[n];
			}

			if (ints[i] == 0)
			{
				zeros.add(i);
				continue;
			}
			product *= ints[i];
		}

		int[] result = new int[n];

		switch (zeros.size())
		{
			case 0:
			{
				Arrays.fill(result, product);
				for (int i = 0; i < n; i++)
				{
					result[i] /= ints[i];
				}
				return result;
			}
			case 1:
			{
				result[zeros.getFirst()] = product;
				return result;
			}
			default: return result;
		}
	}
}
