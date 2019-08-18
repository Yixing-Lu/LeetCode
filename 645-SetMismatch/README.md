The set `S` originally contains numbers from 1 to `n`. But unfortunately, due to the data error, one of the numbers in the set got duplicated to **another** number in the set, which results in repetition of one number and loss of another number.

Given an array `nums` representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

---

> Input: nums = [1,2,2,4]
> Output: [2,3]

---

**Approach 1 XOR**

By taking the XOR of all the elements of the given nums array with all the numbers from 1 to n, we will get a result, xor, as x^y. Here, x and y refer to the repeated and the missing term in the given nums array. 

In the resultant xor, we'll get a 1 in the binary representation only at those bit positions which have a different representaion of x and y. 

Now we consider the rightmost bit which is 1 in the xor, although any bit would work. Let's say, this position is called the rightmostbit.

`xor & ~(xor - 1)`

If we divide the elements of the given nums array into two parts such that the first set contains the elements which have a 1 at the rightmostbit position and the second set contains the elements having a 0 at the same position.

We'll get x in one set and y in the other set, and then allocate elements from 1to n and consider depending on a 1 or 0 at the righmostbit position.

In the end, we will do XOR of the first set and the second set respectively and find out x and y.

Consider the example `[1 2 4 4 5 6]`

3: 011, 4: 100

xor = 3 ^ 4 = 111

xor & ~(xor - 1) = 111 & ~ (110) = 111 & 001 = 001

```java
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;
        for (int n: nums)
            xor ^= n;
        for (int i = 1; i <= nums.length; i++)
            xor ^= i;
        int rightmostbit = xor & ~(xor - 1);
        for (int n: nums) {
            if ((n & rightmostbit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightmostbit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
}
```

- Time complexity : O(n). We iterate over n elements five times.
- Space complexity : O(1). Constant extra space is used.

---

**Approach 2 Constant Space**

We know that all the elements in the given nums array are positive, and lie in the range 11 to n*n* only. Thus, we can pick up each element i*i*from nums. For every number i picked up, we can invert the element at the index i. By doing so, if one of the elements *j* occurs twice, when this number is encountered the second time, the element nums[|i|]  will be found to be negative. Thus, while doing the inversions, we can check if a number found is already negative, to find the duplicate number.

After the inversions have been done, if all the elements in nums are present correctly, the resultant nums array will have all the elements as negative now. But, if one of the numbers, *j* is missing, the element at the j**t**h index will be positive. This can be used to determine the missing number.

```java
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }
}
```

- Time complexity : O(n). Two traversals over the nums array of size n are done.
- Space complexity : O(1). Constant extra space is used.  

