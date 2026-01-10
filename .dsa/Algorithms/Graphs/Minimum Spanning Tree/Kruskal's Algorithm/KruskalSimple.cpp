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

#include <vector>
#include <algorithm>

using namespace std;

class Kruskal
{
public:
	struct Edge
	{
		int u;
		int v;
		int weight;
		bool operator<(Edge const& other)
		{
			return weight < other.weight;
		}
	};

	int n;
	vector<Edge> edges;
	int cost;
	vector<int> tree_id;
	vector<Edge> result;

	Kruskal(int num_vertices) : n(num_vertices), cost(0), tree_id(n)
	{
		for (int i = 0; i < n; i++)
		{
			tree_id[i] = i;
		}
	}

	void minimumSpanningTree()
	{
		cost = 0;
		result.clear();

		sort(edges.begin(), edges.end());

		for (Edge e : edges)
		{
			if (tree_id[e.u] != tree_id[e.v])
			{
				cost += e.weight;
				result.push_back(e);

				int old_id = tree_id[e.u], new_id = tree_id[e.v];
				for (int i = 0; i < n; i++)
				{
					if (tree_id[i] == old_id)
					{
						tree_id[i] = new_id;
					}
				}
			}
		}
	}
};