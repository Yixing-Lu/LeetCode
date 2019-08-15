Given an array `A` of integers, return `true` if and only if we can partition the array into three **non-empty** parts with equal sums.

---

>Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

> Input: [3,3,6,5,-2,2,5,1,-9,4]
> Output: true
> Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

---

```JAVA
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum(), part = 0, cnt = 0;
        if (sum % 3 != 0) 
            return false;
        for (int a : A) {
            part += a;
          	// count how many times get Avg, reset part if get Avg
            if (part == sum /3) {
                cnt++;
                part = 0; 
            }
        }
        if (cnt == 3) 
            return true;  
        else 
            return false;
    }
}
```

Time O(n)

Space O(1)

