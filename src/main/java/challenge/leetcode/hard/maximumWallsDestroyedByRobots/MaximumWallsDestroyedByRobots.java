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

package challenge.leetcode.hard.maximumWallsDestroyedByRobots;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 08:25 Fri 03 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MaximumWallsDestroyedByRobots
{
	private static Integer[][] memo;
	private static int[][] robots;
	private static int[] walls;
	private static int n;

	public static int maxWalls(int[] robotPositions, int[] distance, int[] wallPositions)
	{
		n = robotPositions.length;
		robots = new int[n][2];

		for (int i = 0; i < n; i++)
		{
			robots[i][0] = robotPositions[i];
			robots[i][1] = distance[i];
		}

		Arrays.sort(robots, (a, b) -> a[0] - b[0]);
		Arrays.sort(wallPositions);

		walls = wallPositions;
		memo = new Integer[n][2];

		return dfs(n - 1, 1);
	}

	private static int dfs(int i, int j)
	{
		if (i < 0)
		{
			return 0;
		}

		if (memo[i][j] != null)
		{
			return memo[i][j];
		}

		int left = robots[i][0] - robots[i][1];
		if (i > 0)
		{
			left = Math.max(left, robots[i - 1][0] + 1);
		}

		int l = lowerBound(walls, left);
		int r = lowerBound(walls, robots[i][0] + 1);
		int ans = dfs(i - 1, 0) + (r - l);

		int right = robots[i][0] + robots[i][1];
		if (i + 1 < n)
		{
			if (j == 0)
			{
				right = Math.min(right, robots[i + 1][0] - robots[i + 1][1] - 1);
			}
			else
			{
				right = Math.min(right, robots[i + 1][0] - 1);
			}
		}

		l = lowerBound(walls, robots[i][0]);
		r = lowerBound(walls, right + 1);
		ans = Math.max(ans, dfs(i - 1, 1) + (r - l));

		memo[i][j] = ans;
		return ans;
	}

	private static int lowerBound(int[] arr, int target)
	{
		int left = 0, right = arr.length;

		while (left < right)
		{
			int mid = left + (right - left) / 2;
			if (arr[mid] < target)
			{
				left = mid + 1;
			}
			else
			{
				right = mid;
			}
		}

		return left;
	}
}
