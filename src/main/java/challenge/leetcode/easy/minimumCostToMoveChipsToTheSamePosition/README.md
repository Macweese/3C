[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1217. Minimum Cost to Move Chips to The Same Position

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1217](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/)

## Description

<p>We have <code>n</code> chips, where the position of the <code>i<sup>th</sup></code> chip is <code>position[i]</code>.</p><p>We need to move all the chips to <strong>the same position</strong>. In one step, we can change the position of the <code>i<sup>th</sup></code> chip from <code>position[i]</code> to:</p><ul>
<li><code>position[i] + 2</code> or <code>position[i] - 2</code> with <code>cost = 0</code>.</li>
<li><code>position[i] + 1</code> or <code>position[i] - 1</code> with <code>cost = 1</code>.</li>
</ul><p>Return <em>the minimum cost</em> needed to move all the chips to the same position.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/08/15/chips_e1.jpg" style="width: 750px; height: 217px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
position = [1,2,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/08/15/chip_e2.jpg" style="width: 750px; height: 306px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
position = [2,2,2,3,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
position = [1,1000000000]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= position.length &lt;= 100</code></li>
<li><code>1 &lt;= position[i] &lt;= 10^9</code></li>
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
`math`
`greedy`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  The first move keeps the parity of the element as it is.
</details>
<details>
  <summary>Hint 2</summary>
  The second move changes the parity of the element.
</details>
<details>
  <summary>Hint 3</summary>
  Since the first move is free, if all the numbers have the same parity, the answer would be zero.
</details>
<details>
  <summary>Hint 4</summary>
  Find the minimum cost to make all the numbers have the same parity.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1769 Minimum Number of Operations to Move All Balls to Each Box](https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/)
* [2578 Split With Minimum Sum](https://leetcode.com/problems/split-with-minimum-sum/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )