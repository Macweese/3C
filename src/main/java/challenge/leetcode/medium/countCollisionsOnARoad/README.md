[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2211. Count Collisions on a Road

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2211](https://leetcode.com/problems/count-collisions-on-a-road/)

## Description

<p>There are <code>n</code> cars on an infinitely long road. The cars are numbered from <code>0</code> to <code>n - 1</code> from left to right and each car is present at a <strong>unique</strong> point.</p><p>You are given a <strong>0-indexed</strong> string <code>directions</code> of length <code>n</code>. <code>directions[i]</code> can be either <code>'L'</code>, <code>'R'</code>, or <code>'S'</code> denoting whether the <code>i<sup>th</sup></code> car is moving towards the <strong>left</strong>, towards the <strong>right</strong>, or <strong>staying</strong> at its current point respectively. Each moving car has the <strong>same speed</strong>.</p><p>The number of collisions can be calculated as follows:</p><ul>
<li>When two cars moving in <strong>opposite</strong> directions collide with each other, the number of collisions increases by <code>2</code>.</li>
<li>When a moving car collides with a stationary car, the number of collisions increases by <code>1</code>.</li>
</ul><p>After a collision, the cars involved can no longer move and will stay at the point where they collided. Other than that, cars cannot change their state or direction of motion.</p><p>Return <em>the <strong>total number of collisions</strong> that will happen on the road</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
directions = "RLRSLL"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The collisions that will happen on the road are:
- Cars 0 and 1 will collide with each other. Since they are moving in opposite directions, the number of collisions becomes 0 + 2 = 2.
- Cars 2 and 3 will collide with each other. Since car 3 is stationary, the number of collisions becomes 2 + 1 = 3.
- Cars 3 and 4 will collide with each other. Since car 3 is stationary, the number of collisions becomes 3 + 1 = 4.
- Cars 4 and 5 will collide with each other. After car 4 collides with car 3, it will stay at the point of collision and get hit by car 5. The number of collisions becomes 4 + 1 = 5.
Thus, the total number of collisions that will happen on the road is 5.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
directions = "LLRR"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
No cars will collide with each other. Thus, the total number of collisions that will happen on the road is 0.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= directions.length &lt;= 10<sup>5</sup></code></li>
<li><code>directions[i]</code> is either <code>'L'</code>, <code>'R'</code>, or <code>'S'</code>.</li>
</ul>

<br>

## Solution

### Intuition

<!-- Optional: add your own thoughts after reading the description -->

### Approach

<!-- Optional: sketch your plan -->

### Complexity analysis

#### Time Complexity

<!-- e.g., O(n log n) -->

#### Space Complexity

<!-- e.g., O(n) -->

---

### Code

```
// AC here
```

---

<br>

#### Tags

`string`
`stack`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  In what circumstances does a moving car not collide with another car?
</details>
<details>
  <summary>Hint 2</summary>
  If we disregard the moving cars that do not collide with another car, what does each moving car contribute to the answer?
</details>
<details>
  <summary>Hint 3</summary>
  Will stationary cars contribute towards the answer?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [735 Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)
* [853 Car Fleet](https://leetcode.com/problems/car-fleet/)
* [1503 Last Moment Before All Ants Fall Out of a Plank](https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/)
* [1776 Car Fleet II](https://leetcode.com/problems/car-fleet-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-04, Thu 04 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )