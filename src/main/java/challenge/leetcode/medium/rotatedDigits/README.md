[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 788. Rotated Digits

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 788](https://leetcode.com/problems/rotated-digits/)

## Description

<p>An integer <code>x</code> is a <strong>good</strong> if after rotating each digit individually by 180 degrees, we get a valid number that is different from <code>x</code>. Each digit must be rotated - we cannot choose to leave it alone.</p><p>A number is valid if each digit remains a digit after rotation. For example:</p><ul>
<li><code>0</code>, <code>1</code>, and <code>8</code> rotate to themselves,</li>
<li><code>2</code> and <code>5</code> rotate to each other (in this case they are rotated in a different direction, in other words, <code>2</code> or <code>5</code> gets mirrored),</li>
<li><code>6</code> and <code>9</code> rotate to each other, and</li>
<li>the rest of the numbers do not rotate to any other number and become invalid.</li>
</ul><p>Given an integer <code>n</code>, return <em>the number of <strong>good</strong> integers in the range </em><code>[1, n]</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
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
n = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`math`
`dynamic programming`


---

**Hints**
<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-02, Sat 02 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )