[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1345. Jump Game IV

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1345](https://leetcode.com/problems/jump-game-iv/)

## Description

<p>Given an array of integers <code>arr</code>, you are initially positioned at the first index of the array.</p><p>In one step you can jump from index <code>i</code> to index:</p><ul>
<li><code>i + 1</code> where: <code>i + 1 &lt; arr.length</code>.</li>
<li><code>i - 1</code> where: <code>i - 1 &gt;= 0</code>.</li>
<li><code>j</code> where: <code>arr[i] == arr[j]</code> and <code>i != j</code>.</li>
</ul><p>Return <em>the minimum number of steps</em> to reach the <strong>last index</strong> of the array.</p><p>Notice that you can not jump outside of the array at any time.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [100,-23,-23,404,100,23,23,23,3,404]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
You need three jumps from index 0 --&gt; 4 --&gt; 3 --&gt; 9. Note that index 9 is the last index of the array.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Start index is the last index. You do not need to jump.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
arr = [7,6,9,6,9,6,9,7]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
You can jump directly from index 0 to index 7 which is last index of the array.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= arr.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>-10<sup>8</sup> &lt;= arr[i] &lt;= 10<sup>8</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`breadth-first search`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Build a graph of n nodes where nodes are the indices of the array and edges for node i are nodes i+1, i-1, j where arr[i] == arr[j].
</details>
<details>
  <summary>Hint 2</summary>
  Start bfs from node 0 and keep distance. The answer is the distance when you reach node n-1.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1871 Jump Game VII](https://leetcode.com/problems/jump-game-vii/)
* [2297 Jump Game VIII](https://leetcode.com/problems/jump-game-viii/)
* [2770 Maximum Number of Jumps to Reach the Last Index](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-18, Mon 18 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )