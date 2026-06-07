[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2196. Create Binary Tree From Descriptions

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2196](https://leetcode.com/problems/create-binary-tree-from-descriptions/)

## Description

<p>You are given a 2D integer array <code>descriptions</code> where <code>descriptions[i] = [parent<sub>i</sub>, child<sub>i</sub>, isLeft<sub>i</sub>]</code> indicates that <code>parent<sub>i</sub></code> is the <strong>parent</strong> of <code>child<sub>i</sub></code> in a <strong>binary</strong> tree of <strong>unique</strong> values. Furthermore,</p><ul>
<li>If <code>isLeft<sub>i</sub> == 1</code>, then <code>child<sub>i</sub></code> is the left child of <code>parent<sub>i</sub></code>.</li>
<li>If <code>isLeft<sub>i</sub> == 0</code>, then <code>child<sub>i</sub></code> is the right child of <code>parent<sub>i</sub></code>.</li>
</ul><p>Construct the binary tree described by <code>descriptions</code> and return <em>its <strong>root</strong></em>.</p><p>The test cases will be generated such that the binary tree is <strong>valid</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/02/09/example1drawio.png" style="width: 300px; height: 236px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[50,20,80,15,17,19]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/02/09/example2drawio.png" style="width: 131px; height: 300px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
descriptions = [[1,2,1],[2,3,0],[3,4,1]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[1,2,null,null,3,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= descriptions.length &lt;= 10<sup>4</sup></code></li>
<li><code>descriptions[i].length == 3</code></li>
<li><code>1 &lt;= parent<sub>i</sub>, child<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= isLeft<sub>i</sub> &lt;= 1</code></li>
<li>The binary tree described by <code>descriptions</code> is valid.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`tree`
`binary tree`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Could you represent and store the descriptions more efficiently?
</details>
<details>
  <summary>Hint 2</summary>
  Could you find the root node?
</details>
<details>
  <summary>Hint 3</summary>
  The node that is not a child in any of the descriptions is the root node.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [109 Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
* [1719 Number Of Ways To Reconstruct A Tree](https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-06-07, Sun 07 June 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )