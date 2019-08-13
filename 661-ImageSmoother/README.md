Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

---

> Input:
> [[1,1,1],
>  [1,0,1],
>  [1,1,1]]
> Output:
> [[0, 0, 0],
>  [0, 0, 0],
>  [0, 0, 0]]
> Explanation:
> For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
> For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
> For the point (1,1): floor(8/9) = floor(0.88888889) = 0

---

For each cell in the grid, look at the immediate neighbors - up to 9 of them, including the original cell.

Then, we will add the sum of the neighbors into `ans[r][c]` while recording `count`, the number of such neighbors. The final answer is the sum divided by the count.

```java
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; nr++)
                    for (int nc = c-1; nc <= c+1; nc++) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
}
```

- Time Complexity: *O*(*N*), where N*N* is the number of pixels in our image. We iterate over every pixel.
- Space Complexity: *O*(*N*), the size of our answer.

