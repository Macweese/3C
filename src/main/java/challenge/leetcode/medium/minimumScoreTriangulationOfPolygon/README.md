[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1039. Minimum Score Triangulation of Polygon

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1039](https://leetcode.com/problems/minimum-score-triangulation-of-polygon/)

## Description

<p>You have a convex <code>n</code>-sided polygon where each vertex has an integer value. You are given an integer array <code>values</code> where <code>values[i]</code> is the value of the <code>i<sup>th</sup></code> vertex in <strong>clockwise order</strong>.</p><p><strong>Polygon</strong> <strong>triangulation</strong> is a process where you divide a polygon into a set of triangles and the vertices of each triangle must also be vertices of the original polygon. Note that no other shapes other than triangles are allowed in the division. This process will result in <code>n - 2</code> triangles.</p><p>You will <strong>triangulate</strong> the polygon. For each triangle, the <em>weight</em> of that triangle is the product of the values at its vertices. The total score of the triangulation is the sum of these <em>weights</em> over all <code>n - 2</code> triangles.</p><p>Return the<em> minimum possible score </em>that you can achieve with some<em> </em><strong>triangulation</strong><em> </em>of the polygon.</p>

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
<li><code>n == values.length</code></li>
<li><code>3 &lt;= n &lt;= 50</code></li>
<li><code>1 &lt;= values[i] &lt;= 100</code></li>
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
`dynamic programming`


---

<details>
  <summary>Hint 1</summary>
  Without loss of generality, there is a triangle that uses adjacent vertices A[0] and A[N-1] (where N = A.length).  Depending on your choice K of it, this breaks down the triangulation into two subproblems A[1:K] and A[K+1:N-1].
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-09-29, Mon 29 September 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )