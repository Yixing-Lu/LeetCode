Given a matrix `A`, return the transpose of `A`.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

---

> Input: [[1,2,3],[4,5,6],[7,8,9]]
> Output: [[1,4,7],[2,5,8],[3,6,9]]

---

The transpose of a matrix `A` with dimensions `R x C` is a matrix `ans`with dimensions `C x R` for which `ans[c][r] = A[r][c]`.

```java
class Solution {
    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) 
                ans[c][r] = A[r][c];
        return ans;
    }
}
```

- Time Complexity: O(R * C), where R and C are the number of rows and columns in the given matrix `A`.

- Space Complexity: O(R * C), the space used by the answer. 

  