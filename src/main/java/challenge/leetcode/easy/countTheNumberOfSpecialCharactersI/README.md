[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3120. Count the Number of Special Characters I

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3120](https://leetcode.com/problems/count-the-number-of-special-characters-i/)

## Description

<p>You are given a string <code>word</code>. A letter is called <strong>special</strong> if it appears <strong>both</strong> in lowercase and uppercase in <code>word</code>.</p><p>Return the number of<em> </em><strong>special</strong> letters in<em> </em><code>word</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "aaAbcBC"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The special characters in <code>word</code> are <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "abc"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>No character in <code>word</code> appears in uppercase.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "abBCab"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The only special character in <code>word</code> is <code>'b'</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= word.length &lt;= 50</code></li>
<li><code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

<br>

---

<br>

#### Tags

`hash table`
`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  The constraints are small. For all 52 characters, check if they are present in &lt;code&gt;word&lt;/code&gt;.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [520 Detect Capital](https://leetcode.com/problems/detect-capital/)
* [2309 Greatest English Letter in Upper and Lower Case](https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/)
* [3121 Count the Number of Special Characters II](https://leetcode.com/problems/count-the-number-of-special-characters-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-26, Tue 26 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )