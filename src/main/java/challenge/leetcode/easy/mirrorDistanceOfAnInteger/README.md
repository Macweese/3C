[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3783. Mirror Distance of an Integer

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3783](https://leetcode.com/problems/mirror-distance-of-an-integer/)

## Description

<p>You are given an integer <code>n</code>.</p><p>Define its <strong>mirror distance</strong> as: <code>abs(n - reverse(n))</code>​​​​​​​ where <code>reverse(n)</code> is the integer formed by reversing the digits of <code>n</code>.</p><p>Return an integer denoting the mirror distance of <code>n</code>​​​​​​​.</p><p><code>abs(x)</code> denotes the absolute value of <code>x</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">n = 25</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">27</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>reverse(25) = 52</code>.</li>
<li>Thus, the answer is <code>abs(25 - 52) = 27</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">n = 10</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">9</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>reverse(10) = 01</code> which is 1.</li>
<li>Thus, the answer is <code>abs(10 - 1) = 9</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">n = 7</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li><code>reverse(7) = 7</code>.</li>
<li>Thus, the answer is <code>abs(7 - 7) = 0</code>.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`math`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Simulate as described
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