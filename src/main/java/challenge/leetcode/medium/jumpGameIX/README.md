[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3660. Jump Game IX

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3660](https://leetcode.com/problems/jump-game-ix/)

## Description

<p>You are given an integer array <code>nums</code>.</p><p>From any index <code>i</code>, you can jump to another index <code>j</code> under the following rules:</p><ul>
<li>Jump to index <code>j</code> where <code>j &gt; i</code> is allowed only if <code>nums[j] &lt; nums[i]</code>.</li>
<li>Jump to index <code>j</code> where <code>j &lt; i</code> is allowed only if <code>nums[j] &gt; nums[i]</code>.</li>
</ul><p>For each index <code>i</code>, find the <strong>maximum</strong> <strong>value</strong> in <code>nums</code> that can be reached by following <strong>any</strong> sequence of valid jumps starting at <code>i</code>.</p><p>Return an array <code>ans</code> where <code>ans[i]</code> is the <strong>maximum</strong> <strong>value</strong> reachable starting from index <code>i</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,1,3]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[2,2,3]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>For <code>i = 0</code>: No jump increases the value.</li>
<li>For <code>i = 1</code>: Jump to <code>j = 0</code> as <code>nums[j] = 2</code> is greater than <code>nums[i]</code>.</li>
<li>For <code>i = 2</code>: Since <code>nums[2] = 3</code> is the maximum value in <code>nums</code>, no jump increases the value.</li>
</ul><p>Thus, <code>ans = [2, 2, 3]</code>.</p><ul>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,3,1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[3,3,3]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>For <code>i = 0</code>: Jump forward to <code>j = 2</code> as <code>nums[j] = 1</code> is less than <code>nums[i] = 2</code>, then from <code>i = 2</code> jump to <code>j = 1</code> as <code>nums[j] = 3</code> is greater than <code>nums[2]</code>.</li>
<li>For <code>i = 1</code>: Since <code>nums[1] = 3</code> is the maximum value in <code>nums</code>, no jump increases the value.</li>
<li>For <code>i = 2</code>: Jump to <code>j = 1</code> as <code>nums[j] = 3</code> is greater than <code>nums[2] = 1</code>.</li>
</ul><p>Thus, <code>ans = [3, 3, 3]</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup>​​​​​​​</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Think of the array as a directed graph where edges represent valid jumps.
</details>
<details>
  <summary>Hint 2</summary>
  From index &lt;code&gt;i&lt;/code&gt;, forward jumps go only to smaller values; backward jumps go only to larger values.
</details>
<details>
  <summary>Hint 3</summary>
  The maximum reachable value from &lt;code&gt;i&lt;/code&gt; is the maximum value in the connected component reachable under these jump rules.
</details>
<details>
  <summary>Hint 4</summary>
  You can find connected ranges by looking at prefix maximums and suffix minimums, a cut happens where all values to the left are &lt;= all values to the right.
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

`2026-05-07, Thu 07 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )