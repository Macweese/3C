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
int* parent;
int* rank_arr;

int find(int x)
{
	if (parent[x] != x)
	{
		parent[x] = find(parent[x]);
	}
	return parent[x];
}

void unite(int x, int y)
{
	int px = find(x);
	int py = find(y);
	if (px == py) return;

	if (rank_arr[px] < rank_arr[py])
	{
		parent[px] = py;
	}
	else if (rank_arr[px] > rank_arr[py])
	{
		parent[py] = px;
	}
	else
	{
		parent[py] = px;
		rank_arr[px]++;
	}
}

void reset(int x)
{
	parent[x] = x;
	rank_arr[x] = 0;
}

int compare(const void* a, const void* b)
{
	int* arr1 = *(int**)a;
	int* arr2 = *(int**)b;
	return arr1[2] - arr2[2];
}

int* findAllPeople(int n, int** meetings, int meetingsSize, int* meetingsColSize, int firstPerson, int* returnSize)
{
	parent = (int*) malloc(n * sizeof(int));
	rank_arr = (int*) calloc(n, sizeof(int));

	for (int i = 0; i < n; i++)
	{
		parent[i] = i;
	}

	unite(0, firstPerson);

	qsort(meetings, meetingsSize, sizeof(int*), compare);

	int i = 0;
	while (i < meetingsSize)
	{
		int currentTime = meetings[i][2];
		int start = i;

		while (i < meetingsSize && meetings[i][2] == currentTime)
		{
			unite(meetings[i][0], meetings[i][1]);
			i++;
		}

		for (int j = start; j < i; j++)
		{
			if (find(meetings[j][0]) != find(0))
			{
				reset(meetings[j][0]);
			}
			if (find(meetings[j][1]) != find(0))
			{
				reset(meetings[j][1]);
			}
		}
	}

	int* result = (int*) malloc(n * sizeof(int));
	int count = 0;
	int root0 = find(0);

	for (int i = 0; i < n; i++)
	{
		if (find(i) == root0)
		{
			result[count++] = i;
		}
	}

	free(parent);
	free(rank_arr);
	*returnSize = count;
	return result;
}