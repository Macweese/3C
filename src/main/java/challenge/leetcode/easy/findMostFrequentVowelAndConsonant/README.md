[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3541. Find Most Frequent Vowel and Consonant

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3541](https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/)

## Description

<p>You are given a string <code>s</code> consisting of lowercase English letters (<code>'a'</code> to <code>'z'</code>). </p><p>Your task is to:</p><ul>
<li>Find the vowel (one of <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, or <code>'u'</code>) with the <strong>maximum</strong> frequency.</li>
<li>Find the consonant (all other letters excluding vowels) with the <strong>maximum</strong> frequency.</li>
</ul><p>Return the sum of the two frequencies.</p><p><strong>Note</strong>: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.</p><strong>frequency</strong><code>x</code>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "successes"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">6</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>The vowels are: <code>'u'</code> (frequency 1), <code>'e'</code> (frequency 2). The maximum frequency is 2.</li>
<li>The consonants are: <code>'s'</code> (frequency 4), <code>'c'</code> (frequency 2). The maximum frequency is 4.</li>
<li>The output is <code>2 + 4 = 6</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "aeiaeia"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>The vowels are: <code>'a'</code> (frequency 3), <code>'e'</code> ( frequency 2), <code>'i'</code> (frequency 2). The maximum frequency is 3.</li>
<li>There are no consonants in <code>s</code>. Hence, maximum consonant frequency = 0.</li>
<li>The output is <code>3 + 0 = 3</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 100</code></li>
<li><code>s</code> consists of lowercase English letters only.</li>
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
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use a hashmap
</details>
<details>
  <summary>Hint 2</summary>
  Simulate as described
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


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )