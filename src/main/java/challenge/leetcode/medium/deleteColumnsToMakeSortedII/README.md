[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 955. Delete Columns to Make Sorted II

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 955](https://leetcode.com/problems/delete-columns-to-make-sorted-ii/)

## Description

<p>You are given an array of <code>n</code> strings <code>strs</code>, all of the same length.</p><p>We may choose any deletion indices, and we delete all the characters in those indices for each string.</p><p>For example, if we have <code>strs = ["abcdef","uvwxyz"]</code> and deletion indices <code>{0, 2, 3}</code>, then the final array after deletions is <code>["bef", "vyz"]</code>.</p><p>Suppose we chose a set of deletion indices <code>answer</code> such that after deletions, the final array has its elements in <strong>lexicographic</strong> order (i.e., <code>strs[0] &lt;= strs[1] &lt;= strs[2] &lt;= ... &lt;= strs[n - 1]</code>). Return <em>the minimum possible value of</em> <code>answer.length</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["ca","bb","ac"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After deleting the first column, strs = ["a", "b", "c"].
Now strs is in lexicographic order (ie. strs[0] &lt;= strs[1] &lt;= strs[2]).
We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["xc","yb","za"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
strs is already in lexicographic order, so we do not need to delete anything.
Note that the rows of strs are not necessarily in lexicographic order:
i.e., it is NOT necessarily true that (strs[0][0] &lt;= strs[0][1] &lt;= ...)
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["zyx","wvu","tsr"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We have to delete every column.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == strs.length</code></li>
<li><code>1 &lt;= n &lt;= 100</code></li>
<li><code>1 &lt;= strs[i].length &lt;= 100</code></li>
<li><code>strs[i]</code> consists of lowercase English letters.</li>
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
`string`
`greedy`


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

`2025-12-21, Sun 21 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )