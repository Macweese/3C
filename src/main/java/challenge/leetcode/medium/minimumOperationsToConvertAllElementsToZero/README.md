[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3542. Minimum Operations to Convert All Elements to Zero

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3542](https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/)

## Description

<p>You are given an array <code>nums</code> of size <code>n</code>, consisting of <strong>non-negative</strong> integers. Your task is to apply some (possibly zero) operations on the array so that <strong>all</strong> elements become 0.</p><p>In one operation, you can select a <span data-keyword="subarray">subarray</span> <code>[i, j]</code> (where <code>0 &lt;= i &lt;= j &lt; n</code>) and set all occurrences of the <strong>minimum</strong> <strong>non-negative</strong> integer in that subarray to 0.</p><p>Return the <strong>minimum</strong> number of operations required to make all elements in the array 0.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [0,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Select the subarray <code>[1,1]</code> (which is <code>[2]</code>), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in <code>[0,0]</code>.</li>
<li>Thus, the minimum number of operations required is 1.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [3,1,2,1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Select subarray <code>[1,3]</code> (which is <code>[1,2,1]</code>), where the minimum non-negative integer is 1. Setting all occurrences of 1 to 0 results in <code>[3,0,2,0]</code>.</li>
<li>Select subarray <code>[2,2]</code> (which is <code>[2]</code>), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in <code>[3,0,0,0]</code>.</li>
<li>Select subarray <code>[0,0]</code> (which is <code>[3]</code>), where the minimum non-negative integer is 3. Setting all occurrences of 3 to 0 results in <code>[0,0,0,0]</code>.</li>
<li>Thus, the minimum number of operations required is 3.</li>
</ul>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,1,2,1,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">4</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Select subarray <code>[0,5]</code> (which is <code>[1,2,1,2,1,2]</code>), where the minimum non-negative integer is 1. Setting all occurrences of 1 to 0 results in <code>[0,2,0,2,0,2]</code>.</li>
<li>Select subarray <code>[1,1]</code> (which is <code>[2]</code>), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in <code>[0,0,0,2,0,2]</code>.</li>
<li>Select subarray <code>[3,3]</code> (which is <code>[2]</code>), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in <code>[0,0,0,0,0,2]</code>.</li>
<li>Select subarray <code>[5,5]</code> (which is <code>[2]</code>), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in <code>[0,0,0,0,0,0]</code>.</li>
<li>Thus, the minimum number of operations required is 4.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
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
`stack`
`greedy`
`monotonic stack`


---

<details>
  <summary>Hint 1</summary>
  Process the values in nums from smallest to largest (excluding 0).
</details>
<details>
  <summary>Hint 2</summary>
  For each target value v, identify its maximal contiguous segments (subarrays where nums[i] == v); each segment can be zeroed out in one operation.
</details>
<details>
  <summary>Hint 3</summary>
  After setting those segments to zero, dynamically update the remaining array and repeat with the next value.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-10, Mon 10 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )