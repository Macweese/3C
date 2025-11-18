[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 717. 1-bit and 2-bit Characters

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 717](https://leetcode.com/problems/1-bit-and-2-bit-characters/)

## Description

<p>We have two special characters:</p><ul>
<li>The first character can be represented by one bit <code>0</code>.</li>
<li>The second character can be represented by two bits (<code>10</code> or <code>11</code>).</li>
</ul><p>Given a binary array <code>bits</code> that ends with <code>0</code>, return <code>true</code> if the last character must be a one-bit character.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
bits = [1,0,0]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
bits = [1,1,1,0]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= bits.length &lt;= 1000</code></li>
<li><code>bits[i]</code> is either <code>0</code> or <code>1</code>.</li>
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

`array`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Keep track of where the next character starts.  At the end, you want to know if you started on the last bit.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [89 Gray Code](https://leetcode.com/problems/gray-code/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-11-18, Tue 18 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )