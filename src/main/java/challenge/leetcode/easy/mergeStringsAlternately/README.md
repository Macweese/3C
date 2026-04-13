[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1768. Merge Strings Alternately

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1768](https://leetcode.com/problems/merge-strings-alternately/)

## Description

<p>You are given two strings <code>word1</code> and <code>word2</code>. Merge the strings by adding letters in alternating order, starting with <code>word1</code>. If a string is longer than the other, append the additional letters onto the end of the merged string.</p><p>Return <em>the merged string.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
word1 = "abc", word2 = "pqr"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"apbqcr"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
word1 = "ab", word2 = "pqrs"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"apbqrs"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
word1 = "abcd", word2 = "pq"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"apbqcd"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= word1.length, word2.length &lt;= 100</code></li>
<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
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

`two pointers`
`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use two pointers, one pointer for each string. Alternately choose the character from each pointer, and move the pointer upwards.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [281 Zigzag Iterator](https://leetcode.com/problems/zigzag-iterator/)
* [2645 Minimum Additions to Make Valid String](https://leetcode.com/problems/minimum-additions-to-make-valid-string/)


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