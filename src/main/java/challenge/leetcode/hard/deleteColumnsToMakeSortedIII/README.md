[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 960. Delete Columns to Make Sorted III

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 960](https://leetcode.com/problems/delete-columns-to-make-sorted-iii/)

## Description

<p>You are given an array of <code>n</code> strings <code>strs</code>, all of the same length.</p><p>We may choose any deletion indices, and we delete all the characters in those indices for each string.</p><p>For example, if we have <code>strs = ["abcdef","uvwxyz"]</code> and deletion indices <code>{0, 2, 3}</code>, then the final array after deletions is <code>["bef", "vyz"]</code>.</p><p>Suppose we chose a set of deletion indices <code>answer</code> such that after deletions, the final array has <strong>every string (row) in lexicographic</strong> order. (i.e., <code>(strs[0][0] &lt;= strs[0][1] &lt;= ... &lt;= strs[0][strs[0].length - 1])</code>, and <code>(strs[1][0] &lt;= strs[1][1] &lt;= ... &lt;= strs[1][strs[1].length - 1])</code>, and so on). Return <em>the minimum possible value of</em> <code>answer.length</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["babca","bbazb"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After deleting columns 0, 1, and 4, the final array is strs = ["bc", "az"].
Both these rows are individually in lexicographic order (ie. strs[0][0] &lt;= strs[0][1] and strs[1][0] &lt;= strs[1][1]).
Note that strs[0] &gt; strs[1] - the array strs is not necessarily in lexicographic order.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["edcba"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
If we delete less than 4 columns, the only row will not be lexicographically sorted.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["ghi","def","abc"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
All rows are already lexicographically sorted.
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
`dynamic programming`


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

`2025-12-22, Mon 22 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )