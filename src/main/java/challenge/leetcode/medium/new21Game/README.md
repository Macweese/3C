[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 837. New 21 Game

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 837](https://leetcode.com/problems/new-21-game/)

## Description

<p>Alice plays the following game, loosely based on the card game <strong>"21"</strong>.</p><p>Alice starts with <code>0</code> points and draws numbers while she has less than <code>k</code> points. During each draw, she gains an integer number of points randomly from the range <code>[1, maxPts]</code>, where <code>maxPts</code> is an integer. Each draw is independent and the outcomes have equal probabilities.</p><p>Alice stops drawing numbers when she gets <code>k</code> <strong>or more points</strong>.</p><p>Return the probability that Alice has <code>n</code> or fewer points.</p><p>Answers within <code>10<sup>-5</sup></code> of the actual answer are considered accepted.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 10, k = 1, maxPts = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1.00000
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Alice gets a single card, then stops.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 6, k = 1, maxPts = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0.60000
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Alice gets a single card, then stops.
In 6 out of 10 possibilities, she is at or below 6 points.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 21, k = 17, maxPts = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0.73278
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li>
<li><code>1 &lt;= maxPts &lt;= 10<sup>4</sup></code></li>
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

`math`
`dynamic programming`
`sliding window`
`probability and statistics`


---

**Hints**
<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )