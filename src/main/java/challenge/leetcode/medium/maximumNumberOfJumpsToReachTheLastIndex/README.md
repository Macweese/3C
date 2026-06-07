[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2770. Maximum Number of Jumps to Reach the Last Index

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2770](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)

## Description

<p>You are given a <strong>0-indexed</strong> array <code>nums</code> of <code>n</code> integers and an integer <code>target</code>.</p><p>You are initially positioned at index <code>0</code>. In one step, you can jump from index <code>i</code> to any index <code>j</code> such that:</p><ul>
<li><code>0 &lt;= i &lt; j &lt; n</code></li>
<li><code>-target &lt;= nums[j] - nums[i] &lt;= target</code></li>
</ul><p>Return <em>the <strong>maximum number of jumps</strong> you can make to reach index</em> <code>n - 1</code>.</p><p>If there is no way to reach index <code>n - 1</code>, return <code>-1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,3,6,4,1,2], target = 2
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
To go from index 0 to index n - 1 with the maximum number of jumps, you can perform the following jumping sequence:
- Jump from index 0 to index 1. 
- Jump from index 1 to index 3.
- Jump from index 3 to index 5.
It can be proven that there is no other jumping sequence that goes from 0 to n - 1 with more than 3 jumps. Hence, the answer is 3.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,3,6,4,1,2], target = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
To go from index 0 to index n - 1 with the maximum number of jumps, you can perform the following jumping sequence:
- Jump from index 0 to index 1.
- Jump from index 1 to index 2.
- Jump from index 2 to index 3.
- Jump from index 3 to index 4.
- Jump from index 4 to index 5.
It can be proven that there is no other jumping sequence that goes from 0 to n - 1 with more than 5 jumps. Hence, the answer is 5.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [1,3,6,4,1,2], target = 0
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
-1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
It can be proven that there is no jumping sequence that goes from 0 to n - 1. Hence, the answer is -1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= nums.length == n &lt;= 1000</code></li>
<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
<li><code>0 &lt;= target &lt;= 2 * 10<sup>9</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use a dynamic programming approach.
</details>
<details>
  <summary>Hint 2</summary>
  Define a dynamic programming array dp of size n, where dp[i] represents the maximum number of jumps from index 0 to index i.
</details>
<details>
  <summary>Hint 3</summary>
  For each j iterate over all i &lt; j. Set dp[j] = max(dp[j], dp[i] + 1) if -target &lt;= nums[j] - nums[i] &lt;= target.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [45 Jump Game II](https://leetcode.com/problems/jump-game-ii/)
* [403 Frog Jump](https://leetcode.com/problems/frog-jump/)
* [1306 Jump Game III](https://leetcode.com/problems/jump-game-iii/)
* [1345 Jump Game IV](https://leetcode.com/problems/jump-game-iv/)
* [1654 Minimum Jumps to Reach Home](https://leetcode.com/problems/minimum-jumps-to-reach-home/)
* [1871 Jump Game VII](https://leetcode.com/problems/jump-game-vii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-10, Sun 10 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )