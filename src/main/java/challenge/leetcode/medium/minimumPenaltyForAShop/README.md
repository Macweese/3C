[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2483. Minimum Penalty for a Shop

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2483](https://leetcode.com/problems/minimum-penalty-for-a-shop/)

## Description

<p>You are given the customer visit log of a shop represented by a <strong>0-indexed</strong> string <code>customers</code> consisting only of characters <code>'N'</code> and <code>'Y'</code>:</p><ul>
<li>if the <code>i<sup>th</sup></code> character is <code>'Y'</code>, it means that customers come at the <code>i<sup>th</sup></code> hour</li>
<li>whereas <code>'N'</code> indicates that no customers come at the <code>i<sup>th</sup></code> hour.</li>
</ul><p>If the shop closes at the <code>j<sup>th</sup></code> hour (<code>0 &lt;= j &lt;= n</code>), the <strong>penalty</strong> is calculated as follows:</p><ul>
<li>For every hour when the shop is open and no customers come, the penalty increases by <code>1</code>.</li>
<li>For every hour when the shop is closed and customers come, the penalty increases by <code>1</code>.</li>
</ul><p>Return<em> the <strong>earliest</strong> hour at which the shop must be closed to incur a <strong>minimum</strong> penalty.</em></p><p><strong>Note</strong> that if a shop closes at the <code>j<sup>th</sup></code> hour, it means the shop is closed at the hour <code>j</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
customers = "YYNY"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- Closing the shop at the 0<sup>th</sup> hour incurs in 1+1+0+1 = 3 penalty.
- Closing the shop at the 1<sup>st</sup> hour incurs in 0+1+0+1 = 2 penalty.
- Closing the shop at the 2<sup>nd</sup> hour incurs in 0+0+0+1 = 1 penalty.
- Closing the shop at the 3<sup>rd</sup> hour incurs in 0+0+1+1 = 2 penalty.
- Closing the shop at the 4<sup>th</sup> hour incurs in 0+0+1+0 = 1 penalty.
Closing the shop at 2<sup>nd</sup> or 4<sup>th</sup> hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
customers = "NNNNN"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is best to close the shop at the 0<sup>th</sup> hour as no customers arrive.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
customers = "YYYY"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It is best to close the shop at the 4<sup>th</sup> hour as customers arrive at each hour.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= customers.length &lt;= 10<sup>5</sup></code></li>
<li><code>customers</code> consists only of characters <code>'Y'</code> and <code>'N'</code>.</li>
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

`string`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  At any index, the penalty is the sum of prefix count of ‘N’ and suffix count of ‘Y’.
</details>
<details>
  <summary>Hint 2</summary>
  Enumerate all indices and find the minimum such value.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [2017 Grid Game](https://leetcode.com/problems/grid-game/)
* [3273 Minimum Amount of Damage Dealt to Bob](https://leetcode.com/problems/minimum-amount-of-damage-dealt-to-bob/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-26, Fri 26 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )