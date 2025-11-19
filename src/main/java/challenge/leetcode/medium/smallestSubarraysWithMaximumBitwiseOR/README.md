[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2411. Smallest Subarrays With Maximum Bitwise OR

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2411](https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/)

## Description

<p>You are given a <strong>0-indexed</strong> array <code>nums</code> of length <code>n</code>, consisting of non-negative integers. For each index <code>i</code> from <code>0</code> to <code>n - 1</code>, you must determine the size of the <strong>minimum sized</strong> non-empty subarray of <code>nums</code> starting at <code>i</code> (<strong>inclusive</strong>) that has the <strong>maximum</strong> possible <strong>bitwise OR</strong>.</p><ul>
<li>In other words, let <code>B<sub>ij</sub></code> be the bitwise OR of the subarray <code>nums[i...j]</code>. You need to find the smallest subarray starting at <code>i</code>, such that bitwise OR of this subarray is equal to <code>max(B<sub>ik</sub>)</code> where <code>i &lt;= k &lt;= n - 1</code>.</li>
</ul><p>The bitwise OR of an array is the bitwise OR of all the numbers in it.</p><p>Return <em>an integer array </em><code>answer</code><em> of size </em><code>n</code><em> where </em><code>answer[i]</code><em> is the length of the <strong>minimum</strong> sized subarray starting at </em><code>i</code><em> with <strong>maximum</strong> bitwise OR.</em></p><p>A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,0,2,1,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[3,3,2,2,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The maximum possible bitwise OR starting at any index is 3. 
- Starting at index 0, the shortest subarray that yields it is [1,0,2].
- Starting at index 1, the shortest subarray that yields the maximum bitwise OR is [0,2,1].
- Starting at index 2, the shortest subarray that yields the maximum bitwise OR is [2,1].
- Starting at index 3, the shortest subarray that yields the maximum bitwise OR is [1,3].
- Starting at index 4, the shortest subarray that yields the maximum bitwise OR is [3].
Therefore, we return [3,3,2,2,1].
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[2,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Starting at index 0, the shortest subarray that yields the maximum bitwise OR is of length 2.
Starting at index 1, the shortest subarray that yields the maximum bitwise OR is of length 1.
Therefore, we return [2,1].
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == nums.length</code></li>
<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<br>

## Solution

### Intuition

<!-- Optional: add your own thoughts after reading the description -->

### Approach

<!-- Optional: sketch your plan -->

### Complexity analysis

#### Time Complexity

<!-- e.g., O(n log n) -->

#### Space Complexity

<!-- e.g., O(n) -->

---

### Code

```
// AC here
```

---

<br>

#### Tags

`array`
`binary search`
`bit manipulation`
`sliding window`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Consider trying to solve the problem for each bit position separately.
</details>
<details>
  <summary>Hint 2</summary>
  For each bit position, find the position of the next number that has a 1 in that position, if any.
</details>
<details>
  <summary>Hint 3</summary>
  Take the maximum distance to such a number, including the current number.
</details>
<details>
  <summary>Hint 4</summary>
  Iterate backwards to achieve a linear complexity.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [23 Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
* [898 Bitwise ORs of Subarrays](https://leetcode.com/problems/bitwise-ors-of-subarrays/)
* [2419 Longest Subarray With Maximum Bitwise AND](https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )