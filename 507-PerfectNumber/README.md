We define the Perfect Number is a **positive** integer that is equal to the sum of all its **positive** divisors except itself.

Now, given an **integer** n, write a function that returns true when it is a perfect number and false when it is not.

---

> Input: 28
> Output: True
> Explanation: 28 = 1 + 2 + 4 + 7 + 14

---

**Approach 1 Brute Force**

```java

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
            if(sum>num) {
                return false;
            }
        }
        return sum == num;
    }
}
```

- Time complexity : O(n). In worst case, we iterate over all the numbers lesser than n
- Space complexity : O(1). Constant extra space is used.

---

**Approach 2 Optimal**

In this method, instead of iterating over all the integers to find the factors of num*n**u**m*, we only iterate upto the $\sqrt{n}$ The reasoning behind this can be understood as follows.

Consider the given number num which can have m distinct factors, namely n_1, n_2,..., n_m. Now, since the number num is divisible by n_i, it is also divisible by n_j=num/n_1*n**j*=*n**u**m*/*n*1 i.e. n_i*n_j=num*n**i*∗*n**j*=*n**u**m*. Also, the largest number in such a pair can only be up to \sqrt{num}*n**u**m* (because \sqrt{num} \times \sqrt{num}=num*n**u**m*×*n**u**m*=*n**u**m*). Thus, we can get a significant reduction in the run-time by iterating only upto \sqrt{num}*n**u**m* and considering such n_i*n**i*'s and n_j*n**j*'s in a single pass directly.

Further, if $\sqrt{num}$ is also a factor, we have to consider the factor only once while checking for the perfect number property.

We sum up all such factors and check if the given number is a Perfect Number or not. Another point to be observed is that while considering 1 as such a factor, num*n**u**m* will also be considered as the other factor. Thus, we need to subtract num from the sum.

```java

    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;
    }
}
```

- Time complexity : $O(\sqrt{n})$
- Space complexity : O(1). Constant extra space is used.

