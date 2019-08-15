We have an array `A` of integers, and an array `queries` of queries.

For the `i`-th query `val = queries[i][0], index = queries[i][1]`, we add val to `A[index]`.  Then, the answer to the `i`-th query is the sum of the even values of `A`.

Return the answer to all queries.  Your `answer` array should have `answer[i]` as the answer to the `i`-th query.

---

> Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
> Output: [8,6,2,4]
> Explanation: 
> At the beginning, the array is [1,2,3,4].
> After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
> After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
> After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
> After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

---

Let's try to maintain `S`, the sum of the array throughout one query operation.

---

When acting on an array element `A[index]`, the rest of the values of `A` remain the same.

- When we add things from query to A[index], the rest of A is not changed. Thus, we do not need to
  calculate the sum of the whole array A every time after we perform the addition.
  This saves lots of time, since we are not traversing the whole array A for query.length times.
  Instead, we only traverse the array A only once.

Let's remove `A[index]` from `S` if it is even, then add `A[index] + val` back (if it is even.)

- If we don't perform Sum(A) every time after addition, what do we do?
  1. We find the sum of the even numbers in A first. We will perform modifications on this "sum"
     instead of traverse A to find a new sum every time after addition.
  2. Now let's look at the elements at A that is going to change.
     - if A[index] is an even number, we remove it from sum. Why?
       We already added it to our "sum". If after the addition, this number becomes odd, we won't want it anymore.
     - if A[index] is an odd number, we don't touch it. We didn't add it to our "sum".
  3. Then we check the result after the addition.
     - if A[index]+val is even:
       we add the whole "A[index]+val" to our sum, since it's even.
       recall that , we subtracted A[index] in our previous step. we want to add everything back.
     - if A[index]+val is odd:
       we don't do anything.
       since it's odd, we don't want it in our sum.
       we already subtracted A[index] from sum if it was even.
       we didn't add A[index] to our sum if it was odd.
       therefore, we don't need any extra steps here.

---

```java
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }
}
```

- Time Complexity: O(N+Q), where N is the length of `A` and Q is the number of `queries`.
- Space Complexity: O(Q), though we only allocate O(1) additional space. 

