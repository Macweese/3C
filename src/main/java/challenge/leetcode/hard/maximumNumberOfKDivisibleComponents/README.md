[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2872. Maximum Number of K-Divisible Components

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2872](https://leetcode.com/problems/maximum-number-of-k-divisible-components/)

## Description

<p>There is an undirected tree with <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>. You are given the integer <code>n</code> and a 2D integer array <code>edges</code> of length <code>n - 1</code>, where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p><p>You are also given a <strong>0-indexed</strong> integer array <code>values</code> of length <code>n</code>, where <code>values[i]</code> is the <strong>value</strong> associated with the <code>i<sup>th</sup></code> node, and an integer <code>k</code>.</p><p>A <strong>valid split</strong> of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by <code>k</code>, where the <strong>value of a connected component</strong> is the sum of the values of its nodes.</p><p>Return <em>the <strong>maximum number of components</strong> in any valid split</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2023/08/07/example12-cropped2svg.jpg" style="width: 1024px; height: 453px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We remove the edge connecting node 1 with 2. The resulting split is valid because:
- The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
- The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
It can be shown that no other valid split has more than 2 connected components.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2023/08/07/example21svg-1.jpg" style="width: 999px; height: 338px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We remove the edge connecting node 0 with 2, and the edge connecting node 0 with 1. The resulting split is valid because:
- The value of the component containing node 0 is values[0] = 3.
- The value of the component containing nodes 2, 5, and 6 is values[2] + values[5] + values[6] = 9.
- The value of the component containing nodes 1, 3, and 4 is values[1] + values[3] + values[4] = 6.
It can be shown that no other valid split has more than 3 connected components.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 3 * 10<sup>4</sup></code></li>
<li><code>edges.length == n - 1</code></li>
<li><code>edges[i].length == 2</code></li>
<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
<li><code>values.length == n</code></li>
<li><code>0 &lt;= values[i] &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
<li>Sum of <code>values</code> is divisible by <code>k</code>.</li>
<li>The input is generated such that <code>edges</code> represents a valid tree.</li>
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

`tree`
`depth-first search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Root the tree at node &lt;code&gt;0&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  If a leaf node is not divisible by &lt;code&gt;k&lt;/code&gt;, it must be in the same component as its parent node so we merge it with its parent node.
</details>
<details>
  <summary>Hint 3</summary>
  If a leaf node is divisible by &lt;code&gt;k&lt;/code&gt;, it will be in its own components so we separate it from its parent node.
</details>
<details>
  <summary>Hint 4</summary>
  In each step, we either cut a leaf node down or merge a leaf node. The number of nodes on the tree reduces by one. Repeat this process until only one node is left.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2440 Create Components With Same Value](https://leetcode.com/problems/create-components-with-same-value/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-11-28, Fri 28 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )