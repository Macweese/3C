[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2540. Minimum Common Value

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2540](https://leetcode.com/problems/minimum-common-value/)

## Description

<p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, sorted in non-decreasing order, return <em>the <strong>minimum integer common</strong> to both arrays</em>. If there is no common integer amongst <code>nums1</code> and <code>nums2</code>, return <code>-1</code>.</p><p>Note that an integer is said to be <strong>common</strong> to <code>nums1</code> and <code>nums2</code> if both arrays have <strong>at least one</strong> occurrence of that integer.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums1 = [1,2,3], nums2 = [2,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The smallest element common to both arrays is 2, so we return 2.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums1 = [1,2,3,6], nums2 = [2,3,4,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
<li>Both <code>nums1</code> and <code>nums2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`two pointers`
`binary search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Try to use a set.
</details>
<details>
  <summary>Hint 2</summary>
  Otherwise, try to use a two-pointer approach.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [349 Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)
* [350 Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-19, Tue 19 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )