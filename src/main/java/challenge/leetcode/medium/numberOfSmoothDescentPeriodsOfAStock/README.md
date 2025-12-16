[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2110. Number of Smooth Descent Periods of a Stock

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2110](https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/)

## Description

<p>You are given an integer array <code>prices</code> representing the daily price history of a stock, where <code>prices[i]</code> is the stock price on the <code>i<sup>th</sup></code> day.</p><p>A <strong>smooth descent period</strong> of a stock consists of <strong>one or more contiguous</strong> days such that the price on each day is <strong>lower</strong> than the price on the <strong>preceding day</strong> by <strong>exactly</strong> <code>1</code>. The first day of the period is exempted from this rule.</p><p>Return <em>the number of <strong>smooth descent periods</strong></em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
prices = [3,2,1,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 7 smooth descent periods:
[3], [2], [1], [4], [3,2], [2,1], and [3,2,1]
Note that a period with one day is a smooth descent period by the definition.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
prices = [8,6,7,7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are 4 smooth descent periods: [8], [6], [7], and [7]
Note that [8,6] is not a smooth descent period as 8 - 6 ≠ 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
prices = [1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There is 1 smooth descent period: [1]
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li>
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
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Any array is a series of adjacent longest possible smooth descent periods. For example, [5,3,2,1,7,6] is [5] + [3,2,1] + [7,6].
</details>
<details>
  <summary>Hint 2</summary>
  Think of a 2-pointer approach to traverse the array and find each longest possible period.
</details>
<details>
  <summary>Hint 3</summary>
  Suppose you found the longest possible period with a length of k. How many periods are within that period? How can you count them quickly? Think of the formula to calculate the sum of 1, 2, 3, ..., k.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [713 Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)
* [1063 Number of Valid Subarrays](https://leetcode.com/problems/number-of-valid-subarrays/)
* [2348 Number of Zero-Filled Subarrays](https://leetcode.com/problems/number-of-zero-filled-subarrays/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-15, Mon 15 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )