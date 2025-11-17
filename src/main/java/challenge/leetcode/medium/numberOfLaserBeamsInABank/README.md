[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2125. Number of Laser Beams in a Bank

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2125](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/)

## Description

<p>Anti-theft security devices are activated inside a bank. You are given a <strong>0-indexed</strong> binary string array <code>bank</code> representing the floor plan of the bank, which is an <code>m x n</code> 2D matrix. <code>bank[i]</code> represents the <code>i<sup>th</sup></code> row, consisting of <code>'0'</code>s and <code>'1'</code>s. <code>'0'</code> means the cell is empty, while<code>'1'</code> means the cell has a security device.</p><p>There is <strong>one</strong> laser beam between any <strong>two</strong> security devices <strong>if both</strong> conditions are met:</p><ul>
<li>The two devices are located on two <strong>different rows</strong>: <code>r<sub>1</sub></code> and <code>r<sub>2</sub></code>, where <code>r<sub>1</sub> &lt; r<sub>2</sub></code>.</li>
<li>For <strong>each</strong> row <code>i</code> where <code>r<sub>1</sub> &lt; i &lt; r<sub>2</sub></code>, there are <strong>no security devices</strong> in the <code>i<sup>th</sup></code> row.</li>
</ul><p>Laser beams are independent, i.e., one beam does not interfere nor join with another.</p><p>Return <em>the total number of laser beams in the bank</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser1.jpg" style="width: 400px; height: 368px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
bank = ["011001","000000","010100","001000"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
8
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0<sup>th</sup> row with any on the 3<sup>rd</sup> row.
This is because the 2<sup>nd</sup> row contains security devices, which breaks the second condition.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser2.jpg" style="width: 244px; height: 325px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
bank = ["000","111","000"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There does not exist two devices located on two different rows.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == bank.length</code></li>
<li><code>n == bank[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 500</code></li>
<li><code>bank[i][j]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
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
`string`
`matrix`


---

<details>
  <summary>Hint 1</summary>
  What is the commonality between security devices on the same row?
</details>
<details>
  <summary>Hint 2</summary>
  Each device on the same row has the same number of beams pointing towards the devices on the next row with devices.
</details>
<details>
  <summary>Hint 3</summary>
  If you were given an integer array where each element is the number of security devices on each row, can you solve it?
</details>
<details>
  <summary>Hint 4</summary>
  Convert the input to such an array, skip any row with no security device, then find the sum of the product between adjacent elements.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [73 Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-27, Mon 27 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )