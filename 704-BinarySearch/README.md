Given a **sorted** (in ascending order) integer array `nums` of `n` elements and a `target` value, write a function to search `target` in `nums`. If `target` exists, then return its index, otherwise return `-1`.

---

> Input: nums = [-1,0,3,5,9,12], target = 9
> Output: 4
> Explanation: 9 exists in nums and its index is 4

---

```java
class Solution {
  public int search(int[] nums, int target) {
    int pivot, left = 0, right = nums.length - 1;
    while (left <= right) {
      pivot = (left + right) / 2;
      if (nums[pivot] == target) 
          return pivot;
      else {
        if (target < nums[pivot]) 
            right = pivot - 1;
        else 
            left = pivot + 1;
      }
    }
    return -1;
  }
}
```

Time complexity : O(log*N*).

Space complexity : O(1)

