[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2615. Sum of Distances

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2615](https://leetcode.com/problems/sum-of-distances/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>. There exists an array <code>arr</code> of length <code>nums.length</code>, where <code>arr[i]</code> is the sum of <code>|i - j|</code> over all <code>j</code> such that <code>nums[j] == nums[i]</code> and <code>j != i</code>. If there is no such <code>j</code>, set <code>arr[i]</code> to be <code>0</code>.</p><p>Return <em>the array </em><code>arr</code><em>.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,3,1,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[5,0,3,4,0]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5. 
When i = 1, arr[1] = 0 because there is no other index with value 3.
When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3. 
When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4. 
When i = 4, arr[4] = 0 because there is no other index with value 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [0,5,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,0,0]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Since each element in nums is distinct, arr[i] = 0 for all i.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Can we use the prefix sum here?
</details>
<details>
  <summary>Hint 2</summary>
  For each number x, collect all the indices where x occurs, and calculate the prefix sum of the array.
</details>
<details>
  <summary>Hint 3</summary>
  For each occurrence of x, the indices to the right will be regular subtraction while the indices to the left will be reversed subtraction.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [26 Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
* [442 Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)
* [2602 Minimum Operations to Make All Array Elements Equal](https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-23, Thu 23 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )