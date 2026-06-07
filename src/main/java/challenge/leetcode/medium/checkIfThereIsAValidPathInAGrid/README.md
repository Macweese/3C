[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1391. Check if There is a Valid Path in a Grid

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1391](https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/)

## Description

<p>You are given an <code>m x n</code> <code>grid</code>. Each cell of <code>grid</code> represents a street. The street of <code>grid[i][j]</code> can be:</p><ul>
<li><code>1</code> which means a street connecting the left cell and the right cell.</li>
<li><code>2</code> which means a street connecting the upper cell and the lower cell.</li>
<li><code>3</code> which means a street connecting the left cell and the lower cell.</li>
<li><code>4</code> which means a street connecting the right cell and the lower cell.</li>
<li><code>5</code> which means a street connecting the left cell and the upper cell.</li>
<li><code>6</code> which means a street connecting the right cell and the upper cell.</li>
</ul><img alt="" src="https://assets.leetcode.com/uploads/2020/03/05/main.png" style="width: 450px; height: 708px;"/><p>You will initially start at the street of the upper-left cell <code>(0, 0)</code>. A valid path in the grid is a path that starts from the upper left cell <code>(0, 0)</code> and ends at the bottom-right cell <code>(m - 1, n - 1)</code>. <strong>The path should only follow the streets</strong>.</p><p><strong>Notice</strong> that you are <strong>not allowed</strong> to change any street.</p><p>Return <code>true</code><em> if there is a valid path in the grid or </em><code>false</code><em> otherwise</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/03/05/e1.png" style="width: 455px; height: 311px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[2,4,3],[6,5,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/03/05/e2.png" style="width: 455px; height: 293px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,2,1],[1,2,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
As shown you the street at cell (0, 0) is not connected with any street of any other cell and you will get stuck at cell (0, 0)
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,1,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == grid.length</code></li>
<li><code>n == grid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 300</code></li>
<li><code>1 &lt;= grid[i][j] &lt;= 6</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`depth-first search`
`breadth-first search`
`union-find`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Start DFS from the node (0, 0) and follow the path till you stop.
</details>
<details>
  <summary>Hint 2</summary>
  When you reach a cell and cannot move anymore check that this cell is (m - 1, n - 1) or not.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2267  Check if There Is a Valid Parentheses String Path](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-27, Mon 27 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )