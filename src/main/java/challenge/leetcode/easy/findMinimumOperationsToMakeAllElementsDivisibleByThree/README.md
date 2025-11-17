[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3190. Find Minimum Operations to Make All Elements Divisible by Three

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3190](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/)

## Description

<p>You are given an integer array <code>nums</code>. In one operation, you can add or subtract 1 from <strong>any</strong> element of <code>nums</code>.</p><p>Return the <strong>minimum</strong> number of operations to make all elements of <code>nums</code> divisible by 3.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,3,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>All array elements can be made divisible by 3 using 3 operations:</p><ul>
<li>Subtract 1 from 1.</li>
<li>Add 1 to 2.</li>
<li>Subtract 1 from 4.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [3,6,9]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 50</code></li>
<li><code>1 &lt;= nums[i] &lt;= 50</code></li>
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
`math`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If &lt;code&gt;x % 3 != 0&lt;/code&gt; we can always increment or decrement &lt;code&gt;x&lt;/code&gt; such that we only need 1 operation.
</details>
<details>
  <summary>Hint 2</summary>
  Add &lt;code&gt;min(nums[i] % 3, 3 - (num[i] % 3))&lt;/code&gt; to the count of operations.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [453 Minimum Moves to Equal Array Elements](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)


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