[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 712. Minimum ASCII Delete Sum for Two Strings

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 712](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/)

## Description

<p>Given two strings <code>s1</code> and <code>s2</code>, return <em>the lowest <strong>ASCII</strong> sum of deleted characters to make two strings equal</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s1 = "sea", s2 = "eat"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
231
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s1 = "delete", s2 = "leet"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
403
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s1.length, s2.length &lt;= 1000</code></li>
<li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
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

`string`
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let dp(i, j) be the answer for inputs s1[i:] and s2[j:].
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [72 Edit Distance](https://leetcode.com/problems/edit-distance/)
* [300 Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
* [583 Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-01-10, Sat 10 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )