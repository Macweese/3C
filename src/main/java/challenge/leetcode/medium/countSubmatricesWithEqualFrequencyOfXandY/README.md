[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3212. Count Submatrices With Equal Frequency of X and Y

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3212](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/)

## Description

<p>Given a 2D character matrix <code>grid</code>, where <code>grid[i][j]</code> is either <code>'X'</code>, <code>'Y'</code>, or <code>'.'</code>, return the number of <span data-keyword="submatrix">submatrices</span> that contain:</p><ul>
<li><code>grid[0][0]</code></li>
<li>an <strong>equal</strong> frequency of <code>'X'</code> and <code>'Y'</code>.</li>
<li><strong>at least</strong> one <code>'X'</code>.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/06/07/examplems.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 175px; height: 350px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [["X","Y","."],["Y",".","."]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/06/07/examplems.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 175px; height: 350px;"/></strong></p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [["X","X"],["X","Y"]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>No submatrix has an equal frequency of <code>'X'</code> and <code>'Y'</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[".","."],[".","."]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>No submatrix has at least one <code>'X'</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= grid.length, grid[i].length &lt;= 1000</code></li>
<li><code>grid[i][j]</code> is either <code>'X'</code>, <code>'Y'</code>, or <code>'.'</code>.</li>
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
  Replace &lt;code&gt;’X’&lt;/code&gt; with 1, &lt;code&gt;’Y’&lt;/code&gt; with -1 and &lt;code&gt;’.’&lt;/code&gt; with 0.
</details>
<details>
  <summary>Hint 2</summary>
  You need to find how many submatrices &lt;code&gt;grid[0..x][0..y]&lt;/code&gt; have a sum of 0 and at least one &lt;code&gt;’X’&lt;/code&gt;.
</details>
<details>
  <summary>Hint 3</summary>
  Use prefix sum to calculate submatrices sum.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1224 Maximum Equal Frequency](https://leetcode.com/problems/maximum-equal-frequency/)
* [1504 Count Submatrices With All Ones](https://leetcode.com/problems/count-submatrices-with-all-ones/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-19, Thu 19 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )