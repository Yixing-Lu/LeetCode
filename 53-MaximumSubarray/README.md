Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

---

> Input: [-2,1,-3,4,-1,2,1,-5,4],
> Output: 6
> Explanation: [4,-1,2,1] has the largest sum = 6.

---

**Approach 1**

if sum < 0， no matter the next one is + or -，both greater than plus this sum

```java
public int maxSubArray(int[] A) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < A.length; i++) {
        if (sum < 0) 
            sum = A[i];
        else 
            sum += A[i];
        if (sum > max)
            max = sum;
    }
    return max;
```

---



