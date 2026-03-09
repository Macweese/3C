[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3129. Find All Possible Stable Binary Arrays I

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3129](https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/)

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
<p>The two possible stable binary arrays are <code>[1,0]</code> and <code>[0,1]</code>, as both arrays have a single 0 and a single 1, and no subarray has a length greater than 2.</p>
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
<p>The only possible stable binary array is <code>[1,0,1]</code>.</p><p>Note that the binary arrays <code>[1,1,0]</code> and <code>[0,1,1]</code> have subarrays of length 2 with identical elements, hence, they are not stable.</p>
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
<li><code>1 &lt;= zero, one, limit &lt;= 200</code></li>
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
  Let &lt;code&gt;dp[a][b][c = 0/1][d]&lt;/code&gt; be the number of stable arrays with exactly &lt;code&gt;a&lt;/code&gt; 0s, &lt;code&gt;b&lt;/code&gt; 1s and consecutive &lt;code&gt;d&lt;/code&gt; value of &lt;code&gt;c&lt;/code&gt;’s at the end.
</details>
<details>
  <summary>Hint 2</summary>
  Try each case by appending a 0/1 at last to get the inductions.
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

`2026-03-09, Mon 09 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )