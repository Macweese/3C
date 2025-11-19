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

package challenge.leetcode.medium.smallestMissingNonNegativeIntegerAfterOperations;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Administrator
 * @Created 16/10/2025, 23:10 Thu 16 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class SmallestMissingNonNegativeIntegerAfterOperations
{
	public static int findSmallestInteger(int[] ints, int value)
	{
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < ints.length; ++i)
		{
			ints[i] = ints[i] % value;
			while (ints[i] < 0)
			{
				ints[i] += value;
			}
			map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
		}

		while (ints[0] < 0)
		{
			ints[0] += value;
		}
		for (int i = 0; i < ints.length; ++i)
		{
			int count = map.get(ints[i]);
			if (count > 1)
			{
				map.put(ints[i], count - 1);
				ints[i] += value * (count - 1);
				map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
			}
		}

		Arrays.sort(ints);
		int mex = 0;
		for (int i : ints)
		{
			if (i <= mex)
			{
				mex = i + 1;
			}
		}

		return mex;
	}
}
