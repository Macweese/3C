[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3186. Maximum Total Damage With Spell Casting

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3186](https://leetcode.com/problems/maximum-total-damage-with-spell-casting/)

## Description

<p>A magician has various spells.</p><p>You are given an array <code>power</code>, where each element represents the damage of a spell. Multiple spells can have the same damage value.</p><p>It is a known fact that if a magician decides to cast a spell with a damage of <code>power[i]</code>, they <strong>cannot</strong> cast any spell with a damage of <code>power[i] - 2</code>, <code>power[i] - 1</code>, <code>power[i] + 1</code>, or <code>power[i] + 2</code>.</p><p>Each spell can be cast <strong>only once</strong>.</p><p>Return the <strong>maximum</strong> possible <em>total damage</em> that a magician can cast.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">power = [1,1,3,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">6</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">power = [7,1,6,6]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">13</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The maximum possible damage of 13 is produced by casting spells 1, 2, 3 with damage 1, 6, 6.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= power.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= power[i] &lt;= 10<sup>9</sup></code></li>
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
`two pointers`
`binary search`
`dynamic programming`
`sorting`
`counting`


---

<details>
  <summary>Hint 1</summary>
  If we ever decide to use some spell with power <code>x</code>, then we will use all spells with power &lt;code&gt;x&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  Think of dynamic programming.
</details>
<details>
  <summary>Hint 3</summary>
  &lt;code&gt;dp[i][j]&lt;/code&gt; represents the maximum damage considering up to the &lt;code&gt;i&lt;/code&gt;-th unique spell and &lt;code&gt;j&lt;/code&gt; represents the number of spells skipped (up to 3 as per constraints).
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-11, Sat 11 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )