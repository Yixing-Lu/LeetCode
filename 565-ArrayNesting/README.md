A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

---

> Input: A = [5,4,0,3,1,6,2]
> Output: 4
> Explanation: 
> A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
>
> One of the longest S[K]:
> S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

---

**Approach 1 Brute Force**

The simplest method is to iterate over all the indices of the given nums*n**u**m**s* array. For every index i*i* chosen, we find the element nums[i]*n**u**m**s*[*i*] and increment the count*c**o**u**n**t* for a new element added for the current index i*i*. Since nums[i]*n**u**m**s*[*i*] has to act as the new index for finding the next element belonging to the set corresponding to the index i*i*, the new index is j=nums[i]*j*=*n**u**m**s*[*i*].

```java
public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
            }
            while (start != nums[i]);
            res = Math.max(res, count);

        }
        return res;
    }
}
```

- Time complexity : $O(n^2)$. In worst case, for example- `[1,2,3,4,5,0]`, loop body will be executed n^2*n*2 times.
- Space complexity : $O(1)$. Constant space is used.

---

**Approach 2 Visited Array**

In the last approach, we observed that in the worst case, all the elements of the nums*n**u**m**s* array are added to the sets corresponding to all the starting indices. But, all these sets correspond to the same set of elements only, leading to redundant calculations.

We consider a simple example and see how this problem can be resolved. From the figure below, we can see that the elements in the current nesting shown by arrows form a cycle. Thus, the same elements will be added to the current set irrespective of the first element chosen to be added to the set out of these marked elements.

Thus, when we add an element nums[j]*n**u**m**s*[*j*] to a set corresponding to any of the indices, we mark its position as visited in a visited*v**i**s**i**t**e**d* array. This is done so that whenever this index is chosen as the starting index in the future, we do not go for redundant count*c**o**u**n**t* calculations, since we've already considered the elements linked with this index, which will be added to a new(duplicate) set.

```java
public class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
```

- Time complexity : O(n). Every element of the nums array will be considered atmost once.
- Space complexity : O(n). visited*v**i**s**i**t**e**d* array of size n is used.

---

**Approach 3 Without extra space**

In the last approach, the visited*v**i**s**i**t**e**d* array is used just to keep a track of the elements of the array which have already been visited. Instead of making use of a separate array to keep track of the same, we can mark the visited elements in the original array nums*n**u**m**s* itself. Since, the range of the elements can only be between 1 to 20,000, we can put a very large integer value \text{Integer.MAX_VALUE} at the position which has been visited. The rest process of traversals remains the same as in the last approach.

```java

public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
```

- Time complexity : O(n). Every element of the nums array will be considered atmost once.
- Space complexity : O(1). Constant Space is used.