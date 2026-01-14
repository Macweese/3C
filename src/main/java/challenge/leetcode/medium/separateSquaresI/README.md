[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3453. Separate Squares I

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3453](https://leetcode.com/problems/separate-squares-i/)

## Description

<p>You are given a 2D integer array <code>squares</code>. Each <code>squares[i] = [x<sub>i</sub>, y<sub>i</sub>, l<sub>i</sub>]</code> represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.</p><p>Find the <strong>minimum</strong> y-coordinate value of a horizontal line such that the total area of the squares above the line <em>equals</em> the total area of the squares below the line.</p><p>Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p><p><strong>Note</strong>: Squares <strong>may</strong> overlap. Overlapping areas should be counted <strong>multiple times</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/01/06/4062example1drawio.png" style="width: 378px; height: 352px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">squares = [[0,0,1],[2,2,1]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1.00000</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/06/4062example1drawio.png" style="width: 378px; height: 352px;"/></p><p>Any horizontal line between <code>y = 1</code> and <code>y = 2</code> will have 1 square unit above it and 1 square unit below it. The lowest option is 1.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/01/15/4062example2drawio.png" style="width: 378px; height: 352px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">squares = [[0,0,2],[1,1,1]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1.16667</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/15/4062example2drawio.png" style="width: 378px; height: 352px;"/></p><p>The areas are:</p><ul>
<li>Below the line: <code>7/6 * 2 (Red) + 1/6 (Blue) = 15/6 = 2.5</code>.</li>
<li>Above the line: <code>5/6 * 2 (Red) + 5/6 (Blue) = 15/6 = 2.5</code>.</li>
</ul><p>Since the areas above and below the line are equal, the output is <code>7/6 = 1.16667</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= squares.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>squares[i] = [x<sub>i</sub>, y<sub>i</sub>, l<sub>i</sub>]</code></li>
<li><code>squares[i].length == 3</code></li>
<li><code>0 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= l<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
<li>The total area of all the squares will not exceed <code>10<sup>12</sup></code>.</li>
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
`binary search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Binary search on the answer.
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

`2026-01-13, Tue 13 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )