[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3461. Check If Digits Are Equal in String After Operations I

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3461](https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/)

## Description

<p>You are given a string <code>s</code> consisting of digits. Perform the following operation repeatedly until the string has <strong>exactly</strong> two digits:</p><ul>
<li>For each pair of consecutive digits in <code>s</code>, starting from the first digit, calculate a new digit as the sum of the two digits <strong>modulo</strong> 10.</li>
<li>Replace <code>s</code> with the sequence of newly calculated digits, <em>maintaining the order</em> in which they are computed.</li>
</ul><p>Return <code>true</code> if the final two digits in <code>s</code> are the <strong>same</strong>; otherwise, return <code>false</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "3902"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Initially, <code>s = "3902"</code></li>
<li>First operation:
	<ul>
<li><code>(s[0] + s[1]) % 10 = (3 + 9) % 10 = 2</code></li>
<li><code>(s[1] + s[2]) % 10 = (9 + 0) % 10 = 9</code></li>
<li><code>(s[2] + s[3]) % 10 = (0 + 2) % 10 = 2</code></li>
<li><code>s</code> becomes <code>"292"</code></li>
</ul>
</li>
<li>Second operation:
	<ul>
<li><code>(s[0] + s[1]) % 10 = (2 + 9) % 10 = 1</code></li>
<li><code>(s[1] + s[2]) % 10 = (9 + 2) % 10 = 1</code></li>
<li><code>s</code> becomes <code>"11"</code></li>
</ul>
</li>
<li>Since the digits in <code>"11"</code> are the same, the output is <code>true</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "34789"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Initially, <code>s = "34789"</code>.</li>
<li>After the first operation, <code>s = "7157"</code>.</li>
<li>After the second operation, <code>s = "862"</code>.</li>
<li>After the third operation, <code>s = "48"</code>.</li>
<li>Since <code>'4' != '8'</code>, the output is <code>false</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>3 &lt;= s.length &lt;= 100</code></li>
<li><code>s</code> consists of only digits.</li>
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
`string`
`simulation`
`combinatorics`
`number theory`


---

<details>
  <summary>Hint 1</summary>
  Simulate the operations as described.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-23, Thu 23 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )