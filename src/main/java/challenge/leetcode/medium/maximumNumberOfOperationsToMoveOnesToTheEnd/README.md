[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3228. Maximum Number of Operations to Move Ones to the End

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3228](https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/)

## Description

<p>You are given a <span data-keyword="binary-string">binary string</span> <code>s</code>.</p><p>You can perform the following operation on the string <strong>any</strong> number of times:</p><ul>
<li>Choose <strong>any</strong> index <code>i</code> from the string where <code>i + 1 &lt; s.length</code> such that <code>s[i] == '1'</code> and <code>s[i + 1] == '0'</code>.</li>
<li>Move the character <code>s[i]</code> to the <strong>right</strong> until it reaches the end of the string or another <code>'1'</code>. For example, for <code>s = "010010"</code>, if we choose <code>i = 1</code>, the resulting string will be <code>s = "0<strong><u>001</u></strong>10"</code>.</li>
</ul><p>Return the <strong>maximum</strong> number of operations that you can perform.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "1001101"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">4</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>We can perform the following operations:</p><ul>
<li>Choose index <code>i = 0</code>. The resulting string is <code>s = "<u><strong>001</strong></u>1101"</code>.</li>
<li>Choose index <code>i = 4</code>. The resulting string is <code>s = "0011<u><strong>01</strong></u>1"</code>.</li>
<li>Choose index <code>i = 3</code>. The resulting string is <code>s = "001<strong><u>01</u></strong>11"</code>.</li>
<li>Choose index <code>i = 2</code>. The resulting string is <code>s = "00<strong><u>01</u></strong>111"</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "00111"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
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

`string`
`greedy`
`counting`


---

<details>
  <summary>Hint 1</summary>
  It is optimal to perform the operation on the lowest index possible each time.
</details>
<details>
  <summary>Hint 2</summary>
  Traverse the string from left to right and perform the operation every time it is possible.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-13, Thu 13 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )