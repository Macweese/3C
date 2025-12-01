[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2141. Maximum Running Time of N Computers

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2141](https://leetcode.com/problems/maximum-running-time-of-n-computers/)

## Description

<p>You have <code>n</code> computers. You are given the integer <code>n</code> and a <strong>0-indexed</strong> integer array <code>batteries</code> where the <code>i<sup>th</sup></code> battery can <strong>run</strong> a computer for <code>batteries[i]</code> minutes. You are interested in running <strong>all</strong> <code>n</code> computers <strong>simultaneously</strong> using the given batteries.</p><p>Initially, you can insert <strong>at most one battery</strong> into each computer. After that and at any integer time moment, you can remove a battery from a computer and insert another battery <strong>any number of times</strong>. The inserted battery can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.</p><p>Note that the batteries cannot be recharged.</p><p>Return <em>the <strong>maximum</strong> number of minutes you can run all the </em><code>n</code><em> computers simultaneously.</em></p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/01/06/example1-fit.png" style="width: 762px; height: 150px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
n = 2, batteries = [3,3,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Initially, insert battery 0 into the first computer and battery 1 into the second computer.
After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1 can still run for one minute.
At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert battery 1 instead.
By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
We can run the two computers simultaneously for at most 4 minutes, so we return 4.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/01/06/example2.png" style="width: 629px; height: 150px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
n = 2, batteries = [1,1,1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Initially, insert battery 0 into the first computer and battery 2 into the second computer. 
After one minute, battery 0 and battery 2 are drained so you need to remove them and insert battery 1 into the first computer and battery 3 into the second computer. 
After another minute, battery 1 and battery 3 are also drained so the first and second computers are no longer running.
We can run the two computers simultaneously for at most 2 minutes, so we return 2.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= batteries.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= batteries[i] &lt;= 10<sup>9</sup></code></li>
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
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  For a given running time, can you determine if it is possible to run all n computers simultaneously?
</details>
<details>
  <summary>Hint 2</summary>
  Try to use Binary Search to find the maximal running time
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [453 Minimum Moves to Equal Array Elements](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)
* [1648 Sell Diminishing-Valued Colored Balls](https://leetcode.com/problems/sell-diminishing-valued-colored-balls/)
* [2071 Maximum Number of Tasks You Can Assign](https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/)
* [2187 Minimum Time to Complete Trips](https://leetcode.com/problems/minimum-time-to-complete-trips/)
* [2335 Minimum Amount of Time to Fill Cups](https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-01, Mon 01 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )