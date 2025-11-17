[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2169. Count Operations to Obtain Zero

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2169](https://leetcode.com/problems/count-operations-to-obtain-zero/)

## Description

<p>You are given two <strong>non-negative</strong> integers <code>num1</code> and <code>num2</code>.</p><p>In one <strong>operation</strong>, if <code>num1 &gt;= num2</code>, you must subtract <code>num2</code> from <code>num1</code>, otherwise subtract <code>num1</code> from <code>num2</code>.</p><ul>
<li>For example, if <code>num1 = 5</code> and <code>num2 = 4</code>, subtract <code>num2</code> from <code>num1</code>, thus obtaining <code>num1 = 1</code> and <code>num2 = 4</code>. However, if <code>num1 = 4</code> and <code>num2 = 5</code>, after one operation, <code>num1 = 4</code> and <code>num2 = 1</code>.</li>
</ul><p>Return <em>the <strong>number of operations</strong> required to make either</em> <code>num1 = 0</code> <em>or</em> <code>num2 = 0</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num1 = 2, num2 = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- Operation 1: num1 = 2, num2 = 3. Since num1 &lt; num2, we subtract num1 from num2 and get num1 = 2, num2 = 3 - 2 = 1.
- Operation 2: num1 = 2, num2 = 1. Since num1 &gt; num2, we subtract num2 from num1.
- Operation 3: num1 = 1, num2 = 1. Since num1 == num2, we subtract num2 from num1.
Now num1 = 0 and num2 = 1. Since num1 == 0, we do not need to perform any further operations.
So the total number of operations required is 3.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num1 = 10, num2 = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- Operation 1: num1 = 10, num2 = 10. Since num1 == num2, we subtract num2 from num1 and get num1 = 10 - 10 = 0.
Now num1 = 0 and num2 = 10. Since num1 == 0, we are done.
So the total number of operations required is 1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= num1, num2 &lt;= 10<sup>5</sup></code></li>
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
`simulation`


---

<details>
  <summary>Hint 1</summary>
  Try simulating the process until either of the two integers is zero.
</details>
<details>
  <summary>Hint 2</summary>
  Count the number of operations done.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1342 Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-09, Sun 09 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )