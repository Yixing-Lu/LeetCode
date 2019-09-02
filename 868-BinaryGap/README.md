Given a positive integer `N`, find and return the longest distance between two consecutive 1's in the binary representation of `N`.

If there aren't two consecutive 1's, return 0.

---

> Input: 22
> Output: 2
> Explanation: 
> 22 in binary is 0b10110.
> In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
> The first consecutive pair of 1's have distance 2.
> The second consecutive pair of 1's have distance 1.
> The answer is the largest of these two distances, which is 2.

---

**Approach 1 Store Indexes**

Since we wanted to inspect the distance between consecutive 1s in the binary representation of `N`, let's write down the index of each `1` in that binary representation. For example, if `N = 22 = 0b10110`, then we'll write `A = [1, 2, 4]`. This makes it easier to proceed, as now we have a problem about adjacent values in an array.

Let's make a list `A` of indices `i` such that `N` has the `i`th bit set.

With this array `A`, finding the maximum distance between consecutive `1`s is much easier: it's the maximum distance between adjacent values of this array.

```java
class Solution {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }
}
```

- Time Complexity: $O(\log N)$. Note that $\log N$ is the number of digits in the binary representation of N
- Space Complexity: $O(\log N)$, the space used by `A`. 

----

**Approach 2 One Pass**

In *Approach 1*, we created an array `A` of indices `i` for which `N` had the `i`th bit set.

Since we only care about consecutive values of this array `A`, we don't need to store the whole array. We only need to remember the last value seen.

We'll store `last`, the last value added to the *virtual* array `A`. If `N` has the `i`th bit set, a candidate answer is `i - last`, and then the new last value added to `A` would be `last = i`.

```java
class Solution {
    public int binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }
}
```

- Time Complexity: O(log N). Note that $\log N$ is the number of digits in the binary representation of N
- Space Complexity: O(1)

