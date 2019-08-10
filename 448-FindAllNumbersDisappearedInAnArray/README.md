Given an array of integers where 1 ≤ a[i] ≤ *n* (*n* = size of array), some elements appear twice and others appear once.

Find all the elements of [1, *n*] inclusive that do not appear in this array.

Could you do it without extra space and in O(*n*) runtime? 

---

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

---

**base idea**

iterate through the input array and mark elements as negative using

```java
nums[nums[i] -1] = -nums[nums[i]-1]
```

In this way all the elements whose index that we have seen will be marked as negative. 

the reason we use *nums[i] -1* is to transform [1,n] to [0,n-1] which is same as the range of index.

In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, 

for example: [4.3.2.7.8.2.3.1] —> [-4.-3.-2.-7.**8**.**2**.-3.-1], where **8** and **2** are positive because their indexes **4** and **5** we haven't seen.

so just add **index + 1**  to the return list.

---

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1; % abs avoid when 2nd iterate
            if(nums[val] > 0) { % avoid when 2nd iterate
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
```

