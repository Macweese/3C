[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1277. Count Square Submatrices with All Ones

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1277](https://leetcode.com/problems/count-square-submatrices-with-all-ones/)

## Description

<p>Given a <code>m * n</code> matrix of ones and zeros, return how many <strong>square</strong> submatrices have all ones.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
15
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are <strong>10</strong> squares of side 1.
There are <strong>4</strong> squares of side 2.
There is  <strong>1</strong> square of side 3.
Total number of squares = 10 + 4 + 1 = <strong>15</strong>.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are <b>6</b> squares of side 1.  
There is <strong>1</strong> square of side 2. 
Total number of squares = 6 + 1 = <b>7</b>.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr.length &lt;= 300</code></li>
<li><code>1 &lt;= arr[0].length &lt;= 300</code></li>
<li><code>0 &lt;= arr[i][j] &lt;= 1</code></li>
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
  Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
</details>
<details>
  <summary>Hint 2</summary>
  Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1 to the answer.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2087 Minimum Cost Homecoming of a Robot in a Grid](https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/)
* [2088 Count Fertile Pyramids in a Land](https://leetcode.com/problems/count-fertile-pyramids-in-a-land/)


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