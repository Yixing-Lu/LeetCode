On a `N * N` grid, we place some `1 * 1 * 1 `cubes that are axis-aligned with the x, y, and z axes.

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of grid cell `(i, j)`.

Now we view the *projection* of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.

---

> Input: [[1,2],[3,4]]
> Output: 17
> Explanation: 
> Here are the three projections ("shadows") of the shape made with each axis-aligned plane.

---

From the top, the shadow made by the shape will be 1 square for each non-zero value.

From the side, the shadow made by the shape will be the largest value for each row in the grid.

From the front, the shadow made by the shape will be the largest value for each column in the grid.

With the example `[[1,2],[3,4]]`:

- The shadow from the top will be 4, since there are four non-zero values in the grid;
- The shadow from the side will be `2 + 4`, since the maximum value of the first row is `2`, and the maximum value of the second row is `4`;
- The shadow from the front will be `3 + 4`, since the maximum value of the first column is `3`, and the maximum value of the second column is `4`.

```java
class Solution {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N;  ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }
}
```

- Time Complexity: $O(N^2)$, where N is the length of `grid`.
- Space Complexity: O(1)