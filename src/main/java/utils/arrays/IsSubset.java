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

package utils.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IsSubset
{
	/**
	 * Checks if an array A is a subset of array B
	 * <br>
	 * Example
	 * <br>
	 * For the following:
	 * <br>
	 * {@code int[] A = [9, 4]}
	 * <br>
	 * {@code int[] B = [9, 5]}
	 * <br>
	 * {@code int[] C = [17, -5, 9, 11, 1, 84, 4]}
	 * <br>
	 * Returns: A &sube; C → TRUE
	 * <br>
	 * Returns: B &nsub; C → FALSE
	 *
	 * @param superset The superset array to check within
	 * @param subset   The subset array values to check for
	 * @return TRUE if the superset contains all elements
	 * of the subset
	 * <br>FALSE if the superset does not contain
	 * all elements of the subset
	 */
	public static boolean isSubset(int[] superset, int[] subset)
	{
		int j = 0;

		for (int i : subset)
		{
			for (j = 0; j < superset.length; j++)
			{
				if (i == superset[j])
				{
					// "Remove" the element
					// This is the lazy approach
					superset[j] = 0;
					break;
				}
			}

			if (j == superset.length)
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks if an array A is a subset of array B
	 * <br>
	 * Example:
	 * <br>
	 * For the following:
	 * <br>
	 * {@code int[] A = [9, 4]}
	 * <br>
	 * {@code int[] B = [9, 5]}
	 * <br>
	 * {@code int[] C = [17, -5, 9, 11, 1, 84, 4]}
	 * <br>
	 * Returns: A &sube; C → TRUE
	 * <br>
	 * Returns: B &nsub; C → FALSE
	 *
	 * @param superset The superset array to check within
	 * @param subset   The subset array values to check for
	 * @return TRUE if the superset contains all elements
	 * of the subset
	 * <br>FALSE if the superset does not contain
	 * all elements of the subset
	 */
	public static boolean subset(int[] subset, int[] superset)
	{
		List<Integer> a = Arrays.stream(subset).boxed().collect(Collectors.toList());
		List<Integer> b = Arrays.stream(superset).boxed().collect(Collectors.toList());

		for (Iterator<Integer> it = b.iterator(); it.hasNext(); )
		{
			int i = it.next();
			if (a.contains(i))
			{
				// Remove the current element from the iterator and the list.
				it.remove();
				a.remove(Integer.valueOf(i));
			}
		}

		System.out.println(b);
		System.out.println(a);

		return a.isEmpty();
	}

	public static <T> T subset(int[] subset, int[] superset, boolean r)
	{
		List<Integer> a = Arrays.stream(subset).boxed().collect(Collectors.toList());
		List<Integer> b = Arrays.stream(superset).boxed().toList();

		for (Iterator<Integer> it = b.iterator(); it.hasNext(); )
		{
			int i = it.next();
			if (a.contains(i))
			{
				it.remove();
				// This is intended, we want to remove the element of value i not the element at index i
				a.remove(Integer.valueOf(i));
			}
		}
		if (r)
		{
			return (T) (b.stream().mapToInt(Integer::intValue).toArray());
		}
		return (T) Boolean.valueOf(a.isEmpty());
	}

	public static int[] removeSubset(int[] subset, int[] superset)
	{
		List<Integer> a = Arrays.stream(subset).boxed().collect(Collectors.toList());
		List<Integer> b = Arrays.stream(superset).boxed().toList();

		for (Iterator<Integer> it = b.iterator(); it.hasNext(); )
		{
			int i = it.next();
			if (a.contains(i))
			{
				it.remove();
				// This is intended, we want to remove the element of value i not the element at index i
				a.remove(Integer.valueOf(i));
			}
		}
		return b.stream().mapToInt(Integer::intValue).toArray();
	}

	public static List<List<Integer>> helper(int[] subset, int[] superset)
	{
		List<Integer> a = Arrays.stream(subset).boxed().toList();
		List<Integer> b = Arrays.stream(superset).boxed().toList();

		return null;
	}

	private static void swap(int[] a, int i, int j)
	{
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static int[] sort(int[] a)
	{
		int i = 0;
		while (i < a.length)
		{
			if (a[i] == i + 1 || a[i] <= 0 || a[i] > a.length)
			{
				i++;
			}
			else if (a[a[i] - 1] != a[i])
			{
				swap(a, i, a[i] - 1);
			}
			else
			{
				i++;
			}
		}
		return a;
	}
}
