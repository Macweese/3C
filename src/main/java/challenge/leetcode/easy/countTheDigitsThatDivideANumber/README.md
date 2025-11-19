[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2520. Count the Digits That Divide a Number

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2520](https://leetcode.com/problems/count-the-digits-that-divide-a-number/)

## Description

<p>Given an integer <code>num</code>, return <em>the number of digits in <code>num</code> that divide </em><code>num</code>.</p><p>An integer <code>val</code> divides <code>nums</code> if <code>nums % val == 0</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = 7
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
7 divides itself, hence the answer is 1.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = 121
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
2
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = 1248
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
1248 is divisible by all of its digits, hence the answer is 4.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= num &lt;= 10<sup>9</sup></code></li>
<li><code>num</code> does not contain <code>0</code> as one of its digits.</li>
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

`math`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use mod by 10 to retrieve the least significant digit of the number
</details>
<details>
  <summary>Hint 2</summary>
  Divide the number by 10, then round it down so that the second least significant digit becomes the least significant digit of the number
</details>
<details>
  <summary>Hint 3</summary>
  Use your language’s mod operator to see if a number is a divisor of another.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [202 Happy Number](https://leetcode.com/problems/happy-number/)
* [728 Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)


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