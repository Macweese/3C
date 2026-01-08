[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1161. Maximum Level Sum of a Binary Tree

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1161](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)

## Description

<p>Given the <code>root</code> of a binary tree, the level of its root is <code>1</code>, the level of its children is <code>2</code>, and so on.</p><p>Return the <strong>smallest</strong> level <code>x</code> such that the sum of all the values of nodes at level <code>x</code> is <strong>maximal</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2019/05/03/capture.JPG" style="width: 200px; height: 175px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
root = [1,7,0,7,-8,null,null]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
root = [989,null,10250,98693,-89388,null,null,null,-32127]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
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
`breadth-first search`
`binary tree`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Calculate the sum for each level then find the level with the maximum sum.
</details>
<details>
  <summary>Hint 2</summary>
  How can you traverse the tree ?
</details>
<details>
  <summary>Hint 3</summary>
  How can you sum up the values for every level ?
</details>
<details>
  <summary>Hint 4</summary>
  Use DFS or BFS to traverse the tree keeping the level of each node, and sum up those values with a map or a frequency array.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2583 Kth Largest Sum in a Binary Tree](https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/)
* [2641 Cousins in Binary Tree II](https://leetcode.com/problems/cousins-in-binary-tree-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-01-06, Tue 06 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )