[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 3093. Longest Common Suffix Queries

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 3093](https://leetcode.com/problems/longest-common-suffix-queries/)

## Description

<p>You are given two arrays of strings <code>wordsContainer</code> and <code>wordsQuery</code>.</p><p>For each <code>wordsQuery[i]</code>, you need to find a string from <code>wordsContainer</code> that has the <strong>longest common suffix</strong> with <code>wordsQuery[i]</code>. If there are two or more strings in <code>wordsContainer</code> that share the longest common suffix, find the string that is the <strong>smallest</strong> in length. If there are two or more such strings that have the <strong>same</strong> smallest length, find the one that occurred <strong>earlier</strong> in <code>wordsContainer</code>.</p><p>Return <em>an array of integers </em><code>ans</code><em>, where </em><code>ans[i]</code><em> is the index of the string in </em><code>wordsContainer</code><em> that has the <strong>longest common suffix</strong> with </em><code>wordsQuery[i]</code><em>.</em></p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[1,1,1]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>Let's look at each <code>wordsQuery[i]</code> separately:</p><ul>
<li>For <code>wordsQuery[0] = "cd"</code>, strings from <code>wordsContainer</code> that share the longest common suffix <code>"cd"</code> are at indices 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.</li>
<li>For <code>wordsQuery[1] = "bcd"</code>, strings from <code>wordsContainer</code> that share the longest common suffix <code>"bcd"</code> are at indices 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.</li>
<li>For <code>wordsQuery[2] = "xyz"</code>, there is no string from <code>wordsContainer</code> that shares a common suffix. Hence the longest common suffix is <code>""</code>, that is shared with strings at index 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.</li>
</ul>
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
<span class="example-io">wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh","acbfgh","acbfegh"]</span>
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
<span class="example-io">[2,0,2]</span>
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
<p>Let's look at each <code>wordsQuery[i]</code> separately:</p><ul>
<li>For <code>wordsQuery[0] = "gh"</code>, strings from <code>wordsContainer</code> that share the longest common suffix <code>"gh"</code> are at indices 0, 1, and 2. Among these, the answer is the string at index 2 because it has the shortest length of 6.</li>
<li>For <code>wordsQuery[1] = "acbfgh"</code>, only the string at index 0 shares the longest common suffix <code>"fgh"</code>. Hence it is the answer, even though the string at index 2 is shorter.</li>
<li>For <code>wordsQuery[2] = "acbfegh"</code>, strings from <code>wordsContainer</code> that share the longest common suffix <code>"gh"</code> are at indices 0, 1, and 2. Among these, the answer is the string at index 2 because it has the shortest length of 6.</li>
</ul>
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= wordsContainer.length, wordsQuery.length &lt;= 10<sup>4</sup></code></li>
<li><code>1 &lt;= wordsContainer[i].length &lt;= 5 * 10<sup>3</sup></code></li>
<li><code>1 &lt;= wordsQuery[i].length &lt;= 5 * 10<sup>3</sup></code></li>
<li><code>wordsContainer[i]</code> consists only of lowercase English letters.</li>
<li><code>wordsQuery[i]</code> consists only of lowercase English letters.</li>
<li>Sum of <code>wordsContainer[i].length</code> is at most <code>5 * 10<sup>5</sup></code>.</li>
<li>Sum of <code>wordsQuery[i].length</code> is at most <code>5 * 10<sup>5</sup></code>.</li>
</ul>

<br>

---

<br>

#### Tags

`array`
`string`
`trie`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  If we reverse the strings, the problem changes to finding the longest common prefix.
</details>
<details>
  <summary>Hint 2</summary>
  Build a Trie, each node is a letter and only saves the best word’s index in each node, based on the criteria.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [14 Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
* [3043 Find the Length of the Longest Common Prefix](https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2026-05-28, Thu 28 May 2026`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )