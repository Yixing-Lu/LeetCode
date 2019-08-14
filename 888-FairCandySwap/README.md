Alice and Bob have candy bars of different sizes: `A[i]` is the size of the `i`-th bar of candy that Alice has, and `B[j]` is the size of the `j`-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (*The total amount of candy a person has is the sum of the sizes of candy bars they have.*)

Return an integer array `ans` where `ans[0]` is the size of the candy bar that Alice must exchange, and `ans[1]` is the size of the candy bar that Bob must exchange.

---

> Input: A = [1,2,5], B = [2,4]
> Output: [5,4]

---

Say Alice and Bob have total candy S_A, S_B respectively.

If Alice gives candy x, and receives candy y, then Bob receives candy x and gives candy y. Then, we must have

S_A - x + y = S_B - y + x

for a fair candy swap. This implies

y = x + (S_B - S_A)/2

Our strategy is simple. For every candy x*x* that Alice has, if Bob has candy y = x + (S_B - S_A)/2, we return [x, y][*x*,*y*]. We use a `Set` structure to check whether Bob has the desired candy y in constant time.

```JAVA
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }
}
```

Time Complexity: O(A.length + B.length)

Space Complexity: O(B.length)

