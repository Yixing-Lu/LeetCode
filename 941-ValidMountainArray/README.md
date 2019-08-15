Given an array `A` of integers, return `true` if and only if it is a *valid mountain array*.

Recall that A is a mountain array if and only if:

- `A.length >= 3`
- There exists some **i** with such that:
  - `A[0] < A[1] < ... A[i-1] < A[i]`
  - `A[i] > A[i+1] > ... > A[A.length - 1]`

---

> Input: [0,3,2,1]
> Output: true

---

Let's walk up from left to right until we can't: that has to be the peak. We should ensure the peak is not the first or last element. Then, we walk down. If we reach the end, the array is valid, otherwise its not.

```java
class Solution {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.
- Space Complexity: O(1). 

