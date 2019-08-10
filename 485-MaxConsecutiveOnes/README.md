Given a binary array, find the maximum number of consecutive 1s in this array.

---

```
Input: [1,1,0,1,1,1]
Output: 3
```

---

count every continue 1 and reset count when encount 0, record the max count.

---

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
        	    count++;
        	    max = Math.max(count, max);
            }
            else 
                count = 0;
        }
        
        return max;
    }
}
```

