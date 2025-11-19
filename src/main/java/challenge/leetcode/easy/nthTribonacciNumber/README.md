[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1137. N-th Tribonacci Number

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1137](https://leetcode.com/problems/n-th-tribonacci-number/)

## Description

<p>The Tribonacci sequence T<sub>n</sub> is defined as follows: </p><p>T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, and T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub> for n &gt;= 0.</p><p>Given <code>n</code>, return the value of T<sub>n</sub>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 25
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1389537
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= n &lt;= 37</code></li>
<li>The answer is guaranteed to fit within a 32-bit integer, ie. <code>answer &lt;= 2^31 - 1</code>.</li>
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
`dynamic programming`
`memoization`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Make an array F of length 38, and set F[0] = 0, F[1] = F[2] = 1.
</details>
<details>
  <summary>Hint 2</summary>
  Now write a loop where you set F[n+3] = F[n] + F[n+1] + F[n+2], and return F[n].
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [70 Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
* [509 Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)


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