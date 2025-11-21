[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1930. Unique Length-3 Palindromic Subsequences

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1930](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/)

## Description

<p>Given a string <code>s</code>, return <em>the number of <strong>unique palindromes of length three</strong> that are a <strong>subsequence</strong> of </em><code>s</code>.</p><p>Note that even if there are multiple ways to obtain the same subsequence, it is still only counted <strong>once</strong>.</p><p>A <strong>palindrome</strong> is a string that reads the same forwards and backwards.</p><p>A <strong>subsequence</strong> of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.</p><ul>
<li>For example, <code>"ace"</code> is a subsequence of <code>"<u>a</u>b<u>c</u>d<u>e</u>"</code>.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "aabca"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "<u>a</u>a<u>b</u>c<u>a</u>")
- "aaa" (subsequence of "<u>aa</u>bc<u>a</u>")
- "aca" (subsequence of "<u>a</u>ab<u>ca</u>")
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "adc"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are no palindromic subsequences of length 3 in "adc".
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "bbcbaba"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "<u>bb</u>c<u>b</u>aba")
- "bcb" (subsequence of "<u>b</u>b<u>cb</u>aba")
- "bab" (subsequence of "<u>b</u>bcb<u>ab</u>a")
- "aba" (subsequence of "bbcb<u>aba</u>")
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>3 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s</code> consists of only lowercase English letters.</li>
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

`hash table`
`string`
`bit manipulation`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  What is the maximum number of length-3 palindromic strings?
</details>
<details>
  <summary>Hint 2</summary>
  How can we keep track of the characters that appeared to the left of a given position?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2484 Count Palindromic Subsequences](https://leetcode.com/problems/count-palindromic-subsequences/)


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