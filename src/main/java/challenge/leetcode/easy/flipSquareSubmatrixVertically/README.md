[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3643. Flip Square Submatrix Vertically

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3643](https://leetcode.com/problems/flip-square-submatrix-vertically/)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>grid</code>, and three integers <code>x</code>, <code>y</code>, and <code>k</code>.</p><p>The integers <code>x</code> and <code>y</code> represent the row and column indices of the <strong>top-left</strong> corner of a <strong>square</strong> submatrix and the integer <code>k</code> represents the size (side length) of the square submatrix.</p><p>Your task is to flip the submatrix by reversing the order of its rows vertically.</p><p>Return the updated matrix.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = </span>[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]<span class="example-io">, x = 1, y = 0, k = 3</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The diagram above shows the grid before and after the transformation.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[[3,4,4,2],[2,3,2,3]]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The diagram above shows the grid before and after the transformation.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == grid.length</code></li>
<li><code>n == grid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 50</code></li>
<li><code>1 &lt;= grid[i][j] &lt;= 100</code></li>
<li><code>0 &lt;= x &lt; m</code></li>
<li><code>0 &lt;= y &lt; n</code></li>
<li><code>1 &lt;= k &lt;= min(m - x, n - y)</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`two pointers`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use two pointers at the block&#39;s top and bottom rows and swap their &lt;code&gt;k&lt;/code&gt; columns pairwise until the pointers meet.
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

`2026-03-21, Sat 21 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )