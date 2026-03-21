[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3567. Minimum Absolute Difference in Sliding Submatrix

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3567](https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>grid</code> and an integer <code>k</code>.</p><p>For every contiguous <code>k x k</code> <strong>submatrix</strong> of <code>grid</code>, compute the <strong>minimum absolute</strong> difference between any two <strong>distinct</strong> values within that <strong>submatrix</strong>.</p><p>Return a 2D array <code>ans</code> of size <code>(m - k + 1) x (n - k + 1)</code>, where <code>ans[i][j]</code> is the minimum absolute difference in the submatrix whose top-left corner is <code>(i, j)</code> in <code>grid</code>.</p><p><strong>Note</strong>: If all elements in the submatrix have the same value, the answer will be 0.</p><code>(x1, y1, x2, y2)</code><code>matrix[x][y]</code><code>x1 &lt;= x &lt;= x2</code><code>y1 &lt;= y &lt;= y2</code>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,8],[3,-2]], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[[2]]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>There is only one possible <code>k x k</code> submatrix: <code><span class="example-io">[[1, 8], [3, -2]]</span></code><span class="example-io">.</span></li>
<li>Distinct values in the submatrix are<span class="example-io"> <code>[1, 8, 3, -2]</code>.</span></li>
<li>The minimum absolute difference in the submatrix is <code>|1 - 3| = 2</code>. Thus, the answer is <code>[[2]]</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[3,-1]], k = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[[0,0]]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Both <code>k x k</code> submatrix has only one distinct element.</li>
<li>Thus, the answer is <code>[[0, 0]]</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,-2,3],[2,3,5]], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[[1,2]]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>There are two possible <code>k × k</code> submatrix:

	<ul>
<li>Starting at <code>(0, 0)</code>: <code>[[1, -2], [2, 3]]</code>.

		<ul>
<li>Distinct values in the submatrix are <code>[1, -2, 2, 3]</code>.</li>
<li>The minimum absolute difference in the submatrix is <code>|1 - 2| = 1</code>.</li>
</ul>
</li>
<li>Starting at <code>(0, 1)</code>: <code>[[-2, 3], [3, 5]]</code>.
		<ul>
<li>Distinct values in the submatrix are <code>[-2, 3, 5]</code>.</li>
<li>The minimum absolute difference in the submatrix is <code>|3 - 5| = 2</code>.</li>
</ul>
</li>
</ul>
</li>
<li>Thus, the answer is <code>[[1, 2]]</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= m == grid.length &lt;= 30</code></li>
<li><code>1 &lt;= n == grid[i].length &lt;= 30</code></li>
<li><code>-10<sup>5</sup> &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= k &lt;= min(m, n)</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`sorting`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use bruteforce over the submatrices
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

`2026-03-20, Fri 20 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )