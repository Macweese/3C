[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3136. Valid Word

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3136](https://leetcode.com/problems/valid-word/)

## Description

<p>A word is considered <strong>valid</strong> if:</p><ul>
<li>It contains a <strong>minimum</strong> of 3 characters.</li>
<li>It contains only digits (0-9), and English letters (uppercase and lowercase).</li>
<li>It includes <strong>at least</strong> one <strong>vowel</strong>.</li>
<li>It includes <strong>at least</strong> one <strong>consonant</strong>.</li>
</ul><p>You are given a string <code>word</code>.</p><p>Return <code>true</code> if <code>word</code> is valid, otherwise, return <code>false</code>.</p><p><strong>Notes:</strong></p><ul>
<li><code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, <code>'u'</code>, and their uppercases are <strong>vowels</strong>.</li>
<li>A <strong>consonant</strong> is an English letter that is not a vowel.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "234Adas"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>This word satisfies the conditions.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "b3"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The length of this word is fewer than 3, and does not have a vowel.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "a3$e"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>This word contains a <code>'$'</code> character and does not have a consonant.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= word.length &lt;= 20</code></li>
<li><code>word</code> consists of English uppercase and lowercase letters, digits, <code>'@'</code>, <code>'#'</code>, and <code>'$'</code>.</li>
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
`weekly contest 396`

---

<details>
  <summary>Hint 1</summary>
  Use if-else to check all the conditions.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** ``

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )
