Given an array of integers `A` with even length, return `true` if and only if it is possible to reorder it such that `A[2 * i + 1] = 2 * A[2 * i]` for every `0 <= i < len(A) / 2`.

---

> Input: [4,-2,2,-4]
> Output: true
> Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

---

Let's try to (virtually) "write" the final reordered array.

Let's check elements in order of absolute value. When we check an element `x` and it isn't used, it must pair with `2*x`. We will attempt to write `x, 2x` - if we can't, then the answer is `false`. If we write everything, the answer is `true`.

To keep track of what we have not yet written, we will store it in a `count`.

```java
class Solution {
    public boolean canReorderDoubled(int[] A) {
        // count[x] = the number of occurrences of x in A
        Map<Integer, Integer> count = new HashMap();
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // B = A as Integer[], sorted by absolute value
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; ++i)
            B[i] = A[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        for (int x: B) {
            // If this can't be consumed, skip
            if (count.get(x) == 0) continue;
            // If this doesn't have a doubled partner, the answer is false
            if (count.getOrDefault(2*x, 0) <= 0) return false;

            // Write x, 2*x
            count.put(x, count.get(x) - 1);
            count.put(2*x, count.get(2*x) - 1);
        }

        // If we have written everything, the answer is true
        return true;
    }
}
```

- Time Complexity: $O(N \log N)$, where N is the length of `A`.

- Space Complexity: O(N)

  