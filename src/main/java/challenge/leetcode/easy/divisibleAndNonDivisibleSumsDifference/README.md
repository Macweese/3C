[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2894. Divisible and Non-divisible Sums Difference

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2894](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/)

## Description

<p>You are given positive integers <code>n</code> and <code>m</code>.</p><p>Define two integers as follows:</p><ul>
<li><code>num1</code>: The sum of all integers in the range <code>[1, n]</code> (both <strong>inclusive</strong>) that are <strong>not divisible</strong> by <code>m</code>.</li>
<li><code>num2</code>: The sum of all integers in the range <code>[1, n]</code> (both <strong>inclusive</strong>) that are <strong>divisible</strong> by <code>m</code>.</li>
</ul><p>Return <em>the integer</em> <code>num1 - num2</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 10, m = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
19
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the given example:
- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
We return 37 - 18 = 19 as the answer.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5, m = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
15
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the given example:
- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.
We return 15 - 0 = 15 as the answer.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5, m = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-15
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the given example:
- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
We return 0 - 15 = -15 as the answer.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n, m &lt;= 1000</code></li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  With arithmetic progression we know that the sum of integers in the range &lt;code&gt;[1, n]&lt;/code&gt; is &lt;code&gt;n * (n + 1) / 2 &lt;/code&gt;.
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