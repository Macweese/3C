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

package challenge.leetcode.easy.countNegativeNumbersInASortedMatrix;

/**
 * @author Administrator
 * @Created 01:22 Mon 29 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountNegativeNumbersInASortedMatrix
{
	public static int countNegatives(int[][] grid)
	{
		if (grid[0].length < 30)
		{
			return linearSearch(grid);
		}
		else
		{
			return binarySearch(grid);
		}
	}

	private static int linearSearch(int[][] grid)
	{
		int count = 0;

		for (int[] ints : grid)
		{
			for (int i = 0; i < ints.length; i++)
			{
				if (ints[i] < 0)
				{
					count += ints.length - i;
					break;
				}
			}
		}
		return count;
	}

	private static int binarySearch(int[][] grid)
	{
		int count = 0;
		for (int[] ints : grid)
		{
			int n = ints.length;
			if (ints[0] < 0)
			{
				count += n;
				continue;
			}
			count += n - binarySearchClosest(ints);
		}

		return count;
	}

	private static int binarySearchClosest(int[] ints)
	{
		if (ints == null || ints.length == 0)
		{
			throw new IllegalArgumentException("Array cannot be null or empty");
		}

		int l = 0;
		int r = ints.length - 1;

		while (l <= r)
		{
			int m = l + (r - l) / 2;

			if (ints[m] == 0)
			{
				return ints[m];
			}

			if (ints[m] < 0)
			{
				r = m - 1;
			}
			else
			{
				l = m + 1;
			}
		}

		if (l >= ints.length)
		{
			return ints[ints.length - 1];
		}
		if (r < 0)
		{
			return ints[0];
		}

		int leftDiff = Math.abs(-ints[r]);
		int rightDiff = Math.abs(-ints[l]);

		if (leftDiff <= rightDiff)
		{
			return ints[r];
		}
		else
		{
			return ints[l];
		}
	}
}
