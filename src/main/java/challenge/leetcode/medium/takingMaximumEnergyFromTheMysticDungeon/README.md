[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3147. Taking Maximum Energy From the Mystic Dungeon

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3147](https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/)

## Description

<p>In a mystic dungeon, <code>n</code> magicians are standing in a line. Each magician has an attribute that gives you energy. Some magicians can give you negative energy, which means taking energy from you.</p><p>You have been cursed in such a way that after absorbing energy from magician <code>i</code>, you will be instantly transported to magician <code>(i + k)</code>. This process will be repeated until you reach the magician where <code>(i + k)</code> does not exist.</p><p>In other words, you will choose a starting point and then teleport with <code>k</code> jumps until you reach the end of the magicians' sequence, <strong>absorbing all the energy</strong> during the journey.</p><p>You are given an array <code>energy</code> and an integer <code>k</code>. Return the <strong>maximum</strong> possible energy you can gain.</p><p><strong>Note</strong> that when you are reach a magician, you <em>must</em> take energy from them, whether it is negative or positive energy.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> energy = [5,2,-10,-5,1], k = 3</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> 3</span>
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
<span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> energy = [-2,-3,-1], k = 2</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> -1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= energy.length &lt;= 10<sup>5</sup></code></li>
<li><code>-1000 &lt;= energy[i] &lt;= 1000</code></li>
<li><code>1 &lt;= k &lt;= energy.length - 1</code></li>
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
`prefix sum`


---

<details>
  <summary>Hint 1</summary>
  Let &lt;code&gt;dp[i]&lt;/code&gt; denote the energy we gain starting from index &lt;code&gt;i&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  We can notice, that &lt;code&gt; dp[i] = dp[i + k] + energy[i]&lt;/code&gt;.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-10, Fri 10 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )