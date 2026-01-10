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

static List<int[]> getMSTGraph(int nNodes, int[][] graph, boolean isDirected)
{

	List<int[]> mstEdges = new ArrayList<>();
	List<List<int[]>> adj = getAdjWeighted(graph, nNodes, isDirected);
	boolean[] isVisited = new boolean[nNodes];
	int src = 0;
	PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
	// Store format: [node, parent, weightWithParent]
	pq.offer(new int[]{src, -1, 0});

	int ans = 0;

	while (!pq.isEmpty())
	{
		int[] front = pq.poll();
		int curr = front[0];
		int parent = front[1];
		int weight = front[2];

		if (isVisited[curr])
		{
			continue;
		}

		if (parent != -1)
		{
			mstEdges.add(new int[]{parent, curr, weight});
		}

		isVisited[curr] = true;
		ans += weight;
		for (int[] neighbour : adj.get(curr))
		{
			int neighbourNodeNumber = neighbour[0];
			int weightOfCurrentNeighbour = neighbour[1];
			pq.offer(new int[]{neighbourNodeNumber, curr, weightOfCurrentNeighbour});
		}
	}

	if (mstEdges.size() != nNodes - 1)
	{
		// Graph is disconnected
		return null;
	}

	System.out.println("The Minimum spanning tree of given graph has the following adjacency list:");
	for (var e : mstEdges)
	{
		System.out.println(Arrays.toString(e));
	}

	System.out.println("The sum of all weights in MST of given graph  is " + ans);
	return mstEdges;
}

static List<List<int[]>> getAdjWeighted(int[][] graph, int nNodes, boolean isDirected)
{
	List<List<int[]>> adj = new ArrayList<>();

	for (int i = 0; i < nNodes; i++)
	{
		adj.add(new ArrayList<>());
	}

	for (int[] con : graph)
	{
		adj.get(con[0] - 1).add(new int[]{con[1] - 1, con[2]});

		if (!isDirected)
		{
			adj.get(con[1] - 1).add(new int[]{con[0] - 1, con[2]});
		}
	}
	return adj;
}