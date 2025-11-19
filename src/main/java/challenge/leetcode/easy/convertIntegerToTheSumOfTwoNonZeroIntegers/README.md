[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1317. Convert Integer to the Sum of Two No-Zero Integers

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1317](https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/)

## Description

<p><strong>No-Zero integer</strong> is a positive integer that <strong>does not contain any <code>0</code></strong> in its decimal representation.</p><p>Given an integer <code>n</code>, return <em>a list of two integers</em> <code>[a, b]</code> <em>where</em>:</p><ul>
<li><code>a</code> and <code>b</code> are <strong>No-Zero integers</strong>.</li>
<li><code>a + b = n</code></li>
</ul><p>The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[1,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 11
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[2,9]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 11 = n.
Note that there are other valid answers as [8, 3] that can be accepted.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= n &lt;= 10<sup>4</sup></code></li>
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

`math`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Loop through all elements from 1 to n.
</details>
<details>
  <summary>Hint 2</summary>
  Choose A = i and B = n - i then check if A and B are both No-Zero integers.
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