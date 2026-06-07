[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1674. Minimum Moves to Make Array Complementary

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1674](https://leetcode.com/problems/minimum-moves-to-make-array-complementary/)

## Description

<p>You are given an integer array <code>nums</code> of <strong>even</strong> length <code>n</code> and an integer <code>limit</code>. In one move, you can replace any integer from <code>nums</code> with another integer between <code>1</code> and <code>limit</code>, inclusive.</p><p>The array <code>nums</code> is <strong>complementary</strong> if for all indices <code>i</code> (<strong>0-indexed</strong>), <code>nums[i] + nums[n - 1 - i]</code> equals the same number. For example, the array <code>[1,2,3,4]</code> is complementary because for all indices <code>i</code>, <code>nums[i] + nums[n - 1 - i] = 5</code>.</p><p>Return the <em><strong>minimum</strong> number of moves required to make </em><code>nums</code><em> <strong>complementary</strong></em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,4,3], limit = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In 1 move, you can change nums to [1,2,<u>2</u>,3] (underlined elements are changed).
nums[0] + nums[3] = 1 + 3 = 4.
nums[1] + nums[2] = 2 + 2 = 4.
nums[2] + nums[1] = 2 + 2 = 4.
nums[3] + nums[0] = 3 + 1 = 4.
Therefore, nums[i] + nums[n-1-i] = 4 for every i, so nums is complementary.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,2,1], limit = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In 2 moves, you can change nums to [<u>2</u>,2,2,<u>2</u>]. You cannot change any number to 3 since 3 &gt; limit.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,2,1,2], limit = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
nums is already complementary.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == nums.length</code></li>
<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= limit &lt;= 10<sup>5</sup></code></li>
<li><code>n</code> is even.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Given a target sum x, each pair of nums[i] and nums[n-1-i] would either need 0, 1, or 2 modifications.
</details>
<details>
  <summary>Hint 2</summary>
  Can you find the optimal target sum x value such that the sum of modifications is minimized?
</details>
<details>
  <summary>Hint 3</summary>
  Create a difference array to efficiently sum all the modifications.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [3356 Zero Array Transformation II](https://leetcode.com/problems/zero-array-transformation-ii/)
* [3362 Zero Array Transformation III](https://leetcode.com/problems/zero-array-transformation-iii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-13, Wed 13 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )