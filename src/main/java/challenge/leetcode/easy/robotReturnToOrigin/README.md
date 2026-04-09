[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 657. Robot Return to Origin

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 657](https://leetcode.com/problems/robot-return-to-origin/)

## Description

<p>There is a robot starting at the position <code>(0, 0)</code>, the origin, on a 2D plane. Given a sequence of its moves, judge if this robot <strong>ends up at </strong><code>(0, 0)</code> after it completes its moves.</p><p>You are given a string <code>moves</code> that represents the move sequence of the robot where <code>moves[i]</code> represents its <code>i<sup>th</sup></code> move. Valid moves are <code>'R'</code> (right), <code>'L'</code> (left), <code>'U'</code> (up), and <code>'D'</code> (down).</p><p>Return <code>true</code><em> if the robot returns to the origin after it finishes all of its moves, or </em><code>false</code><em> otherwise</em>.</p><p><strong>Note</strong>: The way that the robot is "facing" is irrelevant. <code>'R'</code> will always make the robot move to the right once, <code>'L'</code> will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
moves = "UD"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
moves = "LL"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= moves.length &lt;= 2 * 10<sup>4</sup></code></li>
<li><code>moves</code> only contains the characters <code>'U'</code>, <code>'D'</code>, <code>'L'</code> and <code>'R'</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`string`
`simulation`


---

**Hints**
<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* [547 Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
* [2120 Execution of All Suffix Instructions Staying in a Grid](https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/)
* [2833 Furthest Point From Origin](https://leetcode.com/problems/furthest-point-from-origin/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-05, Sun 05 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )