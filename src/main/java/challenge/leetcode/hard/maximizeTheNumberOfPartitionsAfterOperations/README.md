[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3003. Maximize the Number of Partitions After Operations

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3003](https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations/)

## Description

<p>You are given a string <code>s</code> and an integer <code>k</code>.</p><p>First, you are allowed to change <strong>at most</strong> <strong>one</strong> index in <code>s</code> to another lowercase English letter.</p><p>After that, do the following partitioning operation until <code>s</code> is <strong>empty</strong>:</p><ul>
<li>Choose the <strong>longest</strong> <strong>prefix</strong> of <code>s</code> containing at most <code>k</code> <strong>distinct</strong> characters.</li>
<li><strong>Delete</strong> the prefix from <code>s</code> and increase the number of partitions by one. The remaining characters (if any) in <code>s</code> maintain their initial order.</li>
</ul><p>Return an integer denoting the <strong>maximum</strong> number of resulting partitions after the operations by optimally choosing at most one index to change.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "accca", k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The optimal way is to change <code>s[2]</code> to something other than a and c, for example, b. then it becomes <code>"acbca"</code>.</p><p>Then we perform the operations:</p><ol>
<li>The longest prefix containing at most 2 distinct characters is <code>"ac"</code>, we remove it and <code>s</code> becomes <code>"bca"</code>.</li>
<li>Now The longest prefix containing at most 2 distinct characters is <code>"bc"</code>, so we remove it and <code>s</code> becomes <code>"a"</code>.</li>
<li>Finally, we remove <code>"a"</code> and <code>s</code> becomes empty, so the procedure ends.</li>
</ol><p>Doing the operations, the string is divided into 3 partitions, so the answer is 3.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "aabaab", k = 3</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>Initially <code>s</code> contains 2 distinct characters, so whichever character we change, it will contain at most 3 distinct characters, so the longest prefix with at most 3 distinct characters would always be all of it, therefore the answer is 1.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "xxyz", k = 1</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">4</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The optimal way is to change <code>s[0]</code> or <code>s[1]</code> to something other than characters in <code>s</code>, for example, to change <code>s[0]</code> to <code>w</code>.</p><p>Then <code>s</code> becomes <code>"wxyz"</code>, which consists of 4 distinct characters, so as <code>k</code> is 1, it will divide into 4 partitions.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
<li><code>s</code> consists only of lowercase English letters.</li>
<li><code>1 &lt;= k &lt;= 26</code></li>
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
`dynamic programming`
`bit manipulation`
`bitmask`


---

<details>
  <summary>Hint 1</summary>
  For each position, try to brute-force the replacements.
</details>
<details>
  <summary>Hint 2</summary>
  To speed up the brute-force solution, we can precompute the following (without changing any index) using prefix sums and binary search:&lt;ul&gt;
&lt;li&gt;&lt;code&gt;pref[i]&lt;/code&gt;: The number of resulting partitions from the operations by performing the operations on &lt;code&gt;s[0:i]&lt;/code&gt;.&lt;/li&gt;
&lt;li&gt;&lt;code&gt;suff[i]&lt;/code&gt;: The number of resulting partitions from the operations by performing the operations on &lt;code&gt;s[i:n - 1]&lt;/code&gt;, where &lt;code&gt;n == s.length&lt;/code&gt;.&lt;/li&gt;
&lt;li&gt;&lt;code&gt;partition_start[i]&lt;/code&gt;: The start index of the partition containing the &lt;code&gt;i&lt;sup&gt;th&lt;/sup&gt;&lt;/code&gt; index after performing the operations.&lt;/li&gt;
&lt;/ul&gt;
</details>
<details>
  <summary>Hint 3</summary>
  Now, for a position &lt;code&gt;i&lt;/code&gt;, we can try all possible &lt;code&gt;25&lt;/code&gt; replacements:&lt;br /&gt;
For a replacement, using prefix sums and binary search, we need to find the rightmost index, &lt;code&gt;r&lt;/code&gt;, such that the number of distinct characters in the range &lt;code&gt;[partition_start[i], r]&lt;/code&gt; is at most &lt;code&gt;k&lt;/code&gt;.&lt;br /&gt;
There are &lt;code&gt;2&lt;/code&gt; cases:&lt;ul&gt;
&lt;li&gt;&lt;code&gt;r &gt;= i&lt;/code&gt;: the number of resulting partitions in this case is &lt;code&gt;1 + pref[partition_start[i] - 1] + suff[r + 1]&lt;/code&gt;.&lt;/li&gt;
&lt;li&gt;Otherwise, we need to find the rightmost index &lt;code&gt;r&lt;sub&gt;2&lt;/sub&gt;&lt;/code&gt; such that the number of distinct characters in the range &lt;code&gt;[r:r&lt;sub&gt;2&lt;/sub&gt;]&lt;/code&gt; is at most &lt;code&gt;k&lt;/code&gt;. The answer in this case is &lt;code&gt;2 + pref[partition_start[i] - 1] + suff[r&lt;sub&gt;2&lt;/sub&gt; + 1]&lt;/code&gt;&lt;/li&gt;
&lt;/ul&gt;
</details>
<details>
  <summary>Hint 4</summary>
  The answer is the maximum among all replacements.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1177 Can Make Palindrome from Substring](https://leetcode.com/problems/can-make-palindrome-from-substring/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-17, Fri 17 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )