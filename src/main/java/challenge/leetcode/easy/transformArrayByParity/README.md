[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3467. Transform Array by Parity

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3467](https://leetcode.com/problems/transform-array-by-parity/)

## Description

<p>You are given an integer array <code>nums</code>. Transform <code>nums</code> by performing the following operations in the <strong>exact</strong> order specified:</p><ol>
<li>Replace each even number with 0.</li>
<li>Replace each odd numbers with 1.</li>
<li>Sort the modified array in <strong>non-decreasing</strong> order.</li>
</ol><p>Return the resulting array after performing these operations.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [4,3,2,1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[0,0,1,1]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Replace the even numbers (4 and 2) with 0 and the odd numbers (3 and 1) with 1. Now, <code>nums = [0, 1, 0, 1]</code>.</li>
<li>After sorting <code>nums</code> in non-descending order, <code>nums = [0, 0, 1, 1]</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,5,1,4,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[0,0,1,1,1]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Replace the even numbers (4 and 2) with 0 and the odd numbers (1, 5 and 1) with 1. Now, <code>nums = [1, 1, 1, 0, 0]</code>.</li>
<li>After sorting <code>nums</code> in non-descending order, <code>nums = [0, 0, 1, 1, 1]</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 100</code></li>
<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
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
`sorting`
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let &lt;code&gt;x&lt;/code&gt; be the number of even numbers, and &lt;code&gt;y&lt;/code&gt; be the number of odd numbers. Output &lt;code&gt;0&lt;/code&gt; &lt;code&gt;x&lt;/code&gt; times, followed by &lt;code&gt;1&lt;/code&gt; &lt;code&gt;y&lt;/code&gt; times.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [328 Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)


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