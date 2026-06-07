[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3043. Find the Length of the Longest Common Prefix

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3043](https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/)

## Description

<p>You are given two arrays with <strong>positive</strong> integers <code>arr1</code> and <code>arr2</code>.</p><p>A <strong>prefix</strong> of a positive integer is an integer formed by one or more of its digits, starting from its <strong>leftmost</strong> digit. For example, <code>123</code> is a prefix of the integer <code>12345</code>, while <code>234</code> is <strong>not</strong>.</p><p>A <strong>common prefix</strong> of two integers <code>a</code> and <code>b</code> is an integer <code>c</code>, such that <code>c</code> is a prefix of both <code>a</code> and <code>b</code>. For example, <code>5655359</code> and <code>56554</code> have common prefixes <code>565</code> and <code>5655</code> while <code>1223</code> and <code>43456</code> <strong>do not</strong> have a common prefix.</p><p>You need to find the length of the <strong>longest common prefix</strong> between all pairs of integers <code>(x, y)</code> such that <code>x</code> belongs to <code>arr1</code> and <code>y</code> belongs to <code>arr2</code>.</p><p>Return <em>the length of the <strong>longest</strong> common prefix among all pairs</em>.<em> If no common prefix exists among them</em>, <em>return</em> <code>0</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr1 = [1,10,100], arr2 = [1000]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 3 pairs (arr1[i], arr2[j]):
- The longest common prefix of (1, 1000) is 1.
- The longest common prefix of (10, 1000) is 10.
- The longest common prefix of (100, 1000) is 100.
The longest common prefix is 100 with a length of 3.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr1 = [1,2,3], arr2 = [4,4,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There exists no common prefix for any pair (arr1[i], arr2[j]), hence we return 0.
Note that common prefixes between elements of the same array do not count.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr1.length, arr2.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>1 &lt;= arr1[i], arr2[i] &lt;= 10<sup>8</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`string`
`trie`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Put all the possible prefixes of each element in &lt;code&gt;arr1&lt;/code&gt; into a HashSet.
</details>
<details>
  <summary>Hint 2</summary>
  For all the possible prefixes of each element in &lt;code&gt;arr2&lt;/code&gt;, check if it exists in the HashSet.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [14 Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
* [3093 Longest Common Suffix Queries](https://leetcode.com/problems/longest-common-suffix-queries/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-21, Thu 21 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )