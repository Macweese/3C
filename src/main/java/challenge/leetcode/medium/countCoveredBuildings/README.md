[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3531. Count Covered Buildings

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3531](https://leetcode.com/problems/count-covered-buildings/)

## Description

<p>You are given a positive integer <code>n</code>, representing an <code>n x n</code> city. You are also given a 2D grid <code>buildings</code>, where <code>buildings[i] = [x, y]</code> denotes a <strong>unique</strong> building located at coordinates <code>[x, y]</code>.</p><p>A building is <strong>covered</strong> if there is at least one building in all <strong>four</strong> directions: left, right, above, and below.</p><p>Return the number of <strong>covered</strong> buildings.</p>

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
<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= buildings.length &lt;= 10<sup>5</sup> </code></li>
<li><code>buildings[i] = [x, y]</code></li>
<li><code>1 &lt;= x, y &lt;= n</code></li>
<li>All coordinates of <code>buildings</code> are <strong>unique</strong>.</li>
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

`array`
`hash table`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Group buildings with the same x or y value together, and sort each group.
</details>
<details>
  <summary>Hint 2</summary>
  In each sorted list, the buildings that are not at the first or last positions are covered in that direction.
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

`2025-12-11, Thu 11 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )