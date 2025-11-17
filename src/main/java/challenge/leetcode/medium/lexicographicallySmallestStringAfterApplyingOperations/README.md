[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1625. Lexicographically Smallest String After Applying Operations

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1625](https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/)

## Description

<p>You are given a string <code>s</code> of <strong>even length</strong> consisting of digits from <code>0</code> to <code>9</code>, and two integers <code>a</code> and <code>b</code>.</p><p>You can apply either of the following two operations any number of times and in any order on <code>s</code>:</p><ul>
<li>Add <code>a</code> to all odd indices of <code>s</code> <strong>(0-indexed)</strong>. Digits post <code>9</code> are cycled back to <code>0</code>. For example, if <code>s = "3456"</code> and <code>a = 5</code>, <code>s</code> becomes <code>"3951"</code>.</li>
<li>Rotate <code>s</code> to the right by <code>b</code> positions. For example, if <code>s = "3456"</code> and <code>b = 1</code>, <code>s</code> becomes <code>"6345"</code>.</li>
</ul><p>Return <em>the <strong>lexicographically smallest</strong> string you can obtain by applying the above operations any number of times on</em> <code>s</code>.</p><p>A string <code>a</code> is lexicographically smaller than a string <code>b</code> (of the same length) if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears earlier in the alphabet than the corresponding letter in <code>b</code>. For example, <code>"0158"</code> is lexicographically smaller than <code>"0190"</code> because the first position they differ is at the third letter, and <code>'5'</code> comes before <code>'9'</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "5525", a = 9, b = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"2050"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can apply the following operations:
Start:  "5525"
Rotate: "2555"
Add:    "2454"
Add:    "2353"
Rotate: "5323"
Add:    "5222"
Add:    "5121"
Rotate: "2151"
Add:    "2050"​​​​​
There is no way to obtain a string that is lexicographically smaller than "2050".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "74", a = 5, b = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"24"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can apply the following operations:
Start:  "74"
Rotate: "47"
​​​​​​​Add:    "42"
​​​​​​​Rotate: "24"​​​​​​​​​​​​
There is no way to obtain a string that is lexicographically smaller than "24".
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "0011", a = 4, b = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"0011"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are no sequence of operations that will give us a lexicographically smaller string than "0011".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= s.length &lt;= 100</code></li>
<li><code>s.length</code> is even.</li>
<li><code>s</code> consists of digits from <code>0</code> to <code>9</code> only.</li>
<li><code>1 &lt;= a &lt;= 9</code></li>
<li><code>1 &lt;= b &lt;= s.length - 1</code></li>
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
`depth-first search`
`breadth-first search`
`enumeration`


---

<details>
  <summary>Hint 1</summary>
  Since the length of s is even, the total number of possible sequences is at most 10 * 10 * s.length.
</details>
<details>
  <summary>Hint 2</summary>
  You can generate all possible sequences and take their minimum.
</details>
<details>
  <summary>Hint 3</summary>
  Keep track of already generated sequences so they are not processed again.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2734 Lexicographically Smallest String After Substring Operation](https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/)
* [3216 Lexicographically Smallest String After a Swap](https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-19, Sun 19 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )