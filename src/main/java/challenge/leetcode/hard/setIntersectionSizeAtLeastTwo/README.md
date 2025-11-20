[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 757. Set Intersection Size At Least Two

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 757](https://leetcode.com/problems/set-intersection-size-at-least-two/)

## Description

<p>You are given a 2D integer array <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> represents all the integers from <code>start<sub>i</sub></code> to <code>end<sub>i</sub></code> inclusively.</p><p>A <strong>containing set</strong> is an array <code>nums</code> where each interval from <code>intervals</code> has <strong>at least two</strong> integers in <code>nums</code>.</p><ul>
<li>For example, if <code>intervals = [[1,3], [3,7], [8,9]]</code>, then <code>[1,2,4,7,8,9]</code> and <code>[2,3,4,8,9]</code> are <strong>containing sets</strong>.</li>
</ul><p>Return <em>the minimum possible size of a containing set</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
intervals = [[1,3],[3,7],[8,9]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
let nums = [2, 3, 4, 8, 9].
It can be shown that there cannot be any containing array of size 4.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
intervals = [[1,3],[1,4],[2,5],[3,5]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
let nums = [2, 3, 4].
It can be shown that there cannot be any containing array of size 2.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
intervals = [[1,2],[2,3],[2,4],[4,5]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
let nums = [1, 2, 3, 4, 5].
It can be shown that there cannot be any containing array of size 4.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= intervals.length &lt;= 3000</code></li>
<li><code>intervals[i].length == 2</code></li>
<li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 10<sup>8</sup></code></li>
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
`greedy`
`sorting`


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

`2025-11-20, Thu 20 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )