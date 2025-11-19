[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1769. Minimum Number of Operations to Move All Balls to Each Box

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1769](https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/)

## Description

<p>You have <code>n</code> boxes. You are given a binary string <code>boxes</code> of length <code>n</code>, where <code>boxes[i]</code> is <code>'0'</code> if the <code>i<sup>th</sup></code> box is <strong>empty</strong>, and <code>'1'</code> if it contains <strong>one</strong> ball.</p><p>In one operation, you can move <strong>one</strong> ball from a box to an adjacent box. Box <code>i</code> is adjacent to box <code>j</code> if <code>abs(i - j) == 1</code>. Note that after doing so, there may be more than one ball in some boxes.</p><p>Return an array <code>answer</code> of size <code>n</code>, where <code>answer[i]</code> is the <strong>minimum</strong> number of operations needed to move all the balls to the <code>i<sup>th</sup></code> box.</p><p>Each <code>answer[i]</code> is calculated considering the <strong>initial</strong> state of the boxes.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
boxes = "110"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[1,1,3]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
boxes = "001011"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[11,8,5,4,3,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == boxes.length</code></li>
<li><code>1 &lt;= n &lt;= 2000</code></li>
<li><code>boxes[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
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
`string`
`prefix sum`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If you want to move a ball from box i to box j, you&#39;ll need abs(i-j) moves.
</details>
<details>
  <summary>Hint 2</summary>
  To move all balls to some box, you can move them one by one.
</details>
<details>
  <summary>Hint 3</summary>
  For each box i, iterate on each ball in a box j, and add abs(i-j) to answers[i].
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1217 Minimum Cost to Move Chips to The Same Position](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/)
* [2850 Minimum Moves to Spread Stones Over Grid](https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/)


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