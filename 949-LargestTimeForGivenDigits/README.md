Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

----

> Input: [1,2,3,4]
> Output: "23:41"

---

Iterate over all permutations `(i, j, k, l)` of `(0, 1, 2, 3)`. For each permutation, we can try the time `A[i]A[j] : A[k]A[l]`.

This is a valid time if and only if the number of hours `10*A[i] + A[j]` is less than `24`; and the number of minutes `10*A[k] + A[l]` is less than `60`.

We will output the largest valid time.

```JAVA
// Solution inspired by @rock
class Solution {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;

        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j) if (j != i)
                for (int k = 0; k < 4; ++k) if (k != i && k != j) {
                    int l = 6 - i - j - k;

                    // For each permutation of A[i], read out the time and
                    // record the largest legal time.
                    int hours = 10 * A[i] + A[j];
                    int mins = 10 * A[k] + A[l];
                    if (hours < 24 && mins < 60)
                        ans = Math.max(ans, hours * 60 + mins);
                }

        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)