[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1758. Minimum Changes To Make Alternating Binary String

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1758](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/)

## Description

<p>You are given a string <code>s</code> consisting only of the characters <code>'0'</code> and <code>'1'</code>. In one operation, you can change any <code>'0'</code> to <code>'1'</code> or vice versa.</p><p>The string is called alternating if no two adjacent characters are equal. For example, the string <code>"010"</code> is alternating, while the string <code>"0100"</code> is not.</p><p>Return <em>the <strong>minimum</strong> number of operations needed to make</em> <code>s</code> <em>alternating</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "0100"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
If you change the last character to '1', s will be "0101", which is alternating.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "10"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
s is already alternating.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "1111"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
You need two operations to reach "0101" or "1010".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
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
  Think about how the final string will look like.
</details>
<details>
  <summary>Hint 2</summary>
  It will either start with a &#39;0&#39; and be like &#39;010101010..&#39; or with a &#39;1&#39; and be like &#39;10101010..&#39;
</details>
<details>
  <summary>Hint 3</summary>
  Try both ways, and check for each way, the number of changes needed to reach it from the given string. The answer is the minimum of both ways.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2957 Remove Adjacent Almost-Equal Characters](https://leetcode.com/problems/remove-adjacent-almost-equal-characters/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-05, Thu 05 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )