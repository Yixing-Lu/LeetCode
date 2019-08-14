Given an array `A` of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever `A[i]` is odd, `i` is odd; and whenever `A[i]` is even, `i` is even.

You may return any answer array that satisfies this condition.

---

> Input: [4,2,5,7]
> Output: [4,5,2,7]

---

**Approach 1 Two Pass**

Read all the even integers and put them into places `ans[0]`, `ans[2]`, `ans[4]`, and so on.

Then, read all the odd integers and put them into places `ans[1]`, `ans[3]`, `ans[5]`, etc.

```java
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int[] ans = new int[N];

        int t = 0;
        for (int x: A) 
          if (x % 2 == 0) {
            ans[t] = x;
            t += 2;
        	}

        t = 1;
        for (int x: A) 
          if (x % 2 == 1) {
            ans[t] = x;
            t += 2;
       		}

        return ans;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.
- Space Complexity: O(N). 

---

**Approach 2 Read/Wirte Head**

we separate it into two slices `even = A[0], A[2], A[4], ...` and `odd = A[1], A[3], A[5], ...`. Our invariant will be that everything less than `i` in the even slice is correct, and everything less than `j` in the odd slice is correct.

For each even `i`, let's make `A[i]` even. To do it, we will draft an element from the odd slice. We pass `j` through the odd slice until we find an even element, then swap. Our invariant is maintained, so the algorithm is correct.

```java
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.
- Space Complexity: O(1). 

