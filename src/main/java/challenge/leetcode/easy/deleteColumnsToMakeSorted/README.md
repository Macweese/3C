[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 944. Delete Columns to Make Sorted

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 944](https://leetcode.com/problems/delete-columns-to-make-sorted/)

## Description

<p>You are given an array of <code>n</code> strings <code>strs</code>, all of the same length.</p><p>The strings can be arranged such that there is one on each line, making a grid.</p><ul>
<li>For example, <code>strs = ["abc", "bce", "cae"]</code> can be arranged as follows:</li>
</ul><pre>
abc
bce
cae
</pre><p>You want to <strong>delete</strong> the columns that are <strong>not sorted lexicographically</strong>. In the above example (<strong>0-indexed</strong>), columns 0 (<code>'a'</code>, <code>'b'</code>, <code>'c'</code>) and 2 (<code>'c'</code>, <code>'e'</code>, <code>'e'</code>) are sorted, while column 1 (<code>'b'</code>, <code>'c'</code>, <code>'a'</code>) is not, so you would delete column 1.</p><p>Return <em>the number of columns that you will delete</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["cba","daf","ghi"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
strs = ["a","b"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.
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
The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == strs.length</code></li>
<li><code>1 &lt;= n &lt;= 100</code></li>
<li><code>1 &lt;= strs[i].length &lt;= 1000</code></li>
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

`2025-12-20, Sat 20 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )