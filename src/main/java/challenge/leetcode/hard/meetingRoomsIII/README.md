[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )

# 2402. Meeting Rooms III

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2402](https://leetcode.com/problems/meeting-rooms-iii/)

## Description

<p>You are given an integer <code>n</code>. There are <code>n</code> rooms numbered from <code>0</code> to <code>n - 1</code>.</p><p>You are given a 2D integer array <code>meetings</code> where <code>meetings[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> means that a meeting will be held during the <strong>half-closed</strong> time interval <code>[start<sub>i</sub>, end<sub>i</sub>)</code>. All the values of <code>start<sub>i</sub></code> are <strong>unique</strong>.</p><p>Meetings are allocated to rooms in the following manner:</p><ol>
<li>Each meeting will take place in the unused room with the <strong>lowest</strong> number.</li>
<li>If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the <strong>same</strong> duration as the original meeting.</li>
<li>When a room becomes unused, meetings that have an earlier original <strong>start</strong> time should be given the room.</li>
</ol><p>Return<em> the <strong>number</strong> of the room that held the most meetings. </em>If there are multiple rooms, return<em> the room with the <strong>lowest</strong> number.</em></p><p>A <strong>half-closed interval</strong> <code>[a, b)</code> is the interval between <code>a</code> and <code>b</code> <strong>including</strong> <code>a</code> and <strong>not including</strong> <code>b</code>.</p>

#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
0
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0.
</pre>

</div>

<br>

#### Example 2
<div style="margin-left: 40px">

<b>Input:</b>
<pre style="margin-left: 40px">
n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
</pre>

<b>Output:</b>
<pre style="margin-left: 40px">
1
</pre>

<b>Explanation:</b>
<pre style="margin-left: 40px">
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.
</pre>

</div>

<br>

### Constraints:

<ul>
<li><code>1 &lt;= n &lt;= 100</code></li>
<li><code>1 &lt;= meetings.length &lt;= 10<sup>5</sup></code></li>
<li><code>meetings[i].length == 2</code></li>
<li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 5 * 10<sup>5</sup></code></li>
<li>All the values of <code>start<sub>i</sub></code> are <strong>unique</strong>.</li>
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
`sorting`
`heap (priority queue)`
`simulation`


---

**Hints**
<details>
  <summary>Hint 1</summary>
  Sort meetings based on start times.
</details>
<details>
  <summary>Hint 2</summary>
  Use two min heaps, the first one keeps track of the numbers of all the rooms that are free. The second heap keeps track of the end times of all the meetings that are happening and the room that they are in.
</details>
<details>
  <summary>Hint 3</summary>
  Keep track of the number of times each room is used in an array.
</details>
<details>
  <summary>Hint 4</summary>
  With each meeting, check if there are any free rooms. If there are, then use the room with the smallest number. Otherwise, assign the meeting to the room whose meeting will end the soonest.
</details>


<br>

---

#### Similar

**LeetCode** (website)

* [252 Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
* [253 Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
* [1353 Maximum Number of Events That Can Be Attended](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/)
* [1606 Find Servers That Handled Most Number of Requests](https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/)
* [1751 Maximum Number of Events That Can Be Attended II](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/)


**Local** (repository)

* <!-- Fill in local links if you have corresponding solutions -->

---

**POTD**

`2025-12-27, Sat 27 December 2025`


[comment]: # (comments...)

<br>

**Notes**

<!-- Your notes -->

[comment]: # (notes...)



[comment]: # ( ----- THIS FILE IS AUTO-GENERATED ----- )