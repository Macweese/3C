[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1861. Rotating the Box

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1861](https://leetcode.com/problems/rotating-the-box/)

## Description

<p>You are given an <code>m x n</code> matrix of characters <code>boxGrid</code> representing a side-view of a box. Each cell of the box is one of the following:</p><ul>
<li>A stone <code>'#'</code></li>
<li>A stationary obstacle <code>'*'</code></li>
<li>Empty <code>'.'</code></li>
</ul><p>The box is rotated <strong>90 degrees clockwise</strong>, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity <strong>does not</strong> affect the obstacles' positions, and the inertia from the box's rotation <strong>does not </strong>affect the stones' horizontal positions.</p><p>It is <strong>guaranteed</strong> that each stone in <code>boxGrid</code> rests on an obstacle, another stone, or the bottom of the box.</p><p>Return <em>an </em><code>n x m</code><em> matrix representing the box after the rotation described above</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>m == boxGrid.length</code></li>
<li><code>n == boxGrid[i].length</code></li>
<li><code>1 &lt;= m, n &lt;= 500</code></li>
<li><code>boxGrid[i][j]</code> is either <code>'#'</code>, <code>'*'</code>, or <code>'.'</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`two pointers`
`matrix`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Rotate the box using the relation rotatedBox[i][j] = box[m - 1 - j][i].
</details>
<details>
  <summary>Hint 2</summary>
  Start iterating from the bottom of the box and for each empty cell check if there is any stone above it with no obstacles between them.
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

`2026-05-06, Wed 06 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )