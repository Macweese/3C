[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1980. Find Unique Binary String

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1980](https://leetcode.com/problems/find-unique-binary-string/)

## Description

<p>Given an array of strings <code>nums</code> containing <code>n</code> <strong>unique</strong> binary strings each of length <code>n</code>, return <em>a binary string of length </em><code>n</code><em> that <strong>does not appear</strong> in </em><code>nums</code><em>. If there are multiple answers, you may return <strong>any</strong> of them</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = ["01","10"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"11"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"11" does not appear in nums. "00" would also be correct.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = ["00","01"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"11"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"11" does not appear in nums. "10" would also be correct.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = ["111","011","001"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"101"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == nums.length</code></li>
<li><code>1 &lt;= n &lt;= 16</code></li>
<li><code>nums[i].length == n</code></li>
<li><code>nums[i] </code>is either <code>'0'</code> or <code>'1'</code>.</li>
<li>All the strings of <code>nums</code> are <strong>unique</strong>.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`string`
`backtracking`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  We can convert the given strings into base 10 integers.
</details>
<details>
  <summary>Hint 2</summary>
  Can we use recursion to generate all possible strings?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [268 Missing Number](https://leetcode.com/problems/missing-number/)
* [448 Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
* [710 Random Pick with Blacklist](https://leetcode.com/problems/random-pick-with-blacklist/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-08, Sun 08 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )