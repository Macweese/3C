[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3494. Find the Minimum Amount of Time to Brew Potions

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3494](https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/)

## Description

<p>You are given two integer arrays, <code>skill</code> and <code><font face="monospace">mana</font></code>, of length <code>n</code> and <code>m</code>, respectively.</p><p>In a laboratory, <code>n</code> wizards must brew <code>m</code> potions <em>in order</em>. Each potion has a mana capacity <code>mana[j]</code> and <strong>must</strong> pass through <strong>all</strong> the wizards sequentially to be brewed properly. The time taken by the <code>i<sup>th</sup></code> wizard on the <code>j<sup>th</sup></code> potion is <code>time<sub>ij</sub> = skill[i] * mana[j]</code>.</p><p>Since the brewing process is delicate, a potion <strong>must</strong> be passed to the next wizard immediately after the current wizard completes their work. This means the timing must be <em>synchronized</em> so that each wizard begins working on a potion <strong>exactly</strong> when it arrives. ​</p><p>Return the <strong>minimum</strong> amount of time required for the potions to be brewed properly.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">skill = [1,5,2,4], mana = [5,1,4,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">110</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<table style="border: 1px solid black;">
<tbody>
<tr>
<th style="border: 1px solid black;">Potion Number</th>
<th style="border: 1px solid black;">Start time</th>
<th style="border: 1px solid black;">Wizard 0 done by</th>
<th style="border: 1px solid black;">Wizard 1 done by</th>
<th style="border: 1px solid black;">Wizard 2 done by</th>
<th style="border: 1px solid black;">Wizard 3 done by</th>
</tr>
<tr>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">0</td>
<td style="border: 1px solid black;">5</td>
<td style="border: 1px solid black;">30</td>
<td style="border: 1px solid black;">40</td>
<td style="border: 1px solid black;">60</td>
</tr>
<tr>
<td style="border: 1px solid black;">1</td>
<td style="border: 1px solid black;">52</td>
<td style="border: 1px solid black;">53</td>
<td style="border: 1px solid black;">58</td>
<td style="border: 1px solid black;">60</td>
<td style="border: 1px solid black;">64</td>
</tr>
<tr>
<td style="border: 1px solid black;">2</td>
<td style="border: 1px solid black;">54</td>
<td style="border: 1px solid black;">58</td>
<td style="border: 1px solid black;">78</td>
<td style="border: 1px solid black;">86</td>
<td style="border: 1px solid black;">102</td>
</tr>
<tr>
<td style="border: 1px solid black;">3</td>
<td style="border: 1px solid black;">86</td>
<td style="border: 1px solid black;">88</td>
<td style="border: 1px solid black;">98</td>
<td style="border: 1px solid black;">102</td>
<td style="border: 1px solid black;">110</td>
</tr>
</tbody>
</table><p>As an example for why wizard 0 cannot start working on the 1<sup>st</sup> potion before time <code>t = 52</code>, consider the case where the wizards started preparing the 1<sup>st</sup> potion at time <code>t = 50</code>. At time <code>t = 58</code>, wizard 2 is done with the 1<sup>st</sup> potion, but wizard 3 will still be working on the 0<sup>th</sup> potion till time <code>t = 60</code>.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">skill = [1,1,1], mana = [1,1,1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">5</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ol>
<li>Preparation of the 0<sup>th</sup> potion begins at time <code>t = 0</code>, and is completed by time <code>t = 3</code>.</li>
<li>Preparation of the 1<sup>st</sup> potion begins at time <code>t = 1</code>, and is completed by time <code>t = 4</code>.</li>
<li>Preparation of the 2<sup>nd</sup> potion begins at time <code>t = 2</code>, and is completed by time <code>t = 5</code>.</li>
</ol>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">skill = [1,2,3,4], mana = [1,2]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
21
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>n == skill.length</code></li>
<li><code>m == mana.length</code></li>
<li><code>1 &lt;= n, m &lt;= 5000</code></li>
<li><code>1 &lt;= mana[i], skill[i] &lt;= 5000</code></li>
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
`simulation`
`prefix sum`


---

<details>
  <summary>Hint 1</summary>
  Maintain each wizard&#39;s earliest free time (for the last potion) as &lt;code&gt;f[i]&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  Let &lt;code&gt;x&lt;/code&gt; be the current mana value. Starting from &lt;code&gt;now = f[0]&lt;/code&gt;, update &lt;code&gt;now = max(now + skill[i - 1] * x, f[i])&lt;/code&gt; for &lt;code&gt;i in [1..n]&lt;/code&gt;. Then, the final &lt;code&gt;f[n - 1] = now + skill[n - 1] * x&lt;/code&gt; for this potion.
</details>
<details>
  <summary>Hint 3</summary>
  Update all other &lt;code&gt;f&lt;/code&gt; values by &lt;code&gt;f[i] = f[i + 1] - skill[i + 1] * x&lt;/code&gt; for &lt;code&gt;i in [0..n - 2]&lt;/code&gt; (in reverse order).
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-09, Thu 09 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )