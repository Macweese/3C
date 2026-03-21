[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1727. Largest Submatrix With Rearrangements

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1727](https://leetcode.com/problems/largest-submatrix-with-rearrangements/)

## Description

<p>You are given a binary matrix <code>matrix</code> of size <code>m x n</code>, and you are allowed to rearrange the <strong>columns</strong> of the <code>matrix</code> in any order.</p><p>Return <em>the area of the largest submatrix within </em><code>matrix</code><em> where <strong>every</strong> element of the submatrix is </em><code>1</code><em> after reordering the columns optimally.</em></p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/12/29/screenshot-2020-12-30-at-40536-pm.png" style="width: 500px; height: 240px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
matrix = [[0,0,1],[1,1,1],[1,0,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/12/29/screenshot-2020-12-30-at-40852-pm.png" style="width: 500px; height: 62px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
matrix = [[1,0,1,0,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
matrix = [[1,1,0],[1,0,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == matrix.length</code></li>
<li><code>n == matrix[i].length</code></li>
<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
<li><code>matrix[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`greedy`
`sorting`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  For each column, find the number of consecutive ones ending at each position.
</details>
<details>
  <summary>Hint 2</summary>
  For each row, sort the cumulative ones in non-increasing order and &#34;fit&#34; the largest submatrix.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [695 Max Area of Island](https://leetcode.com/problems/max-area-of-island/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-17, Tue 17 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )