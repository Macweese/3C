[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2523. Closest Prime Numbers in Range

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2523](https://leetcode.com/problems/closest-prime-numbers-in-range/)

## Description

<p>Given two positive integers <code>left</code> and <code>right</code>, find the two integers <code>num1</code> and <code>num2</code> such that:</p><ul>
<li><code>left &lt;= num1 &lt; num2 &lt;= right </code>.</li>
<li>Both <code>num1</code> and <code>num2</code> are <span data-keyword="prime-number">prime numbers</span>.</li>
<li><code>num2 - num1</code> is the <strong>minimum</strong> amongst all other pairs satisfying the above conditions.</li>
</ul><p>Return the positive integer array <code>ans = [num1, num2]</code>. If there are multiple pairs satisfying these conditions, return the one with the <strong>smallest</strong> <code>num1</code> value. If no such numbers exist, return <code>[-1, -1]</code><em>.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
left = 10, right = 19
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[11,13]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
left = 4, right = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[-1,-1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There exists only one prime number in the given range, so the conditions cannot be satisfied.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= left &lt;= right &lt;= 10<sup>6</sup></code></li>
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
`number theory`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use Sieve of Eratosthenes to mark numbers that are primes.
</details>
<details>
  <summary>Hint 2</summary>
  Iterate from right to left and find pair with the minimum distance between marked numbers.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1735 Count Ways to Make Array With Product](https://leetcode.com/problems/count-ways-to-make-array-with-product/)


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