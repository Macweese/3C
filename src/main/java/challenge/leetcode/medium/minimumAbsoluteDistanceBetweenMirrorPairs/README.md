[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3761. Minimum Absolute Distance Between Mirror Pairs

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3761](https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/)

## Description

<p>You are given an integer array <code>nums</code>.</p><p>A <strong>mirror pair</strong> is a pair of indices <code>(i, j)</code> such that:</p><ul>
<li><code>0 &lt;= i &lt; j &lt; nums.length</code>, and</li>
<li><code>reverse(nums[i]) == nums[j]</code>, where <code>reverse(x)</code> denotes the integer formed by reversing the digits of <code>x</code>. Leading zeros are omitted after reversing, for example <code>reverse(120) = 21</code>.</li>
</ul><p>Return the <strong>minimum</strong> absolute distance between the indices of any mirror pair. The absolute distance between indices <code>i</code> and <code>j</code> is <code>abs(i - j)</code>.</p><p>If no mirror pair exists, return <code>-1</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [12,21,45,33,54]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>The mirror pairs are:</p><ul>
<li>(0, 1) since <code>reverse(nums[0]) = reverse(12) = 21 = nums[1]</code>, giving an absolute distance <code>abs(0 - 1) = 1</code>.</li>
<li>(2, 4) since <code>reverse(nums[2]) = reverse(45) = 54 = nums[4]</code>, giving an absolute distance <code>abs(2 - 4) = 2</code>.</li>
</ul><p>The minimum absolute distance among all pairs is 1.</p>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [120,21]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There is only one mirror pair (0, 1) since <code>reverse(nums[0]) = reverse(120) = 21 = nums[1]</code>.</p><p>The minimum absolute distance is 1.</p>
</pre>

</div>

<br>

#### Example 3
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [21,120]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">-1</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>There are no mirror pairs in the array.</p>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code>​​​​​​​</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`hash table`
`math`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Scan left to right with a hash map: for each &lt;code&gt;nums[i]&lt;/code&gt;, if the map contains key &lt;code&gt;nums[i]&lt;/code&gt; then set &lt;code&gt;ans = min(ans, i - map[nums[i]])&lt;/code&gt;.
</details>
<details>
  <summary>Hint 2</summary>
  Store/update the current index under key &lt;code&gt;reverse(nums[i])&lt;/code&gt;, so future matches use the most recent index.
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

`2026-04-17, Fri 17 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )