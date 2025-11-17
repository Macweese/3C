[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 166. Fraction to Recurring Decimal

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 166](https://leetcode.com/problems/fraction-to-recurring-decimal/)

## Description

<p>Given two integers representing the <code>numerator</code> and <code>denominator</code> of a fraction, return <em>the fraction in string format</em>.</p><p>If the fractional part is repeating, enclose the repeating part in parentheses.</p><p>If multiple answers are possible, return <strong>any of them</strong>.</p><p>It is <strong>guaranteed</strong> that the length of the answer string is less than <code>10<sup>4</sup></code> for all the given inputs.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
numerator = 1, denominator = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"0.5"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
numerator = 2, denominator = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"2"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
numerator = 4, denominator = 333
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"0.(012)"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>-2<sup>31</sup> &lt;= numerator, denominator &lt;= 2<sup>31</sup> - 1</code></li>
<li><code>denominator != 0</code></li>
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
`string`


---

<details>
  <summary>Hint 1</summary>
  No scary math, just apply elementary math knowledge. Still remember how to perform a &lt;i&gt;long division&lt;/i&gt;?
</details>
<details>
  <summary>Hint 2</summary>
  Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
</details>
<details>
  <summary>Hint 3</summary>
  Notice that once the remainder starts repeating, so does the divided result.
</details>
<details>
  <summary>Hint 4</summary>
  Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-09-24, Wed 24 September 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )