[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 20. Valid Parentheses

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 20](https://leetcode.com/problems/valid-parentheses/)

## Description

<p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p><p>An input string is valid if:</p><ol>
<li>Open brackets must be closed by the same type of brackets.</li>
<li>Open brackets must be closed in the correct order.</li>
<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "()"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "()[]{}"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "(]"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 4
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "([])"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

#### Example 5
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "([)]"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">false</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
<li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li>
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
`stack`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use a stack of characters.
</details>
<details>
  <summary>Hint 2</summary>
  When you encounter an opening bracket, push it to the top of the stack.
</details>
<details>
  <summary>Hint 3</summary>
  When you encounter a closing bracket, check if the top of the stack was the opening for it. If yes, pop it from the stack. Otherwise, return false.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [22 Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
* [32 Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
* [301 Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)
* [1003 Check If Word Is Valid After Substitutions](https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/)
* [2116 Check if a Parentheses String Can Be Valid](https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/)
* [2337 Move Pieces to Obtain a String](https://leetcode.com/problems/move-pieces-to-obtain-a-string/)


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