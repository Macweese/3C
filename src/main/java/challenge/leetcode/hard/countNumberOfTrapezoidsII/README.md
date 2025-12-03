[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3625. Count Number of Trapezoids II

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3625](https://leetcode.com/problems/count-number-of-trapezoids-ii/)

## Description

<p data-end="189" data-start="146">You are given a 2D integer array <code>points</code> where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> represents the coordinates of the <code>i<sup>th</sup></code> point on the Cartesian plane.</p><p data-end="189" data-start="146">Return <em data-end="330" data-start="297">the number of unique </em><em>trapezoids</em> that can be formed by choosing any four distinct points from <code>points</code>.</p><p data-end="579" data-start="405">A<b> </b><strong>trapezoid</strong> is a convex quadrilateral with <strong data-end="496" data-start="475">at least one pair</strong> of parallel sides. Two lines are parallel if and only if they have the same slope.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-4.png" style="width: 250px; height: 250px;"/>

<img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-3.png" style="width: 250px; height: 250px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">points = [[-3,2],[3,0],[2,3],[3,2],[2,-3]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-4.png" style="width: 250px; height: 250px;"/> <img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-3.png" style="width: 250px; height: 250px;"/></p><p>There are two distinct ways to pick four points that form a trapezoid:</p><ul>
<li>The points <code>[-3,2], [2,3], [3,2], [2,-3]</code> form one trapezoid.</li>
<li>The points <code>[2,3], [3,2], [3,0], [2,-3]</code> form another trapezoid.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-5.png" style="width: 250px; height: 250px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">points = [[0,0],[1,0],[0,1],[2,1]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-5.png" style="width: 250px; height: 250px;"/></p><p>There is only one trapezoid which can be formed.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>4 &lt;= points.length &lt;= 500</code></li>
<li><code>–1000 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 1000</code></li>
<li>All points are pairwise distinct.</li>
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
`hash table`
`math`
`geometry`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Hash every point-pair by its reduced slope &lt;code&gt;(dy,dx)&lt;/code&gt; (normalize with GCD and fix signs).
</details>
<details>
  <summary>Hint 2</summary>
  In each slope-bucket of size &lt;code&gt;k&lt;/code&gt;, there are &lt;code&gt;C(k,2)&lt;/code&gt; ways to pick two segments as the trapezoid&#39;s parallel bases.
</details>
<details>
  <summary>Hint 3</summary>
  Skip any base-pair that shares an endpoint since it would not form a quadrilateral.
</details>
<details>
  <summary>Hint 4</summary>
  Subtract one count for each parallelogram. Each parallelogram was counted once for each of its two parallel-side pairs, so after subtracting once, every quadrilateral with at least one pair of parallel sides, including parallelograms, contributes exactly one to the final total.
</details>
<details>
  <summary>Hint 5</summary>
  Final answer = total valid base-pairs minus parallelogram overcounts.
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

`2025-12-03, Wed 03 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )