Given an integer array *nums*, find the sum of the elements between indices *i* and *j* (*i*≤ *j*), inclusive.

---

> Given nums = [-2, 0, 3, -5, 2, -1]
>
> sumRange(0, 2) -> 1
> sumRange(2, 5) -> -1
> sumRange(0, 5) -> -3

---

**Approach Cache**

Imagine that we pre-compute the cummulative sum from index 0 to k. Could we use this information to derive Sum(i, j)?

Let us define sum[k] as the cumulative sum for $nums[0 \cdots k-1]$ (inclusive):

Now, we can calculate *sumRange* as following:

sumRange(i, j) = sum[j + 1] - sum[i]

```java
private int[] sum;

public NumArray(int[] nums) {
    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++)
        sum[i + 1] = sum[i] + nums[i];
}

public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
}
```

Time complexity : O(1) time per query, O(n) time pre-computation. 

Space complexity : O(n)