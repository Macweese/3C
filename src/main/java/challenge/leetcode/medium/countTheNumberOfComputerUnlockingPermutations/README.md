[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3577. Count the Number of Computer Unlocking Permutations

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3577](https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/)

## Description

<p>You are given an array <code>complexity</code> of length <code>n</code>.</p><p>There are <code>n</code> <strong>locked</strong> computers in a room with labels from 0 to <code>n - 1</code>, each with its own <strong>unique</strong> password. The password of the computer <code>i</code> has a complexity <code>complexity[i]</code>.</p><p>The password for the computer labeled 0 is <strong>already</strong> decrypted and serves as the root. All other computers must be unlocked using it or another previously unlocked computer, following this information:</p><ul>
<li>You can decrypt the password for the computer <code>i</code> using the password for computer <code>j</code>, where <code>j</code> is <strong>any</strong> integer less than <code>i</code> with a lower complexity. (i.e. <code>j &lt; i</code> and <code>complexity[j] &lt; complexity[i]</code>)</li>
<li>To decrypt the password for computer <code>i</code>, you must have already unlocked a computer <code>j</code> such that <code>j &lt; i</code> and <code>complexity[j] &lt; complexity[i]</code>.</li>
</ul><p>Find the number of <span data-keyword="permutation-array">permutations</span> of <code>[0, 1, 2, ..., (n - 1)]</code> that represent a valid order in which the computers can be unlocked, starting from computer 0 as the only initially unlocked one.</p><p>Since the answer may be large, return it <strong>modulo</strong> 10<sup>9</sup> + 7.</p><p><strong>Note</strong> that the password for the computer <strong>with label</strong> 0 is decrypted, and <em>not</em> the computer with the first position in the permutation.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">complexity = [1,2,3]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">2</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The valid permutations are:</p><ul>
<li>[0, 1, 2]
	<ul>
<li>Unlock computer 0 first with root password.</li>
<li>Unlock computer 1 with password of computer 0 since <code>complexity[0] &lt; complexity[1]</code>.</li>
<li>Unlock computer 2 with password of computer 1 since <code>complexity[1] &lt; complexity[2]</code>.</li>
</ul>
</li>
<li>[0, 2, 1]
	<ul>
<li>Unlock computer 0 first with root password.</li>
<li>Unlock computer 2 with password of computer 0 since <code>complexity[0] &lt; complexity[2]</code>.</li>
<li>Unlock computer 1 with password of computer 0 since <code>complexity[0] &lt; complexity[1]</code>.</li>
</ul>
</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">complexity = [3,3,3,4,4,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">0</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There are no possible permutations which can unlock all computers.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= complexity.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= complexity[i] &lt;= 10<sup>9</sup></code></li>
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
`math`
`brainteaser`
`combinatorics`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Ensure that the element at index 0 has the unique minimum complexity (no other element can match its value).
</details>
<details>
  <summary>Hint 2</summary>
  Fix index 0 as the first in the unlocking order.
</details>
<details>
  <summary>Hint 3</summary>
  The remaining indices from &lt;code&gt;1&lt;/code&gt; to &lt;code&gt;n - 1&lt;/code&gt; can then be arranged arbitrarily, yielding &lt;code&gt;factorial(n - 1)&lt;/code&gt; possible orders.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1006 Clumsy Factorial](https://leetcode.com/problems/clumsy-factorial/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-10, Wed 10 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )