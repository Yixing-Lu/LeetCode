Given an array `A` of integers, for each integer `A[i]` we may choose any `x` with `-K <= x <= K`, and add `x` to `A[i]`.

After this process, we have some array `B`.

Return the smallest possible difference between the maximum value of `B` and the minimum value of `B`.

---

> Input: A = [0,10], K = 2
> Output: 6
> Explanation: B = [2,8]

---

Let `A` be the original array, and `B` be the array after all our modifications. Towards trying to minimize `max(B) - min(B)`, let's try to minimize `max(B)` and maximize `min(B)` separately.

The smallest possible value of `max(B)` is `max(A) - K`, as the value `max(A)` cannot go lower. Similarly, the largest possible value of `min(B)` is `min(A) + K`. So the quantity `max(B) - min(B)` is at least `ans = (max(A) - K) - (min(A) + K)`.

```java
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2*K);
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.
- Space Complexity: O(1)