[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3583. Count Special Triplets

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3583](https://leetcode.com/problems/count-special-triplets/)

## Description

<p>You are given an integer array <code>nums</code>.</p><p>A <strong>special triplet</strong> is defined as a triplet of indices <code>(i, j, k)</code> such that:</p><ul>
<li><code>0 &lt;= i &lt; j &lt; k &lt; n</code>, where <code>n = nums.length</code></li>
<li><code>nums[i] == nums[j] * 2</code></li>
<li><code>nums[k] == nums[j] * 2</code></li>
</ul><p>Return the total number of <strong>special triplets</strong> in the array.</p><p>Since the answer may be large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [6,3,6]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The only special triplet is <code>(i, j, k) = (0, 1, 2)</code>, where:</p><ul>
<li><code>nums[0] = 6</code>, <code>nums[1] = 3</code>, <code>nums[2] = 6</code></li>
<li><code>nums[0] = nums[1] * 2 = 3 * 2 = 6</code></li>
<li><code>nums[2] = nums[1] * 2 = 3 * 2 = 6</code></li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [0,1,0,0]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The only special triplet is <code>(i, j, k) = (0, 2, 3)</code>, where:</p><ul>
<li><code>nums[0] = 0</code>, <code>nums[2] = 0</code>, <code>nums[3] = 0</code></li>
<li><code>nums[0] = nums[2] * 2 = 0 * 2 = 0</code></li>
<li><code>nums[3] = nums[2] * 2 = 0 * 2 = 0</code></li>
</ul>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [8,4,2,8,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There are exactly two special triplets:</p><ul>
<li><code>(i, j, k) = (0, 1, 3)</code>
<ul>
<li><code>nums[0] = 8</code>, <code>nums[1] = 4</code>, <code>nums[3] = 8</code></li>
<li><code>nums[0] = nums[1] * 2 = 4 * 2 = 8</code></li>
<li><code>nums[3] = nums[1] * 2 = 4 * 2 = 8</code></li>
</ul>
</li>
<li><code>(i, j, k) = (1, 2, 4)</code>
<ul>
<li><code>nums[1] = 4</code>, <code>nums[2] = 2</code>, <code>nums[4] = 4</code></li>
<li><code>nums[1] = nums[2] * 2 = 2 * 2 = 4</code></li>
<li><code>nums[4] = nums[2] * 2 = 2 * 2 = 4</code></li>
</ul>
</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>3 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
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
`hash table`
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use frequency arrays or maps, e.g. &lt;code&gt;freqPrev&lt;/code&gt; and &lt;code&gt;freqNext&lt;/code&gt;—to track how many times each value appears before and after the current index.
</details>
<details>
  <summary>Hint 2</summary>
  For each index &lt;code&gt;j&lt;/code&gt; in the triplet (&lt;code&gt;i&lt;/code&gt;,&lt;code&gt;j&lt;/code&gt;,&lt;code&gt;k&lt;/code&gt;), compute its contribution to the answer using your freqPrev and freqNext counts.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-09, Tue 09 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )