[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3652. Best Time to Buy and Sell Stock using Strategy

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3652](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/)

## Description

<p>You are given two integer arrays <code>prices</code> and <code>strategy</code>, where:</p><ul>
<li><code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</li>
<li><code>strategy[i]</code> represents a trading action on the <code>i<sup>th</sup></code> day, where:
	<ul>
<li><code>-1</code> indicates buying one unit of the stock.</li>
<li><code>0</code> indicates holding the stock.</li>
<li><code>1</code> indicates selling one unit of the stock.</li>
</ul>
</li>
</ul><p>You are also given an <strong>even</strong> integer <code>k</code>, and may perform <strong>at most one</strong> modification to <code>strategy</code>. A modification consists of:</p><ul>
<li>Selecting exactly <code>k</code> <strong>consecutive</strong> elements in <code>strategy</code>.</li>
<li>Set the <strong>first</strong> <code>k / 2</code> elements to <code>0</code> (hold).</li>
<li>Set the <strong>last</strong> <code>k / 2</code> elements to <code>1</code> (sell).</li>
</ul><p>The <strong>profit</strong> is defined as the <strong>sum</strong> of <code>strategy[i] * prices[i]</code> across all days.</p><p>Return the <strong>maximum</strong> possible profit you can achieve.</p><p><strong>Note:</strong> There are no constraints on budget or stock ownership, so all buy and sell operations are feasible regardless of past actions.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">prices = [4,2,8], strategy = [-1,0,1], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">10</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<table style="border: 1px solid black;">
<thead>
<tr>
<th style="border: 1px solid black;">Modification</th>
<th style="border: 1px solid black;">Strategy</th>
<th style="border: 1px solid black;">Profit Calculation</th>
<th style="border: 1px solid black;">Profit</th>
</tr>
</thead>
<tbody>
<tr>
<td style="border: 1px solid black;">Original</td>
<td style="border: 1px solid black;">[-1, 0, 1]</td>
<td style="border: 1px solid black;">(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8</td>
<td style="border: 1px solid black;">4</td>
</tr>
<tr>
<td style="border: 1px solid black;">Modify [0, 1]</td>
<td style="border: 1px solid black;">[0, 1, 1]</td>
<td style="border: 1px solid black;">(0 × 4) + (1 × 2) + (1 × 8) = 0 + 2 + 8</td>
<td style="border: 1px solid black;">10</td>
</tr>
<tr>
<td style="border: 1px solid black;">Modify [1, 2]</td>
<td style="border: 1px solid black;">[-1, 0, 1]</td>
<td style="border: 1px solid black;">(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8</td>
<td style="border: 1px solid black;">4</td>
</tr>
</tbody>
</table><p>Thus, the maximum possible profit is 10, which is achieved by modifying the subarray <code>[0, 1]</code>​​​​​​​.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">prices = [5,4,3], strategy = [1,1,0], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">9</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<div class="example-block">
<table style="border: 1px solid black;">
<thead>
<tr>
<th style="border: 1px solid black;">Modification</th>
<th style="border: 1px solid black;">Strategy</th>
<th style="border: 1px solid black;">Profit Calculation</th>
<th style="border: 1px solid black;">Profit</th>
</tr>
</thead>
<tbody>
<tr>
<td style="border: 1px solid black;">Original</td>
<td style="border: 1px solid black;">[1, 1, 0]</td>
<td style="border: 1px solid black;">(1 × 5) + (1 × 4) + (0 × 3) = 5 + 4 + 0</td>
<td style="border: 1px solid black;">9</td>
</tr>
<tr>
<td style="border: 1px solid black;">Modify [0, 1]</td>
<td style="border: 1px solid black;">[0, 1, 0]</td>
<td style="border: 1px solid black;">(0 × 5) + (1 × 4) + (0 × 3) = 0 + 4 + 0</td>
<td style="border: 1px solid black;">4</td>
</tr>
<tr>
<td style="border: 1px solid black;">Modify [1, 2]</td>
<td style="border: 1px solid black;">[1, 0, 1]</td>
<td style="border: 1px solid black;">(1 × 5) + (0 × 4) + (1 × 3) = 5 + 0 + 3</td>
<td style="border: 1px solid black;">8</td>
</tr>
</tbody>
</table>
<p>Thus, the maximum possible profit is 9, which is achieved without any modification.</p>
</div>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= prices.length == strategy.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li>
<li><code>-1 &lt;= strategy[i] &lt;= 1</code></li>
<li><code>2 &lt;= k &lt;= prices.length</code></li>
<li><code>k</code> is even</li>
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
`sliding window`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use prefix sums to precompute the base profit and to get fast range queries (sums of &lt;code&gt;prices&lt;/code&gt; and counts of each &lt;code&gt;strategy&lt;/code&gt; value over any interval).
</details>
<details>
  <summary>Hint 2</summary>
  Try every segment of length &lt;code&gt;k&lt;/code&gt;: compute the profit delta caused by replacing that segment (using the prefix queries) and take the maximum of &lt;code&gt;base + delta&lt;/code&gt;.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-18, Thu 18 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )