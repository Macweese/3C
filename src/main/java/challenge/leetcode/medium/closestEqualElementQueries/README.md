[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3488. Closest Equal Element Queries

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3488](https://leetcode.com/problems/closest-equal-element-queries/)

## Description

<p>You are given a <strong>circular</strong> array <code>nums</code> and an array <code>queries</code>.</p><p>For each query <code>i</code>, you have to find the following:</p><ul>
<li>The <strong>minimum</strong> distance between the element at index <code>queries[i]</code> and <strong>any</strong> other index <code>j</code> in the <strong>circular</strong> array, where <code>nums[j] == nums[queries[i]]</code>. If no such index exists, the answer for that query should be -1.</li>
</ul><p>Return an array <code>answer</code> of the <strong>same</strong> size as <code>queries</code>, where <code>answer[i]</code> represents the result for query <code>i</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,3,1,4,1,3,2], queries = [0,3,5]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[2,-1,3]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Query 0: The element at <code>queries[0] = 0</code> is <code>nums[0] = 1</code>. The nearest index with the same value is 2, and the distance between them is 2.</li>
<li>Query 1: The element at <code>queries[1] = 3</code> is <code>nums[3] = 4</code>. No other index contains 4, so the result is -1.</li>
<li>Query 2: The element at <code>queries[2] = 5</code> is <code>nums[5] = 3</code>. The nearest index with the same value is 1, and the distance between them is 3 (following the circular path: <code>5 -&gt; 6 -&gt; 0 -&gt; 1</code>).</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,3,4], queries = [0,1,2,3]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[-1,-1,-1,-1]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>Each value in <code>nums</code> is unique, so no index shares the same value as the queried element. This results in -1 for all queries.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= queries.length &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
<li><code>0 &lt;= queries[i] &lt; nums.length</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`binary search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use a dictionary that maps each unique value in the array to a sorted list of its indices.
</details>
<details>
  <summary>Hint 2</summary>
  For each query, use binary search on the sorted indices list to find the nearest occurrences of the target value.
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

`2026-04-16, Thu 16 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )