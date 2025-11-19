[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1512. Number of Good Pairs

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1512](https://leetcode.com/problems/number-of-good-pairs/)

## Description

<p>Given an array of integers <code>nums</code>, return <em>the number of <strong>good pairs</strong></em>.</p><p>A pair <code>(i, j)</code> is called <em>good</em> if <code>nums[i] == nums[j]</code> and <code>i</code> &lt; <code>j</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,1,1,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,1,1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Each pair in the array are <em>good</em>.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 100</code></li>
<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
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
`math`
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Count how many times each number appears. If a number appears n times, then n * (n – 1) // 2 good pairs can be made with this number.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2001 Number of Pairs of Interchangeable Rectangles](https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/)
* [2083 Substrings That Begin and End With the Same Letter](https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/)


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