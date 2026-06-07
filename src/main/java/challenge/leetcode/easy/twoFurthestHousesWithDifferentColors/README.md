[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2078. Two Furthest Houses With Different Colors

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2078](https://leetcode.com/problems/two-furthest-houses-with-different-colors/)

## Description

<p>There are <code>n</code> houses evenly lined up on the street, and each house is beautifully painted. You are given a <strong>0-indexed</strong> integer array <code>colors</code> of length <code>n</code>, where <code>colors[i]</code> represents the color of the <code>i<sup>th</sup></code> house.</p><p>Return <em>the <strong>maximum</strong> distance between <strong>two</strong> houses with <strong>different</strong> colors</em>.</p><p>The distance between the <code>i<sup>th</sup></code> and <code>j<sup>th</sup></code> houses is <code>abs(i - j)</code>, where <code>abs(x)</code> is the <strong>absolute value</strong> of <code>x</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/10/31/eg1.png" style="width: 610px; height: 84px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
colors = [<u><strong>1</strong></u>,1,1,<strong><u>6</u></strong>,1,1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the above image, color 1 is blue, and color 6 is red.
The furthest two houses with different colors are house 0 and house 3.
House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
Note that houses 3 and 6 can also produce the optimal answer.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2021/10/31/eg2.png" style="width: 426px; height: 84px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
colors = [<u><strong>1</strong></u>,8,3,8,<u><strong>3</strong></u>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the above image, color 1 is blue, color 8 is yellow, and color 3 is green.
The furthest two houses with different colors are house 0 and house 4.
House 0 has color 1, and house 4 has color 3. The distance between them is abs(0 - 4) = 4.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
colors = [<u><strong>0</strong></u>,<strong><u>1</u></strong>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The furthest two houses with different colors are house 0 and house 1.
House 0 has color 0, and house 1 has color 1. The distance between them is abs(0 - 1) = 1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == colors.length</code></li>
<li><code>2 &lt;= n &lt;= 100</code></li>
<li><code>0 &lt;= colors[i] &lt;= 100</code></li>
<li>Test data are generated such that <strong>at least</strong> two houses have different colors.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`greedy`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  The constraints are small. Can you try the combination of every two houses?
</details>
<details>
  <summary>Hint 2</summary>
  Greedily, the maximum distance will come from either the pair of the leftmost house and possibly some house on the right with a different color, or the pair of the rightmost house and possibly some house on the left with a different color.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1299 Replace Elements with Greatest Element on Right Side](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)
* [1855 Maximum Distance Between a Pair of Values](https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/)
* [2016 Maximum Difference Between Increasing Elements](https://leetcode.com/problems/maximum-difference-between-increasing-elements/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-20, Mon 20 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)


[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )