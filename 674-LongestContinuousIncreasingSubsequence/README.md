Given an unsorted array of integers, find the length of longest `continuous` increasing subsequence (subarray).

---

> Input: [1,3,5,4,7]
> Output: 3
> Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 

---

Every (continuous) increasing subsequence is disjoint, and the boundary of each such subsequence occurs whenever `nums[i-1] >= nums[i]`. When it does, it marks the start of a new increasing subsequence at `nums[i]`, and we store such `i` in the variable `anchor`.

```java
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) 
              anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}
```

- Time Complexity: *O*(*N*), where *N* is the length of `nums`. We perform one loop through `nums`.
- Space Complexity: *O*(1), the space used by `anchor` and `ans`.