Given an array containing *n* distinct numbers taken from `0, 1, 2, ..., n`, find the one that is missing from the array.

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

---

```
Input: [3,0,1]
Output: 2
```

```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```

---

**Approach 1 Sort**

If `nums` were in order, it would be easy to see which number is missing.

we ensure that the number we expect to be at each index is indeed there

```java
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }
        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // Array was not missing any numbers
        return -1;
    }
}
```

Time complexity : O(nlgn)

Space complexity : O(1)

---

**Approach 2 HashSet**

The naive implementation might use a linear scan of the array to check for containment, but we can use a `HashSet` to get constant time containment queries and overall linear runtime.

```java
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) 
          numSet.add(num);
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
```

Time complexity : O(*n*)

Space complexity : O(*n*)

---

**Approach 3 Bit Manipulation**

Because we know that `nums` contains n*n* numbers and that it is missing exactly one number on the range [0..n-1][0..*n*−1], we know that n*n* definitely replaces the missing number in `nums`. Therefore, if we initialize an integer to n*n* and XOR it with every index and value, we will be left with the missing number. 

| Index | 0    | 1    | 2    | 3    |
| ----- | ---- | ---- | ---- | ---- |
| Value | 0    | 1    | 3    | 4    |

4 XOR (0 XOR 0) XOR (1 XOR 1) XOR (2 XOR 3) XOR (3 XOR 4)

=(4 XOR 4) XOR (0 XOR 0) XOR (1 XOR 1) XOR (3 XOR 3) XOR 2

= 0 XOR 0 XOR 0 XOR 0 XOR 2

=2

```java
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
```

Time complexity : O(*n*)

Assuming that XOR is a constant-time operation, this algorithm does constant work on n*n* iterations, so the runtime is overall linear.

Space complexity : O(1)

---

**Approach 4 ExpectedSum - ActualSum**

We can compute the sum of `nums` in linear time, and by Gauss' formula, we can compute the sum of the first n natural numbers in constant time. Therefore, the number that is missing is simply the result of Gauss' formula minus the sum of `nums`, as `nums` consists of the first n*n* natural numbers minus some number.

```java
class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
```

Time complexity : O(*n*)

Space complexity : O(1)

