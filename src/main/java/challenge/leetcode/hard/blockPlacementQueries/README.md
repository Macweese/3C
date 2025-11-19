[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3161. Block Placement Queries

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3161](https://leetcode.com/problems/block-placement-queries/)

## Description

<p>There exists an infinite number line, with its origin at 0 and extending towards the <strong>positive</strong> x-axis.</p><p>You are given a 2D array <code>queries</code>, which contains two types of queries:</p><ol>
<li>For a query of type 1, <code>queries[i] = [1, x]</code>. Build an obstacle at distance <code>x</code> from the origin. It is guaranteed that there is <strong>no</strong> obstacle at distance <code>x</code> when the query is asked.</li>
<li>For a query of type 2, <code>queries[i] = [2, x, sz]</code>. Check if it is possible to place a block of size <code>sz</code> <em>anywhere</em> in the range <code>[0, x]</code> on the line, such that the block <strong>entirely</strong> lies in the range <code>[0, x]</code>. A block <strong>cannot </strong>be placed if it intersects with any obstacle, but it may touch it. Note that you do<strong> not</strong> actually place the block. Queries are separate.</li>
</ol><p>Return a boolean array <code>results</code>, where <code>results[i]</code> is <code>true</code> if you can place the block specified in the <code>i<sup>th</sup></code> query of type 2, and <code>false</code> otherwise.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/04/22/example0block.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 309px; height: 129px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[false,true,true]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/04/22/example0block.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 309px; height: 129px;"/></strong></p><p>For query 0, place an obstacle at <code>x = 2</code>. A block of size at most 2 can be placed before <code>x = 3</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2024/04/22/example1block.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 310px; height: 130px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">queries = </span>[[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]<!-- notionvc: 4a471445-5af1-4d72-b11b-94d351a2c8e9 -->
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[true,true,false]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/04/22/example1block.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 310px; height: 130px;"/></strong></p><ul>
<li>Place an obstacle at <code>x = 7</code> for query 0. A block of size at most 7 can be placed before <code>x = 7</code>.</li>
<li>Place an obstacle at <code>x = 2</code> for query 2. Now, a block of size at most 5 can be placed before <code>x = 7</code>, and a block of size at most 2 before <code>x = 2</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= queries.length &lt;= 15 * 10<sup>4</sup></code></li>
<li><code>2 &lt;= queries[i].length &lt;= 3</code></li>
<li><code>1 &lt;= queries[i][0] &lt;= 2</code></li>
<li><code>1 &lt;= x, sz &lt;= min(5 * 10<sup>4</sup>, 3 * queries.length)</code></li>
<li>The input is generated such that for queries of type 1, no obstacle exists at distance <code>x</code> when the query is asked.</li>
<li>The input is generated such that there is at least one query of type 2.</li>
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
`binary indexed tree`
`segment tree`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let &lt;code&gt;d[x]&lt;/code&gt; be the distance of the next obstacle after &lt;code&gt;x&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  For each query of type 2, we just need to check if &lt;code&gt;max(d[0], d[1], d[2], …d[x - sz]) &gt; sz&lt;/code&gt;.
</details>
<details>
  <summary>Hint 3</summary>
  Use segment tree to maintain &lt;code&gt;d[x]&lt;/code&gt;.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1739 Building Boxes](https://leetcode.com/problems/building-boxes/)
* [3479 Fruits Into Baskets III](https://leetcode.com/problems/fruits-into-baskets-iii/)


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