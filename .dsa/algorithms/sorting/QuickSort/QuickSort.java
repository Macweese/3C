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

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
		{
			nums[i] = sc.nextInt();
		}
		quickSort(nums, 0, n - 1);
		for (int i = 0; i < n; ++i)
		{
			System.out.print(nums[i] + " ");
		}
	}

	public static void quickSort(int[] nums, int left, int right)
	{
		if (left >= right)
		{
			return;
		}
		int i = left - 1, j = right + 1;
		int x = nums[(left + right) >> 1];
		while (i < j)
		{
			while (nums[++i] < x)
				;
			while (nums[--j] > x)
				;
			if (i < j)
			{
				int t = nums[i];
				nums[i] = nums[j];
				nums[j] = t;
			}
		}
		quickSort(nums, left, j);
		quickSort(nums, j + 1, right);
	}
}