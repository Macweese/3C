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

package challenge.leetcode.medium.adjacentIncreasingSubarraysDetectionII;

import java.util.List;

/**
 * @author Administrator
 * @Created 15/10/2025, 05:36 Wed 15 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class AdjacentIncreasingSubarraysDetectionII
{
	static void main(String[] args)
	{
		List<Integer> TEST_1 = List.of(2,5,7,8,9,2,3,4,3,1);
		List<Integer> TEST_2 = List.of(1,2,3,4,4,4,4,5,6,7);
		List<Integer> TEST_3 = List.of(8,-4,-1,16,20);
		List<Integer> TEST_4 = List.of(-4,20,4,10,-19,-14,-8,1,11,17);
		List<Integer> TEST_5 = List.of(-15,19);
		List<Integer> TEST_6 = List.of(-15,-13,4,7);
		List<Integer> TEST_7 = List.of(-15,-13,4,7,0,2);

		System.out.println(maxIncreasingSubarrays(TEST_1));
		System.out.println(maxIncreasingSubarrays(TEST_2));
		System.out.println(maxIncreasingSubarrays(TEST_3));
		System.out.println(maxIncreasingSubarrays(TEST_4));
		System.out.println(maxIncreasingSubarrays(TEST_5));
		System.out.println(maxIncreasingSubarrays(TEST_6));
		System.out.println(maxIncreasingSubarrays(TEST_7));
	}

	public static int maxIncreasingSubarrays(List<Integer> ints)
	{
		int a = 1;
		int b = 0;
		int max = 0;

		for (int i = 1; i < ints.size(); i++)
		{
			if (ints.get(i) > ints.get(i - 1))
			{
				a++;
			}
			else
			{
				b = a;
				a = 1;
			}

			if (a == b)
			{
				max = Math.max(max, a);
			}
			else if (a > b)
			{
				max = Math.max(max, b * 2 > a ? b : a / 2);
			}
			else
			{
				max = Math.max(max, a * 2 > b ? a : b / 2);
			}
		}

		return max;
	}
}
