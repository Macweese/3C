[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1888. Minimum Number of Flips to Make the Binary String Alternating

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1888](https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/)

## Description

<p>You are given a binary string <code>s</code>. You are allowed to perform two types of operations on the string in any sequence:</p><ul>
<li><strong>Type-1: Remove</strong> the character at the start of the string <code>s</code> and <strong>append</strong> it to the end of the string.</li>
<li><strong>Type-2: Pick</strong> any character in <code>s</code> and <strong>flip</strong> its value, i.e., if its value is <code>'0'</code> it becomes <code>'1'</code> and vice-versa.</li>
</ul><p>Return <em>the <strong>minimum</strong> number of <strong>type-2</strong> operations you need to perform</em> <em>such that </em><code>s</code> <em>becomes <strong>alternating</strong>.</em></p><p>The string is called <strong>alternating</strong> if no two adjacent characters are equal.</p><ul>
<li>For example, the strings <code>"010"</code> and <code>"1010"</code> are alternating, while the string <code>"0100"</code> is not.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "111000"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "10<u>1</u>01<u>0</u>".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "010"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: The string is already alternating.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "1110"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
: Use the second operation on the second element to make s = "1<u>0</u>10".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`string`
`dynamic programming`
`sliding window`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Note what actually matters is how many 0s and 1s are in odd and even positions
</details>
<details>
  <summary>Hint 2</summary>
  For every cyclic shift we need to count how many 0s and 1s are at each parity and convert the minimum between them for each parity
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2170 Minimum Operations to Make the Array Alternating](https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-07, Sat 07 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )