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
 *
 */
package challenge.hard.firstMissingPositive;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;

/*
	Given an unsorted integer array nums,
	return the smallest missing positive integer.

	You must implement an algorithm that
	runs in O(n) time and uses constant extra space.

	Example 1:
	Input: nums = [1,2,0]
	Output: 3
	Explanation: The numbers in the range [1,2] are all in the array.

	Example 2:
	Input: nums = [3,4,-1,1]
	Output: 2
	Explanation: 1 is in the array but 2 is missing.

	Example 3:
	Input: nums = [7,8,9,11,12]
	Output: 1
	Explanation: The smallest positive integer 1 is missing.

	Constraints:

	1 <= nums.length <= 10^5
	-2^31 <= nums[i] <= 2^31 - 1
 */

/**
 * Finds the smallest missing positive integer within an array
 * or the next following integer if the sequence of integers
 * has no discrepancy
 */
public class FirstMissingPositive implements Runnable
{
	final int[] ARRAY_0 = new int[]{0};
	final int[] ARRAY_1 = new int[]{1, 2, 0};
	final int[] ARRAY_2 = new int[]{3, 4, -1, 1};
	final int[] ARRAY_3 = new int[]{7, 8, 9, 11, 12};
	final int[] ARRAY_4 = new int[]{1, 2, 3, 5, 6, 7, 10, 12, 13, 14, 16, 18, 19, 21, 24, 25, 26, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 41, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 54, 55};

	public static void main(String[] args)
	{
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		firstMissingPositive.run();
	}

	@Override
	public void run()
	{
		//System.out.println("\nResult array 1: " + find(ARRAY_1));
		//System.out.println("\nResult array 2: " + find(ARRAY_2));
		//System.out.println("\nResult array 3: " + find(ARRAY_3));

		//final int[] generated = gen(2 << 15);
		//final int[] generated = gen(2 << 7);
		//System.out.println(Arrays.toString(generated));
		//t(generated);
		//solve(generated);
		//System.out.println("LeetCode: " + fmp(generated));
		//System.out.println("LeetCode: " + firstMissingPositive(generated));
		//streamSolution(generated);
		//solve(ARRAY_4);

		//allSolutions(ARRAY_0);
		//System.out.println();
		//allSolutions(ARRAY_1);
		//System.out.println();
		//allSolutions(ARRAY_2);
		//System.out.println();
		//allSolutions(ARRAY_3);
		//System.out.println();
		//allSolutions(ARRAY_4);
		//System.out.println();
		//allSolutions(gen(2 << 8));
		//System.out.println();
		//allSolutions(gen(2 << 8));
		//System.out.println();
		allSolutions(gen(2 << 8));

		//System.out.println("Finder: " + finder(ARRAY_0) + ", Control: " + fmp(ARRAY_0));
		//System.out.println("Finder: " + finder(ARRAY_1) + ", Control: " + fmp(ARRAY_1));
		//System.out.println("Finder: " + finder(ARRAY_2) + ", Control: " + fmp(ARRAY_2));
		//System.out.println("Finder: " + finder(ARRAY_3) + ", Control: " + fmp(ARRAY_3));
		//System.out.println("Finder: " + finder(ARRAY_4) + ", Control: " + fmp(ARRAY_4));
	}

	public void allSolutions(int[] array)
	{
		solve(array);
		System.out.println("solve2(): " + solve2(array));
		System.out.println("  find(): " + find(array));
		System.out.println("     f(): " + f(array));
		System.out.println("  leet(): " + leet(array));
		System.out.println("   fmp(): " + fmp(array));
		streamSolution(array);
		streamSolution2(array);
		streamSolution3(array);
		streamSolution4(array);
	}

	public static void streamSolution(int[] array)
	{
		AtomicInteger a = new AtomicInteger(1);
		IntPredicate sequential = (i) -> i == a.get();

		Arrays.stream(array).sorted()
			.distinct()
			.filter(i -> i > 0)
			.takeWhile(sequential)
			.forEach(i -> a.set(a.incrementAndGet()));
		System.out.println(" streamSolution(): " + a.get());
	}

	public static void streamSolution2(int[] ints)
	{
		int[] a = new int[]{1, ints.length};
		Arrays.stream(ints)
			.distinct()
			.sorted()
			.filter(i -> i > 0 && i < a[1])
			.takeWhile(i -> 1 < i || i < a[1])
			.forEach(i ->
			{
				if (i == a[0])
				{
					a[0] = a[0] + 1;
				}
			});
		System.out.println("streamSolution2(): " + a[0]);
	}

	public static void streamSolution3(int[] ints)
	{
		int[] a = new int[]{1, ints.length};
		Arrays.stream(ints)
			.sorted()
			.distinct()
			.filter(i -> i > 0)
			.limit(a[1])
			.forEach(i ->
			{
				if (i == a[0])
				{
					a[0] = a[0] + 1;
				}
			});
		System.out.println("streamSolution3(): " + a[0]);
	}

	public static void streamSolution4(int[] ints)
	{
		int[] a = new int[]{1, ints.length};
		Arrays.stream(ints)
			.parallel()
			.sorted()
			.distinct()
			.filter(i -> i > 0 || i < a[1])
			.forEachOrdered(i ->
			{
				if (i == a[0])
				{
					a[0] = a[0] + 1;
				}
			});
		System.out.println("streamSolution3(): " + a[0]);
	}

	public static void solve(int[] array)
	{
		int pass = 0;
		//array = Arrays.stream(array).sorted().distinct().dropWhile(i -> i < 1).toArray();
		//array = Arrays.stream(array).sorted().distinct().dropWhile(i -> i < 1).limit(array.length).toArray();
		array = Arrays.stream(array).parallel().sorted().distinct().filter(i -> i > 0).limit(array.length).toArray();

		int min = Arrays.stream(array).min().orElse(-1);
		int max = Arrays.stream(array).max().orElse(-1);

		if (min > 1)
		{
			System.out.println("Min value in the array: " + min + "\nDefault min: " + 1);
			return;
		}
		else if (max == array.length)
		{
			System.out.println("Array does not contain any missing value.\nDefault sequential value: " + (max + 1));
			return;
		}

		while (array.length > 2)
		{
			int index = (array.length + 1) / 2;
			System.out.println("\tPass: " + pass + ", Array size: " + array.length + ", Index: " + index + ", " + Arrays.toString(array));
			if (array[index] - array[0] != index)
			{
				array = Arrays.copyOfRange(array, 0, index);
				//System.out.println("\tCopied lower segment, new array: " + Arrays.toString(array));
			}
			else
			{
				array = Arrays.copyOfRange(array, index, array.length);
				//System.out.println("\tCopied upper segment, new array: " + Arrays.toString(array));
			}
			pass++;
		}

		min = array[0];
		max = array[array.length - 1];

		System.out.println("Lowest missing value: " + (min + 1 == max ? max + 1 : min + 1));
	}

	public static int solve2(int[] array)
	{
		int pass = 0;
		array = Arrays.stream(array).parallel().sorted().distinct().filter(i -> i > 0).limit(array.length).toArray();

		boolean upper = false;
		boolean upperTraversed = false;

		while (array.length != 2)
		{
			System.out.println("\tPass: " + pass + ", Array size: " + array.length + ", Index: " + (upper ? array.length / 2 : Math.round((float) array.length / 2)) + ", " + Arrays.toString(array));

			if (array[0] != 1 && !upperTraversed)
			{
				return 1;
			}
			if (array[(array.length + 1) / 2] - array[0] != (array.length + 1) / 2)
			{
				array = Arrays.copyOfRange(array, 0, Math.round((float) array.length / 2));
				upper = false;
			}
			else
			{
				array = Arrays.copyOfRange(array, array.length / 2, array.length);
				upper = true;
				upperTraversed = true;
			}
			pass++;
		}
		return array[0] == array[array.length - 1] - 1 ? array[array.length - 1] + 1 : array[0] + 1;
	}

	// Not accurate
	public static int find(int[] array)
	{
		int[] finalArray = array;
		array = Arrays.stream(array)
			.distinct()
			.sorted()
			.dropWhile(i -> i < 1 || i > finalArray.length)
			.toArray();

		int min = Arrays.stream(array).min().orElse(-1);
		int max = Arrays.stream(array).max().orElse(-1);

		if (min > 1)
		{
			return 1;
		}
		else if (max == array.length)
		{
			return max + 1;
		}

		while (array.length > 2)
		{
			int index = (array.length + 1) / 2;
			if (array[index] - array[0] != index)
			{
				array = Arrays.copyOfRange(array, 0, index);
			}
			else
			{
				array = Arrays.copyOfRange(array, index, array.length);
			}
		}

		System.out.println(Arrays.toString(array));
		return array.length == 1 ? array[0] : array[0] + 1 == array[array.length - 1] ? array[array.length - 1] + 1 : array[0] + 1;
		//return array[0] + 1 == array[array.length - 1] ? array[array.length - 1] + 1 : array[0] + 1;
	}

	/*
		TODO: has bug
	 */
	// formatted and made readable like a proper leetcode submission!
	static int f(int[] a)
	{
		int[] finalA = a;
		//a = Arrays.stream(a).distinct().sorted().takeWhile(i -> 0 < i || i < finalA.length).toArray();
		a = Arrays.stream(a).sorted().distinct().takeWhile(i -> 0 < i || i < finalA.length).toArray();
		int l = Arrays.stream(a).min().orElse(1), g = Arrays.stream(a).min().orElse(-1);
		if (l > 1)
		{
			return 1;
		}
		else if (g == a.length)
		{
			return (g + 1);
		}
		while (a.length > 1)
		{
			int i = (a.length + 1) / 2;
			if (a[i] - a[0] != i)
			{
				a = Arrays.copyOfRange(a, 0, i);
			}
			else
			{
				a = Arrays.copyOfRange(a, i, a.length);
			}
		}
		//int mi = a[0], ma = a[a.length - 1];
		//return mi + 1 == ma ? ma + 1 : mi + 1;
		return a[0] + 1;
	}

	public int[] gen(int s)
	{
		int[] array = new int[s];
		for (int i = 0; i < s; i++)
		{
			int n = (int) (Math.random() * s);
			int j = (int) (Math.random() * (2 << 9));
			array[i] = j > 2 << 3 ? n : n * -1;
		}
		return array;
	}

	/*
		TODO: has bug
    */
	public static int leet(int[] array)
	{
		int[] finalArray = array;
		//array = Arrays.stream(array).distinct().sorted().takeWhile(i -> 0 < i || i < finalArray.length).toArray();
		array = Arrays.stream(array).sorted().distinct().takeWhile(i -> 0 < i || i < finalArray.length).toArray();

		while (array.length > 1)
		{
			int index = (array.length + 1) / 2;
			if (array[index] - array[0] != index)
			{
				array = Arrays.copyOfRange(array, 0, index);
			}
			else
			{
				array = Arrays.copyOfRange(array, index, array.length);
			}
		}

		//return (array[0] + 1 == array[array.length - 1] ? array[array.length - 1] + 1 : array[0] + 1);
		return (array[0] > 1 ? 1 : array[0] + 1);
	}

	/***********************************************
	 LeetCode top answer below
	 */
	public int fmp(int[] a)
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
				_swap(a, i, a[i] - 1);
			}
			else
			{
				i++;
			}
		}
		i = 0;
		while (i < a.length && a[i] == i + 1)
		{
			i++;
		}
		return i + 1;
	}

	private void _swap(int[] a, int i, int j)
	{
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// Made readable
	public int firstMissingPositive(int[] array)
	{
		System.out.println();
		int i = 0;
		int pass = 0;

		while (i < array.length)
		{
			// If the value at array[i]
			//    is equal to its order, i.e. array[0] = 1, array[2] = 1 ...
			//    OR
			//    is less than 1
			//    OR
			//    is greater than the array size
			if (array[i] == i + 1 || array[i] <= 0 || array[i] > array.length)
			{
				i++;
			}
			// If the value at array[i] does not equal its order
			// e.g. array[0] != 1, array[5] != 6
			else if (array[array[i] - 1] != array[i])
			{
				swap(array, i, array[i] - 1);
			}
			else
			{
				i++;
			}
			System.out.println(pass + ": " + Arrays.toString(array));
			pass++;
		}

		i = 0;

		while (i < array.length && array[i] == i + 1)
		{
			System.out.println("array[" + i + "]: " + array[i]);
			i++;
		}

		return i + 1;
	}

	private void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


	//---------------------------------------------------------------------//

	public int finder(int[] array)
	{
		int i = 0;

		while (i < array.length)
		{
			if (0 > array[i] || array[i] > array.length || array[i] != i + 1)
			{
				swap(array, i, i + 1);
				continue;
			}
			i++;
		}

		return i;
	}
}
