[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1415. The k-th Lexicographical String of All Happy Strings of Length n

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1415](https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/)

## Description

<p>A <strong>happy string</strong> is a string that:</p><ul>
<li>consists only of letters of the set <code>['a', 'b', 'c']</code>.</li>
<li><code>s[i] != s[i + 1]</code> for all values of <code>i</code> from <code>1</code> to <code>s.length - 1</code> (string is 1-indexed).</li>
</ul><p>For example, strings <strong>"abc", "ac", "b"</strong> and <strong>"abcbabcbcb"</strong> are all happy strings and strings <strong>"aa", "baa"</strong> and <strong>"ababbc"</strong> are not happy strings.</p><p>Given two integers <code>n</code> and <code>k</code>, consider a list of all happy strings of length <code>n</code> sorted in lexicographical order.</p><p>Return <em>the kth string</em> of this list or return an <strong>empty string</strong> if there are less than <code>k</code> happy strings of length <code>n</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 1, k = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"c"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 1, k = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
""
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are only 3 happy strings of length 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 3, k = 9
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"cab"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9<sup>th</sup> string = "cab"
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 10</code></li>
<li><code>1 &lt;= k &lt;= 100</code></li>
</ul>

<br>

---

<br>

#### Tags

`string`
`backtracking`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Generate recursively all the happy strings of length n.
</details>
<details>
  <summary>Hint 2</summary>
  Sort them in lexicographical order and return the kth string if it exists.
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

`2026-03-14, Sat 14 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )