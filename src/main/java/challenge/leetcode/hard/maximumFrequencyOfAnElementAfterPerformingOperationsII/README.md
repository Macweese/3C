[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3347. Maximum Frequency of an Element After Performing Operations II

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3347](https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/)

## Description

<p>You are given an integer array <code>nums</code> and two integers <code>k</code> and <code>numOperations</code>.</p><p>You must perform an <strong>operation</strong> <code>numOperations</code> times on <code>nums</code>, where in each operation you:</p><ul>
<li>Select an index <code>i</code> that was <strong>not</strong> selected in any previous operations.</li>
<li>Add an integer in the range <code>[-k, k]</code> to <code>nums[i]</code>.</li>
</ul><p>Return the <strong>maximum</strong> possible <span data-keyword="frequency-array">frequency</span> of any element in <code>nums</code> after performing the <strong>operations</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,4,5], k = 1, numOperations = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>We can achieve a maximum frequency of two by:</p><ul>
<li>Adding 0 to <code>nums[1]</code>, after which <code>nums</code> becomes <code>[1, 4, 5]</code>.</li>
<li>Adding -1 to <code>nums[2]</code>, after which <code>nums</code> becomes <code>[1, 4, 4]</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [5,11,20,20], k = 5, numOperations = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>We can achieve a maximum frequency of two by:</p><ul>
<li>Adding 0 to <code>nums[1]</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
<li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
<li><code>0 &lt;= numOperations &lt;= nums.length</code></li>
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
`binary search`
`sliding window`
`sorting`
`prefix sum`


---

<details>
  <summary>Hint 1</summary>
  The optimal values to check are &lt;code&gt;nums[i] - k&lt;/code&gt;, &lt;code&gt;nums[i]&lt;/code&gt;, and &lt;code&gt;nums[i] + k&lt;/code&gt;.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1838 Frequency of the Most Frequent Element](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)
* [3005 Count Elements With Maximum Frequency](https://leetcode.com/problems/count-elements-with-maximum-frequency/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-22, Wed 22 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )