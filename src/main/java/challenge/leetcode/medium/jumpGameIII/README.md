[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1306. Jump Game III

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1306](https://leetcode.com/problems/jump-game-iii/)

## Description

<p>Given an array of non-negative integers <code>arr</code>, you are initially positioned at <code>start</code> index of the array. When you are at index <code>i</code>, you can jump to <code>i + arr[i]</code> or <code>i - arr[i]</code>, check if you can reach <strong>any</strong> index with value 0.</p><p>Notice that you can not jump outside of the array at any time.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [4,2,3,0,3,1,2], start = 5
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
All possible ways to reach at index 3 with value 0 are: 
index 5 -&gt; index 4 -&gt; index 1 -&gt; index 3 
index 5 -&gt; index 6 -&gt; index 4 -&gt; index 1 -&gt; index 3
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [4,2,3,0,3,1,2], start = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
One possible way to reach at index 3 with value 0 is: 
index 0 -&gt; index 4 -&gt; index 1 -&gt; index 3
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [3,0,2,1,2], start = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There is no way to reach at index 1 with value 0.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>0 &lt;= arr[i] &lt; arr.length</code></li>
<li><code>0 &lt;= start &lt; arr.length</code></li>
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
`depth-first search`
`breadth-first search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Think of BFS to solve the problem.
</details>
<details>
  <summary>Hint 2</summary>
  When you reach a position with a value = 0 then return true.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [45 Jump Game II](https://leetcode.com/problems/jump-game-ii/)
* [55 Jump Game](https://leetcode.com/problems/jump-game/)
* [1871 Jump Game VII](https://leetcode.com/problems/jump-game-vii/)
* [2297 Jump Game VIII](https://leetcode.com/problems/jump-game-viii/)
* [2770 Maximum Number of Jumps to Reach the Last Index](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)


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