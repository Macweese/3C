[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3100. Water Bottles II

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3100](https://leetcode.com/problems/water-bottles-ii/)

## Description

<p>You are given two integers <code>numBottles</code> and <code>numExchange</code>.</p><p><code>numBottles</code> represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:</p><ul>
<li>Drink any number of full water bottles turning them into empty bottles.</li>
<li>Exchange <code>numExchange</code> empty bottles with one full water bottle. Then, increase <code>numExchange</code> by one.</li>
</ul><p>Note that you cannot exchange multiple batches of empty bottles for the same value of <code>numExchange</code>. For example, if <code>numBottles == 3</code> and <code>numExchange == 1</code>, you cannot exchange <code>3</code> empty water bottles for <code>3</code> full bottles.</p><p>Return <em>the <strong>maximum</strong> number of water bottles you can drink</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/01/28/exampleone1.png" style="width: 948px; height: 482px; padding: 10px; background: #fff; border-radius: .5rem;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
numBottles = 13, numExchange = 6
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
15
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/01/28/example231.png" style="width: 990px; height: 642px; padding: 10px; background: #fff; border-radius: .5rem;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
numBottles = 10, numExchange = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
13
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= numBottles &lt;= 100 </code></li>
<li><code>1 &lt;= numExchange &lt;= 100</code></li>
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
`simulation`


---

<details>
  <summary>Hint 1</summary>
  Simulate the process step by step. At each step, drink &lt;code&gt;numExchange&lt;/code&gt; bottles of water then exchange them for a full bottle. Keep repeating this step until you cannot exchange  bottles anymore.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1518 Water Bottles](https://leetcode.com/problems/water-bottles/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-02, Thu 02 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )