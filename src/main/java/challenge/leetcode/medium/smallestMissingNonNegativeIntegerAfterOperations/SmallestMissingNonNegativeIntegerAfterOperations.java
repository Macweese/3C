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
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class SmallestMissingNonNegativeIntegerAfterOperations
{
	static void main(String[] args)
	{
		int[] TEST_1 = {1,-10,7,13,6,8};
		int[] TEST_1a = {-1,-10,7,13,6,8};
		int[] TEST_2 = {1,-10,7,13,6,8};
		int[] TEST_3 = {1,3,5,7};
		int[] TEST_4 = {3,2,3,1,0,1,4,2,3,1,4,1,3};
		int[] TEST_5 = {0,0,0,0,1,0,0,1,0,0,1,1,0,1,0,1,1};

		System.out.println(findSmallestInteger(TEST_5, 2));
	}

	public static int findSmallestInteger(int[] ints, int value)
	{
		HashMap<Integer, Integer> map = new HashMap<>();

		System.out.println(Arrays.toString(ints));
		for (int i = 0; i < ints.length; ++i)
		{
			ints[i] = ints[i] % value;
			while (ints[i] < 0)
			{
				ints[i] += value;
			}
			map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
		}

		System.out.println(Arrays.toString(ints));
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
		System.out.println(Arrays.toString(ints));
		int mex = 0;
		for (int i : ints)
		{
			if (i <= mex)
			{
				mex = i + 1;
			}
		}

		System.out.println(mex);
		return mex;
	}
}
