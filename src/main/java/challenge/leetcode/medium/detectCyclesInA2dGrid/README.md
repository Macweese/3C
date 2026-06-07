[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1559. Detect Cycles in 2D Grid

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1559](https://leetcode.com/problems/detect-cycles-in-2d-grid/)

## Description

<p>Given a 2D array of characters <code>grid</code> of size <code>m x n</code>, you need to find if there exists any cycle consisting of the <strong>same value</strong> in <code>grid</code>.</p><p>A cycle is a path of <strong>length 4 or more</strong> in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the <strong>same value</strong> of the current cell.</p><p>Also, you cannot move to the cell that you visited in your last move. For example, the cycle <code>(1, 1) -&gt; (1, 2) -&gt; (1, 1)</code> is invalid because from <code>(1, 2)</code> we visited <code>(1, 1)</code> which was the last visited cell.</p><p>Return <code>true</code> if any cycle of the same value exists in <code>grid</code>, otherwise, return <code>false</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == grid.length</code></li>
<li><code>n == grid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 500</code></li>
<li><code>grid</code> consists only of lowercase English letters.</li>
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
  Keep track of the parent (previous position) to avoid considering an invalid path.
</details>
<details>
  <summary>Hint 2</summary>
  Use DFS or BFS and keep track of visited cells to see if there is a cycle.
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

`2026-04-26, Sun 26 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )