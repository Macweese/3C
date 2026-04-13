[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1320. Minimum Distance to Type a Word Using Two Fingers

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1320](https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/)

## Description

<img alt="" src="https://assets.leetcode.com/uploads/2020/01/02/leetcode_keyboard.png" style="width: 349px; height: 209px;"/><p>You have a keyboard layout as shown above in the <strong>X-Y</strong> plane, where each English uppercase letter is located at some coordinate.</p><ul>
<li>For example, the letter <code>'A'</code> is located at coordinate <code>(0, 0)</code>, the letter <code>'B'</code> is located at coordinate <code>(0, 1)</code>, the letter <code>'P'</code> is located at coordinate <code>(2, 3)</code> and the letter <code>'Z'</code> is located at coordinate <code>(4, 1)</code>.</li>
</ul><p>Given the string <code>word</code>, return <em>the minimum total <strong>distance</strong> to type such string using only two fingers</em>.</p><p>The <strong>distance</strong> between coordinates <code>(x<sub>1</sub>, y<sub>1</sub>)</code> and <code>(x<sub>2</sub>, y<sub>2</sub>)</code> is <code>|x<sub>1</sub> - x<sub>2</sub>| + |y<sub>1</sub> - y<sub>2</sub>|</code>.</p><p><strong>Note</strong> that the initial positions of your two fingers are considered free so do not count towards your total distance, also your two fingers do not have to start at the first letter or the first two letters.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
word = "CAKE"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Using two fingers, one optimal way to type "CAKE" is: 
Finger 1 on letter 'C' -&gt; cost = 0 
Finger 1 on letter 'A' -&gt; cost = Distance from letter 'C' to letter 'A' = 2 
Finger 2 on letter 'K' -&gt; cost = 0 
Finger 2 on letter 'E' -&gt; cost = Distance from letter 'K' to letter 'E' = 1 
Total distance = 3
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
word = "HAPPY"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Using two fingers, one optimal way to type "HAPPY" is:
Finger 1 on letter 'H' -&gt; cost = 0
Finger 1 on letter 'A' -&gt; cost = Distance from letter 'H' to letter 'A' = 2
Finger 2 on letter 'P' -&gt; cost = 0
Finger 2 on letter 'P' -&gt; cost = Distance from letter 'P' to letter 'P' = 0
Finger 1 on letter 'Y' -&gt; cost = Distance from letter 'A' to letter 'Y' = 4
Total distance = 6
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= word.length &lt;= 300</code></li>
<li><code>word</code> consists of uppercase English letters.</li>
</ul>

<br>

---

<br>

#### Tags

`string`
`dynamic programming`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use dynamic programming.
</details>
<details>
  <summary>Hint 2</summary>
  dp[i][j][k]: smallest movements when you have one finger on i-th char and the other one on j-th char already having written k first characters from word.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [1974 Minimum Time to Type Word Using Special Typewriter](https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-12, Sun 12 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )