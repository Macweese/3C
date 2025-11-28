[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3381. Maximum Subarray Sum With Length Divisible by K

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3381](https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/)

## Description

<p>You are given an array of integers <code>nums</code> and an integer <code>k</code>.</p><p>Return the <strong>maximum</strong> sum of a <span data-keyword="subarray-nonempty">subarray</span> of <code>nums</code>, such that the size of the subarray is <strong>divisible</strong> by <code>k</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2], k = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The subarray <code>[1, 2]</code> with sum 3 has length equal to 2 which is divisible by 1.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [-1,-2,-3,-4,-5], k = 4</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">-10</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The maximum sum subarray is <code>[-1, -2, -3, -4]</code> which has length equal to 4 which is divisible by 4.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [-5,1,2,-3,4], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">4</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The maximum sum subarray is <code>[1, 2, -3, 4]</code> which has length equal to 4 which is divisible by 2.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= k &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
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
`hash table`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Maintain minimum prefix sum ending at every possible &lt;code&gt;index%k&lt;/code&gt;.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [974 Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-11-27, Thu 27 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )