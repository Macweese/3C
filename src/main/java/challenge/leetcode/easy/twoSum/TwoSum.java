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
package challenge.leetcode.easy.twoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TwoSum
{
	private static final int ARRAY_SIZE_MIN = 3;
	private static final int ARRAY_SIZE_MAX = 3000;
	private static final int VALUE_MIN = -100_000;
	private static final int VALUE_MAX = 100_000;

	private static List<int[]> addends = new ArrayList<>();
	public static ArrayList<int[]> combinations = new ArrayList<>();

	public static void findAddends3(Combination combination, int[] ints, int sum)
	{
		// Lazy work around
		// These are initialized to Integer.MIN_VALUE because 0 is a potentially valid value, whilst Integer.MIN_VALUE is not
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		int c = Integer.MIN_VALUE;

		for (int i = 0; i < ints.length; i++)
		{
			a = ints[i];

			for (int j = 0; j < ints.length; j++)
			{
				if (i == j)
				{
					continue;
				}

				b = ints[j];
				int r = sum - a - b;

				for (int k = 0; k < ints.length; k++)
				{
					if (i == k || j == k)
					{
						continue;
					}

					if (ints[k] == r)
					{
						c = ints[k];

						int[] candidate = new int[]{a, b, c};

						if (!answerExists(combination, addends, candidate) && (a > Integer.MIN_VALUE && b > Integer.MIN_VALUE && c > Integer.MIN_VALUE))
						{
							addends.add(candidate);
						}
					}
				}
			}
		}
	}

	public static void findAddends(Combination combination, final int[] ints, final int sum)
	{
		findAddends(combination, ints, sum, 2);
	}

	public static void findAddends(Combination combination, final int[] ints, final int sum, final int addendSize)
	{
		if (combination == Combination.FIRST)
		{
			findFirstAddendCombination(ints, sum);
		}
		else
		{
			findAllAddendCombinations(combination, ints, sum, addendSize);
		}
	}

	public static void findFirstAddendCombination(final int[] ints, final int sum)
	{
		//final int[] ints = {6, 4, 7, 9, 3, 9, 9, 100, 10};
		//final int sum = 24;
		int a = 0;
		int b = 0;
		int c = 0;

		outer:
		for (int i = 0; i < ints.length; i++)
		{
			a = ints[i];

			for (int j = 0; j < ints.length; j++)
			{
				if (i == j)
				{
					continue;
				}

				b = ints[j];
				int r = sum - a - b;

				if (r < 0)
				{
					continue;
				}

				for (int k = 0; k < ints.length; k++)
				{
					if (i == k || j == k)
					{
						continue;
					}

					if (ints[k] == r)
					{
						c = ints[k];
						break outer;
					}
				}
			}
		}

		if (a + b + c != sum)
		{
			System.out.println("No answer exists.");
		}
		else
		{
			System.out.println("a: " + a);
			System.out.println("b: " + b);
			System.out.println("c: " + c);
			System.out.println("Sum: " + (a + b + c));
		}
	}

	public static void findAllAddendCombinations(final Combination combination, final int[] ints, final int sum, final int addendSize)
	{
		int index = 0;

		if (addendSize > ints.length)
		{
			System.out.println("No possible answer exists.");
			return;
		}

		while (index < ints.length / addendSize)
		{
			findAddends3(combination, ints, sum);
			index++;
		}

		addends.forEach(array -> System.out.println(Arrays.toString(array)));
	}

	private static boolean answerExists(int[][] addends, int a, int b, int c)
	{
		return Arrays.stream(addends).anyMatch(array -> array[0] == a && array[1] == b && array[2] == c);
	}

	private static boolean answerExists(List<int[]> addends, int a, int b, int c)
	{
		return addends.stream().anyMatch(array -> array[0] == a && array[1] == b && array[2] == c);
	}

	private static boolean answerExists(Combination combination, List<int[]> addends, int... addend)
	{
		return addends.stream().anyMatch(array -> identicalArrayElements(combination, array, addend));
		//return addends.stream().anyMatch(array -> array[0] == a && array[1] == b && array[2] == c);
	}

/*    public static boolean identicalArrayElements(int[] a, int[] b)
    {
        if (a.length != b.length)
        {
            return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }

        return true;
    }*/

	public static boolean identicalArrayElements(Combination combination, int[] a, int... b)
	{
		if (a.length != b.length)
		{
			return false;
		}

		if (combination == Combination.COMBINATION)
		{
			Arrays.sort(a);
			Arrays.sort(b);
			return compareElements(a, b);
		}
		else if (combination == Combination.PERMUTATION)
		{
			return compareElements(a, b);
		}

		return true;
	}

	public static boolean compareElements(int[] a, int[] b)
	{
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] != b[i])
			{
				return false;
			}
		}

		return true;
	}

	public static int[] generateIntArray()
	{
		int[] nums = new int[generateRandomInt(ARRAY_SIZE_MIN, ARRAY_SIZE_MAX)];

		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = generateRandomInt(VALUE_MIN, VALUE_MAX);
		}

		return nums;
	}

	public static int generateRandomInt(int min, int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static void removeDuplicatesFromArray()
	{
		int[] duplicates = {1, 1, 2, 3, 3, 3, 4, 5, 5};
		int[] unique = Arrays.stream(duplicates).distinct().toArray();

		System.out.println("Duplicates: " + Arrays.toString(duplicates));
		System.out.println("Unique: " + Arrays.toString(unique));
	}

	public static void twoDArrayToOneD()
	{
		int[][] nested = {{1, 2, 3}, {4, 5}, {6}};
		int size = Arrays.stream(nested).mapToInt(sub -> sub.length).sum();
		int[] array = new int[size];

		for (int[] i : nested)
		{
			int index = 0;

			for (int j : i)
			{
				array[index] = j;
				index++;
			}
		}

		System.out.println("Old: " + Arrays.deepToString(nested));
		System.out.println("New: " + Arrays.toString(array));
	}
}

