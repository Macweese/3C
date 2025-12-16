[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2147. Number of Ways to Divide a Long Corridor

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2147](https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/)

## Description

<p>Along a long library corridor, there is a line of seats and decorative plants. You are given a <strong>0-indexed</strong> string <code>corridor</code> of length <code>n</code> consisting of letters <code>'S'</code> and <code>'P'</code> where each <code>'S'</code> represents a seat and each <code>'P'</code> represents a plant.</p><p>One room divider has <strong>already</strong> been installed to the left of index <code>0</code>, and <strong>another</strong> to the right of index <code>n - 1</code>. Additional room dividers can be installed. For each position between indices <code>i - 1</code> and <code>i</code> (<code>1 &lt;= i &lt;= n - 1</code>), at most one divider can be installed.</p><p>Divide the corridor into non-overlapping sections, where each section has <strong>exactly two seats</strong> with any number of plants. There may be multiple ways to perform the division. Two ways are <strong>different</strong> if there is a position with a room divider installed in the first way but not in the second way.</p><p>Return <em>the number of ways to divide the corridor</em>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>. If there is no way, return <code>0</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/04/1.png" style="width: 410px; height: 199px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
corridor = "SSPPSPS"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 3 different ways to divide the corridor.
The black bars in the above image indicate the two room dividers already installed.
Note that in each of the ways, <strong>each</strong> section has exactly <strong>two</strong> seats.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/04/2.png" style="width: 357px; height: 68px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
corridor = "PPSPSP"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There is only 1 way to divide the corridor, by not installing any additional dividers.
Installing any would create some section that does not have exactly two seats.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/12/3.png" style="width: 115px; height: 68px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
corridor = "S"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There is no way to divide the corridor because there will always be a section that does not have exactly two seats.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == corridor.length</code></li>
<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>corridor[i]</code> is either <code>'S'</code> or <code>'P'</code>.</li>
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

`math`
`string`
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Divide the corridor into segments. Each segment has two seats, starts precisely with one seat, and ends precisely with the other seat.
</details>
<details>
  <summary>Hint 2</summary>
  How many dividers can you install between two adjacent segments? You must install precisely one. Otherwise, you would have created a section with not exactly two seats.
</details>
<details>
  <summary>Hint 3</summary>
  If there are k plants between two adjacent segments, there are k + 1 positions (ways) you could install the divider you must install.
</details>
<details>
  <summary>Hint 4</summary>
  The problem now becomes: Find the product of all possible positions between every two adjacent segments.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [639 Decode Ways II](https://leetcode.com/problems/decode-ways-ii/)
* [1547 Minimum Cost to Cut a Stick](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/)
* [1712 Ways to Split Array Into Three Subarrays](https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-14, Sun 14 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )