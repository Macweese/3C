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

package challenge.leetcode.easy.shuffleTheArray;

/**
 * @author Administrator
 * @Created 13/09/2025, 07:10 Sat 13 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1470
 * @Name Shuffle the Array
 * @Difficulty Easy
 * @Tags array
 * weekly contest 192
 * @link <a href="https://leetcode.com/problems/shuffle-the-array/">www.leetcode.com/1470</a>
 * @Description Given the array <code>nums</code> consisting of <code>2n</code> elements in the form <code>[x1,x2,...,xn,y1,y2,...,yn]</code>.<br>
 * <br>
 * <i>Return the array in the form</i> <code>[x1,y1,x2,y2,...,xn,yn]</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [2,5,1,3,4,7], n = 3</code>
 * 			<br><b>Output:</b> {@code [2,3,5,4,1,7]}
 *
 * 			<br><b>Output:</b> {@code [2,5,1,3,4,7]}
 * 			<br><b>Output:</b> {@code [2,4,1,3,5,7]}
 *
 * 			<br><b>Explanation:</b> Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2,3,4,4,3,2,1], n = 4</code>
 * 			<br><b>Output:</b> {@code [1,4,2,3,3,2,4,1]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [1,1,2,2], n = 2</code>
 * 			<br><b>Output:</b> {@code [1,2,1,2]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; n &le; 500</code></li>
 * 		<li><code>nums.length == 2n</code></li>
 * 		<li><code>1 &le; nums[i] &le; 10^3</code></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class ShuffleTheArray
{
	public static int[] interleaveSimple(int[] ints, int n)
	{
		int[] result = new int[ints.length];

		for (int i = 0; i < n; i++)
		{
			result[2 * i] = ints[i];
			result[2 * i + 1] = ints[i + n];
		}

		return result;
	}

	public static int[] shuffle(int[] ints, int n)
	{
		for (int i = 1; i <= n; i += 2)
		{
			int t = ints[i];
			ints[i] = ints[n + i];
			ints[i + n - 1] = t;
		}

		return ints;
	}

	public static int[] test(int[] ints, int n)
	{
		ints = swap(ints, 0, 1, n, ints[1]);
		return ints;
	}

	public static int[] swap(int[] ints, int cycle, int next, int prev, int value)
	{
		if (cycle > ints.length)
		{
			return ints;
		}
		cycle++;


		value = ints[next];
		ints[next] = ints[prev];
		ints[prev] = cycle == 0 ? value : ints[prev];
		prev = next;
		next = next < ints.length / 2 ? next * 2 : 2 * next - ints.length + 1;

		return swap(ints, cycle, next, prev, value);
	}

	/**
	 * Performs perfect (out-)shuffle,
	 * in-place with constant-space in linear time,
	 * using Huang-Langston algorithm.
	 *
	 * @param a The array to shuffle
	 * @return The shuffled array
	 */
	public static int[] perfectShuffle(int[] a)
	{
		int len = a.length;

		if ((len & 1) == 1)
		{
			throw new IllegalArgumentException("Array length must be even (2n).");
		}

		if (len <= 2)
		{
			// Already interleaved for n=1
			return a;
		}

		processSegment(a, 0, len);
		return a;
	}

	/**
	 * Processes subarray <code>a[start .. start+length-1]</code>, <code>length = 2m</code>, in canonical form:<br>
	 * <code>A (m) | B (m)</code><br>
	 * Repeatedly peels off a prefix of size <code>2n = 3^k - 1</code>,
	 * applies shuffle to its first t pairs, and shrinks the problem.
	 *
	 * @param a      The array being processed
	 * @param start  The starting index for the segment to process
	 * @param length The length of the segment to process
	 */
	private static void processSegment(int[] a, int start, int length)
	{
		while (length > 0)
		{
			int m = length / 2;
			if (m <= 1)
			{
				// Nothing further to do
				return;
			}

			// Choose largest 3^k - 1 <= 2m
			int blockSize = 3;
			while (blockSize - 1 <= 2 * m)
			{
				blockSize *= 3;
			}
			blockSize /= 3;
			int size = blockSize - 1;  // 2n
			int n = size / 2;

			// Decompose first 2m elements:
			// A1..An | A_{n+1}..A_m | B1..Bn | B_{n+1}..B_m
			// Labels: A (n), R (m - n), B (n), Z (m - n)
			int A = start;
			int r = m - n;
			// Z starts at (A + n + r) + n (implicit)

			// We need prefix arranged as [B A ...] so that first 2n elements = [b1..bt, a1..at].
			// Current: A R B ...
			// Rotate (A R) (length m) with B (length n): [A R][B] -> [B][A R]
			rotateAdjacentBlocks(a, A, n + r, n);

			// Now prefix = B A R Z; first 2n elements are B A.
			// Apply cycle leaders to those 2n positions to interleave into a1 b1 a2 b2 ... an bn.
			cycleLeadersBlock(a, start, size);

			// After cycle leaders, prefix becomes:
			// a1 b1 a2 b2 ... an bn  A_{n+1}..A_m  B_{n+1}..B_m
			// Suffix is again in canonical form A' B' with size 2(m - n).
			start += size;
			length -= size;
		}
	}

	/**
	 * Cycle-leader permutation on block of size <code>blockSize = 2n</code> at base.
	 * <table border="5">
	 * 		<tr>
	 * 			<td text-align: right;>Block currently:</td>
	 * 			<td text-align: left;>&emsp;<code>[a<sub>1</sub>, a<sub>2</sub>, ..a<sub>n</sub>, b<sub>1</sub>, b<sub>2</sub>, ..b<sub>n</sub>]</code></td>
	 * 		</tr>
	 * 		<tr>
	 * 			<td text-align: right;>We want:</td>
	 * 			<td text-align: left;>&emsp;<code>[a<sub>1</sub>, b<sub>1</sub>, a<sub>2</sub>, b<sub>2</sub>, ...a<sub>n</sub>, b<sub>n</sub> ]</code></td>
	 * 		</tr>
	 * </table>
	 * <p>
	 * 		Permutation (1-based positions <code>1...2n</code>):<br>
	 * 		<code>p(i) = (2 * i) mod (2n + 1)</code><br>
	 * 		Start indices (cycle leaders):<br>
	 * 		<code>1, 3, 9, 27, ... &lt; 2n</code>
	 * </p>
	 * <br>
	 * Implementation writes forward (destination updates) using carry.
	 */
	private static void cycleLeadersBlock(int[] a, int base, int blockSize)
	{
		int mod = blockSize + 1;
		for (int start = 1; start < blockSize; start *= 3)
		{
			int i = start;
			int carry = a[base + i - 1];
			while (true)
			{
				// destination index (1-based)
				int j = (2 * i) % mod;
				if (j == start)
				{
					a[base + j - 1] = carry;
					break;
				}
				int tmp = a[base + j - 1];
				a[base + j - 1] = carry;
				carry = tmp;
				i = j;
			}
		}
	}

	/**
	 * Rotate adjacent blocks in an array, such that:<br>
	 * <code>block = [A (lenA) | B (lenB)] &rarr; [B | A]</code>
	 *
	 * @param a     The array being processed
	 * @param i     The start index for the block
	 * @param sizeA The length of block A
	 * @param sizeB The length of block B
	 */
	private static void rotateAdjacentBlocks(int[] a, int i, int sizeA, int sizeB)
	{
		if (sizeA == 0 || sizeB == 0)
		{
			return;
		}
		reverse(a, i, i + sizeA - 1);
		reverse(a, i + sizeA, i + sizeA + sizeB - 1);
		reverse(a, i, i + sizeA + sizeB - 1);
	}

	/**
	 * Reverses the elements of the array <code>a</code>,
	 * between the left index <code>l</code>
	 * and right index <code>r</code>.
	 *
	 * @param a The array being processed
	 * @param l The index to begin reversal of elements
	 * @param r The index to end reversal of elements
	 */
	private static void reverse(int[] a, int l, int r)
	{
		for (; l < r; ++l, --r)
		{
			int t = a[l];
			a[l] = a[r];
			a[r] = t;
		}
	}
}
