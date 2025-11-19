[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2390. Removing Stars From a String

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2390](https://leetcode.com/problems/removing-stars-from-a-string/)

## Description

<p>You are given a string <code>s</code>, which contains stars <code>*</code>.</p><p>In one operation, you can:</p><ul>
<li>Choose a star in <code>s</code>.</li>
<li>Remove the closest <strong>non-star</strong> character to its <strong>left</strong>, as well as remove the star itself.</li>
</ul><p>Return <em>the string after <strong>all</strong> stars have been removed</em>.</p><p><strong>Note:</strong></p><ul>
<li>The input will be generated such that the operation is always possible.</li>
<li>It can be shown that the resulting string will always be unique.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "leet**cod*e"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"lecoe"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Performing the removals from left to right:
- The closest character to the 1<sup>st</sup> star is 't' in "lee<strong><u>t</u></strong>**cod*e". s becomes "lee*cod*e".
- The closest character to the 2<sup>nd</sup> star is 'e' in "le<strong><u>e</u></strong>*cod*e". s becomes "lecod*e".
- The closest character to the 3<sup>rd</sup> star is 'd' in "leco<strong><u>d</u></strong>*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "erase*****"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
""
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The entire string is removed, so we return an empty string.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s</code> consists of lowercase English letters and stars <code>*</code>.</li>
<li>The operation above can be performed on <code>s</code>.</li>
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
`stack`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  What data structure could we use to efficiently perform these removals?
</details>
<details>
  <summary>Hint 2</summary>
  Use a stack to store the characters. Pop one character off the stack at each star. Otherwise, we push the character onto the stack.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [844 Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)
* [1047 Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)


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