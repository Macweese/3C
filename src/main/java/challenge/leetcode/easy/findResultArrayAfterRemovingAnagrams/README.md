[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2273. Find Resultant Array After Removing Anagrams

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2273](https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/)

## Description

<p>You are given a <strong>0-indexed</strong> string array <code>words</code>, where <code>words[i]</code> consists of lowercase English letters.</p><p>In one operation, select any index <code>i</code> such that <code>0 &lt; i &lt; words.length</code> and <code>words[i - 1]</code> and <code>words[i]</code> are <strong>anagrams</strong>, and <strong>delete</strong> <code>words[i]</code> from <code>words</code>. Keep performing this operation as long as you can select an index that satisfies the conditions.</p><p>Return <code>words</code> <em>after performing all operations</em>. It can be shown that selecting the indices for each operation in <strong>any</strong> arbitrary order will lead to the same result.</p><p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, <code>"dacb"</code> is an anagram of <code>"abdc"</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["abba","baba","bbaa","cd","cd"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
["abba","cd"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One of the ways we can obtain the resultant array is by using the following operations:
- Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","baba","cd","cd"].
- Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
  Now words = ["abba","cd","cd"].
- Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","cd"].
We can no longer perform any operations, so ["abba","cd"] is the final answer.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["a","b","c","d","e"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
["a","b","c","d","e"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
No two adjacent strings in words are anagrams of each other, so no operations are performed.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= words.length &lt;= 100</code></li>
<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
<li><code>words[i]</code> consists of lowercase English letters.</li>
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
`sorting`


---

<details>
  <summary>Hint 1</summary>
  Instead of removing each repeating anagram, try to find all the strings in words which will not be present in the final answer.
</details>
<details>
  <summary>Hint 2</summary>
  For every index i, find the largest index j &lt; i such that words[j] will be present in the final answer.
</details>
<details>
  <summary>Hint 3</summary>
  Check if words[i] and words[j] are anagrams. If they are, then it can be confirmed that words[i] will not be present in the final answer.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [49 Group Anagrams](https://leetcode.com/problems/group-anagrams/)
* [242 Valid Anagram](https://leetcode.com/problems/valid-anagram/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-13, Mon 13 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )