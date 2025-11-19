[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 898. Bitwise ORs of Subarrays

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 898](https://leetcode.com/problems/bitwise-ors-of-subarrays/)

## Description

<p>Given an integer array <code>arr</code>, return <em>the number of distinct bitwise ORs of all the non-empty subarrays of</em> <code>arr</code>.</p><p>The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.</p><p>A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [0]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There is only one possible result: 0.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [1,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [1,2,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The possible results are 1, 2, 3, 4, 6, and 7.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>0 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
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
`dynamic programming`
`bit manipulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Consider the the subarrays that end at index &lt;code&gt;i&lt;/code&gt;. The number of unique bitwise OR for these subarrays is limited.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2401 Longest Nice Subarray](https://leetcode.com/problems/longest-nice-subarray/)
* [2411 Smallest Subarrays With Maximum Bitwise OR](https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/)
* [2505 Bitwise OR of All Subsequence Sums](https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums/)
* [3287 Find the Maximum Sequence Value of Array](https://leetcode.com/problems/find-the-maximum-sequence-value-of-array/)


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