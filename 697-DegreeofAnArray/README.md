Given a non-empty array of non-negative integers `nums`, the **degree** of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.

---

> Input: [1,2,2,3,1,4,2]
> Output: 6

---

For each element in the given array, let's know `left`, the index of its first occurrence; and `right`, the index of its last occurrence.

Then, for each element `x` that occurs the maximum number of times, `right[x] - left[x] + 1` will be our candidate answer, and we'll take the minimum of those candidates.

```java
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) 
              left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet())
            if (count.get(x) == degree)
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
        return ans;
        
    }
}
```

- Time Complexity: *O*(*N*), where N*N* is the length of `nums`. Every loop is through *O*(*N*) items with *O*(1) work inside the for-block.
- Space Complexity: *O*(*N*), the space used by `left`, `right`, and `count`.

