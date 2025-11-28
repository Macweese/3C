[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2435. Paths in Matrix Whose Sum Is Divisible by K

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2435](https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/)

## Description

<p>You are given a <strong>0-indexed</strong> <code>m x n</code> integer matrix <code>grid</code> and an integer <code>k</code>. You are currently at position <code>(0, 0)</code> and you want to reach position <code>(m - 1, n - 1)</code> moving only <strong>down</strong> or <strong>right</strong>.</p><p>Return<em> the number of paths where the sum of the elements on the path is divisible by </em><code>k</code>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img src="https://assets.leetcode.com/uploads/2022/08/13/image-20220813183124-1.png" style="width: 437px; height: 200px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are two paths where the sum of the elements on the path is divisible by k.
The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img src="https://assets.leetcode.com/uploads/2022/08/17/image-20220817112930-3.png" style="height: 85px; width: 132px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[0,0]], k = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The path highlighted in red has a sum of 0 + 0 = 0 which is divisible by 5.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<img src="https://assets.leetcode.com/uploads/2022/08/12/image-20220812224605-3.png" style="width: 257px; height: 200px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
10
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Every integer is divisible by 1 so the sum of the elements on every possible path is divisible by k.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == grid.length</code></li>
<li><code>n == grid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>1 &lt;= m * n &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>0 &lt;= grid[i][j] &lt;= 100</code></li>
<li><code>1 &lt;= k &lt;= 50</code></li>
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
  The actual numbers in grid do not matter. What matters are the remainders you get when you divide the numbers by k.
</details>
<details>
  <summary>Hint 2</summary>
  We can use dynamic programming to solve this problem. What can we use as states?
</details>
<details>
  <summary>Hint 3</summary>
  Let dp[i][j][value] represent the number of paths where the sum of the elements on the path has a remainder of value when divided by k.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [62 Unique Paths](https://leetcode.com/problems/unique-paths/)
* [63 Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)
* [64 Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
* [174 Dungeon Game](https://leetcode.com/problems/dungeon-game/)
* [741 Cherry Pickup](https://leetcode.com/problems/cherry-pickup/)
* [1091 Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
* [2087 Minimum Cost Homecoming of a Robot in a Grid](https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/)
* [2510 Check if There is a Path With Equal Number of 0&#39;s And 1&#39;s](https://leetcode.com/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-11-26, Wed 26 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )