[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2518. Number of Great Partitions

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2518](https://leetcode.com/problems/number-of-great-partitions/)

## Description

<p>You are given an array <code>nums</code> consisting of <strong>positive</strong> integers and an integer <code>k</code>.</p><p><strong>Partition</strong> the array into two ordered <strong>groups</strong> such that each element is in exactly <strong>one</strong> group. A partition is called great if the <strong>sum</strong> of elements of each group is greater than or equal to <code>k</code>.</p><p>Return <em>the number of <strong>distinct</strong> great partitions</em>. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p><p>Two partitions are considered distinct if some element <code>nums[i]</code> is in different groups in the two partitions.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4], k = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The great partitions are: ([1,2,3], [4]), ([1,3], [2,4]), ([1,4], [2,3]), ([2,3], [1,4]), ([2,4], [1,3]) and ([4], [1,2,3]).
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,3,3], k = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are no great partitions for this array.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [6,6], k = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can either put nums[0] in the first partition or in the second partition.
The great partitions will be ([6], [6]) and ([6], [6]).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length, k &lt;= 1000</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If the sum of the array is smaller than 2*k, then it is impossible to find a great partition.
</details>
<details>
  <summary>Hint 2</summary>
  Solve the reverse problem, that is, find the number of partitions where the sum of elements of at least one of the two groups is smaller than k.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [132 Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)
* [416 Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [2698 Find the Punishment Number of an Integer](https://leetcode.com/problems/find-the-punishment-number-of-an-integer/)
* [3578 Count Partitions With Max-Min Difference at Most K](https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/)


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