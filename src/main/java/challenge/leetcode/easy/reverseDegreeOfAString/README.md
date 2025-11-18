[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3498. Reverse Degree of a String

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3498](https://leetcode.com/problems/reverse-degree-of-a-string/)

## Description

<p>Given a string <code>s</code>, calculate its <strong>reverse degree</strong>.</p><p>The <strong>reverse degree</strong> is calculated as follows:</p><ol>
<li>For each character, multiply its position in the <em>reversed</em> alphabet (<code>'a'</code> = 26, <code>'b'</code> = 25, ..., <code>'z'</code> = 1) with its position in the string <strong>(1-indexed)</strong>.</li>
<li>Sum these products for all characters in the string.</li>
</ol><p>Return the <strong>reverse degree</strong> of <code>s</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "abc"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">148</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<table style="border: 1px solid black;">
<tbody>
<tr>
<th style="border: 1px solid black;">Letter</th>
<th style="border: 1px solid black;">Index in Reversed Alphabet</th>
<th style="border: 1px solid black;">Index in String</th>
<th style="border: 1px solid black;">Product</th>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'a'</code></td>
<td style="border: 1px solid black;">26</td>
<td style="border: 1px solid black;">1</td>
<td style="border: 1px solid black;">26</td>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'b'</code></td>
<td style="border: 1px solid black;">25</td>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">50</td>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'c'</code></td>
<td style="border: 1px solid black;">24</td>
<td style="border: 1px solid black;">3</td>
<td style="border: 1px solid black;">72</td>
</tr>
</tbody>
</table><p>The reversed degree is <code>26 + 50 + 72 = 148</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "zaza"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">160</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<table style="border: 1px solid black;">
<tbody>
<tr>
<th style="border: 1px solid black;">Letter</th>
<th style="border: 1px solid black;">Index in Reversed Alphabet</th>
<th style="border: 1px solid black;">Index in String</th>
<th style="border: 1px solid black;">Product</th>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'z'</code></td>
<td style="border: 1px solid black;">1</td>
<td style="border: 1px solid black;">1</td>
<td style="border: 1px solid black;">1</td>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'a'</code></td>
<td style="border: 1px solid black;">26</td>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">52</td>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'z'</code></td>
<td style="border: 1px solid black;">1</td>
<td style="border: 1px solid black;">3</td>
<td style="border: 1px solid black;">3</td>
</tr>
<tr>
<td style="border: 1px solid black;"><code>'a'</code></td>
<td style="border: 1px solid black;">26</td>
<td style="border: 1px solid black;">4</td>
<td style="border: 1px solid black;">104</td>
</tr>
</tbody>
</table><p>The reverse degree is <code>1 + 52 + 3 + 104 = 160</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 1000</code></li>
<li><code>s</code> contains only lowercase English letters.</li>
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
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Simulate the operations as described.
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