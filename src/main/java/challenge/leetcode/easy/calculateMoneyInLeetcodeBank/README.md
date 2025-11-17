[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1716. Calculate Money in Leetcode Bank

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1716](https://leetcode.com/problems/calculate-money-in-leetcode-bank/)

## Description

<p>Hercy wants to save money for his first car. He puts money in the Leetcode bank <strong>every day</strong>.</p><p>He starts by putting in <code>$1</code> on Monday, the first day. Every day from Tuesday to Sunday, he will put in <code>$1</code> more than the day before. On every subsequent Monday, he will put in <code>$1</code> more than the <strong>previous Monday</strong>.<span style="display: none;"> </span></p><p>Given <code>n</code>, return <em>the total amount of money he will have in the Leetcode bank at the end of the </em><code>n<sup>th</sup></code><em> day.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
10
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After the 4<sup>th</sup> day, the total is 1 + 2 + 3 + 4 = 10.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
37
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After the 10<sup>th</sup> day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2<sup>nd</sup> Monday, Hercy only puts in $2.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 20
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
96
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After the 20<sup>th</sup> day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 1000</code></li>
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


---

<details>
  <summary>Hint 1</summary>
  Simulate the process by keeping track of how much money Hercy is putting in and which day of the week it is, and use this information to deduce how much money Hercy will put in the next day.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2591 Distribute Money to Maximum Children](https://leetcode.com/problems/distribute-money-to-maximum-children/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-25, Sat 25 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )