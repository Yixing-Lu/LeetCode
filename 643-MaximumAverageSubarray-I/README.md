Given an array consisting of `n` integers, find the contiguous subarray of given length `k` that has the maximum average value. And you need to output the maximum average value.

---

> Input: [1,12,-5,-6,50,3], k = 4
> Output: 12.75
> Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

---

**Approach 1 Cumulative Sum**

Here, sum[i] is used to store the sum of the elements of the given nums array from the first element upto the element at the i^{th} index.

in order to find the sum of elements from the index i to i+k, all we need to do is to use: sum[i] - sum[i-k]. Thus, now, by doing one more iteration over the sum array, we can determine the maximum average possible from the subarrays of length k.

```java
public class Solution {
	public double findMaxAverage(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			sum[i] = sum[i - 1] + nums[i];
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) 
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		
		return res;
	}
}
```

- Time complexity : *O*(*n*). We iterate over the nums array of length n once to fill the sum array. Then, we iterate over n-k elements of sum to determine the required result.
- Space complexity : *O*(*n*). We make use of a sum array of length n to store the cumulative sum.

---

**Approach 2 Sliding Window**

to determine the sum of elements from the index i+1 to the index i+k+1, all we need to do is to subtract the element nums[i] from xand to add the element nums[i+k+1] to x. We can carry out our process based on this idea and determine the maximum possible average.

```java
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
                res=Math.max(res,sum);
        }
        return res/k;
    }
}
```

- Time complexity : O*(*n). We iterate over the given nums array of length n once only.
- Space complexity : *O*(1). Constant extra space is used.

