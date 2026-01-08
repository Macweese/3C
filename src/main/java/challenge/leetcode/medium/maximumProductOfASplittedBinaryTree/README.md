[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1339. Maximum Product of Splitted Binary Tree

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1339](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)

## Description

<p>Given the <code>root</code> of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.</p><p>Return <em>the maximum product of the sums of the two subtrees</em>. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p><p><strong>Note</strong> that you need to maximize the answer before taking the mod and not after taking it.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/01/21/sample_1_1699.png" style="width: 500px; height: 167px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
root = [1,2,3,4,5,6]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
110
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/01/21/sample_2_1699.png" style="width: 500px; height: 211px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
root = [1,null,2,3,4,null,null,5,6]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
90
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
</pre>

</div>

<br>

### Constraints:

<ul>
<li>The number of nodes in the tree is in the range <code>[2, 5 * 10<sup>4</sup>]</code>.</li>
<li><code>1 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
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
`binary tree`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If we know the sum of a subtree, the answer is max( (total_sum - subtree_sum) * subtree_sum) in each node.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2049 Count Nodes With the Highest Score](https://leetcode.com/problems/count-nodes-with-the-highest-score/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-01-07, Wed 07 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )