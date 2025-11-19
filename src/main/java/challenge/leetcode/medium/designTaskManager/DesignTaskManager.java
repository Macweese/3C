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

package challenge.leetcode.medium.designTaskManager;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Created 18/09/2025, 09:53 Thu 18 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class DesignTaskManager
{
}

class TaskManager
{
	// Constraints
	private static final int MAX_TASK_ID = 100_000;
	private static final int KEY_SHIFT = 17;      // 2^17 = 131072 > 1e5 (fits taskId)
	private static final long TASK_MASK = (1L << KEY_SHIFT) - 1L;

	// If initial tasks >= this threshold, use O(n) heapify; else add() incrementally
	private static final int HEAPIFY_THRESHOLD = 2048;

	// Heap arrays (1-indexed)
	// key[i] = ((long)priority << KEY_SHIFT) | taskId
	private long[] key;
	// payload[i] packs (userId, taskId): high 32 bits = userId, low 32 bits = taskId
	private long[] payload;

	// Direct-address: taskId -> heap index (0 if absent)
	private final int[] pos = new int[MAX_TASK_ID + 1];

	private int size;

	// Default adaptive constructor
	public TaskManager(List<List<Integer>> tasks)
	{
		this(tasks, -1);
	}

	// Overload to pre-size if you know peak concurrent size
	public TaskManager(List<List<Integer>> tasks, int expectedMaxConcurrentTasks)
	{
		int initial = (tasks == null) ? 0 : tasks.size();
		int cap = initialCapacity(initial, expectedMaxConcurrentTasks);

		this.key = new long[cap];
		this.payload = new long[cap];
		this.size = 0;

		if (tasks == null || initial == 0)
		{
			return;
		}

		if (initial >= HEAPIFY_THRESHOLD)
		{
			// Bulk load then O(n) heapify
			int i = 1;
			for (int k = 0; k < initial; k++)
			{
				List<Integer> t = tasks.get(k);
				if (t == null || t.size() != 3)
				{
					continue;
				}
				int u = t.get(0);
				int id = t.get(1);
				int pr = t.get(2);
				ensureCapacity(i);
				key[i] = packKey(pr, id);
				payload[i] = packPayload(u, id);
				pos[id] = i;
				i++;
			}
			size = i - 1;
			for (int j = size >>> 1; j >= 1; j--)
			{
				siftDown(j);
			}
		}
		else
		{
			// Small initial sets: cheaper to use incremental adds
			for (int k = 0; k < initial; k++)
			{
				List<Integer> t = tasks.get(k);
				if (t == null || t.size() != 3)
				{
					continue;
				}
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	public final void add(int userId, int taskId, int priority)
	{
		int i = ++size;
		ensureCapacity(i);
		key[i] = packKey(priority, taskId);
		payload[i] = packPayload(userId, taskId);
		pos[taskId] = i;
		siftUp(i);
	}

	public final void edit(int taskId, int newPriority)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			// per constraints, shouldn't happen
			return;
		}

		key[i] = packKey(newPriority, taskId);

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent])
		{
			siftUp(i);
		}
		else
		{
			siftDown(i);
		}
	}

	public final void rmv(int taskId)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return;
		}

		pos[taskId] = 0;

		if (i == size)
		{
			size--;
			return;
		}

		long lk = key[size];
		long lp = payload[size];
		// low 32 bits
		int movedTask = (int) lp;

		size--;

		key[i] = lk;
		payload[i] = lp;
		pos[movedTask] = i;

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent])
		{
			siftUp(i);
		}
		else
		{
			siftDown(i);
		}
	}

	public final int execTop()
	{
		if (size == 0)
		{
			return -1;
		}

		long rootPayload = payload[1];
		int topUser = (int) (rootPayload >>> 32);
		int topTask = (int) rootPayload;
		pos[topTask] = 0;

		if (size == 1)
		{
			size = 0;
			return topUser;
		}

		long lk = key[size];
		long lp = payload[size];
		int movedTask = (int) lp;

		size--;

		key[1] = lk;
		payload[1] = lp;
		pos[movedTask] = 1;

		siftDown(1);
		return topUser;
	}

	private void siftUp(int i)
	{
		long k = key[i];
		long pl = payload[i];
		int t = (int) pl;

		while (i > 1)
		{
			int p = i >>> 1;
			if (key[p] >= k)
			{
				break;
			}

			key[i] = key[p];
			payload[i] = payload[p];
			pos[(int) payload[i]] = i;

			i = p;
		}

		key[i] = k;
		payload[i] = pl;
		pos[t] = i;
	}

	private void siftDown(int i)
	{
		long k = key[i];
		long pl = payload[i];
		int t = (int) pl;

		while (true)
		{
			int left = i << 1;
			if (left > size)
			{
				break;
			}

			int right = left + 1;
			int best = left;
			if (right <= size && key[right] > key[left])
			{
				best = right;
			}

			if (key[best] <= k)
			{
				break;
			}

			key[i] = key[best];
			payload[i] = payload[best];
			pos[(int) payload[i]] = i;

			i = best;
		}

		key[i] = k;
		payload[i] = pl;
		pos[t] = i;
	}

	private static long packKey(int priority, int taskId)
	{
		// Higher priority => bigger key; tie => higher taskId => bigger key
		return (((long) priority) << KEY_SHIFT) | (taskId & TASK_MASK);
	}

	private static long packPayload(int userId, int taskId)
	{
		return (((long) userId) << 32) | (taskId & 0xFFFF_FFFFL);
	}

	private void ensureCapacity(int requiredIndex)
	{
		if (requiredIndex < key.length)
		{
			return;
		}

		int newCap = key.length << 1;
		if (newCap <= requiredIndex)
		{
			newCap = requiredIndex + 1;
		}

		long[] nk = new long[newCap];
		long[] np = new long[newCap];

		System.arraycopy(key, 0, nk, 0, key.length);
		System.arraycopy(payload, 0, np, 0, payload.length);

		key = nk;
		payload = np;
	}

	private static int initialCapacity(int initial, int expectedMaxConcurrentTasks)
	{
		if (expectedMaxConcurrentTasks > 0)
		{
			return Math.max(16, expectedMaxConcurrentTasks + 2);
		}
		int want = Math.max(16, initial + 8);
		int cap = 1;
		while (cap < want)
		{
			// power-of-two growth for fewer resizes
			cap <<= 1;
		}
		return cap;
	}
}
