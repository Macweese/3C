[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1488. Avoid Flood in The City

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 1488](https://leetcode.com/problems/avoid-flood-in-the-city/)

## Description

<p>Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the <code>nth</code> lake, the <code>nth</code> lake becomes full of water. If it rains over a lake that is <strong>full of water</strong>, there will be a <strong>flood</strong>. Your goal is to avoid floods in any lake.</p><p>Given an integer array <code>rains</code> where:</p><ul>
<li><code>rains[i] &gt; 0</code> means there will be rains over the <code>rains[i]</code> lake.</li>
<li><code>rains[i] == 0</code> means there are no rains this day and you can choose <strong>one lake</strong> this day and <strong>dry it</strong>.</li>
</ul><p>Return <em>an array <code>ans</code></em> where:</p><ul>
<li><code>ans.length == rains.length</code></li>
<li><code>ans[i] == -1</code> if <code>rains[i] &gt; 0</code>.</li>
<li><code>ans[i]</code> is the lake you choose to dry in the <code>ith</code> day if <code>rains[i] == 0</code>.</li>
</ul><p>If there are multiple valid answers return <strong>any</strong> of them. If it is impossible to avoid flood return <strong>an empty array</strong>.</p><p>Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
rains = [1,2,3,4]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[-1,-1,-1,-1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day full lakes are [1,2,3]
After the fourth day full lakes are [1,2,3,4]
There's no day to dry any lake and there is no flood in any lake.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
rains = [1,2,0,0,2,1]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[-1,-1,2,1,-1,-1]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day, we dry lake 2. Full lakes are [1]
After the fourth day, we dry lake 1. There is no full lakes.
After the fifth day, full lakes are [2].
After the sixth day, full lakes are [1,2].
It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
rains = [1,2,0,1,2]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
[]
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
After that, it will rain over lakes [1,2]. It's easy to prove that no matter which lake you choose to dry in the 3rd day, the other one will flood.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= rains.length &lt;= 10<sup>5</sup></code></li>
<li><code>0 &lt;= rains[i] &lt;= 10<sup>9</sup></code></li>
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
`hash table`
`binary search`
`greedy`
`heap (priority queue)`


---

<details>
  <summary>Hint 1</summary>
  Keep An array of the last day there was rains over each city.
</details>
<details>
  <summary>Hint 2</summary>
  Keep an array of the days you can dry a lake when you face one.
</details>
<details>
  <summary>Hint 3</summary>
  When it rains over a lake, check the first possible day you can dry this lake and assign this day to this lake.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* <!-- No similar problems or unavailable -->

**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-10-07, Tue 07 October 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )