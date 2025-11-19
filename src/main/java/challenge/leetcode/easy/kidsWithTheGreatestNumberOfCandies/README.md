[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1431. Kids With the Greatest Number of Candies

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 1431](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/)

## Description

<p>There are <code>n</code> kids with candies. You are given an integer array <code>candies</code>, where each <code>candies[i]</code> represents the number of candies the <code>i<sup>th</sup></code> kid has, and an integer <code>extraCandies</code>, denoting the number of extra candies that you have.</p><p>Return <em>a boolean array </em><code>result</code><em> of length </em><code>n</code><em>, where </em><code>result[i]</code><em> is </em><code>true</code><em> if, after giving the </em><code>i<sup>th</sup></code><em> kid all the </em><code>extraCandies</code><em>, they will have the <strong>greatest</strong> number of candies among all the kids</em><em>, or </em><code>false</code><em> otherwise</em>.</p><p>Note that <strong>multiple</strong> kids can have the <strong>greatest</strong> number of candies.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
candies = [2,3,5,1,3], extraCandies = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[true,true,true,false,true]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
candies = [4,2,1,1,2], extraCandies = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[true,false,false,false,false]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
candies = [12,1,12], extraCandies = 10
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[true,false,true]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == candies.length</code></li>
<li><code>2 &lt;= n &lt;= 100</code></li>
<li><code>1 &lt;= candies[i] &lt;= 100</code></li>
<li><code>1 &lt;= extraCandies &lt;= 50</code></li>
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


---

**Hints**
<details>
  <summary>Hint 1</summary>
  For each kid check if candies[i] + extraCandies ≥ maximum in Candies[i].
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