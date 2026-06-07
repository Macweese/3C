[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3464. Maximize the Distance Between Points on a Square

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3464](https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/)

## Description

<p>You are given an integer <code><font face="monospace">side</font></code>, representing the edge length of a square with corners at <code>(0, 0)</code>, <code>(0, side)</code>, <code>(side, 0)</code>, and <code>(side, side)</code> on a Cartesian plane.</p><p>You are also given a <strong>positive</strong> integer <code>k</code> and a 2D integer array <code>points</code>, where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> represents the coordinate of a point lying on the <strong>boundary</strong> of the square.</p><p>You need to select <code>k</code> elements among <code>points</code> such that the <strong>minimum</strong> Manhattan distance between any two points is <strong>maximized</strong>.</p><p>Return the <strong>maximum</strong> possible <strong>minimum</strong> Manhattan distance between the selected <code>k</code> points.</p><p>The Manhattan Distance between two cells <code>(x<sub>i</sub>, y<sub>i</sub>)</code> and <code>(x<sub>j</sub>, y<sub>j</sub>)</code> is <code>|x<sub>i</sub> - x<sub>j</sub>| + |y<sub>i</sub> - y<sub>j</sub>|</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/4080_example0_revised.png" style="width: 200px; height: 200px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">side = 2, points = [[0,2],[2,0],[2,2],[0,0]], k = 4</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/4080_example0_revised.png" style="width: 200px; height: 200px;"/></p><p>Select all four points.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/4080_example1_revised.png" style="width: 211px; height: 200px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">side = 2, points = [[0,0],[1,2],[2,0],[2,2],[2,1]], k = 4</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/4080_example1_revised.png" style="width: 211px; height: 200px;"/></p><p>Select the points <code>(0, 0)</code>, <code>(2, 0)</code>, <code>(2, 2)</code>, and <code>(2, 1)</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/4080_example2_revised.png" style="width: 200px; height: 200px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">side = 2, points = [[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]], k = 5</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/4080_example2_revised.png" style="width: 200px; height: 200px;"/></p><p>Select the points <code>(0, 0)</code>, <code>(0, 1)</code>, <code>(0, 2)</code>, <code>(1, 2)</code>, and <code>(2, 2)</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= side &lt;= 10<sup>9</sup></code></li>
<li><code>4 &lt;= points.length &lt;= min(4 * side, 15 * 10<sup>3</sup>)</code></li>
<li><code>points[i] == [xi, yi]</code></li>
<li>The input is generated such that:
	<ul>
<li><code>points[i]</code> lies on the boundary of the square.</li>
<li>All <code>points[i]</code> are <strong>unique</strong>.</li>
</ul>
</li>
<li><code>4 &lt;= k &lt;= min(25, points.length)</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`math`
`binary search`
`geometry`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Can we use binary search for this problem?
</details>
<details>
  <summary>Hint 2</summary>
  Think of the coordinates on a straight line in clockwise order.
</details>
<details>
  <summary>Hint 3</summary>
  Binary search on the minimum Manhattan distance &lt;code&gt;x&lt;/code&gt;.
</details>
<details>
  <summary>Hint 4</summary>
  During the binary search, for each coordinate, find the immediate next coordinate with distance &gt;= &lt;code&gt;x&lt;/code&gt;.
</details>
<details>
  <summary>Hint 5</summary>
  Greedily select up to &lt;code&gt;k&lt;/code&gt; coordinates.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2557 Maximum Number of Integers to Choose From a Range II](https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-ii/)
* [3143 Maximum Points Inside the Square](https://leetcode.com/problems/maximum-points-inside-the-square/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-25, Sat 25 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )