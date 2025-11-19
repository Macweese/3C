[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1. Two Sum

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1](https://leetcode.com/problems/two-sum/)

## Description

<p>Given an array of integers <code>nums</code> and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p><p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p><p>You can return the answer in any order.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [2,7,11,15], target = 9
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,2,4], target = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[1,2]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,3], target = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
<li><strong>Only one valid answer exists.</strong></li>
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
  A really brute force way would be to search for all possible pairs of numbers but that would be too slow. Again, it&#39;s best to try out brute force solutions just for completeness. It is from these brute force solutions that you can come up with optimizations.
</details>
<details>
  <summary>Hint 2</summary>
  So, if we fix one of the numbers, say &lt;code&gt;x&lt;/code&gt;, we have to scan the entire array to find the next number &lt;code&gt;y&lt;/code&gt; which is &lt;code&gt;value - x&lt;/code&gt; where value is the input parameter. Can we change our array somehow so that this search becomes faster?
</details>
<details>
  <summary>Hint 3</summary>
  The second train of thought is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [15 3Sum](https://leetcode.com/problems/3sum/)
* [18 4Sum](https://leetcode.com/problems/4sum/)
* [167 Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
* [170 Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design/)
* [560 Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
* [653 Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)
* [1099 Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/)
* [1679 Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/)
* [1711 Count Good Meals](https://leetcode.com/problems/count-good-meals/)
* [2006 Count Number of Pairs With Absolute Difference K](https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/)
* [2023 Number of Pairs of Strings With Concatenation Equal to Target](https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/)
* [2200 Find All K-Distant Indices in an Array](https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/)
* [2351 First Letter to Appear Twice](https://leetcode.com/problems/first-letter-to-appear-twice/)
* [2354 Number of Excellent Pairs](https://leetcode.com/problems/number-of-excellent-pairs/)
* [2367 Number of Arithmetic Triplets](https://leetcode.com/problems/number-of-arithmetic-triplets/)
* [2374 Node With Highest Edge Score](https://leetcode.com/problems/node-with-highest-edge-score/)
* [2399 Check Distances Between Same Letters](https://leetcode.com/problems/check-distances-between-same-letters/)
* [2395 Find Subarrays With Equal Sum](https://leetcode.com/problems/find-subarrays-with-equal-sum/)
* [2441 Largest Positive Integer That Exists With Its Negative](https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/)
* [2465 Number of Distinct Averages](https://leetcode.com/problems/number-of-distinct-averages/)
* [2824 Count Pairs Whose Sum is Less than Target](https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/)


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