[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1582. Special Positions in a Binary Matrix

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1582](https://leetcode.com/problems/special-positions-in-a-binary-matrix/)

## Description

<p>Given an <code>m x n</code> binary matrix <code>mat</code>, return <em>the number of special positions in </em><code>mat</code><em>.</em></p><p>A position <code>(i, j)</code> is called <strong>special</strong> if <code>mat[i][j] == 1</code> and all other elements in row <code>i</code> and column <code>j</code> are <code>0</code> (rows and columns are <strong>0-indexed</strong>).</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/23/special1.jpg" style="width: 244px; height: 245px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
mat = [[1,0,0],[0,0,1],[1,0,0]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
(1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/special-grid.jpg" style="width: 244px; height: 245px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
mat = [[1,0,0],[0,1,0],[0,0,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
(0, 0), (1, 1) and (2, 2) are special positions.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == mat.length</code></li>
<li><code>n == mat[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 100</code></li>
<li><code>mat[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
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
  Keep track of 1s in each row and in each column. Then while iterating over matrix, if the current position is 1 and current row as well as current column contains exactly one occurrence of 1.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2482 Difference Between Ones and Zeros in Row and Column](https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/)


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