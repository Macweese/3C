[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2044. Count Number of Maximum Bitwise-OR Subsets

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2044](https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/)

## Description

<p>Given an integer array <code>nums</code>, find the <strong>maximum</strong> possible <strong>bitwise OR</strong> of a subset of <code>nums</code> and return <em>the <strong>number of different non-empty subsets</strong> with the maximum bitwise OR</em>.</p><p>An array <code>a</code> is a <strong>subset</strong> of an array <code>b</code> if <code>a</code> can be obtained from <code>b</code> by deleting some (possibly zero) elements of <code>b</code>. Two subsets are considered <strong>different</strong> if the indices of the elements chosen are different.</p><p>The bitwise OR of an array <code>a</code> is equal to <code>a[0] <strong>OR</strong> a[1] <strong>OR</strong> ... <strong>OR</strong> a[a.length - 1]</code> (<strong>0-indexed</strong>).</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [2,2,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 2<sup>3</sup> - 1 = 7 total subsets.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,2,1,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [2,5]
- [2,1,5]
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 16</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
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
`backtracking`
`bit manipulation`
`enumeration`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Can we enumerate all possible subsets?
</details>
<details>
  <summary>Hint 2</summary>
  The maximum bitwise-OR is the bitwise-OR of the whole array.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [78 Subsets](https://leetcode.com/problems/subsets/)
* [2275 Largest Combination With Bitwise AND Greater Than Zero](https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/)
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