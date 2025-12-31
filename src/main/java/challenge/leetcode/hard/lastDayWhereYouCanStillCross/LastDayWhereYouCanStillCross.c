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

int parentIndex(int x)
{
    return x;
}

int findSet(int *parent, int x)
{
    if (parent[x] != x)
    {
        parent[x] = findSet(parent, parent[x]);
    }
    return parent[x];
}

void unionSet(int *parent, int *rank, int a, int b)
{
    int ra = findSet(parent, a);
    int rb = findSet(parent, b);
    if (ra == rb)
    {
        return;
    }
    if (rank[ra] < rank[rb])
    {
        parent[ra] = rb;
    }
    else if (rank[ra] > rank[rb])
    {
        parent[rb] = ra;
    }
    else
    {
        parent[rb] = ra;
        rank[ra]++;
    }
}

int latestDayToCross(int row, int col, int** cells, int cellsSize, int* cellsColSize)
{
    int n = row * col;
    int top = n;
    int bottom = n + 1;
    int total = n + 2;
    int *parent = (int *)malloc(total * sizeof(int));
    int *rank = (int *)calloc(total, sizeof(int));
    int *grid = (int *)calloc(n, sizeof(int));
    for (int i = 0; i < total; i++)
    {
        parent[i] = i;
    }
    int dirs[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    for (int day = cellsSize - 1; day >= 0; day--)
    {
        int r = cells[day][0] - 1;
        int c = cells[day][1] - 1;
        int idx = r * col + c;
        grid[idx] = 1;
        if (r == 0)
        {
            unionSet(parent, rank, idx, top);
        }
        if (r == row - 1)
        {
            unionSet(parent, rank, idx, bottom);
        }
        for (int k = 0; k < 4; k++)
        {
            int nr = r + dirs[k][0];
            int nc = c + dirs[k][1];
            if (nr < 0 || nr >= row || nc < 0 || nc >= col)
            {
                continue;
            }
            int nidx = nr * col + nc;
            if (grid[nidx])
            {
                unionSet(parent, rank, idx, nidx);
            }
        }
        if (findSet(parent, top) == findSet(parent, bottom))
        {
            free(parent);
            free(rank);
            free(grid);
            return day;
        }
    }
    free(parent);
    free(rank);
    free(grid);
    return 0;
}