[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 27. Remove Element

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 27](https://leetcode.com/problems/remove-element/)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>val</code>, remove all occurrences of <code>val</code> in <code>nums</code> <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>. The order of the elements may be changed. Then return <em>the number of elements in </em><code>nums</code><em> which are not equal to </em><code>val</code>.</p><p>Consider the number of elements in <code>nums</code> which are not equal to <code>val</code> be <code>k</code>, to get accepted, you need to do the following things:</p><ul>
<li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the elements which are not equal to <code>val</code>. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li>
<li>Return <code>k</code>.</li>
</ul><p><strong>Custom Judge:</strong></p><p>The judge will test your solution with the following code:</p><pre>
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i &lt; actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
</pre><p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [3,2,2,3], val = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2, nums = [2,2,_,_]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [0,1,2,2,3,0,4,2], val = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5, nums = [0,1,4,0,3,_,_,_]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= nums.length &lt;= 100</code></li>
<li><code>0 &lt;= nums[i] &lt;= 50</code></li>
<li><code>0 &lt;= val &lt;= 100</code></li>
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
  The problem statement clearly asks us to modify the array in-place and it also says that the element beyond the new length of the array can be anything. Given an element, we need to remove all the occurrences of it from the array. We don&#39;t technically need to &lt;b&gt;remove&lt;/b&gt; that element per se, right?
</details>
<details>
  <summary>Hint 2</summary>
  We can move all the occurrences of this element to the end of the array. Use two pointers!
&lt;br&gt;&lt;img src=&#34;https://assets.leetcode.com/uploads/2019/10/20/hint_remove_element.png&#34; width=&#34;500&#34;/&gt;
</details>
<details>
  <summary>Hint 3</summary>
  Yet another direction of thought is to consider the elements to be removed as non-existent. In a single pass, if we keep copying the visible elements in-place, that should also solve this problem for us.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [26 Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
* [203 Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
* [283 Move Zeroes](https://leetcode.com/problems/move-zeroes/)


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