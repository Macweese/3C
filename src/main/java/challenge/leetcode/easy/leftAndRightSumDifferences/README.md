[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2574. Left and Right Sum Differences

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2574](https://leetcode.com/problems/left-and-right-sum-differences/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of size <code>n</code>.</p><p>Define two arrays <code>leftSum</code> and <code>rightSum</code> where:</p><ul>
<li><code>leftSum[i]</code> is the sum of elements to the left of the index <code>i</code> in the array <code>nums</code>. If there is no such element, <code>leftSum[i] = 0</code>.</li>
<li><code>rightSum[i]</code> is the sum of elements to the right of the index <code>i</code> in the array <code>nums</code>. If there is no such element, <code>rightSum[i] = 0</code>.</li>
</ul><p>Return an integer array <code>answer</code> of size <code>n</code> where <code>answer[i] = |leftSum[i] - rightSum[i]|</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [10,4,8,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[15,1,11,22]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The array leftSum is [0] and the array rightSum is [0].
The array answer is [|0 - 0|] = [0].
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  For each index i, maintain two variables leftSum and rightSum.
</details>
<details>
  <summary>Hint 2</summary>
  Iterate on the range j: [0 … i - 1] and add nums[j] to the leftSum and similarly iterate on the range j: [i + 1 … nums.length - 1] and add nums[j] to the rightSum.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [724 Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)
* [1991 Find the Middle Index in Array](https://leetcode.com/problems/find-the-middle-index-in-array/)
* [2670 Find the Distinct Difference Array](https://leetcode.com/problems/find-the-distinct-difference-array/)
* [3179 Find the N-th Value After K Seconds](https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-06-06, Sat 06 June 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )