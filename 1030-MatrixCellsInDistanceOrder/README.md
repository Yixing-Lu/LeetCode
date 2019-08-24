We are given a matrix with `R` rows and `C` columns has cells with integer coordinates `(r, c)`, where `0 <= r < R` and `0 <= c < C`.

Additionally, we are given a cell in that matrix with coordinates `(r0, c0)`.

Return the coordinates of all cells in the matrix, sorted by their distance from `(r0, c0)` from smallest distance to largest distance.  Here, the distance between two cells `(r1, c1)` and `(r2, c2)` is the Manhattan distance, `|r1 - r2| + |c1 - c2|`.  (You may return the answer in any order that satisfies this condition.)

---

> Input: R = 2, C = 3, r0 = 1, c0 = 2
> Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
> Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
> There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].

---

**Approach 1 BFS**

```JAVA
public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    boolean[][] visited = new boolean[R][C];
    int[][] result = new int[R * C][2];
    int i = 0;
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.offer(new int[]{r0, c0});
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int r = cell[0];
      int c = cell[1];

      if (r < 0 || r >= R || c < 0 || c >= C) {
        continue;
      }
      if (visited[r][c]) {
        continue;
      }

      result[i] = cell;
      i++;
      visited[r][c] = true;

      queue.offer(new int[]{r, c - 1});
      queue.offer(new int[]{r, c + 1});
      queue.offer(new int[]{r - 1, c});
      queue.offer(new int[]{r + 1, c});
    }
    return result;
  }
```

Time O(N)