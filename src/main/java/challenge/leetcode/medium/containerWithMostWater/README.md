[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 11. Container With Most Water

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 11](https://leetcode.com/problems/container-with-most-water/)

## Description

<p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p><p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p><p>Return <em>the maximum amount of water a container can store</em>.</p><p><strong>Notice</strong> that you may not slant the container.</p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
height = [1,8,6,2,5,4,8,3,7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
49
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
height = [1,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == height.length</code></li>
<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
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
`greedy`


---

<details>
  <summary>Hint 1</summary>
  If you simulate the problem, it will be O(n^2) which is not efficient.
</details>
<details>
  <summary>Hint 2</summary>
  Try to use two-pointers. Set one pointer to the left and one to the right of the array. Always move the pointer that points to the lower line.
</details>
<details>
  <summary>Hint 3</summary>
  How can you calculate the amount of water at each step?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [42 Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
* [2517 Maximum Tastiness of Candy Basket](https://leetcode.com/problems/maximum-tastiness-of-candy-basket/)
* [2560 House Robber IV](https://leetcode.com/problems/house-robber-iv/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-04, Sat 04 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )