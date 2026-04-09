[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3661. Maximum Walls Destroyed by Robots

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3661](https://leetcode.com/problems/maximum-walls-destroyed-by-robots/)

## Description

<div data-docx-has-block-data="false" data-lark-html-role="root" data-page-id="Rax8d6clvoFeVtx7bzXcvkVynwf">
<div class="old-record-id-Y5dGdSKIMoNTttxGhHLccrpEnaf">There is an endless straight line populated with some robots and walls. You are given integer arrays <code>robots</code>, <code>distance</code>, and <code>walls</code>:</div>
</div><ul>
<li><code>robots[i]</code> is the position of the <code>i<sup>th</sup></code> robot.</li>
<li><code>distance[i]</code> is the <strong>maximum</strong> distance the <code>i<sup>th</sup></code> robot's bullet can travel.</li>
<li><code>walls[j]</code> is the position of the <code>j<sup>th</sup></code> wall.</li>
</ul><p>Every robot has <strong>one</strong> bullet that can either fire to the left or the right <strong>at most </strong><code>distance[i]</code> meters.</p><p>A bullet destroys every wall in its path that lies within its range. Robots are fixed obstacles: if a bullet hits another robot before reaching a wall, it <strong>immediately stops</strong> at that robot and cannot continue.</p><p>Return the <strong>maximum</strong> number of <strong>unique</strong> walls that can be destroyed by the robots.</p><p>Notes:</p><ul>
<li>A wall and a robot may share the same position; the wall can be destroyed by the robot at that position.</li>
<li>Robots are not destroyed by bullets.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">robots = [4], distance = [3], walls = [1,10]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>robots[0] = 4</code> fires <strong>left</strong> with <code>distance[0] = 3</code>, covering <code>[1, 4]</code> and destroys <code>walls[0] = 1</code>.</li>
<li>Thus, the answer is 1.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">robots = [10,2], distance = [5,1], walls = [5,2,7]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>robots[0] = 10</code> fires <strong>left</strong> with <code>distance[0] = 5</code>, covering <code>[5, 10]</code> and destroys <code>walls[0] = 5</code> and <code>walls[2] = 7</code>.</li>
<li><code>robots[1] = 2</code> fires <strong>left</strong> with <code>distance[1] = 1</code>, covering <code>[1, 2]</code> and destroys <code>walls[1] = 2</code>.</li>
<li>Thus, the answer is 3.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= robots.length == distance.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= walls.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= robots[i], walls[j] &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= distance[i] &lt;= 10<sup>5</sup></code></li>
<li>All values in <code>robots</code> are <strong>unique</strong></li>
<li>All values in <code>walls</code> are <strong>unique</strong></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`binary search`
`dynamic programming`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sort both the robots and walls arrays. This will help in efficiently processing positions and performing range queries.
</details>
<details>
  <summary>Hint 2</summary>
  Each robot can shoot either left or right. However, if a robot fires and another robot is in its path, the bullet stops. You need to use the positions of neighboring robots to limit the shooting range.
</details>
<details>
  <summary>Hint 3</summary>
  Use binary search (lower_bound and upper_bound) to count how many walls fall within a certain range.
</details>
<details>
  <summary>Hint 4</summary>
  You can use dynamic programming to keep track of the maximum number of walls destroyed so far, depending on the direction the previous robot shot.
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

`2026-04-03, Fri 03 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )