

# A

Given a binary-matrix of 1's and 0's representing coordinates for a map of land and water respectively, we are to find and return the size of the largest island in the matrix.
Previously, iterating through the entire matrix was done, and performing DFS on every cell that contains a '1', and updating the max island size seen so far from the DFS result as
currentMaxIslandSize = max(currentMaxIslandSize, DFS_result). However, after finalizing a complete, working solution, I realized that not every cell *has to be* visited.
As there are cases where cells may be skipped, the difficult problem is however, identifying which cells, given the matrix size x*y and layout of the islands.

Symbol legend:
water cell = '0'
land cell = '1'
skippable cell = '-'
skippable and already visited = '*'
potentially skippable = '?'

Assume iterating starting from top left corner, going right-to-left, top-to-bottom
MATRIX:
```
0 1 1 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 1 1 1 0 0 0
0 1 1 1 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 0
0 1 0 0 1 1 0 0 1 1 1 0 0
0 0 0 1 1 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0 0
```

Let our current position for iteration be marked with "X"
If we have a current max island size of 15, then we could potentially skip the following cells (marked with -):
```
0 1 1 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 1 1 1 0 0 0
0 1 1 1 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 X -
0 1 0 0 1 1 0 0 1 1 1 - -
0 0 0 1 1 0 0 0 0 0 - - -
0 0 0 0 0 0 0 1 1 - - - -
0 0 0 0 0 0 0 1 - - - - -
```

Or the following:
Because the positions marked with '*' are already visited, we know that there exists a "boundary" of at least 1 cell between the visited cell, and the next potential island to the right of the visited cells (' * ')
and because the remaining cells, after subtracting the water boundary, is less than 15, we may skip visiting those cells altogether.
Similarly, this assessment is applied to the remaining unvisited cells to the left of the already visited (' * ') cells, and we have already visited the cells to the north, and thus know that the remaining cells are either:
* already accounted for by a DFS
* unconnected for / unvisited due to a boundary

and that the size of any potential unvisited island is thus a maximum size of the constrained area, which is smaller than 15 cells, we can safely skip searching for islands in those cells.
```
0 1 1 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 1 1 1 0 0 0
0 1 1 1 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 0
0 1 0 0 1 1 0 0 1 1 1 0 0
0 0 0 1 1 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 X * * - - -
- - - - - - - * * - - - -
```

```
0 1 1 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 1 1 1 0 0 0
0 1 1 1 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 X
0 1 0 0 1 1 0 0 1 1 1 - -
0 0 0 1 1 0 0 0 0 0 * - -
0 0 0 0 0 0 0 1 1 1 - - -
0 0 0 0 0 0 0 1 - - - - -

Plus 1 extra cell skip anywhere 
```

Or any combination of 15 at least cell skips? e.g. Carving out sections that form boundaries, with sections < currentMaxIslandSize (15) in size
```
0 1 1 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 1 1 1 0 0 0
0 1 1 1 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 0
0 1 0 0 1 1 0 0 1 1 1 0 0
0 0 0 1 1 X ? ? ? ? ? ? ?
? ? ? ? ? ? ? ? ? ? ? ? ?
? ? ? ? ? ? ? ? ? ? ? ? ?
```

Perhaps "bisecting" the remaining cells to see if they lead anywhere, e.g. if the last rows are not connected, as such:
```
1 1 1 1 1 1 0 1 1 1 1 1 1
1 1 1 1 1 1 0 1 1 1 1 1 1
```
That means any remaining island is not possibly larger than the current max of 15, so everything can be skipped henceforth.

Other optimization techniques that could perhaps be employed; checking cells of every n-th row/column, 
if the current max island size is 15, every other row could be skipped, because even if the entire row is connected as a single island (13 cells), it is smaller than the current max (15)
```
0 1 1 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 1 1 1 0 0 0
0 1 1 1 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 0
0 1 0 0 1 1 0 0 1 1 1 0 0
0 0 0 1 1 0 0 0 0 0 1 0 0 << We found the largest island ending in this row, every (currentMaxIslandSize / row.size) from now on may be skipped
- - - - - - - - - - - - -
0 0 0 0 0 0 0 1 1 0 0 0 0
```

or in the following diamond/checker pattern:
```
0 - 1 - 0 - 0 - 0 - 0 - 0
- 1 - 0 - 0 - 1 - 1 - 0 -
0 - 1 - 1 - 0 - 0 - 0 - 0
- 1 - 0 - 1 - 0 - 0 - 0 -
0 - 0 - 1 - 0 - 1 - 1 - 0
- 0 - 1 - 0 - 0 - 0 - 0 -
0 - 0 - 0 - 0 - 1 - 0 - 0
- 0 - 0 - 0 - 1 - 0 - 0 -
```