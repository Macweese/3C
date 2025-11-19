[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 966. Vowel Spellchecker

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 966](https://leetcode.com/problems/vowel-spellchecker/)

## Description

<p>Given a <code>wordlist</code>, we want to implement a spellchecker that converts a query word into a correct word.</p><p>For a given <code>query</code> word, the spell checker handles two categories of spelling mistakes:</p><ul>
<li>Capitalization: If the query matches a word in the wordlist (<strong>case-insensitive</strong>), then the query word is returned with the same case as the case in the wordlist.

	<ul>
<li>Example: <code>wordlist = ["yellow"]</code>, <code>query = "YellOw"</code>: <code>correct = "yellow"</code></li>
<li>Example: <code>wordlist = ["Yellow"]</code>, <code>query = "yellow"</code>: <code>correct = "Yellow"</code></li>
<li>Example: <code>wordlist = ["yellow"]</code>, <code>query = "yellow"</code>: <code>correct = "yellow"</code></li>
</ul>
</li>
<li>Vowel Errors: If after replacing the vowels <code>('a', 'e', 'i', 'o', 'u')</code> of the query word with any vowel individually, it matches a word in the wordlist (<strong>case-insensitive</strong>), then the query word is returned with the same case as the match in the wordlist.
	<ul>
<li>Example: <code>wordlist = ["YellOw"]</code>, <code>query = "yollow"</code>: <code>correct = "YellOw"</code></li>
<li>Example: <code>wordlist = ["YellOw"]</code>, <code>query = "yeellow"</code>: <code>correct = ""</code> (no match)</li>
<li>Example: <code>wordlist = ["YellOw"]</code>, <code>query = "yllw"</code>: <code>correct = ""</code> (no match)</li>
</ul>
</li>
</ul><p>In addition, the spell checker operates under the following precedence rules:</p><ul>
<li>When the query exactly matches a word in the wordlist (<strong>case-sensitive</strong>), you should return the same word back.</li>
<li>When the query matches a word up to capitalization, you should return the first such match in the wordlist.</li>
<li>When the query matches a word up to vowel errors, you should return the first such match in the wordlist.</li>
<li>If the query has no matches in the wordlist, you should return the empty string.</li>
</ul><p>Given some <code>queries</code>, return a list of words <code>answer</code>, where <code>answer[i]</code> is the correct word for <code>query = queries[i]</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
wordlist = ["yellow"], queries = ["YellOw"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
["yellow"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= wordlist.length, queries.length &lt;= 5000</code></li>
<li><code>1 &lt;= wordlist[i].length, queries[i].length &lt;= 7</code></li>
<li><code>wordlist[i]</code> and <code>queries[i]</code> consist only of only English letters.</li>
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


---

**Hints**
<!-- No hints -->

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