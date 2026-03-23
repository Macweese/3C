[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1594. Maximum Non Negative Product in a Matrix

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1594](https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/)

## Description

<p>You are given a <code>m x n</code> matrix <code>grid</code>. Initially, you are located at the top-left corner <code>(0, 0)</code>, and in each step, you can only <strong>move right or down</strong> in the matrix.</p><p>Among all possible paths starting from the top-left corner <code>(0, 0)</code> and ending in the bottom-right corner <code>(m - 1, n - 1)</code>, find the path with the <strong>maximum non-negative product</strong>. The product of a path is the product of all integers in the grid cells visited along the path.</p><p>Return the <em>maximum non-negative product <strong>modulo</strong> </em><code>10<sup>9</sup> + 7</code>. <em>If the maximum product is <strong>negative</strong>, return </em><code>-1</code>.</p><p>Notice that the modulo is performed after getting the maximum product.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/23/product1.jpg" style="width: 244px; height: 245px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/23/product2.jpg" style="width: 244px; height: 245px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
8
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/23/product3.jpg" style="width: 164px; height: 165px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,3],[0,-4]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Maximum non-negative product is shown (1 * 0 * -4 = 0).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == grid.length</code></li>
<li><code>n == grid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 15</code></li>
<li><code>-4 &lt;= grid[i][j] &lt;= 4</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`dynamic programming`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use Dynamic programming. Keep the highest value and lowest value you can achieve up to a point.
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

`2026-03-23, Mon 23 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )