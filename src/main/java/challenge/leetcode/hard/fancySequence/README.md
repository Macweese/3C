[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1622. Fancy Sequence

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1622](https://leetcode.com/problems/fancy-sequence/)

## Description

<p>Write an API that generates fancy sequences using the <code>append</code>, <code>addAll</code>, and <code>multAll</code> operations.</p><p>Implement the <code>Fancy</code> class:</p><ul>
<li><code>Fancy()</code> Initializes the object with an empty sequence.</li>
<li><code>void append(val)</code> Appends an integer <code>val</code> to the end of the sequence.</li>
<li><code>void addAll(inc)</code> Increments all existing values in the sequence by an integer <code>inc</code>.</li>
<li><code>void multAll(m)</code> Multiplies all existing values in the sequence by an integer <code>m</code>.</li>
<li><code>int getIndex(idx)</code> Gets the current value at index <code>idx</code> (0-indexed) of the sequence <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>. If the index is greater or equal than the length of the sequence, return <code>-1</code>.</li>
</ul>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[null, null, null, null, null, 10, null, null, null, 26, 34, 20]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Fancy fancy = new Fancy();
fancy.append(2);   // fancy sequence: [2]
fancy.addAll(3);   // fancy sequence: [2+3] -&gt; [5]
fancy.append(7);   // fancy sequence: [5, 7]
fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -&gt; [10, 14]
fancy.getIndex(0); // return 10
fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -&gt; [13, 17]
fancy.append(10);  // fancy sequence: [13, 17, 10]
fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -&gt; [26, 34, 20]
fancy.getIndex(0); // return 26
fancy.getIndex(1); // return 34
fancy.getIndex(2); // return 20
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= val, inc, m &lt;= 100</code></li>
<li><code>0 &lt;= idx &lt;= 10<sup>5</sup></code></li>
<li>At most <code>10<sup>5</sup></code> calls total will be made to <code>append</code>, <code>addAll</code>, <code>multAll</code>, and <code>getIndex</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`math`
`design`
`segment tree`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use two arrays to save the cumulative multipliers at each time point and cumulative sums adjusted by the current multiplier.
</details>
<details>
  <summary>Hint 2</summary>
  The function getIndex(idx) ask to the current value modulo 10^9+7. Use modular inverse and both arrays to calculate this value.
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

`2026-03-15, Sun 15 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )