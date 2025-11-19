[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3110. Score of a String

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3110](https://leetcode.com/problems/score-of-a-string/)

## Description

<p>You are given a string <code>s</code>. The <strong>score</strong> of a string is defined as the sum of the absolute difference between the <strong>ASCII</strong> values of adjacent characters.</p><p>Return the <strong>score</strong> of<em> </em><code>s</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "hello"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">13</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The <strong>ASCII</strong> values of the characters in <code>s</code> are: <code>'h' = 104</code>, <code>'e' = 101</code>, <code>'l' = 108</code>, <code>'o' = 111</code>. So, the score of <code>s</code> would be <code>|104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "zaz"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">50</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The <strong>ASCII</strong> values of the characters in <code>s</code> are: <code>'z' = 122</code>, <code>'a' = 97</code>. So, the score of <code>s</code> would be <code>|122 - 97| + |97 - 122| = 25 + 25 = 50</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= s.length &lt;= 100</code></li>
<li><code>s</code> consists only of lowercase English letters.</li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sum the difference between all the adjacent characters by just taking the absolute difference of their ASCII values.
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