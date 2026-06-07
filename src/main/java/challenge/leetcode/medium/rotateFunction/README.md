[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 396. Rotate Function

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 396](https://leetcode.com/problems/rotate-function/)

## Description

<p>You are given an integer array <code>nums</code> of length <code>n</code>.</p><p>Assume <code>arr<sub>k</sub></code> to be an array obtained by rotating <code>nums</code> by <code>k</code> positions clock-wise. We define the <strong>rotation function</strong> <code>F</code> on <code>nums</code> as follow:</p><ul>
<li><code>F(k) = 0 * arr<sub>k</sub>[0] + 1 * arr<sub>k</sub>[1] + ... + (n - 1) * arr<sub>k</sub>[n - 1].</code></li>
</ul><p>Return <em>the maximum value of</em> <code>F(0), F(1), ..., F(n-1)</code>.</p><p>The test cases are generated so that the answer fits in a <strong>32-bit</strong> integer.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [4,3,2,6]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
26
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [100]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == nums.length</code></li>
<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`math`
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

`2026-05-01, Fri 01 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )