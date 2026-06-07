[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3300. Minimum Element After Replacement With Digit Sum

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3300](https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/)

## Description

<p>You are given an integer array <code>nums</code>.</p><p>You replace each element in <code>nums</code> with the <strong>sum</strong> of its digits.</p><p>Return the <strong>minimum</strong> element in <code>nums</code> after all replacements.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [10,12,13,14]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><code>nums</code> becomes <code>[1, 3, 4, 5]</code> after all replacements, with minimum element 1.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,3,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><code>nums</code> becomes <code>[1, 2, 3, 4]</code> after all replacements, with minimum element 1.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [999,19,199]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">10</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p><code>nums</code> becomes <code>[27, 10, 19]</code> after all replacements, with minimum element 10.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 100</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`math`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Convert to string and calculate the sum for each element.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1945 Sum of Digits of String After Convert](https://leetcode.com/problems/sum-of-digits-of-string-after-convert/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-29, Fri 29 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )