Given a non-negative integer `c`, your task is to decide whether there're two integers `a` and `b` such that a2 + b2 = c.

---

> Input: 5
> Output: True
> Explanation: 1 * 1 + 2 * 2 = 5

---

**Approach 1 Brute Force**

The simplest solution would be to consider every possible combination of integers a*a*and b*b* and check if the sum of their squares equals c. Now, both a and b can lie within the range $(0,\sqrt{c})$. Thus, we need to check for the values of a and b in this range only.

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }
}
```

- Time complexity : O(c). Two loops upto $\sqrt{c}$. Here, c refers to the given integer(sum of squares).
- Space complexity : O(1). Constant extra space is used. 

---

**Approach 2 Better Brute Force**

We can improve the last solution, if we make the following observation. For any particular a*a* chosen, the value of b*b* required to satisfy the equation a^2 + b^2 = c*a*2+*b*2=*c* will be such that b^2 = c - a^2*b*2=*c*−*a*2. Thus, we need to traverse over the range (0, \sqrt{c})(0,*c*) only for considering the various values of a*a*. For every current value of a*a* chosen, we can determine the corresponding b^2*b*2 value and check if it is a perfect square or not. If it happens to be a perfect square, c*c* is a sum of squares of two integers, otherwise not.

Now, to determine, if the number c - a^2*c*−*a*2 is a perfect square or not, we can make use of the following theorem:

$n^2=1+3+5+...+(2⋅n−1)=∑_{i=1}^n(2⋅i−1)$

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b =  c - (int)(a * a);
            int i = 1, sum = 0;
            while (sum < b) {
                sum += i;
                i += 2;
            }
            if (sum == b)
                return true;
        }
        return false;
    }
}
```

---

**Approach 4 Sqrt**

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}
```

---

**Approach 5 Binary Search**

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
}
```

---

**Approach 6 Fermat Theorem**

`Any positive number n is expressible as a sum of two squares if and only if the prime factorization of n, every prime of the form (4k+3) occurs an even number of times.`

By making use of the above theorem, we can directly find out if the given number c*c*can be expressed as a sum of two squares.

In case, c*c* itself is a prime number, it won't be divisible by any of the primes in the [2,\sqrt{c}][2,*c*]. Thus, we need to check if c*c* can be expressed in the form of 4k+34*k*+3. If so, we need to return a False value, indicating that this prime occurs an odd number(1) of times.

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
```

