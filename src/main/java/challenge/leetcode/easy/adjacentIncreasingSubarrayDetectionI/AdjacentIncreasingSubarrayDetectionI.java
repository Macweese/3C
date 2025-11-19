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

package challenge.leetcode.easy.adjacentIncreasingSubarrayDetectionI;

import java.util.List;

/**
 * @author Administrator
 * @Created 14/10/2025, 06:26 Tue 14 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class AdjacentIncreasingSubarrayDetectionI
{
	public static boolean hasIncreasingSubarrays(List<Integer> ints, int k)
	{
		int subArraySize = 1;
		int prevSubarraySize = 0;

		for (int i = 1; i < ints.size(); ++i)
		{
			if (ints.get(i) > ints.get(i - 1))
			{
				subArraySize++;
			}
			else
			{
				prevSubarraySize = subArraySize;
				subArraySize = 1;
			}

			if (subArraySize >= k && prevSubarraySize >= k || subArraySize >= 2 * k || prevSubarraySize >= 2 * k)
			{
				return true;
			}
		}
		return false;
	}
}
