[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2840. Check if Strings Can be Made Equal With Operations II

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2840](https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/)

## Description

<p>You are given two strings <code>s1</code> and <code>s2</code>, both of length <code>n</code>, consisting of <strong>lowercase</strong> English letters.</p><p>You can apply the following operation on <strong>any</strong> of the two strings <strong>any</strong> number of times:</p><ul>
<li>Choose any two indices <code>i</code> and <code>j</code> such that <code>i &lt; j</code> and the difference <code>j - i</code> is <strong>even</strong>, then <strong>swap</strong> the two characters at those indices in the string.</li>
</ul><p>Return <code>true</code><em> if you can make the strings </em><code>s1</code><em> and </em><code>s2</code><em> equal, and </em><code>false</code><em> otherwise</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s1 = "abcdba", s2 = "cabdab"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can apply the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
- Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
- Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s1 = "abe", s2 = "bea"
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
<li><code>n == s1.length == s2.length</code></li>
<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>s1</code> and <code>s2</code> consist only of lowercase English letters.</li>
</ul>

<br>

---

<br>

#### Tags

`hash table`
`string`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  &lt;div class=&#34;_1l1MA&#34;&gt;Characters in two positions can be swapped if and only if the two positions have the same parity.&lt;/div&gt;
</details>
<details>
  <summary>Hint 2</summary>
  &lt;div class=&#34;_1l1MA&#34;&gt;To be able to make the two strings equal, the characters at even and odd positions in the strings should be the same.&lt;/div&gt;
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

`2026-03-30, Mon 30 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )