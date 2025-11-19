[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 698. Partition to K Equal Sum Subsets

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 698](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <code>true</code> if it is possible to divide this array into <code>k</code> non-empty subsets whose sums are all equal.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [4,3,2,3,5,2,1], k = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4], k = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= k &lt;= nums.length &lt;= 16</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
<li>The frequency of each element is in the range <code>[1, 4]</code>.</li>
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
`dynamic programming`
`backtracking`
`bit manipulation`
`memoization`
`bitmask`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  We can figure out what target each subset must sum to.  Then, let&#39;s recursively search, where at each call to our function, we choose which of k subsets the next value will join.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [416 Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [2305 Fair Distribution of Cookies](https://leetcode.com/problems/fair-distribution-of-cookies/)
* [2025 Maximum Number of Ways to Partition an Array](https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/)
* [2397 Maximum Rows Covered by Columns](https://leetcode.com/problems/maximum-rows-covered-by-columns/)
* [3670 Maximum Product of Two Integers With No Common Bits](https://leetcode.com/problems/maximum-product-of-two-integers-with-no-common-bits/)


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