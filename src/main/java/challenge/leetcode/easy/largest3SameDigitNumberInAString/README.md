[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2264. Largest 3-Same-Digit Number in String

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2264](https://leetcode.com/problems/largest-3-same-digit-number-in-string/)

## Description

<p>You are given a string <code>num</code> representing a large integer. An integer is <strong>good</strong> if it meets the following conditions:</p><ul>
<li>It is a <strong>substring</strong> of <code>num</code> with length <code>3</code>.</li>
<li>It consists of only one unique digit.</li>
</ul><p>Return <em>the <strong>maximum good </strong>integer as a <strong>string</strong> or an empty string </em><code>""</code><em> if no such integer exists</em>.</p><p>Note:</p><ul>
<li>A <strong>substring</strong> is a contiguous sequence of characters within a string.</li>
<li>There may be <strong>leading zeroes</strong> in <code>num</code> or a good integer.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = "6<strong><u>777</u></strong>133339"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"777"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = "23<strong><u>000</u></strong>19"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
"000"
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
"000" is the only good integer.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
num = "42352338"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
""
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>3 &lt;= num.length &lt;= 1000</code></li>
<li><code>num</code> only consists of digits.</li>
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

`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  We can sequentially check if “999”, “888”, “777”, … , “000” exists in num in that order. The first to be found is the maximum good integer.
</details>
<details>
  <summary>Hint 2</summary>
  If we cannot find any of the above integers, we return an empty string “”.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1903 Largest Odd Number in String](https://leetcode.com/problems/largest-odd-number-in-string/)


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