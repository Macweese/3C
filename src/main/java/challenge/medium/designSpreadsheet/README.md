# 3484. Design Spreadsheet

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 3484](https://leetcode.com/problems/design-spreadsheet/)


## Description

A spreadsheet is a grid with 26 columns (labeled from `'A'` to `'Z'`) and a given number of `rows`. Each cell in the spreadsheet can hold an integer value between 0 and 10<sup>5</sup>.

Implement the `Spreadsheet` class:

* `Spreadsheet(int rows)` Initializes a spreadsheet with 26 columns (labeled `'A'` to `'Z'`) and the specified number of rows. All cells are initially set to 0.
* void` setCell(String cell, int value)` Sets the value of the specified `cell`. The cell reference is provided in the format `"AX"` (e.g., `"A1"`, `"B10"`), where the letter represents the column (from `'A'` to `'Z'`) and the number represents a **1-indexed** row.
* `void resetCell(String cell)` Resets the specified cell to 0.
* `int getValue(String formula)` Evaluates a formula of the form `"=X+Y"`, where `X` and `Y` are **either** cell references or non-negative integers, and returns the computed sum.

**Note:** If `getValue` references a cell that has not been explicitly set using `setCell`, its value is considered 0.

<br>


#### Example 1
<div style="margin-left: 40px">

<b>Input:</b>

<div style="margin-left: 40px">

`["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
[[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]`
</div>

<b>Output:</b>

<div style="margin-left: 40px">

`[null, 12, null, 16, null, 25, null, 15]`
</div>

<b>Explanation:</b>

<div style="margin-left: 40px">

    Spreadsheet spreadsheet = new Spreadsheet(3);   // Initializes a spreadsheet with 3 rows and 26 columns
    spreadsheet.getValue("=5+7");                   // returns 12 (5+7)
    spreadsheet.setCell("A1", 10);                  // sets A1 to 10
    spreadsheet.getValue("=A1+6");                  // returns 16 (10+6)
    spreadsheet.setCell("B2", 15);                  // sets B2 to 15
    spreadsheet.getValue("=A1+B2");                 // returns 25 (10+15)
    spreadsheet.resetCell("A1");                    // resets A1 to 0
    spreadsheet.getValue("=A1+B2");                 // returns 15 (0+15)
</div>
</div>


### Constraints:

* <code>1 &le; rows &le; 10<sup>3</sup></code>
* <code>0 &le; value &le; 10<sup>9999999999999999999</sup></code>
* The formula is always in the format `"=X+Y"`, where `X` and `Y` are either valid cell references or **non-negative** integers with values less than or equal to <code>10<sup>5</sup></code>.
* Each cell reference consists of a capital letter from `'A'` to `'Z'` followed by a row number between `1` and `rows`.
* At most <code>10<sup>4</sup></code> calls will be made in **total** to `setCell`, `resetCell`, and `getValue`.

<br>

## Solution

### Intuition

### Approach

### Complexity analysis

$$
\begin{flalign}&
n \ \stackrel{\text{def}}{=}
\text{placeholder}
&\end{flalign}
$$

$$
\begin{flalign} &
m \stackrel{\text{def}}{=} \text{placeholder}
& \end{flalign}
$$

#### Time Complexity

* Time complexity: $ O(1) $
  Constant time.

#### Space Complexity

* Space complexity: $ O(1) $
  No extra space is used.

---

[comment]: # ( --- submission image --- )


---

<br>

#### Tags

`array`
`hash table`
`string`
`design`
`matrix`
`biweekly contest 152`

---


<details>
  <summary>Hint 1</summary>

Use a hashmap to represent the cells, where the key is the cell reference (e.g., `"A1"`) and the value is the integer stored in the cell.

</details>

<details>
  <summary>Hint 2</summary>

For `setCell`, simply assign the given value to the specified cell in the hashmap.

</details>


<details>
  <summary>Hint 3</summary>

For `resetCell`, set the value of the specified cell to `0` in the hashmap.

</details>

<details>
  <summary>Hint 4</summary>

For `getValue`, find the values of the operands from the hashmap and return their sum.

</details>

<br>

---

#### Similar

**LeetCode** (website)

* [168 Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)

**Local** (repository)

* [168 Excel Sheet Column Title](../../easy/excelSheetColumnTitle)

---

**POTD** `2025-09-19, Fri
 19 September 2025`

[comment]: # (comment)
[comment]: #
[comment]: #

<br>

**Notes**  



