[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3171. Find Subarray With Bitwise OR Closest to K

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3171](https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k/)

## Description

<p>You are given an array <code>nums</code> and an integer <code>k</code>. You need to find a <span data-keyword="subarray-nonempty">subarray</span> of <code>nums</code> such that the <strong>absolute difference</strong> between <code>k</code> and the bitwise <code>OR</code> of the subarray elements is as<strong> small</strong> as possible. In other words, select a subarray <code>nums[l..r]</code> such that <code>|k - (nums[l] OR nums[l + 1] ... OR nums[r])|</code> is minimum.</p><p>Return the <strong>minimum</strong> possible value of the absolute difference.</p><p>A <strong>subarray</strong> is a contiguous <b>non-empty</b> sequence of elements within an array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,4,5], k = 3</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The subarray <code>nums[0..1]</code> has <code>OR</code> value 3, which gives the minimum absolute difference <code>|3 - 3| = 0</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,3,1,3], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The subarray <code>nums[1..1]</code> has <code>OR</code> value 3, which gives the minimum absolute difference <code>|3 - 2| = 1</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1], k = 10</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">9</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There is a single subarray with <code>OR</code> value 1, which gives the minimum absolute difference <code>|10 - 1| = 9</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
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
`bit manipulation`
`segment tree`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let &lt;code&gt;dp[i]&lt;/code&gt; be the set of all the bitwise &lt;code&gt;OR&lt;/code&gt; of all the subarrays ending at index &lt;code&gt;i&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  We start from &lt;code&gt;nums[i]&lt;/code&gt;, taking the bitwise &lt;code&gt;OR&lt;/code&gt; result by including elements one by one from &lt;code&gt;i&lt;/code&gt; towards left. Notice that only unset bits can become set on adding an element, and set bits never become unset again.
</details>
<details>
  <summary>Hint 3</summary>
  Hence &lt;code&gt;dp[i]&lt;/code&gt; can contain at most 30 elements.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [3117 Minimum Sum of Values by Dividing Array](https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/)


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