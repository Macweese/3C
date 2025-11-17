[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 165. Compare Version Numbers

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 165](https://leetcode.com/problems/compare-version-numbers/)

## Description

<p>Given two <strong>version strings</strong>, <code>version1</code> and <code>version2</code>, compare them. A version string consists of <strong>revisions</strong> separated by dots <code>'.'</code>. The <strong>value of the revision</strong> is its <strong>integer conversion</strong> ignoring leading zeros.</p><p>To compare version strings, compare their revision values in <strong>left-to-right order</strong>. If one of the version strings has fewer revisions, treat the missing revision values as <code>0</code>.</p><p>Return the following:</p><ul>
<li>If <code>version1 &lt; version2</code>, return -1.</li>
<li>If <code>version1 &gt; version2</code>, return 1.</li>
<li>Otherwise, return 0.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">version1 = "1.2", version2 = "1.10"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">-1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>version1's second revision is "2" and version2's second revision is "10": 2 &lt; 10, so version1 &lt; version2.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">version1 = "1.01", version2 = "1.001"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>Ignoring leading zeroes, both "01" and "001" represent the same integer "1".</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">version1 = "1.0", version2 = "1.0.0.0"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>version1 has less revisions, which means every missing revision are treated as "0".</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= version1.length, version2.length &lt;= 500</code></li>
<li><code>version1</code> and <code>version2</code> only contain digits and <code>'.'</code>.</li>
<li><code>version1</code> and <code>version2</code> <strong>are valid version numbers</strong>.</li>
<li>All the given revisions in <code>version1</code> and <code>version2</code> can be stored in a <strong>32-bit integer</strong>.</li>
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

`two pointers`
`string`


---

<details>
  <summary>Hint 1</summary>
  You can use two pointers for each version string to traverse them together while comparing the corresponding segments.
</details>
<details>
  <summary>Hint 2</summary>
  Utilize the substring method to extract each version segment delimited by &#39;.&#39;. Ensure you&#39;re extracting the segments correctly by adjusting the start and end indices accordingly.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-09-23, Tue 23 September 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )