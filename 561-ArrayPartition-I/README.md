Given an array of **2n** integers, your task is to group these integers into **n**pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

---

> Input: [1,4,3,2]
>
> Output: 4
> Explanation: n is 2,  the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

---

As we cannot select the max, because it is the min of a pair, so the largest number we can choose is the second largest, in the condition it's paired with the largest one; recursive continue.

---

```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=nums.length-2;i>=0;i-=2)
            sum+=nums[i];
        return sum;
    }
}
```

