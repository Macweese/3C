[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2327. Number of People Aware of a Secret

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2327](https://leetcode.com/problems/number-of-people-aware-of-a-secret/)

## Description

<p>On day <code>1</code>, one person discovers a secret.</p><p>You are given an integer <code>delay</code>, which means that each person will <strong>share</strong> the secret with a new person <strong>every day</strong>, starting from <code>delay</code> days after discovering the secret. You are also given an integer <code>forget</code>, which means that each person will <strong>forget</strong> the secret <code>forget</code> days after discovering it. A person <strong>cannot</strong> share the secret on the same day they forgot it, or on any day afterwards.</p><p>Given an integer <code>n</code>, return<em> the number of people who know the secret at the end of day </em><code>n</code>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 6, delay = 2, forget = 4
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
5
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Day 1: Suppose the first person is named A. (1 person)
Day 2: A is the only person who knows the secret. (1 person)
Day 3: A shares the secret with a new person, B. (2 people)
Day 4: A shares the secret with a new person, C. (3 people)
Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
Day 6: B shares the secret with E, and C shares the secret with F. (5 people)
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 4, delay = 1, forget = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
6
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Day 1: The first person is named A. (1 person)
Day 2: A shares the secret with B. (2 people)
Day 3: A and B share the secret with 2 new people, C and D. (4 people)
Day 4: A forgets the secret. B, C, and D share the secret with 3 new people. (6 people)
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= n &lt;= 1000</code></li>
<li><code>1 &lt;= delay &lt; forget &lt;= n</code></li>
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

`dynamic programming`
`queue`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Let dp[i][j] be the number of people who have known the secret for exactly j + 1 days, at day i.
</details>
<details>
  <summary>Hint 2</summary>
  If j &gt; 0, dp[i][j] = dp[i – 1][j – 1].
</details>
<details>
  <summary>Hint 3</summary>
  dp[i][0] = sum(dp[i – 1][j]) for j in [delay – 1, forget – 2].
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