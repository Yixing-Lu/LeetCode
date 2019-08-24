Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

---

> Input: 10
> Output: True
> Explanation:
> The binary representation of 10 is: 1010.

---

**Approach 1 Convert to String**

Let's convert the given number into a string of binary digits. Then, we should simply check that no two adjacent digits are the same.

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
```

Time Complexity: O(1). For arbitrary inputs, we do O(w)work, where w is the number of bits in `n`. However, w ≤ 32.

Space complexity: O(1), or alternatively O(w)

----

**Approach 2 Divide By Two**

We can get the last bit and the rest of the bits via `n % 2` and `n // 2` operations. Let's remember `cur`, the last bit of `n`. If the last bit ever equals the last bit of the remaining, then two adjacent bits have the same value, and the answer is `False`. Otherwise, the answer is `True`.

Also note that instead of `n % 2` and `n // 2`, we could have used operators `n & 1` and `n >>= 1` instead.

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}
```

- Time Complexity: O(1). For arbitrary inputs, we do O(w)work, where w*w* is the number of bits in `n`. However, w≤32.
- Space complexity: O(1)