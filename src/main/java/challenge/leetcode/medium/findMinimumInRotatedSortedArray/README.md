[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 153. Find Minimum in Rotated Sorted Array

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

## Description

<p>Suppose an array of length <code>n</code> sorted in ascending order is <strong>rotated</strong> between <code>1</code> and <code>n</code> times. For example, the array <code>nums = [0,1,2,4,5,6,7]</code> might become:</p><ul>
<li><code>[4,5,6,7,0,1,2]</code> if it was rotated <code>4</code> times.</li>
<li><code>[0,1,2,4,5,6,7]</code> if it was rotated <code>7</code> times.</li>
</ul><p>Notice that <strong>rotating</strong> an array <code>[a[0], a[1], a[2], ..., a[n-1]]</code> 1 time results in the array <code>[a[n-1], a[0], a[1], a[2], ..., a[n-2]]</code>.</p><p>Given the sorted rotated array <code>nums</code> of <strong>unique</strong> elements, return <em>the minimum element of this array</em>.</p><p>You must write an algorithm that runs in <code>O(log n) time</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,4,5,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The original array was [1,2,3,4,5] rotated 3 times.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [4,5,6,7,0,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [11,13,15,17]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
11
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The original array was [11,13,15,17] and it was rotated 4 times.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == nums.length</code></li>
<li><code>1 &lt;= n &lt;= 5000</code></li>
<li><code>-5000 &lt;= nums[i] &lt;= 5000</code></li>
<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
<li><code>nums</code> is sorted and rotated between <code>1</code> and <code>n</code> times.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`binary search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Array was originally in ascending order. Now that the array is rotated, there would be a point in the array where there is a small deflection from the increasing sequence. eg. The array would be something like [4, 5, 6, 7, 0, 1, 2].
</details>
<details>
  <summary>Hint 2</summary>
  You can divide the search space into two and see which direction to go.
Can you think of an algorithm which has O(logN) search complexity?
</details>
<details>
  <summary>Hint 3</summary>
  &lt;ol&gt;
&lt;li&gt;All the elements to the left of inflection point &gt; first element of the array.&lt;/li&gt;
&lt;li&gt;All the elements to the right of inflection point &lt; first element of the array.&lt;/li&gt;
&lt;ol&gt;
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [33 Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
* [154 Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)


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