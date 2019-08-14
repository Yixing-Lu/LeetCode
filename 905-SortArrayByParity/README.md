Given an array `A` of non-negative integers, return an array consisting of all the even elements of `A`, followed by all the odd elements of `A`.

---

> Input: [3,1,2,4]
> Output: [2,4,3,1]
> The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

---

**Approach 1 Two Pass**

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.
- Space Complexity: O(N) for the sort, depending on the built-in implementation of `sort`. 

---

**Approach 2 In-Place QuickSort**

We'll maintain two pointers `i` and `j`. The loop invariant is everything below `i` has parity `0` (ie. `A[k] % 2 == 0` when `k < i`), and everything above `j` has parity `1`.

Then, there are 4 cases for `(A[i] % 2, A[j] % 2)`:

- If it is `(0, 1)`, then everything is correct: `i++` and `j--`.
- If it is `(1, 0)`, we swap them so they are correct, then continue.
- If it is `(0, 0)`, only the `i` place is correct, so we `i++` and continue.
- If it is `(1, 1)`, only the `j` place is correct, so we `j--` and continue.

Throughout all 4 cases, the loop invariant is maintained, and `j-i` is getting smaller. So eventually we will be done with the array sorted as desired.

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            else if (A[i] % 2 == 0) i++;
            else if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`. Each step of the while loop makes `j-i` decrease by at least one. (Note that while quicksort is O*(*N*log*N*) normally, this is O(N)* because we only need one pass to sort the elements.)

- Space Complexity: O(1) in additional space complexity. 

  