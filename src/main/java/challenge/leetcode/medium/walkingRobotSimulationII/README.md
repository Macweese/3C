[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2069. Walking Robot Simulation II

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2069](https://leetcode.com/problems/walking-robot-simulation-ii/)

## Description

<p>A <code>width x height</code> grid is on an XY-plane with the <strong>bottom-left</strong> cell at <code>(0, 0)</code> and the <strong>top-right</strong> cell at <code>(width - 1, height - 1)</code>. The grid is aligned with the four cardinal directions (<code>"North"</code>, <code>"East"</code>, <code>"South"</code>, and <code>"West"</code>). A robot is <strong>initially</strong> at cell <code>(0, 0)</code> facing direction <code>"East"</code>.</p><p>The robot can be instructed to move for a specific number of <strong>steps</strong>. For each step, it does the following.</p><ol>
<li>Attempts to move <strong>forward one</strong> cell in the direction it is facing.</li>
<li>If the cell the robot is <strong>moving to</strong> is <strong>out of bounds</strong>, the robot instead <strong>turns</strong> 90 degrees <strong>counterclockwise</strong> and retries the step.</li>
</ol><p>After the robot finishes moving the number of steps required, it stops and awaits the next instruction.</p><p>Implement the <code>Robot</code> class:</p><ul>
<li><code>Robot(int width, int height)</code> Initializes the <code>width x height</code> grid with the robot at <code>(0, 0)</code> facing <code>"East"</code>.</li>
<li><code>void step(int num)</code> Instructs the robot to move forward <code>num</code> steps.</li>
<li><code>int[] getPos()</code> Returns the current cell the robot is at, as an array of length 2, <code>[x, y]</code>.</li>
<li><code>String getDir()</code> Returns the current direction of the robot, <code>"North"</code>, <code>"East"</code>, <code>"South"</code>, or <code>"West"</code>.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<img alt="example-1" src="https://assets.leetcode.com/uploads/2021/10/09/example-1.png" style="width: 498px; height: 268px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"]
[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
robot.step(2);  // It moves two steps East to (2, 0), and faces East.
robot.step(2);  // It moves two steps East to (4, 0), and faces East.
robot.getPos(); // return [4, 0]
robot.getDir(); // return "East"
robot.step(2);  // It moves one step East to (5, 0), and faces East.
                // Moving the next step East would be out of bounds, so it turns and faces North.
                // Then, it moves one step North to (5, 1), and faces North.
robot.step(1);  // It moves one step North to (5, 2), and faces <strong>North</strong> (not West).
robot.step(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
                // Then, it moves four steps West to (1, 2), and faces West.
robot.getPos(); // return [1, 2]
robot.getDir(); // return "West"
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= width, height &lt;= 100</code></li>
<li><code>1 &lt;= num &lt;= 10<sup>5</sup></code></li>
<li>At most <code>10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>step</code>, <code>getPos</code>, and <code>getDir</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`design`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  The robot only moves along the perimeter of the grid. Can you think if modulus can help you quickly compute which cell it stops at?
</details>
<details>
  <summary>Hint 2</summary>
  After the robot moves one time, whenever the robot stops at some cell, it will always face a specific direction. i.e., The direction it faces is determined by the cell it stops at.
</details>
<details>
  <summary>Hint 3</summary>
  Can you precompute what direction it faces when it stops at each cell along the perimeter, and reuse the results?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [874 Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-07, Tue 07 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )