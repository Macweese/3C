[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1975. Maximum Matrix Sum

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1975](https://leetcode.com/problems/maximum-matrix-sum/)

## Description

<p>You are given an <code>n x n</code> integer <code>matrix</code>. You can do the following operation <strong>any</strong> number of times:</p><ul>
<li>Choose any two <strong>adjacent</strong> elements of <code>matrix</code> and <strong>multiply</strong> each of them by <code>-1</code>.</li>
</ul><p>Two elements are considered <strong>adjacent</strong> if and only if they share a <strong>border</strong>.</p><p>Your goal is to <strong>maximize</strong> the summation of the matrix's elements. Return <em>the <strong>maximum</strong> sum of the matrix's elements using the operation mentioned above.</em></p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/07/16/pc79-q2ex1.png" style="width: 401px; height: 81px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
matrix = [[1,-1],[-1,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/07/16/pc79-q2ex2.png" style="width: 321px; height: 121px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
16
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == matrix.length == matrix[i].length</code></li>
<li><code>2 &lt;= n &lt;= 250</code></li>
<li><code>-10<sup>5</sup> &lt;= matrix[i][j] &lt;= 10<sup>5</sup></code></li>
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
`greedy`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Try to use the operation so that each row has only one negative number.
</details>
<details>
  <summary>Hint 2</summary>
  If you have only one negative element you cannot convert it to positive.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-01-05, Mon 05 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )