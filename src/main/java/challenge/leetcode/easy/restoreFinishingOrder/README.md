# 3668. Restore Finishing Order

<h3 style="color:#3BE38C;">Easy</h3>

[LeetCode 3668](https://leetcode.com/problems/restore-finishing-order/)


## Description

You are given an integer array order of length n and an integer array friends.

* order contains every integer from 1 to n exactly once, representing the IDs of the participants of a race in their finishing order.
* friends contains the IDs of your friends in the race sorted in strictly increasing order. Each ID in friends is guaranteed to appear in the order array.

Return an array containing your friends' IDs in their finishing order.


<br>


#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>

<div style="margin-left: 40px">

`order = [3,1,2,5,4], friends = [1,3,4]`
</div>

<b>Output:</b>

<div style="margin-left: 40px">

`[3,1,4]`
</div>

<b>Explanation:</b>

<div style="margin-left: 40px">

The finishing order is `[3, 1, 2, 5, 4]`.  
Therefore, the finishing order of your friends is `[3, 1, 4]`.  

</div>
</div>


#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>

<div style="margin-left: 40px">

`order = [1,4,5,3,2], friends = [2,5]`
</div>

<b>Output:</b>

<div style="margin-left: 40px">

`[5,2]`
</div>

<b>Explanation:</b>

<div style="margin-left: 40px">

The finishing order is `[1, 4, 5, 3, 2]`.  
Therefore, the finishing order of your friends is `[5, 2]`.  
</div>
</div>

### Constraints:

* `order` contains every integer from `1` to `n` exactly once
* <code>1 &le; order.length &le; 100</code>
* <code>1 &le; friends.length &le; min(8, n)</code>
* <code>1 &le; friends[i] &le; n</code>
* `friends` is strictly increasing

<br>

## Solution

### Intuition

### Approach

### Complexity analysis

$$
\begin{flalign}&
n \ \stackrel{\text{def}}{=}
\text{elements}
&\end{flalign}
$$

$$
\begin{flalign} &
m \stackrel{\text{def}}{=} \text{arrays}
& \end{flalign}
$$

#### Time Complexity

* Time complexity: $ O(1) $
  Constant time.

#### Space Complexity

* Space complexity: $ O(1) $
  No extra space is used.

---

<br>

#### Tags

`array`
`binary search`
`hash set`
`weekly contest 465`

---


<details>
  <summary>Hint 1</summary>

Use a hash set for quick friend lookups from `friends`.

</details>

<details>
  <summary>Hint 2</summary>

Iterate over `order`, checking the set to collect your friends in finishing order.

</details>

<br>

---

#### Similar

**LeetCode** (website)

* 

**Local** (repository)

* 

---

**POTD** 

[comment]: #
[comment]: #
[comment]: #

<br>

**Notes**  



