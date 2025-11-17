[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3539. Find Sum of Array Product of Magical Sequences

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3539](https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences/)

## Description

<p>You are given two integers, <code>m</code> and <code>k</code>, and an integer array <code>nums</code>.</p><code>seq</code><strong>magical</strong><ul>
<li><code>seq</code> has a size of <code>m</code>.</li>
<li><code>0 &lt;= seq[i] &lt; nums.length</code></li>
<li>The <strong>binary representation</strong> of <code>2<sup>seq[0]</sup> + 2<sup>seq[1]</sup> + ... + 2<sup>seq[m - 1]</sup></code> has <code>k</code> <strong>set bits</strong>.</li>
</ul><p>The <strong>array product</strong> of this sequence is defined as <code>prod(seq) = (nums[seq[0]] * nums[seq[1]] * ... * nums[seq[m - 1]])</code>.</p><p>Return the <strong>sum</strong> of the <strong>array products</strong> for all valid <strong>magical</strong> sequences.</p><p>Since the answer may be large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p><p>A <strong>set bit</strong> refers to a bit in the binary representation of a number that has a value of 1.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">m = 5, k = 5, nums = [1,10,100,10000,1000000]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">991600007</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>All permutations of <code>[0, 1, 2, 3, 4]</code> are magical sequences, each with an array product of 10<sup>13</sup>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">m = 2, k = 2, nums = [5,4,3,2,1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">170</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The magical sequences are <code>[0, 1]</code>, <code>[0, 2]</code>, <code>[0, 3]</code>, <code>[0, 4]</code>, <code>[1, 0]</code>, <code>[1, 2]</code>, <code>[1, 3]</code>, <code>[1, 4]</code>, <code>[2, 0]</code>, <code>[2, 1]</code>, <code>[2, 3]</code>, <code>[2, 4]</code>, <code>[3, 0]</code>, <code>[3, 1]</code>, <code>[3, 2]</code>, <code>[3, 4]</code>, <code>[4, 0]</code>, <code>[4, 1]</code>, <code>[4, 2]</code>, and <code>[4, 3]</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">m = 1, k = 1, nums = [28]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">28</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The only magical sequence is <code>[0]</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= k &lt;= m &lt;= 30</code></li>
<li><code>1 &lt;= nums.length &lt;= 50</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>8</sup></code></li>
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
`math`
`dynamic programming`
`bit manipulation`
`combinatorics`
`bitmask`


---

<details>
  <summary>Hint 1</summary>
  Use Dynamic Programming
</details>
<details>
  <summary>Hint 2</summary>
  Let &lt;code&gt;dp[i][j][mask]&lt;/code&gt; be the state after choosing &lt;code&gt;i&lt;/code&gt; numbers (indices)
</details>
<details>
  <summary>Hint 3</summary>
  The partial sum &lt;code&gt;S = 2^(seq[0]) + 2^(seq[1]) + ... + 2^(seq[i - 1])&lt;/code&gt; has produced exactly &lt;code&gt;j&lt;/code&gt; set bits once you’ve fully propagated any carries
</details>
<details>
  <summary>Hint 4</summary>
  The &lt;code&gt;mask&lt;/code&gt; represents the &#34;window&#34; of lower-order bits from &lt;code&gt;S&lt;/code&gt; that have not yet been fully processed (i.e. bits that might later create new set bits when additional terms are added)
</details>
<details>
  <summary>Hint 5</summary>
  Use combinatorics
</details>
<details>
  <summary>Hint 6</summary>
  How many ways are there to permute a sequence of entities where some are repetitive?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [238 Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
* [3370 Smallest Number With All Set Bits](https://leetcode.com/problems/smallest-number-with-all-set-bits/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-12, Sun 12 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )