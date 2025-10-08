# 1935. Maximum Number of Words You Can Type

---

## Problem

The problem requests that, given an array `a` of size `2n`.  
Interleave the elements of `a` such that:

$$  
a = ( \ a_1, \ a_2, \ a_3, \ a_4, \ a_5, \ a_6, \ a_7, \ a_8, \ ... \ a_{2n} \ )  
$$

Yields the permutation

$$  
a' = ( \ a_1, \ a_{n+1}, \ a_2, \ a_{n+2}, \ a_3, \ a_{n+3}, \ a_4, \ a_{n+4}, \ ...
\ a_{2n} \ )  
$$

Mathematically expressed it is the following:

$$  
a' = (\ a_{\sigma(1)},\ a_{\sigma(2)},\ ,\ a_{\sigma(3)},\ a_{\sigma(4)}, ... \ a_{\sigma(2n)} \ )  
$$

$$  
a'=  
\begin{pmatrix} 1 & 2 & 3 & 4 & \cdots & 2n-1 & 2n\\  
1 & n+1 & 2 & n+2 & \cdots & n & 2n \end{pmatrix}  
$$

Using the map

$$  
k \mapsto \begin{cases}  
\frac{k+1}{2} & k \equiv 1 \pmod{2}\\  
n+\frac{k}{2} & k \equiv 0 \pmod{2}  
\end{cases}  
$$

This method of rearrangement is called
a [perfect shuffle (Wikipedia)](https://en.wikipedia.org/wiki/Faro_shuffle#Group_theory_aspects). In this case,
specifically it is a *perfect out-shuffle*, as the interleaving is behind the first segment.

It is sometimes also called a Faro-shuffle.

---

<br>
<br> Solution – 1935 Maximum Number of Words You Can Type  

## Intuition: Conceiving a challenge

### Naïve challenge

The most obvious challenge is to create a new array, and iterate through the first $ n $ elements, placing the element at
index $ k $ at $ 2k $. Then, for the 2<sup>nd</sup> half (elements of index $ n ... 2n $) of the input array, place
elements of index $ k $ at $ 2k - n + 1 $.

This naïve approach runs in $ O(n) $ time, and uses $ O(n) $ space.
Which is perfectly fine — it works, passes tests and meets all requirements. However, after thinking about it a little
longer, I felt that there may be a way to improve the memory performance.

### Optimal challenge

In attempting to find a challenge that optimizes the space complexity to less than $ O(n) $, a crude algorithm was
drafted from the pattern of the interleaving index mapping:

$$  
a(k) \mapsto \begin{cases}  
2k & \text{for} \ 1 \le k \le n\\  
2k - (2n - 1) & \text{for} \ 2n + 1 \le k \le 2n  
\end{cases}  
$$

<details>
  <summary><b>Visualizing the algorithm</b></summary>

<br>

Given the array of elements `[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]`.  
Starting the permuting algorithm at index `n = 6`:

![leetcode_scratch_1470_perfect_shuffle_segment.png](https://assets.leetcode.com/users/images/7660d4d4-b9eb-4e2a-a790-1445e09949ed_1757879868.812426.png)

</details>

<br>

The finding that it *could* be done, was good enough to continue pursuing a complete challenge that considers all $ n $
values.

**New problem:**  
This optimized approach spawned a new problem:  
Starting from $ i = n $ only suffices if the nontrivial part of the permutation forms a single cycle. That happens
when $ 2 $ is a primitive root modulo ($ 2n - 1 $). Often it is not.

Example $ n = 5 $ shows two cycles.  
$ \text{Cycle } 1: 1 → 2 → 4 → 8 → 7 → 5 → 1 $  
$ \text{Cycle } 2: 3 → 6 → 3 $

Therefore, we must either:  
&emsp;• &emsp;Try every index that isn’t yet visited (marking somehow. This would break our goal of improving space
complexity, permuting in-place and $ O(1) $ memory), or  
&emsp;• &emsp;Use known segment structures.

The 2<sup>nd</sup> option means using Huang–Langston method: process blocks of size $ 3^k - 1 $ and cycle-lead only
powers of $ 3 $.

[DOI: Huang–Langston: Practical In-Place Merging (1988)](https://doi.org/10.1145/42392.42403)  
[PDF: Huang–Langston: Practical In-Place Merging (1988)](https://dl.acm.org/doi/pdf/10.1145/42392.42403)


---

## Approach

Using the hypothesized optimal challenge, it was clear that the algorithm works if we segment the array and cycle each
segment.

Thus, we implement segmenting and process the respective segment.

<details>
  <summary><b>Visual Demo</b></summary>

```log
 Input: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]

 Cycle:
     1: [1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1]
     2: [1,1,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1]
     3: [1,1,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1]
     4: [1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1]
     5: [1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1]
     6: [1,1,1,1,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1]
     7: [1,1,1,1,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,1,1]
     8: [1,1,1,1,0,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,1,1]
     9: [1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,1,1]
    10: [0,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,1,1]
    21: [0,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1]
    22: [0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,1,1]
    23: [0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,1,1]
    24: [0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,0,1,1]
    25: [0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1]
    26: [0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1]
    27: [0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1]

Output: [0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1]

  Size: 32
Cycles: 27
```

</details>


---

## Complexity

### Time complexity: $ O(n) $

<b>Inner calls </b>
$$
\begin{flalign} &
\text{blockSize} \stackrel{\text{def}}{=} 3^k - 1
& \end{flalign}
$$
• Computing the block size takes $ O(\log(2n)) $ steps per iteration  
• Rotating, reversing calls and cycling blocks $ O(\text{blockSize}) $  
$ \text{Inner} \therefore O(\log(2n)) + O(\text{blockSize}) = O(\text{blockSize}) $

<b>Outer calls</b>  
• Processing each segment is $ O(\log_{\frac{3}{2}}n) = O(\log n) $

Total time for rotations and cycles:  
$ O(\Sigma \text{ blockSize}) = O(n) $

Total time for block size computations:  
$ O(\log n) \times O(\log n) = O((\log n)^2) $

Total overall time complexity = $ O(n) + O((\log n)^2) = O(n)$

### Space complexity: $ O(1) $

Constant space.  
Only uses temporary variables, performing the permutation of the array entirely in-place.

---

## Code

```java
class Solution
{
	public int[] shuffle(int[] a, int n)
	{
		if (n < 2)
		{
			return a;
		}

		processSegment(a, 0, 2 * n);
		return a;
	}

	private void processSegment(int[] a, int start, int length)
	{
		while (length > 0)
		{
			int m = length / 2;
			if (m <= 1)
			{
				return;
			}

			int blockSize = 3;
			while (blockSize - 1 <= 2 * m)
			{
				blockSize *= 3;
			}
			blockSize /= 3;
			int size = blockSize - 1;
			int n = size / 2;
			int i = start;
			int r = m - n;

			rotateAdjacentBlocks(a, i, n + r, n);
			cycleLeadersBlock(a, start, size);

			start += size;
			length -= size;
		}
	}

	private void cycleLeadersBlock(int[] a, int base, int blockSize)
	{
		int mod = blockSize + 1;
		for (int start = 1; start < blockSize; start *= 3)
		{
			int i = start;
			int carry = a[base + i - 1];
			while (true)
			{
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

	private void rotateAdjacentBlocks(int[] a, int i, int sizeA, int sizeB)
	{
		if (sizeA == 0 || sizeB == 0)
		{
			return;
		}
		reverse(a, i, i + sizeA - 1);
		reverse(a, i + sizeA, i + sizeA + sizeB - 1);
		reverse(a, i, i + sizeA + sizeB - 1);
	}

	private void reverse(int[] ints, int l, int r)
	{
		for (; l < r; ++l, --r)
		{
			int t = ints[l];
			ints[l] = ints[r];
			ints[r] = t;
		}
	}
}
```

<br>
Code with explaining comments:

```java
class Solution
{
	/**
	 * Performs perfect (out-)shuffle,
	 * in-place with constant-space in linear time,
	 * using Huang-Langston algorithm.
	 *
	 * @param a The array to shuffle
	 * @return  The shuffled array
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
			// A1...An | A_{n+1}...A_m | B1...Bn | B_{n+1}...B_m
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
			// A_1 B_1 A_2 B_2 ... A_n B_n  A_{n+1}...A_m  B_{n+1}...B_m
			// Suffix is again in canonical form A' B' with size 2(m - n).
			start += size;
			length -= size;
		}
	}

	/**
	 * Cycle-leader permutation on block of size <code>blockSize = 2n</code> at base.
	 * <table border="5">
	 * 	<tr>
	 * 		<td text-align: right;>Block currently:</td>
	 * 		<td text-align: left;>&emsp;<code>[a<sub>1</sub>, a<sub>2</sub>, ..a<sub>n</sub>, b<sub>1</sub>, b<sub>2</sub>, ..b<sub>n</sub>]</code></td>
	 * 	</tr>
	 * 	<tr>
	 * 		<td text-align: right;>We want:</td>
	 * 		<td text-align: left;>&emsp;<code>[a<sub>1</sub>, b<sub>1</sub>, a<sub>2</sub>, b<sub>2</sub>, ...a<sub>n</sub>, b<sub>n</sub> ]</code></td>
	 * 	</tr>
	 * </table>
	 * <p>
	 * 	Permutation (1-based positions <code>1...2n</code>):<br>
	 * 	<code>p(i) = (2 * i) mod (2n + 1)</code><br>
	 * 	Start indices (cycle leaders):<br>
	 * 	<code>1, 3, 9, 27, ... &lt; 2n</code>
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
	 * @param a     The array being processed
	 * @param l     The index to begin reversal of elements
	 * @param r     The index to end reversal of elements
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
```

---
![image.png](https://assets.leetcode.com/users/images/b0d9625e-9d21-4afc-8ba6-1aac627d0b1c_1757890768.0655541.png)
