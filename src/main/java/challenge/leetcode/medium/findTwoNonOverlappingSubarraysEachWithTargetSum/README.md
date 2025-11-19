[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1477](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)

## Description

<p>You are given an array of integers <code>arr</code> and an integer <code>target</code>.</p><p>You have to find <strong>two non-overlapping sub-arrays</strong> of <code>arr</code> each with a sum equal <code>target</code>. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is <strong>minimum</strong>.</p><p>Return <em>the minimum sum of the lengths</em> of the two required sub-arrays, or return <code>-1</code> if you cannot find such two sub-arrays.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [3,2,2,4,3], target = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [7,3,4,7], target = 7
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]), but we will choose the first and third sub-arrays as the sum of their lengths is 2.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [4,3,2,6,2,3,4], target = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We have only one sub-array of sum = 6.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
<li><code>1 &lt;= target &lt;= 10<sup>8</sup></code></li>
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
`binary search`
`dynamic programming`
`sliding window`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let&#39;s create two arrays prefix and suffix where prefix[i] is the minimum length of sub-array ends before i and has sum = k, suffix[i] is the minimum length of sub-array starting at or after i and has sum = k.
</details>
<details>
  <summary>Hint 2</summary>
  The answer we are searching for is min(prefix[i] + suffix[i]) for all values of i from 0 to n-1 where n == arr.length.
</details>
<details>
  <summary>Hint 3</summary>
  If you are still stuck with how to build prefix and suffix, you can store for each index i the length of the sub-array starts at i and has sum = k or infinity otherwise, and you can use it to build both prefix and suffix.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2395 Find Subarrays With Equal Sum](https://leetcode.com/problems/find-subarrays-with-equal-sum/)


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