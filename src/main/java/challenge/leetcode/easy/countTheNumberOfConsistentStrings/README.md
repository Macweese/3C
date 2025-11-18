[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1684. Count the Number of Consistent Strings

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1684](https://leetcode.com/problems/count-the-number-of-consistent-strings/)

## Description

<p>You are given a string <code>allowed</code> consisting of <strong>distinct</strong> characters and an array of strings <code>words</code>. A string is <strong>consistent </strong>if all characters in the string appear in the string <code>allowed</code>.</p><p>Return<em> the number of <strong>consistent</strong> strings in the array </em><code>words</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
All strings are consistent.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Strings "cc", "acd", "ac", and "d" are consistent.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= words.length &lt;= 10<sup>4</sup></code></li>
<li><code>1 &lt;= allowed.length &lt;=<sup> </sup>26</code></li>
<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
<li>The characters in <code>allowed</code> are <strong>distinct</strong>.</li>
<li><code>words[i]</code> and <code>allowed</code> contain only lowercase English letters.</li>
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

`array`
`hash table`
`string`
`bit manipulation`
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  A string is incorrect if it contains a character that is not allowed
</details>
<details>
  <summary>Hint 2</summary>
  Constraints are small enough for brute force
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2506 Count Pairs Of Similar Strings](https://leetcode.com/problems/count-pairs-of-similar-strings/)


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