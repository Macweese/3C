[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 865. Smallest Subtree with all the Deepest Nodes

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 865](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/)

## Description

<p>Given the <code>root</code> of a binary tree, the depth of each node is <strong>the shortest distance to the root</strong>.</p><p>Return <em>the smallest subtree</em> such that it contains <strong>all the deepest nodes</strong> in the original tree.</p><p>A node is called <strong>the deepest</strong> if it has the largest depth possible among any node in the entire tree.</p><p>The <strong>subtree</strong> of a node is a tree consisting of that node, plus the set of all descendants of that node.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/01/sketch1.png" style="width: 600px; height: 510px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
root = [3,5,1,6,2,0,8,null,null,7,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[2,7,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest nodes of the tree.
Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
root = [1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The root is the deepest node in the tree.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
root = [0,1,3,null,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[2]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.
</pre>

</div>

<br>

### Constraints:

<ul>
<li>The number of nodes in the tree will be in the range <code>[1, 500]</code>.</li>
<li><code>0 &lt;= Node.val &lt;= 500</code></li>
<li>The values of the nodes in the tree are <strong>unique</strong>.</li>
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

`hash table`
`tree`
`depth-first search`
`breadth-first search`
`binary tree`


---

**Hints**
<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-01-09, Fri 09 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )