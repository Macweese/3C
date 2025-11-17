[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1437. Check If All 1&#39;s Are at Least Length K Places Away

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1437](https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/)

## Description

<p>Given an binary array <code>nums</code> and an integer <code>k</code>, return <code>true</code><em> if all </em><code>1</code><em>'s are at least </em><code>k</code><em> places away from each other, otherwise return </em><code>false</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/04/15/sample_1_1791.png" style="width: 428px; height: 181px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,0,0,0,1,0,0,1], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Each of the 1s are at least 2 places away from each other.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/04/15/sample_2_1791.png" style="width: 320px; height: 173px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,0,0,1,0,1], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The second 1 and third 1 are only one apart from each other.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= k &lt;= nums.length</code></li>
<li><code>nums[i]</code> is <code>0</code> or <code>1</code></li>
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


---

<details>
  <summary>Hint 1</summary>
  Each time you find a number 1, check whether or not it is K or more places away from the next one. If it&#39;s not, return false.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2365 Task Scheduler II](https://leetcode.com/problems/task-scheduler-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-17, Mon 17 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )