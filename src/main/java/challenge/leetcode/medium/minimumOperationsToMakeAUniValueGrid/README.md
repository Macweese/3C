[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2033. Minimum Operations to Make a Uni-Value Grid

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2033](https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/)

## Description

<p>You are given a 2D integer <code>grid</code> of size <code>m x n</code> and an integer <code>x</code>. In one operation, you can <strong>add</strong> <code>x</code> to or <strong>subtract</strong> <code>x</code> from any element in the <code>grid</code>.</p><p>A <strong>uni-value grid</strong> is a grid where all the elements of it are equal.</p><p>Return <em>the <strong>minimum</strong> number of operations to make the grid <strong>uni-value</strong></em>. If it is not possible, return <code>-1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/gridtxt.png" style="width: 164px; height: 165px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[2,4],[6,8]], x = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can make every element equal to 4 by doing the following: 
- Add x to 2 once.
- Subtract x from 6 once.
- Subtract x from 8 twice.
A total of 4 operations were used.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/gridtxt-1.png" style="width: 164px; height: 165px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,5],[2,3]], x = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can make every element equal to 3.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/gridtxt-2.png" style="width: 164px; height: 165px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[1,2],[3,4]], x = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is impossible to make every element equal.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == grid.length</code></li>
<li><code>n == grid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= x, grid[i][j] &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`math`
`sorting`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Is it possible to make two integers a and b equal if they have different remainders dividing by x?
</details>
<details>
  <summary>Hint 2</summary>
  If it is possible, which number should you select to minimize the number of operations?
</details>
<details>
  <summary>Hint 3</summary>
  What if the elements are sorted?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [462 Minimum Moves to Equal Array Elements II](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-28, Tue 28 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )