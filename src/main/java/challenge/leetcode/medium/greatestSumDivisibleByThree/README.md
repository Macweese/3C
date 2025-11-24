[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1262. Greatest Sum Divisible by Three

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1262](https://leetcode.com/problems/greatest-sum-divisible-by-three/)

## Description

<p>Given an integer array <code>nums</code>, return <em>the <strong>maximum possible sum </strong>of elements of the array such that it is divisible by three</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,6,5,1,8]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
18
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Since 4 is not divisible by 3, do not pick any number.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
12
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 4 * 10<sup>4</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
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
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Represent the state as DP[pos][mod]: maximum possible sum starting in the position &#34;pos&#34; in the array where the current sum modulo 3 is equal to mod.
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


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )