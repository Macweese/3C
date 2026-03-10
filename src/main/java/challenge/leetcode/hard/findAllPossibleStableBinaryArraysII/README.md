[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3130. Find All Possible Stable Binary Arrays II

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3130](https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii/)

## Description

<p>You are given 3 positive integers <code>zero</code>, <code>one</code>, and <code>limit</code>.</p><p>A <span data-keyword="binary-array">binary array</span> <code>arr</code> is called <strong>stable</strong> if:</p><ul>
<li>The number of occurrences of 0 in <code>arr</code> is <strong>exactly </strong><code>zero</code>.</li>
<li>The number of occurrences of 1 in <code>arr</code> is <strong>exactly</strong> <code>one</code>.</li>
<li>Each <span data-keyword="subarray-nonempty">subarray</span> of <code>arr</code> with a size greater than <code>limit</code> must contain <strong>both </strong>0 and 1.</li>
</ul><p>Return the <em>total</em> number of <strong>stable</strong> binary arrays.</p><p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">zero = 1, one = 1, limit = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The two possible stable binary arrays are <code>[1,0]</code> and <code>[0,1]</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">zero = 1, one = 2, limit = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The only possible stable binary array is <code>[1,0,1]</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">zero = 3, one = 3, limit = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">14</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>All the possible stable binary arrays are <code>[0,0,1,0,1,1]</code>, <code>[0,0,1,1,0,1]</code>, <code>[0,1,0,0,1,1]</code>, <code>[0,1,0,1,0,1]</code>, <code>[0,1,0,1,1,0]</code>, <code>[0,1,1,0,0,1]</code>, <code>[0,1,1,0,1,0]</code>, <code>[1,0,0,1,0,1]</code>, <code>[1,0,0,1,1,0]</code>, <code>[1,0,1,0,0,1]</code>, <code>[1,0,1,0,1,0]</code>, <code>[1,0,1,1,0,0]</code>, <code>[1,1,0,0,1,0]</code>, and <code>[1,1,0,1,0,0]</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 <= zero, one, limit <= 1000</code></li>
</ul>

<br>

---

<br>

#### Tags

`dynamic programming`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let <code>dp[x][y][z = 0/1]</code> be the number of stable arrays with exactly <code>x</code> zeros, <code>y</code> ones, and the last element is <code>z</code>. (0 or 1).

<code>dp[x][y][0] + dp[x][y][1]</code> is the answer for given <code>(x, y)</code>.
</details>
<details>
  <summary>Hint 2</summary>
  If we have already placed <code>x</code> 1 and <code>y</code> 0, if we place a group of <code>k</code> 0, the number of ways is <code>dp[x-k][y][1]</code>. We can place a group with size <code>i</code>, where <code>i</code> varies from 1 to <code>min(limit, zero - x)</code>.

Similarly, we can solve by placing a group of ones.
</details>
<details>
  <summary>Hint 3</summary>
  Speed up the calculation using prefix arrays to store the sum of <code>dp</code> states.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [525 Contiguous Array](https://leetcode.com/problems/contiguous-array/)
* [930 Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-03-10, Tue 10 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )