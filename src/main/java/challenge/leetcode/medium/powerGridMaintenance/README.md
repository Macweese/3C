[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3607. Power Grid Maintenance

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3607](https://leetcode.com/problems/power-grid-maintenance/)

## Description

<p data-end="401" data-start="120">You are given an integer <code data-end="194" data-start="191">c</code> representing <code data-end="211" data-start="208">c</code> power stations, each with a unique identifier <code>id</code> from 1 to <code>c</code> (1‑based indexing).</p><p data-end="401" data-start="120">These stations are interconnected via <code data-end="295" data-start="292">n</code> <strong>bidirectional</strong> cables, represented by a 2D array <code data-end="357" data-start="344">connections</code>, where each element <code data-end="430" data-start="405">connections[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> indicates a connection between station <code>u<sub>i</sub></code> and station <code>v<sub>i</sub></code>. Stations that are directly or indirectly connected form a <strong>power grid</strong>.</p><p data-end="626" data-start="586">Initially, <strong>all</strong> stations are online (operational).</p><p data-end="720" data-start="628">You are also given a 2D array <code data-end="667" data-start="658">queries</code>, where each query is one of the following <em>two</em> types:</p><ul data-end="995" data-start="722">
<li data-end="921" data-start="722">
<p data-end="921" data-start="724"><code data-end="732" data-start="724">[1, x]</code>: A maintenance check is requested for station <code data-end="782" data-start="779">x</code>. If station <code>x</code> is online, it resolves the check by itself. If station <code>x</code> is offline, the check is resolved by the operational station with the smallest <code>id</code> in the same <strong>power grid</strong> as <code>x</code>. If <strong>no</strong> <strong>operational</strong> station <em>exists</em> in that grid, return -1.</p>
</li>
<li data-end="995" data-start="923">
<p data-end="995" data-start="925"><code data-end="933" data-start="925">[2, x]</code>: Station <code data-end="946" data-start="943">x</code> goes offline (i.e., it becomes non-operational).</p>
</li>
</ul><p data-end="1106" data-start="997">Return an array of integers representing the results of each query of type <code data-end="1080" data-start="1072">[1, x]</code> in the <strong>order</strong> they appear.</p><p data-end="1106" data-start="997"><strong>Note:</strong> The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2025/04/15/powergrid.jpg" style="width: 361px; height: 42px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[3,2,3]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/15/powergrid.jpg" style="width: 361px; height: 42px;"/></p><ul>
<li data-end="223" data-start="143">Initially, all stations <code>{1, 2, 3, 4, 5}</code> are online and form a single power grid.</li>
<li data-end="322" data-start="226">Query <code>[1,3]</code>: Station 3 is online, so the maintenance check is resolved by station 3.</li>
<li data-end="402" data-start="325">Query <code>[2,1]</code>: Station 1 goes offline. The remaining online stations are <code>{2, 3, 4, 5}</code>.</li>
<li data-end="557" data-start="405">Query <code>[1,1]</code>: Station 1 is offline, so the check is resolved by the operational station with the smallest <code>id</code> among <code>{2, 3, 4, 5}</code>, which is station 2.</li>
<li data-end="641" data-start="560">Query <code>[2,2]</code>: Station 2 goes offline. The remaining online stations are <code>{3, 4, 5}</code>.</li>
<li data-end="800" data-start="644">Query <code>[1,2]</code>: Station 2 is offline, so the check is resolved by the operational station with the smallest <code>id</code> among <code>{3, 4, 5}</code>, which is station 3.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[1,-1]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li data-end="976" data-start="909">There are no connections, so each station is its own isolated grid.</li>
<li data-end="1096" data-start="979">Query <code>[1,1]</code>: Station 1 is online in its isolated grid, so the maintenance check is resolved by station 1.</li>
<li data-end="1135" data-start="1099">Query <code>[2,1]</code>: Station 1 goes offline.</li>
<li data-end="1237" data-start="1138">Query <code>[1,1]</code>: Station 1 is offline and there are no other stations in its grid, so the result is -1.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li data-end="155" data-start="139"><code>1 &lt;= c &lt;= 10<sup>5</sup></code></li>
<li data-end="213" data-start="158"><code>0 &lt;= n == connections.length &lt;= min(10<sup>5</sup>, c * (c - 1) / 2)</code></li>
<li data-end="244" data-start="216"><code>connections[i].length == 2</code></li>
<li data-end="295" data-start="247"><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= c</code></li>
<li data-end="338" data-start="298"><code>u<sub>i</sub> != v<sub>i</sub></code></li>
<li data-end="374" data-start="341"><code>1 &lt;= queries.length &lt;= 2 * 10<sup>5</sup></code></li>
<li data-end="401" data-start="377"><code>queries[i].length == 2</code></li>
<li data-end="436" data-start="404"><code>queries[i][0]</code> is either 1 or 2.</li>
<li data-end="462" data-start="439"><code>1 &lt;= queries[i][1] &lt;= c</code></li>
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
`hash table`
`depth-first search`
`breadth-first search`
`union find`
`graph`
`heap (priority queue)`
`ordered set`


---

<details>
  <summary>Hint 1</summary>
  Use DFS or BFS to assign each station a component ID
</details>
<details>
  <summary>Hint 2</summary>
  For each component, maintain a sorted set of online station IDs
</details>
<details>
  <summary>Hint 3</summary>
  For query &lt;code&gt;[2, x]&lt;/code&gt;, remove &lt;code&gt;x&lt;/code&gt; from the set of its component
</details>
<details>
  <summary>Hint 4</summary>
  For query &lt;code&gt;[1, x]&lt;/code&gt;, if &lt;code&gt;x&lt;/code&gt; is in its component’s set return &lt;code&gt;x&lt;/code&gt;; otherwise if the set is non-empty return its smallest element; else return &lt;code&gt;-1&lt;/code&gt;
</details>
<details>
  <summary>Hint 5</summary>
  Precompute all components and then handle each query in O(log n) time using the sorted sets
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-06, Thu 06 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )