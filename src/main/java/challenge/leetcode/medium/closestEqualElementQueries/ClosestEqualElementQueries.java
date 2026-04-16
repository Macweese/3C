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

package challenge.leetcode.medium.closestEqualElementQueries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Administrator
 * @Created 06:06 Thu 16 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class ClosestEqualElementQueries
{
	public static List<Integer> solveQueries(int[] ints, int[] queries)
	{
		int n = ints.length;
		Map<Integer, TreeSet<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++)
		{
			map.computeIfAbsent(ints[i], _ -> new TreeSet<>()).add(i);
		}

		List<Integer> result = new ArrayList<>();

		for (int index : queries)
		{
			TreeSet<Integer> set = map.get(ints[index]);

			if (set == null || set.size() < 2)
			{
				result.add(-1);
				continue;
			}

			Integer lower = set.lower(index);
			lower = lower == null ? set.last() : lower;
			Integer higher = set.higher(index);
			higher = higher == null ? set.first() : higher;

			int next = (higher - index + n) % n;
			int prev = (index - lower + n) % n;

			int distance = Math.min(next, prev);
			result.add(distance);
		}

		return result;
	}
}
