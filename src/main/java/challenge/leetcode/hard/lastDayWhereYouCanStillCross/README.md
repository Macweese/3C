[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1970. Last Day Where You Can Still Cross

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1970](https://leetcode.com/problems/last-day-where-you-can-still-cross/)

## Description

<p>There is a <strong>1-based</strong> binary matrix where <code>0</code> represents land and <code>1</code> represents water. You are given integers <code>row</code> and <code>col</code> representing the number of rows and columns in the matrix, respectively.</p><p>Initially on day <code>0</code>, the <strong>entire</strong> matrix is <strong>land</strong>. However, each day a new cell becomes flooded with <strong>water</strong>. You are given a <strong>1-based</strong> 2D array <code>cells</code>, where <code>cells[i] = [r<sub>i</sub>, c<sub>i</sub>]</code> represents that on the <code>i<sup>th</sup></code> day, the cell on the <code>r<sub>i</sub><sup>th</sup></code> row and <code>c<sub>i</sub><sup>th</sup></code> column (<strong>1-based</strong> coordinates) will be covered with <strong>water</strong> (i.e., changed to <code>1</code>).</p><p>You want to find the <strong>last</strong> day that it is possible to walk from the <strong>top</strong> to the <strong>bottom</strong> by only walking on land cells. You can start from <strong>any</strong> cell in the top row and end at <strong>any</strong> cell in the bottom row. You can only travel in the<strong> four</strong> cardinal directions (left, right, up, and down).</p><p>Return <em>the <strong>last</strong> day where it is possible to walk from the <strong>top</strong> to the <strong>bottom</strong> by only walking on land cells</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/07/27/1.png" style="width: 624px; height: 162px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/07/27/2.png" style="width: 504px; height: 178px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/07/27/3.png" style="width: 666px; height: 167px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 3.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= row, col &lt;= 2 * 10<sup>4</sup></code></li>
<li><code>4 &lt;= row * col &lt;= 2 * 10<sup>4</sup></code></li>
<li><code>cells.length == row * col</code></li>
<li><code>1 &lt;= r<sub>i</sub> &lt;= row</code></li>
<li><code>1 &lt;= c<sub>i</sub> &lt;= col</code></li>
<li>All the values of <code>cells</code> are <strong>unique</strong>.</li>
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
`depth-first search`
`breadth-first search`
`union find`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  What graph algorithm allows us to find whether a path exists?
</details>
<details>
  <summary>Hint 2</summary>
  Can we use binary search to help us solve the problem?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [803 Bricks Falling When Hit](https://leetcode.com/problems/bricks-falling-when-hit/)
* [2258 Escape the Spreading Fire](https://leetcode.com/problems/escape-the-spreading-fire/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-31, Wed 31 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )