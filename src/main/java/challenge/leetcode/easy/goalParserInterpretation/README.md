[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1678. Goal Parser Interpretation

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1678](https://leetcode.com/problems/goal-parser-interpretation/)

## Description

<p>You own a <strong>Goal Parser</strong> that can interpret a string <code>command</code>. The <code>command</code> consists of an alphabet of <code>"G"</code>, <code>"()"</code> and/or <code>"(al)"</code> in some order. The Goal Parser will interpret <code>"G"</code> as the string <code>"G"</code>, <code>"()"</code> as the string <code>"o"</code>, and <code>"(al)"</code> as the string <code>"al"</code>. The interpreted strings are then concatenated in the original order.</p><p>Given the string <code>command</code>, return <em>the <strong>Goal Parser</strong>'s interpretation of </em><code>command</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
command = "G()(al)"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"Goal"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The Goal Parser interprets the command as follows:
G -&gt; G
() -&gt; o
(al) -&gt; al
The final concatenated result is "Goal".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
command = "G()()()()(al)"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"Gooooal"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
command = "(al)G(al)()()G"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"alGalooG"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= command.length &lt;= 100</code></li>
<li><code>command</code> consists of <code>"G"</code>, <code>"()"</code>, and/or <code>"(al)"</code> in some order.</li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  You need to check at most 2 characters to determine which character comes next.
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