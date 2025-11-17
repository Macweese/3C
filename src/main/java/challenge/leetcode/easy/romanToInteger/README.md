[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 13. Roman to Integer

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 13](https://leetcode.com/problems/roman-to-integer/)

## Description

<p>Roman numerals are represented by seven different symbols: <code>I</code>, <code>V</code>, <code>X</code>, <code>L</code>, <code>C</code>, <code>D</code> and <code>M</code>.</p><pre>
<strong>Symbol</strong>       <strong>Value</strong>
I             1
V             5
X             10
L             50
C             100
D             500
M             1000</pre><p>For example, <code>2</code> is written as <code>II</code> in Roman numeral, just two ones added together. <code>12</code> is written as <code>XII</code>, which is simply <code>X + II</code>. The number <code>27</code> is written as <code>XXVII</code>, which is <code>XX + V + II</code>.</p><p>Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <code>IIII</code>. Instead, the number four is written as <code>IV</code>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as <code>IX</code>. There are six instances where subtraction is used:</p><ul>
<li><code>I</code> can be placed before <code>V</code> (5) and <code>X</code> (10) to make 4 and 9. </li>
<li><code>X</code> can be placed before <code>L</code> (50) and <code>C</code> (100) to make 40 and 90. </li>
<li><code>C</code> can be placed before <code>D</code> (500) and <code>M</code> (1000) to make 400 and 900.</li>
</ul><p>Given a roman numeral, convert it to an integer.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "III"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
III = 3.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "LVIII"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
58
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
L = 50, V= 5, III = 3.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
s = "MCMXCIV"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1994
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
M = 1000, CM = 900, XC = 90 and IV = 4.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 15</code></li>
<li><code>s</code> contains only the characters <code>('I', 'V', 'X', 'L', 'C', 'D', 'M')</code>.</li>
<li>It is <strong>guaranteed</strong> that <code>s</code> is a valid roman numeral in the range <code>[1, 3999]</code>.</li>
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
`math`
`string`


---

<details>
  <summary>Hint 1</summary>
  Problem is simpler to solve by working the string from back to front and using a map.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [12 Integer to Roman](https://leetcode.com/problems/integer-to-roman/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-09-21, Sun 21 September 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )