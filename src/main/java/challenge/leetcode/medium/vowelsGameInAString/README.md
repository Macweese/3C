[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3227. Vowels Game in a String

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3227](https://leetcode.com/problems/vowels-game-in-a-string/)

## Description

<p>Alice and Bob are playing a game on a string.</p><p>You are given a string <code>s</code>, Alice and Bob will take turns playing the following game where Alice starts <strong>first</strong>:</p><ul>
<li>On Alice's turn, she has to remove any <strong>non-empty</strong> <span data-keyword="substring">substring</span> from <code>s</code> that contains an <strong>odd</strong> number of vowels.</li>
<li>On Bob's turn, he has to remove any <strong>non-empty</strong> <span data-keyword="substring">substring</span> from <code>s</code> that contains an <strong>even</strong> number of vowels.</li>
</ul><p>The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play <strong>optimally</strong>.</p><p>Return <code>true</code> if Alice wins the game, and <code>false</code> otherwise.</p><p>The English vowels are: <code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, and <code>u</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "leetcoder"</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">true</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Alice plays first, she can delete the underlined substring in <code>s = "<u><strong>leetco</strong></u>der"</code> which contains 3 vowels. The resulting string is <code>s = "der"</code>.</li>
<li>Bob plays second, he can delete the underlined substring in <code>s = "<u><strong>d</strong></u>er"</code> which contains 0 vowels. The resulting string is <code>s = "er"</code>.</li>
<li>Alice plays third, she can delete the whole string <code>s = "<strong><u>er</u></strong>"</code> which contains 1 vowel.</li>
<li>Bob plays fourth, since the string is empty, there is no valid play for Bob. So Alice wins the game.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">s = "bbcd"</span>
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
<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
<li><code>s</code> consists only of lowercase English letters.</li>
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

`math`
`string`
`brainteaser`
`game theory`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If there are no vowels in the initial string, then Bob wins.
</details>
<details>
  <summary>Hint 2</summary>
  If the number of vowels in the initial string is odd, then Alice can remove the whole string on her first turn and win.
</details>
<details>
  <summary>Hint 3</summary>
  What if the number of vowels in the initial string is even? What’s the optimal play for Alice’s first turn?
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