[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1018. Binary Prefix Divisible By 5

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1018](https://leetcode.com/problems/binary-prefix-divisible-by-5/)

## Description

<p>You are given a binary array <code>nums</code> (<strong>0-indexed</strong>).</p><p>We define <code>x<sub>i</sub></code> as the number whose binary representation is the subarray <code>nums[0..i]</code> (from most-significant-bit to least-significant-bit).</p><ul>
<li>For example, if <code>nums = [1,0,1]</code>, then <code>x<sub>0</sub> = 1</code>, <code>x<sub>1</sub> = 2</code>, and <code>x<sub>2</sub> = 5</code>.</li>
</ul><p>Return <em>an array of booleans </em><code>answer</code><em> where </em><code>answer[i]</code><em> is </em><code>true</code><em> if </em><code>x<sub>i</sub></code><em> is divisible by </em><code>5</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [0,1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[true,false,false]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[false,false,false]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
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
`bit manipulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If X is the first i digits of the array as a binary number, then 2X + A[i] is the first i+1 digits.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2455 Average Value of Even Numbers That Are Divisible by Three](https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/)
* [2644 Find the Maximum Divisibility Score](https://leetcode.com/problems/find-the-maximum-divisibility-score/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-11-24, Mon 24 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )