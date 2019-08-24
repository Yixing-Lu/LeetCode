Given two integers `L` and `R`, find the count of numbers in the range `[L, R]`(inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of `1`s present when written in binary. For example, `21` written in binary is `10101` which has 3 set bits. Also, 1 is not a prime.)

---

> Input: L = 10, R = 15
> Output: 5
> Explanation:
> 10 -> 1010 (2 set bits, 2 is prime)
> 11 -> 1011 (3 set bits, 3 is prime)
> 12 -> 1100 (2 set bits, 2 is prime)
> 13 -> 1101 (3 set bits, 3 is prime)
> 14 -> 1110 (3 set bits, 3 is prime)
> 15 -> 1111 (4 set bits, 4 is not prime)

---

For each number from `L` to `R`, let's find out how many set bits it has. If that number is `2, 3, 5, 7, 11, 13, 17`, or `19`, then we add one to our count. We only need primes up to 19 because $R \leq 10^6 < 2^{20}*$.

```JAVA
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }
    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}
```

Time Complexity: O(D)

Space Complexity: O(1)

---

**Note**

Integer.bitCount(x): 计算x的二进制中1的个数

