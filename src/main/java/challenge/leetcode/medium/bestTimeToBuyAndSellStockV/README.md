[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3573. Best Time to Buy and Sell Stock V

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3573](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/)

## Description

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a stock in dollars on the <code>i<sup>th</sup></code> day, and an integer <code>k</code>.</p><p>You are allowed to make at most <code>k</code> transactions, where each transaction can be either of the following:</p><ul>
<li>
<p><strong>Normal transaction</strong>: Buy on day <code>i</code>, then sell on a later day <code>j</code> where <code>i &lt; j</code>. You profit <code>prices[j] - prices[i]</code>.</p>
</li>
<li>
<p><strong>Short selling transaction</strong>: Sell on day <code>i</code>, then buy back on a later day <code>j</code> where <code>i &lt; j</code>. You profit <code>prices[i] - prices[j]</code>.</p>
</li>
</ul><p><strong>Note</strong> that you must complete each transaction before starting another. Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.</p><p>Return the <strong>maximum</strong> total profit you can earn by making <strong>at most</strong> <code>k</code> transactions.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">prices = [1,7,9,8,2], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">14</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can make $14 of profit through 2 transactions:

<ul>
<li>A normal transaction: buy the stock on day 0 for $1 then sell it on day 2 for $9.</li>
<li>A short selling transaction: sell the stock on day 3 for $8 then buy back on day 4 for $2.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">prices = [12,16,19,19,8,1,19,13,9], k = 3</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">36</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can make $36 of profit through 3 transactions:

<ul>
<li>A normal transaction: buy the stock on day 0 for $12 then sell it on day 2 for $19.</li>
<li>A short selling transaction: sell the stock on day 3 for $19 then buy back on day 4 for $8.</li>
<li>A normal transaction: buy the stock on day 5 for $1 then sell it on day 6 for $19.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= prices.length &lt;= 10<sup>3</sup></code></li>
<li><code>1 &lt;= prices[i] &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= k &lt;= prices.length / 2</code></li>
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
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use dynamic programming.
</details>
<details>
  <summary>Hint 2</summary>
  Keep the following states: &lt;code&gt;idx&lt;/code&gt;, &lt;code&gt;transactionsDone&lt;/code&gt;, &lt;code&gt;transactionType&lt;/code&gt;, &lt;code&gt;isTransactionRunning&lt;/code&gt;.
</details>
<details>
  <summary>Hint 3</summary>
  Transactions transition from completed -&gt; running and from running -&gt; completed.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [121 Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-17, Wed 17 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )