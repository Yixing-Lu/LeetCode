Given an array `A` of positive lengths, return the largest perimeter of a triangle with **non-zero area**, formed from 3 of these lengths.

If it is impossible to form any triangle of non-zero area, return `0`.

---

> Input: [3,2,3,4]
> Output: 10

---

This leads to a simple algorithm: Sort the array. For any c*c* in the array, we choose the largest possible a \leq b \leq c*a*≤*b*≤*c*: these are just the two values adjacent to c*c*. If this forms a triangle, we return the answer.

```java
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
}
```

Time Complexity: O(N log N)

Space Complexity: O(1)