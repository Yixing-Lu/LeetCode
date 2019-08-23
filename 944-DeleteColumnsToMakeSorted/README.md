We are given an array `A` of `N` lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

For example, if we have an array `A = ["``abcdef``","uvwxyz"]` and deletion indices `{0, 2, 3}`, then the final array after deletions is `["bef", "vyz"]`, and the remaining columns of `A` are `["b"``,"``v"]`, `["e","y"]`, and `["f","z"]`.  (Formally, the `c`-th column is `[A[0][c], A[1][c], ..., A[A.length-1][c]]`.)

Suppose we chose a set of deletion indices `D` such that after deletions, each remaining column in A is in **non-decreasing** sorted order.

Return the minimum possible value of `D.length`.

---

> Input: ["cba","daf","ghi"]
> Output: 1
> Explanation: 
> After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
> If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.

---

For each column, check if its sorted. If it isn't, it must be deleted, so we add 1 to the final answer.

```JAVA
class Solution {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }
}
```

- Time Complexity: O(A), whereA is the total *content* of `A`.
- Space Complexity: O(1)
