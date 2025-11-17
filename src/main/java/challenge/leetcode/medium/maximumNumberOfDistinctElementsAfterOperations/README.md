[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3397. Maximum Number of Distinct Elements After Operations

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3397](https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p><p>You are allowed to perform the following <strong>operation</strong> on each element of the array <strong>at most</strong> <em>once</em>:</p><ul>
<li>Add an integer in the range <code>[-k, k]</code> to the element.</li>
</ul><p>Return the <strong>maximum</strong> possible number of <strong>distinct</strong> elements in <code>nums</code> after performing the <strong>operations</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,2,3,3,4], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">6</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><code>nums</code> changes to <code>[-1, 0, 1, 2, 3, 4]</code> after performing operations on the first four elements.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [4,4,4,4], k = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>By adding -1 to <code>nums[0]</code> and 1 to <code>nums[1]</code>, <code>nums</code> changes to <code>[3, 5, 4, 4]</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
<li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
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
`greedy`
`sorting`


---

<details>
  <summary>Hint 1</summary>
  Can we use sorting here?
</details>
<details>
  <summary>Hint 2</summary>
  Find the minimum element which is not used for each element.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1481 Least Number of Unique Integers after K Removals](https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-18, Sat 18 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )