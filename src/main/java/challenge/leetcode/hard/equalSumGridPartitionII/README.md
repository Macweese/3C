[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3548. Equal Sum Grid Partition II

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3548](https://leetcode.com/problems/equal-sum-grid-partition-ii/)

## Description

<p>You are given an <code>m x n</code> matrix <code>grid</code> of positive integers. Your task is to determine if it is possible to make <strong>either one horizontal or one vertical cut</strong> on the grid such that:</p><ul>
<li>Each of the two resulting sections formed by the cut is <strong>non-empty</strong>.</li>
<li>The sum of elements in both sections is <b>equal</b>, or can be made equal by discounting <strong>at most</strong> one single cell in total (from either section).</li>
<li>If a cell is discounted, the rest of the section must <strong>remain connected</strong>.</li>
</ul><p>Return <code>true</code> if such a partition exists; otherwise, return <code>false</code>.</p><p><strong>Note:</strong> A section is <strong>connected</strong> if every cell in it can be reached from any other cell by moving up, down, left, or right through other cells in the section.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.jpeg" style="height: 180px; width: 180px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,4],[2,3]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.jpeg" style="height: 180px; width: 180px;"/></p><ul>
<li>A horizontal cut after the first row gives sums <code>1 + 4 = 5</code> and <code>2 + 3 = 5</code>, which are equal. Thus, the answer is <code>true</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/04/01/chatgpt-image-apr-1-2025-at-05_28_12-pm.png" style="height: 180px; width: 180px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,2],[3,4]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/01/chatgpt-image-apr-1-2025-at-05_28_12-pm.png" style="height: 180px; width: 180px;"/></p><ul>
<li>A vertical cut after the first column gives sums <code>1 + 3 = 4</code> and <code>2 + 4 = 6</code>.</li>
<li>By discounting 2 from the right section (<code>6 - 2 = 4</code>), both sections have equal sums and remain connected. Thus, the answer is <code>true</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/04/01/chatgpt-image-apr-2-2025-at-02_50_29-am.png" style="height: 180px; width: 180px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,2,4],[2,3,5]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2025/04/01/chatgpt-image-apr-2-2025-at-02_50_29-am.png" style="height: 180px; width: 180px;"/></strong></p><ul>
<li>A horizontal cut after the first row gives <code>1 + 2 + 4 = 7</code> and <code>2 + 3 + 5 = 10</code>.</li>
<li>By discounting 3 from the bottom section (<code>10 - 3 = 7</code>), both sections have equal sums, but they do not remain connected as it splits the bottom section into two parts (<code>[2]</code> and <code>[5]</code>). Thus, the answer is <code>false</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 4
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[4,1,8],[3,2,6]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>No valid cut exists, so the answer is <code>false</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= m == grid.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= n == grid[i].length &lt;= 10<sup>5</sup></code></li>
<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`matrix`
`enumeration`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  In a grid (or any subgrid), when can a section be disconnected? Can disconnected components occur if the section spans more than one row and more than one column?
</details>
<details>
  <summary>Hint 2</summary>
  Handle single rows or single columns separately. For all other partitions, maintain the sums and value frequencies of each section to check whether removing at most one element from one section can make the two sums equal.
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

`2026-03-26, Thu 26 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )