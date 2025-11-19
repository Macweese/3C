[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2547. Minimum Cost to Split an Array

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2547](https://leetcode.com/problems/minimum-cost-to-split-an-array/)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p><p>Split the array into some number of non-empty subarrays. The <strong>cost</strong> of a split is the sum of the <strong>importance value</strong> of each subarray in the split.</p><p>Let <code>trimmed(subarray)</code> be the version of the subarray where all numbers which appear only once are removed.</p><ul>
<li>For example, <code>trimmed([3,1,2,4,3,4]) = [3,4,3,4].</code></li>
</ul><p>The <strong>importance value</strong> of a subarray is <code>k + trimmed(subarray).length</code>.</p><ul>
<li>For example, if a subarray is <code>[1,2,3,3,3,4,4]</code>, then <font face="monospace">trimmed(</font><code>[1,2,3,3,3,4,4]) = [3,3,3,4,4].</code>The importance value of this subarray will be <code>k + 5</code>.</li>
</ul><p>Return <em>the minimum possible cost of a split of </em><code>nums</code>.</p><p>A <strong>subarray</strong> is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,1,2,1,3,3], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
8
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We split nums to have two subarrays: [1,2], [1,2,1,3,3].
The importance value of [1,2] is 2 + (0) = 2.
The importance value of [1,2,1,3,3] is 2 + (2 + 2) = 6.
The cost of the split is 2 + 6 = 8. It can be shown that this is the minimum possible cost among all the possible splits.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,1,2,1], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We split nums to have two subarrays: [1,2], [1,2,1].
The importance value of [1,2] is 2 + (0) = 2.
The importance value of [1,2,1] is 2 + (2) = 4.
The cost of the split is 2 + 4 = 6. It can be shown that this is the minimum possible cost among all the possible splits.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,1,2,1], k = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
10
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We split nums to have one subarray: [1,2,1,2,1].
The importance value of [1,2,1,2,1] is 5 + (3 + 2) = 10.
The cost of the split is 10. It can be shown that this is the minimum possible cost among all the possible splits.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>0 &lt;= nums[i] &lt; nums.length</code></li>
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
`hash table`
`dynamic programming`
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let&#39;s denote dp[r] = minimum cost to partition the first r elements of nums. What would be the transitions of such dynamic programming?
</details>
<details>
  <summary>Hint 2</summary>
  dp[r] = min(dp[l] + importance(nums[l..r])) over all 0 &lt;= l &lt; r. This already gives us an O(n^3) approach, as importance can be calculated in linear time, and there are a total of O(n^2) transitions.
</details>
<details>
  <summary>Hint 3</summary>
  Can you think of a way to compute multiple importance values of related subarrays faster?
</details>
<details>
  <summary>Hint 4</summary>
  importance(nums[l-1..r]) is either importance(nums[l..r]) if a new unique element is added, importance(nums[l..r]) + 1 if an old element that appeared at least twice is added, or importance(nums[l..r]) + 2, if a previously unique element is duplicated. This allows us to compute importance(nums[l..r]) for all 0 &lt;= l &lt; r in O(n) by keeping a frequency table and decreasing l from r-1 down to 0.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [322 Coin Change](https://leetcode.com/problems/coin-change/)
* [410 Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)
* [3013 Divide an Array Into Subarrays With Minimum Cost II](https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/)
* [3117 Minimum Sum of Values by Dividing Array](https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/)
* [3500 Minimum Cost to Divide Array Into Subarrays](https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/)


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