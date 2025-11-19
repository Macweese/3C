[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2785. Sort Vowels in a String

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2785](https://leetcode.com/problems/sort-vowels-in-a-string/)

## Description

<p>Given a <strong>0-indexed</strong> string <code>s</code>, <strong>permute</strong> <code>s</code> to get a new string <code>t</code> such that:</p><ul>
<li>All consonants remain in their original places. More formally, if there is an index <code>i</code> with <code>0 &lt;= i &lt; s.length</code> such that <code>s[i]</code> is a consonant, then <code>t[i] = s[i]</code>.</li>
<li>The vowels must be sorted in the <strong>nondecreasing</strong> order of their <strong>ASCII</strong> values. More formally, for pairs of indices <code>i</code>, <code>j</code> with <code>0 &lt;= i &lt; j &lt; s.length</code> such that <code>s[i]</code> and <code>s[j]</code> are vowels, then <code>t[i]</code> must not have a higher ASCII value than <code>t[j]</code>.</li>
</ul><p>Return <em>the resulting string</em>.</p><p>The vowels are <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, and <code>'u'</code>, and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "lEetcOde"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"lEOtcede"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "lYmpH"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"lYmpH"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s</code> consists only of letters of the English alphabet in <strong>uppercase and lowercase</strong>.</li>
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
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Add all the vowels in an array and sort the array.
</details>
<details>
  <summary>Hint 2</summary>
  Replace characters in string s if it&#39;s a vowel from the new array.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [345 Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)


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