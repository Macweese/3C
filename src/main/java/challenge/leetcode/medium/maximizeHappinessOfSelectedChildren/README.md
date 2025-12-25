[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3075. Maximize Happiness of Selected Children

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3075](https://leetcode.com/problems/maximize-happiness-of-selected-children/)

## Description

<p>You are given an array <code>happiness</code> of length <code>n</code>, and a <strong>positive</strong> integer <code>k</code>.</p><p>There are <code>n</code> children standing in a queue, where the <code>i<sup>th</sup></code> child has <strong>happiness value</strong> <code>happiness[i]</code>. You want to select <code>k</code> children from these <code>n</code> children in <code>k</code> turns.</p><p>In each turn, when you select a child, the <strong>happiness value</strong> of all the children that have <strong>not</strong> been selected till now decreases by <code>1</code>. Note that the happiness value <strong>cannot</strong> become negative and gets decremented <strong>only</strong> if it is positive.</p><p>Return <em>the <strong>maximum</strong> sum of the happiness values of the selected children you can achieve by selecting </em><code>k</code> <em>children</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
happiness = [1,2,3], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can pick 2 children in the following way:
- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
The sum of the happiness values of the selected children is 3 + 1 = 4.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
happiness = [1,1,1,1], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can pick 2 children in the following way:
- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
The sum of the happiness values of the selected children is 1 + 0 = 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
happiness = [2,3,4,5], k = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can pick 1 child in the following way:
- Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
The sum of the happiness values of the selected children is 5.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == happiness.length &lt;= 2 * 10<sup>5</sup></code></li>
<li><code>1 &lt;= happiness[i] &lt;= 10<sup>8</sup></code></li>
<li><code>1 &lt;= k &lt;= n</code></li>
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
  Since all the unselected numbers are decreasing at the same rate, we should greedily select &lt;code&gt;k&lt;/code&gt; largest values.
</details>
<details>
  <summary>Hint 2</summary>
  The &lt;code&gt;i&lt;sup&gt;th&lt;/code&gt; largest number (&lt;code&gt;i = 1, 2, 3,…k&lt;/code&gt;) should decrease by &lt;code&gt;(i - 1)&lt;/code&gt; when it is picked.
</details>
<details>
  <summary>Hint 3</summary>
  Add &lt;code&gt;0&lt;/code&gt; if the decreased value is negative.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2226 Maximum Candies Allocated to K Children](https://leetcode.com/problems/maximum-candies-allocated-to-k-children/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-25, Thu 25 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )