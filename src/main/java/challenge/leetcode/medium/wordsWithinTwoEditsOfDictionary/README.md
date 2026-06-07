[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2452. Words Within Two Edits of Dictionary

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2452](https://leetcode.com/problems/words-within-two-edits-of-dictionary/)

## Description

<p>You are given two string arrays, <code>queries</code> and <code>dictionary</code>. All words in each array comprise of lowercase English letters and have the same length.</p><p>In one <strong>edit</strong> you can take a word from <code>queries</code>, and change any letter in it to any other letter. Find all words from <code>queries</code> that, after a <strong>maximum</strong> of two edits, equal some word from <code>dictionary</code>.</p><p>Return<em> a list of all words from </em><code>queries</code><em>, </em><em>that match with some word from </em><code>dictionary</code><em> after a maximum of <strong>two edits</strong></em>. Return the words in the <strong>same order</strong> they appear in <code>queries</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
["word","note","wood"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
- Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
- It would take more than 2 edits for "ants" to equal a dictionary word.
- "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
Thus, we return ["word","note","wood"].
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
queries = ["yes"], dictionary = ["not"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Applying any two edits to "yes" cannot make it equal to "not". Thus, we return an empty array.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= queries.length, dictionary.length &lt;= 100</code></li>
<li><code>n == queries[i].length == dictionary[j].length</code></li>
<li><code>1 &lt;= n &lt;= 100</code></li>
<li>All <code>queries[i]</code> and <code>dictionary[j]</code> are composed of lowercase English letters.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`string`
`trie`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Try brute-forcing the problem.
</details>
<details>
  <summary>Hint 2</summary>
  For each word in queries, try comparing to each word in dictionary.
</details>
<details>
  <summary>Hint 3</summary>
  If there is a maximum of two edit differences, the word should be present in answer.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [127 Word Ladder](https://leetcode.com/problems/word-ladder/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-22, Wed 22 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )