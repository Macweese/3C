[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3. Longest Substring Without Repeating Characters

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## Description

<p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty"><strong>substring</strong></span> without duplicate characters.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "abcabcbb"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The answer is "abc", with the length of 3. Note that <code>"bca"</code> and <code>"cab"</code> are also correct answers.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "bbbbb"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The answer is "b", with the length of 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "pwwkew"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
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

`hash table`
`string`
`sliding window`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Generate all possible substrings &amp; check for each substring if it&#39;s valid and keep updating maxLen accordingly.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [159 Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)
* [340 Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
* [992 Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/)
* [1695 Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/)
* [2067 Number of Equal Count Substrings](https://leetcode.com/problems/number-of-equal-count-substrings/)
* [2260 Minimum Consecutive Cards to Pick Up](https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/)
* [2401 Longest Nice Subarray](https://leetcode.com/problems/longest-nice-subarray/)
* [2405 Optimal Partition of String](https://leetcode.com/problems/optimal-partition-of-string/)
* [2799 Count Complete Subarrays in an Array](https://leetcode.com/problems/count-complete-subarrays-in-an-array/)
* [2982 Find Longest Special Substring That Occurs Thrice II](https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/)
* [2981 Find Longest Special Substring That Occurs Thrice I](https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/)


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