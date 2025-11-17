[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3234. Count the Number of Substrings With Dominant Ones

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3234](https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/)

## Description

<p>You are given a binary string <code>s</code>.</p><p>Return the number of <span data-keyword="substring-nonempty">substrings</span> with <strong>dominant</strong> ones.</p><p>A string has <strong>dominant</strong> ones if the number of ones in the string is <strong>greater than or equal to</strong> the <strong>square</strong> of the number of zeros in the string.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "00011"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">5</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The substrings with dominant ones are shown in the table below.</p>
<table><thead><tr><th>i</th><th>j</th><th>s[i..j]</th><th>Number of Zeros</th><th>Number of Ones</th></tr></thead><tbody><tr><td>3</td><td>3</td><td>1</td><td>0</td><td>1</td></tr><tr><td>4</td><td>4</td><td>1</td><td>0</td><td>1</td></tr><tr><td>2</td><td>3</td><td>01</td><td>1</td><td>1</td></tr><tr><td>3</td><td>4</td><td>11</td><td>0</td><td>2</td></tr><tr><td>2</td><td>4</td><td>011</td><td>1</td><td>2</td></tr></tbody></table>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "101101"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">16</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The substrings with <strong>non-dominant</strong> ones are shown in the table below.</p><p>Since there are 21 substrings total and 5 of them have non-dominant ones, 
it follows that there are 16 substrings with dominant ones.</p>
<table><thead><tr><th>i</th><th>j</th><th>s[i..j]</th><th>Number of Zeros</th><th>Number of Ones</th></tr></thead><tbody><tr><td>1</td><td>1</td><td>0</td><td>1</td><td>0</td></tr><tr><td>4</td><td>4</td><td>0</td><td>1</td><td>0</td></tr><tr><td>1</td><td>4</td><td>0110</td><td>2</td><td>2</td></tr><tr><td>0</td><td>4</td><td>10110</td><td>2</td><td>3</td></tr><tr><td>1</td><td>5</td><td>01101</td><td>2</td><td>3</td></tr></tbody></table>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 4 * 10<sup>4</sup></code></li>
<li><code>s</code> consists only of characters <code>'0'</code> and <code>'1'</code>.</li>
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
`sliding window`
`enumeration`


---

<details>
  <summary>Hint 1</summary>
  Let us fix the starting index &lt;code&gt;l&lt;/code&gt; of the substring and count the number of indices &lt;code&gt;r&lt;/code&gt; such that &lt;code&gt;l &lt;= r&lt;/code&gt; and the substring &lt;code&gt;s[l..r]&lt;/code&gt; has dominant ones.
</details>
<details>
  <summary>Hint 2</summary>
  A substring with dominant ones has at most &lt;code&gt;sqrt(n)&lt;/code&gt; zeros.
</details>
<details>
  <summary>Hint 3</summary>
  We cannot iterate over every &lt;code&gt;r&lt;/code&gt; and check if the  &lt;code&gt;s[l..r]&lt;/code&gt; has dominant ones. Instead, we iterate over the next &lt;code&gt;sqrt(n)&lt;/code&gt; zeros to the left of &lt;code&gt;l&lt;/code&gt; and count the number of substrings with dominant ones where the current zero is the rightmost zero of the substring.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [696 Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**  
`2025-11-15, Sat 15 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )