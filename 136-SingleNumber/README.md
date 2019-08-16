Given a **non-empty** array of integers, every element appears *twice* except for one. Find that single one.

---

> Input: [4,1,2,1,2]
> Output: 4

---

- If we take XOR of zero and some bit, it will return that bit
  - *a*⊕0=*a*
- If we take XOR of two same bits, it will return 0
  - *a*⊕*a*=0
- *a*⊕*b*⊕*a*=(*a*⊕*a*)⊕*b*=0⊕*b*=*b*

So we can XOR all bits together to find the unique number.

----

```JAVA
class Solution {
    public int singleNumber(int[] nums) {
    int ans =0;
    
    int len = nums.length;
    for(int i=0;i!=len;i++)
        ans ^= nums[i];
    
    return ans;
		}
}
```

- Time complexity : O(n). We only iterate through nums, so the time complexity is the number of elements innums.
- Space complexity : O(1).