Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

1. You must do this **in-place** without making a copy of the array.
2. Minimize the total number of operations.

---

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

---

**Approach 1** (C++)

count zero, then copy non-zero elements, then add zeros.

```c++
void moveZeroes(vector<int>& nums) {
    int n = nums.size();

    // Count the zeroes
    int numZeroes = 0;
    for (int i = 0; i < n; i++) {
        numZeroes += (nums[i] == 0);
    }

    // Make all the non-zero elements retain their original order.
    vector<int> ans;
    for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
            ans.push_back(nums[i]);
        }
    }

    // Move all zeroes to the end
    while (numZeroes--) {
        ans.push_back(0);
    }

    // Combine the result
    for (int i = 0; i < n; i++) {
        nums[i] = ans[i];
    }
}
```

Time Complexity: O(n). 

Space Complexity : O(n).

---

**Approach 2**

Code will maintain the following invariant:

1. All elements before the slow pointer (lastNonZeroFoundAt) are non-zeroes.

2. All elements between the current and slow pointer are zeroes.



Therefore, when we encounter a non-zero element, we need to swap elements pointed by current and slow pointer, then advance both pointers.

If it's zero element, we just advance current pointer.

```java
class Solution {
    public void moveZeroes(int[] nums) {
        for (int lastNoneZeroFoundAt = 0, cur = 0; cur < nums.length; cur ++) {
            if (nums[cur] != 0) {
              	// swap
                int temp = nums[cur];
                nums[cur] = nums[lastNoneZeroFoundAt];
                nums[lastNoneZeroFoundAt] = temp;
              	// advance pointer
                lastNoneZeroFoundAt ++;
            }
        }
    }
}
```

Time Complexity: O(n)

Space Complexity : O(1)

