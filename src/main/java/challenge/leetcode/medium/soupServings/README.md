[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 808. Soup Servings

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 808](https://leetcode.com/problems/soup-servings/)

## Description

<p>You have two soups, <strong>A</strong> and <strong>B</strong>, each starting with <code>n</code> mL. On every turn, one of the following four serving operations is chosen <em>at random</em>, each with probability <code>0.25</code> <strong>independent</strong> of all previous turns:</p><ul>
<li>pour 100 mL from type A and 0 mL from type B</li>
<li>pour 75 mL from type A and 25 mL from type B</li>
<li>pour 50 mL from type A and 50 mL from type B</li>
<li>pour 25 mL from type A and 75 mL from type B</li>
</ul><p><strong>Note:</strong></p><ul>
<li>There is no operation that pours 0 mL from A and 100 mL from B.</li>
<li>The amounts from A and B are poured <em>simultaneously</em> during the turn.</li>
<li>If an operation asks you to pour <strong>more than</strong> you have left of a soup, pour all that remains of that soup.</li>
</ul><p>The process stops immediately after any turn in which <em>one of the soups</em> is used up.</p><p>Return the probability that A is used up <em>before</em> B, plus half the probability that both soups are used up in the<strong> same turn</strong>. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 50
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0.62500
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
If we perform either of the first two serving operations, soup A will become empty first.
If we perform the third operation, A and B will become empty at the same time.
If we perform the fourth operation, B will become empty first.
So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 100
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0.71875
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
If we perform the first serving operation, soup A will become empty first.
If we perform the second serving operations, A will become empty on performing operation [1, 2, 3], and both A and B become empty on performing operation 4.
If we perform the third operation, A will become empty on performing operation [1, 2], and both A and B become empty on performing operation 3.
If we perform the fourth operation, A will become empty on performing operation 1, and both A and B become empty on performing operation 2.
So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.71875.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li>
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
`probability and statistics`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  For large &lt;code&gt;n&lt;/code&gt;, the answer approaches a constant value.
</details>
<details>
  <summary>Hint 2</summary>
  Which soup is more likely to deplete first if we are allowed to perform many operations without bias?
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


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )