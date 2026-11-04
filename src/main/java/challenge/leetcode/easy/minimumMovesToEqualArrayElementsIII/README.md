[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3736. Minimum Moves to Equal Array Elements III

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3736](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/)

## Description

<p>You are given an integer array <code>nums</code>.</p><p>In one move, you may <strong>increase</strong> the value of any single element <code>nums[i]</code> by 1.</p><p>Return the <strong>minimum total</strong> number of <strong>moves</strong> required so that all elements in <code>nums</code> become <strong>equal</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,1,3]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>To make all elements equal:</p><ul>
<li>Increase <code>nums[0] = 2</code> by 1 to make it 3.</li>
<li>Increase <code>nums[1] = 1</code> by 1 to make it 2.</li>
<li>Increase <code>nums[1] = 2</code> by 1 to make it 3.</li>
</ul><p>Now, all elements of <code>nums</code> are equal to 3. The minimum total moves is <code>3</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [4,4,5]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>To make all elements equal:</p><ul>
<li>Increase <code>nums[0] = 4</code> by 1 to make it 5.</li>
<li>Increase <code>nums[1] = 4</code> by 1 to make it 5.</li>
</ul><p>Now, all elements of <code>nums</code> are equal to 5. The minimum total moves is <code>2</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 100</code></li>
<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
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
  To make all numbers equal, they must all reach at least the maximum value in the array.
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