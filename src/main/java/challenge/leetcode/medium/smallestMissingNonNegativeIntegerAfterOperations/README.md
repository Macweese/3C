[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2598. Smallest Missing Non-negative Integer After Operations

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2598](https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> and an integer <code>value</code>.</p><p>In one operation, you can add or subtract <code>value</code> from any element of <code>nums</code>.</p><ul>
<li>For example, if <code>nums = [1,2,3]</code> and <code>value = 2</code>, you can choose to subtract <code>value</code> from <code>nums[0]</code> to make <code>nums = [-1,2,3]</code>.</li>
</ul><p>The MEX (minimum excluded) of an array is the smallest missing <strong>non-negative</strong> integer in it.</p><ul>
<li>For example, the MEX of <code>[-1,2,3]</code> is <code>0</code> while the MEX of <code>[1,0,3]</code> is <code>2</code>.</li>
</ul><p>Return <em>the maximum MEX of </em><code>nums</code><em> after applying the mentioned operation <strong>any number of times</strong></em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,-10,7,13,6,8], value = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One can achieve this result by applying the following operations:
- Add value to nums[1] twice to make nums = [1,<strong><u>0</u></strong>,7,13,6,8]
- Subtract value from nums[2] once to make nums = [1,0,<strong><u>2</u></strong>,13,6,8]
- Subtract value from nums[3] twice to make nums = [1,0,2,<strong><u>3</u></strong>,6,8]
The MEX of nums is 4. It can be shown that 4 is the maximum MEX we can achieve.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,-10,7,13,6,8], value = 7
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One can achieve this result by applying the following operation:
- subtract value from nums[2] once to make nums = [1,-10,<u><strong>0</strong></u>,13,6,8]
The MEX of nums is 2. It can be shown that 2 is the maximum MEX we can achieve.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length, value &lt;= 10<sup>5</sup></code></li>
<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
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
`math`
`greedy`


---

<details>
  <summary>Hint 1</summary>
  Think about using modular arithmetic.
</details>
<details>
  <summary>Hint 2</summary>
  if x = nums[i] (mod value), then we can make nums[i] equal to x  after some number of operations
</details>
<details>
  <summary>Hint 3</summary>
  How does finding the frequency of (nums[i] mod value) help?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [41 First Missing Positive](https://leetcode.com/problems/first-missing-positive/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-16, Thu 16 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )