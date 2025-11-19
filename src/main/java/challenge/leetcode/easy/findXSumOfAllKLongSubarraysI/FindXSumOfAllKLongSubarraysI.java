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

package challenge.leetcode.easy.findXSumOfAllKLongSubarraysI;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author Administrator
 * @Created 04/11/2025, 05:02 Tue 04 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class FindXSumOfAllKLongSubarraysI
{
	public static int findXSum(int[] ints, int k, int x)
	{
		int[] result = new int[ints.length - k + 1];
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();

		TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
		PriorityQueue<Map.Entry<Integer, Integer>> frequencyHeap = new PriorityQueue<>(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())));
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < k; i++)
		{
			frequencyMap.put(ints[i], frequencyMap.getOrDefault(ints[i], 0) + 1);
			set.add(ints[i]);
			deque.push(ints[i]);
		}

		frequencyHeap.addAll(frequencyMap.entrySet());
		result[0] = getSumMaxFreq(frequencyHeap, frequencyMap, x);

		for (int i = k; i < ints.length; i++)
		{
			deque.push(ints[i]);
			int removed = deque.removeLast();
			int added = deque.getFirst();

			frequencyMap.put(removed, frequencyMap.get(removed) - 1);
			frequencyMap.put(added, frequencyMap.getOrDefault(added, 0) + 1);

			if (frequencyMap.get(removed) == 0)
			{
				set.remove(removed);
			}
			set.add(added);

			result[i - k + 1] = getSumMaxFreq(frequencyHeap, frequencyMap, x);
		}

		return 0;
	}

	private static int getSumMaxFreq(PriorityQueue<Map.Entry<Integer, Integer>> heap, HashMap<Integer, Integer> frequencyMap, int x)
	{
		int sum = 0;
		for (Map.Entry<Integer, Integer> map : frequencyMap.entrySet())
		{
			if (map.getValue() == 0)
			{
				heap.remove(map);
			}
		}

		int i = 0;
		PriorityQueue<Map.Entry<Integer, Integer>> t = new PriorityQueue<>(heap);
		while (!t.isEmpty() && i < x)
		{
			Map.Entry<Integer, Integer> entry = t.poll();
			sum += entry.getKey() * entry.getValue();
			++i;
		}

		return sum;
	}


	private static final Comparator<Map.Entry<Integer, Integer>> FREQ_THEN_KEY_DESC =
		Comparator.<Map.Entry<Integer, Integer>, Integer>comparing(Map.Entry::getValue)
			.reversed()
			.thenComparing(Map.Entry::getKey, Comparator.reverseOrder());

	public static int[] solve(int[] ints, int k, int x)
	{
		int n = ints.length;
		int[] result = new int[n - k + 1];
		Map<Integer, Integer> freq = new HashMap<>();

		for (int i = 0; i < k; i++)
		{
			freq.merge(ints[i], 1, Integer::sum);
		}
		result[0] = getSumMaxFreq(freq, x);

		for (int i = k; i < n; i++)
		{
			int out = ints[i - k];
			int in = ints[i];

			freq.computeIfPresent(out, (key, val) -> val == 1 ? null : val - 1);
			freq.merge(in, 1, Integer::sum);

			result[i - k + 1] = getSumMaxFreq(freq, x);
		}

		return result;
	}

	private static int getSumMaxFreq(Map<Integer, Integer> freq, int x)
	{
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(FREQ_THEN_KEY_DESC);

		for (var e : freq.entrySet())
		{
			if (e.getValue() > 0)
			{
				pq.add(new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()));
			}
		}

		int sum = 0;
		for (int i = 0; i < x && !pq.isEmpty(); i++)
		{
			var e = pq.poll();
			sum += e.getKey() * e.getValue();
		}
		return sum;
	}
}
