[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2561. Rearranging Fruits

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2561](https://leetcode.com/problems/rearranging-fruits/)

## Description

<p>You have two fruit baskets containing <code>n</code> fruits each. You are given two <strong>0-indexed</strong> integer arrays <code>basket1</code> and <code>basket2</code> representing the cost of fruit in each basket. You want to make both baskets <strong>equal</strong>. To do so, you can use the following operation as many times as you want:</p><ul>
<li>Choose two indices <code>i</code> and <code>j</code>, and swap the <code>i<sup><font size="1">th</font></sup></code> fruit of <code>basket1</code> with the <code>j<sup><font size="1">th</font></sup></code> fruit of <code>basket2</code>.</li>
<li>The cost of the swap is <code>min(basket1[i], basket2[j])</code>.</li>
</ul><p>Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.</p><p>Return <em>the minimum cost to make both the baskets equal or </em><code>-1</code><em> if impossible.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
basket1 = [4,2,2,2], basket2 = [1,4,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
basket1 = [2,3,4,1], basket2 = [3,2,5,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It can be shown that it is impossible to make both the baskets equal.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>basket1.length == basket2.length</code></li>
<li><code>1 &lt;= basket1.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= basket1[i], basket2[i] &lt;= 10<sup>9</sup></code></li>
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
`greedy`
`sort`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Create two frequency maps for both arrays, and find the minimum element among all elements of both arrays.
</details>
<details>
  <summary>Hint 2</summary>
  Check if the sum of frequencies of an element in both arrays is odd, if so return -1
</details>
<details>
  <summary>Hint 3</summary>
  Store the elements that need to be swapped in a vector, and sort it.
</details>
<details>
  <summary>Hint 4</summary>
  Can we reduce swapping cost with the help of minimum element?
</details>
<details>
  <summary>Hint 5</summary>
  Calculate the minimum cost of swapping.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2332 The Latest Time to Catch a Bus](https://leetcode.com/problems/the-latest-time-to-catch-a-bus/)
* [2449 Minimum Number of Operations to Make Arrays Similar](https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/)


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