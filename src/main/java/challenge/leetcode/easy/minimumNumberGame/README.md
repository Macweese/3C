[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2974. Minimum Number Game

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2974](https://leetcode.com/problems/minimum-number-game/)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of <strong>even</strong> length and there is also an empty array <code>arr</code>. Alice and Bob decided to play a game where in every round Alice and Bob will do one move. The rules of the game are as follows:</p><ul>
<li>Every round, first Alice will remove the <strong>minimum</strong> element from <code>nums</code>, and then Bob does the same.</li>
<li>Now, first Bob will append the removed element in the array <code>arr</code>, and then Alice does the same.</li>
<li>The game continues until <code>nums</code> becomes empty.</li>
</ul><p>Return <em>the resulting array </em><code>arr</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [5,4,2,3]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[3,2,5,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In round one, first Alice removes 2 and then Bob removes 3. Then in arr firstly Bob appends 3 and then Alice appends 2. So arr = [3,2].
At the begining of round two, nums = [5,4]. Now, first Alice removes 4 and then Bob removes 5. Then both append in arr which becomes [3,2,5,4].
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [2,5]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[5,2]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
In round one, first Alice removes 2 and then Bob removes 5. Then in arr firstly Bob appends and then Alice appends. So arr = [5,2].
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= nums.length &lt;= 100</code></li>
<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
<li><code>nums.length % 2 == 0</code></li>
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
`sorting`
`heap (priority queue)`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sort the array in increasing order and then swap the adjacent elements.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

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