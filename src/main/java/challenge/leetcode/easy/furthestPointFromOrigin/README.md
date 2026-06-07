[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2833. Furthest Point From Origin

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 2833](https://leetcode.com/problems/furthest-point-from-origin/)

## Description

<p>You are given a string <code>moves</code> of length <code>n</code> consisting only of characters <code>'L'</code>, <code>'R'</code>, and <code>'_'</code>. The string represents your movement on a number line starting from the origin <code>0</code>.</p><p>In the <code>i<sup>th</sup></code> move, you can choose one of the following directions:</p><ul>
<li>move to the left if <code>moves[i] = 'L'</code> or <code>moves[i] = '_'</code></li>
<li>move to the right if <code>moves[i] = 'R'</code> or <code>moves[i] = '_'</code></li>
</ul><p>Return <em>the <strong>distance from the origin</strong> of the <strong>furthest</strong> point you can get to after </em><code>n</code><em> moves</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
moves = "L_RL__R"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
3
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The furthest point we can reach from the origin 0 is point -3 through the following sequence of moves "LLRLLLR".
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
moves = "_R__LL_"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The furthest point we can reach from the origin 0 is point -5 through the following sequence of moves "LRLLLLL".
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
moves = "_______"
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The furthest point we can reach from the origin 0 is point 7 through the following sequence of moves "RRRRRRR".
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= moves.length == n &lt;= 50</code></li>
<li><code>moves</code> consists only of characters <code>'L'</code>, <code>'R'</code> and <code>'_'</code>.</li>
</ul>

<br>

---

<br>

#### Tags

`string`
`counting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  &lt;div class=&#34;_1l1MA&#34;&gt;In an optimal answer, all occurrences of &lt;code&gt;&#39;_’&lt;/code&gt; will be replaced with the &lt;strong&gt;same&lt;/strong&gt; character.&lt;/div&gt;
</details>
<details>
  <summary>Hint 2</summary>
  &lt;div class=&#34;_1l1MA&#34;&gt;Replace all characters of &lt;code&gt;&#39;_’&lt;/code&gt; with the character that occurs the most. &lt;/div&gt;
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [657 Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-04-24, Fri 24 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )