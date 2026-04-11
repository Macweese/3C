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

package challenge.leetcode.easy.minimumDistanceBetweenThreeEqualElementsI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @Created 06:36 Fri 10 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumDistanceBetweenThreeEqualElementsI
{
	public static int minimumDistance(int[] ints)
	{
		if (ints.length < 3)
		{
			return -1;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : ints)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int distance = Integer.MAX_VALUE;

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if (entry.getValue() < 3)
			{
				continue;
			}
			distance = Math.min(distance, getDistance(ints, entry.getKey(), entry.getValue()));
		}

		return distance == Integer.MAX_VALUE ? -1 : distance;
	}

	private static int getDistance(int[] ints, int val, int count)
	{
		int a;
		int b;
		int c;
		int distance;

		int i = -1;
		while (true)
		{
			if (ints[++i] == val)
			{
				a = i;
				break;
			}
		}
		while (true)
		{
			if (ints[++i] == val)
			{
				b = i;
				break;
			}
		}
		while (true)
		{
			if (ints[++i] == val)
			{
				c = i;
				break;
			}
		}

		distance = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);

		if (count < 4)
		{
			return distance;
		}

		for (i = c + 1; i < ints.length; i++)
		{
			if (ints[i] != val)
			{
				continue;
			}

			a = b;
			b = c;
			c = i;

			distance = Math.min(distance, (Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a)));
		}

		return distance;
	}

	public static int minimumDistanceFast(int[] nums)
	{
		List<Integer>[] buckets = new ArrayList[nums.length + 1];

		int minDistance = Integer.MAX_VALUE;

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
