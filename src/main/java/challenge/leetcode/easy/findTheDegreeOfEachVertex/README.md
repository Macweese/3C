[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3898. Find the Degree of Each Vertex

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3898](https://leetcode.com/problems/find-the-degree-of-each-vertex/)

## Description

<p>You are given a 2D integer array <code>matrix</code> of size <code>n x n</code> representing the adjacency matrix of an undirected graph with <code>n</code> vertices labeled from 0 to <code>n - 1</code>.</p><ul>
<li><code>matrix[i][j] = 1</code> indicates that there is an edge between vertices <code>i</code> and <code>j</code>.</li>
<li><code>matrix[i][j] = 0</code> indicates that there is no edge between vertices <code>i</code> and <code>j</code>.</li>
</ul><p>The <strong>degree</strong> of a vertex is the number of edges connected to it.</p><p>Return an integer array <code>ans</code> of size <code>n</code> where <code>ans[i]</code> represents the degree of vertex <code>i</code>.</p>

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
<li><code>1 &lt;= n == matrix.length == matrix[i].length &lt;= 100</code>​​​​​​​</li>
<li><code>​​​​​​​matrix[i][i] == 0</code></li>
<li><code>matrix[i][j]</code> is either 0 or 1</li>
<li><code>matrix[i][j] == matrix[j][i]</code></li>
</ul>

<br>

---

<br>

#### Tags

<!-- No tags found -->

---

**Hints**
<details>
  <summary>Hint 1</summary>
  The degree of node &lt;code&gt;i&lt;/code&gt; is the sum of row &lt;code&gt;i&lt;/code&gt; in the matrix
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


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )