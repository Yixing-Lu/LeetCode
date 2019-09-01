Given an integer, write a function to determine if it is a power of three.

---

Hence it should be possible to divide `n` by `b` `x` times, every time with a remainder of **0** and the end result to be **1**.

Notice that we need a guard to check that `n != 0`, otherwise the while loop will never finish. For negative numbers, the algorithm does not make sense, so we will include this guard as well.

```java
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
```

- Time complexity : $O(\log_b(n))$. In our case that is $O(\log_3n)$. The number of divisions is given by that logarithm.
- Space complexity : O(1). We are not using any additional memory. 

