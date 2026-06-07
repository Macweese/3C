[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1871. Jump Game VII

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1871](https://leetcode.com/problems/jump-game-vii/)

## Description

<p>You are given a <strong>0-indexed</strong> binary string <code>s</code> and two integers <code>minJump</code> and <code>maxJump</code>. In the beginning, you are standing at index <code>0</code>, which is equal to <code>'0'</code>. You can move from index <code>i</code> to index <code>j</code> if the following conditions are fulfilled:</p><ul>
<li><code>i + minJump &lt;= j &lt;= min(i + maxJump, s.length - 1)</code>, and</li>
<li><code>s[j] == '0'</code>.</li>
</ul><p>Return <code>true</code><i> if you can reach index </i><code>s.length - 1</code><i> in </i><code>s</code><em>, or </em><code>false</code><em> otherwise.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "<u>0</u>11<u>0</u>1<u>0</u>", minJump = 2, maxJump = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
true
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In the first step, move from index 0 to index 3. 
In the second step, move from index 3 to index 5.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "01101110", minJump = 2, maxJump = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
false
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
<li><code>s[0] == '0'</code></li>
<li><code>1 &lt;= minJump &lt;= maxJump &lt; s.length</code></li>
</ul>

<br>

---

<br>

#### Tags

`string`
`dynamic programming`
`sliding window`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Consider for each reachable index i the interval [i + a, i + b].
</details>
<details>
  <summary>Hint 2</summary>
  Use partial sums to mark the intervals as reachable.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [45 Jump Game II](https://leetcode.com/problems/jump-game-ii/)
* [55 Jump Game](https://leetcode.com/problems/jump-game/)
* [1306 Jump Game III](https://leetcode.com/problems/jump-game-iii/)
* [1345 Jump Game IV](https://leetcode.com/problems/jump-game-iv/)
* [1340 Jump Game V](https://leetcode.com/problems/jump-game-v/)
* [1696 Jump Game VI](https://leetcode.com/problems/jump-game-vi/)
* [1871 Jump Game VII](https://leetcode.com/problems/jump-game-vii/)
* [2297 Jump Game VIII](https://leetcode.com/problems/jump-game-viii/)
* [2559 Count Vowel Strings in Ranges](https://leetcode.com/problems/count-vowel-strings-in-ranges/)
* [2770 Maximum Number of Jumps to Reach the Last Index](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-25, Mon 25 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )