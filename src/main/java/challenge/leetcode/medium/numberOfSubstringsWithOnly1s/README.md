[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1513. Number of Substrings With Only 1s

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1513](https://leetcode.com/problems/number-of-substrings-with-only-1s/)

## Description

<p>Given a binary string <code>s</code>, return <em>the number of substrings with all characters</em> <code>1</code><em>'s</em>. Since the answer may be too large, return it modulo <code>10<sup>9</sup> + 7</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "0110111"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
9
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 9 substring in total with only 1's characters.
"1" -&gt; 5 times.
"11" -&gt; 3 times.
"111" -&gt; 1 time.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "101"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Substring "1" is shown 2 times in s.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "111111"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
21
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Each substring contains only 1's characters.
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

`math`
`string`


---

<details>
  <summary>Hint 1</summary>
  Count number of 1s in each consecutive-1 group. For a group with n consecutive 1s, the total contribution of it to the final answer is (n + 1) * n // 2.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1759 Count Number of Homogenous Substrings](https://leetcode.com/problems/count-number-of-homogenous-substrings/)
* [2062 Count Vowel Substrings of a String](https://leetcode.com/problems/count-vowel-substrings-of-a-string/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-16, Sun 16 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )