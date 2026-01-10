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

int n;
vector<vector<int>> adj;
vector<bool> visited;
vector<int> parent;
int cycle_start, cycle_end;

bool dfs(int v, int par) // passing vertex and its parent vertex
{
    visited[v] = true;

    for (int u : adj[v])
    {
        if(u == par)
        {
            continue; // skipping edge to parent vertex
        }

        if (visited[u])
        {
            cycle_end = v;
            cycle_start = u;
            return true;
        }

        parent[u] = v;

        if (dfs(u, parent[u]))
        {
            return true;
        }
    }

    return false;
}

void find_cycle()
{
    visited.assign(n, false);
    parent.assign(n, -1);
    cycle_start = -1;

    for (int v = 0; v < n; v++)
    {
        if (!visited[v] && dfs(v, parent[v]))
        {
            break;
        }
    }

    if (cycle_start == -1)
    {
        cout << "Acyclic" << endl;
    }
    else
    {
        vector<int> cycle;
        cycle.push_back(cycle_start);

        for (int v = cycle_end; v != cycle_start; v = parent[v])
        {
            cycle.push_back(v);
        }

        cycle.push_back(cycle_start);

        cout << "Cycle found: ";

        for (int v : cycle)
        {
            cout << v << " ";
        }

        cout << endl;
    }
}