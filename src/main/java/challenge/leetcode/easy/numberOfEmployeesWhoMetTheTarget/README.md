[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2798. Number of Employees Who Met the Target

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2798](https://leetcode.com/problems/number-of-employees-who-met-the-target/)

## Description

<p>There are <code>n</code> employees in a company, numbered from <code>0</code> to <code>n - 1</code>. Each employee <code>i</code> has worked for <code>hours[i]</code> hours in the company.</p><p>The company requires each employee to work for <strong>at least</strong> <code>target</code> hours.</p><p>You are given a <strong>0-indexed</strong> array of non-negative integers <code>hours</code> of length <code>n</code> and a non-negative integer <code>target</code>.</p><p>Return <em>the integer denoting the number of employees who worked at least</em> <code>target</code> <em>hours</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
hours = [0,1,2,3,4], target = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The company wants each employee to work for at least 2 hours.
- Employee 0 worked for 0 hours and didn't meet the target.
- Employee 1 worked for 1 hours and didn't meet the target.
- Employee 2 worked for 2 hours and met the target.
- Employee 3 worked for 3 hours and met the target.
- Employee 4 worked for 4 hours and met the target.
There are 3 employees who met the target.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
hours = [5,1,4,2,2], target = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The company wants each employee to work for at least 6 hours.
There are 0 employees who met the target.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == hours.length &lt;= 50</code></li>
<li><code>0 &lt;= hours[i], target &lt;= 10<sup>5</sup></code></li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Iterate over the elements of array hours and check if the value is greater than or equal to target.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [3065 Minimum Operations to Exceed Threshold Value I](https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/)


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