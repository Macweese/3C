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

public class ShellSort
{

	private static int[] shellSort(int[] arr)
	{
		int n = arr.length;

		for (int gap = n / 2; gap > 0; gap /= 2)
		{
			for (int i = gap; i < n; i++)
			{
				int key = arr[i];
				int j = i;
				while (j >= gap && arr[j - gap] > key)
				{
					arr[j] = arr[j - gap];
					j -= gap;
				}
				arr[j] = key;
			}
		}
		return arr;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(shellSort(new int[]{1, 2, 7, 9, 5, 8})));
	}
}
