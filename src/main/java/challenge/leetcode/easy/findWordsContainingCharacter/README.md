[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2942. Find Words Containing Character

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2942](https://leetcode.com/problems/find-words-containing-character/)

## Description

<p>You are given a <strong>0-indexed</strong> array of strings <code>words</code> and a character <code>x</code>.</p><p>Return <em>an <strong>array of indices</strong> representing the words that contain the character </em><code>x</code>.</p><p><strong>Note</strong> that the returned array may be in <strong>any</strong> order.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["leet","code"], x = "e"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"e" occurs in both words: "l<strong><u>ee</u></strong>t", and "cod<u><strong>e</strong></u>". Hence, we return indices 0 and 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["abc","bcd","aaaa","cbc"], x = "a"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,2]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"a" occurs in "<strong><u>a</u></strong>bc", and "<u><strong>aaaa</strong></u>". Hence, we return indices 0 and 2.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["abc","bcd","aaaa","cbc"], x = "z"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"z" does not occur in any of the words. Hence, we return an empty array.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= words.length &lt;= 50</code></li>
<li><code>1 &lt;= words[i].length &lt;= 50</code></li>
<li><code>x</code> is a lowercase English letter.</li>
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
`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use two nested loops.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2089 Find Target Indices After Sorting Array](https://leetcode.com/problems/find-target-indices-after-sorting-array/)


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