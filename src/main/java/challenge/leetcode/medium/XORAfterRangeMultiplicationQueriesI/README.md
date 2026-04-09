[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3653. XOR After Range Multiplication Queries I

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3653](https://leetcode.com/problems/xor-after-range-multiplication-queries-i/)

## Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> and a 2D integer array <code>queries</code> of size <code>q</code>, where <code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>, k<sub>i</sub>, v<sub>i</sub>]</code>.</p><p>For each query, you must apply the following operations in order:</p><ul>
<li>Set <code>idx = l<sub>i</sub></code>.</li>
<li>While <code>idx &lt;= r<sub>i</sub></code>:
	<ul>
<li>Update: <code>nums[idx] = (nums[idx] * v<sub>i</sub>) % (10<sup>9</sup> + 7)</code></li>
<li>Set <code>idx += k<sub>i</sub></code>.</li>
</ul>
</li>
</ul><p>Return the <strong>bitwise XOR</strong> of all elements in <code>nums</code> after processing all queries.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [1,1,1], queries = [[0,2,1,4]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">4</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li data-end="106" data-start="18">A single query <code data-end="44" data-start="33">[0, 2, 1, 4]</code> multiplies every element from index 0 through index 2 by 4.</li>
<li data-end="157" data-start="109">The array changes from <code data-end="141" data-start="132">[1, 1, 1]</code> to <code data-end="154" data-start="145">[4, 4, 4]</code>.</li>
<li data-end="205" data-start="160">The XOR of all elements is <code data-end="202" data-start="187">4 ^ 4 ^ 4 = 4</code>.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">31</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<ul>
<li data-end="350" data-start="230">The first query <code data-end="257" data-start="246">[1, 4, 2, 3]</code> multiplies the elements at indices 1 and 3 by 3, transforming the array to <code data-end="347" data-start="333">[2, 9, 1, 15, 4]</code>.</li>
<li data-end="466" data-start="353">The second query <code data-end="381" data-start="370">[0, 2, 1, 2]</code> multiplies the elements at indices 0, 1, and 2 by 2, resulting in <code data-end="463" data-start="448">[4, 18, 2, 15, 4]</code>.</li>
<li data-end="532" data-is-last-node="" data-start="469">Finally, the XOR of all elements is <code data-end="531" data-start="505">4 ^ 18 ^ 2 ^ 15 ^ 4 = 31</code>.​​​​​​​<strong>​​​​​​​</strong></li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n == nums.length &lt;= 10<sup>3</sup></code></li>
<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
<li><code>1 &lt;= q == queries.length &lt;= 10<sup>3</sup></code></li>
<li><code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>, k<sub>i</sub>, v<sub>i</sub>]</code></li>
<li><code>0 &lt;= l<sub>i</sub> &lt;= r<sub>i</sub> &lt; n</code></li>
<li><code>1 &lt;= k<sub>i</sub> &lt;= n</code></li>
<li><code>1 &lt;= v<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

<br>

#### Tags

`array`
`divide and conquer`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Use bruteforce
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

`2026-04-08, Wed 08 April 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )