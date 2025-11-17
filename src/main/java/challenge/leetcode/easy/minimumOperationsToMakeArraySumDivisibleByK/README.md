[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3512. Minimum Operations to Make Array Sum Divisible by K

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3512](https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>. You can perform the following operation any number of times:</p><ul>
<li>Select an index <code>i</code> and replace <code>nums[i]</code> with <code>nums[i] - 1</code>.</li>
</ul><p>Return the <strong>minimum</strong> number of operations required to make the sum of the array divisible by <code>k</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [3,9,7], k = 5</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">4</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Perform 4 operations on <code>nums[1] = 9</code>. Now, <code>nums = [3, 5, 7]</code>.</li>
<li>The sum is 15, which is divisible by 5.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [4,1,3], k = 4</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>The sum is 8, which is already divisible by 4. Hence, no operations are needed.</li>
</ul>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [3,2], k = 6</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">5</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Perform 3 operations on <code>nums[0] = 3</code> and 2 operations on <code>nums[1] = 2</code>. Now, <code>nums = [0, 0]</code>.</li>
<li>The sum is 0, which is divisible by 6.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
<li><code>1 &lt;= k &lt;= 100</code></li>
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
  &lt;code&gt; sum(nums) % k &lt;/code&gt;
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