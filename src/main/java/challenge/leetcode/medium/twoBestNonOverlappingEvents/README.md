[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2054. Two Best Non-Overlapping Events

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2054](https://leetcode.com/problems/two-best-non-overlapping-events/)

## Description

<p>You are given a <strong>0-indexed</strong> 2D integer array of <code>events</code> where <code>events[i] = [startTime<sub>i</sub>, endTime<sub>i</sub>, value<sub>i</sub>]</code>. The <code>i<sup>th</sup></code> event starts at <code>startTime<sub>i</sub></code><sub> </sub>and ends at <code>endTime<sub>i</sub></code>, and if you attend this event, you will receive a value of <code>value<sub>i</sub></code>. You can choose <strong>at most</strong> <strong>two</strong> <strong>non-overlapping</strong> events to attend such that the sum of their values is <strong>maximized</strong>.</p><p>Return <em>this <strong>maximum</strong> sum.</em></p><p>Note that the start time and end time is <strong>inclusive</strong>: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time <code>t</code>, the next event must start at or after <code>t + 1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/picture5.png" style="width: 400px; height: 75px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
events = [[1,3,2],[4,5,2],[2,4,3]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="Example 1 Diagram" src="https://assets.leetcode.com/uploads/2021/09/21/picture1.png" style="width: 400px; height: 77px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
events = [[1,3,2],[4,5,2],[1,5,5]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Choose event 2 for a sum of 5.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/picture3.png" style="width: 400px; height: 66px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
events = [[1,5,3],[1,5,1],[6,6,5]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
8
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Choose events 0 and 2 for a sum of 3 + 5 = 8.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= events.length &lt;= 10<sup>5</sup></code></li>
<li><code>events[i].length == 3</code></li>
<li><code>1 &lt;= startTime<sub>i</sub> &lt;= endTime<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= value<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
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
`binary search`
`dynamic programming`
`sorting`
`heap (priority queue)`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  How can sorting the events on the basis of their start times help? How about end times?
</details>
<details>
  <summary>Hint 2</summary>
  How can we quickly get the maximum score of an interval not intersecting with the interval we chose?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1235 Maximum Profit in Job Scheduling](https://leetcode.com/problems/maximum-profit-in-job-scheduling/)
* [1751 Maximum Number of Events That Can Be Attended II](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/)
* [2555 Maximize Win From Two Segments](https://leetcode.com/problems/maximize-win-from-two-segments/)
* [3414 Maximum Score of Non-overlapping Intervals](https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-23, Tue 23 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )