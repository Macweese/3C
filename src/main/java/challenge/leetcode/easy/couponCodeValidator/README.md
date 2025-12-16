[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3606. Coupon Code Validator

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3606](https://leetcode.com/problems/coupon-code-validator/)

## Description

<p>You are given three arrays of length <code>n</code> that describe the properties of <code>n</code> coupons: <code>code</code>, <code>businessLine</code>, and <code>isActive</code>. The <code>i<sup>th</sup> </code>coupon has:</p><ul>
<li><code>code[i]</code>: a <strong>string</strong> representing the coupon identifier.</li>
<li><code>businessLine[i]</code>: a <strong>string</strong> denoting the business category of the coupon.</li>
<li><code>isActive[i]</code>: a <strong>boolean</strong> indicating whether the coupon is currently active.</li>
</ul><p>A coupon is considered <strong>valid</strong> if all of the following conditions hold:</p><ol>
<li><code>code[i]</code> is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (<code>_</code>).</li>
<li><code>businessLine[i]</code> is one of the following four categories: <code>"electronics"</code>, <code>"grocery"</code>, <code>"pharmacy"</code>, <code>"restaurant"</code>.</li>
<li><code>isActive[i]</code> is <strong>true</strong>.</li>
</ol><p>Return an array of the <strong>codes</strong> of all valid coupons, <strong>sorted</strong> first by their <strong>businessLine</strong> in the order: <code>"electronics"</code>, <code>"grocery"</code>, <code>"pharmacy", "restaurant"</code>, and then by <strong>code</strong> in lexicographical (ascending) order within each category.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">["PHARMA5","SAVE20"]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>First coupon is valid.</li>
<li>Second coupon has empty code (invalid).</li>
<li>Third coupon is valid.</li>
<li>Fourth coupon has special character <code>@</code> (invalid).</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">["ELECTRONICS_50"]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>First coupon is inactive (invalid).</li>
<li>Second coupon is valid.</li>
<li>Third coupon has invalid business line (invalid).</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == code.length == businessLine.length == isActive.length</code></li>
<li><code>1 &lt;= n &lt;= 100</code></li>
<li><code>0 &lt;= code[i].length, businessLine[i].length &lt;= 100</code></li>
<li><code>code[i]</code> and <code>businessLine[i]</code> consist of printable ASCII characters.</li>
<li><code>isActive[i]</code> is either <code>true</code> or <code>false</code>.</li>
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
`string`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Filter out any coupon where &lt;code&gt;isActive[i]&lt;/code&gt; is false, &lt;code&gt;code[i]&lt;/code&gt; is empty or contains non‑alphanumeric/underscore chars, or &lt;code&gt;businessLine[i]&lt;/code&gt; is not in the allowed set
</details>
<details>
  <summary>Hint 2</summary>
  Store each remaining coupon as a pair &lt;code&gt;(businessLine[i], code[i])&lt;/code&gt;
</details>
<details>
  <summary>Hint 3</summary>
  Define a priority map, e.g. &lt;code&gt;{&#34;electronics&#34;:0, &#34;grocery&#34;:1, &#34;pharmacy&#34;:2, &#34;restaurant&#34;:3}&lt;/code&gt;
</details>
<details>
  <summary>Hint 4</summary>
  Sort the list of pairs by &lt;code&gt;(priority[businessLine], code)&lt;/code&gt; and return the &lt;code&gt;code&lt;/code&gt; values in order
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

`2025-12-13, Sat 13 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )