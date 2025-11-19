[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2419. Longest Subarray With Maximum Bitwise AND

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2419](https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/)

## Description

<p>You are given an integer array <code>nums</code> of size <code>n</code>.</p><p>Consider a <strong>non-empty</strong> subarray from <code>nums</code> that has the <strong>maximum</strong> possible <strong>bitwise AND</strong>.</p><ul>
<li>In other words, let <code>k</code> be the maximum value of the bitwise AND of <strong>any</strong> subarray of <code>nums</code>. Then, only subarrays with a bitwise AND equal to <code>k</code> should be considered.</li>
</ul><p>Return <em>the length of the <strong>longest</strong> such subarray</em>.</p><p>The bitwise AND of an array is the bitwise AND of all the numbers in it.</p><p>A <strong>subarray</strong> is a contiguous sequence of elements within an array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,3,2,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
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
`bit manipulation`
`brainteaser`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Notice that the bitwise AND of two different numbers will always be strictly less than the maximum of those two numbers.
</details>
<details>
  <summary>Hint 2</summary>
  What does that tell us about the nature of the subarray that we should choose?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1805 Number of Different Integers in a String](https://leetcode.com/problems/number-of-different-integers-in-a-string/)
* [2038 Remove Colored Pieces if Both Neighbors are the Same Color](https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/)
* [2044 Count Number of Maximum Bitwise-OR Subsets](https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/)
* [2411 Smallest Subarrays With Maximum Bitwise OR](https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/)


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