[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3117. Minimum Sum of Values by Dividing Array

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3117](https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/)

## Description

<p>You are given two arrays <code>nums</code> and <code>andValues</code> of length <code>n</code> and <code>m</code> respectively.</p><p>The <strong>value</strong> of an array is equal to the <strong>last</strong> element of that array.</p><p>You have to divide <code>nums</code> into <code>m</code> <strong>disjoint contiguous</strong> <span data-keyword="subarray-nonempty">subarrays</span> such that for the <code>i<sup>th</sup></code> subarray <code>[l<sub>i</sub>, r<sub>i</sub>]</code>, the bitwise <code>AND</code> of the subarray elements is equal to <code>andValues[i]</code>, in other words, <code>nums[l<sub>i</sub>] &amp; nums[l<sub>i</sub> + 1] &amp; ... &amp; nums[r<sub>i</sub>] == andValues[i]</code> for all <code>1 &lt;= i &lt;= m</code>, where <code>&amp;</code> represents the bitwise <code>AND</code> operator.</p><p>Return <em>the <strong>minimum</strong> possible sum of the <strong>values</strong> of the </em><code>m</code><em> subarrays </em><code>nums</code><em> is divided into</em>. <em>If it is not possible to divide </em><code>nums</code><em> into </em><code>m</code><em> subarrays satisfying these conditions, return</em> <code>-1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,4,3,3,2], andValues = [0,3,3,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">12</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The only possible way to divide <code>nums</code> is:</p><ol>
<li><code>[1,4]</code> as <code>1 &amp; 4 == 0</code>.</li>
<li><code>[3]</code> as the bitwise <code>AND</code> of a single element subarray is that element itself.</li>
<li><code>[3]</code> as the bitwise <code>AND</code> of a single element subarray is that element itself.</li>
<li><code>[2]</code> as the bitwise <code>AND</code> of a single element subarray is that element itself.</li>
</ol><p>The sum of the values for these subarrays is <code>4 + 3 + 3 + 2 = 12</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,3,5,7,7,7,5], andValues = [0,7,5]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">17</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There are three ways to divide <code>nums</code>:</p><ol>
<li><code>[[2,3,5],[7,7,7],[5]]</code> with the sum of the values <code>5 + 7 + 5 == 17</code>.</li>
<li><code>[[2,3,5,7],[7,7],[5]]</code> with the sum of the values <code>7 + 7 + 5 == 19</code>.</li>
<li><code>[[2,3,5,7,7],[7],[5]]</code> with the sum of the values <code>7 + 7 + 5 == 19</code>.</li>
</ol><p>The minimum possible sum of the values is <code>17</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,3,4], andValues = [2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">-1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The bitwise <code>AND</code> of the entire array <code>nums</code> is <code>0</code>. As there is no possible way to divide <code>nums</code> into a single subarray to have the bitwise <code>AND</code> of elements <code>2</code>, return <code>-1</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == nums.length &lt;= 10<sup>4</sup></code></li>
<li><code>1 &lt;= m == andValues.length &lt;= min(n, 10)</code></li>
<li><code>1 &lt;= nums[i] &lt; 10<sup>5</sup></code></li>
<li><code>0 &lt;= andValues[j] &lt; 10<sup>5</sup></code></li>
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
`binary search`
`dynamic programming`
`bit manipulation`
`segment tree`
`queue`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let &lt;code&gt;dp[i][j]&lt;/code&gt; be the optimal answer to split  &lt;code&gt;nums[0..(i - 1)]&lt;/code&gt; into the first &lt;code&gt;j&lt;/code&gt; andValues.
</details>
<details>
  <summary>Hint 2</summary>
  &lt;code&gt;dp[i][j] = min(dp[(i - z)][j - 1]) + nums[i - 1]&lt;/code&gt; over all &lt;code&gt;x &lt;= z &lt;= y&lt;/code&gt; and &lt;code&gt;dp[0][0] = 0&lt;/code&gt;, where &lt;code&gt;x&lt;/code&gt; and &lt;code&gt;y&lt;/code&gt; are the longest and shortest subarrays ending with &lt;code&gt;nums[i - 1]&lt;/code&gt; and the bitwise-and of all the values in it is &lt;code&gt;andValues[j - 1]&lt;/code&gt;.
</details>
<details>
  <summary>Hint 3</summary>
  The answer is &lt;code&gt;dp[n][m]&lt;/code&gt;.
</details>
<details>
  <summary>Hint 4</summary>
  To calculate &lt;code&gt;x&lt;/code&gt; and &lt;code&gt;y&lt;/code&gt;, we can use binary search (or sliding window). Note that the more values we have, the smaller the &lt;code&gt;AND&lt;/code&gt; value is.
</details>
<details>
  <summary>Hint 5</summary>
  To calculate the result, we need to support RMQ (range minimum query). Segment tree is one way to do it in &lt;code&gt;O(log(n))&lt;/code&gt;. But we can use Monotonic Queue since the ranges are indeed “sliding to right” which can be reduced to the classical minimum value in sliding window problem, for a &lt;code&gt;O(n)&lt;/code&gt; solution.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2547 Minimum Cost to Split an Array](https://leetcode.com/problems/minimum-cost-to-split-an-array/)
* [2578 Split With Minimum Sum](https://leetcode.com/problems/split-with-minimum-sum/)
* [3171 Find Subarray With Bitwise OR Closest to K](https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k/)
* [3525 Find X Value of Array II](https://leetcode.com/problems/find-x-value-of-array-ii/)


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