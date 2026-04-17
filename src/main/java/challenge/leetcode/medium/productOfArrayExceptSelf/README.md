[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 238. Product of Array Except Self

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 238](https://leetcode.com/problems/product-of-array-except-self/)

## Description

<p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p><p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p><p>You must write an algorithm that runs in <code>O(n)</code> time and without using the division operation.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,3,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[24,12,8,6]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [-1,1,0,-3,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,0,9,0,0]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
<li>The input is generated such that <code>answer[i]</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
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
  Think how you can efficiently utilize prefix and suffix products to calculate the product of all elements except self for each index. Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?
</details>
<details>
  <summary>Hint 2</summary>
  Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [42 Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
* [152 Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
* [265 Paint House II](https://leetcode.com/problems/paint-house-ii/)
* [2163 Minimum Difference in Sums After Removal of Elements](https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/)
* [2906 Construct Product Matrix](https://leetcode.com/problems/construct-product-matrix/)
* [3539 Find Sum of Array Product of Magical Sequences](https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences/)


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