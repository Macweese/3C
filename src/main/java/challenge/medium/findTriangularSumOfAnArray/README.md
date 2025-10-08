[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2221. Find Triangular Sum of an Array

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2221](https://leetcode.com/problems/find-triangular-sum-of-an-array/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>, where <code>nums[i]</code> is a digit between <code>0</code> and <code>9</code> (<strong>inclusive</strong>).</p><p>The <strong>triangular sum</strong> of <code>nums</code> is the value of the only element present in <code>nums</code> after the following process terminates:</p><ol>
<li>Let <code>nums</code> comprise of <code>n</code> elements. If <code>n == 1</code>, <strong>end</strong> the process. Otherwise, <strong>create</strong> a new <strong>0-indexed</strong> integer array <code>newNums</code> of length <code>n - 1</code>.</li>
<li>For each index <code>i</code>, where <code>0 &lt;= i &lt; n - 1</code>, <strong>assign</strong> the value of <code>newNums[i]</code> as <code>(nums[i] + nums[i+1]) % 10</code>, where <code>%</code> denotes modulo operator.</li>
<li><strong>Replace</strong> the array <code>nums</code> with <code>newNums</code>.</li>
<li><strong>Repeat</strong> the entire process starting from step 1.</li>
</ol><p>Return <em>the triangular sum of</em> <code>nums</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/02/22/ex1drawio.png" style="width: 250px; height: 250px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
8
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The above diagram depicts the process from which we obtain the triangular sum of the array.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Since there is only one element in nums, the triangular sum is the value of that element itself.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>0 &lt;= nums[i] &lt;= 9</code></li>
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
`math`
`simulation`
`combinatorics`
`biweekly contest 75`

---

<details>
  <summary>Hint 1</summary>
  Try simulating the entire process.
</details>
<details>
  <summary>Hint 2</summary>
  To reduce space, use a temporary array to update nums in every step instead of creating a new array at each step.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [119 Pascal&#39;s Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)
* [2243 Calculate Digit Sum of a String](https://leetcode.com/problems/calculate-digit-sum-of-a-string/)
* [2293 Min Max Game](https://leetcode.com/problems/min-max-game/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-09-30, Tue 30 September 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )