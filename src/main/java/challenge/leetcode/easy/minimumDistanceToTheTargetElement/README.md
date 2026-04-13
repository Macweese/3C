[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1848. Minimum Distance to the Target Element

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1848](https://leetcode.com/problems/minimum-distance-to-the-target-element/)

## Description

<p>Given an integer array <code>nums</code> <strong>(0-indexed)</strong> and two integers <code>target</code> and <code>start</code>, find an index <code>i</code> such that <code>nums[i] == target</code> and <code>abs(i - start)</code> is <strong>minimized</strong>. Note that <code>abs(x)</code> is the absolute value of <code>x</code>.</p><p>Return <code>abs(i - start)</code>.</p><p>It is <strong>guaranteed</strong> that <code>target</code> exists in <code>nums</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4,5], target = 5, start = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1], target = 1, start = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
nums[0] = 1 is the only value equal to target, so the answer is abs(0 - 0) = 0.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Every value of nums is 1, but nums[0] minimizes abs(i - start), which is abs(0 - 0) = 0.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
<li><code>0 &lt;= start &lt; nums.length</code></li>
<li><code>target</code> is in <code>nums</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`array`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Loop in both directions until you find the target element.
</details>
<details>
  <summary>Hint 2</summary>
  For each index i such that nums[i] == target calculate abs(i - start).
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

`2026-04-13, Mon 13 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )