Given a string `S` that **only** contains "I" (increase) or "D" (decrease), let `N = S.length`.

Return **any** permutation `A` of `[0, 1, ..., N]` such that for all `i = 0, ..., N-1`:

- If `S[i] == "I"`, then `A[i] < A[i+1]`
- If `S[i] == "D"`, then `A[i] > A[i+1]`

---

> Input: "IDID"
> Output: [0,4,1,3,2]

---

If we see say `S[0] == 'I'`, we can always put `0` as the first element; similarly, if we see `S[0] == 'D'`, we can always put `N` as the first element.

Keep track of the smallest and largest element we haven't placed. If we see an `'I'`, place the small element; otherwise place the large element.

```JAVA
class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }
}
```

- Time Complexity: O(N), where N is the length of `S`.
- Space Complexity: O(N)