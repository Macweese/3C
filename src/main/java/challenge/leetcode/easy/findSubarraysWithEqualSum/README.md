[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2395. Find Subarrays With Equal Sum

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2395](https://leetcode.com/problems/find-subarrays-with-equal-sum/)

## Description

<p>Given a <strong>0-indexed</strong> integer array <code>nums</code>, determine whether there exist <strong>two</strong> subarrays of length <code>2</code> with <strong>equal</strong> sum. Note that the two subarrays must begin at <strong>different</strong> indices.</p><p>Return <code>true</code><em> if these subarrays exist, and </em><code>false</code><em> otherwise.</em></p><p>A <b>subarray</b> is a contiguous non-empty sequence of elements within an array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [4,2,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The subarrays with elements [4,2] and [2,4] have the same sum of 6.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
No two subarrays of size 2 have the same sum.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [0,0,0]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The subarrays [nums[0],nums[1]] and [nums[1],nums[2]] have the same sum of 0. 
Note that even though the subarrays have the same content, the two subarrays are considered different because they are in different positions in the original array.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= nums.length &lt;= 1000</code></li>
<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use a counter to keep track of the subarray sums.
</details>
<details>
  <summary>Hint 2</summary>
  Use a hashset to check if any two sums are equal.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1 Two Sum](https://leetcode.com/problems/two-sum/)
* [416 Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [1477 Find Two Non-overlapping Sub-arrays Each With Target Sum](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)


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