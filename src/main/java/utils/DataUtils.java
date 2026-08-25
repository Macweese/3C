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
package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

// TODO: Clean up this class
//       * consolidate duplicate methods for generating arrays
//       * or split into own Generator class
//       * documentation
public class DataUtils
{
	/**
	 * Generates an integer array according to the provided {@link IntArraySpec}.
	 *
	 * <p>Behavior is controlled by:
	 * <ul>
	 *   <li>Size: {@link SizeMode#FIXED} uses the exact {@code size}, {@link SizeMode#RANDOM} picks a size uniformly at random in [1, size].</li>
	 *   <li>Value bounds: elements are sampled uniformly from the inclusive range [{@code minInclusive}, {@code maxInclusive}].</li>
	 *   <li>Ordering:
	 *     <ul>
	 *       <li>{@link SortingMode#UNSORTED}:<br> leaves the initially generated random order unchanged.</li>
	 *       <li>{@link SortingMode#SHUFFLED}:<br> shuffles the array uniformly (Fisher–Yates).</li>
	 *       <li>{@link SortingMode#INCREASING}/{@link SortingMode#NON_DECREASING}:<br> sorts non-decreasing (duplicates allowed).</li>
	 *       <li>{@link SortingMode#DECREASING}/{@link SortingMode#NON_INCREASING}:<br> sorts non-increasing (duplicates allowed).</li>
	 *       <li>{@link SortingMode#STRICTLY_INCREASING}/{@link SortingMode#STRICTLY_DECREASING}:<br> ensures all elements are distinct,
	 *       then sorts ascending/descending respectively.</li>
	 *     </ul>
	 *   </li>
	 * </ul>
	 *
	 * <p>Edge cases:
	 * <ul>
	 *   <li>If spec resolves to size 0, an empty array is returned.</li>
	 *   <li>For strict modes, if the number of required distinct values exceeds the size of the requested value range,
	 *       an {@link IllegalArgumentException} is thrown.</li>
	 * </ul>
	 *
	 * @param spec Specification for size, bounds, and ordering. Must not be null.
	 * @return A new array meeting the specification; possibly empty if size resolves to 0.
	 * @throws NullPointerException     if {@code spec} is null.
	 * @throws IllegalArgumentException if strict ordering is requested but the bounds cannot provide enough distinct values.
	 * @apiNote Values are sampled uniformly over the integer range using an inclusive bound strategy.
	 * @implNote Uses {@link ThreadLocalRandom} for randomness. Sorting is via {@link Arrays#sort(int[])}; shuffle uses Fisher–Yates.
	 */
	public static int[] generateArray(IntArraySpec spec)
	{
		Objects.requireNonNull(spec, "spec");
		final int n = spec.resolveSize();
		if (n <= 0)
		{
			return new int[0];
		}

		final int min = spec.minInclusive;
		final int max = spec.maxInclusive;

		final SortingMode mode = spec.sortingMode;
		final boolean requireDistinct = mode.isStrict();

		// If strict is required, ensure feasible number of distinct values in range:
		if (requireDistinct)
		{
			long rangeSize = ((long) max - (long) min) + 1L;
			if (rangeSize < n)
			{
				throw new IllegalArgumentException(
					"Cannot generate " + n + " distinct values in range [" + min + ", " + max + "]");
			}
		}

		final int[] a = new int[n];

		if (requireDistinct)
		{
			fillDistinctRandom(a, min, max);
		}
		else
		{
			fillRandom(a, min, max);
		}

		// Apply sorting/ordering semantics
		if (mode.isOrdered())
		{
			Arrays.sort(a);
			if (mode.isDescending())
			{
				reverse(a);
			}
		}
		else if (mode.isShuffled())
		{
			shuffle(a);
		}
		// UNSORTED: leave as generated (random order)

		return a;
	}

	// ---------------------------------
	// Convenience overloads (backward-ish)
	// ---------------------------------

	/**
	 * Generates a random-length array with values in [0, {@link Integer#MAX_VALUE}] (inclusive), unsorted.
	 *
	 * <p>Details:
	 * <ul>
	 *   <li>Size: uniformly random in the inclusive range [1, 20].</li>
	 *   <li>Values: each element sampled uniformly from [0, {@link Integer#MAX_VALUE}].</li>
	 *   <li>Ordering: left unsorted (initial random generation order is preserved).</li>
	 * </ul>
	 *
	 * @return A new array with the above characteristics. Never null; may be empty only if the internal size resolves to 0 (which does not occur here).
	 * @implNote Uses {@link ThreadLocalRandom} for randomness.
	 * @see #generateArray(IntArraySpec)
	 */
	public static int[] generateRandomArray()
	{
		return generateArray(
			IntArraySpec.builder(20)
				.randomSizeUpTo()
				.lowerBound(0)
				.upperBound(Integer.MAX_VALUE)
				.sorting(SortingMode.UNSORTED)
				.build()
		);
	}

	/**
	 * Generates a fixed-length array with values in [0, {@code Integer.MAX_VALUE - 1}] (inclusive), unsorted.
	 *
	 * <p>Details:
	 * <ul>
	 *   <li>Size: exactly {@code size} (if {@code size} &lt;= 0, returns an empty array).</li>
	 *   <li>Values: each element sampled uniformly from [0, {@code Integer.MAX_VALUE - 1}] (inclusive).</li>
	 *   <li>Ordering: unsorted (initial random generation order is preserved).</li>
	 * </ul>
	 *
	 * <p>Note: The upper bound uses {@code Integer.MAX_VALUE - 1} for historical consistency with earlier behavior.</p>
	 *
	 * @param size Desired array length; non-positive values yield an empty array.
	 * @return A new array with the specified size and bounds.
	 * @implNote Uses {@link ThreadLocalRandom} for randomness.
	 * @see #generateArray(IntArraySpec)
	 */
	public static int[] generateRandomArray(int size)
	{
		return generateArray(
			IntArraySpec.builder(size)
				.fixedSize()
				.lowerBound(0)
				.upperBound(Integer.MAX_VALUE - 1)
				.sorting(SortingMode.UNSORTED)
				.build()
		);
	}

	/**
	 * Generates a fixed-length array with values in [{@code minValue}, {@code maxValue}] (inclusive), unsorted.
	 *
	 * <p>Details:
	 * <ul>
	 *   <li>Size: exactly {@code size} (if {@code size} &lt;= 0, returns an empty array).</li>
	 *   <li>Values: sampled uniformly from the inclusive range [{@code minValue}, {@code maxValue}].</li>
	 *   <li>Ordering: unsorted.</li>
	 * </ul>
	 *
	 * @param size     Desired array length; non-positive values yield an empty array.
	 * @param minValue Inclusive lower bound for values.
	 * @param maxValue Inclusive upper bound for values.
	 * @return A new array of length {@code size} with values within the given bounds.
	 * @throws IllegalArgumentException if {@code minValue} &gt; {@code maxValue}.
	 * @implNote Uses {@link ThreadLocalRandom} for randomness.
	 * @see #generateArray(IntArraySpec)
	 */
	public static int[] generateRandomArray(int size, int minValue, int maxValue)
	{
		return generateArray(
			IntArraySpec.builder(size)
				.fixedSize()
				.bounds(minValue, maxValue)
				.sorting(SortingMode.UNSORTED)
				.build()
		);
	}

	/**
	 * Generates a fixed-length array with values in [0, {@code maxValue}] (inclusive), unsorted.
	 *
	 * <p>Details:
	 * <ul>
	 *   <li>Size: exactly {@code size} (if {@code size} &lt;= 0, returns an empty array).</li>
	 *   <li>Values: sampled uniformly from [0, {@code maxValue}] (inclusive).</li>
	 *   <li>Ordering: unsorted.</li>
	 * </ul>
	 *
	 * @param size     Desired array length; non-positive values yield an empty array.
	 * @param maxValue Inclusive upper bound for values.
	 * @return A new array of length {@code size} with values in [0, {@code maxValue}].
	 * @throws IllegalArgumentException if {@code maxValue} &lt; 0 (because the lower bound is 0).
	 * @implNote Uses {@link ThreadLocalRandom} for randomness.
	 * @see #generateArray(IntArraySpec)
	 */
	public static int[] generateRandomArray(int size, int maxValue)
	{
		return generateArray(
			IntArraySpec.builder(size)
				.fixedSize()
				.lowerBound(0)
				.upperBound(maxValue)
				.sorting(SortingMode.UNSORTED)
				.build()
		);
	}

	/**
	 * Generates an array with optional random size and values in [{@code minValue}, {@code maxValue}] (inclusive), unsorted.
	 *
	 * <p>Details:
	 * <ul>
	 *   <li>Size:
	 *     <ul>
	 *       <li>{@link SizeMode#FIXED}: exactly {@code size} (if {@code size} &lt;= 0, returns an empty array).</li>
	 *       <li>{@link SizeMode#RANDOM}: uniformly random length in [1, {@code size}] (if {@code size} &lt;= 0, returns an empty array).</li>
	 *     </ul>
	 *   </li>
	 *   <li>Values: sampled uniformly from [{@code minValue}, {@code maxValue}] (inclusive).</li>
	 *   <li>Ordering: unsorted.</li>
	 * </ul>
	 *
	 * @param size     Upper bound for size (or exact size if {@code sizeMode} is FIXED).
	 * @param sizeMode Whether the size should be fixed or a random length up to {@code size} (inclusive).
	 * @param minValue Inclusive lower bound for values.
	 * @param maxValue Inclusive upper bound for values.
	 * @return A new array with the requested size behavior and bounds.
	 * @throws IllegalArgumentException if {@code minValue} &gt; {@code maxValue}.
	 * @implNote Uses {@link ThreadLocalRandom} for randomness.
	 * @see #generateArray(IntArraySpec)
	 */
	public static int[] generateRandomArray(int size, SizeMode sizeMode, int minValue, int maxValue)
	{
		IntArraySpec.Builder b = IntArraySpec.builder(size).bounds(minValue, maxValue);
		if (sizeMode == SizeMode.RANDOM)
		{
			b.randomSizeUpTo();
		}
		else
		{
			b.fixedSize();
		}
		return generateArray(b.sorting(SortingMode.UNSORTED).build());
	}

	/**
	 * Generates an array with optional random size and values in [0, {@code maxValue}] (inclusive), unsorted.
	 *
	 * <p>Equivalent to {@link #generateRandomArray(int, SizeMode, int, int)} with {@code minValue = 0}.</p>
	 *
	 * @param size     Upper bound for size (or exact size if {@code sizeMode} is FIXED).
	 * @param sizeMode Whether the size should be fixed or a random length up to {@code size} (inclusive).
	 * @param maxValue Inclusive upper bound for values.
	 * @return A new array with the requested size behavior and bounds.
	 * @throws IllegalArgumentException if {@code maxValue} &lt; 0 (because the lower bound is 0).
	 * @implNote Uses {@link ThreadLocalRandom} for randomness.
	 * @see #generateArray(IntArraySpec)
	 */
	public static int[] generateRandomArray(int size, SizeMode sizeMode, int maxValue)
	{
		return generateRandomArray(size, sizeMode, 0, maxValue);
	}

	/**
	 * Generates a sequential integer array starting at {@code startFrom}.
	 *
	 * <p>Values are deterministic unless {@code sizeMode == RANDOM}. The sequence produced before any reordering is:
	 * {@code startFrom, startFrom + 1, ..., startFrom + size - 1} where:
	 * <ul>
	 *   <li>Size is exactly {@code n} when {@link SizeMode#FIXED}.</li>
	 *   <li>Size is chosen uniformly at random from [1, {@code n}] when {@link SizeMode#RANDOM} (if {@code n } &le; 0, returns empty).</li>
	 * </ul>
	 *
	 * <p>Ordering behavior:
	 * <ul>
	 *   <li>{@link SortingMode#INCREASING}/{@link SortingMode#NON_DECREASING}/{@link SortingMode#STRICTLY_INCREASING}:<br>
	 *       the array remains in increasing order (all elements are distinct by construction).</li>
	 *   <li>{@link SortingMode#DECREASING}/{@link SortingMode#NON_INCREASING}/{@link SortingMode#STRICTLY_DECREASING}:<br>
	 *       the array is reversed to descending order.</li>
	 *   <li>{@link SortingMode#SHUFFLED}:<br> the array is randomly shuffled (Fisher–Yates).</li>
	 *   <li>{@link SortingMode#UNSORTED}:<br> no reordering is applied; because the base sequence is increasing,
	 *       the result will also be increasing.</li>
	 * </ul>
	 *
	 * @param n         The fixed length (FIXED) or the maximum length bound (RANDOM).
	 * @param sizeMode  Whether to use a fixed length or draw a random length up to {@code n} (inclusive).
	 * @param startFrom The first value in the sequence before any reordering.
	 * @param mode      Desired ordering mode for the resulting array.
	 * @return A new sequential array honoring the requested size and ordering. Never null; may be empty if {@code n <= 0}.
	 * @implNote Uses {@link ThreadLocalRandom} when {@code sizeMode == RANDOM} and for shuffling.
	 */
	public static int[] generateSequentialArray(int n, SizeMode sizeMode, int startFrom, SortingMode mode)
	{
		final int size = (sizeMode == SizeMode.RANDOM && n > 0)
			? ThreadLocalRandom.current().nextInt(1, n + 1)
			: Math.max(0, n);

		int[] a = new int[size];
		for (int i = 0; i < size; i++)
		{
			a[i] = startFrom + i;
		}

		if (mode.isShuffled())
		{
			shuffle(a);
		}
		else if (mode.isDescending())
		{
			reverse(a);
		}
		// INCREASING / NON_DECREASING / STRICTLY_INCREASING are the same for sequential
		return a;
	}

	/**
	 * Convenience overload for {@link #generateSequentialArray(int, SizeMode, int, SortingMode)} with:
	 * <ul>
	 *   <li>{@code sizeMode = FIXED}</li>
	 *   <li>{@code startFrom = 1}</li>
	 *   <li>{@code mode = INCREASING}</li>
	 * </ul>
	 *
	 * @param n The array length.
	 * @return A sequential array {@code [1, 2, ..., n]} (or empty if {@code n <= 0}).
	 */
	public static int[] generateSequentialArray(int n)
	{
		return generateSequentialArray(n, SizeMode.FIXED, 1, SortingMode.INCREASING);
	}

	/**
	 * Convenience overload for {@link #generateSequentialArray(int, SizeMode, int, SortingMode)} with:
	 * <ul>
	 *   <li>{@code startFrom = 1}</li>
	 *   <li>{@code mode = INCREASING}</li>
	 * </ul>
	 *
	 * @param n        The fixed length (FIXED) or the maximum length bound (RANDOM).
	 * @param sizeMode Whether to use a fixed length or a random length up to {@code n}.
	 * @return A sequential array starting at 1, in increasing order; may be empty if {@code n <= 0}.
	 */
	public static int[] generateSequentialArray(int n, SizeMode sizeMode)
	{
		return generateSequentialArray(n, sizeMode, 1, SortingMode.INCREASING);
	}

	/**
	 * Convenience overload for {@link #generateSequentialArray(int, SizeMode, int, SortingMode)} with:
	 * <ul>
	 *   <li>{@code startFrom = 1}</li>
	 * </ul>
	 *
	 * @param n        The fixed length (FIXED) or the maximum length bound (RANDOM).
	 * @param sizeMode Whether to use a fixed length or a random length up to {@code n}.
	 * @param mode     Desired ordering mode for the resulting array.
	 * @return A sequential array starting at 1 with the desired ordering; may be empty if {@code n <= 0}.
	 */
	public static int[] generateSequentialArray(int n, SizeMode sizeMode, SortingMode mode)
	{
		return generateSequentialArray(n, sizeMode, 1, mode);
	}


	private static void fillRandom(int[] a, int minInclusive, int maxInclusive)
	{
		for (int i = 0; i < a.length; i++)
		{
			a[i] = randomIntInclusive(minInclusive, maxInclusive);
		}
	}

	private static void fillDistinctRandom(int[] a, int minInclusive, int maxInclusive)
	{
		// Assumes feasibility (checked by caller)
		HashSet<Integer> set = new HashSet<>(a.length * 2);
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		while (set.size() < a.length)
		{
			long range = ((long) maxInclusive - (long) minInclusive) + 1L;
			long rnd = tlr.nextLong(range);
			int val = (int) (minInclusive + rnd);
			set.add(val);
		}
		int i = 0;
		for (int v : set)
		{
			a[i++] = v;
			if (i == a.length)
			{
				break;
			}
		}
	}

	private static int randomIntInclusive(int minInclusive, int maxInclusive)
	{
		long range = ((long) maxInclusive - (long) minInclusive) + 1L;
		long rnd = ThreadLocalRandom.current().nextLong(range);
		return (int) (minInclusive + rnd);
	}

	private static void reverse(int[] a)
	{
		for (int i = 0, j = a.length - 1; i < j; i++, j--)
		{
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
	}

	private static void shuffle(int[] a)
	{
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		for (int i = a.length - 1; i > 0; i--)
		{
			int j = tlr.nextInt(i + 1);
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
	}

	/**
	 * Searches an array to find the index of the value
	 *
	 * @param ints  The array to search
	 * @param value The value to find
	 * @return Returns the index of the value in the array,
	 * or <code>-1</code> if the value does not exist in the array.
	 */
	public static int binarySearch(int[] ints, int value)
	{
		int l = 0;
		int r = ints.length - 1;

		while (l <= r)
		{
			int m = l + (r - l) / 2;

			if (ints[m] == value)
			{
				return m;
			}

			if (ints[m] < value)
			{
				l = m + 1;
			}
			else
			{
				r = m - 1;
			}
		}

		return -1;
	}

	/**
	 * Binary search of integer array
	 *
	 * @param ints  sorted integer array
	 * @param value target value to search for
	 * @return returns the search value if found,
	 * or if the value is not found, returns the CLOSEST value
	 * (the one with minimum absolute difference)
	 */
	public static int binarySearchClosest(int[] ints, int value)
	{
		if (ints == null || ints.length == 0)
		{
			throw new IllegalArgumentException("Array cannot be null or empty");
		}

		int l = 0;
		int r = ints.length - 1;

		// Standard binary search first
		while (l <= r)
		{
			int m = l + (r - l) / 2;

			if (ints[m] == value)
			{
				return ints[m]; // Exact match found
			}

			if (ints[m] < value)
			{
				l = m + 1;
			}
			else
			{
				r = m - 1;
			}
		}

		// No exact match found, find closest value
		// At this point: l > r, and the target would be inserted at position l

		// Handle edge cases
		if (l >= ints.length)
		{
			return ints[ints.length - 1]; // Target larger than all elements
		}
		if (r < 0)
		{
			return ints[0]; // Target smaller than all elements
		}

		// Compare the two closest candidates: ints[r] and ints[l]
		int leftDiff = Math.abs(value - ints[r]);
		int rightDiff = Math.abs(value - ints[l]);

		if (leftDiff <= rightDiff)
		{
			return ints[r];
		}
		else
		{
			return ints[l];
		}
	}

	/**
	 * Modified binary search<br>
	 * <br>
	 * Searches an array and returns the value, if present.
	 * Otherwise, returns the closest matching value.
	 * If no value was found, returns <code>null</code>.
	 *
	 * @param ints      Array to search
	 * @param value     Value to find
	 * @param takeLower Specify whether to prefer closest lower alternative or higher.
	 * @return returns the search value
	 * or
	 * if the value is not found
	 * returns the <i>closest</i> value
	 * where it could be less than
	 * or
	 * more than the search value,
	 * within the specified ranges
	 * @implNote This is not a strict binary search,
	 * but a combination of binary search and linear
	 * search.<br>
	 * The worst case performance of this algorithm
	 * is <br><math>O(n + n&times;log(n))</math>,<br> as it performs
	 * a binary search first, and if no closest match
	 * was found, reverts to linear search through,
	 * at worst case, the entire array.
	 */
	public static Optional<Integer> binarySearchClosest(int[] ints, int value, boolean takeLower)
	{
		return binarySearchClosest(ints, value, takeLower, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Modified binary search<br>
	 * <br>
	 * Searches an array and returns the value, if present.
	 * Otherwise, returns the closest matching value, with the specified range.
	 * If no value was found, returns <code>null</code>.
	 *
	 * @param ints          Array to search
	 * @param value         Value to find
	 * @param takeLower     Specify whether to prefer closest lower alternative or higher.
	 * @param minAcceptable The minimum acceptable value, as alternative value.
	 * @param maxAcceptable The Maximum acceptable value, as alternative value.
	 * @return returns the search value
	 * or
	 * if the value is not found
	 * returns the <i>closest</i> value
	 * where it could be less than
	 * or
	 * more than the search value,
	 * within the specified ranges
	 * @implNote This is not a strict binary search,
	 * but a combination of binary search and linear
	 * search.<br>
	 * The worst case performance of this algorithm
	 * is <br><math>O(n + n&times;log(n))</math>,<br> , as it performs
	 * a binary search first, and if no closest match
	 * was found, reverts to linear search through,
	 * at worst case, the entire array.
	 */
	public static Optional<Integer> binarySearchClosest(int[] ints, int value, boolean takeLower, int minAcceptable, int maxAcceptable)
	{
		if (ints == null || ints.length == 0)
		{
			return Optional.empty();
		}

		// Ensure minAcceptable <= maxAcceptable
		int min = Math.min(minAcceptable, maxAcceptable);
		int max = Math.max(minAcceptable, maxAcceptable);
		minAcceptable = min;
		maxAcceptable = max;

		int l = 0;
		int r = ints.length - 1;

		// Standard binary search first
		while (l <= r)
		{
			int m = l + (r - l) / 2;

			if (ints[m] == value)
			{
				// Exact match found - check if it's within acceptable bounds
				if (minAcceptable <= ints[m] && ints[m] <= maxAcceptable)
				{
					return Optional.of(ints[m]);
				}
				else
				{
					// Exact match found but outside bounds, still look for alternatives
					break;
				}
			}

			if (ints[m] < value)
			{
				l = m + 1;
			}
			else
			{
				r = m - 1;
			}
		}

		// No exact match (or exact match was out of bounds)
		// Find closest alternatives within bounds
		Integer lower = null;  // Closest value <= target within bounds
		Integer upper = null;  // Closest value >= target within bounds

		// Find closest lower value (largest value <= target within bounds)
		for (int i = 0; i < ints.length; i++)
		{
			if (ints[i] <= value && ints[i] >= minAcceptable && ints[i] <= maxAcceptable)
			{
				if (lower == null || ints[i] > lower)
				{
					lower = ints[i];
				}
			}
		}

		// Find closest upper value (smallest value >= target within bounds)
		for (int i = 0; i < ints.length; i++)
		{
			if (ints[i] >= value && ints[i] >= minAcceptable && ints[i] <= maxAcceptable)
			{
				if (upper == null || ints[i] < upper)
				{
					upper = ints[i];
				}
			}
		}

		// Return based on preference and availability
		if (takeLower)
		{
			if (lower != null)
			{
				return Optional.of(lower);
			}
			else if (upper != null)
			{
				return Optional.of(upper);
			}
		}
		else
		{
			if (upper != null)
			{
				return Optional.of(upper);
			}
			else if (lower != null)
			{
				return Optional.of(lower);
			}
		}

		return Optional.empty();
	}
}
