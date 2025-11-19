[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 904. Fruit Into Baskets

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 904](https://leetcode.com/problems/fruit-into-baskets/)

## Description

<p>You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array <code>fruits</code> where <code>fruits[i]</code> is the <strong>type</strong> of fruit the <code>i<sup>th</sup></code> tree produces.</p><p>You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:</p><ul>
<li>You only have <strong>two</strong> baskets, and each basket can only hold a <strong>single type</strong> of fruit. There is no limit on the amount of fruit each basket can hold.</li>
<li>Starting from any tree of your choice, you must pick <strong>exactly one fruit</strong> from <strong>every</strong> tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.</li>
<li>Once you reach a tree with fruit that cannot fit in your baskets, you must stop.</li>
</ul><p>Given the integer array <code>fruits</code>, return <em>the <strong>maximum</strong> number of fruits you can pick</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
fruits = [<u>1,2,1</u>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can pick from all 3 trees.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
fruits = [0,<u>1,2,2</u>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
fruits = [1,<u>2,3,2,2</u>]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= fruits.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= fruits[i] &lt; fruits.length</code></li>
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
`sliding window`


---

**Hints**
<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* [2401 Longest Nice Subarray](https://leetcode.com/problems/longest-nice-subarray/)
* [3477 Fruits Into Baskets II](https://leetcode.com/problems/fruits-into-baskets-ii/)


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