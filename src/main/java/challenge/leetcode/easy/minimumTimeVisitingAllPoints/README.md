[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1266. Minimum Time Visiting All Points

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1266](https://leetcode.com/problems/minimum-time-visiting-all-points/)

## Description

<p>On a 2D plane, there are <code>n</code> points with integer coordinates <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>. Return <em>the <strong>minimum time</strong> in seconds to visit all the points in the order given by </em><code>points</code>.</p><p>You can move according to these rules:</p><ul>
<li>In <code>1</code> second, you can either:

	<ul>
<li>move vertically by one unit,</li>
<li>move horizontally by one unit, or</li>
<li>move diagonally <code>sqrt(2)</code> units (in other words, move one unit vertically then one unit horizontally in <code>1</code> second).</li>
</ul>
</li>
<li>You have to visit the points in the same order as they appear in the array.</li>
<li>You are allowed to pass through points that appear later in the order, but these do not count as visits.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/1626_example_1.PNG" style="width: 500px; height: 428px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
points = [[1,1],[3,4],[-1,0]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One optimal path is <strong>[1,1]</strong> -&gt; [2,2] -&gt; [3,3] -&gt; <strong>[3,4] </strong>-&gt; [2,3] -&gt; [1,2] -&gt; [0,1] -&gt; <strong>[-1,0]</strong>   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
points = [[3,2],[-2,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>points.length == n</code></li>
<li><code>1 &lt;= n &lt;= 100</code></li>
<li><code>points[i].length == 2</code></li>
<li><code>-1000 &lt;= points[i][0], points[i][1] &lt;= 1000</code></li>
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
`math`
`geometry`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  To walk from point A to point B there will be an optimal strategy to walk ?
</details>
<details>
  <summary>Hint 2</summary>
  Advance in diagonal as possible then after that go in straight line.
</details>
<details>
  <summary>Hint 3</summary>
  Repeat the process until visiting all the points.
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

`2026-01-12, Mon 12 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )