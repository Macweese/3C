[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1009. Complement of Base 10 Integer

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1009](https://leetcode.com/problems/complement-of-base-10-integer/)

## Description

<p>The <strong>complement</strong> of an integer is the integer you get when you flip all the <code>0</code>'s to <code>1</code>'s and all the <code>1</code>'s to <code>0</code>'s in its binary representation.</p><ul>
<li>For example, The integer <code>5</code> is <code>"101"</code> in binary and its <strong>complement</strong> is <code>"010"</code> which is the integer <code>2</code>.</li>
</ul><p>Given an integer <code>n</code>, return <em>its complement</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 7
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= n &lt; 10<sup>9</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`bit manipulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  A binary number plus its complement will equal 111....111 in binary.  Also, N = 0 is a corner case.
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

`2026-03-11, Wed 11 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )