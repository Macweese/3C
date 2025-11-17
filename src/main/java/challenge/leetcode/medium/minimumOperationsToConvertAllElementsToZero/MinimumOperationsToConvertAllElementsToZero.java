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

package challenge.leetcode.medium.minimumOperationsToConvertAllElementsToZero;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Administrator
 * @Created 10/11/2025, 01:31 Mon 10 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class MinimumOperationsToConvertAllElementsToZero
{
	static void main(String[] args)
	{
		System.out.println(minOperations(new int[]{0,2}));
		System.out.println(minOperations(new int[]{3,1,2,1}));
		System.out.println(minOperations(new int[]{1,2,1,2,1,2}));
	}

	public static int minOperations(int[] ints)
	{
		System.out.println();
		int operations = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : ints)
		{
			if (i == 0)
			{
				continue;
			}
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		while (!map.isEmpty())
		{
			System.out.println(operations + " : " + Arrays.toString(ints));
			int key = map.firstEntry().getKey();

			boolean segmentFound = false;
			for (int i = 0; i < ints.length; i++)
			{
				if (map.get(key) == 0)
				{
					break;
				}

				if (segmentFound && ints[i] == 0)
				{
					segmentFound = false;
				}
				if (ints[i] == key)
				{
					operations = !segmentFound? operations + 1 : operations;
					segmentFound = true;
					ints[i] = 0;
					map.put(key, map.get(key) - 1);
				}
			}

			if (map.get(key) == 0)
			{
				map.remove(map.firstKey());
			}
		}

		System.out.println(operations + " : " + Arrays.toString(ints));
		return operations;
	}
}
