[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3740. Minimum Distance Between Three Equal Elements I

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3740](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/)

## Description

<p>You are given an integer array <code>nums</code>.</p><p>A tuple <code>(i, j, k)</code> of 3 <strong>distinct</strong> indices is <strong>good</strong> if <code>nums[i] == nums[j] == nums[k]</code>.</p><p>The <strong>distance</strong> of a <strong>good</strong> tuple is <code>abs(i - j) + abs(j - k) + abs(k - i)</code>, where <code>abs(x)</code> denotes the <strong>absolute value</strong> of <code>x</code>.</p><p>Return an integer denoting the <strong>minimum</strong> possible <strong>distance</strong> of a <strong>good</strong> tuple. If no <strong>good</strong> tuples exist, return <code>-1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,2,1,1,3]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">6</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The minimum distance is achieved by the good tuple <code>(0, 2, 3)</code>.</p><p><code>(0, 2, 3)</code> is a good tuple because <code>nums[0] == nums[2] == nums[3] == 1</code>. Its distance is <code>abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,1,2,3,2,1,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">8</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The minimum distance is achieved by the good tuple <code>(2, 4, 6)</code>.</p><p><code>(2, 4, 6)</code> is a good tuple because <code>nums[2] == nums[4] == nums[6] == 2</code>. Its distance is <code>abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8</code>.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">-1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There are no good tuples. Therefore, the answer is -1.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == nums.length &lt;= 100</code></li>
<li><code>1 &lt;= nums[i] &lt;= n</code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use bruteforce
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

`2026-04-10, Fri 10 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )