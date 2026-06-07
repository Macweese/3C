[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 1665. Minimum Initial Energy to Finish Tasks

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 1665](https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/)

## Description

<p>You are given an array <code>tasks</code> where <code>tasks[i] = [actual<sub>i</sub>, minimum<sub>i</sub>]</code>:</p><ul>
<li><code>actual<sub>i</sub></code> is the actual amount of energy you <strong>spend to finish</strong> the <code>i<sup>th</sup></code> task.</li>
<li><code>minimum<sub>i</sub></code> is the minimum amount of energy you <strong>require to begin</strong> the <code>i<sup>th</sup></code> task.</li>
</ul><p>For example, if the task is <code>[10, 12]</code> and your current energy is <code>11</code>, you cannot start this task. However, if your current energy is <code>13</code>, you can complete this task, and your energy will be <code>3</code> after finishing it.</p><p>You can finish the tasks in <strong>any order</strong> you like.</p><p>Return <em>the <strong>minimum</strong> initial amount of energy you will need</em> <em>to finish all the tasks</em>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
tasks = [[1,2],[2,4],[4,8]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
8
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Starting with 8 energy, we finish the tasks in the following order:
    - 3rd task. Now energy = 8 - 4 = 4.
    - 2nd task. Now energy = 4 - 2 = 2.
    - 1st task. Now energy = 2 - 1 = 1.
Notice that even though we have leftover energy, starting with 7 energy does not work because we cannot do the 3rd task.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
32
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Starting with 32 energy, we finish the tasks in the following order:
    - 1st task. Now energy = 32 - 1 = 31.
    - 2nd task. Now energy = 31 - 2 = 29.
    - 3rd task. Now energy = 29 - 10 = 19.
    - 4th task. Now energy = 19 - 10 = 9.
    - 5th task. Now energy = 9 - 8 = 1.
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
27
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
Starting with 27 energy, we finish the tasks in the following order:
    - 5th task. Now energy = 27 - 5 = 22.
    - 2nd task. Now energy = 22 - 2 = 20.
    - 3rd task. Now energy = 20 - 3 = 17.
    - 1st task. Now energy = 17 - 1 = 16.
    - 4th task. Now energy = 16 - 4 = 12.
    - 6th task. Now energy = 12 - 6 = 6.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= tasks.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= actual<sub>​i</sub> &lt;= minimum<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`greedy`
`sorting`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  We can easily figure that the f(x) : does x solve this array is monotonic so binary Search is doable
</details>
<details>
  <summary>Hint 2</summary>
  Figure a sorting pattern
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

`2026-05-12, Tue 12 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )