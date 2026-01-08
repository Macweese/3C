[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1458. Max Dot Product of Two Subsequences

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1458](https://leetcode.com/problems/max-dot-product-of-two-subsequences/)

## Description

<p>Given two arrays <code>nums1</code> and <code><font face="monospace">nums2</font></code><font face="monospace">.</font></p><p>Return the maximum dot product between <strong>non-empty</strong> subsequences of nums1 and nums2 with the same length.</p><p>A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, <code>[2,3,5]</code> is a subsequence of <code>[1,2,3,4,5]</code> while <code>[1,5,3]</code> is not).</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums1 = [2,1,-2,5], nums2 = [3,0,-6]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
18
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums1 = [3,-2], nums2 = [2,-6,7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
21
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums1 = [-1,-1], nums2 = [1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums1.length, nums2.length &lt;= 500</code></li>
<li><code>-1000 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
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
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use dynamic programming, define DP[i][j] as the maximum dot product of two subsequences starting in the position i of nums1 and position j of nums2.
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

`2026-01-08, Thu 08 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )