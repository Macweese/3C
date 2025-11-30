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

package challenge.leetcode.medium.makeSumDivisibleByP;

/**
 * @author Administrator
 * @Created 01:01 Sun 30 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class makeSumDivisibleByP
{
	public static int minSubArray(int[] nums, int numsize, int p)
	{
		int[] ints = nums.clone();
		for (int i = 1; i < ints.length; i++)
		{
			ints[i] += ints[i - 1];
		}

		if (ints[ints.length - 1] % p == 0)
		{
			return 0;
		}

		int r = 0;
		int min = ints.length - 1;
		int diff = ints[ints.length - 1] % p;
		for (int i = 0; i < ints.length; i++)
		{
			int j = i + 1;
			int removals = 0;
			while (j < ints.length - 1 && r != diff)
			{
				if (r > diff)
				{
					r = 0;
					min = ints.length - 1;
					continue;
				}

				r += nums[j++];
				removals++;
			}

			min = Math.min(min, removals);
		}

		return min == (ints.length - 1) ? 0 : min;
	}
}
