[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 12. Integer to Roman

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 12](https://leetcode.com/problems/integer-to-roman/)

## Description

<p>Seven different symbols represent Roman numerals with the following values:</p><table>
<thead>
<tr>
<th>Symbol</th>
<th>Value</th>
</tr>
</thead>
<tbody>
<tr>
<td>I</td>
<td>1</td>
</tr>
<tr>
<td>V</td>
<td>5</td>
</tr>
<tr>
<td>X</td>
<td>10</td>
</tr>
<tr>
<td>L</td>
<td>50</td>
</tr>
<tr>
<td>C</td>
<td>100</td>
</tr>
<tr>
<td>D</td>
<td>500</td>
</tr>
<tr>
<td>M</td>
<td>1000</td>
</tr>
</tbody>
</table><p>Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:</p><ul>
<li>If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.</li>
<li>If the value starts with 4 or 9 use the <strong>subtractive form</strong> representing one symbol subtracted from the following symbol, for example, 4 is 1 (<code>I</code>) less than 5 (<code>V</code>): <code>IV</code> and 9 is 1 (<code>I</code>) less than 10 (<code>X</code>): <code>IX</code>. Only the following subtractive forms are used: 4 (<code>IV</code>), 9 (<code>IX</code>), 40 (<code>XL</code>), 90 (<code>XC</code>), 400 (<code>CD</code>) and 900 (<code>CM</code>).</li>
<li>Only powers of 10 (<code>I</code>, <code>X</code>, <code>C</code>, <code>M</code>) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (<code>V</code>), 50 (<code>L</code>), or 500 (<code>D</code>) multiple times. If you need to append a symbol 4 times use the <strong>subtractive form</strong>.</li>
</ul><p>Given an integer, convert it to a Roman numeral.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<div style="margin-left: 40px">
<span class="example-io">num = 3749</span>
</div>

<b>Output:</b>
<div style="margin-left: 40px">
<span class="example-io">"MMMDCCXLIX"</span>
</div>

<b>Explanation:</b>
<div style="margin-left: 40px">
<pre>
3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
</pre>
</div>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<div style="margin-left: 40px">
<span class="example-io">num = 58</span>
</div>

<b>Output:</b>
<div style="margin-left: 40px">
<span class="example-io">"LVIII"</span>
</div>

<b>Explanation:</b>
<div style="margin-left: 40px">
<pre>
50 = L
 8 = VIII
</pre>
</div>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<div style="margin-left: 40px">
<span class="example-io">num = 1994</span>
</div>

<b>Output:</b>
<div style="margin-left: 40px">
<span class="example-io">"MCMXCIV"</span>
</div>

<b>Explanation:</b>
<div style="margin-left: 40px">
<pre>
1000 = M
 900 = CM
  90 = XC
   4 = IV
</pre>
</div>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= num &lt;= 3999</code></li>
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

<!-- No hints -->

<br>

---

#### Similar

**LeetCode** (website)

* [13 Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
* [273 Integer to English Words](https://leetcode.com/problems/integer-to-english-words/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-09-20, Sat 20 September 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )