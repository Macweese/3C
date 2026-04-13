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

package challenge.leetcode.medium.minimumDistanceBetweenThreeEqualElementsII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 06:19 Sat 11 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumDistanceBetweenThreeEqualElementsII
{
	public static int minimumDistance(int[] nums)
	{
		int minDistance = Integer.MAX_VALUE;
		List<Integer>[] buckets = new ArrayList[nums.length + 1];

		for (int i = 0; i < nums.length; i++)
		{
			int val = nums[i];
			if (buckets[val] == null)
			{
				buckets[val] = new ArrayList<>();
			}
			List<Integer> list = buckets[val];
			list.add(i);

			if (list.size() >= 3)
			{
				int first = list.get(list.size() - 3);
				int distance = 2 * (i - first);
				minDistance = Math.min(minDistance, distance);
			}
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}
}
