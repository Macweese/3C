[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 338. Counting Bits

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 338](https://leetcode.com/problems/counting-bits/)

## Description

<p>Given an integer <code>n</code>, return <em>an array </em><code>ans</code><em> of length </em><code>n + 1</code><em> such that for each </em><code>i</code><em> </em>(<code>0 &lt;= i &lt;= n</code>)<em>, </em><code>ans[i]</code><em> is the <strong>number of </strong></em><code>1</code><em><strong>'s</strong> in the binary representation of </em><code>i</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,1,2,1,2]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
3 --&gt; 11
4 --&gt; 100
5 --&gt; 101
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`dynamic programming`
`bit manipulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  You should make use of what you have produced already.
</details>
<details>
  <summary>Hint 2</summary>
  Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
</details>
<details>
  <summary>Hint 3</summary>
  Or does the odd/even status of the number help you in calculating the number of 1s?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [191 Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
* [2859 Sum of Values at Indices With K Set Bits](https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/)
* [2917 Find the K-or of an Array](https://leetcode.com/problems/find-the-k-or-of-an-array/)


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