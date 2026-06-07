[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2126. Destroying Asteroids

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2126](https://leetcode.com/problems/destroying-asteroids/)

## Description

<p>You are given an integer <code>mass</code>, which represents the original mass of a planet. You are further given an integer array <code>asteroids</code>, where <code>asteroids[i]</code> is the mass of the <code>i<sup>th</sup></code> asteroid.</p><p>You can arrange for the planet to collide with the asteroids in <strong>any arbitrary order</strong>. If the mass of the planet is <b>greater than or equal to</b> the mass of the asteroid, the asteroid is <strong>destroyed</strong> and the planet <strong>gains</strong> the mass of the asteroid. Otherwise, the planet is destroyed.</p><p>Return <code>true</code><em> if <strong>all</strong> asteroids can be destroyed. Otherwise, return </em><code>false</code><em>.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
mass = 10, asteroids = [3,9,19,5,21]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One way to order the asteroids is [9,19,5,3,21]:
- The planet collides with the asteroid with a mass of 9. New planet mass: 10 + 9 = 19
- The planet collides with the asteroid with a mass of 19. New planet mass: 19 + 19 = 38
- The planet collides with the asteroid with a mass of 5. New planet mass: 38 + 5 = 43
- The planet collides with the asteroid with a mass of 3. New planet mass: 43 + 3 = 46
- The planet collides with the asteroid with a mass of 21. New planet mass: 46 + 21 = 67
All asteroids are destroyed.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
mass = 5, asteroids = [4,9,23,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The planet cannot ever gain enough mass to destroy the asteroid with a mass of 23.
After the planet destroys the other asteroids, it will have a mass of 5 + 4 + 9 + 4 = 22.
This is less than 23, so a collision would not destroy the last asteroid.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= mass &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= asteroids.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= asteroids[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Choosing the asteroid to collide with can be done greedily.
</details>
<details>
  <summary>Hint 2</summary>
  If an asteroid will destroy the planet, then every bigger asteroid will also destroy the planet.
</details>
<details>
  <summary>Hint 3</summary>
  You only need to check the smallest asteroid at each collision. If it will destroy the planet, then every other asteroid will also destroy the planet.
</details>
<details>
  <summary>Hint 4</summary>
  Sort the asteroids in non-decreasing order by mass, then greedily try to collide with the asteroids in that order.
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

`2026-05-31, Sun 31 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )