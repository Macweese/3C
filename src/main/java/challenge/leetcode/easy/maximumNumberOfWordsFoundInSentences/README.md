[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2114. Maximum Number of Words Found in Sentences

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2114](https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/)

## Description

<p>A <strong>sentence</strong> is a list of <strong>words</strong> that are separated by a single space with no leading or trailing spaces.</p><p>You are given an array of strings <code>sentences</code>, where each <code>sentences[i]</code> represents a single <strong>sentence</strong>.</p><p>Return <em>the <strong>maximum number of words</strong> that appear in a single sentence</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
sentences = ["alice and bob love leetcode", "i think so too", <u>"this is great thanks very much"</u>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- The first sentence, "alice and bob love leetcode", has 5 words in total.
- The second sentence, "i think so too", has 4 words in total.
- The third sentence, "this is great thanks very much", has 6 words in total.
Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
sentences = ["please wait", <u>"continue to fight"</u>, <u>"continue to win"</u>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is possible that multiple sentences contain the same number of words. 
In this example, the second and third sentences (underlined) have the same number of words.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= sentences.length &lt;= 100</code></li>
<li><code>1 &lt;= sentences[i].length &lt;= 100</code></li>
<li><code>sentences[i]</code> consists only of lowercase English letters and <code>' '</code> only.</li>
<li><code>sentences[i]</code> does not have leading or trailing spaces.</li>
<li>All the words in <code>sentences[i]</code> are separated by a single space.</li>
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
  Process each sentence separately and count the number of words by looking for the number of space characters in the sentence and adding it by 1.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2047 Number of Valid Words in a Sentence](https://leetcode.com/problems/number-of-valid-words-in-a-sentence/)


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