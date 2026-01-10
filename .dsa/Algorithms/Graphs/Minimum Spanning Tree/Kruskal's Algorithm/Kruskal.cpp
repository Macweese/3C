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

vector<int> parent;
vector<int> rank;

void make_set(int v)
{
	parent[v] = v;
	rank[v] = 0;
}

int find_set(int v)
{
	if (v == parent[v])
	{
		return v;
	}
	return parent[v] = find_set(parent[v]);
}

void union_sets(int a, int b)
{
	a = find_set(a);
	b = find_set(b);

	if (a != b)
	{
		if (rank[a] < rank[b])
		{
			swap(a, b);
		}

		parent[b] = a;
		if (rank[a] == rank[b])
		{
			rank[a]++;
		}
	}
}

struct Edge
{
	int u;
	int v;
	int weight;

	bool operator<(Edge const&other)
	{
		return weight < other.weight;
	}
};

int n;
vector<Edge> edges;

int cost = 0;
vector<Edge> result;
parent.resize(n);
rank.resize(n);

for (int i = 0; i < n; i++)
{
	make_set(i);
}

sort(edges.begin(), edges.end());

for (Edge e: edges)
{
	if (find_set(e.u) != find_set(e.v))
	{
		cost += e.weight;
		result.push_back(e);
		union_sets(e.u, e.v);
	}
}
