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

class Edge implements Comparable<Edge>
{
	int u;
	int v;
	int weight;

	@Override
	public int compareTo(Edge other)
	{
		return Integer.compare(this.weight, other.weight);
	}
}

class UnionFind
{
	private List<Integer> parent;
	private List<Integer> rank;

	public UnionFind(int n)
	{
		parent = new ArrayList<>(Collections.nCopies(n, 0));
		rank = new ArrayList<>(Collections.nCopies(n, 0));

		for (int i = 0; i < n; i++)
		{
			makeSet(i);
		}
	}

	public void makeSet(int v)
	{
		parent.set(v, v);
		rank.set(v, 0);
	}

	public int findSet(int v)
	{
		if (v == parent.get(v))
		{
			return v;
		}
		int root = findSet(parent.get(v));
		parent.set(v, root);
		return root;
	}

	public void unionSets(int a, int b)
	{
		a = findSet(a);
		b = findSet(b);

		if (a != b)
		{
			if (rank.get(a) < rank.get(b))
			{
				int temp = a;
				a = b;
				b = temp;
			}

			parent.set(b, a);

			if (rank.get(a).equals(rank.get(b)))
			{
				rank.set(a, rank.get(a) + 1);
			}
		}
	}
}

class Kruskal
{
	public void kruskal()
	{
		// Main algorithm
		int n;
		List<Edge> edges = new ArrayList<>();

		int cost = 0;
		List<Edge> result = new ArrayList<>();
		UnionFind uf = new UnionFind(n);
		Collections.sort(edges);

		for (Edge e : edges)
		{
			if (uf.findSet(e.u) != uf.findSet(e.v))
			{
				cost += e.weight;
				result.add(e);
				uf.unionSets(e.u, e.v);
			}
		}
	}
}
