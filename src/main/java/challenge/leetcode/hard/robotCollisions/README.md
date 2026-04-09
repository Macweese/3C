[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2751. Robot Collisions

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2751](https://leetcode.com/problems/robot-collisions/)

## Description

<p>There are <code>n</code> <strong>1-indexed</strong> robots, each having a position on a line, health, and movement direction.</p><p>You are given <strong>0-indexed</strong> integer arrays <code>positions</code>, <code>healths</code>, and a string <code>directions</code> (<code>directions[i]</code> is either <strong>'L'</strong> for <strong>left</strong> or <strong>'R'</strong> for <strong>right</strong>). All integers in <code>positions</code> are <strong>unique</strong>.</p><p>All robots start moving on the line<strong> simultaneously</strong> at the <strong>same speed </strong>in their given directions. If two robots ever share the same position while moving, they will <strong>collide</strong>.</p><p>If two robots collide, the robot with <strong>lower health</strong> is <strong>removed</strong> from the line, and the health of the other robot <strong>decreases</strong> <strong>by one</strong>. The surviving robot continues in the <strong>same</strong> direction it was going. If both robots have the <strong>same</strong> health, they are both<strong> </strong>removed from the line.</p><p>Your task is to determine the <strong>health</strong> of the robots that survive the collisions, in the same <strong>order </strong>that the robots were given,<strong> </strong>i.e. final health of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.</p><p>Return <em>an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.</em></p><p><strong>Note:</strong> The positions may be unsorted.</p><div class="notranslate" style="all: initial;"> </div>

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
<li><code>1 &lt;= positions.length == healths.length == directions.length == n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= positions[i], healths[i] &lt;= 10<sup>9</sup></code></li>
<li><code>directions[i] == 'L'</code> or <code>directions[i] == 'R'</code></li>
<li>All values in <code>positions</code> are distinct</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`stack`
`sorting`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Process the robots in the order of their positions to ensure that we process the collisions correctly.
</details>
<details>
  <summary>Hint 2</summary>
  To optimize the solution, use a stack to keep track of the surviving robots as we iterate through the positions.
</details>
<details>
  <summary>Hint 3</summary>
  Instead of simulating each collision, check the current robot against the top of the stack (if it exists) to determine if a collision occurs.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [735 Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-01, Wed 01 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )