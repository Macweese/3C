[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2144. Minimum Cost of Buying Candies With Discount

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2144](https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/)

## Description

<p>A shop is selling candies at a discount. For <strong>every two</strong> candies sold, the shop gives a <strong>third</strong> candy for <strong>free</strong>.</p><p>The customer can choose <strong>any</strong> candy to take away for free as long as the cost of the chosen candy is less than or equal to the <strong>minimum</strong> cost of the two candies bought.</p><ul>
<li>For example, if there are <code>4</code> candies with costs <code>1</code>, <code>2</code>, <code>3</code>, and <code>4</code>, and the customer buys candies with costs <code>2</code> and <code>3</code>, they can take the candy with cost <code>1</code> for free, but not the candy with cost <code>4</code>.</li>
</ul><p>Given a <strong>0-indexed</strong> integer array <code>cost</code>, where <code>cost[i]</code> denotes the cost of the <code>i<sup>th</sup></code> candy, return <em>the <strong>minimum cost</strong> of buying <strong>all</strong> the candies</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
cost = [1,2,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We buy the candies with costs 2 and 3, and take the candy with cost 1 for free.
The total cost of buying all candies is 2 + 3 = 5. This is the <strong>only</strong> way we can buy the candies.
Note that we cannot buy candies with costs 1 and 3, and then take the candy with cost 2 for free.
The cost of the free candy has to be less than or equal to the minimum cost of the purchased candies.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
cost = [6,5,7,9,2,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
23
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The way in which we can get the minimum cost is described below:
- Buy candies with costs 9 and 7
- Take the candy with cost 6 for free
- We buy candies with costs 5 and 2
- Take the last remaining candy with cost 2 for free
Hence, the minimum cost to buy all candies is 9 + 7 + 5 + 2 = 23.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
cost = [5,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
10
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Since there are only 2 candies, we buy both of them. There is not a third candy we can take for free.
Hence, the minimum cost to buy all candies is 5 + 5 = 10.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= cost.length &lt;= 100</code></li>
<li><code>1 &lt;= cost[i] &lt;= 100</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If we consider costs from high to low, what is the maximum cost of a single candy that we can get for free?
</details>
<details>
  <summary>Hint 2</summary>
  How can we generalize this approach to maximize the costs of the candies we get for free?
</details>
<details>
  <summary>Hint 3</summary>
  Can “sorting” the array help us find the minimum cost?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [561 Array Partition](https://leetcode.com/problems/array-partition/)
* [1200 Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)
* [3122 Minimum Number of Operations to Satisfy Conditions](https://leetcode.com/problems/minimum-number-of-operations-to-satisfy-conditions/)
* [3142 Check if Grid Satisfies Conditions](https://leetcode.com/problems/check-if-grid-satisfies-conditions/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-06-01, Mon 01 June 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )