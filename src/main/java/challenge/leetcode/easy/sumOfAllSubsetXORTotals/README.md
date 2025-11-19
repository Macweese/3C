[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1863. Sum of All Subset XOR Totals

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1863](https://leetcode.com/problems/sum-of-all-subset-xor-totals/)

## Description

<p>The <strong>XOR total</strong> of an array is defined as the bitwise <code>XOR</code> of<strong> all its elements</strong>, or <code>0</code> if the array is<strong> empty</strong>.</p><ul>
<li>For example, the <strong>XOR total</strong> of the array <code>[2,5,6]</code> is <code>2 XOR 5 XOR 6 = 1</code>.</li>
</ul><p>Given an array <code>nums</code>, return <em>the <strong>sum</strong> of all <strong>XOR totals</strong> for every <strong>subset</strong> of </em><code>nums</code>. </p><p><strong>Note:</strong> Subsets with the <strong>same</strong> elements should be counted <strong>multiple</strong> times.</p><p>An array <code>a</code> is a <strong>subset</strong> of an array <code>b</code> if <code>a</code> can be obtained from <code>b</code> by deleting some (possibly zero) elements of <code>b</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 = 6
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [5,1,6]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
28
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The 8 subsets of [5,1,6] are:
- The empty subset has an XOR total of 0.
- [5] has an XOR total of 5.
- [1] has an XOR total of 1.
- [6] has an XOR total of 6.
- [5,1] has an XOR total of 5 XOR 1 = 4.
- [5,6] has an XOR total of 5 XOR 6 = 3.
- [1,6] has an XOR total of 1 XOR 6 = 7.
- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,4,5,6,7,8]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
480
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The sum of all XOR totals for every subset is 480.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 12</code></li>
<li><code>1 &lt;= nums[i] &lt;= 20</code></li>
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
`bit manipulation`
`combinatorics`
`enumeration`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Is there a way to iterate through all the subsets of the array?
</details>
<details>
  <summary>Hint 2</summary>
  Can we use recursion to efficiently iterate through all the subsets?
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