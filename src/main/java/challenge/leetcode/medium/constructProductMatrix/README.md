[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2906. Construct Product Matrix

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2906](https://leetcode.com/problems/construct-product-matrix/)

## Description

<p>Given a <strong>0-indexed</strong> 2D integer matrix <code><font face="monospace">grid</font></code><font face="monospace"> </font>of size <code>n * m</code>, we define a <strong>0-indexed</strong> 2D matrix <code>p</code> of size <code>n * m</code> as the <strong>product</strong> matrix of <code>grid</code> if the following condition is met:</p><ul>
<li>Each element <code>p[i][j]</code> is calculated as the product of all elements in <code>grid</code> except for the element <code>grid[i][j]</code>. This product is then taken modulo <code><font face="monospace">12345</font></code>.</li>
</ul><p>Return <em>the product matrix of</em> <code><font face="monospace">grid</font></code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,2],[3,4]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[[24,12],[8,6]]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
p[0][0] = grid[0][1] * grid[1][0] * grid[1][1] = 2 * 3 * 4 = 24
p[0][1] = grid[0][0] * grid[1][0] * grid[1][1] = 1 * 3 * 4 = 12
p[1][0] = grid[0][0] * grid[0][1] * grid[1][1] = 1 * 2 * 4 = 8
p[1][1] = grid[0][0] * grid[0][1] * grid[1][0] = 1 * 2 * 3 = 6
So the answer is [[24,12],[8,6]].
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[12345],[2],[1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[[2],[0],[0]]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
p[0][0] = grid[0][1] * grid[0][2] = 2 * 1 = 2.
p[0][1] = grid[0][0] * grid[0][2] = 12345 * 1 = 12345. 12345 % 12345 = 0. So p[0][1] = 0.
p[0][2] = grid[0][0] * grid[0][1] = 12345 * 2 = 24690. 24690 % 12345 = 0. So p[0][2] = 0.
So the answer is [[2],[0],[0]].
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == grid.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= m == grid[i].length &lt;= 10<sup>5</sup></code></li>
<li><code>2 &lt;= n * m &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>9</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`matrix`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Try to solve this without using the &lt;code&gt;&#39;/&#39;&lt;/code&gt; (division operation).
</details>
<details>
  <summary>Hint 2</summary>
  Create two 2D arrays for &lt;b&gt;suffix&lt;/b&gt; and &lt;b&gt;prefix&lt;/b&gt; product, and use them to find the product for each position.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [238 Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-24, Tue 24 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )