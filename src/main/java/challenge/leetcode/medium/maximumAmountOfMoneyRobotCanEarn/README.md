[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3418. Maximum Amount of Money Robot Can Earn

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3418](https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/)

## Description

<p>You are given an <code>m x n</code> grid. A robot starts at the top-left corner of the grid <code>(0, 0)</code> and wants to reach the bottom-right corner <code>(m - 1, n - 1)</code>. The robot can move either right or down at any point in time.</p><p>The grid contains a value <code>coins[i][j]</code> in each cell:</p><ul>
<li>If <code>coins[i][j] &gt;= 0</code>, the robot gains that many coins.</li>
<li>If <code>coins[i][j] &lt; 0</code>, the robot encounters a robber, and the robber steals the <strong>absolute</strong> value of <code>coins[i][j]</code> coins.</li>
</ul><p>The robot has a special ability to <strong>neutralize robbers</strong> in at most <strong>2 cells</strong> on its path, preventing them from stealing coins in those cells.</p><p><strong>Note:</strong> The robot's total coins can be negative.</p><p>Return the <strong>maximum</strong> profit the robot can gain on the route.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">coins = [[0,1,-1],[1,-2,3],[2,-3,4]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">8</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>An optimal path for maximum coins is:</p><ol>
<li>Start at <code>(0, 0)</code> with <code>0</code> coins (total coins = <code>0</code>).</li>
<li>Move to <code>(0, 1)</code>, gaining <code>1</code> coin (total coins = <code>0 + 1 = 1</code>).</li>
<li>Move to <code>(1, 1)</code>, where there's a robber stealing <code>2</code> coins. The robot uses one neutralization here, avoiding the robbery (total coins = <code>1</code>).</li>
<li>Move to <code>(1, 2)</code>, gaining <code>3</code> coins (total coins = <code>1 + 3 = 4</code>).</li>
<li>Move to <code>(2, 2)</code>, gaining <code>4</code> coins (total coins = <code>4 + 4 = 8</code>).</li>
</ol>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">coins = [[10,10,10],[10,10,10]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">40</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>An optimal path for maximum coins is:</p><ol>
<li>Start at <code>(0, 0)</code> with <code>10</code> coins (total coins = <code>10</code>).</li>
<li>Move to <code>(0, 1)</code>, gaining <code>10</code> coins (total coins = <code>10 + 10 = 20</code>).</li>
<li>Move to <code>(0, 2)</code>, gaining another <code>10</code> coins (total coins = <code>20 + 10 = 30</code>).</li>
<li>Move to <code>(1, 2)</code>, gaining the final <code>10</code> coins (total coins = <code>30 + 10 = 40</code>).</li>
</ol>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == coins.length</code></li>
<li><code>n == coins[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 500</code></li>
<li><code>-1000 &lt;= coins[i][j] &lt;= 1000</code></li>
</ul>

<br>

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
  Use Dynamic Programming.
</details>
<details>
  <summary>Hint 2</summary>
  Let &lt;code&gt;dp[i][j][k]&lt;/code&gt; denote the maximum amount of money a robot can earn by starting at cell &lt;code&gt;(i,j)&lt;/code&gt; and having neutralized &lt;code&gt;k&lt;/code&gt; robbers.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-02, Thu 02 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )