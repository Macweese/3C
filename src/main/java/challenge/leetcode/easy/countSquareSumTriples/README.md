[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1925. Count Square Sum Triples

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1925](https://leetcode.com/problems/count-square-sum-triples/)

## Description

<p>A <strong>square triple</strong> <code>(a,b,c)</code> is a triple where <code>a</code>, <code>b</code>, and <code>c</code> are <strong>integers</strong> and <code>a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup></code>.</p><p>Given an integer <code>n</code>, return <em>the number of <strong>square triples</strong> such that </em><code>1 &lt;= a, b, c &lt;= n</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: The square triples are (3,4,5) and (4,3,5).
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 250</code></li>
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
`enumeration`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Iterate over all possible pairs (a,b) and check that the square root of a * a + b * b is an integers less than or equal n
</details>
<details>
  <summary>Hint 2</summary>
  You can check that the square root of an integer is an integer using binary seach or a builtin function like sqrt
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2475 Number of Unequal Triplets in Array](https://leetcode.com/problems/number-of-unequal-triplets-in-array/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-08, Mon 08 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )