[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2048. Next Greater Numerically Balanced Number

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2048](https://leetcode.com/problems/next-greater-numerically-balanced-number/)

## Description

<p>An integer <code>x</code> is <strong>numerically balanced</strong> if for every digit <code>d</code> in the number <code>x</code>, there are <strong>exactly</strong> <code>d</code> occurrences of that digit in <code>x</code>.</p><p>Given an integer <code>n</code>, return <em>the <strong>smallest numerically balanced</strong> number <strong>strictly greater</strong> than </em><code>n</code><em>.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
22
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
22 is numerically balanced since:
- The digit 2 occurs 2 times. 
It is also the smallest numerically balanced number strictly greater than 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 1000
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1333
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
1333 is numerically balanced since:
- The digit 1 occurs 1 time.
- The digit 3 occurs 3 times. 
It is also the smallest numerically balanced number strictly greater than 1000.
Note that 1022 cannot be the answer because 0 appeared more than 0 times.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 3000
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3133
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
3133 is numerically balanced since:
- The digit 1 occurs 1 time.
- The digit 3 occurs 3 times.
It is also the smallest numerically balanced number strictly greater than 3000.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= n &lt;= 10<sup>6</sup></code></li>
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

`hash table`
`math`
`backtracking`
`counting`
`enumeration`


---

<details>
  <summary>Hint 1</summary>
  How far away can the next greater numerically balanced number be from n?
</details>
<details>
  <summary>Hint 2</summary>
  With the given constraints, what is the largest numerically balanced number?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2639 Find the Width of Columns of a Grid](https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-24, Fri 24 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )