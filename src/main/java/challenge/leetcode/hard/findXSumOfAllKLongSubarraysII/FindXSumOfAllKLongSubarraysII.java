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

package challenge.leetcode.hard.findXSumOfAllKLongSubarraysII;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Administrator
 * @Created 05/11/2025, 01:01 Wed 05 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class FindXSumOfAllKLongSubarraysII
{
	static void main(String[] args)
	{

	}

	private static final Comparator<Map.Entry<Integer, Integer>> FREQ_THEN_KEY_DESC =
		Map.Entry.<Integer, Integer>comparingByValue()
			.reversed()
			.thenComparing(Map.Entry::getKey, Comparator.reverseOrder());

	public static long[] findXSum(int[] ints, int k, int x)
	{
		int n = ints.length;
		long[] result = new long[n - k + 1];
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

	private static long getSumMaxFreq(Map<Integer, Integer> freq, int x)
	{
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(FREQ_THEN_KEY_DESC);

		for (var e : freq.entrySet())
		{
			if (e.getValue() > 0)
			{
				pq.add(new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()));
			}
		}

		long sum = 0;
		for (int i = 0; i < x && !pq.isEmpty(); i++)
		{
			var e = pq.poll();
			sum += (long) e.getKey() * e.getValue();
		}
		return sum;
	}
}

class Solution
{
	private static final Comparator<Pair> COMPARATOR = (a, b) ->
		a.freq != b.freq ? Integer.compare(b.freq, a.freq) : Integer.compare(b.key, a.key);

	private static final class Pair
	{
		final int key;
		final int freq;

		Pair(int key, int freq)
		{
			this.key = key;
			this.freq = freq;
		}
	}

	public static long[] findXSum(int[] ints, int k, int x)
	{
		int n = ints.length;
		long sum = 0;
		long[] result = new long[n - k + 1];

		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> freq = new HashMap<>();
		PriorityQueue<Pair> inHeap = new PriorityQueue<>(COMPARATOR.reversed());
		PriorityQueue<Pair> outHeap = new PriorityQueue<>(COMPARATOR);

		for (int i = 0; i < k; i++)
		{
			freq.merge(ints[i], 1, Integer::sum);
		}
		for (Map.Entry<Integer, Integer> e : freq.entrySet())
		{
			outHeap.add(new Pair(e.getKey(), e.getValue()));
		}
		sum = fillInHeap(freq, x, inHeap, outHeap, set, 0);

		result[0] = sum;

		for (int i = k; i < n; i++)
		{
			int out = ints[i - k];
			int in = ints[i];

			{
				int oldF = freq.getOrDefault(out, 0);
				if (oldF > 0)
				{
					int newF = oldF - 1;
					if (newF == 0)
					{
						freq.remove(out);
					}
					else
					{
						freq.put(out, newF);
					}

					if (set.remove(out))
					{
						sum -= (long) out * oldF;
					}
					if (newF > 0)
					{
						outHeap.add(new Pair(out, newF));
					}
				}
			}

			{
				int oldF = freq.getOrDefault(in, 0);
				int newF = oldF + 1;
				freq.put(in, newF);

				if (set.remove(in))
				{
					sum -= (long) in * oldF;
				}
				outHeap.add(new Pair(in, newF));
			}

			sum = rebalance(freq, x, inHeap, outHeap, set, sum);
			result[i - k + 1] = sum;
		}

		return result;
	}

	private static long fillInHeap(Map<Integer, Integer> freq, int x, PriorityQueue<Pair> inHeap, PriorityQueue<Pair> outHeap, Set<Integer> inSet, long sumIn)
	{
		int target = Math.min(x, freq.size());
		while (inSet.size() < target)
		{
			cleanOutTop(freq, outHeap, inSet);
			if (outHeap.isEmpty())
			{
				break;
			}
			Pair best = outHeap.poll();
			inSet.add(best.key);
			inHeap.add(best);
			sumIn += (long) best.key * best.freq;
		}
		return sumIn;
	}

	private static long rebalance(Map<Integer, Integer> freq, int x, PriorityQueue<Pair> inHeap, PriorityQueue<Pair> outHeap, Set<Integer> inSet, long sumIn)
	{
		int target = Math.min(x, freq.size());
		sumIn = fillInHeap(freq, x, inHeap, outHeap, inSet, sumIn);

		while (true)
		{
			cleanInTop(freq, inHeap, inSet);
			cleanOutTop(freq, outHeap, inSet);

			if (inSet.size() == 0 || inSet.size() < target)
			{
				if (inSet.size() < target)
				{
					sumIn = fillInHeap(freq, x, inHeap, outHeap, inSet, sumIn);
					continue;
				}
			}

			if (inHeap.isEmpty() || outHeap.isEmpty())
			{
				break;
			}

			Pair worstIn = inHeap.peek();
			Pair bestOut = outHeap.peek();

			if (COMPARATOR.compare(bestOut, worstIn) < 0)
			{
				inHeap.poll();
				outHeap.poll();
				inSet.remove(worstIn.key);
				inSet.add(bestOut.key);

				inHeap.add(bestOut);
				outHeap.add(worstIn);

				sumIn += (long) bestOut.key * bestOut.freq - (long) worstIn.key * worstIn.freq;
			}
			else
			{
				break;
			}
		}

		return sumIn;
	}

	private static void cleanOutTop(Map<Integer, Integer> freq, PriorityQueue<Pair> outHeap, Set<Integer> inSet)
	{
		while (!outHeap.isEmpty())
		{
			Pair p = outHeap.peek();
			int f = freq.getOrDefault(p.key, 0);
			if (f == 0 || p.freq != f || inSet.contains(p.key))
			{
				outHeap.poll();
			}
			else
			{
				break;
			}
		}
	}

	private static void cleanInTop(Map<Integer, Integer> freq, PriorityQueue<Pair> inHeap, Set<Integer> inSet)
	{
		while (!inHeap.isEmpty())
		{
			Pair p = inHeap.peek();
			int f = freq.getOrDefault(p.key, 0);
			if (f == 0 || p.freq != f || !inSet.contains(p.key))
			{
				inHeap.poll();
			}
			else
			{
				break;
			}
		}
	}
}