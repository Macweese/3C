[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3121. Count the Number of Special Characters II

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3121](https://leetcode.com/problems/count-the-number-of-special-characters-ii/)

## Description

<p>You are given a string <code>word</code>. A letter <code>c</code> is called <strong>special</strong> if it appears <strong>both</strong> in lowercase and uppercase in <code>word</code>, and <strong>every</strong> lowercase occurrence of <code>c</code> appears before the <strong>first</strong> uppercase occurrence of <code>c</code>.</p><p>Return the number of<em> </em><strong>special</strong> letters<em> </em>in<em> </em><code>word</code>.</p>

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
<p>The special characters are <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</p>
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
<p>There are no special characters in <code>word</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">word = "AbBCab"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There are no special characters in <code>word</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= word.length &lt;= 2 * 10<sup>5</sup></code></li>
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
  For each character &lt;code&gt;c&lt;/code&gt;, store the first occurrence of its uppercase and the last occurrence of its lowercase.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [520 Detect Capital](https://leetcode.com/problems/detect-capital/)
* [2309 Greatest English Letter in Upper and Lower Case](https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/)
* [3120 Count the Number of Special Characters I](https://leetcode.com/problems/count-the-number-of-special-characters-i/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-27, Wed 27 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )