[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3479. Fruits Into Baskets III

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3479](https://leetcode.com/problems/fruits-into-baskets-iii/)

## Description

<p>You are given two arrays of integers, <code>fruits</code> and <code>baskets</code>, each of length <code>n</code>, where <code>fruits[i]</code> represents the <strong>quantity</strong> of the <code>i<sup>th</sup></code> type of fruit, and <code>baskets[j]</code> represents the <strong>capacity</strong> of the <code>j<sup>th</sup></code> basket.</p><p>From left to right, place the fruits according to these rules:</p><ul>
<li>Each fruit type must be placed in the <strong>leftmost available basket</strong> with a capacity <strong>greater than or equal</strong> to the quantity of that fruit type.</li>
<li>Each basket can hold <b>only one</b> type of fruit.</li>
<li>If a fruit type <b>cannot be placed</b> in any basket, it remains <b>unplaced</b>.</li>
</ul><p>Return the number of fruit types that remain unplaced after all possible allocations are made.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">fruits = [4,2,5], baskets = [3,5,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>fruits[0] = 4</code> is placed in <code>baskets[1] = 5</code>.</li>
<li><code>fruits[1] = 2</code> is placed in <code>baskets[0] = 3</code>.</li>
<li><code>fruits[2] = 5</code> cannot be placed in <code>baskets[2] = 4</code>.</li>
</ul><p>Since one fruit type remains unplaced, we return 1.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">fruits = [3,6,1], baskets = [6,4,7]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>fruits[0] = 3</code> is placed in <code>baskets[0] = 6</code>.</li>
<li><code>fruits[1] = 6</code> cannot be placed in <code>baskets[1] = 4</code> (insufficient capacity) but can be placed in the next available basket, <code>baskets[2] = 7</code>.</li>
<li><code>fruits[2] = 1</code> is placed in <code>baskets[1] = 4</code>.</li>
</ul><p>Since all fruits are successfully placed, we return 0.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == fruits.length == baskets.length</code></li>
<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= fruits[i], baskets[i] &lt;= 10<sup>9</sup></code></li>
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
`binary search`
`segment tree`
`ordered set`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sort the baskets by the pair of &lt;code&gt;(basket[i], i)&lt;/code&gt; in the array.
</details>
<details>
  <summary>Hint 2</summary>
  For each fruit from left to right, use binary search to find the first index in the sorted array such that &lt;code&gt;basket[i] &gt;= fruit&lt;/code&gt;.
</details>
<details>
  <summary>Hint 3</summary>
  Use a segment tree to maintain the smallest original indices where &lt;code&gt;basket[i] &gt;= fruit&lt;/code&gt;.
</details>
<details>
  <summary>Hint 4</summary>
  When a valid index is found, set the corresponding point to infinity to mark it as used.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [3161 Block Placement Queries](https://leetcode.com/problems/block-placement-queries/)


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