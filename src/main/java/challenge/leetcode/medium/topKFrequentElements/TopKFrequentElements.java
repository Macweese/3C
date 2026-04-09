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

package challenge.leetcode.medium.topKFrequentElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @Created 17:51 Tue 31 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class TopKFrequentElements
{
	public static int[] topKFrequent(int[] ints, int k)
	{
		int[] result = new int[k];
		Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

		for (int i : ints)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
			.sorted(Comparator.comparingInt(Map.Entry::getValue))
			.collect(Collectors.toCollection(ArrayList::new));

		for (int i = 0; i < k; ++i)
		{
			result[i] = list.getLast().getKey();
			list.removeLast();
		}

		return result;
	}
}
