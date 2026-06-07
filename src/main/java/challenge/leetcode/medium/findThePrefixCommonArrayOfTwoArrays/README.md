[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2657. Find the Prefix Common Array of Two Arrays

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2657](https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/)

## Description

<p>You are given two <strong>0-indexed </strong>integer<strong> </strong>permutations <code>A</code> and <code>B</code> of length <code>n</code>.</p><p>A <strong>prefix common array</strong> of <code>A</code> and <code>B</code> is an array <code>C</code> such that <code>C[i]</code> is equal to the count of numbers that are present at or before the index <code>i</code> in both <code>A</code> and <code>B</code>.</p><p>Return <em>the <strong>prefix common array</strong> of </em><code>A</code><em> and </em><code>B</code>.</p><p>A sequence of <code>n</code> integers is called a <strong>permutation</strong> if it contains all integers from <code>1</code> to <code>n</code> exactly once.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
A = [1,3,2,4], B = [3,1,2,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,2,3,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
A = [2,3,1], B = [3,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,3]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= A.length == B.length == n &lt;= 50</code></li>
<li><code>1 &lt;= A[i], B[i] &lt;= n</code></li>
<li><code>It is guaranteed that A and B are both a permutation of n integers.</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`bit manipulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Consider keeping a frequency array that stores the count of occurrences of each number till index i.
</details>
<details>
  <summary>Hint 2</summary>
  If a number occurred two times, it means it occurred in both A and B since they’re both permutations so add one to the answer.
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

`2026-05-20, Wed 20 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )