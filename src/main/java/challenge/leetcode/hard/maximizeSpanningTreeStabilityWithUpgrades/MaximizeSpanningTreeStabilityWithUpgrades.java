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

package challenge.leetcode.hard.maximizeSpanningTreeStabilityWithUpgrades;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 16:50 Thu 12 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MaximizeSpanningTreeStabilityWithUpgrades
{
	private static int find(int v, int[] parent)
	{
		if (parent[v] == v)
		{
			return v;
		}
		return parent[v] = find(parent[v], parent);
	}

	private static boolean unionSets(int a, int b, int[] parent, int[] size)
	{
		a = find(a, parent);
		b = find(b, parent);
		if (a != b)
		{
			if (size[a] < size[b])
			{
				int temp = a;
				a = b;
				b = temp;
			}
			parent[b] = a;
			size[a] += size[b];
			return true;
		}
		return false;
	}

	public static int maxStability(int n, int[][] edges, int k)
	{
		int[] parent = new int[n];
		int[] size = new int[n];
		for (int i = 0; i < n; i++)
		{
			parent[i] = i;
			size[i] = 1;
		}

		int comp = n;
		int res = Integer.MAX_VALUE;
		List<int[]> opt = new ArrayList<>();

		for (int[] edge : edges)
		{
			if (edge[3] == 1)
			{
				if (unionSets(edge[0], edge[1], parent, size))
				{
					comp--;
					res = Math.min(res, edge[2]);
				}
				else
				{
					return -1;
				}
			}
		}

		if (comp == 1)
		{
			return res;
		}

		for (int[] edge : edges)
		{
			if (edge[3] == 0)
			{
				opt.add(edge);
			}
		}

		opt.sort((a, b) -> b[2] - a[2]);

		List<Integer> stab = new ArrayList<>();
		for (int[] edge : opt)
		{
			if (unionSets(edge[0], edge[1], parent, size))
			{
				comp--;
				stab.add(edge[2]);
				if (comp == 1)
				{
					break;
				}
			}
		}

		if (comp > 1)
		{
			return -1;
		}
		for (int i = 1; i <= k && i <= stab.size(); i++)
		{
			int idx = stab.size() - i;
			stab.set(idx, stab.get(idx) * 2);
		}

		int minStab = Integer.MAX_VALUE;
		for (int val : stab)
		{
			minStab = Math.min(minStab, val);
		}

		return Math.min(res, minStab);
	}
}
