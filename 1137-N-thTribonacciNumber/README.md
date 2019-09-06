The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given `n`, return the value of Tn.

---

> Input: n = 4
> Output: 4
> Explanation:
> T_3 = 0 + 1 + 1 = 2
> T_4 = 1 + 1 + 2 = 4

---

Calculate next element `d = a + b + c`,
let `(a,b,c) = (b,c,d)`.
Repeat this process `n - 2` times;

We can loop `n` times and return `i0`.
It can remove the special cases for `n < 2`.

```java
class Solution {
    public int tribonacci(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
            n--;
        }
        return c;
    }
}
```

Time `O(N)`
Space `O(1)`