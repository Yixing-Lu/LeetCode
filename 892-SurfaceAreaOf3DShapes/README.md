On a `N * N` grid, we place some `1 * 1 * 1 `cubes.

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of grid cell `(i, j)`.

Return the total surface area of the resulting shapes.

---

> Input: [[1,2],[3,4]]
> Output: 34

---

Let's try to count the surface area contributed by `v = grid[i][j]`.

When `v > 0`, the top and bottom surface contributes an area of 2.

Then, for each side (west side, north side, east side, south side) of the column at `grid[i][j]`, the neighboring cell with value `nv` means our square contributes `max(v - nv, 0)`.

For example, for `grid = [[1, 5]]`, the contribution at `grid[0][1]` is 2 + 5 + 5 + 5 + 4. The 2 comes from the top and bottom side, the 5 comes from the north, east, and south side; and the 4 comes from the west side, of which 1 unit is covered by the adjacent column.

For each `v = grid[r][c] > 0`, count `ans += 2`, plus `ans += max(v - nv, 0)` for each neighboring value `nv` adjacent to `grid[r][c]`.

```JAVA
class Solution {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int ans = 0;

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }

        return ans;
    }
}
```

- Time Complexity: $O(N^2)$, where N is the number of rows (and columns) in the `grid`.
- Space Complexity: O(1)