[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2515. Shortest Distance to Target String in a Circular Array

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2515](https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/)

## Description

<p>You are given a <strong>0-indexed</strong> <strong>circular</strong> string array <code>words</code> and a string <code>target</code>. A <strong>circular array</strong> means that the array's end connects to the array's beginning.</p><ul>
<li>Formally, the next element of <code>words[i]</code> is <code>words[(i + 1) % n]</code> and the previous element of <code>words[i]</code> is <code>words[(i - 1 + n) % n]</code>, where <code>n</code> is the length of <code>words</code>.</li>
</ul><p>Starting from <code>startIndex</code>, you can move to either the next word or the previous word with <code>1</code> step at a time.</p><p>Return <em>the <strong>shortest</strong> distance needed to reach the string</em> <code>target</code>. If the string <code>target</code> does not exist in <code>words</code>, return <code>-1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We start from index 1 and can reach "hello" by
- moving 3 units to the right to reach index 4.
- moving 2 units to the left to reach index 4.
- moving 4 units to the right to reach index 0.
- moving 1 unit to the left to reach index 0.
The shortest distance to reach "hello" is 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We start from index 0 and can reach "leetcode" by
- moving 2 units to the right to reach index 2.
- moving 1 unit to the left to reach index 2.
The shortest distance to reach "leetcode" is 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
words = ["i","eat","leetcode"], target = "ate", startIndex = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Since "ate" does not exist in <code>words</code>, we return -1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= words.length &lt;= 100</code></li>
<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
<li><code>words[i]</code> and <code>target</code> consist of only lowercase English letters.</li>
<li><code>0 &lt;= startIndex &lt; words.length</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  You have two options, either move straight to the left or move straight to the right.
</details>
<details>
  <summary>Hint 2</summary>
  Find the first target word and record the distance.
</details>
<details>
  <summary>Hint 3</summary>
  Choose the one with the minimum distance.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1652 Defuse the Bomb](https://leetcode.com/problems/defuse-the-bomb/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-15, Wed 15 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )