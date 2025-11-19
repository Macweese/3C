[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1981. Minimize the Difference Between Target and Chosen Elements

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1981](https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>mat</code> and an integer <code>target</code>.</p><p>Choose one integer from <strong>each row</strong> in the matrix such that the <strong>absolute difference</strong> between <code>target</code> and the <strong>sum</strong> of the chosen elements is <strong>minimized</strong>.</p><p>Return <em>the <strong>minimum absolute difference</strong></em>.</p><p>The <strong>absolute difference</strong> between two numbers <code>a</code> and <code>b</code> is the absolute value of <code>a - b</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/08/03/matrix1.png" style="width: 181px; height: 181px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One possible choice is to:
- Choose 1 from the first row.
- Choose 5 from the second row.
- Choose 7 from the third row.
The sum of the chosen elements is 13, which equals the target, so the absolute difference is 0.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/08/03/matrix1-1.png" style="width: 61px; height: 181px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
mat = [[1],[2],[3]], target = 100
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
94
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The best possible choice is to:
- Choose 1 from the first row.
- Choose 2 from the second row.
- Choose 3 from the third row.
The sum of the chosen elements is 6, and the absolute difference is 94.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/08/03/matrix1-3.png" style="width: 301px; height: 61px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
mat = [[1,2,9,8,7]], target = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The best choice is to choose 7 from the first row.
The absolute difference is 1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == mat.length</code></li>
<li><code>n == mat[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 70</code></li>
<li><code>1 &lt;= mat[i][j] &lt;= 70</code></li>
<li><code>1 &lt;= target &lt;= 800</code></li>
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
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  The sum of chosen elements will not be too large. Consider using a hash set to record all possible sums while iterating each row.
</details>
<details>
  <summary>Hint 2</summary>
  Instead of keeping track of all possible sums, since in each row, we are adding positive numbers, only keep those that can be a candidate, not exceeding the target by too much.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [416 Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [1755 Closest Subsequence Sum](https://leetcode.com/problems/closest-subsequence-sum/)
* [1937 Maximum Number of Points with Cost](https://leetcode.com/problems/maximum-number-of-points-with-cost/)


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