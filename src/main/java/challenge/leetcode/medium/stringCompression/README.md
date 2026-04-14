[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 443. String Compression

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 443](https://leetcode.com/problems/string-compression/)

## Description

<p>Given an array of characters <code>chars</code>, compress it using the following algorithm:</p><p>Begin with an empty string <code>s</code>. For each group of <strong>consecutive repeating characters</strong> in <code>chars</code>:</p><ul>
<li>If the group's length is <code>1</code>, append the character to <code>s</code>.</li>
<li>Otherwise, append the character followed by the group's length.</li>
</ul><p>The compressed string <code>s</code> <strong>should not be returned separately</strong>, but instead, be stored <strong>in the input character array <code>chars</code></strong>. Note that group lengths that are <code>10</code> or longer will be split into multiple characters in <code>chars</code>.</p><p>After you are done <strong>modifying the input array,</strong> return <em>the new length of the array</em>.</p><p>You must write an algorithm that uses only constant extra space.</p><p><strong>Note: </strong>The characters in the array beyond the returned length do not matter and should be ignored.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
chars = ["a","a","b","b","c","c","c"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
chars = ["a"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
Return 1, and the first character of the input array should be: ["a"]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The only group is "a", which remains uncompressed since it's a single character.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= chars.length &lt;= 2000</code></li>
<li><code>chars[i]</code> is a lowercase English letter, uppercase English letter, digit, or symbol.</li>
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

`two pointers`
`string`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  How do you know if you are at the end of a consecutive group of characters?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [38 Count and Say](https://leetcode.com/problems/count-and-say/)
* [271 Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/)
* [604 Design Compressed String Iterator](https://leetcode.com/problems/design-compressed-string-iterator/)
* [1313 Decompress Run-Length Encoded List](https://leetcode.com/problems/decompress-run-length-encoded-list/)
* [3163 String Compression III](https://leetcode.com/problems/string-compression-iii/)
* [3167 Better Compression of String](https://leetcode.com/problems/better-compression-of-string/)


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