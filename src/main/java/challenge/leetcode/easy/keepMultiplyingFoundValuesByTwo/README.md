[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2154. Keep Multiplying Found Values by Two

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2154](https://leetcode.com/problems/keep-multiplying-found-values-by-two/)

## Description

<p>You are given an array of integers <code>nums</code>. You are also given an integer <code>original</code> which is the first number that needs to be searched for in <code>nums</code>.</p><p>You then do the following steps:</p><ol>
<li>If <code>original</code> is found in <code>nums</code>, <strong>multiply</strong> it by two (i.e., set <code>original = 2 * original</code>).</li>
<li>Otherwise, <strong>stop</strong> the process.</li>
<li><strong>Repeat</strong> this process with the new number as long as you keep finding the number.</li>
</ol><p>Return <em>the <strong>final</strong> value of </em><code>original</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [5,3,6,1,12], original = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
24
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
- 24 is not found in nums. Thus, 24 is returned.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
nums = [2,7,9], original = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- 4 is not found in nums. Thus, 4 is returned.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
<li><code>1 &lt;= nums[i], original &lt;= 1000</code></li>
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
`hash table`
`sorting`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Repeatedly iterate through the array and check if the current value of original is in the array.
</details>
<details>
  <summary>Hint 2</summary>
  If original is not found, stop and return its current value.
</details>
<details>
  <summary>Hint 3</summary>
  Otherwise, multiply original by 2 and repeat the process.
</details>
<details>
  <summary>Hint 4</summary>
  Use set data structure to check the existence faster.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [747 Largest Number At Least Twice of Others](https://leetcode.com/problems/largest-number-at-least-twice-of-others/)
* [1346 Check If N and Its Double Exist](https://leetcode.com/problems/check-if-n-and-its-double-exist/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-11-19, Wed 19 November 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )