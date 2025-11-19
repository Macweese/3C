[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1588. Sum of All Odd Length Subarrays

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1588](https://leetcode.com/problems/sum-of-all-odd-length-subarrays/)

## Description

<p>Given an array of positive integers <code>arr</code>, return <em>the sum of all possible <strong>odd-length subarrays</strong> of </em><code>arr</code>.</p><p>A <strong>subarray</strong> is a contiguous subsequence of the array.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [1,4,2,5,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
58
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [10,11,12]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
66
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr.length &lt;= 100</code></li>
<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
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
`math`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  You can brute force – try every (i,j) pair, and if the length is odd, go through and add the sum to the answer.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2778 Sum of Squares of Special Elements ](https://leetcode.com/problems/sum-of-squares-of-special-elements/)


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