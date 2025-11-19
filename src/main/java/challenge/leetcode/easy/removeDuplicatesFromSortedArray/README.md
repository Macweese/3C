[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 26. Remove Duplicates from Sorted Array

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Description

<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove the duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears only <strong>once</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>.</p><p>Consider the number of <em>unique elements</em> in <code>nums</code> to be <code>k<strong>​​​​​​​</strong></code>​​​​​​​. <meta charset="utf-8"/>After removing duplicates, return the number of unique elements <code>k</code>.</p><p><meta charset="utf-8"/>The first <code>k</code> elements of <code>nums</code> should contain the unique numbers in <strong>sorted order</strong>. The remaining elements beyond index <code>k - 1</code> can be ignored.</p><p><strong>Custom Judge:</strong></p><p>The judge will test your solution with the following code:</p><pre>
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}
</pre><p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2, nums = [1,2,_]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [0,0,1,1,1,2,2,3,3,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5, nums = [0,1,2,3,4,_,_,_,_,_]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
<li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
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
`two pointers`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  In this problem, the key point to focus on is the input array being sorted. As far as duplicate elements are concerned, what is their positioning in the array when the given array is sorted? Look at the image below for the answer. If we know the position of one of the elements, do we also know the positioning of all the duplicate elements?

&lt;br&gt;
&lt;img src=&#34;https://assets.leetcode.com/uploads/2019/10/20/hint_rem_dup.png&#34; width=&#34;500&#34;/&gt;
</details>
<details>
  <summary>Hint 2</summary>
  We need to modify the array in-place and the size of the final array would potentially be smaller than the size of the input array. So, we ought to use a two-pointer approach here. One, that would keep track of the current element in the original array and another one for just the unique elements.
</details>
<details>
  <summary>Hint 3</summary>
  Essentially, once an element is encountered, you simply need to &lt;b&gt;bypass&lt;/b&gt; its duplicates and move on to the next unique element.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [27 Remove Element](https://leetcode.com/problems/remove-element/)
* [80 Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
* [2460 Apply Operations to an Array](https://leetcode.com/problems/apply-operations-to-an-array/)
* [2615 Sum of Distances](https://leetcode.com/problems/sum-of-distances/)


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