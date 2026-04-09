[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2839. Check if Strings Can be Made Equal With Operations I

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2839](https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/)

## Description

<p>You are given two strings <code>s1</code> and <code>s2</code>, both of length <code>4</code>, consisting of <strong>lowercase</strong> English letters.</p><p>You can apply the following operation on any of the two strings <strong>any</strong> number of times:</p><ul>
<li>Choose any two indices <code>i</code> and <code>j</code> such that <code>j - i = 2</code>, then <strong>swap</strong> the two characters at those indices in the string.</li>
</ul><p>Return <code>true</code><em> if you can make the strings </em><code>s1</code><em> and </em><code>s2</code><em> equal, and </em><code>false</code><em> otherwise</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s1 = "abcd", s2 = "cdab"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can do the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbad".
- Choose the indices i = 1, j = 3. The resulting string is s1 = "cdab" = s2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s1 = "abcd", s2 = "dacb"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is not possible to make the two strings equal.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>s1.length == s2.length == 4</code></li>
<li><code>s1</code> and <code>s2</code> consist only of lowercase English letters.</li>
</ul>

<br>

---

<br>

#### Tags

`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  &lt;div class=&#34;_1l1MA&#34;&gt;Since the strings are very small you can try a brute-force approach.&lt;/div&gt;
</details>
<details>
  <summary>Hint 2</summary>
  &lt;div class=&#34;_1l1MA&#34;&gt;There are only &lt;code&gt;2&lt;/code&gt; different swaps that are possible in a string.&lt;/div&gt;
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

`2026-03-29, Sun 29 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )