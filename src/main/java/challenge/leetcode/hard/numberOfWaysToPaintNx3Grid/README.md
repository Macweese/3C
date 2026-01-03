[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1411. Number of Ways to Paint N × 3 Grid

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1411](https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/)

## Description

<p>You have a <code>grid</code> of size <code>n x 3</code> and you want to paint each cell of the grid with exactly one of the three colors: <strong>Red</strong>, <strong>Yellow,</strong> or <strong>Green</strong> while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).</p><p>Given <code>n</code> the number of rows of the grid, return <em>the number of ways</em> you can paint this <code>grid</code>. As the answer may grow large, the answer <strong>must be</strong> computed modulo <code>10<sup>9</sup> + 7</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2020/03/26/e1.png" style="width: 400px; height: 257px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
n = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
12
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 12 possible way to paint the grid as shown.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5000
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
30228214
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == grid.length</code></li>
<li><code>1 &lt;= n &lt;= 5000</code></li>
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

`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  We will use Dynamic programming approach. we will try all possible configuration.
</details>
<details>
  <summary>Hint 2</summary>
  Let dp[idx][prev1col][prev2col][prev3col] be the number of ways to color the rows of the grid from idx to n-1 keeping in mind that the previous row (idx - 1) has colors prev1col, prev2col and prev3col. Build the dp array to get the answer.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1931 Painting a Grid With Three Different Colors](https://leetcode.com/problems/painting-a-grid-with-three-different-colors/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-01-03, Sat 03 January 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )