[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 679. 24 Game

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 679](https://leetcode.com/problems/24-game/)

## Description

<p>You are given an integer array <code>cards</code> of length <code>4</code>. You have four cards, each containing a number in the range <code>[1, 9]</code>. You should arrange the numbers on these cards in a mathematical expression using the operators <code>['+', '-', '*', '/']</code> and the parentheses <code>'('</code> and <code>')'</code> to get the value 24.</p><p>You are restricted with the following rules:</p><ul>
<li>The division operator <code>'/'</code> represents real division, not integer division.

	<ul>
<li>For example, <code>4 / (1 - 2 / 3) = 4 / (1 / 3) = 12</code>.</li>
</ul>
</li>
<li>Every operation done is between two numbers. In particular, we cannot use <code>'-'</code> as a unary operator.
	<ul>
<li>For example, if <code>cards = [1, 1, 1, 1]</code>, the expression <code>"-1 - 1 - 1 - 1"</code> is <strong>not allowed</strong>.</li>
</ul>
</li>
<li>You cannot concatenate numbers together
	<ul>
<li>For example, if <code>cards = [1, 2, 1, 2]</code>, the expression <code>"12 + 12"</code> is not valid.</li>
</ul>
</li>
</ul><p>Return <code>true</code> if you can get such expression that evaluates to <code>24</code>, and <code>false</code> otherwise.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
cards = [4,1,8,7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
(8-4) * (7-1) = 24
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
cards = [1,2,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>cards.length == 4</code></li>
<li><code>1 &lt;= cards[i] &lt;= 9</code></li>
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
`math`
`backtracking`


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