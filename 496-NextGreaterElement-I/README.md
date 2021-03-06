You are given two arrays **(without duplicates)** `nums1` and `nums2` where `nums1`’s elements are subset of `nums2`. Find all the next greater numbers for `nums1`'s elements in the corresponding places of `nums2`.

The Next Greater Number of a number **x** in `nums1` is the first greater number to its right in `nums2`. If it does not exist, output -1 for this number.

---

> Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
> Output: [-1,3,-1]
> Explanation:
>     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
>     For number 1 in the first array, the next greater number for it in the second array is 3.
>     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

----

We use a stack to keep a **decreasing** sub-sequence, whenever we see a number `x` greater than `stack.peek()` we pop all elements less than `x` and for all the popped ones, their next greater element is `x`
For example `[9, 8, 7, 3, 2, 1, 6]`
The stack will first contain `[9, 8, 7, 3, 2, 1]` and then we see `6` which is greater than `1` so we pop `1 2 3` whose next greater element should be `6`

```java
public int[] nextGreaterElement(int[] findNums, int[] nums) {
        // map from x to next greater element of x
  			Map<Integer, Integer> map = new HashMap<>(); 
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
```

