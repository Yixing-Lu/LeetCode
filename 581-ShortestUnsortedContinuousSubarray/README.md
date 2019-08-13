Given an integer array, you need to find one **continuous subarray** that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the **shortest** such subarray and output its length.

---

> Input: [2, 6, 4, 8, 10, 9, 15]
> Output: 5
> Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

---

**Approach 1 Brute Force**

we compare nums[i] with every nums[j], such that i < j < n.

If any nums[j] happens to be lesser than nums[i], it means both nums[i] and nums[j] aren't at their correct position for the sorted array. Thus, we need to swap the two elements to bring them at their correct positions. Here, instead of swapping, we just note the position of nums[i] and nums[j]. These two elements now mark the boundary of the unsorted subarray(atleast for the time being).

Thus, out of all the nums[i] chosen, we determine the leftmost nums[i] which isn't at its correct position. This marks the left boundary of the smallest unsorted subarray(l). Similarly, out of all the nums[j] 's considered for all nums[i]'s we determine the rightmost nums[j] which isn't at its correct position. This marks the right boundary of the smallest unsorted subarray(r).

```java
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
```

- Time complexity : O*(*n*2). Two nested loops are there.
- Space complexity : *O*(1). Constant space is used. 

---

**Approach 3 Sort**

```java
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
```

- Time complexity : *O*(*n*log*n*). Sorting takes  *n*log*n* time.
- Space complexity : *O*(*n*). We are making copy of original array. 