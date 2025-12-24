[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3074. Apple Redistribution into Boxes

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3074](https://leetcode.com/problems/apple-redistribution-into-boxes/)

## Description

<p>You are given an array <code>apple</code> of size <code>n</code> and an array <code>capacity</code> of size <code>m</code>.</p><p>There are <code>n</code> packs where the <code>i<sup>th</sup></code> pack contains <code>apple[i]</code> apples. There are <code>m</code> boxes as well, and the <code>i<sup>th</sup></code> box has a capacity of <code>capacity[i]</code> apples.</p><p>Return <em>the <strong>minimum</strong> number of boxes you need to select to redistribute these </em><code>n</code><em> packs of apples into boxes</em>.</p><p><strong>Note</strong> that, apples from the same pack can be distributed into different boxes.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
apple = [1,3,2], capacity = [4,3,1,5,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
apple = [5,5,5], capacity = [2,4,2,7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We will need to use all the boxes.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == apple.length &lt;= 50</code></li>
<li><code>1 &lt;= m == capacity.length &lt;= 50</code></li>
<li><code>1 &lt;= apple[i], capacity[i] &lt;= 50</code></li>
<li>The input is generated such that it's possible to redistribute packs of apples into boxes.</li>
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
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sort array &lt;code&gt;capacity&lt;/code&gt; in non-decreasing order.
</details>
<details>
  <summary>Hint 2</summary>
  Greedily select boxes with the largest capacities to redistribute apples optimally.
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

`2025-12-24, Wed 24 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )