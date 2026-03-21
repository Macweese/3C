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

package challenge.leetcode.medium.minimumAbsoluteDifferenceInSlidingSubmatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * @Created 00:42 Sat 21 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumAbsoluteDifferenceInSlidingMatrix
{
	public static int[][] minAbsDiff(int[][] grid, int k)
	{
		int m = grid.length;
		int n = grid[0].length;
		int[][] ans = new int[m - k + 1][n - k + 1];

		for (int i = 0; i <= m - k; i++)
		{
			for (int j = 0; j <= n - k; j++)
			{
				List<Integer> nums = new ArrayList<>();

				for (int x = i; x < i + k; x++)
				{
					for (int y = j; y < j + k; y++)
					{
						nums.add(grid[x][y]);
					}
				}

				Collections.sort(nums);

				int minDiff = Integer.MAX_VALUE;
				for (int p = 1; p < nums.size(); p++)
				{
					if (!nums.get(p).equals(nums.get(p - 1)))
					{
						minDiff = Math.min(minDiff, nums.get(p) - nums.get(p - 1));
					}
				}

				ans[i][j] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
			}
		}

		return ans;
	}
}
