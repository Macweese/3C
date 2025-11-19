[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 15. 3Sum

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 15](https://leetcode.com/problems/3sum/)

## Description

<p>Given an integer array nums, return all the triplets <code>[nums[i], nums[j], nums[k]]</code> such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and <code>nums[i] + nums[j] + nums[k] == 0</code>.</p><p>Notice that the solution set must not contain duplicate triplets.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [-1,0,1,2,-1,-4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[[-1,-1,2],[-1,0,1]]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [0,1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The only possible triplet does not sum up to 0.
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
[[0,0,0]]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The only possible triplet sums up to 0.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
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
`two pointers`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  So, we essentially need to find three numbers x, y, and z such that they add up to the given value. If we fix one of the numbers say x, we are left with the two-sum problem at hand!
</details>
<details>
  <summary>Hint 2</summary>
  For the two-sum problem, if we fix one of the numbers, say x, we have to scan the entire array to find the next number y, which is value - x where value is the input parameter. Can we change our array somehow so that this search becomes faster?
</details>
<details>
  <summary>Hint 3</summary>
  The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1 Two Sum](https://leetcode.com/problems/two-sum/)
* [16 3Sum Closest](https://leetcode.com/problems/3sum-closest/)
* [18 4Sum](https://leetcode.com/problems/4sum/)
* [259 3Sum Smaller](https://leetcode.com/problems/3sum-smaller/)
* [2367 Number of Arithmetic Triplets](https://leetcode.com/problems/number-of-arithmetic-triplets/)
* [2908 Minimum Sum of Mountain Triplets I](https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/)
* [2909 Minimum Sum of Mountain Triplets II](https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/)


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