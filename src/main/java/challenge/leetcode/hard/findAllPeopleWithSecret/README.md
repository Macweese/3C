[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2092. Find All People With Secret

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2092](https://leetcode.com/problems/find-all-people-with-secret/)

## Description

<p>You are given an integer <code>n</code> indicating there are <code>n</code> people numbered from <code>0</code> to <code>n - 1</code>. You are also given a <strong>0-indexed</strong> 2D integer array <code>meetings</code> where <code>meetings[i] = [x<sub>i</sub>, y<sub>i</sub>, time<sub>i</sub>]</code> indicates that person <code>x<sub>i</sub></code> and person <code>y<sub>i</sub></code> have a meeting at <code>time<sub>i</sub></code>. A person may attend <strong>multiple meetings</strong> at the same time. Finally, you are given an integer <code>firstPerson</code>.</p><p>Person <code>0</code> has a <strong>secret</strong> and initially shares the secret with a person <code>firstPerson</code> at time <code>0</code>. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person <code>x<sub>i</sub></code> has the secret at <code>time<sub>i</sub></code>, then they will share the secret with person <code>y<sub>i</sub></code>, and vice versa.</p><p>The secrets are shared <strong>instantaneously</strong>. That is, a person may receive the secret and share it with people in other meetings within the same time frame.</p><p>Return <em>a list of all the people that have the secret after all the meetings have taken place. </em>You may return the answer in <strong>any order</strong>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,2,3,5]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
At time 0, person 0 shares the secret with person 1.
At time 5, person 1 shares the secret with person 2.
At time 8, person 2 shares the secret with person 3.
At time 10, person 1 shares the secret with person 5.​​​​
Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,3]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
At time 0, person 0 shares the secret with person 3.
At time 2, neither person 1 nor person 2 know the secret.
At time 3, person 3 shares the secret with person 0 and person 1.
Thus, people 0, 1, and 3 know the secret after all the meetings.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[0,1,2,3,4]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
At time 0, person 0 shares the secret with person 1.
At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
Note that person 2 can share the secret at the same time as receiving it.
At time 2, person 3 shares the secret with person 4.
Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= meetings.length &lt;= 10<sup>5</sup></code></li>
<li><code>meetings[i].length == 3</code></li>
<li><code>0 &lt;= x<sub>i</sub>, y<sub>i </sub>&lt;= n - 1</code></li>
<li><code>x<sub>i</sub> != y<sub>i</sub></code></li>
<li><code>1 &lt;= time<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= firstPerson &lt;= n - 1</code></li>
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

`depth-first search`
`breadth-first search`
`union find`
`graph`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Could you model all the meetings happening at the same time as a graph?
</details>
<details>
  <summary>Hint 2</summary>
  What data structure can you use to efficiently share the secret?
</details>
<details>
  <summary>Hint 3</summary>
  You can use the union-find data structure to quickly determine who knows the secret and share the secret.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [882 Reachable Nodes In Subdivided Graph](https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-19, Fri 19 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )