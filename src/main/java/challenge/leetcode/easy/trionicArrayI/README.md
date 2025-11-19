[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3637. Trionic Array I

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3637](https://leetcode.com/problems/trionic-array-i/)

## Description

<p data-end="128" data-start="0">You are given an integer array <code data-end="37" data-start="31">nums</code> of length <code data-end="51" data-start="48">n</code>.</p><p data-end="128" data-start="0">An array is <strong data-end="76" data-start="65">trionic</strong> if there exist indices <code data-end="117" data-start="100">0 &lt; p &lt; q &lt; n − 1</code> such that:</p><ul>
<li data-end="170" data-start="132"><code data-end="144" data-start="132">nums[0...p]</code> is <strong>strictly</strong> increasing,</li>
<li data-end="211" data-start="173"><code data-end="185" data-start="173">nums[p...q]</code> is <strong>strictly</strong> decreasing,</li>
<li data-end="252" data-start="214"><code data-end="228" data-start="214">nums[q...n − 1]</code> is <strong>strictly</strong> increasing.</li>
</ul><p data-end="315" data-is-last-node="" data-is-only-node="" data-start="254">Return <code data-end="267" data-start="261">true</code> if <code data-end="277" data-start="271">nums</code> is trionic, otherwise return <code data-end="314" data-start="307">false</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,3,5,4,2,6]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>Pick <code data-end="91" data-start="84">p = 2</code>, <code data-end="100" data-start="93">q = 4</code>:</p><ul>
<li><code data-end="130" data-start="108">nums[0...2] = [1, 3, 5]</code> is strictly increasing (<code data-end="166" data-start="155">1 &lt; 3 &lt; 5</code>).</li>
<li><code data-end="197" data-start="175">nums[2...4] = [5, 4, 2]</code> is strictly decreasing (<code data-end="233" data-start="222">5 &gt; 4 &gt; 2</code>).</li>
<li><code data-end="262" data-start="242">nums[4...5] = [2, 6]</code> is strictly increasing (<code data-end="294" data-start="287">2 &lt; 6</code>).</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,1,3]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There is no way to pick <code>p</code> and <code>q</code> to form the required three segments.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li data-end="41" data-start="26"><code data-end="39" data-start="26">3 &lt;= n &lt;= 100</code></li>
<li data-end="70" data-start="44"><code data-end="70" data-start="44">-1000 &lt;= nums[i] &lt;= 1000</code></li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use brute force
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


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )