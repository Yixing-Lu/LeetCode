For a non-negative integer `X`, the *array-form of X* is an array of its digits in left to right order.  For example, if `X = 1231`, then the array form is `[1,2,3,1]`.

Given the array-form `A` of a non-negative integer `X`, return the array-form of the integer `X+K`.

---

> Input: A = [2,7,4], K = 181
> Output: [4,5,5]
> Explanation: 274 + 181 = 455

---

Take `K` as a carry.
Add it to the lowest digit,
Update carry `K`,
and Keep going to higher digit.

```JAVA
public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
  			// deal with the rest part of K 
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }

```

Insert will take `O(1)` time or `O(N)` time on shifting, depending on the data stucture.
But in this problem `K` is at most 5 digit so this is restricted.
So this part doesn't matter.



The overall time complexity is `O(N)`.