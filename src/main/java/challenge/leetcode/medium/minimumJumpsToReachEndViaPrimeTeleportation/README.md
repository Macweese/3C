[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3629. Minimum Jumps to Reach End via Prime Teleportation

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3629](https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/)

## Description

<p>You are given an integer array <code>nums</code> of length <code>n</code>.</p><p>You start at index 0, and your goal is to reach index <code>n - 1</code>.</p><p>From any index <code>i</code>, you may perform one of the following operations:</p><ul>
<li><strong>Adjacent Step</strong>: Jump to index <code>i + 1</code> or <code>i - 1</code>, if the index is within bounds.</li>
<li><strong>Prime Teleportation</strong>: If <code>nums[i]</code> is a <span data-keyword="prime-number">prime number</span> <code>p</code>, you may instantly jump to any index <code>j != i</code> such that <code>nums[j] % p == 0</code>.</li>
</ul><p>Return the <strong>minimum</strong> number of jumps required to reach index <code>n - 1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,4,6]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>One optimal sequence of jumps is:</p><ul>
<li>Start at index <code>i = 0</code>. Take an adjacent step to index 1.</li>
<li>At index <code>i = 1</code>, <code>nums[1] = 2</code> is a prime number. Therefore, we teleport to index <code>i = 3</code> as <code>nums[3] = 6</code> is divisible by 2.</li>
</ul><p>Thus, the answer is 2.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,3,4,7,9]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>One optimal sequence of jumps is:</p><ul>
<li>Start at index <code>i = 0</code>. Take an adjacent step to index <code>i = 1</code>.</li>
<li>At index <code>i = 1</code>, <code>nums[1] = 3</code> is a prime number. Therefore, we teleport to index <code>i = 4</code> since <code>nums[4] = 9</code> is divisible by 3.</li>
</ul><p>Thus, the answer is 2.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [4,6,5,8]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Since no teleportation is possible, we move through <code>0 → 1 → 2 → 3</code>. Thus, the answer is 3.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`math`
`breadth-first search`
`number theory`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use a breadth-first search.
</details>
<details>
  <summary>Hint 2</summary>
  Precompute prime factors of each &lt;code&gt;nums[i]&lt;/code&gt; via a sieve, and build a bucket &lt;code&gt;bucket[p]&lt;/code&gt; mapping each prime &lt;code&gt;p&lt;/code&gt; to all indices &lt;code&gt;j&lt;/code&gt; with &lt;code&gt;nums[j] % p == 0&lt;/code&gt;.
</details>
<details>
  <summary>Hint 3</summary>
  During the BFS, when at index &lt;code&gt;i&lt;/code&gt;, enqueue its adjacent steps (&lt;code&gt;i+1&lt;/code&gt; and &lt;code&gt;i-1&lt;/code&gt;) and all indices in &lt;code&gt;bucket[p]&lt;/code&gt; for each prime &lt;code&gt;p&lt;/code&gt; dividing &lt;code&gt;nums[i]&lt;/code&gt;, then clear &lt;code&gt;bucket[p]&lt;/code&gt; so each prime&#39;s bucket is visited only once.
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

`2026-05-08, Fri 08 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )