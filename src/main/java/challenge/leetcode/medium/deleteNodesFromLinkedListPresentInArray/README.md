[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3217. Delete Nodes From Linked List Present in Array

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3217](https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/)

## Description

<p>You are given an array of integers <code>nums</code> and the <code>head</code> of a linked list. Return the <code>head</code> of the modified linked list after <strong>removing</strong> all nodes from the linked list that have a value that exists in <code>nums</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample0.png" style="width: 400px; height: 66px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,3], head = [1,2,3,4,5]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[4,5]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample0.png" style="width: 400px; height: 66px;"/></strong></p><p>Remove the nodes with values 1, 2, and 3.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample1.png" style="height: 62px; width: 450px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1], head = [1,2,1,2,1,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[2,2,2]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample1.png" style="height: 62px; width: 450px;"/></p><p>Remove the nodes with value 1.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample2.png" style="width: 400px; height: 83px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [5], head = [1,2,3,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[1,2,3,4]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample2.png" style="width: 400px; height: 83px;"/></strong></p><p>No node has value 5.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
<li>All elements in <code>nums</code> are unique.</li>
<li>The number of nodes in the given list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
<li>The input is generated such that there is at least one node in the linked list that has a value not present in <code>nums</code>.</li>
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
`hash table`
`linked list`


---

<details>
  <summary>Hint 1</summary>
  Add all elements of &lt;code&gt;nums&lt;/code&gt; into a Set.
</details>
<details>
  <summary>Hint 2</summary>
  Scan the list to check if the current element should be deleted by checking the Set.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [203 Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
* [237 Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)
* [2487 Remove Nodes From Linked List](https://leetcode.com/problems/remove-nodes-from-linked-list/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-01, Sat 01 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )