[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 874. Walking Robot Simulation

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 874](https://leetcode.com/problems/walking-robot-simulation/)

## Description

<p>A robot on an infinite XY-plane starts at point <code>(0, 0)</code> facing north. The robot receives an array of integers <code>commands</code>, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:</p><ul>
<li><code>-2</code>: Turn left <code>90</code> degrees.</li>
<li><code>-1</code>: Turn right <code>90</code> degrees.</li>
<li><code>1 &lt;= k &lt;= 9</code>: Move forward <code>k</code> units, one unit at a time.</li>
</ul><p>Some of the grid squares are <code>obstacles</code>. The <code>i<sup>th</sup></code> obstacle is at grid point <code>obstacles[i] = (x<sub>i</sub>, y<sub>i</sub>)</code>. If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.</p><p>Return the <strong>maximum squared Euclidean distance</strong> that the robot reaches at any point in its path (i.e. if the distance is <code>5</code>, return <code>25</code>).</p><p><strong>Note:</strong></p><ul>
<li>There can be an obstacle at <code>(0, 0)</code>. If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to <code>(0, 0)</code> due to the obstacle.</li>
<li>North means +Y direction.</li>
<li>East means +X direction.</li>
<li>South means -Y direction.</li>
<li>West means -X direction.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">commands = [4,-1,3], obstacles = []</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">25</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The robot starts at <code>(0, 0)</code>:</p><ol>
<li>Move north 4 units to <code>(0, 4)</code>.</li>
<li>Turn right.</li>
<li>Move east 3 units to <code>(3, 4)</code>.</li>
</ol><p>The furthest point the robot ever gets from the origin is <code>(3, 4)</code>, which squared is <code>3<sup>2</sup> + 4<sup>2 </sup>= 25</code> units away.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">commands = [4,-1,4,-2,4], obstacles = [[2,4]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">65</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The robot starts at <code>(0, 0)</code>:</p><ol>
<li>Move north 4 units to <code>(0, 4)</code>.</li>
<li>Turn right.</li>
<li>Move east 1 unit and get blocked by the obstacle at <code>(2, 4)</code>, robot is at <code>(1, 4)</code>.</li>
<li>Turn left.</li>
<li>Move north 4 units to <code>(1, 8)</code>.</li>
</ol><p>The furthest point the robot ever gets from the origin is <code>(1, 8)</code>, which squared is <code>1<sup>2</sup> + 8<sup>2</sup> = 65</code> units away.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">commands = [6,-1,-1,6], obstacles = [[0,0]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">36</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The robot starts at <code>(0, 0)</code>:</p><ol>
<li>Move north 6 units to <code>(0, 6)</code>.</li>
<li>Turn right.</li>
<li>Turn right.</li>
<li>Move south 5 units and get blocked by the obstacle at <code>(0,0)</code>, robot is at <code>(0, 1)</code>.</li>
</ol><p>The furthest point the robot ever gets from the origin is <code>(0, 6)</code>, which squared is <code>6<sup>2</sup> = 36</code> units away.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= commands.length &lt;= 10<sup>4</sup></code></li>
<li><code>commands[i]</code> is either <code>-2</code>, <code>-1</code>, or an integer in the range <code>[1, 9]</code>.</li>
<li><code>0 &lt;= obstacles.length &lt;= 10<sup>4</sup></code></li>
<li><code>-3 * 10<sup>4</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 3 * 10<sup>4</sup></code></li>
<li>The answer is guaranteed to be less than <code>2<sup>31</sup></code>.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`simulation`


---

**Hints**
<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* [2069 Walking Robot Simulation II](https://leetcode.com/problems/walking-robot-simulation-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-06, Mon 06 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )