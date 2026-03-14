[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3296. Minimum Number of Seconds to Make Mountain Height Zero

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3296](https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/)

## Description

<p>You are given an integer <code>mountainHeight</code> denoting the height of a mountain.</p><p>You are also given an integer array <code>workerTimes</code> representing the work time of workers in <strong>seconds</strong>.</p><p>The workers work <strong>simultaneously</strong> to <strong>reduce</strong> the height of the mountain. For worker <code>i</code>:</p><ul>
<li>To decrease the mountain's height by <code>x</code>, it takes <code>workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x</code> seconds. For example:

	<ul>
<li>To reduce the height of the mountain by 1, it takes <code>workerTimes[i]</code> seconds.</li>
<li>To reduce the height of the mountain by 2, it takes <code>workerTimes[i] + workerTimes[i] * 2</code> seconds, and so on.</li>
</ul>
</li>
</ul><p>Return an integer representing the <strong>minimum</strong> number of seconds required for the workers to make the height of the mountain 0.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">mountainHeight = 4, workerTimes = [2,1,1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">3</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>One way the height of the mountain can be reduced to 0 is:</p><ul>
<li>Worker 0 reduces the height by 1, taking <code>workerTimes[0] = 2</code> seconds.</li>
<li>Worker 1 reduces the height by 2, taking <code>workerTimes[1] + workerTimes[1] * 2 = 3</code> seconds.</li>
<li>Worker 2 reduces the height by 1, taking <code>workerTimes[2] = 1</code> second.</li>
</ul><p>Since they work simultaneously, the minimum time needed is <code>max(2, 3, 1) = 3</code> seconds.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">mountainHeight = 10, workerTimes = [3,2,2,4]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">12</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li>Worker 0 reduces the height by 2, taking <code>workerTimes[0] + workerTimes[0] * 2 = 9</code> seconds.</li>
<li>Worker 1 reduces the height by 3, taking <code>workerTimes[1] + workerTimes[1] * 2 + workerTimes[1] * 3 = 12</code> seconds.</li>
<li>Worker 2 reduces the height by 3, taking <code>workerTimes[2] + workerTimes[2] * 2 + workerTimes[2] * 3 = 12</code> seconds.</li>
<li>Worker 3 reduces the height by 2, taking <code>workerTimes[3] + workerTimes[3] * 2 = 12</code> seconds.</li>
</ul><p>The number of seconds needed is <code>max(9, 12, 12, 12) = 12</code> seconds.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">mountainHeight = 5, workerTimes = [1]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">15</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There is only one worker in this example, so the answer is <code>workerTimes[0] + workerTimes[0] * 2 + workerTimes[0] * 3 + workerTimes[0] * 4 + workerTimes[0] * 5 = 15</code>.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= mountainHeight &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= workerTimes.length &lt;= 10<sup>4</sup></code></li>
<li><code>1 &lt;= workerTimes[i] &lt;= 10<sup>6</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`math`
`binary search`
`greedy`
`heap (priority queue)`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Can we use binary search to solve this problem?
</details>
<details>
  <summary>Hint 2</summary>
  Do a binary search on the number of seconds to check if it&#39;s enough to reduce the mountain height to 0 or less with all workers working simultaneously.
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

`2026-03-13, Fri 13 March 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )