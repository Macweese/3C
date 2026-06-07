[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3742. Maximum Path Score in a Grid

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3742](https://leetcode.com/problems/maximum-path-score-in-a-grid/)

## Description

<p>You are given an <code>m x n</code> grid where each cell contains one of the values 0, 1, or 2. You are also given an integer <code>k</code>.</p><p>You start from the top-left corner <code>(0, 0)</code> and want to reach the bottom-right corner <code>(m - 1, n - 1)</code> by moving only <strong>right</strong> or <strong>down</strong>.</p><p>Each cell contributes a specific score and incurs an associated cost, according to their cell values:</p><ul>
<li>0: adds 0 to your score and costs 0.</li>
<li>1: adds 1 to your score and costs 1.</li>
<li>2: adds 2 to your score and costs 1. ​​​​​​​</li>
</ul><p>Return the <strong>maximum</strong> score achievable without exceeding a total cost of <code>k</code>, or -1 if no valid path exists.</p><p><strong>Note:</strong> If you reach the last cell but the total cost exceeds <code>k</code>, the path is invalid.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[0, 1],[2, 0]], k = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The optimal path is:</p><table style="border: 1px solid black;">
<thead>
<tr>
<th style="border: 1px solid black;">Cell</th>
<th style="border: 1px solid black;">grid[i][j]</th>
<th style="border: 1px solid black;">Score</th>
<th style="border: 1px solid black;">Total<br/>
			Score</th>
<th style="border: 1px solid black;">Cost</th>
<th style="border: 1px solid black;">Total<br/>
			Cost</th>
</tr>
</thead>
<tbody>
<tr>
<td style="border: 1px solid black;">(0, 0)</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">0</td>
</tr>
<tr>
<td style="border: 1px solid black;">(1, 0)</td>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">1</td>
<td style="border: 1px solid black;">1</td>
</tr>
<tr>
<td style="border: 1px solid black;">(1, 1)</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">1</td>
</tr>
</tbody>
</table><p>Thus, the maximum possible score is 2.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[0, 1],[1, 2]], k = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">-1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There is no path that reaches cell <code>(1, 1)</code>​​​​​​​ without exceeding cost k. Thus, the answer is -1.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= m, n &lt;= 200</code></li>
<li><code>0 &lt;= k &lt;= 10<sup>3</sup>​​​​​​​</code></li>
<li><code><sup>​​​​​​​</sup>grid[0][0] == 0</code></li>
<li><code>0 &lt;= grid[i][j] &lt;= 2</code></li>
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
  Use dynamic programming.
</details>
<details>
  <summary>Hint 2</summary>
  Let &lt;code&gt;dp[i][j][c]&lt;/code&gt; = max score at cell &lt;code&gt;(i,j)&lt;/code&gt; with total cost exactly &lt;code&gt;c&lt;/code&gt; (0 &lt;= &lt;code&gt;c&lt;/code&gt; &lt;= &lt;code&gt;k&lt;/code&gt;).
</details>
<details>
  <summary>Hint 3</summary>
  Update &lt;code&gt;dp[i][j][c]&lt;/code&gt; from &lt;code&gt;(i-1,j)&lt;/code&gt; and &lt;code&gt;(i,j-1)&lt;/code&gt; using &lt;code&gt;cost = (grid[i][j] == 0 ? 0 : 1)&lt;/code&gt; and &lt;code&gt;score = grid[i][j]&lt;/code&gt;.
</details>
<details>
  <summary>Hint 4</summary>
  Answer = &lt;code&gt;max(dp[m-1][n-1][c])&lt;/code&gt; for &lt;code&gt;c=0..k&lt;/code&gt;, or &lt;code&gt;-1&lt;/code&gt; if none.
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

`2026-04-30, Thu 30 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )