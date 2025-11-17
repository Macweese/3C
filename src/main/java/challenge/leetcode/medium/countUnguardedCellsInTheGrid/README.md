[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2257. Count Unguarded Cells in the Grid

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2257](https://leetcode.com/problems/count-unguarded-cells-in-the-grid/)

## Description

<p>You are given two integers <code>m</code> and <code>n</code> representing a <strong>0-indexed</strong> <code>m x n</code> grid. You are also given two 2D integer arrays <code>guards</code> and <code>walls</code> where <code>guards[i] = [row<sub>i</sub>, col<sub>i</sub>]</code> and <code>walls[j] = [row<sub>j</sub>, col<sub>j</sub>]</code> represent the positions of the <code>i<sup>th</sup></code> guard and <code>j<sup>th</sup></code> wall respectively.</p><p>A guard can see <b>every</b> cell in the four cardinal directions (north, east, south, or west) starting from their position unless <strong>obstructed</strong> by a wall or another guard. A cell is <strong>guarded</strong> if there is <strong>at least</strong> one guard that can see it.</p><p>Return<em> the number of unoccupied cells that are <strong>not</strong> <strong>guarded</strong>.</em></p>

#### Example 1
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/example1drawio2.png" style="width: 300px; height: 204px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
7
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/example2drawio.png" style="width: 200px; height: 201px;"/>

<b>Input:</b>
<pre style="margin-left: 40px">
m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
4
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
<li><code>1 &lt;= guards.length, walls.length &lt;= 5 * 10<sup>4</sup></code></li>
<li><code>2 &lt;= guards.length + walls.length &lt;= m * n</code></li>
<li><code>guards[i].length == walls[j].length == 2</code></li>
<li><code>0 &lt;= row<sub>i</sub>, row<sub>j</sub> &lt; m</code></li>
<li><code>0 &lt;= col<sub>i</sub>, col<sub>j</sub> &lt; n</code></li>
<li>All the positions in <code>guards</code> and <code>walls</code> are <strong>unique</strong>.</li>
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
`matrix`
`simulation`


---

<details>
  <summary>Hint 1</summary>
  Create a 2D array to represent the grid. Can you mark the tiles that can be seen by a guard?
</details>
<details>
  <summary>Hint 2</summary>
  Iterate over the guards, and for each of the 4 directions, advance the current tile and mark the tile. When should you stop advancing?
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [361 Bomb Enemy](https://leetcode.com/problems/bomb-enemy/)
* [999 Available Captures for Rook](https://leetcode.com/problems/available-captures-for-rook/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD** `2025-11-02, Sun 02 November 2025`

[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )