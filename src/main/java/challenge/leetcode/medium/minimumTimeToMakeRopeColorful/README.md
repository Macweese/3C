[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1578. Minimum Time to Make Rope Colorful

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1578](https://leetcode.com/problems/minimum-time-to-make-rope-colorful/)

## Description

<p>Alice has <code>n</code> balloons arranged on a rope. You are given a <strong>0-indexed</strong> string <code>colors</code> where <code>colors[i]</code> is the color of the <code>i<sup>th</sup></code> balloon.</p><p>Alice wants the rope to be <strong>colorful</strong>. She does not want <strong>two consecutive balloons</strong> to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it <strong>colorful</strong>. You are given a <strong>0-indexed</strong> integer array <code>neededTime</code> where <code>neededTime[i]</code> is the time (in seconds) that Bob needs to remove the <code>i<sup>th</sup></code> balloon from the rope.</p><p>Return <em>the <strong>minimum time</strong> Bob needs to make the rope <strong>colorful</strong></em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/13/ballon1.jpg" style="width: 404px; height: 243px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
colors = "abaac", neededTime = [1,2,3,4,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/13/balloon2.jpg" style="width: 244px; height: 243px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
colors = "abc", neededTime = [1,2,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The rope is already colorful. Bob does not need to remove any balloons from the rope.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/13/balloon3.jpg" style="width: 404px; height: 243px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
colors = "aabaa", neededTime = [1,2,3,4,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Bob will remove the balloons at indices 0 and 4. Each balloons takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == colors.length == neededTime.length</code></li>
<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= neededTime[i] &lt;= 10<sup>4</sup></code></li>
<li><code>colors</code> contains only lowercase English letters.</li>
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
`dynamic programming`
`greedy`


---

<details>
  <summary>Hint 1</summary>
  Maintain the running sum and max value for repeated letters.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-03, Mon 03 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )