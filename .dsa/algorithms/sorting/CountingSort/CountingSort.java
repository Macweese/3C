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

public class CountingSort
{
	public static void countingSort(int[] nums, int min, int max)
	{
		int n = nums.length;
		int k = max - min + 1;
		int[] c = new int[k];
		for (int v : nums)
		{
			c[v - min]++;
		}

		for (int i = 1; i < k; i++)
		{
			c[i] += c[i - 1];
		}

		int[] r = new int[n];
		for (int i = n - 1; i >= 0; i--)
		{
			int v = nums[i];
			int a = c[v - min];
			r[a - 1] = v;
			c[v - min]--;
		}
		System.arraycopy(r, 0, nums, 0, n);
	}

	public static void main(String[] args)
	{

		// test case 1
		int[] nums = {1, 2, 7, 9, 5, 5, 8};
		countingSort(nums, 1, 9);
		System.out.println(Arrays.toString(nums));

		// test case 2
		int[] nums2 = {2, 7, 9, 5, 5, 8};
		countingSort(nums2, 2, 9);
		System.out.println(Arrays.toString(nums2));
	}
}