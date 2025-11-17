# 2197. Replace Non-Coprime Numbers In Array

<h3 style="color:#FF4800;">Hard</h3>

[LeetCode 2197](https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/)

<h2>Description</h2>

You are given an array of integers `nums`. Perform the following steps:

1. Find **any** two **adjacent** numbers in `nums` that are **non-coprime**.
2. If no such numbers are found, **stop** the process.
3. Otherwise, delete the two numbers and replace them with their **LCM** (Least Common Multiple).
4. **Repeat** this process as long as you keep finding two adjacent non-coprime numbers.

Return the _**final**_ modified array. It can be shown that replacing adjacent non-coprime numbers in **any** arbitrary order will lead to the same `result`.

The test cases are generated such that the values in the final array are **less than or equal** to <code>10<sup>8</sup></code>.

Two values `x` and `y` are **non-coprime** if `GCD(x, y) > 1` where `GCD(x, y)` is the **Greatest Common Divisor** of `x` and `y`.

<br>


<h4>Example 1</h4>
<div style="margin-left: 40px">
	
<b>Input:</b>  `nums = [6,4,3,2,7,6,2]`

<b>Output:</b>  `[12,7,6]`

<b>Explanation:</b>

<div style="margin-left: 40px">
	(6, 4) are non-coprime with LCM(6, 4) = 12. Now, <code>nums = [<b>12</b>,3,2,7,6,2]</code>.<br>
	(6, 4) are non-coprime with LCM(6, 4) = 12. Now, <code>nums = [<b>12</b>,2,7,6,2]</code>.<br>
	(6, 4) are non-coprime with LCM(6, 4) = 12. Now, <code>nums = [<b>12</b>,2,7,6,2]</code>.<br>
	(6, 4) are non-coprime with LCM(6, 4) = 12. Now, <code>nums = [12,3,2,7,<b>6</b>]</code>.<br>
	There are no more adjacent non-coprime numbers in <code>nums</code>.<br>
	Thus, the final modified array is <code>[12,7,6]</code>.<br>
	Note that there are other ways to obtain the same resultant array.<br>
</div>
</div>


<h4>Example 2</h4>
<div style="margin-left: 40px">

<b>Input:</b>  `nums = [2,2,1,1,3,3,3]`

<b>Output:</b>  `[2,1,1,3]`

<b>Explanation:</b>

<div style="margin-left: 40px">
	(3, 3) are non-coprime with LCM(3, 3) = 3. Now, <code>nums = [2,2,1,1,<b>3</b>,3]</code>.<br>
	(3, 3) are non-coprime with LCM(3, 3) = 3. Now, <code>nums = [2,2,1,1,<b>3</b>]</code>.<br>
	(2, 2) are non-coprime with LCM(2, 2) = 2. Now, <code>nums = [<b>2</b>,1,1,3]</code>.<br>
	There are no more adjacent non-coprime numbers in <code>nums</code>.<br>
	Thus, the final modified array is <code>[2,1,1,3]</code><br>
	Note that there are other ways to obtain the same resultant array.<br>
</div>
</div>


<h3>Constraints:</h3>

- <code>1 &le; nums.length &le; 10<sup>5</sup></code>
- <code>1 &le; nums[i] &le; 10<sup>5</sup></code>
- The test cases are generated such that the values in the final array are **less than or equal** to 10<sup>8</sup>.

<br>

<h2>Solution</h2>

<h3>Intuition</h3>

<h3>Approach</h3>

<h3>Complexity analysis</h3>

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

<h4>Time Complexity</h4>

- Time complexity: $ O(1) $  
  Constant time.

<h4>Space Complexity</h4>

- Space complexity: $ O(1) $  
  No extra space is used.

### Code

```c
#pragma GCC optimize("O3, unroll-loops")
static inline int gcd(int x, int y)
{
    int bz = fmin(__builtin_ctz(x), __builtin_ctz(y));
    if (bz > 0)
    {
        return gcd(x >> bz, y >> bz) << bz;
    }
    int r = x % y;
    return r ? gcd(y, r) : y;
}

static int* replaceNonCoprimes(int* nums, int n, int* returnSize)
{
    int a = -1;
    for(int i = 0; i < n; i++)
    {
        int b = nums[i];
        while(a != -1)
        {
            int g = gcd(nums[a], b);
            if (g == 1)
            {
                break;
            }
            b *= nums[a] / g;
            a--;
        }
        nums[++a] = b;
    }
    *returnSize = a + 1;
    return nums;
}
```

![img.png](replaceNonCoprimeNumbersInArrayAC.png)

---

<br>

<h4>Tags</h4>

`array`
`math`
`stack`
`number theory`
`weekly contest 283`

---

#### Hints

<details>
  <summary>Hint 1</summary>

Notice that the order of merging two numbers into their LCM does not matter so we can greedily merge elements to its left if possible.

</details>

<details>
  <summary>Hint 2</summary>
  
  If a new value is formed, we should recursively check if it can be merged with the value to its left.
  
</details>


<details>
  <summary>Hint 3</summary>
  
  To simulate the merge efficiently, we can maintain a stack that stores processed elements. When we iterate through the array, we only compare with the top of the stack (which is the value to its left).
  
</details>

<br>

<h4>Similar</h4>

**LeetCode** (website)

- [1209: Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)
- [2001 Number of Pairs of Interchangeable Rectangles](https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/)
- [2584 Split the Array to Make Coprime Products](https://leetcode.com/problems/split-the-array-to-make-coprime-products/)

**Local** (repository)

- [1209: Remove All Adjacent Duplicates in String II](../../medium/removeAllAdjacentDuplicatesInAStringII)
- [2001 Number of Pairs of Interchangeable Rectangles](../../medium/numberOfPairsOfInterchangeableRectangles)
- [2584 Split the Array to Make Coprime Products](../splitTheArrayToMakeCoprimeProducts)

---

**POTD** `2025-09-16, Tue
 16 September 2025`

[comment]: #
[comment]: #
[comment]: #

<br>

**Notes**  



