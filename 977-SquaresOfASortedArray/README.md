Given an array of integers `A` sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

---

> Input: [-4,-1,0,3,10]
> Output: [0,1,9,16,100]

---

We can use two pointers to read the positive and negative parts of the array - one pointer `j` in the positive direction, and another `i` in the negative direction.

Now that we are reading two increasing arrays (the squares of the elements), we can merge these arrays together using a two-pointer technique.

```JAVA
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.
- Space Complexity: O(N). 

