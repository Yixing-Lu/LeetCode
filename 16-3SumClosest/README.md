Given an array `nums` of *n* integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

----

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

---

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
        if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) < dif) {
                    dif = Math.abs(nums[i] + nums[lo] + nums[hi] - target);
                    res = nums[i] + nums[lo] + nums[hi];
                    if (dif == 0) // to run faster
                        break;
                }
                else if (nums[i] + nums[lo] + nums[hi] < target)
                    lo++;
                else
                    hi--;
            }
        }
        }
    return res;
    }
}
```

time $O(n^3)$

