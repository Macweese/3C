[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2578. Split With Minimum Sum

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2578](https://leetcode.com/problems/split-with-minimum-sum/)

## Description

<p>Given a positive integer <code>num</code>, split it into two non-negative integers <code>num1</code> and <code>num2</code> such that:</p><ul>
<li>The concatenation of <code>num1</code> and <code>num2</code> is a permutation of <code>num</code>.

	<ul>
<li>In other words, the sum of the number of occurrences of each digit in <code>num1</code> and <code>num2</code> is equal to the number of occurrences of that digit in <code>num</code>.</li>
</ul>
</li>
<li><code>num1</code> and <code>num2</code> can contain leading zeros.</li>
</ul><p>Return <em>the <strong>minimum</strong> possible sum of</em> <code>num1</code> <em>and</em> <code>num2</code>.</p><p><strong>Notes:</strong></p><ul>
<li>It is guaranteed that <code>num</code> does not contain any leading zeros.</li>
<li>The order of occurrence of the digits in <code>num1</code> and <code>num2</code> may differ from the order of occurrence of <code>num</code>.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = 4325
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
59
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can split 4325 so that <code>num1</code> is 24 and <code>num2</code> is 35, giving a sum of 59. We can prove that 59 is indeed the minimal possible sum.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = 687
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
75
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can split 687 so that <code>num1</code> is 68 and <code>num2</code> is 7, which would give an optimal sum of 75.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>10 &lt;= num &lt;= 10<sup>9</sup></code></li>
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

`math`
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sort the digits of num in non decreasing order.
</details>
<details>
  <summary>Hint 2</summary>
  Assign digits to num1 and num2 alternatively.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [416 Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [1217 Minimum Cost to Move Chips to The Same Position](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/)
* [2035 Partition Array Into Two Arrays to Minimize Sum Difference](https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/)
* [3117 Minimum Sum of Values by Dividing Array](https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/)


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