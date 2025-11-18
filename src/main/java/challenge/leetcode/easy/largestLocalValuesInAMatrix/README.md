[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2373. Largest Local Values in a Matrix

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2373](https://leetcode.com/problems/largest-local-values-in-a-matrix/)

## Description

<p>You are given an <code>n x n</code> integer matrix <code>grid</code>.</p><p>Generate an integer matrix <code>maxLocal</code> of size <code>(n - 2) x (n - 2)</code> such that:</p><ul>
<li><code>maxLocal[i][j]</code> is equal to the <strong>largest</strong> value of the <code>3 x 3</code> matrix in <code>grid</code> centered around row <code>i + 1</code> and column <code>j + 1</code>.</li>
</ul><p>In other words, we want to find the largest value in every contiguous <code>3 x 3</code> matrix in <code>grid</code>.</p><p>Return <em>the generated matrix</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/06/21/ex1.png" style="width: 371px; height: 210px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[[9,9],[8,6]]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The diagram above shows the original matrix and the generated matrix.
Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/07/02/ex2new2.png" style="width: 436px; height: 240px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[[2,2,2],[2,2,2],[2,2,2]]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == grid.length == grid[i].length</code></li>
<li><code>3 &lt;= n &lt;= 100</code></li>
<li><code>1 &lt;= grid[i][j] &lt;= 100</code></li>
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
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use nested loops to run through all possible 3 x 3 windows in the matrix.
</details>
<details>
  <summary>Hint 2</summary>
  For each 3 x 3 window, iterate through the values to get the maximum value within the window.
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


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )