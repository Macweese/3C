[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2553. Separate the Digits in an Array

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2553](https://leetcode.com/problems/separate-the-digits-in-an-array/)

## Description

<p>Given an array of positive integers <code>nums</code>, return <em>an array </em><code>answer</code><em> that consists of the digits of each integer in </em><code>nums</code><em> after separating them in <strong>the same order</strong> they appear in </em><code>nums</code>.</p><p>To separate the digits of an integer is to get all the digits it has in the same order.</p><ul>
<li>For example, for the integer <code>10921</code>, the separation of its digits is <code>[1,0,9,2,1]</code>.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [13,25,83,77]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[1,3,2,5,8,3,7,7]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- The separation of 13 is [1,3].
- The separation of 25 is [2,5].
- The separation of 83 is [8,3].
- The separation of 77 is [7,7].
answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [7,1,3,9]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[7,1,3,9]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The separation of each integer in nums is itself.
answer = [7,1,3,9].
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Convert each number into a list and append that list to the answer.
</details>
<details>
  <summary>Hint 2</summary>
  You can convert the integer into a string to do that easily.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2180 Count Integers With Even Digit Sum](https://leetcode.com/problems/count-integers-with-even-digit-sum/)
* [2544 Alternating Digit Sum](https://leetcode.com/problems/alternating-digit-sum/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-11, Mon 11 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )