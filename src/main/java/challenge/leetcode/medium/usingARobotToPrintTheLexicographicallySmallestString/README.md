[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2434. Using a Robot to Print the Lexicographically Smallest String

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2434](https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/)

## Description

<p>You are given a string <code>s</code> and a robot that currently holds an empty string <code>t</code>. Apply one of the following operations until <code>s</code> and <code>t</code> <strong>are both empty</strong>:</p><ul>
<li>Remove the <strong>first</strong> character of a string <code>s</code> and give it to the robot. The robot will append this character to the string <code>t</code>.</li>
<li>Remove the <strong>last</strong> character of a string <code>t</code> and give it to the robot. The robot will write this character on paper.</li>
</ul><p>Return <em>the lexicographically smallest string that can be written on the paper.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "zza"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"azz"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Let p denote the written string.
Initially p="", s="zza", t="".
Perform first operation three times p="", s="", t="zza".
Perform second operation three times p="azz", s="", t="".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "bac"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"abc"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Let p denote the written string.
Perform first operation twice p="", s="c", t="ba". 
Perform second operation twice p="ab", s="c", t="". 
Perform first operation p="ab", s="", t="c". 
Perform second operation p="abc", s="", t="".
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "bdda"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"addb"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Let p denote the written string.
Initially p="", s="bdda", t="".
Perform first operation four times p="", s="", t="bdda".
Perform second operation four times p="addb", s="", t="".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s</code> consists of only English lowercase letters.</li>
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

`hash table`
`string`
`stack`
`greedy`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If there are some character “a” ’ s in the string, they can be written on paper before anything else.
</details>
<details>
  <summary>Hint 2</summary>
  Every character in the string before the last “a” should be written in reversed order.
</details>
<details>
  <summary>Hint 3</summary>
  After the robot writes every “a” on paper, the same holds for other characters “b”, ”c”, …etc.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [484 Find Permutation](https://leetcode.com/problems/find-permutation/)


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