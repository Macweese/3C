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

import java.util.Arrays;

public class SelectionSort
{

	private static void selectionSort(int[] nums)
	{
		for (int i = 0, n = nums.length; i < n - 1; ++i)
		{
			int minIndex = i;
			for (int j = i; j < n; ++j)
			{
				if (nums[j] < nums[minIndex])
				{
					minIndex = j;
				}
			}
			swap(nums, minIndex, i);
		}
	}

	private static void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args)
	{
		int[] nums = {1, 2, 7, 9, 5, 8};
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}