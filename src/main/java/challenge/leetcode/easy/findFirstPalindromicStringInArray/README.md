[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2108. Find First Palindromic String in the Array

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2108](https://leetcode.com/problems/find-first-palindromic-string-in-the-array/)

## Description

<p>Given an array of strings <code>words</code>, return <em>the first <strong>palindromic</strong> string in the array</em>. If there is no such string, return <em>an <strong>empty string</strong> </em><code>""</code>.</p><p>A string is <strong>palindromic</strong> if it reads the same forward and backward.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["abc","car","ada","racecar","cool"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"ada"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["notapalindrome","racecar"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"racecar"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The first and only string that is palindromic is "racecar".
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["def","ghi"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
""
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are no palindromic strings, so the empty string is returned.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= words.length &lt;= 100</code></li>
<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
<li><code>words[i]</code> consists only of lowercase English letters.</li>
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
`two pointers`
`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Iterate through the elements in order. As soon as the current element is a palindrome, return it.
</details>
<details>
  <summary>Hint 2</summary>
  To check if an element is a palindrome, can you reverse the string?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [125 Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)


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