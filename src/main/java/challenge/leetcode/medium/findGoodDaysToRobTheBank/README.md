[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2100. Find Good Days to Rob the Bank

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2100](https://leetcode.com/problems/find-good-days-to-rob-the-bank/)

## Description

<p>You and a gang of thieves are planning on robbing a bank. You are given a <strong>0-indexed</strong> integer array <code>security</code>, where <code>security[i]</code> is the number of guards on duty on the <code>i<sup>th</sup></code> day. The days are numbered starting from <code>0</code>. You are also given an integer <code>time</code>.</p><p>The <code>i<sup>th</sup></code> day is a good day to rob the bank if:</p><ul>
<li>There are at least <code>time</code> days before and after the <code>i<sup>th</sup></code> day,</li>
<li>The number of guards at the bank for the <code>time</code> days <strong>before</strong> <code>i</code> are <strong>non-increasing</strong>, and</li>
<li>The number of guards at the bank for the <code>time</code> days <strong>after</strong> <code>i</code> are <strong>non-decreasing</strong>.</li>
</ul><p>More formally, this means day <code>i</code> is a good day to rob the bank if and only if <code>security[i - time] &gt;= security[i - time + 1] &gt;= ... &gt;= security[i] &lt;= ... &lt;= security[i + time - 1] &lt;= security[i + time]</code>.</p><p>Return <em>a list of <strong>all</strong> days <strong>(0-indexed) </strong>that are good days to rob the bank</em>.<em> The order that the days are returned in does<strong> </strong><strong>not</strong> matter.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
security = [5,3,3,3,5,6,2], time = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[2,3]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
On day 2, we have security[0] &gt;= security[1] &gt;= security[2] &lt;= security[3] &lt;= security[4].
On day 3, we have security[1] &gt;= security[2] &gt;= security[3] &lt;= security[4] &lt;= security[5].
No other days satisfy this condition, so days 2 and 3 are the only good days to rob the bank.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
security = [1,1,1,1,1], time = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,2,3,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Since time equals 0, every day is a good day to rob the bank, so return every day.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
security = [1,2,3,4,5,6], time = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
No day has 2 days before it that have a non-increasing number of guards.
Thus, no day is a good day to rob the bank, so return an empty list.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= security.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= security[i], time &lt;= 10<sup>5</sup></code></li>
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
`prefix sum`


---

<details>
  <summary>Hint 1</summary>
  The trivial solution is to check the time days before and after each day. There are a lot of repeated operations using this solution. How could we optimize this solution?
</details>
<details>
  <summary>Hint 2</summary>
  We can use precomputation to make the solution faster.
</details>
<details>
  <summary>Hint 3</summary>
  Use an array to store the number of days before the i&lt;sup&gt;th&lt;/sup&gt; day that is non-increasing, and another array to store the number of days after the i&lt;sup&gt;th&lt;/sup&gt; day that is non-decreasing.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [665 Non-decreasing Array](https://leetcode.com/problems/non-decreasing-array/)
* [845 Longest Mountain in Array](https://leetcode.com/problems/longest-mountain-in-array/)
* [1095 Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array/)
* [1800 Maximum Ascending Subarray Sum](https://leetcode.com/problems/maximum-ascending-subarray-sum/)
* [2420 Find All Good Indices](https://leetcode.com/problems/find-all-good-indices/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-08, Wed 08 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )