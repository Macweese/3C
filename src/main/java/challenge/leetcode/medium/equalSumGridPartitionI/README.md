[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3546. Equal Sum Grid Partition I

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3546](https://leetcode.com/problems/equal-sum-grid-partition-i/)

## Description

<p>You are given an <code>m x n</code> matrix <code>grid</code> of positive integers. Your task is to determine if it is possible to make <strong>either one horizontal or one vertical cut</strong> on the grid such that:</p><ul>
<li>Each of the two resulting sections formed by the cut is <strong>non-empty</strong>.</li>
<li>The sum of the elements in both sections is <strong>equal</strong>.</li>
</ul><p>Return <code>true</code> if such a partition exists; otherwise return <code>false</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.png" style="width: 200px;"/>

<img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.jpeg" style="width: 200px; height: 200px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,4],[2,3]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.png" style="width: 200px;"/><img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.jpeg" style="width: 200px; height: 200px;"/></p><p>A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5. Thus, the answer is <code>true</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">grid = [[1,3],[2,4]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>No horizontal or vertical cut results in two non-empty sections with equal sums. Thus, the answer is <code>false</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= m == grid.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= n == grid[i].length &lt;= 10<sup>5</sup></code></li>
<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`matrix`
`enumeration`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  There are two types of cuts: a &lt;code&gt;horizontal&lt;/code&gt; cut or a &lt;code&gt;vertical&lt;/code&gt; cut.
</details>
<details>
  <summary>Hint 2</summary>
  For a &lt;code&gt;horizontal&lt;/code&gt; cut at row &lt;code&gt;r&lt;/code&gt; (0 &lt;= r &lt;m - 1), split &lt;code&gt;grid&lt;/code&gt; into rows 0...r vs. r+1...m-1 and compare their sums.
</details>
<details>
  <summary>Hint 3</summary>
  For a &lt;code&gt;vertical&lt;/code&gt; cut at column &lt;code&gt;c&lt;/code&gt; (0 &lt;= c &lt; n - 1), split &lt;code&gt;grid&lt;/code&gt; into columns 0...c vs. c+1...n-1 and compare their sums.
</details>
<details>
  <summary>Hint 4</summary>
  Brute‑force all possible &lt;code&gt;r&lt;/code&gt; and &lt;code&gt;c&lt;/code&gt; cuts; if any yields equal section sums, return &lt;code&gt;true&lt;/code&gt;.
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

`2026-03-25, Wed 25 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)

```txt
CASE A:						CASE B:			
	┌─┬─┐		┌─┬─┬─┬─┐			┌─┬─┐		
	│1│4│		│1│2│5│0│			│1│2│		
	├─┼─┤		├─┼─┼─┼─┤			├─┼─┤		
	│2│3│		│4│3│0│1│			│4│3│		
	└─┴─┘		└─┴─┴─┴─┘			└─┴─┘		
	┌─┬─┐		┌─┬─┬─┬─┐			┌─┐ ┌─┐		
	│1│4│=5		│1│2│5│0│=8			│1│ │2│		
	└─┴─┘		└─┴─┴─┴─┘			├─┤ ├─┤		
	┌─┬─┐		┌─┬─┬─┬─┐			│4│ │3│		
	│2│3│=5		│4│3│0│1│=8			└─┘ └─┘		
	└─┴─┘		└─┴─┴─┴─┘			=5  =5		
```

[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )